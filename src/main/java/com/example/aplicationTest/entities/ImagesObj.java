package com.example.aplicationTest.entities;

public class ImagesObj {
    Long id;
    String name;
    String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }
    public ImagesObj(){}
    public ImagesObj(Long id,String name,String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
