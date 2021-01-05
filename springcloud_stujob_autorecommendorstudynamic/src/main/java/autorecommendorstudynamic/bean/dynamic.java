package autorecommendorstudynamic.bean;

import java.io.Serializable;

public class dynamic implements Serializable,Comparable<dynamic> {
    private String dynamic_id;
    private String dynamic_user_id;
    private String dynamic_content;
    private String dynamic_image_url;
    private String dynamic_send_time;

    public dynamic(String dynamic_id, String dynamic_user_id, String dynamic_content, String dynamic_image_url, String dynamic_send_time) {
        this.dynamic_id = dynamic_id;
        this.dynamic_user_id = dynamic_user_id;
        this.dynamic_content = dynamic_content;
        this.dynamic_image_url = dynamic_image_url;
        this.dynamic_send_time = dynamic_send_time;
    }

    public dynamic() {
    }

    @Override
    public String toString() {
        return "dynamic{" +
                "dynamic_id='" + dynamic_id + '\'' +
                ", dynamic_user_id='" + dynamic_user_id + '\'' +
                ", dynamic_content='" + dynamic_content + '\'' +
                ", dynamic_image_url='" + dynamic_image_url + '\'' +
                ", dynamic_send_time='" + dynamic_send_time + '\'' +
                '}';
    }

    public String getDynamic_id() {
        return dynamic_id;
    }

    public void setDynamic_id(String dynamic_id) {
        this.dynamic_id = dynamic_id;
    }

    public String getDynamic_user_id() {
        return dynamic_user_id;
    }

    public void setDynamic_user_id(String dynamic_user_id) {
        this.dynamic_user_id = dynamic_user_id;
    }

    public String getDynamic_content() {
        return dynamic_content;
    }

    public void setDynamic_content(String dynamic_content) {
        this.dynamic_content = dynamic_content;
    }

    public String getDynamic_image_url() {
        return dynamic_image_url;
    }

    public void setDynamic_image_url(String dynamic_image_url) {
        this.dynamic_image_url = dynamic_image_url;
    }

    public String getDynamic_send_time() {
        return dynamic_send_time;
    }

    public void setDynamic_send_time(String dynamic_send_time) {
        this.dynamic_send_time = dynamic_send_time;
    }

    @Override
    public int compareTo(dynamic o) {
        int i = this.dynamic_send_time.compareTo(o.dynamic_send_time);
        return i;
    }
}
