package person.bean;

public class bookmessage {
    private String userphone;
    private String bookid;
    private String address;

    public bookmessage(String userphone, String bookid, String address) {
        this.userphone = userphone;
        this.bookid = bookid;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public bookmessage() {
    }

    public bookmessage(String userphone, String bookid) {
        this.userphone = userphone;
        this.bookid = bookid;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    @Override
    public String toString() {
        return "bookmessage{" +
                "userphone='" + userphone + '\'' +
                ", bookid='" + bookid + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
