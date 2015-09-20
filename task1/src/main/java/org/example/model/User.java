package org.example.model;

public class User{

    private Integer id;
    private String name;
    private String surName;
    private String email;
    private Roles role;

    public User(Integer id, String name, String surName, String email, Roles role) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.role = role;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getEmail() {
        return email;
    }

    public Roles getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
