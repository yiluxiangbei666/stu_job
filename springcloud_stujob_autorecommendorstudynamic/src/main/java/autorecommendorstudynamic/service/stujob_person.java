package autorecommendorstudynamic.service;

import autorecommendorstudynamic.bean.user;
import autorecommendorstudynamic.bean.user_moreinfo;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "STUJOB-PERSON")
@EnableAutoConfiguration
public interface stujob_person {
    @GetMapping(value = "/user/getUserInfo")
    public List<Object> getUserInfo(@RequestParam("phone")String phone);
    @GetMapping(value = "/user/getposition")
    public List<Map<String, Object>> getposition(@RequestParam("keyword")String keyword,
                                    @RequestParam("pageNo")int pageNo,
                                    @RequestParam("pageSize") int pageSize);
    @GetMapping(value = "/user/getpositioninfo")
    public HashSet<String> getpositioninfo(@RequestParam("position_name") String position_name,
                                           @RequestParam("company_name") String company_name,
                                           @RequestParam("position_send_time") String position_send_time);
    @GetMapping(value = "/user/getUserList")
    public List<user> getUserList();
    @GetMapping(value = "/user/getUserInfoByPhone")
    public user_moreinfo getUserInfoByPhone(@RequestParam("phone") String phone);
    @GetMapping(value = "/user/insertuser_moreinfo")
    public String insertuser_moreinfo(@RequestBody user_moreinfo u);
}
