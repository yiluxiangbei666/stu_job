package person.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import person.bean.*;
import person.service.*;
import person.service.impl.PositionElasticsearchImpl;
import person.service.impl.redisServiceimpl;
import person.util.SmsUtils;
import person.util.fileServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping(value = "user")
public class userController {
    @Autowired
    private fileServiceImpl fileServiceImpl;
    @Autowired
    PositionElasticsearchImpl positionElasticsearch;
    @Autowired
    SmsUtils smsUtils;
    @Autowired
    userservice userservice;
    @Autowired
    redisServiceimpl redisServiceimpl;
    @Autowired
    chatservice cservice;
    @Autowired
    apply_recordservice apply_recordservice;
    @Autowired
    person.service.stu_autorecommendorstudynamic stu_autorecommendorstudynamic;
    @Autowired
    stu_searchorchat stu_searchorchat;

    @RequestMapping(value = "getkeytip")
    @ResponseBody
    public String getkeytipp(){
        return redisServiceimpl.getkeytip();
    }
    @RequestMapping(value = "getDynamicByContent")
    @ResponseBody
    public List<dynamic> getDynamicByContent(String content){
        return stu_autorecommendorstudynamic.getDynamicByContent(content);
    }
    @RequestMapping(value = "getchatlistbyuserandcontent")
    @ResponseBody
    public List<chat> getchatlistbyuserandcontent(String phone,String content){
        return stu_searchorchat.getchatlistbyuserandcontent(phone,content);
    }
    @RequestMapping(value = "getPhoneCode")
    @ResponseBody
    public String getPhoneCode(String phone) throws ClientException {
        String phonecode = String.valueOf(smsUtils.setNewcode());
//        SendSmsResponse sendSms = smsUtils.sendSms(phone, code);
//        System.out.println("???????????????????????????----------------");
//        System.out.println("Code=" + sendSms.getCode());
//        System.out.println("Message=" + sendSms.getMessage());
//        System.out.println("RequestId=" + sendSms.getRequestId());
//        System.out.println("BizId=" + sendSms.getBizId());
        redisServiceimpl.savephonecode(phone,phonecode);
        System.out.println(phone+"  "+phonecode);
        return "success";
    }
    @RequestMapping(value = "personregister")
    @ResponseBody
    public String register(user u,String phonecode){
        UUID uuid = UUID.randomUUID();
        user userByPhone = userservice.getUserByPhone(u.getPhone());
        if(userByPhone!=null){
            return "??????????????????";
        }
        else {
            u.setUser_id(uuid.toString().replace("-",""));
            if(phonecode.equals(redisServiceimpl.getphonecode(u.getPhone()))){
                user_moreinfo userMoreinfo=new user_moreinfo();
                userMoreinfo.setUser_phone(u.getPhone());
                System.out.println(userMoreinfo);
                userservice.insertuser_info(userMoreinfo);
                userservice.saveUser(u);
            }
            else {
                return "????????????????????????";
            }
        }
        return "success";
    }
    @RequestMapping(value = "getCurrentUser")
    @ResponseBody
    public String GetCurrentUser(HttpServletRequest request, HttpServletResponse response) throws InterruptedException, IOException {
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
        return "?????????";
    }
    @RequestMapping(value = "getUserByPhone")
    @ResponseBody
    public user getUserByPhone(String phone){
        user u=userservice.getUserByPhone(phone);
        return u;
    }
    @RequestMapping(value = "getUserInfo")
    @ResponseBody
    public List<Object> getUserInfo(String phone)
    {
        user u = userservice.getUserByPhone(phone);
        user_moreinfo uinfo = userservice.getUserInfoByPhone(phone);
        List<Object> lists=new ArrayList<>();
        lists.add(u);
        lists.add(uinfo);
        System.out.println(u+"  "+uinfo);
        return lists;
    }
    @RequestMapping(value = "updateUser_head_img",method=RequestMethod.POST)
    @ResponseBody
    public String updateUser_head_img(@RequestParam("phone")String phone,
                                      @RequestParam("file")MultipartFile file) throws IOException {
        System.out.println("updateheadimg");
        user_moreinfo userInfoByPhone = userservice.getUserInfoByPhone(phone);
        String user_head_img = file.getOriginalFilename();
        user_moreinfo u=new user_moreinfo();
        u.setUser_head_img(user_head_img);
        u.setUser_phone(userInfoByPhone.getUser_phone());
        fileServiceImpl.saveOneFile("",file);
        if(userInfoByPhone!=null){
            userservice.setUserHeadImg(u);
            System.out.println(userInfoByPhone.getUser_phone()+" "+file);
        }
        else {
            userservice.insertuser_info(u);
            userservice.setUserHeadImg(u);
        }
        return "success";
    }
    @RequestMapping(value = "upfile",method = RequestMethod.POST)
    @ResponseBody
    public String upfile(@RequestParam("file")MultipartFile file) throws IOException {
        fileServiceImpl.saveOneFile("",file);
        return "success";
    }
    //update_resume_url
    @RequestMapping(value = "update_resume_url",method=RequestMethod.POST)
    @ResponseBody
    public String update_resume_url(@RequestParam("phone")String phone,
                                      @RequestParam("file")MultipartFile file) throws IOException {
        fileServiceImpl.saveOneFile("",file);
        String resumer_url = file.getOriginalFilename();
        if(phone!=null&&file!=null){
            user u=new user();
            u.setPhone(phone);
            u.setResume_url(resumer_url);
            userservice.update_resume_url(u);
        }
        System.out.println(phone+" "+file);
        return "success";
    }//saveuserandmoreinfo
    @RequestMapping(value = "saveuserandmoreinfo")
    @ResponseBody
    public String saveuserandmoreinfo(user u,user_moreinfo user_more){
        user_more.setUser_phone(u.getPhone());
        System.out.println(u+" "+user_more);
        userservice.update_user(u);
        userservice.update_user_info(user_more);
        return "success";
    }//getposition
    @RequestMapping(value = "getposition")
    @ResponseBody
    public List<Map<String, Object>> getposition(String keyword,int pageNo,int pageSize) throws Exception {
        List<Map<String, Object>> maps = positionElasticsearch.searchPage(keyword, pageNo, pageSize);
        return maps;
    }
    @RequestMapping(value ="getpositioninfo")
    @ResponseBody
    public HashSet<String> getpositioninfo(String position_name,String company_name,String position_send_time) throws Exception {
        HashSet<String> getpositioninfo = positionElasticsearch.getpositioninfo(position_name, company_name, position_send_time);
        return getpositioninfo;
    }
    @RequestMapping(value = "getpositionId")
    @ResponseBody
    public String getpositionId(String position_name,String company_name,String position_send_time) throws Exception {
        String s = positionElasticsearch.getpositionId(position_name, company_name, position_send_time);
        return s;
    }
    @RequestMapping(value = "deletePositionById")
    @ResponseBody
    public String deletePositionById(String Id) throws Exception {
        String s = positionElasticsearch.deletePostionById(Id);
        if(s.equalsIgnoreCase("success")){
            return "????????????";
        }
        else {
            return "????????????";
        }
    }
    @RequestMapping(value = "getPositionByCompanyName")
    @ResponseBody
    public List<position> getPositionByCompanyName(String content) throws Exception {
        System.out.println(content);
        HashSet<String> positionByCompanyName=null;
        if(content!=null){
            positionByCompanyName = positionElasticsearch.getPositionByCompanyName(content);
        }
        List<position> positions=new ArrayList<>();
        for(String s:positionByCompanyName){
            position position = JSONObject.parseObject(s, position.class);
            positions.add(position);
        }
        return positions;
    }
    @RequestMapping(value = "getPositionByPhone")
    @ResponseBody
    public List<position> getPositionByPhone(String phone) throws Exception {
        System.out.println(phone);
        HashSet<String> positionByCompanyName=null;
        if(phone!=null){
            positionByCompanyName = positionElasticsearch.getpositioninfoByPhone(phone);
        }
        List<position> positions=new ArrayList<>();
        for(String s:positionByCompanyName){
            position position = JSONObject.parseObject(s, position.class);
            positions.add(position);
        }
        return positions;
    }
    @RequestMapping(value = "getUserList")
    @ResponseBody
    public List<user> getUserList(){
        List<user> userList = userservice.getUserList();
        return userList;
    }
    @RequestMapping(value = "addPosition")
    @ResponseBody
    public String addPosition(String company_name,String position_demand,
                              String position_money,String position_name,
                              String position_walfare,String position_send_userphone) throws Exception {
        positionElasticsearch.addposition(company_name,position_demand,position_money,position_name
        ,position_walfare,position_send_userphone);
        return "success";
    }
    @RequestMapping(value = "getchatList")
    @ResponseBody
    public List<chat> getchatList(String chat_user_id,String chat_usered_id){
        chat c=new chat();
        c.setChat_user_id(chat_user_id);
        c.setChat_usered_id(chat_usered_id);
        List<chat> chats = cservice.getchatListBysenduserandtouser(c);
        System.out.println(chats);
        return chats;
    }
    @RequestMapping(value = "getUserInfoByPhone")
    @ResponseBody
    public user_moreinfo getUserInfoByPhone(String phone){
        user_moreinfo userInfoByPhone = userservice.getUserInfoByPhone(phone);
        return userInfoByPhone;
    }
    @RequestMapping(value = "insertuser_moreinfo")
    @ResponseBody
    public String insertuser_moreinfo(user_moreinfo u){
        System.out.println(u);
        userservice.insertuser_info(u);
        return "success";
    }
    @RequestMapping(value = "getmysubmitrecord")
    @ResponseBody
    public List<apply_record> getmysubmitrecord(String phone){
        List<apply_record> apply_records = apply_recordservice.getmyapply_record(phone);
        return apply_records;
    }
    @RequestMapping(value = "positionchart")
    @ResponseBody
    public List<subject> positionchart() throws Exception {
        List<subject> lists=new ArrayList<>();
        lists.add(new subject("java,",positionElasticsearch.positionchart("java")+positionElasticsearch.positionchart("??????")));
        lists.add(new subject("??????",positionElasticsearch.positionchart("??????")));
        lists.add(new subject("??????",positionElasticsearch.positionchart("??????")));
        lists.add(new subject("??????",positionElasticsearch.positionchart("??????")));
        lists.add(new subject("????????????",positionElasticsearch.positionchart("????????????")));
        lists.add(new subject("????????????",positionElasticsearch.positionchart("??????")));
        lists.add(new subject("????????????",positionElasticsearch.getallpositioncount()-positionElasticsearch.positionchart("??????")
        -(positionElasticsearch.positionchart("java")+positionElasticsearch.positionchart("??????"))
        -positionElasticsearch.positionchart("??????")-positionElasticsearch.positionchart("??????")
    -positionElasticsearch.positionchart("????????????")-positionElasticsearch.positionchart("??????")));

        return lists;
    }
    @RequestMapping(value = "getUserByPhoneAndName")
    @ResponseBody
    public List<user> getUserByPhoneAndName(String content){
        List<user> userByPhoneAndName=null;
        if(content!=null){
            userByPhoneAndName= userservice.getUserByPhoneAndName(content);
        }
        return userByPhoneAndName;
    }
}
