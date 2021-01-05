package person.dao;

import org.apache.ibatis.annotations.Mapper;
import person.bean.apply_record;

import java.util.List;

@Mapper
public interface apply_recorddao {
    public List<apply_record> getmyapply_record(String phone);
}
