package autorecommendorstudynamic.service.impl;

import autorecommendorstudynamic.bean.dynamic;
import autorecommendorstudynamic.dao.dynamicdao;
import autorecommendorstudynamic.service.dynamicservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class dynamicserviceimpl implements dynamicservice {
    @Autowired
    autorecommendorstudynamic.dao.dynamicdao dynamicdao;
    @Override
    public void adddynamic(dynamic d) {
        dynamicdao.adddynamic(d);
    }

    @Override
    public List<dynamic> getAllDynamic() {
        return dynamicdao.getAllDynamic();
    }
    @Override
    public List<dynamic> getDynamicByContent(String content) {
        return dynamicdao.getDynamicByContent(content);
    }

}
