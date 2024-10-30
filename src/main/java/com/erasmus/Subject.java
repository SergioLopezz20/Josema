package com.erasmus;

public class Subject {
    private String name;
    private String etsisiSubject;
    private String procede;

    public Subject(String name, String etsisiSubject, String procede) {
        this.name = name;
        this.etsisiSubject = etsisiSubject;
        this.procede = procede;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEtsisiSubject() {
        return etsisiSubject;
    }

    public void setEtsisiSubject(String etsisiSubject) {
        this.etsisiSubject = etsisiSubject;
    }

    public String getProcede() {
        return procede;
    }

    public void setProcede(String procede) {
        this.procede = procede;
    }
}
