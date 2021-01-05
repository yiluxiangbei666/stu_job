package searchorchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pageController {
    @RequestMapping(value = "chat")
    public String chat(){
        return "chat";
    }
    @RequestMapping(value = "charttest")
    public String charttest(){
        return "charttest";
    }
}
