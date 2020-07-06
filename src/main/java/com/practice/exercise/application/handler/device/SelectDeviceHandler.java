package com.practice.exercise.application.handler.device;

import com.practice.exercise.domain.model.device.Device;
import com.practice.exercise.domain.service.device.SelectDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SelectDeviceHandler {

    private final SelectDeviceService selectDeviceService;

    @Autowired
    public SelectDeviceHandler(SelectDeviceService selectDeviceService) {
        this.selectDeviceService = selectDeviceService;
    }

    public List<Device> selectDevices(LocalDateTime localDateTime, String status, Integer rotorSpeed) {
        return selectDeviceService.selectDevices(localDateTime, status, rotorSpeed);
    }
}
