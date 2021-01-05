package test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.bean.test;
import test.dao.testdao;
import test.service.testservice;

@Service
public class testserviceimpl implements testservice {

    @Autowired
    testdao testdao;
    @Override
    public void inserttest(test t) {
        testdao.inserttest(t);
    }
}
