package com.practice.exercise.application.handler.device;

import com.practice.exercise.application.factory.device.DeviceCommand;
import com.practice.exercise.application.factory.device.DeviceFactory;
import com.practice.exercise.domain.model.device.Device;
import com.practice.exercise.domain.service.device.SaveDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveDeviceHandler {

    private final SaveDeviceService saveDeviceService;
    private final DeviceFactory deviceFactory;

    @Autowired
    public SaveDeviceHandler(SaveDeviceService saveDeviceService, DeviceFactory deviceFactory) {
        this.saveDeviceService = saveDeviceService;
        this.deviceFactory = deviceFactory;
    }

    public Device saveDevice(DeviceCommand deviceCommand) {
        return this.saveDeviceService.save(this.deviceFactory.mapFromDeviceCommand(deviceCommand));
    }
}
