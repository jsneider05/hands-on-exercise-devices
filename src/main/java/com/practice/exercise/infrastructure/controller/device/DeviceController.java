package com.practice.exercise.infrastructure.controller.device;

import com.practice.exercise.application.factory.device.DeviceCommand;
import com.practice.exercise.application.handler.device.SaveDeviceHandler;
import com.practice.exercise.application.handler.device.SelectDeviceHandler;
import com.practice.exercise.domain.model.device.Device;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/device")
public class DeviceController {

    private SelectDeviceHandler selectDeviceHandler;
    private SaveDeviceHandler saveDeviceHandler;

    public DeviceController(SelectDeviceHandler selectDeviceHandler, SaveDeviceHandler saveDeviceHandler) {
        this.selectDeviceHandler = selectDeviceHandler;
        this.saveDeviceHandler = saveDeviceHandler;
    }

//    hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission') hasAnyAuthority('permission')

    @GetMapping(value = "list")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Device> selectAllDevices() {
        return selectDeviceHandler.selectAllDevices();
    }

    @PostMapping(value = "save")
    @PreAuthorize("hasAuthority('device:write')")
    public Device saveDevice(@RequestBody DeviceCommand deviceCommand) {
        return this.saveDeviceHandler.saveDevice(deviceCommand);
    }
}
