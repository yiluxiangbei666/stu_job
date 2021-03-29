package searchorchat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class Mysecurityconfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("http://localhost:8001/login").permitAll()
                .and()
                .formLogin().loginPage("http://localhost:8001/login").defaultSuccessUrl("http://localhost:8001/index")
                .and().logout().logoutUrl("/logout")
                .and().csrf().disable();
    }
}
