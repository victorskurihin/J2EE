package su.svn.demo.persistent;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "CONFIG")
@Table(
    name = "CONFIG",
    uniqueConstraints = {
        @UniqueConstraint(name = "IDX_ID_NAME", columnNames = {"ID", "NAME"})
    }
)
@NamedQuery(name = "Config.getAll", query = "SELECT c FROM CONFIG c")
public class ConfigDataSet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "VALUE", nullable = false)
    private String value;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigDataSet that = (ConfigDataSet) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value);
    }

    @Override
    public String toString() {
        return "ConfigDataSet" +
                "{ id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                " }";
    }
}
