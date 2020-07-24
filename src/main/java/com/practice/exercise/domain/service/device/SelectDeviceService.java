package com.practice.exercise.domain.service.device;

import com.practice.exercise.domain.model.device.Device;
import com.practice.exercise.domain.model.device.filter.FilterType;
import com.practice.exercise.domain.model.device.filter.DeviceFilter;
import com.practice.exercise.domain.model.device.filter.DeviceFilterFactory;
import com.practice.exercise.domain.repository.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SelectDeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceFilterFactory deviceFilterFactory;
    protected List<Device> deviceList;

    @Autowired
    public SelectDeviceService(@Qualifier("postgresJpaRepository") DeviceRepository deviceRepository, DeviceFilterFactory deviceFilterFactory) {
        this.deviceRepository = deviceRepository;
        this.deviceFilterFactory = deviceFilterFactory;
    }

    public List<Device> selectDevices(LocalDateTime localDateTime, String status, Integer rotorSpeed) {

        this.deviceList = deviceRepository.selectDevices();

        Map<String, Object> filterMapDevice  = new HashMap<>();
        filterMapDevice.put(FilterType.localDateTime.name(), localDateTime);
        filterMapDevice.put(FilterType.status.name(), status);
        filterMapDevice.put(FilterType.rotorSpeed.name(), rotorSpeed);

        filterMapDevice.forEach((filterType, filterValue) -> {
            if (Objects.nonNull(filterValue) && !filterValue.toString().isBlank()) {
                DeviceFilter deviceFilter = this.deviceFilterFactory.createDeviceFilter(filterType);
                this.deviceList = this.deviceList.stream().filter(deviceFilter.filterDeviceByField(filterValue))
                        .collect(Collectors.toList());
            }
        });

        return this.deviceList;
    }
}
