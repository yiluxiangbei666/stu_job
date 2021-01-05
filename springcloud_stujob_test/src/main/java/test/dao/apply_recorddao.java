package test.dao;

import org.apache.ibatis.annotations.Mapper;
import test.bean.apply_record;

@Mapper
public interface apply_recorddao {
   public void insertapply_record(apply_record a);
   public apply_record selectapply_record(apply_record a);
}
