package com.practice.exercise.application.handler.device;

import com.practice.exercise.application.factory.device.DeviceCommand;
import com.practice.exercise.application.factory.device.DeviceFactory;
import com.practice.exercise.domain.model.device.Device;
import com.practice.exercise.domain.service.device.UpdateDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateDeviceHandler {

    private final UpdateDeviceService updateDeviceService;
    private final DeviceFactory deviceFactory;

    @Autowired
    public UpdateDeviceHandler(UpdateDeviceService updateDeviceService, DeviceFactory deviceFactory) {
        this.updateDeviceService = updateDeviceService;
        this.deviceFactory = deviceFactory;
    }

    public Device updateDevice(Long id, DeviceCommand deviceCommand) {
        return this.updateDeviceService.updateDevice(id, this.deviceFactory.mapFromDeviceCommand(deviceCommand));
    }
}
