package com.practice.exercise.domain.service.device;

import com.practice.exercise.domain.model.device.Device;
import com.practice.exercise.domain.model.device.filter.FilterType;
import com.practice.exercise.domain.model.device.filter.DeviceFilter;
import com.practice.exercise.domain.model.device.filter.DeviceFilterFactory;
import com.practice.exercise.domain.repository.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;

@Service
public class SelectDeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceFilterFactory deviceFilterFactory;

    @Autowired
    public SelectDeviceService(DeviceRepository deviceRepository, DeviceFilterFactory deviceFilterFactory) {
        this.deviceRepository = deviceRepository;
        this.deviceFilterFactory = deviceFilterFactory;
    }

    public List<Device> select(LocalDateTime localDateTime, String status, Integer rotorSpeed) {

        final var deviceList = deviceRepository.selectDevices();

        Map<String, Object> filterMapDevice  = new HashMap<>();
        filterMapDevice.put(FilterType.localDateTime.name(), localDateTime);
        filterMapDevice.put(FilterType.status.name(), status);
        filterMapDevice.put(FilterType.rotorSpeed.name(), rotorSpeed);

        filterMapDevice.forEach((filterType, filterValue) -> {
            if (Objects.nonNull(filterValue) && !filterValue.toString().isBlank()) {
                DeviceFilter deviceFilter = this.deviceFilterFactory.createDeviceFilter(filterType);
                deviceList.removeIf(Predicate.not(deviceFilter.filterDeviceByField(filterValue)));
            }
        });

        return deviceList;
    }
}
