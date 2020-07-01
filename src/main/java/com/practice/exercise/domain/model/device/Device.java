package com.practice.exercise.domain.model.device;

import java.util.UUID;

public class Device {

    private UUID id;
    private String name;

    public Device(UUID id, String name) {

        ArgumentValidator.validateRequired(name, "name");

        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
