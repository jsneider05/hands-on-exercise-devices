package com.practice.exercise.infrastructure.repository.device;

import com.practice.exercise.domain.model.device.Device;
import com.practice.exercise.domain.repository.device.DeviceRepository;
import com.practice.exercise.infrastructure.mapper.device.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postgresJpaRepository")
public class DeviceRepositoryImpl implements DeviceRepository {

    private DeviceJpaRepository deviceJpaRepository;
    private DeviceMapper deviceMapper;

    @Autowired
    public DeviceRepositoryImpl(DeviceJpaRepository deviceJpaRepository, DeviceMapper deviceMapper) {
        this.deviceJpaRepository = deviceJpaRepository;
        this.deviceMapper = deviceMapper;
    }

    @Override
    public List<Device> selectAllDevices() {
        return this.deviceMapper.mapFromDeviceEntityList(deviceJpaRepository.findAll());
    }

    @Override
    public Device saveDevice(Device device) {
        return this.deviceMapper.mapFromDeviceEntity(
                this.deviceJpaRepository.save(
                        this.deviceMapper.mapToDeviceEntity(device)
                ));
    }

    @Override
    public void deleteDeviceById(Long id) {
        this.deviceJpaRepository.deleteById(id);
    }

    @Override
    public Device updateDevice(Long id, Device device) {
        return this.deviceMapper.mapFromDeviceEntity(
                this.deviceJpaRepository.save(
                        this.deviceMapper.mapToDeviceEntity(device)
                ));
    }

}
