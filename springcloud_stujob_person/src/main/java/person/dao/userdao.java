package person.dao;

import org.apache.ibatis.annotations.Mapper;
import person.bean.user;
import person.bean.user_moreinfo;

import java.lang.String;
import java.util.List;

@Mapper
public interface userdao {
    public user getUserByPhone(String phone);

    void savaUser(user u);
    public user_moreinfo getUserInfoByPhone(String phone);
    public void setUserHeadImg(user_moreinfo u);
    public void update_resume_url(user u);
    public void update_user(user u);
    public void update_user_info(user_moreinfo user_more);
    public void insertuser_info(user_moreinfo user_info);
    public List<user> getUserList();
}
