package person.bean;

import java.io.Serializable;

public class chat implements Serializable {
    private String chat_user_id;
    private String chat_usered_id;
    private String chat_send_time;
    private String chat_send_content;
    private String chat_send_image_url;

    public chat() {
    }

    public chat(String chat_user_id, String chat_usered_id, String chat_send_time, String chat_send_content, String chat_send_image_url) {
        this.chat_user_id = chat_user_id;
        this.chat_usered_id = chat_usered_id;
        this.chat_send_time = chat_send_time;
        this.chat_send_content = chat_send_content;
        this.chat_send_image_url = chat_send_image_url;
    }

    public String getChat_user_id() {
        return chat_user_id;
    }

    public void setChat_user_id(String chat_user_id) {
        this.chat_user_id = chat_user_id;
    }

    public String getChat_usered_id() {
        return chat_usered_id;
    }

    public void setChat_usered_id(String chat_usered_id) {
        this.chat_usered_id = chat_usered_id;
    }

    public String getChat_send_time() {
        return chat_send_time;
    }

    public void setChat_send_time(String chat_send_time) {
        this.chat_send_time = chat_send_time;
    }

    public String getChat_send_content() {
        return chat_send_content;
    }

    public void setChat_send_content(String chat_send_content) {
        this.chat_send_content = chat_send_content;
    }

    public String getChat_send_image_url() {
        return chat_send_image_url;
    }

    public void setChat_send_image_url(String chat_send_image_url) {
        this.chat_send_image_url = chat_send_image_url;
    }

    @Override
    public String toString() {
        return "chat{" +
                "chat_user_id='" + chat_user_id + '\'' +
                ", chat_usered_id='" + chat_usered_id + '\'' +
                ", chat_send_time='" + chat_send_time + '\'' +
                ", chat_send_content='" + chat_send_content + '\'' +
                ", chat_send_image_url='" + chat_send_image_url + '\'' +
                '}';
    }
}
