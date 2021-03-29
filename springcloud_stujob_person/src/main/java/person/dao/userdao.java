package person.dao;

import org.apache.ibatis.annotations.Mapper;
import person.bean.user;
import person.bean.user_moreinfo;

import java.lang.String;
import java.util.List;

@Mapper
public interface userdao {
    user getUserByPhone(String phone);
    List<user> getUserByPhoneAndName(String content);
    void savaUser(user u);
    user_moreinfo getUserInfoByPhone(String phone);
    void setUserHeadImg(user_moreinfo u);
    void update_resume_url(user u);
    void update_user(user u);
    void update_user_info(user_moreinfo user_more);
    void insertuser_info(user_moreinfo user_info);
    List<user> getUserList();
    void update_usermoneybyphone(user u);
}
