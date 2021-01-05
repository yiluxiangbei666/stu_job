package autorecommendorstudynamic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pageController {
    @RequestMapping(value = "recommendpage")
    public String recommend(){
        return "recommend";
    }
    @RequestMapping(value = "dynamicpage")
    public String dynamic(){
        return "dynamic";
    }
}
