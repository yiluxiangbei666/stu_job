package autorecommendorstudynamic.service;

import autorecommendorstudynamic.bean.comment;

import java.util.List;

public interface commentservice {
    public void addcomment(comment c);
    public List<comment> getcommentListByDynamicId(String comment_usered_id);
}
