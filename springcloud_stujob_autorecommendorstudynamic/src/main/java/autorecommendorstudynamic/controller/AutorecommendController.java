package autorecommendorstudynamic.controller;

import autorecommendorstudynamic.bean.*;
import autorecommendorstudynamic.service.*;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping(value = "recommend")
public class AutorecommendController {
    @Autowired
    private stujob_person stujob_person;
    @Autowired
    private autorecommendorstudynamic.service.dynamicservice dynamicservice;
    @Autowired
    userservice userservice;
    @Autowired
    commentservice commentservice;
    @Autowired
    autorecommendorstudynamic.service.dynamic_loveservice dynamic_loveservice;

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
    @RequestMapping(value = "getUserInfo")
    @ResponseBody
    public List<Object> getUserInfo(String phone){
        List<Object> userInfo = stujob_person.getUserInfo(phone);
        return userInfo;
    }
    @RequestMapping(value = "getposition")
    @ResponseBody
    public List<Map<String, Object>> getposition(String keyword,
                                    int pageNo,
                                    int pageSize){
        List<Map<String, Object>> getposition = stujob_person.getposition(keyword, pageNo, pageSize);
        return getposition;
    }
    @RequestMapping(value = "getUserList")
    @ResponseBody
    public List<user> getUserList(){
        List<user> userList = stujob_person.getUserList();
        return userList;
    }
    @RequestMapping(value = "addDynamic",method = RequestMethod.POST)
    @ResponseBody
    public String addDynamic(String dynamic_user_id,String dynamic_content,String dynamic_send_time){
        System.out.println(dynamic_user_id+" "+dynamic_content+" "+dynamic_send_time);
        dynamic d=new dynamic();
        d.setDynamic_id(UUID.randomUUID().toString().replace("-",""));
        d.setDynamic_user_id(dynamic_user_id);
        d.setDynamic_content(dynamic_content);
        d.setDynamic_send_time(dynamic_send_time);
        dynamicservice.adddynamic(d);
        return "success";
    }
    @RequestMapping(value = "addComment")
    @ResponseBody
    public String addComment(comment c){
        c.setComment_id(UUID.randomUUID().toString().replace("-",""));
        commentservice.addcomment(c);
        return "success";
    }
    @RequestMapping(value = "getAllDynamic")
    @ResponseBody
    public List<dynamic> getAllDynamic(){
        List<dynamic> allDynamic = dynamicservice.getAllDynamic();
        Collections.sort(allDynamic, new Comparator<dynamic>() {
            @Override
            public int compare(dynamic o1, dynamic o2) {
                int i = o1.compareTo(o2);
                return i;
            }
        });
        return allDynamic;
    }
    @RequestMapping(value = "getDynamicComment")
    @ResponseBody
    public List<comment> getDynamicComment(String comment_usered_id){
        List<comment> comments = commentservice.getcommentListByDynamicId(comment_usered_id);
        return comments;
    }
    @RequestMapping(value = "dianzhan")
    @ResponseBody
    public String dianzhan(String dynamic_id,String dynamic_love_user_id){
        dynamic_love dynamicLove=new dynamic_love();
        dynamicLove.setDynamic_love_id(UUID.randomUUID().toString().replace("-",""));
        dynamicLove.setDynamic_id(dynamic_id);
        dynamicLove.setDynamic_love_user_id(dynamic_love_user_id);
        dynamicLove.setDynamic_love_if("是");
        System.out.println(dynamicLove);
        dynamic_loveservice.dianzhan(dynamicLove);
        return "success";
    }
    @RequestMapping(value = "conceldianzhan")
    @ResponseBody
    public String conceldianzhan(String dynamic_id,String dynamic_love_user_id){
        dynamic_love dynamicLove=new dynamic_love();
        dynamicLove.setDynamic_id(dynamic_id);
        dynamicLove.setDynamic_love_user_id(dynamic_love_user_id);
        System.out.println(dynamicLove);
        dynamic_loveservice.conceldianzhan(dynamicLove);
        return "success";
    }
    @RequestMapping(value = "getDynamic_loveList")
    @ResponseBody
    public List<String> getDynamic_loveList(String dynamic_love_user_id){
        List<String> dynamic_loveList = dynamic_loveservice.getDynamic_loveList(dynamic_love_user_id);
        System.out.println(dynamic_loveList);
        return dynamic_loveList;
    }
    @RequestMapping(value = "getUser_infomation")
    @ResponseBody
    public user_moreinfo getUser_infomation(String phone){
        user_moreinfo u = stujob_person.getUserInfoByPhone(phone);
        if(u==null){
            u=new user_moreinfo();
            u.setUser_phone(phone);
            System.out.println(u);
        }
        return u;
    }
    @RequestMapping(value = "getpositioninfo")
    @ResponseBody
    public List<position> getpositioninfo(String position_name, String company_name, String position_send_time){
        HashSet<String> getpositioninfo = stujob_person.getpositioninfo(position_name, company_name, position_send_time);
        List<position> positions=new ArrayList<>();
        for(String s:getpositioninfo){
            position position = JSONObject.parseObject(s, position.class);
            positions.add(position);
        }
        return positions;
    }
}
