package su.svn.WebApp003.models;

import javax.persistence.*;
import java.io.Serializable;

@javax.persistence.Entity(name = "USERS")
@NamedQuery(name = "User.getAll", query = "SELECT U FROM USERS U")
public class UserDataSet implements Serializable {
    // @Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Column(name = "ID")
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "LASTNAME", nullable = false)
    private String lastName;

    @Column(name = "AGE", nullable = false)
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
