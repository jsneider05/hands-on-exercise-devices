package com.practice.exercise.infrastructure.configuration.auth.repository;

import com.google.common.collect.Lists;
import com.practice.exercise.infrastructure.configuration.auth.model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.practice.exercise.infrastructure.configuration.auth.model.ApplicationUserRole.*;

@Repository("fakeApplicationUserRepository")
public class FakeApplicationUserRepositoryImpl implements ApplicationUserRepository {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserRepositoryImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        return Lists.newArrayList(
                new ApplicationUser(
                        ADMIN.getSimpleGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "Joan",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        USER.getSimpleGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "user",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMINTRAINEE.getSimpleGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "Alex",
                        true,
                        true,
                        true,
                        true
                )
        );
    }
}
