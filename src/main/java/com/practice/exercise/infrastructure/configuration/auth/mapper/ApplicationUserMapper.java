package com.practice.exercise.infrastructure.configuration.auth.mapper;

import com.practice.exercise.infrastructure.configuration.auth.entity.PrivilegeEntity;
import com.practice.exercise.infrastructure.configuration.auth.entity.RoleEntity;
import com.practice.exercise.infrastructure.configuration.auth.entity.UserEntity;
import com.practice.exercise.infrastructure.configuration.auth.model.ApplicationUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ApplicationUserMapper {

    public Optional<ApplicationUser> mapToApplicationUser(UserEntity user) {
        return Optional.of( new ApplicationUser(getPermissions(user.getRoles()),
                user.getPassword(),
                user.getUserName(),
                true,
                true,
                true,
                user.isEnabled()));
    }

    private Set<SimpleGrantedAuthority> getPermissions(Set<RoleEntity> roleEntities) {
        Set<SimpleGrantedAuthority> permissions = roleEntities.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toSet());

        roleEntities.forEach(
                role -> getRolePrivilegesName(role.getPrivileges())
                        .forEach(
                                privilegeName -> permissions.add(new SimpleGrantedAuthority(privilegeName))));
        return permissions;
    }

    private Set<String> getRolePrivilegesName(Set<PrivilegeEntity> privilegeEntities) {
        return privilegeEntities.stream()
                .map(PrivilegeEntity::getName)
                .collect(Collectors.toSet());
    }

}
