package person.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import person.bean.user;
import person.bean.user_moreinfo;

import java.util.List;

public interface userservice {
    user getUserByPhone(String phone);
    List<user> getUserByPhoneAndName(String content);
    void saveUser(user u);
    String getCurrentUser() throws InterruptedException;
    user_moreinfo getUserInfoByPhone(String phone);
    void setUserHeadImg(user_moreinfo u);
    void update_resume_url(user u);
    void update_user(user u);
    void update_user_info(user_moreinfo user_more);
    List<user> getUserList();
    void insertuser_info(user_moreinfo user_info);
}
