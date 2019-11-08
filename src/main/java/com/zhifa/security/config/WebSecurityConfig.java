package com.zhifa.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //自定义用户信息
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager detailsManager = new InMemoryUserDetailsManager();
        detailsManager.createUser(User.withUsername("zhifa").password("123").authorities("p1").build());
        detailsManager.createUser(User.withUsername("liang").password("456").authorities("p2").build());
        return detailsManager;
    }
    //密码编码器

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/r/r1").hasAnyAuthority("p1")
            .antMatchers("/r/r2").hasAnyAuthority("p2")
            .antMatchers("/r/**").authenticated() //所有r/**都必须经过认证
            .anyRequest().permitAll()//chu除了上面的 都放行
            .and()
            .formLogin().successForwardUrl("/login-success")


        ;

    }
}
