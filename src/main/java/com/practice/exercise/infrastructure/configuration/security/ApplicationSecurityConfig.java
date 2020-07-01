package com.practice.exercise.infrastructure.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.practice.exercise.infrastructure.configuration.security.ApplicationUserPermission.*;
import static com.practice.exercise.infrastructure.configuration.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/v1/device/list").permitAll()
//                .antMatchers("/v1/device/**").hasRole(USER.name())
                .antMatchers(HttpMethod.POST,"/v1/device/**").hasAuthority(DEVICE_WRITE.getPermission())
//                .antMatchers(HttpMethod.POST,"/v1/device/**").hasAnyRole(ADMIN.name())
                .antMatchers(HttpMethod.PUT,"/v1/device/**").hasAuthority(DEVICE_WRITE.getPermission())
//                .antMatchers(HttpMethod.PUT,"/v1/device/**").hasAnyRole(ADMIN.name())
                .antMatchers(HttpMethod.DELETE,"/v1/device/**").hasAuthority(DEVICE_WRITE.getPermission())
//                .antMatchers(HttpMethod.DELETE,"/v1/device/**").hasAnyRole(ADMIN.name())
//                .antMatchers(HttpMethod.GET,"/v1/device/**").hasAuthority(DEVICE_READ.getPermission())
                .antMatchers(HttpMethod.GET,"/v1/device/**").hasAnyRole(ADMIN.name(), ADMINTRAINEE.name())
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails joanUser = User.builder()
                .username("Joan")
                .password(passwordEncoder.encode("password"))
//                .roles(ADMIN.name()) //ROLE_ADMIN
                .authorities(ADMIN.getSimpleGrantedAuthorities())
                .build();

        UserDetails angieUser = User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
//                .roles(USER.name()) //ROLE_USER
                .authorities(USER.getSimpleGrantedAuthorities())
                .build();

        UserDetails alexUser = User.builder()
                .username("Alex")
                .password(passwordEncoder.encode("password"))
//                .roles(ADMINTRAINEE.name()) //ROLE_ADMINTRAINEE
                .authorities(ADMINTRAINEE.getSimpleGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                joanUser,
                angieUser,
                alexUser
        );
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin")
//                .password("{noop}password")
//                .roles("USER");
//    }

}
