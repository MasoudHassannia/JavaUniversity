package com.company;

import java.util.List;

public class Master extends Person implements Table {
    private List<Student> studentsList;

    public Master(String firstName, String lastName) {
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
