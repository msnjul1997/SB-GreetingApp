package com.example.sbgreeting.com.model;

import javax.persistence.*;
//mark class as an Entity
@Entity

//defining class name as Table name
@Table(name = "Greetings")
public class User {
    @Id //mark id as primary key
    @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}