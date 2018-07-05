package com.devcolibri.entity;

import javax.persistence.*;

@Entity(name = "users")
@NamedQuery(
    name = "User.getAll", query = "SELECT id, name, lastName, age FROM users"
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private int age;

    public User() {
    }

    public User(String name, String lastName, int age) {

        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
