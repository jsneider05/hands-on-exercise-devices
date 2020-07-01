package com.practice.exercise.application.handler.device;

import com.practice.exercise.domain.model.device.Device;
import com.practice.exercise.domain.service.device.SelectAllDeviceService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SelectDeviceHandler {

    private SelectAllDeviceService selectAllDeviceService;

    public SelectDeviceHandler(SelectAllDeviceService selectAllDeviceService) {
        this.selectAllDeviceService = selectAllDeviceService;
    }

    public List<Device> selectAllDevices() {
        return selectAllDeviceService.selectAllDevices();
    }
}
