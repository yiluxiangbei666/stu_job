package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.bean.book;
import test.dao.bookdao;

import java.util.List;


public interface bookserver {
    public List<book> getbooks();
    public int insertbook_to_loverecord(book b);
    public book getaddloverecord(book b);
    public List<book> getBooksBymyPhone(String phone);
    public book getBooknumberById(String bookid);
    public void reduceonebookbybookid(String bookid);
    public int addBuybookrecord(book b);
    public List<book> getbuybooksbyPhone(String phone);
    public List<book> getsalebooksbyPhone(String phone);
}
