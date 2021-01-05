package autorecommendorstudynamic.dao;

import autorecommendorstudynamic.bean.comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface commentdao {
    public void addcomment(comment c);
    public List<comment> getcommentListByDynamicId(String comment_usered_id);
}
