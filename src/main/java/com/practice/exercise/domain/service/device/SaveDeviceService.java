package com.practice.exercise.domain.service.device;

import com.practice.exercise.domain.model.device.Device;
import com.practice.exercise.domain.repository.device.DeviceRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveDeviceService {

    private DeviceRepository deviceRepository;

    public SaveDeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Device saveDevice(Device device) {
        return this.deviceRepository.saveDevice(device);
    }
}
