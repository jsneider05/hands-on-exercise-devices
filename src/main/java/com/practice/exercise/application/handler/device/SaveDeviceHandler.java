package com.practice.exercise.application.handler.device;

import com.practice.exercise.application.factory.device.DeviceCommand;
import com.practice.exercise.application.factory.device.DeviceFactory;
import com.practice.exercise.domain.model.device.Device;
import com.practice.exercise.domain.service.device.SaveDeviceService;
import org.springframework.stereotype.Component;

@Component
public class SaveDeviceHandler {

    private SaveDeviceService saveDeviceService;
    private DeviceFactory deviceFactory;

    public SaveDeviceHandler(SaveDeviceService saveDeviceService, DeviceFactory deviceFactory) {
        this.saveDeviceService = saveDeviceService;
        this.deviceFactory = deviceFactory;
    }

    public Device saveDevice(DeviceCommand deviceCommand) {
        return this.saveDeviceService.saveDevice(this.deviceFactory.mapFromDeviceCommand(deviceCommand));
    }
}
