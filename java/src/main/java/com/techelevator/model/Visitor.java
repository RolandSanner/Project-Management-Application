package com.techelevator.model;

public class Visitor {



    private int visitorID;
    private String firstName;
    private String lastName;
    private String company_position;

    public Visitor(int visitor_id, String firstName, String lastName, String company_position) {
        this.visitorID = visitor_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company_position = company_position;
    }

    public Visitor(){}

    @Override
    public String toString() {
        return "com.techelevator.model.Visitor{" +
                "visitor_id=" + visitorID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company_position='" + company_position + '\'' +
                '}';
    }

    public int getVisitorID() {
        return visitorID;
    }

    public void setVisitorID(int visitorID) {
        this.visitorID = visitorID;
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

    public String getCompany_position() {
        return company_position;
    }

    public void setCompany_position(String company_position) {
        this.company_position = company_position;
    }
}
