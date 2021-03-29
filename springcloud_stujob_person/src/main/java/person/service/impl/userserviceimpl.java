package person.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import person.bean.user;
import person.bean.user_moreinfo;
import person.dao.userdao;
import person.service.userservice;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class userserviceimpl implements userservice {


    @Autowired
    private person.dao.userdao userdao;

    @Override
    public List<user> getUserByPhoneAndName(String content) {
        return userdao.getUserByPhoneAndName(content);
    }

    @Override
    public user getUserByPhone(String phone) {
        return userdao.getUserByPhone(phone);
    }

    @Override
    public void saveUser(user u) {
        userdao.savaUser(u);
    }

    @Override
    public void setUserHeadImg(user_moreinfo u) {
        userdao.setUserHeadImg(u);
    }

    @Override
    public String getCurrentUser() throws InterruptedException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object myUser = (auth != null) ? auth.getName() : null;
        return (String)myUser;
    }
    @Override
    public List<user> getUserList() {
        return userdao.getUserList();
    }

    @Override
    public void insertuser_info(user_moreinfo user_info) {
        userdao.insertuser_info(user_info);
    }

    @Override
    public user_moreinfo getUserInfoByPhone(String phone) {
        return userdao.getUserInfoByPhone(phone);
    }

    @Override
    public void update_user(user u) {
        userdao.update_user(u);
    }

    @Override
    public void update_user_info(user_moreinfo user_more) {
        userdao.update_user_info(user_more);
    }

    @Override
    public void update_resume_url(user u) {
        userdao.update_resume_url(u);
    }


}
