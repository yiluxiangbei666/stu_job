package person.service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import person.bean.book;


@Component
@FeignClient(value = "STUJOB-TEST")
@EnableAutoConfiguration
public interface stu_test {
    @RequestMapping(value = "/book/reduceonebookbybookid")
   public String reduceonebookbybookid(@RequestParam("bookid")String bookid);
    @RequestMapping(value = "/book/reduceonebooknumber")
    public book reduceonebooknumber(@RequestParam("bookid")String bookid);
    @RequestMapping(value = "/book/addBuybookrecord")
    public String addBuybookrecord(@RequestParam("bookid")String bookid,
                                   @RequestParam("userphone")String userphone,
                                   @RequestParam("bookname")String bookname,
                                   @RequestParam("bookprice")String bookprice,
                                   @RequestParam("bookimg")String bookimg,
                                   @RequestParam("address")String address);
}