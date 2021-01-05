package searchorchat.dao;

import org.apache.ibatis.annotations.Mapper;
import searchorchat.bean.chat;

import java.util.HashSet;
import java.util.List;

@Mapper
public interface chatdao {
    public HashSet<String> getchatListbysendUser(String sendUser);
    public HashSet<String> getchatListbysendedUser(String sendedUser);
}
