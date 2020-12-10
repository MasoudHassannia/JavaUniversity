package com.company;

import com.company.dao.StudentImpl;
import com.company.person.Student;

public class Main {

    public static void main(String[] args) {
        Student student = new Student("mehdi","alavai");
        StudentImpl studentImpl = new StudentImpl();

        studentImpl.insertRecord(student);

    }
}
