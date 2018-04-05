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

        if(blod.equals("A")){
            modelMap.addAttribute("result", "A형은 소심합니다.");
        }else if(blod.equals("B")){
            modelMap.addAttribute("result", "B형은 다혈질 입니다.");
        }else if(blod.equals("AB")){
            modelMap.addAttribute("result", "AB형은 천재입니다.");
        }else if(blod.equals("O")){
            modelMap.addAttribute("result", "O형은 활발합니다.");
        }else{
            modelMap.addAttribute("result", "혈액형은 A, B , AB, O형이 입력이 가능합니다.");
        }

        return "inputResult";
    }

}
