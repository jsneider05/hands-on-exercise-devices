package com.practice.exercise.domain.model.device.filter;

import com.practice.exercise.domain.model.device.Device;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class DeviceFilterStatus implements DeviceFilter{

    @Override
    public Predicate<Device> filterDeviceByField(Object filterValue) {
        return device -> device.getStatus().equals(filterValue.toString());
    }

    @Override
    public String getFilterType() {
        return FilterType.status.name();
    }
}
