package com.company;

import com.company.dao.MasterImpl;
import com.company.dao.StudentImpl;
import com.company.person.Master;
import com.company.person.Person;
import com.company.person.Student;

public class Main {

    public static void main(String[] args) {

        StudentImpl studentImpl = new StudentImpl();
        MasterImpl masterImpl = new MasterImpl();

        studentImpl.insertRecord(new Person("mahdi","ahmadi"));
        masterImpl.insertRecord(new Master("Behnam","salili"));

        studentImpl.updateRecord(new Person("masoud","hassannia"),2);







    }
}
