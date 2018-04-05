package kr.co.sunnyvale.mvcexam.controller;

import kr.co.sunnyvale.mvcexam.dto.Blod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlodController {

    @GetMapping(path = "/blod")
    public String input(){
        return "blodForm";
    }

    @PostMapping(path = "/blod")
    public String input(@ModelAttribute Blod blod, ModelMap modelMap){

        String msg = null;
        if("A".equals(blod.getBlod())){
            msg = "A형은 소심합니다.";
        }else if("B".equals(blod.getBlod())){
            msg = "B형은 다혈질 입니다.";
        }else if("B".equals(blod.getBlod())){
            msg = "AB형은 천재입니다.";
        }else if("O".equals(blod.getBlod())){
            msg = "O형은 활발합니다.";
        }else{
            msg = "혈액형은 A, B , AB, O형이 입력이 가능합니다.";
        }
        blod.setMsg(msg);
        modelMap.addAttribute("blod", blod);

        return "blodResult";
    }

}
