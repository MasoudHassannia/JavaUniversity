package com.company;

import java.util.List;

public class Student extends Person implements Table {
    private List<Master> mastersList;

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void createTable() {

    }

    @Override
    public void insertRecord(Person person) {

    }

    @Override
    public void deleteRecord(int id) {

    }

    @Override
    public void updateRecord(Person person, int id) {

    }
}
