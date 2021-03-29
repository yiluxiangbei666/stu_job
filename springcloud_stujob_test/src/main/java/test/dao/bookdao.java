package test.dao;

import org.apache.ibatis.annotations.Mapper;
import test.bean.book;

import java.util.List;

@Mapper
public interface bookdao {
    public List<book> getBooks();
    public int insertbook_to_loverecord(book b);
    public book getaddloverecord(book b);
    public List<book> getBooksBymyPhone(String phone);
    public book getBooknumberById(String bookid);
    public void reduceonebookbybookid(String bookid);
    public int addBuybookrecord(book b);
    public List<book> getbuybooksbyPhone(String phone);
    public List<book> getsalebooksbyPhone(String phone);
}
