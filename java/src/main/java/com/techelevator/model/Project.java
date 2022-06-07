package com.techelevator.model;

public class Project {


    private String projectID;
    private String projectName;
    private String precinct;
    private String municipality;
    private String location;
    private String description;
    private long projectManagerID;
    private String projectManagerName;
    private long groupID;
    private String groupName;
    private String fundingSource;
    private String contractName;

    public String getProjectID() {
        return projectID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getProjectManagerName() {
        return projectManagerName;
    }

    public void setProjectManagerName(String projectManagerName) {
        this.projectManagerName = projectManagerName;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public Project() {

    }

    public Project(String projectID, String projectName, String precinct, String municipality, String location, String description, long projectManagerID, long groupID, String fundingSource, String contractName) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.precinct = precinct;
        this.municipality = municipality;
        this.location = location;
        this.description = description;
        this.projectManagerID = projectManagerID;
        this.groupID = groupID;
        this.fundingSource = fundingSource;
        this.contractName = contractName;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectID='" + projectID + '\'' +
                ", projectName='" + projectName + '\'' +
                ", precinct='" + precinct + '\'' +
                ", municipality='" + municipality + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", projectManagerID=" + projectManagerID +
                ", groupID=" + groupID +
                ", fundingSource='" + fundingSource + '\'' +
                ", contractName='" + contractName + '\'' +
                '}';
    }

    public long getProjectManagerID() {
        return projectManagerID;
    }

    public void setProjectManagerID(long projectManagerID) {
        this.projectManagerID = projectManagerID;
    }

    public long getGroupID() {
        return groupID;
    }

    public void setGroupID(long groupID) {
        this.groupID = groupID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPrecinct() {
        return precinct;
    }

    public void setPrecinct(String precinct) {
        this.precinct = precinct;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(String fundingSource) {
        this.fundingSource = fundingSource;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }
}
