package com.example.annotationuser;
public class App {

    // https://www.baeldung.com/java-annotation-processing-builder
    public static void main(String[] args) {

        Person person = new PersonBuilder()
                .setAge(25)
                .setName("John")
                .build();

        System.out.println(person.getName());
    }
}
