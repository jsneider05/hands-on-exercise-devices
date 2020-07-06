package com.practice.exercise.application.factory.device;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

public class DeviceCommand {

    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime localDateTime;

    @Pattern(regexp = "^(?!\\s*$).+", message = "{status.notValid}")
    private String status;

    @Valid
    private ParamCommand param;

    public DeviceCommand(@JsonProperty("id") Long id,
                         @JsonProperty("localDateTime") LocalDateTime localDateTime,
                         @JsonProperty("status") String status,
                         @JsonProperty("param") ParamCommand param) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.status = status;
        this.param = param;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getStatus() {
        return status;
    }

    public ParamCommand getParam() {
        return param;
    }
}
