package com.example.springdatabasicdemo.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.sql.Date;


@MappedSuperclass
public abstract class CreatedAndModified extends BaseEntity{

    @Column(name = "created")
    private Date created;


    @Column(name = "modified")
    private Date modified;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
