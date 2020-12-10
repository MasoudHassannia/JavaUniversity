package com.company.person;

import java.util.List;

public class Master extends Person {
    private List<Student> studentsList;

    public Master(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }


}
