package person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import person.bean.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component("MyUserDetailService")
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private  userservice userservice;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        user userByPhone = userservice.getUserByPhone(username);
        System.out.println(userByPhone);
        if(userByPhone!=null){
            String myPassword=passwordEncoder.encode(String.valueOf(userByPhone.getPassword()));
            Collection<GrantedAuthority> authorities = authorities();
            return new User(username,myPassword,authorities);
        }
        else {
            throw new UsernameNotFoundException("该用户不存在！");
        }
    }

    private Collection<GrantedAuthority> authorities(){
        List<GrantedAuthority> authorityList=new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("1"));
        return authorityList;
    }
}
