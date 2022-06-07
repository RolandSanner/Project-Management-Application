package com.techelevator.model;

public class ProjectContractor {
    private int contractor_id;
    private String project_id;

    public ProjectContractor() {
    }

    public ProjectContractor(int contractor_id, String project_id) {
        this.contractor_id = contractor_id;
        this.project_id = project_id;
    }

    public int getContractor_id() {
        return contractor_id;
    }

    public void setContractor_id(int contractor_id) {
        this.contractor_id = contractor_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }
}
