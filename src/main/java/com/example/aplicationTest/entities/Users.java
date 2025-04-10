package com.example.aplicationTest.entities;

import jakarta.persistence.*;

@Entity
public class Users {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;

@Column(nullable = false,unique = true)
    String email;

@Column(nullable = false)
    String name;

@Column(nullable = false)
    String avatarUrl;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
public Users(){}
    public Users(String email,String name,String avatarUrl){
        this.email = email;
        this.avatarUrl=avatarUrl;
        this.name = name;
    }
}



