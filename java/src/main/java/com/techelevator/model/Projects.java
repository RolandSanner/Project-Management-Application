package com.techelevator.model;

public class Projects {

    private long projectID;
    private String projectName;
    private String precinct;
    private String municipality;
    private String location;
    private String description;

    public long getProjectID() {
        return projectID;
    }

    public void setProjectID(long projectID) {
        this.projectID = projectID;
    }


    @Override
    public String toString() {
        return "com.techelevator.model.Project{" +
                "projectID=" + projectID +
                ", projectName='" + projectName + '\'' +
                ", precinct='" + precinct + '\'' +
                ", municipality='" + municipality + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
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
