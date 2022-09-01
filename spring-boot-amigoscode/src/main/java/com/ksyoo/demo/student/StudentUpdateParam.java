package com.ksyoo.demo.student;

import java.util.Optional;

public class StudentUpdateParam {
    private Optional<String> name;
    private Optional<String> email;

    public StudentUpdateParam(Optional<String> name, Optional<String> email) {
        this.name = name;
        this.email = email;
    }

    public Optional<String> getName() {
        return name;
    }

    public void setName(Optional<String> name) {
        this.name = name;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentUpdateParam { " +
                "name=" + name +
                ", email=" + email +
                " }";
    }
}
