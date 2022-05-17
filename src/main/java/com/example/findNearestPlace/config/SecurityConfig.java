package com.example.findNearestPlace.config;
import com.example.findNearestPlace.services.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final MyUserDetails myUserDetails;
    @Autowired
    public SecurityConfig(MyUserDetails myUserDetails) {
        this.myUserDetails = myUserDetails;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetails).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/api/v1/auth/**").permitAll().
                anyRequest().authenticated().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/api/v1/logout"))
                .clearAuthentication(true).invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .and().httpBasic();
    }


        }


