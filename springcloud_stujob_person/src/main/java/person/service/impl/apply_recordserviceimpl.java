package person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.bean.apply_record;
import person.dao.apply_recorddao;
import person.service.apply_recordservice;

import java.util.List;

@Service
public class apply_recordserviceimpl implements apply_recordservice {
    @Autowired
    person.dao.apply_recorddao apply_recorddao;
    @Override
    public List<apply_record> getmyapply_record(String phone) {
        return apply_recorddao.getmyapply_record(phone);
    }
}
