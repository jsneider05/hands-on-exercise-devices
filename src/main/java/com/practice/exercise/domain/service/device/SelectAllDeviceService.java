package com.practice.exercise.domain.service.device;

import com.practice.exercise.domain.model.device.Device;
import com.practice.exercise.domain.repository.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectAllDeviceService {

    private DeviceRepository deviceRepository;

    @Autowired
    public SelectAllDeviceService(@Qualifier("postgresJpaRepository") DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> selectAllDevices() {
        return deviceRepository.selectAllDevices();
    }
}
