package com.example.entity;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static javax.persistence.AccessType.FIELD;
import static javax.persistence.GenerationType.AUTO;

@MappedSuperclass
@Access(FIELD)
public class ParentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= AUTO)
    @Column(name="id", unique = true, nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
