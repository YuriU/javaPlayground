package com.in28minutes.rest.webservice.restfulwebservice.versioning;

public class PersonV1 {
    public PersonV1(String name) {
        this.name = name;
    }

    public PersonV1() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
