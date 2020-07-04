package com.practice.exercise.infrastructure.mapper.device;

import com.practice.exercise.domain.model.device.Device;
import com.practice.exercise.domain.model.device.Param;
import com.practice.exercise.infrastructure.entity.device.DeviceEntity;
import com.practice.exercise.infrastructure.entity.device.ParamEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeviceMapper {

    public List<Device> mapFromDeviceEntityList(List<DeviceEntity> listDeviceEntities) {
        return listDeviceEntities.stream()
                .map(deviceEntity -> new Device(deviceEntity.getId(),
                        deviceEntity.getLocalDateTime(),
                        deviceEntity.getStatus(),
                        mapFromParamEntity(deviceEntity.getParam())))
                .collect(Collectors.toList());
    }

    public Device mapFromDeviceEntity(DeviceEntity deviceEntity) {
        return new Device(deviceEntity.getId(),
                deviceEntity.getLocalDateTime(),
                deviceEntity.getStatus(),
                mapFromParamEntity(deviceEntity.getParam()));
    }

    private Param mapFromParamEntity(ParamEntity paramEntity) {
        return new Param(paramEntity.getId(),
                paramEntity.getRotorSpeed(),
                paramEntity.getSlack(),
                paramEntity.getRootThreshold());
    }

    public DeviceEntity mapToDeviceEntity(Device device) {
        return new DeviceEntity(device.getId(),
                device.getLocalDateTime(),
                device.getStatus(),
                mapToParamEntity(device.getParam()));
    }

    private ParamEntity mapToParamEntity(Param param) {
        return new ParamEntity(param.getId(),
                param.getRotorSpeed(),
                param.getSlack(),
                param.getRootThreshold());
    }
}
