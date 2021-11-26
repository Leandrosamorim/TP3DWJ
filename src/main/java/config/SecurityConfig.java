/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author 55229
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception{
          http.authorizeRequests()
           .anyRequest().authenticated()
           .and()
           .httpBasic();
        
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
         auth.inMemoryAuthentication()
       .passwordEncoder(new BCryptPasswordEncoder())
           .withUser("technicalsand")
           .password(passwordEncoder().encode("technicalsand"))
           .roles("ADMIN")
       .and()
           .withUser("reader")
           .password(passwordEncoder().encode("reader1"))
           .roles("USER")
       ;
    
    }
    
    @Bean
public PasswordEncoder passwordEncoder() {
   return new BCryptPasswordEncoder();
}
    
}
