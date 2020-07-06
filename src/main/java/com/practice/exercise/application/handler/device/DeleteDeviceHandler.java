package com.practice.exercise.application.handler.device;

import com.practice.exercise.domain.service.device.DeleteDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteDeviceHandler {

    private final DeleteDeviceService deleteDeviceService;

    @Autowired
    public DeleteDeviceHandler(DeleteDeviceService deleteDeviceService) {
        this.deleteDeviceService = deleteDeviceService;
    }

    public void deleteDeviceById(Long id) {
        this.deleteDeviceService.deleteDeviceById(id);
    }
}
