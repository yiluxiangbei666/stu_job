package test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.bean.book;
import test.dao.bookdao;
import test.service.bookserver;

import java.util.List;

@Service
public class bookserverimpl implements bookserver {
    @Autowired
    bookdao bdao;

    @Override
    public void reduceonebookbybookid(String bookid) {
        bdao.reduceonebookbybookid(bookid);
    }

    @Override
    public int insertbook_to_loverecord(book b) {
       return bdao.insertbook_to_loverecord(b);
    }

    @Override
    public List<book> getbooks() {
        return bdao.getBooks();
    }

    @Override
    public int addBuybookrecord(book b) {
        return bdao.addBuybookrecord(b);
    }

    @Override
    public book getaddloverecord(book b) {
        return bdao.getaddloverecord(b);
    }

    @Override
    public List<book> getBooksBymyPhone(String phone) {
        return bdao.getBooksBymyPhone(phone);
    }

    @Override
    public book getBooknumberById(String bookid) {
        return bdao.getBooknumberById(bookid);
    }

    @Override
    public List<book> getbuybooksbyPhone(String phone) {
        return bdao.getbuybooksbyPhone(phone);
    }

    @Override
    public List<book> getsalebooksbyPhone(String phone) {
        return bdao.getsalebooksbyPhone(phone);
    }
}
