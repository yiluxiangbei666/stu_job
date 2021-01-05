package person.service;

import person.bean.chat;

import java.util.List;

public interface chatservice {
    public void addChat(chat c);
    public List<chat> getchatListBysenduserandtouser(chat c);
}
