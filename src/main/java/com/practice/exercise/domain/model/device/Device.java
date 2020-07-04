package com.practice.exercise.domain.model.device;

import java.time.LocalDateTime;

public class Device {

    private Long id;
    private LocalDateTime localDateTime;
    private String status;
    private Param param;

    public Long getId() {
        return id;
    }

    public Device(Long id, LocalDateTime localDateTime, String status, Param param) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.status = status;
        this.param = param;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Param getParam() {
        return param;
    }

    public void setParam(Param param) {
        this.param = param;
    }
}
