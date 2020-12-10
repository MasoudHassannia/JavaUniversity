package com.company.person;

import java.util.List;

public class Student extends Person {
    private List<Master> mastersList;


    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public List<Master> getMastersList() {
        return mastersList;
    }

    public void setMastersList(List<Master> mastersList) {
        this.mastersList = mastersList;
    }
}
