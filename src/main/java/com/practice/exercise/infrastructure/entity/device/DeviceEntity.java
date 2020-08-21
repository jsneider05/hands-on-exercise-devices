package com.practice.exercise.infrastructure.entity.device;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "devices")
public class DeviceEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "devices_id_seq",
            sequenceName = "devices_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "devices_id_seq")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "local_date_time", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime localDateTime;

    @Column(name = "status", nullable = false, length = 255)
    private String status;

    /*
    Using a Foreign Key
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "param_id", referencedColumnName = "id")
     */
    /*
    Using a Shared Primary Key
    @OneToOne(mappedBy = "device", cascade = CascadeType.ALL)
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "param_id", referencedColumnName = "id")
    private ParamEntity param;

    public DeviceEntity() {
    }

    public DeviceEntity(Long id, LocalDateTime localDateTime, String status, ParamEntity param) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.status = status;
        this.param = param;
    }

    public Long getId() {
        return id;
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

    public ParamEntity getParam() {
        return param;
    }

    public void setParam(ParamEntity param) {
        this.param = param;
    }
}
