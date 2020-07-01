package com.practice.exercise.infrastructure.repository.device;

import com.practice.exercise.infrastructure.entity.device.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DeviceJpaRepository extends JpaRepository<DeviceEntity, UUID> {

    List<DeviceEntity> findAll();

    DeviceEntity save(DeviceEntity deviceEntity);

}
