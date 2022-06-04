package com.techelevator.model;

public class Group {

    private int groupID;
    private String groupName;
    private int program_manager_id;

    public Group() {
    }

    public Group(int groupID, String groupName, int program_manager_id) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.program_manager_id = program_manager_id;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getProgram_manager_id() {
        return program_manager_id;
    }

    public void setProgram_manager_id(int program_manager_id) {
        this.program_manager_id = program_manager_id;
    }
}
