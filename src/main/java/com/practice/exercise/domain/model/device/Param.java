package com.practice.exercise.domain.model.device;


public class Param {

    private Long id;
    private int rotorSpeed;
    private float slack;
    private float rootThreshold;

    public Param() {
    }

    public Param(Long id, int rotorSpeed, float slack, float rootThreshold) {
        this.id = id;
        this.rotorSpeed = rotorSpeed;
        this.slack = slack;
        this.rootThreshold = rootThreshold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRotorSpeed() {
        return rotorSpeed;
    }

    public void setRotorSpeed(int rotorSpeed) {
        this.rotorSpeed = rotorSpeed;
    }

    public float getSlack() {
        return slack;
    }

    public void setSlack(float slack) {
        this.slack = slack;
    }

    public float getRootThreshold() {
        return rootThreshold;
    }

    public void setRootThreshold(float rootThreshold) {
        this.rootThreshold = rootThreshold;
    }
}
