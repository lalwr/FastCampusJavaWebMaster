package kr.co.sunnyvale.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InputController {

    @GetMapping(path = "/input")
    public String input(){
        return "inputForm";
    }

    @PostMapping(path = "/input")
    public String input(@RequestParam(name = "value1") String name, @RequestParam(name = "value2") String blod,
                        ModelMap modelMap){

        modelMap.addAttribute("name", name);
        modelMap.addAttribute("blod", blod);

        //blod.equals("A") 를 사용 안하는 이유는 blod가 값이 없으면 null 포인트 Exception이 발생하기 때문이다.

        String msg = "";
        if("A".equals(blod)){
            msg = "A형은 소심합니다.";
        }else if("B".equals(blod)){
            msg = "B형은 다혈질 입니다.";
        }else if("B".equals(blod)){
            msg = "AB형은 천재입니다.";
        }else if("O".equals(blod)){
            msg = "O형은 활발합니다.";
        }else{
            msg = "혈액형은 A, B , AB, O형이 입력이 가능합니다.";
        }
        modelMap.addAttribute("result", msg);

        return "inputResult";
    }

}
