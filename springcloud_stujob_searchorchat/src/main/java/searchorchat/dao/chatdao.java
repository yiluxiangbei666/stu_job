package searchorchat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import searchorchat.bean.chat;

import java.util.HashSet;
import java.util.List;

@Mapper
public interface chatdao {
    HashSet<String> getchatListbysendUser(String sendUser);
    HashSet<String> getchatListbysendedUser(String sendedUser);
    List<chat> getChatListByUserAndContent(@Param("phone") String phone,@Param("content") String content);
}
