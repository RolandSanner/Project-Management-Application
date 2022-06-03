package com.techelevator.model;

public class Project {


    private String projectID;
    private String projectName;
    private String precinct;
    private String municipality;
    private String location;
    private String description;
    private long projectManagerID;
    private long groupID;

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public Project() {

    }

    public Project(String projectID, String projectName, String precinct, String municipality, String location, String description, long projectManagerID, long groupID) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.precinct = precinct;
        this.municipality = municipality;
        this.location = location;
        this.description = description;
        this.projectManagerID = projectManagerID;
        this.groupID = groupID;
    }



    @Override
    public String toString() {
        return "com.techelevator.model.Project{" +
                "projectID='" + projectID + '\'' +
                ", projectName='" + projectName + '\'' +
                ", precinct='" + precinct + '\'' +
                ", municipality='" + municipality + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", projectManagerID=" + projectManagerID +
                ", groupID=" + groupID +
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
}
