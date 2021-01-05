package autorecommendorstudynamic.dao;

import autorecommendorstudynamic.bean.dynamic_love;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface dynamic_lovedao {
    public void dianzhan(dynamic_love d);
    public void conceldianzhan(dynamic_love d);
    public List<String> getDynamic_loveList(String dynamic_love_user_id);
}
