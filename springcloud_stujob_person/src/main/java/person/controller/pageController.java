package person.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.java2d.pipe.ValidatePipe;

@Controller
public class pageController {
    @RequestMapping(value = "login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }
    @RequestMapping(value = "register")
    public String register(){
        return "register";
    }
    @RequestMapping(value = "homepage")
    public String homepage(){
        return "homepage";
    }
    @RequestMapping(value = "getmysubmitrecord")
    public String getmysubmitrecord(){
        return "mysubmitrecord";
    }
    @RequestMapping(value = "positionchart")
    public String positionchart()
    {
        return "positionchart";
    }
}
