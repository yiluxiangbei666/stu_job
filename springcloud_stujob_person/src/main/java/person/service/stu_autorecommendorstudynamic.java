package person.service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import person.bean.dynamic;

import java.util.List;


@Component
@FeignClient(value = "STUJOB-AUTORECOMMENDORSTUDYYNAMIC")
@EnableAutoConfiguration
public interface stu_autorecommendorstudynamic {
    @RequestMapping(value = "/recommend/getDynamicByContent")
    List<dynamic> getDynamicByContent(@RequestParam("content") String content);
}