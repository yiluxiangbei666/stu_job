package autorecommendorstudynamic.bean;

import java.io.Serializable;

public class dynamic_love implements Serializable {
    private String dynamic_love_id;
    private String dynamic_id;
    private String dynamic_love_user_id;
    private String dynamic_love_if;

    public dynamic_love() {
    }

    public dynamic_love(String dynamic_love_id, String dynamic_id, String dynamic_love_user_id, String dynamic_love_if) {
        this.dynamic_love_id = dynamic_love_id;
        this.dynamic_id = dynamic_id;
        this.dynamic_love_user_id = dynamic_love_user_id;
        this.dynamic_love_if = dynamic_love_if;
    }

    public String getDynamic_love_id() {
        return dynamic_love_id;
    }

    public void setDynamic_love_id(String dynamic_love_id) {
        this.dynamic_love_id = dynamic_love_id;
    }

    public String getDynamic_id() {
        return dynamic_id;
    }

    public void setDynamic_id(String dynamic_id) {
        this.dynamic_id = dynamic_id;
    }

    public String getDynamic_love_user_id() {
        return dynamic_love_user_id;
    }

    public void setDynamic_love_user_id(String dynamic_love_user_id) {
        this.dynamic_love_user_id = dynamic_love_user_id;
    }

    public String getDynamic_love_if() {
        return dynamic_love_if;
    }

    public void setDynamic_love_if(String dynamic_love_if) {
        this.dynamic_love_if = dynamic_love_if;
    }

    @Override
    public String toString() {
        return "dynamic_love{" +
                "dynamic_love_id='" + dynamic_love_id + '\'' +
                ", dynamic_id='" + dynamic_id + '\'' +
                ", dynamic_love_user_id='" + dynamic_love_user_id + '\'' +
                ", dynamic_love_if='" + dynamic_love_if + '\'' +
                '}';
    }
}
