package com.practice.exercise.domain.repository.device;

import com.practice.exercise.domain.model.device.Device;

import java.util.List;

public interface DeviceRepository {

    /**
     * Select all devices from database
     * @return List of {@link Device}
     */
    List<Device> selectAllDevices();

    /**
     * Save a device
     * @param device
     * @return An {@link Device} object
     */
    Device saveDevice(Device device);
}
