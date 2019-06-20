package com.rocketzki.persistedh2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Users")
public class User {

    @Id
    private int id;
    private String username;
    private String password;


    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }
}
