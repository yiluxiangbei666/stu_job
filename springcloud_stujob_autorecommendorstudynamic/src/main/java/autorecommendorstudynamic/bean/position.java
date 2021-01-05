package autorecommendorstudynamic.bean;

import java.io.Serializable;

public class position implements Serializable {
    private String position_id;
    private String company_name;
    private String position_name;
    private String position_demand;
    private String position_money;
    private String position_send_time;
    private String position_send_userphone;
    private String position_walfare;

    public position() {
    }

    public String getPosition_walfare() {
        return position_walfare;
    }

    public void setPosition_walfare(String position_walfare) {
        this.position_walfare = position_walfare;
    }

    public position(String position_id, String company_name, String position_name, String position_demand, String position_money, String position_send_time, String position_send_userphone, String position_walfare) {
        this.position_id = position_id;
        this.company_name = company_name;
        this.position_name = position_name;
        this.position_demand = position_demand;
        this.position_money = position_money;
        this.position_send_time = position_send_time;
        this.position_send_userphone = position_send_userphone;
        this.position_walfare = position_walfare;
    }
    public String getPosition_id() {
        return position_id;
    }

    public void setPosition_id(String position_id) {
        this.position_id = position_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getPosition_demand() {
        return position_demand;
    }

    public void setPosition_demand(String position_demand) {
        this.position_demand = position_demand;
    }

    public String getPosition_money() {
        return position_money;
    }

    public void setPosition_money(String position_money) {
        this.position_money = position_money;
    }

    public String getPosition_send_time() {
        return position_send_time;
    }

    public void setPosition_send_time(String position_send_time) {
        this.position_send_time = position_send_time;
    }

    public String getPosition_send_userphone() {
        return position_send_userphone;
    }

    public void setPosition_send_userphone(String position_send_userphone) {
        this.position_send_userphone = position_send_userphone;
    }

    @Override
    public String toString() {
        return "position{" +
                "position_id='" + position_id + '\'' +
                ", company_name='" + company_name + '\'' +
                ", position_name='" + position_name + '\'' +
                ", position_demand='" + position_demand + '\'' +
                ", position_money='" + position_money + '\'' +
                ", position_send_time='" + position_send_time + '\'' +
                ", position_send_userphone='" + position_send_userphone + '\'' +
                ", position_walfare='" + position_walfare + '\'' +
                '}';
    }
}
