package person.dao;

import org.apache.ibatis.annotations.Mapper;
import person.bean.chat;

import java.util.List;

@Mapper
public interface chatdao {
    public void addChat(chat c);
    public List<chat> getchatListBysenduserandtouser(chat c);
}
