package person.bean;

import java.io.Serializable;

public class user implements Serializable {
    private String user_id;
    private String user_name;
    private String phone;
    private String password;
    private String sex;
    private String school;
    private String major;
    private String resume_url;
    private String money;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public user() {
    }

    public user(String user_id, String user_name, String phone, String password, String sex, String school, String major, String resume_url, String money) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.phone = phone;
        this.password = password;
        this.sex = sex;
        this.school = school;
        this.major = major;
        this.resume_url = resume_url;
        this.money = money;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getResume_url() {
        return resume_url;
    }

    public void setResume_url(String resume_url) {
        this.resume_url = resume_url;
    }

    @Override
    public String toString() {
        return "user{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", school='" + school + '\'' +
                ", major='" + major + '\'' +
                ", resume_url='" + resume_url + '\'' +
                '}';
    }
}
