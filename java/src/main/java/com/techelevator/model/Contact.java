
package com.techelevator.model;

public class Contact {


    private int contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String municipality;
    private String contactRole;
    private String companyName;
    private String industry;
    private String contactStreet;
    private String contactCity;
    private String contactState;
    private String contactZip ;

    public Contact() {
    }

    public Contact(int contactID, String firstName, String lastName, String phoneNumber, String email, String municipality, String contactRole, String companyName, String industry, String contactStreet, String contactCity, String contactState, String contactZip ) {
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.municipality = municipality;
        this.contactRole = contactRole;
        this.companyName = companyName;
        this.industry = industry;
        this.contactStreet = contactStreet;
        this.contactCity = contactCity;
        this.contactState = contactState;
        this.contactZip  = contactZip ;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactID=" + contactID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", municipality='" + municipality + '\'' +
                ", contactRole='" + contactRole + '\'' +
                ", companyName='" + companyName + '\'' +
                ", industry='" + industry + '\'' +
                ", contactStreet='" + contactStreet + '\'' +
                ", contactCity='" + contactCity + '\'' +
                ", contactState='" + contactState + '\'' +
                ", contactZip ='" + contactZip  + '\'' +
                '}';
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }


    public String getContactStreet() {
        return contactStreet;
    }

    public void setContactStreet(String contactStreet) {
        this.contactStreet = contactStreet;
    }

    public String getContactCity() {
        return contactCity;
    }

    public void setContactCity(String contactCity) {
        this.contactCity = contactCity;
    }

    public String getContactState() {
        return contactState;
    }

    public void setContactState(String contactState) {
        this.contactState = contactState;
    }

    public String getContactZip() {
        return contactZip;
    }

    public void setContactZip(String contactZip) {
        this.contactZip = contactZip;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
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

    public String getContactRole() {
        return contactRole;
    }

    public void setContactRole(String contactRole) {
        this.contactRole = contactRole;
    }
}