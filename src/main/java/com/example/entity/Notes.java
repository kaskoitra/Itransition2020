package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name="content")
@Access(AccessType.FIELD)
public class Notes extends ParentEntity {

    private static final long serialVersionUID = 4541815928732870812L;

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

