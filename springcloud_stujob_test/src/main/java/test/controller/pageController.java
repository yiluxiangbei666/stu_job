package test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pageController {
    @RequestMapping(value = "addtest")
    public String addTestPage()
    {
        return "addtest";
    }
    @RequestMapping(value = "taketest")
    public String taketest()
    {
        return "taketest";
    }
}
