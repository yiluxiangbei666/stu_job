package person.service;

import person.bean.apply_record;

import java.util.List;

public interface apply_recordservice {
    public List<apply_record> getmyapply_record(String phone);
}
