package searchorchat.service;

import searchorchat.bean.chat;

import java.util.HashSet;
import java.util.List;

public interface chatservice {
    public HashSet<String> getchatListbysendUser(String sendUser);
    public HashSet<String> getchatListbysendedUser(String sendedUser);
}
