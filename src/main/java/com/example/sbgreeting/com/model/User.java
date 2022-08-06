package com.example.sbgreeting.com.model;

public class User {
    public String firstName;
    public String lastName;
    public User(String firstName,String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public User() {

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
    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
    }

}
