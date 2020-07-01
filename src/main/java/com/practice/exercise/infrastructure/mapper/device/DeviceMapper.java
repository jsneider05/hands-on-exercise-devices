package com.practice.exercise.infrastructure.mapper.device;

import com.practice.exercise.domain.model.device.Device;
import com.practice.exercise.infrastructure.entity.device.DeviceEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeviceMapper {

    public List<Device> mapFromDeviceEntityList(List<DeviceEntity> listDeviceEntities) {
        return listDeviceEntities.stream()
                .map(deviceEntity -> new Device(deviceEntity.getId(), deviceEntity.getName()))
                .collect(Collectors.toList());
    }

    public Device mapFromDeviceEntity(DeviceEntity deviceEntity) {
        return new Device(deviceEntity.getId(), deviceEntity.getName());
    }

    public DeviceEntity mapToDeviceEntity(Device device) {
        return new DeviceEntity(device.getId(), device.getName());
    }
}
