package examples.helloboard.controller;

import examples.helloboard.VO.BoardVO;
import examples.helloboard.common.BoardPagingInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = "/boards")
public class BoardController {

    public static List list = new ArrayList();

    @GetMapping
    public String boardList(@ModelAttribute("board") BoardVO boardVO, ModelMap modelMap) throws Exception{

        if(list.size() == 0){
            for(int i =1; i < 100; i++){
                BoardVO board = new BoardVO();
                board.setNo(i);
                board.setSubject("연습게시판" + i);
                list.add(board);
            }
            Collections.reverse(list);
        }


        boardVO.setTotCount(list.size());

        BoardPagingInfo pagingInfo = new BoardPagingInfo();
        pagingInfo.setPage(boardVO.getPage());
        pagingInfo.setTotCount(boardVO.getTotCount());
        modelMap.addAttribute("pagingInfo", pagingInfo);

        int listSize = list.size();

        int startNo = pagingInfo.getPageVal();
        int endNo = startNo + pagingInfo.getPageSize();
        if(listSize < endNo ) {
            endNo = listSize;
        }
        List ressultList = list.subList(startNo, endNo); //페이지에 보여줄 글 가져오기

        modelMap.addAttribute("list", ressultList);

        //TODO
        // searchType(title, content, titleAndContent), searchStr 이 있을 경우
        // 1. 검색된 결과의 총 수
        // 2. 한페이지에 보여줄 수
        // 1,2를 이용하여 페이징 처리에 해당하는 값을 구할 수 있다. 만약 전체가 97페이지면?
        // <<    <     1     2     3    4   5  >  >>    > 를 누르면 6페이지를 보여준다.
        // <<    <     6     7     8    9   10  >  >>
        // <<    <    96    97                  >  >>
        // 3. page에 해당하는 검색 결과 목록
        // 검색조건 값이 없을 경우 처리는?

        return "list";
    }

    @GetMapping(value = "/write" )
    public String boardwriteForm(@ModelAttribute("board") BoardVO boardVO) throws Exception{
        return "write";
    }

    @PostMapping(value = "/write")
    public String boardwrite(@ModelAttribute("board") BoardVO boardVO) throws Exception{
        BoardVO updateVO = new BoardVO();
        updateVO.setNo(list.size()+1);
        updateVO.setSubject(boardVO.getSubject());
        list.add(0, updateVO);
        return "redirect:/boards";
    }

    @GetMapping(value = "/{no}")
    public String boardDetail(@PathVariable(value ="no") int no, ModelMap modelMap) throws Exception{
        BoardVO boardVO = (BoardVO) list.get(no-1);
        modelMap.addAttribute("boardVO", boardVO);

        // 1. no 해당하는 게시물을 한건 읽어온다.
        // 2. no 이전 글, boardId의 이후 글. (검색어도 신경써라!!!)
        //    이전글 : 100보다 작으면서 가장 큰 boardId
        //    이후글 : 100보다 크면서 가장 작은 boardId

        return "detail";
    }

    @PutMapping
    public String boardUpdate(@RequestParam(name="no", required = true) int no,
                              @RequestParam(name = "subject" ,required = true) String subject) throws Exception{
        BoardVO boardVO = new BoardVO();
        boardVO.setNo(no);
        boardVO.setSubject(subject);
        list.set(no-1, boardVO);

        return "redirect:/boards";
    }

    @DeleteMapping
    public String boardDelete(@RequestParam(name = "no", required = true) int no) throws Exception{
        list.remove(no-1);
        return "redirect:/boards";
    }





}
