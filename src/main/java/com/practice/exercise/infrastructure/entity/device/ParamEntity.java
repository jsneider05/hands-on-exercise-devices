package com.practice.exercise.infrastructure.entity.device;

import javax.persistence.*;

@Entity
@Table(name = "params")
public class ParamEntity {


//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "rotor_speed", nullable = false)
    private int rotorSpeed;

    @Column(name = "slack", nullable = false)
    private float slack;

    @Column(name = "root_threshold", nullable = false)
    private float rootThreshold;

    /*
    Using a Foreign Key
    @OneToOne(mappedBy = "param")
     */
    /*
    @OneToOne
    @MapsId
    Using a Shared Primary Key
     */
    @OneToOne(mappedBy = "param")
    private DeviceEntity device;

    public ParamEntity() {
    }

    public ParamEntity(Long id, int rotorSpeed, float slack, float rootThreshold) {
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

    public DeviceEntity getDevice() {
        return device;
    }

    public void setDevice(DeviceEntity device) {
        this.device = device;
    }
}
