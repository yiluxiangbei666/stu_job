package searchorchat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import searchorchat.bean.chat;
import searchorchat.bean.user;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "STUJOB-PERSON")
@EnableAutoConfiguration
public interface stujob_person {
    @GetMapping(value = "/user/getUserByPhone")
    public user getUser(@RequestParam("phone")String phone);
    @GetMapping(value = "/user/getchatList")
    public List<chat> getchatList(@RequestParam("chat_user_id")String chat_user_id, @RequestParam("chat_usered_id") String chat_usered_id);
    @PostMapping(value = "/user/upfile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upfile(@RequestPart("file") MultipartFile file);
}
