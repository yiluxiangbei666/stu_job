package searchorchat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchorchat.bean.chat;
import searchorchat.dao.chatdao;
import searchorchat.service.chatservice;

import java.util.HashSet;
import java.util.List;

@Service
public class Chatserviceimpl implements chatservice {
    @Autowired
    chatdao cdao;
    @Override
    public HashSet<String> getchatListbysendUser(String sendUser) {
        return cdao.getchatListbysendUser(sendUser);
    }
    @Override
    public HashSet<String> getchatListbysendedUser(String sendedUser) {
        return cdao.getchatListbysendedUser(sendedUser);
    }
}
