package person.service.impl;

import com.alibaba.fastjson.JSON;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.bean.book;
import person.bean.bookmessage;
import person.bean.user;
import person.dao.userdao;
import person.service.stu_test;

@Service
public class mybuybookmessageserviceimpl {
    @Autowired
    stu_test stuTest;
    @Autowired
    userdao udao;

    @RabbitListener(queues = "buybookorderqueue")
    @RabbitHandler
    public void process(String bookmessage) {
        bookmessage bmessage= JSON.parseObject(bookmessage, bookmessage.class);
        buybookstrategy(bmessage);
    }
    @GlobalTransactional
    public void buybookstrategy(bookmessage bmessage){
        user getbookuser = udao.getUserByPhone(bmessage.getUserphone());
        book book = stuTest.reduceonebooknumber(bmessage.getBookid());
        getbookuser.setMoney(String.valueOf(Double.valueOf(getbookuser.getMoney())-Double.valueOf(book.getBookprice().substring(1))));
        udao.update_usermoneybyphone(getbookuser);
        System.out.println(getbookuser.getMoney());

        user sendbookuser = udao.getUserByPhone(book.getUserphone());
        sendbookuser.setMoney(String.valueOf(Double.valueOf(sendbookuser.getMoney())+Double.valueOf(book.getBookprice().substring(1))));
        System.out.println(sendbookuser.getMoney());

        udao.update_usermoneybyphone(sendbookuser);
        stuTest.reduceonebookbybookid(bmessage.getBookid());
        //设置接收方电话
        book.setBookimg(getbookuser.getPhone());
        System.out.println(book);
        stuTest.addBuybookrecord(book.getBookid(),book.getUserphone(),book.getBookname(),book.getBookprice(),book.getBookimg(),bmessage.getAddress());
    }
}
