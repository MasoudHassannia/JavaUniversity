package com.company;

public class MasterStudent {
    private int ID;
    private int masterID;
    private int studentID;

    public MasterStudent( int masterID, int studentID) {

        this.masterID = masterID;
        this.studentID = studentID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMasterID() {
        return masterID;
    }

    public void setMasterID(int masterID) {
        this.masterID = masterID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
