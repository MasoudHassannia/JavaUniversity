package com.company;

import java.sql.*;
import java.util.List;

public class Student extends Person implements Table {
    private List<Master> mastersList;
    private String address = "jdbc:mysql://localhost/university";
    private String user = "root";
    private String password = "0135790";

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void createTable() {
        try (Connection connection = DriverManager.getConnection(address, user, password);
             Statement statement = connection.createStatement();) {
            String student = "Create Table IF NOT EXISTS student (" +
                    "id_student int primary key auto_increment," +
                    "first_name varChar(55) NOT NULL," +
                    "last_name varChar(55) NOT NULL)";

            statement.executeUpdate(student);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void insertRecord(Person person) {
        try(Connection connection = DriverManager.getConnection(address,user,password);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO student (first_name,last_name) VALUES(?,?)");){
            preparedStatement.setString(1,person.getFirstName());
            preparedStatement.setString(2,person.getLastName());
            preparedStatement.executeUpdate();
            System.out.println("New Student Added!");

        }catch( SQLException sqlException){
            sqlException.printStackTrace();
        }

    }

    @Override
    public void deleteRecord(int id) {
        try(Connection connection = DriverManager.getConnection(address,user,password);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM student WHERE id_student = ?")) {
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Student with ID "+ id +" deleted!");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    @Override
    public void updateRecord(Person person, int id) {
        try(Connection connection = DriverManager.getConnection(address,user,password);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE student SET first_name = ?,last_name = ?,  WHERE id_student = ?");) {
            preparedStatement.setString(1,person.getFirstName());
            preparedStatement.setString(2,person.getLastName());
            preparedStatement.setLong(3,id);
            preparedStatement.executeUpdate();
            System.out.println("Updated!");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
}
