package examples.helloboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    /*
    http://localhost:8080/ -----------> was
                           <----------
                             302 location:/boards (redirect)
    http://localhost:8080/boards (자동요청) ---> was
                                       <-----
                                       404 not found
     */
    @GetMapping(value = "/")
    public String index(){
        return "redirect:/boards";
    }
}
