package com.practice.exercise.domain.model.device.filter;

import com.practice.exercise.domain.model.device.Device;

import java.util.function.Predicate;

public interface DeviceFilter {

    /**
     * Predicate for filter device por field
     * @param filterValue
     */
    Predicate<Device> filterDeviceByField(Object filterValue);

    /**
     * Get the filter type
     * @return Someone value of {@link FilterType}
     */
    String getFilterType();
}
