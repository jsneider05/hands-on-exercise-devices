package com.practice.exercise.infrastructure.configuration.auth.repository;

import com.practice.exercise.infrastructure.configuration.auth.mapper.ApplicationUserMapper;
import com.practice.exercise.infrastructure.configuration.auth.model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("postgresApplicationUserRepository")
public class ApplicationUserRepositoryImpl implements ApplicationUserRepository {

    private final ApplicationUserJpaRepository applicationUserJpaRepository;
    private ApplicationUserMapper applicationUserMapper;

    @Autowired
    public ApplicationUserRepositoryImpl(ApplicationUserJpaRepository applicationUserJpaRepository, ApplicationUserMapper applicationUserMapper) {
        this.applicationUserJpaRepository = applicationUserJpaRepository;
        this.applicationUserMapper = applicationUserMapper;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return this.applicationUserMapper.mapToApplicationUser(
                this.applicationUserJpaRepository.selectApplicationUserByUsername(username));
    }
}
