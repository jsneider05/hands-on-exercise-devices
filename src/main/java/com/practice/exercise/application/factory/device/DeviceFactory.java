package com.practice.exercise.application.factory.device;

import com.practice.exercise.domain.model.device.Device;
import com.practice.exercise.domain.model.device.Param;
import org.springframework.stereotype.Component;

@Component
public class DeviceFactory {

    public Device mapFromDeviceCommand (DeviceCommand deviceCommand) {
        return new Device(null, deviceCommand.getLocalDateTime(),
                deviceCommand.getStatus(),
                mapFromParamCommand(deviceCommand.getParamCommand()));
    }

    private Param mapFromParamCommand (ParamCommand paramCommand) {
        return new Param(null, paramCommand.getRotorSpeed(),
                paramCommand.getSlack(),
                paramCommand.getRootThreshold());
    }
}
