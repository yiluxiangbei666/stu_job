package test.bean;

public class test {
    private String test_id;
    private String test_user_id;
    private String test_company_name;
    private String position;
    private String test_content_xml_url;
    private String test_send_time;

    public test() {
    }

    public test(String test_id, String test_user_id, String test_company_name, String position, String test_content_xml_url, String test_send_time) {
        this.test_id = test_id;
        this.test_user_id = test_user_id;
        this.test_company_name = test_company_name;
        this.position = position;
        this.test_content_xml_url = test_content_xml_url;
        this.test_send_time = test_send_time;
    }

    public String getTest_id() {
        return test_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public String getTest_user_id() {
        return test_user_id;
    }

    public void setTest_user_id(String test_user_id) {
        this.test_user_id = test_user_id;
    }

    public String getTest_company_name() {
        return test_company_name;
    }

    public void setTest_company_name(String test_company_name) {
        this.test_company_name = test_company_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTest_content_xml_url() {
        return test_content_xml_url;
    }

    public void setTest_content_xml_url(String test_content_xml_url) {
        this.test_content_xml_url = test_content_xml_url;
    }

    public String getTest_send_time() {
        return test_send_time;
    }

    public void setTest_send_time(String test_send_time) {
        this.test_send_time = test_send_time;
    }

    @Override
    public String toString() {
        return "test{" +
                "test_id='" + test_id + '\'' +
                ", test_user_id='" + test_user_id + '\'' +
                ", test_company_name='" + test_company_name + '\'' +
                ", position='" + position + '\'' +
                ", test_content_xml_url='" + test_content_xml_url + '\'' +
                ", test_send_time='" + test_send_time + '\'' +
                '}';
    }
}
