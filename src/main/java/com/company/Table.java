package com.company;

import com.company.person.Person;

public interface Table {

    void createTable();

    void insertRecord(Person person);

    void deleteRecord(int id);

    void updateRecord(Person person,int id);
}
