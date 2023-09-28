package com.example.internetsale.config;

import com.example.internetsale.security.JwtConfigurer;
import com.example.internetsale.security.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final JwtTokenProvider jwtTokenProvider;

    public SecurityConfiguration(@Lazy UserDetailsService userDetailsService, JwtTokenProvider jwtTokenProvider) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
//        auth
//                .userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
////                .inMemoryAuthentication()
////                .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN")
////                .and()
////                .withUser("user").password(passwordEncoder().encode("user123")).roles("USER");
//    }

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
                .antMatchers("/api/authenticate").permitAll()
                .antMatchers("/jwt/login").permitAll()
                .antMatchers("/items/create").hasRole("ADMIN")
                .antMatchers("/items/update/*").hasAnyRole("ADMIN","USER")
                .antMatchers("/items ").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
//                .httpBasic();
//                .formLogin();
                .apply(new JwtConfigurer(jwtTokenProvider));

    }

//    @Bean
//    PasswordEncoder passwordEncoder(){
//
//         return new BCryptPasswordEncoder();
//    }
}
