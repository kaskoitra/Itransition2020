package com.example.entity;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static javax.persistence.AccessType.FIELD;

@Entity
@Table(name="content")
@Access(FIELD)
public class Notes extends ParentEntity {

    @Column(name = "tag", nullable = false, length = 255)
    private String tag;
    @Column(name = "content", nullable = false)
    private String content;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

