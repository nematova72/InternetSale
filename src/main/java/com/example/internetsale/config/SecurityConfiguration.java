package com.example.internetsale.config;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.security.auth.callback.PasswordCallback;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN")
                .and()
                .withUser("user").password(passwordEncoder().encode("user123")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers("/user/register").permitAll()
                .antMatchers("/items/create").hasRole("ADMIN")
                .antMatchers("/items/update/*").hasAnyRole("ADMIN","USER")
                .antMatchers("/items ").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder(){

         return new BCryptPasswordEncoder();
    }
}
