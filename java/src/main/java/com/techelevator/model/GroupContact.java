package com.techelevator.model;

public class GroupContact {
    private int contact_id;
    private int group_id;

    public GroupContact() {
    }

    public GroupContact(int contact_id, int group_id) {
        this.contact_id = contact_id;
        this.group_id = group_id;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }
}
