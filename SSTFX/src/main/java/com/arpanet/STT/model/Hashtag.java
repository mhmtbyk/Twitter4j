package com.arpanet.STT.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Hashtag {
    @Id
    private Long id;
    private String text;
    public Hashtag(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public String setText(String text) {
        this.text = text;
        return text;
    }

    public Hashtag(Long id, String text) {
        this.id = id;
        this.text = text;
    }
}
