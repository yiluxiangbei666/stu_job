package person.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import person.bean.user;
import person.bean.user_moreinfo;

import java.util.List;

public interface userservice {
    public user getUserByPhone(String phone);
    public void saveUser(user u);
    public String getCurrentUser() throws InterruptedException;

    public user_moreinfo getUserInfoByPhone(String phone);
    public void setUserHeadImg(user_moreinfo u);
    public void update_resume_url(user u);

    public void update_user(user u);
    public void update_user_info(user_moreinfo user_more);

    public List<user> getUserList();
    public void insertuser_info(user_moreinfo user_info);
}
