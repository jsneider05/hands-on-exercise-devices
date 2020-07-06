package com.practice.exercise.infrastructure.repository.device;

import com.practice.exercise.infrastructure.entity.device.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceJpaRepository extends JpaRepository<DeviceEntity, Long> {

    List<DeviceEntity> findAll();

    DeviceEntity save(DeviceEntity deviceEntity);

}
