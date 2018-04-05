package examples.helloboard.controller;

import examples.helloboard.VO.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller(value = "/boards")
public class BoardController {

    public static List list = new ArrayList();

    @GetMapping
    public String boardList(ModelMap modelMap){

        if(list.size() == 0){
            for(int i =1; i < 3; i++){
                BoardVO boardVO = new BoardVO();
                boardVO.setNo(i);
                boardVO.setSubject("연습게시판" + i);
                list.add(boardVO);
            }
        }
        modelMap.addAttribute("list", list);
        return "list";
    }

    @GetMapping(value = "/write")
    public String boardwriteForm(){
        return "write";
    }

    @PostMapping(value = "/write")
    public String boardwrite(@ModelAttribute BoardVO boardVO){
        BoardVO updateVO = new BoardVO();
        updateVO.setNo(list.size()+1);
        updateVO.setSubject(boardVO.getSubject());
        list.add(updateVO);
        return "redirect:/boards";
    }

    @GetMapping(value = "/detail/{no}")
    public String boardDetail(@PathVariable int no, ModelMap modelMap){
        BoardVO boardVO = (BoardVO) list.get(no-1);
        System.out.println("detail");
        modelMap.addAttribute("boardVO", boardVO);
        return "detail";
    }

    @PostMapping(value = "/update")
    public String boardUpdate(@RequestParam(required = true) int no, @RequestParam(required = true) String name){
        HashMap hashMap = new HashMap();
        hashMap.put("no", no);
        hashMap.put("name", name);
        list.set(no-1, hashMap);

        return "redirect:/boards";
    }





}
