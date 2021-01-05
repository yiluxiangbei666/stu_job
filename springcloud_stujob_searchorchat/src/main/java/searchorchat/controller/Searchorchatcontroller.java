package searchorchat.controller;

import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import searchorchat.bean.chat;
import searchorchat.bean.subject;
import searchorchat.bean.user;
import searchorchat.service.chatservice;
import searchorchat.service.stujob_person;
import searchorchat.service.userservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping(value = "searchorchat")
public class Searchorchatcontroller {
    @Autowired
    private stujob_person stujob_person;
    @Autowired
    private searchorchat.service.chatservice chatservice;
    @Autowired
    searchorchat.service.userservice userservice;
    @RequestMapping(value = "getCurrentUser")
    @ResponseBody
    public String GetCurrentUser(HttpServletRequest request){
        String currentUsername = userservice.getCurrentUser();
        HttpSession session = request.getSession();
        String loginphone = (String) session.getAttribute("loginphone");
        if (StringUtils.isEmpty(loginphone)&&currentUsername!=null) {
            loginphone = currentUsername;
            session.setAttribute("loginphone", loginphone);
            return loginphone;
        }
        else if(loginphone!=null){
            return loginphone;
        }
        return "无用户";
    }
    @RequestMapping(value = "getcartList")
    @ResponseBody
    public HashSet<String> getcartList(@RequestParam("sendUser") String sendUser){
        HashSet<String> hs=new HashSet<>();
        HashSet<String> chats1 = chatservice.getchatListbysendUser(sendUser);
        HashSet<String> chats2 = chatservice.getchatListbysendedUser(sendUser);
        for (String string : chats1) {
            hs.add(string);
        }
        for (String string : chats2) {
            hs.add(string);
        }
        return hs;
    }
    @RequestMapping(value = "getUserByPhone")
    @ResponseBody
    public user getUserByPhone(@RequestParam("phone") String phone){
        user user = stujob_person.getUser(phone);
        return user;
    }
    @RequestMapping(value = "getchatList")
    @ResponseBody
    public List<chat> getchatList(String chat_user_id,String chat_usered_id){
        List<chat> chats = stujob_person.getchatList(chat_user_id, chat_usered_id);
        return chats;
    }
    @RequestMapping(value = "upfile",method = RequestMethod.POST)
    @ResponseBody
    public String upfile(@RequestParam("file") MultipartFile file) throws IOException {
        stujob_person.upfile(file);
        return "success";
    }
    @RequestMapping(value = "charttest")
    @ResponseBody
    public List<subject> charttest() throws IOException {
        List<subject> list=new ArrayList<>();
        for(int i=0;i<4;i++){
            list.add(new subject("fgz"+i,i+1));
        }
        return list;
    }
}
