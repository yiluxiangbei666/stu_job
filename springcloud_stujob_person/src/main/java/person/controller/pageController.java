package person.controller;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.TimeUnit;

@Controller
public class pageController {
    @Autowired
    RedisTemplate redisTemplate;
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

    @RequestMapping(value = "searchAllInfo")
    public String searchAllInfo(@RequestParam String keytip)
    {
        redisTemplate.opsForValue().set("searchAllKey",keytip, 30,TimeUnit.SECONDS);
        System.out.println(keytip);
        return "searchAllInfo";
    }
    @RequestMapping(value = "myaddjoblist")
    public String myaddjoblist(){
        return "myaddjoblist";
    }
}
