package com.adisava.persistance;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {

    private static final long serialVersionUID = 8783403369108889175L;

    public String username;

    public String password;

    public String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
