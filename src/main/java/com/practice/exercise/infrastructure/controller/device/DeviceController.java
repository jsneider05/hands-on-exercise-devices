package com.practice.exercise.infrastructure.controller.device;

import com.practice.exercise.application.factory.device.DeviceCommand;
import com.practice.exercise.application.handler.device.DeleteDeviceHandler;
import com.practice.exercise.application.handler.device.SaveDeviceHandler;
import com.practice.exercise.application.handler.device.SelectDeviceHandler;
import com.practice.exercise.application.handler.device.UpdateDeviceHandler;
import com.practice.exercise.domain.model.device.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestControllerAdvice
@RestController
@RequestMapping(value = "/v1/device")
public class DeviceController {

    private final SelectDeviceHandler selectDeviceHandler;
    private final SaveDeviceHandler saveDeviceHandler;
    private final DeleteDeviceHandler deleteDeviceHandler;
    private final UpdateDeviceHandler updateDeviceHandler;

    @Autowired
    public DeviceController(SelectDeviceHandler selectDeviceHandler,
                            SaveDeviceHandler saveDeviceHandler,
                            DeleteDeviceHandler deleteDeviceHandler,
                            UpdateDeviceHandler updateDeviceHandler) {
        this.selectDeviceHandler = selectDeviceHandler;
        this.saveDeviceHandler = saveDeviceHandler;
        this.deleteDeviceHandler = deleteDeviceHandler;
        this.updateDeviceHandler = updateDeviceHandler;
    }

//    hasRole('ROLE_')
//    hasAnyRole('ROLE_1', 'ROLE_2')
//    hasAuthority('permission')
//    hasAnyAuthority('permission1', 'permission2')

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Device> selectAllDevices() {
        return selectDeviceHandler.selectAllDevices();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('device:write')")
    public Device saveDevice(@RequestBody @Valid DeviceCommand deviceCommand) {
        return this.saveDeviceHandler.saveDevice(deviceCommand);
    }

    @PreAuthorize("hasAuthority('device:write')")
    @DeleteMapping(path = "{id}")
    public void deleteDeviceById(@PathVariable(name = "id", required = true) Long id) {
        this.deleteDeviceHandler.deleteDeviceById(id);
    }

    @PreAuthorize("hasAuthority('device:write')")
    @PutMapping(path = "{id}")
    public Device updateDevice(@PathVariable(value = "id", required = true) Long id,
                             @RequestBody @Valid DeviceCommand deviceCommand) {
        return this.updateDeviceHandler.updateDevice(id, deviceCommand);
    }
}
