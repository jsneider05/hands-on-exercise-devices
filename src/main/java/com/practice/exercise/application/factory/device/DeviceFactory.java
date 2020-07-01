package com.practice.exercise.application.factory.device;

import com.practice.exercise.domain.model.device.Device;
import org.springframework.stereotype.Component;

@Component
public class DeviceFactory {

    public Device mapFromDeviceCommand (DeviceCommand deviceCommand) {
        return new Device(null, deviceCommand.getName());
    }
}
