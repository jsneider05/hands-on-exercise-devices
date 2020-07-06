package com.practice.exercise.application.factory.device;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

public class ParamCommand {

    private Long id;

    @Range(min = 0, max = 5000)
    private int rotorSpeed;

    @DecimalMin(value = "0.0")
    @DecimalMax(value = "70.0")
    @Digits(integer = 2, fraction = 2)
    private float slack;

    @DecimalMin(value = "0.0")
    @DecimalMax(value = "100.0", inclusive = false)
    @Digits(integer = 2, fraction = 2)
    private float rootThreshold;

    public ParamCommand(@JsonProperty("id") Long id,
                        @JsonProperty("rotorSpeed") int rotorSpeed,
                        @JsonProperty("slack") float slack,
                        @JsonProperty("rootThreshold") float rootThreshold) {
        this.id = id;
        this.rotorSpeed = rotorSpeed;
        this.slack = slack;
        this.rootThreshold = rootThreshold;
    }

    public Long getId() {
        return id;
    }

    public int getRotorSpeed() {
        return rotorSpeed;
    }

    public float getSlack() {
        return slack;
    }

    public float getRootThreshold() {
        return rootThreshold;
    }
}
