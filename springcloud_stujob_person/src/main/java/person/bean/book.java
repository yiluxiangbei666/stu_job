package person.bean;

public class book {
    private String bookid;
    private String userphone;
    private String bookname;
    private String bookdescribe;
    private String bookprice;
    private String bookimg;
    private String booknumber;

    public book() {
    }

    public book(String bookid, String userphone, String bookname, String bookdescribe, String bookprice, String bookimg, String booknumber) {
        this.bookid = bookid;
        this.userphone = userphone;
        this.bookname = bookname;
        this.bookdescribe = bookdescribe;
        this.bookprice = bookprice;
        this.bookimg = bookimg;
        this.booknumber = booknumber;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookdescribe() {
        return bookdescribe;
    }

    public void setBookdescribe(String bookdescribe) {
        this.bookdescribe = bookdescribe;
    }

    public String getBookprice() {
        return bookprice;
    }

    public void setBookprice(String bookprice) {
        this.bookprice = bookprice;
    }

    public String getBookimg() {
        return bookimg;
    }

    public void setBookimg(String bookimg) {
        this.bookimg = bookimg;
    }

    public String getBooknumber() {
        return booknumber;
    }

    public void setBooknumber(String booknumber) {
        this.booknumber = booknumber;
    }

    @Override
    public String toString() {
        return "book{" +
                "bookid='" + bookid + '\'' +
                ", userphone='" + userphone + '\'' +
                ", bookname='" + bookname + '\'' +
                ", bookdescribe='" + bookdescribe + '\'' +
                ", bookprice='" + bookprice + '\'' +
                ", bookimg='" + bookimg + '\'' +
                ", booknumber='" + booknumber + '\'' +
                '}';
    }
}
