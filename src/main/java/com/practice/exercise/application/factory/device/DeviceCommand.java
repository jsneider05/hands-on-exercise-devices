package com.practice.exercise.application.factory.device;

import java.time.LocalDateTime;

public class DeviceCommand {

    private LocalDateTime localDateTime;
    private String status;
    private ParamCommand paramCommand;

    public DeviceCommand() {
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getStatus() {
        return status;
    }

    public ParamCommand getParamCommand() {
        return paramCommand;
    }
}
