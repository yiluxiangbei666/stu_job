package autorecommendorstudynamic.service;

import autorecommendorstudynamic.bean.dynamic_love;

import java.util.List;

public interface dynamic_loveservice {
    public void dianzhan(dynamic_love d);
    public List<String> getDynamic_loveList(String dynamic_love_user_id);
    void conceldianzhan(dynamic_love dynamicLove);
}
