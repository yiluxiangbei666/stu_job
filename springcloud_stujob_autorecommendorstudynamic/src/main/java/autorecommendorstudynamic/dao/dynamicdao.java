package autorecommendorstudynamic.dao;

import autorecommendorstudynamic.bean.dynamic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface dynamicdao {
    public void adddynamic(dynamic d);
    public List<dynamic> getAllDynamic();
}
