package test.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import test.bean.book;
import test.bean.bookmessage;
import test.bean.user;
import test.config.ExchangeConfig;
import test.service.bookserver;
import test.service.stujob_person;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping(value = "book")
public class bookController {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    bookserver bserver;
    @Autowired
    stujob_person stujob_person;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @RequestMapping(value = "searchbooks")
    @ResponseBody
    public List<book> getbooks(){
        List<book> getbooks = bserver.getbooks();
        if(getbooks==null){
            return null;
        }
        else {
            return getbooks;
        }
    }
    @RequestMapping(value = "addtoloverecord")
    @ResponseBody
    public String addtoloverecord(@RequestParam("userphone") String userphone,
                                   @RequestParam("bookname") String bookname,
                                   @RequestParam("bookdescribe") String bookdescribe,
                                   @RequestParam("bookprice") String bookprice,
                                   @RequestParam("myphone") String myphone){
        book b=new book();
        b.setUserphone(userphone);
        b.setBookname(bookname);
        b.setBookdescribe(bookdescribe);
        b.setBookprice(bookprice);
        //myphone暂定为img
        b.setBookimg(myphone);
        book getaddloverecord = bserver.getaddloverecord(b);
        if(getaddloverecord!=null){
            return "您已经收藏";
        }
        else {
            b.setBookid(UUID.randomUUID().toString().replace("-",""));
            int count = bserver.insertbook_to_loverecord(b);
            System.out.println("-------------------");
            if(count!=0){
                return "收藏成功";
            }
            else {
                return "收藏失败";
            }
        }
    }
    @RequestMapping(value = "getbooksBymyPhone")
    @ResponseBody
    public List<book> getbooksBymyPhone(String myphone){
        List<book> booksBymyPhone = bserver.getBooksBymyPhone(myphone);
        return booksBymyPhone;
    }
    @RequestMapping(value = "buybook")
    @ResponseBody
    public String buybook(@RequestParam("bookid") String bookid,
                                  @RequestParam("accountnumber") String accountnumber,
                                  @RequestParam("accountpassword") String accountpassword,
                                  @RequestParam("myaddress") String myaddress){
        System.out.println(bookid+" "+accountnumber+" "+accountpassword+" "+myaddress);
        user user = stujob_person.getUser(accountnumber);
        if(user==null){
            return "账号错误";
        }
        else {
            if(user.getPassword().equals(accountpassword)){
                book book = reduceonebooknumber(bookid);
                bookmessage bmessage=new bookmessage(user.getPhone(),book.getBookid(),myaddress);
                System.out.println(book);
                String randId= UUID.randomUUID().toString();
                try{
                    Boolean getbookid = redisTemplate.opsForValue().setIfAbsent(bookid, randId, 10, TimeUnit.SECONDS);
                    if(!getbookid){
                        long oldtime=new Date().getTime();
                        long nowtime=0;
                        while (!redisTemplate.opsForValue().setIfAbsent(bookid, randId, 10, TimeUnit.SECONDS)){
                            nowtime=new Date().getTime();
                            if(nowtime-oldtime>3000){
                                break;
                            }
                            else {
                                try{
                                    Thread.sleep(1000);
                                }catch (Exception e){

                                }
                            }
                        }
                        if(nowtime-oldtime>3000){
                           return "购买超时";
                        }
                        else {
                            user = stujob_person.getUser(accountnumber);
                            if(Integer.valueOf(book.getBooknumber())>0&&Double.valueOf(user.getMoney())>=Double.valueOf(book.getBookprice().substring(1))){

                                rabbitTemplate.convertAndSend(ExchangeConfig.DEFAULT_EXCHANGE, ExchangeConfig.DEFAULT_QUEUE_NAME,
                                        JSON.toJSONString(bmessage));
                                return "购买成功,稍后商家发货";
                            }
                            else {
                                return "书籍库存不足或您余额不足，请您仔细检查！";
                            }
                        }
                    }
                    else {
                        user = stujob_person.getUser(accountnumber);
                        if(Integer.valueOf(book.getBooknumber())>0&&Double.valueOf(user.getMoney())>=Double.valueOf(book.getBookprice().substring(1))){

                            rabbitTemplate.convertAndSend(ExchangeConfig.DEFAULT_EXCHANGE, ExchangeConfig.DEFAULT_QUEUE_NAME,
                                    JSON.toJSONString(bmessage));
                            return "购买成功,稍后商家发货";
                        }
                        else {
                            return "书籍库存不足或您余额不足，请您仔细检查！";
                        }
                    }
                }
                finally {
                    if(randId.equals(redisTemplate.opsForValue().get(bookid))){
                        redisTemplate.delete(bookid);
                    }
                }
            }
            else {
                return "密码错误";
            }
        }
    }
    @RequestMapping(value = "reduceonebooknumber")
    @ResponseBody
    public book reduceonebooknumber(String bookid){
        return bserver.getBooknumberById(bookid);
    }
    @RequestMapping(value = "reduceonebookbybookid")
    @ResponseBody
    public String reduceonebookbybookid(String bookid){
        bserver.reduceonebookbybookid(bookid);
        return "success";
    }
    @RequestMapping(value = "addBuybookrecord")
    @ResponseBody
    public String addBuybookrecord(String bookid,String userphone,String bookname,String bookprice,String bookimg,String address){
        book b=new book(bookid,userphone,bookname,bookprice,bookimg+"::"+address);
        System.out.println(b);
        if(bserver.addBuybookrecord(b)!=0){
            return "success";
        }else
        {
            return "error";
        }
    }
    @RequestMapping(value = "getbuybooksbyPhone")
    @ResponseBody
    public List<book> getbuybooksbyPhone(String phone){
       return bserver.getbuybooksbyPhone(phone);
    }
    @RequestMapping(value = "getsalebooksbyPhone")
    @ResponseBody
    public List<book> getsalebooksbyPhone(String phone){
        return bserver.getsalebooksbyPhone(phone);
    }
}
