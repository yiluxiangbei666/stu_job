package test.bean;

import java.io.Serializable;

public class apply_record implements Serializable {
    private String apply_record_id;
    private String apply_record_username;
    private String apply_record_company;
    private String apply_record_position;
    private String apply_record_time;
    private String apply_record_phone;
    private String apply_record_score;

    public apply_record() {
    }

    public apply_record(String apply_record_id, String apply_record_username, String apply_record_company, String apply_record_position, String apply_record_time, String apply_record_phone, String apply_record_score) {
        this.apply_record_id = apply_record_id;
        this.apply_record_username = apply_record_username;
        this.apply_record_company = apply_record_company;
        this.apply_record_position = apply_record_position;
        this.apply_record_time = apply_record_time;
        this.apply_record_phone = apply_record_phone;
        this.apply_record_score = apply_record_score;
    }

    public String getApply_record_id() {
        return apply_record_id;
    }

    public void setApply_record_id(String apply_record_id) {
        this.apply_record_id = apply_record_id;
    }

    public String getApply_record_username() {
        return apply_record_username;
    }

    public void setApply_record_username(String apply_record_username) {
        this.apply_record_username = apply_record_username;
    }

    public String getApply_record_company() {
        return apply_record_company;
    }

    public void setApply_record_company(String apply_record_company) {
        this.apply_record_company = apply_record_company;
    }

    public String getApply_record_position() {
        return apply_record_position;
    }

    public void setApply_record_position(String apply_record_position) {
        this.apply_record_position = apply_record_position;
    }

    public String getApply_record_time() {
        return apply_record_time;
    }

    public void setApply_record_time(String apply_record_time) {
        this.apply_record_time = apply_record_time;
    }

    public String getApply_record_phone() {
        return apply_record_phone;
    }

    public void setApply_record_phone(String apply_record_phone) {
        this.apply_record_phone = apply_record_phone;
    }

    public String getApply_record_score() {
        return apply_record_score;
    }

    public void setApply_record_score(String apply_record_score) {
        this.apply_record_score = apply_record_score;
    }

    @Override
    public String toString() {
        return "apply_record{" +
                "apply_record_id='" + apply_record_id + '\'' +
                ", apply_record_username='" + apply_record_username + '\'' +
                ", apply_record_company='" + apply_record_company + '\'' +
                ", apply_record_position='" + apply_record_position + '\'' +
                ", apply_record_time='" + apply_record_time + '\'' +
                ", apply_record_phone='" + apply_record_phone + '\'' +
                ", apply_record_score='" + apply_record_score + '\'' +
                '}';
    }
}
