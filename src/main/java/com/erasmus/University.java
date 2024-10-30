package com.erasmus;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private String country;
    private List<Subject> subjects;

    public University(String name, String country) {
        this.name = name;
        this.country = country;
        this.subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }
}
