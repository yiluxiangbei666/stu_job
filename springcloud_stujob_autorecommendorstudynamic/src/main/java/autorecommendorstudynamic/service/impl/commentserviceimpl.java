package autorecommendorstudynamic.service.impl;

import autorecommendorstudynamic.bean.comment;
import autorecommendorstudynamic.dao.commentdao;
import autorecommendorstudynamic.service.commentservice;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class commentserviceimpl implements commentservice {
    @Autowired
    autorecommendorstudynamic.dao.commentdao commentdao;
    @Override
    public void addcomment(comment c) {
        commentdao.addcomment(c);
    }

    @Override
    public List<comment> getcommentListByDynamicId(String comment_usered_id) {
        return commentdao.getcommentListByDynamicId(comment_usered_id);
    }
}
