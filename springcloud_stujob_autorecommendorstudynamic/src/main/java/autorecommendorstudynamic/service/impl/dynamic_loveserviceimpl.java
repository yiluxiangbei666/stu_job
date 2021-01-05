package autorecommendorstudynamic.service.impl;

import autorecommendorstudynamic.bean.dynamic_love;
import autorecommendorstudynamic.dao.dynamic_lovedao;
import autorecommendorstudynamic.service.dynamic_loveservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class dynamic_loveserviceimpl implements dynamic_loveservice {
    @Autowired
    dynamic_lovedao dynamic_lovedao;

    @Override
    public List<String> getDynamic_loveList(String dynamic_love_user_id) {
        return dynamic_lovedao.getDynamic_loveList(dynamic_love_user_id);
    }

    @Override
    public void dianzhan(dynamic_love d) {
        dynamic_lovedao.dianzhan(d);
    }
    @Override
    public void conceldianzhan(dynamic_love d) {
        dynamic_lovedao.conceldianzhan(d);
    }
}
