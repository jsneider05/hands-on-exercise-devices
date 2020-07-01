package com.practice.exercise.infrastructure.configuration.security;

public enum ApplicationUserPermission {
//    DEVICE_CREATE("device:create"),
    DEVICE_READ("device:read"),
//    DEVICE_UPDATE("device:update"),
//    DEVICE_DELETE("device:delete"),
    DEVICE_WRITE("device:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
