package person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.bean.chat;
import person.dao.chatdao;
import person.service.chatservice;

import java.util.List;

@Service
public class chatserviceimpl implements chatservice {
    @Autowired
    chatdao cdao;

    @Override
    public void addChat(chat c) {
        cdao.addChat(c);
    }

    @Override
    public List<chat> getchatListBysenduserandtouser(chat c){
        return cdao.getchatListBysenduserandtouser(c);
    }
}
