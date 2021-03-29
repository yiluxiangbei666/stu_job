package person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class redisServiceimpl {
    @Autowired
    RedisTemplate redisTemplate;
    public void savephonecode(String phone,String phonecode){
        redisTemplate.opsForValue().set(phone,phonecode);
        redisTemplate.expire(phone,5, TimeUnit.MINUTES);
    }
    public String getphonecode(String phone){
        return (String)redisTemplate.opsForValue().get(phone);
    }
    public String getkeytip(){
        return  (String)redisTemplate.opsForValue().get("searchAllKey");
    }
}
