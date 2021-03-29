package person.service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import person.bean.book;
import person.bean.chat;

import java.util.List;


@Component
@FeignClient(value = "STUJOB-SEARCHORCHAT")
@EnableAutoConfiguration
public interface stu_searchorchat {
    @RequestMapping(value = "/searchorchat/getchatlistbyuserandcontent")
    List<chat> getchatlistbyuserandcontent(@RequestParam("phone") String phone, @RequestParam("content") String content);
}