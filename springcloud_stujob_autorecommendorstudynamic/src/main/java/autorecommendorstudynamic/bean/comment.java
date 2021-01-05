package autorecommendorstudynamic.bean;

import java.io.Serializable;

public class comment implements Serializable {
    private String comment_id;
    private String comment_user_id;
    private String comment_usered_id;
    private String comment_time;
    private String comment_content;
    private String comment_image_url;

    public comment(String comment_id, String comment_user_id, String comment_usered_id, String comment_time, String comment_content, String comment_image_url) {
        this.comment_id = comment_id;
        this.comment_user_id = comment_user_id;
        this.comment_usered_id = comment_usered_id;
        this.comment_time = comment_time;
        this.comment_content = comment_content;
        this.comment_image_url = comment_image_url;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_user_id() {
        return comment_user_id;
    }

    public void setComment_user_id(String comment_user_id) {
        this.comment_user_id = comment_user_id;
    }

    public String getComment_usered_id() {
        return comment_usered_id;
    }

    public void setComment_usered_id(String comment_usered_id) {
        this.comment_usered_id = comment_usered_id;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getComment_image_url() {
        return comment_image_url;
    }

    public void setComment_image_url(String comment_image_url) {
        this.comment_image_url = comment_image_url;
    }

    public comment() {
    }

    @Override
    public String toString() {
        return "comment{" +
                "comment_id='" + comment_id + '\'' +
                ", comment_user_id='" + comment_user_id + '\'' +
                ", comment_usered_id='" + comment_usered_id + '\'' +
                ", comment_time='" + comment_time + '\'' +
                ", comment_content='" + comment_content + '\'' +
                ", comment_image_url='" + comment_image_url + '\'' +
                '}';
    }
}
