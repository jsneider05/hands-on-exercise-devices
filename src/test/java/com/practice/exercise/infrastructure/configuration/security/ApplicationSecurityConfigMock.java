package com.practice.exercise.infrastructure.configuration.security;

import com.practice.exercise.infrastructure.configuration.jwt.JwtConfig;
import com.practice.exercise.infrastructure.configuration.jwt.JwtTokenVerifier;
import com.practice.exercise.infrastructure.configuration.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.test.context.ActiveProfiles;

import javax.crypto.SecretKey;

import static com.practice.exercise.infrastructure.configuration.auth.model.ApplicationUserRole.*;

@Profile("test")
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfigMock extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfigMock(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/v1/device/**").hasAuthority("device:write")
//                .antMatchers("/v1/device/**").hasAuthority("device:read")
                .anyRequest()
                .authenticated()
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

//    private final PasswordEncoder passwordEncoder;
//    private final MockApplicationUserService mockApplicationUserService;
//    private final JwtConfig jwtConfig;
//    private final SecretKey secretKey;
//
//    @Autowired
//    public ApplicationSecurityConfigMock(PasswordEncoder passwordEncoder,
//                                         MockApplicationUserService mockApplicationUserService,
//                                         JwtConfig jwtConfig,
//                                         SecretKey secretKey) {
//        this.passwordEncoder = passwordEncoder;
//        this.mockApplicationUserService = mockApplicationUserService;
//        this.jwtConfig = jwtConfig;
//        this.secretKey = secretKey;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .sessionManagement()
//                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
//                .addFilterAfter(new JwtTokenVerifier(jwtConfig, secretKey), JwtUsernameAndPasswordAuthenticationFilter.class)
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated();
//
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder);
//        provider.setUserDetailsService(mockApplicationUserService);
//        return provider;
//    }
}
