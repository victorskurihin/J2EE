package su.svn.demo;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "TEST")
public class TestMessages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String message() {
        return "Hello wold!";
    }
}
