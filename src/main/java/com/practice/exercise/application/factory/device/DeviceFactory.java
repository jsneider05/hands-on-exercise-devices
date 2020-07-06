package com.practice.exercise.application.factory.device;

import com.practice.exercise.domain.model.device.Device;
import com.practice.exercise.domain.model.device.Param;
import org.springframework.stereotype.Component;

@Component
public class DeviceFactory {

    public Device mapFromDeviceCommand (DeviceCommand deviceCommand) {
        return new Device(deviceCommand.getId(), deviceCommand.getLocalDateTime(),
                deviceCommand.getStatus(),
                mapFromParamCommand(deviceCommand.getParam()));
    }

    private Param mapFromParamCommand (ParamCommand paramCommand) {
        return new Param(paramCommand.getId(), paramCommand.getRotorSpeed(),
                paramCommand.getSlack(),
                paramCommand.getRootThreshold());
    }
}
