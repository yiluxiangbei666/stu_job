package test.service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import test.bean.user;

@Component
@FeignClient(value = "STUJOB-PERSON")
@EnableAutoConfiguration
public interface stujob_person {
    @GetMapping(value = "/user/getUserByPhone")
    public user getUser(@RequestParam("phone")String phone);
}
