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
    @RequestMapping(value = "jobstrategy")
    public String jobstrategy()
    {
        return "jobstrategy";
    }
    @RequestMapping(value = "mybookloverecord")
    public String mybookloverecord(){
        return "mybookloverecord";
    }
    @RequestMapping(value = "mybuybookrecord")
    public String mybuybookrecord(){
        return "mybuybookrecord";
    }
    @RequestMapping(value = "mysalebookrecord")
    public String mysalebookrecord(){
        return "mysalebookrecord";
    }
}
