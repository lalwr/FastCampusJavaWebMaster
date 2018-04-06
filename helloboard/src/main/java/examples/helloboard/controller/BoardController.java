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