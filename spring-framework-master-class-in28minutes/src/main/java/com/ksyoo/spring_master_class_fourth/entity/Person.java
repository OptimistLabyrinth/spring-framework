package com.ksyoo.spring_master_class_fourth.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name = "find_all_persons", query = "SELECT p FROM Person p")
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private Date birthDate;

    public Person() {
    }

    public Person(String name, String location, Date birthDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
