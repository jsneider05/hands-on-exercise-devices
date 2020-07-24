package com.practice.exercise.infrastructure.configuration.auth.repository;

import com.practice.exercise.infrastructure.configuration.auth.model.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserRepository {

    Optional<ApplicationUser> selectApplicationUserByUsername (String username);

}
