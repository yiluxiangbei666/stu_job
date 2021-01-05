package test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.bean.apply_record;
import test.bean.test;
import test.dao.apply_recorddao;
import test.service.apply_recordservice;

@Service
public class apply_recordserviceimpl implements apply_recordservice {
    @Autowired
    apply_recorddao adao;

    @Override
    public apply_record selectapply_record(apply_record a) {
       return adao.selectapply_record(a);
    }

    @Override
    public void insertapply_record(apply_record a) {
        adao.insertapply_record(a);
    }
}
