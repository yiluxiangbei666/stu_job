package test.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.bean.apply_record;
import test.bean.subject;
import test.bean.subjectanswer;
import test.bean.test;
import test.service.apply_recordservice;
import test.service.impl.xslxserviceimpl;
import test.service.testservice;
import test.service.userservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@Controller
@RequestMapping(value = "test")
public class testController {
    @Autowired
    userservice userservice;
    @Autowired
    xslxserviceimpl xslxserviceimpl;
    @Autowired
    testservice testservice;
    @Autowired
    apply_recordservice apply_recordservice;
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
    @RequestMapping(value = "addsubjectList")
    @ResponseBody
    public String addsubjectList(String a,String position,String phone,String company) throws Exception {
        List<subject> subjects = JSON.parseArray(a, subject.class);
        String excelname="D://"+phone+"@"+company+"@"+position+".xlsx";
        String[] headList={"题目","A","B","C","D","答案"};
        String[] fieldList={"题目","A","B","C","D","答案"};
        List<HashMap<String, String>> dataList=new ArrayList<>();
        for(subject s:subjects){
            HashMap<String,String> hashMap=new HashMap<>();
            hashMap.put("题目",s.getSubjectname());
            hashMap.put("A",s.getA());
            hashMap.put("B",s.getB());
            hashMap.put("C",s.getC());
            hashMap.put("D",s.getD());
            hashMap.put("答案",s.getTrueanswer());
            dataList.add(hashMap);
        }
        xslxserviceimpl.createExcel(excelname,headList,fieldList,dataList);
        test t=new test();
        t.setTest_id(UUID.randomUUID().toString().replace("-",""));
        t.setTest_user_id(phone);
        t.setTest_company_name(company);
        t.setPosition(position);
        t.setTest_content_xml_url(excelname);
        Date date = new Date();
        t.setTest_send_time(date.getMonth()+1+"月"+date.getDay()+"日");
        System.out.println(t);
        testservice.inserttest(t);
        return phone+"@"+company+"@"+position;
    }
    @RequestMapping(value = "getsubjectList")
    @ResponseBody
    public List<subject> getsubjectList(String secretkey) throws Exception {
        File f=new File("D://"+secretkey+".xlsx");
        System.out.println("D://"+secretkey+".xlsx");
        List<List<Object>> lists = xslxserviceimpl.readExcel(f);
        List<subject> subjectlist=new ArrayList<>();
        for (List<Object> list:lists){
            subject s = new subject();
            s.setSubjectname((String)list.get(0));
            s.setA((String)list.get(1));
            s.setB((String)list.get(2));
            s.setC((String)list.get(3));
            s.setD((String)list.get(4));
            s.setTrueanswer((String)list.get(5));
            subjectlist.add(s);
        }
        return subjectlist;
    }
    @RequestMapping(value = "submittest")
    @ResponseBody
    public String submittest(String a,String username,String phone,String secretkey) throws Exception {
        List<subjectanswer> subjectanswers = JSON.parseArray(a, subjectanswer.class);
        File f=new File("D://"+secretkey+".xlsx");
        String[] split = secretkey.split("@");
        String company=split[1];
        String postion=split[2];
        List<List<Object>> lists = xslxserviceimpl.readExcel(f);
        List<subject> subjectlist=new ArrayList<>();
        for (List<Object> list:lists){
            subject s = new subject();
            s.setSubjectname((String)list.get(0));
            s.setTrueanswer((String)list.get(5));
            subjectlist.add(s);
        }
        int score=0;
        for(int i=0;i<subjectanswers.size();i++){
            if(subjectanswers.get(i).getYouranswer().equalsIgnoreCase(subjectlist.get(i).getTrueanswer())){
                score++;
            }
        }
        apply_record apply = new apply_record();
        apply.setApply_record_id(UUID.randomUUID().toString().replace("-",""));
        apply.setApply_record_username(username);
        apply.setApply_record_company(company);
        apply.setApply_record_phone(phone);
        apply.setApply_record_position(postion);
        apply.setApply_record_score(String.valueOf(score));
        Date date = new Date();
        apply.setApply_record_time(date.getMonth()+1+"月"+date.getDate()+"日");
        if(apply_recordservice.selectapply_record(apply)!=null){
            return "您已经参加了一次测试,不可重复做题";
        }
        else {
            apply_recordservice.insertapply_record(apply);
        }
        return String.valueOf(score);
    }
}
