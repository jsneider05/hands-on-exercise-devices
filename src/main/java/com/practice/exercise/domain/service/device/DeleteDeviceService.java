package com.practice.exercise.domain.service.device;

import com.practice.exercise.domain.repository.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DeleteDeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeleteDeviceService(@Qualifier("postgresJpaRepository") DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public void deleteDeviceById(Long id) {
        this.deviceRepository.deleteDeviceById(id);
    }
}
