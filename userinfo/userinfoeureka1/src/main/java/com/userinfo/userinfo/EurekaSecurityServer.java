package com.userinfo.userinfo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class EurekaSecurityServer extends WebSecurityConfigurerAdapter {
    @Override
protected void configure (HttpSecurity http) throws Exception {
        //关闭csrf
        http.csrf().disable();
        super.configure(http);
    }
}
