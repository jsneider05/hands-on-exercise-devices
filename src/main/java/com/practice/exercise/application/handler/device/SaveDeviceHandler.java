package com.practice.exercise.application.handler.device;

import com.practice.exercise.application.event.activemq.ActiveMqPublisher;
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
    private final ActiveMqPublisher activeMqPublisher;

    @Autowired
    public SaveDeviceHandler(SaveDeviceService saveDeviceService,
                             DeviceFactory deviceFactory,
                             ActiveMqPublisher activeMqPublisher) {
        this.saveDeviceService = saveDeviceService;
        this.deviceFactory = deviceFactory;
        this.activeMqPublisher = activeMqPublisher;
    }

    public Device saveDevice(DeviceCommand deviceCommand) {
        Device deviceSaved = this.saveDeviceService.save(this.deviceFactory.mapFromDeviceCommand(deviceCommand));
        activeMqPublisher.publishDeviceCounter(deviceSaved.getId().toString());
        return deviceSaved;
    }
}
