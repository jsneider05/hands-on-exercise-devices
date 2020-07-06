package com.practice.exercise.domain.model.device.filter;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeviceFilterFactory {

    List<DeviceFilter> filters;

    public DeviceFilterFactory(List<DeviceFilter> filters) {
        this.filters = filters;
    }

    public DeviceFilter createDeviceFilter(String filterType) {
        return this.filters.stream().filter(deviceFilter ->
                filterType.equals(deviceFilter.getFilterType())).findFirst().orElseThrow(RuntimeException::new);
    }
}
