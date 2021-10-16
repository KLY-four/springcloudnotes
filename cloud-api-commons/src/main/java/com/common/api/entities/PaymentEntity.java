package com.common.api.entities;

import java.io.Serializable;

public class PaymentEntity implements Serializable {
    private Integer id ;
    private String serial;

    public PaymentEntity() {
    }

    public PaymentEntity(String serial) {
        this.serial = serial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
