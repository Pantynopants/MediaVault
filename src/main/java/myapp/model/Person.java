package myapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
