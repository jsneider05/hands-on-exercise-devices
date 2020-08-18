package com.practice.exercise.domain.service.device;

import com.practice.exercise.domain.model.device.Device;
import com.practice.exercise.domain.repository.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveDeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public SaveDeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Device save(Device device) {
        return this.deviceRepository.saveDevice(device);
    }
}
