package person.bean;

import java.io.Serializable;

public class user_moreinfo implements Serializable {
    private String user_phone;
    private String user_advantage;
    private String user_project;
    private String user_atschool_experience;
    private String user_head_img;

    public user_moreinfo() {
    }

    public user_moreinfo(String user_phone, String user_advantage, String user_project, String user_atschool_experience, String user_head_img) {
        this.user_phone = user_phone;
        this.user_advantage = user_advantage;
        this.user_project = user_project;
        this.user_atschool_experience = user_atschool_experience;
        this.user_head_img = user_head_img;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_advantage() {
        return user_advantage;
    }

    public void setUser_advantage(String user_advantage) {
        this.user_advantage = user_advantage;
    }

    public String getUser_project() {
        return user_project;
    }

    public void setUser_project(String user_project) {
        this.user_project = user_project;
    }

    public String getUser_atschool_experience() {
        return user_atschool_experience;
    }

    public void setUser_atschool_experience(String user_atschool_experience) {
        this.user_atschool_experience = user_atschool_experience;
    }

    public String getUser_head_img() {
        return user_head_img;
    }

    public void setUser_head_img(String user_head_img) {
        this.user_head_img = user_head_img;
    }

    @Override
    public String toString() {
        return "user_moreinfo{" +
                "user_phone='" + user_phone + '\'' +
                ", user_advantage='" + user_advantage + '\'' +
                ", user_project='" + user_project + '\'' +
                ", user_atschool_experience='" + user_atschool_experience + '\'' +
                ", user_head_img='" + user_head_img + '\'' +
                '}';
    }
}
