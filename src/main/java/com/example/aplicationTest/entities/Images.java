package com.example.aplicationTest.entities;

import jakarta.persistence.*;

@Entity
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String type;

    @Lob
    @Column(nullable = false,columnDefinition = "LONGBLOB")
    byte[] data;

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public byte[] getData() {
        return data;
    }

}
