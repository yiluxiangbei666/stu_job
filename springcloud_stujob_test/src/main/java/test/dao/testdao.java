package test.dao;

import org.apache.ibatis.annotations.Mapper;
import test.bean.test;

@Mapper
public interface testdao {
    public void inserttest(test t);
}
