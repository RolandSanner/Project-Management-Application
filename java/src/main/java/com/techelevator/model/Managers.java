
package com.techelevator.model;

public class Managers {


    private int managerID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String municipality;
    private String managerRole;


    public Managers (){

    }


    public Managers(int managerID, String firstName, String lastName, String phoneNumber, String email, String municipality, String managerRole) {
        this.managerID = managerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.municipality = municipality;
        this.managerRole = managerRole;
    }

    @Override
    public String toString() {
        return "com.techelevator.model.Managers{" +
                "managerID=" + managerID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", municipality='" + municipality + '\'' +
                ", managerRole='" + managerRole + '\'' +
                '}';
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getManagerRole() {
        return managerRole;
    }

    public void setManagerRole(String managerRole) {
        this.managerRole = managerRole;
    }
}