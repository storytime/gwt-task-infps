package org.example.model;

/**
 * @author by Bogdan.Fedorchenko on 9/15/2015.
 */
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

    public User(){}

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurName() {
        return surName;
    }

    public User setSurName(String surName) {
        this.surName = surName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Roles getRole() {
        return role;
    }

    public User setRole(Roles role) {
        this.role = role;
        return this;
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

    @Override
    public boolean equals(Object o) {
        if (o instanceof User) {
            return id == ((User) o).id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
