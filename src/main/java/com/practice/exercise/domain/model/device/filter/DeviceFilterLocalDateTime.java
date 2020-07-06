package com.practice.exercise.domain.model.device.filter;

import com.practice.exercise.domain.model.device.Device;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;

@Component
public class DeviceFilterLocalDateTime implements DeviceFilter{

    @Override
    public Predicate<Device> filterDeviceByField(Object filterValue) {
        return device -> isAfterDate(filterValue.toString(), device.getLocalDateTime());
    }

    private boolean isAfterDate(String filterValue, LocalDateTime localDateTimeDevice) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime localDateTimeFilter = LocalDateTime.parse(filterValue, formatter);
        return localDateTimeDevice.isAfter(localDateTimeFilter);
    }

    @Override
    public String getFilterType() {
        return FilterType.localDateTime.name();
    }
}
