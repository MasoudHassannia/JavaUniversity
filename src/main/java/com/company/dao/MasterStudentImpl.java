package com.company.dao;

import com.company.MasterStudent;
import com.company.person.Person;

import java.sql.*;

public class MasterStudentImpl {
    private final String address = "jdbc:mysql://localhost/university";
    private final String user = "root";
    private final String password = "0135790";

    public void createTable() {
        try (Connection connection = DriverManager.getConnection(address, user, password);
             Statement statement = connection.createStatement();) {
            String student = "Create Table IF NOT EXISTS master_student (" +
                    "id int primary key auto_increment," +
                    "master_ID int NOT NULL," +
                    "student_ID int NOT NULL)";

            statement.executeUpdate(student);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void insertRecord(MasterStudent masterStudent) {
        try (Connection connection = DriverManager.getConnection(address, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO master_student (master_ID,student_ID) VALUES(?,?)");) {
            preparedStatement.setInt(1, masterStudent.getMasterID());
            preparedStatement.setInt(2, masterStudent.getStudentID());
            preparedStatement.executeUpdate();
            System.out.println("New MasterStudent Added!");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void deleteRecord(int id) {
        try (Connection connection = DriverManager.getConnection(address, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM master_student WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("MasterStudent with ID " + id + " deleted!");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }



}
