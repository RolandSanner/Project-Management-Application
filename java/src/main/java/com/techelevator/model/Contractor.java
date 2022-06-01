package com.techelevator.model;

public class Contractor {

    private int contractorID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String companyName;
    private String industry;
    private String contractorAddress;

    public Contractor(){

    }

    public Contractor(int contractorID, String firstName, String lastName, String phoneNumber, String email, String companyName, String industry, String contractorAddress) {
        this.contractorID = contractorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.industry = industry;
        this.contractorAddress = contractorAddress;
    }

    @Override
    public String toString() {
        return "com.techelevator.model.Contractor{" +
                "contractorID=" + contractorID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", industry='" + industry + '\'' +
                ", contractorAddress='" + contractorAddress + '\'' +
                '}';
    }

    public int getContractorID() {
        return contractorID;
    }

    public void setContractorID(int contractorID) {
        this.contractorID = contractorID;
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

    public String getContractorAddress() {
        return contractorAddress;
    }

    public void setContractorAddress(String contractorAddress) {
        this.contractorAddress = contractorAddress;
    }
}

