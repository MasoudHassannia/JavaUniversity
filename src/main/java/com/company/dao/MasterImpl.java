package com.company.dao;

import com.company.Table;
import com.company.person.Person;

import java.sql.*;

public class MasterImpl implements Table {
    private final String address = "jdbc:mysql://localhost/university";
    private final String user = "root";
    private final String password = "0135790";

    @Override
    public void createTable() {
        try (Connection connection = DriverManager.getConnection(address, user, password);
             Statement statement = connection.createStatement();) {
            String master = "Create Table IF NOT EXISTS master (" +
                    "id_master int primary key auto_increment," +
                    "first_name varChar(55) NOT NULL," +
                    "last_name varChar(55) NOT NULL)";

            statement.executeUpdate(master);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    @Override
    public void insertRecord(Person person) {
        try (Connection connection = DriverManager.getConnection(address, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO master (first_name,last_name) VALUES(?,?)");) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.executeUpdate();
            System.out.println("New master Added!");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    @Override
    public void deleteRecord(int id) {
        try (Connection connection = DriverManager.getConnection(address, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM master WHERE id_master = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Master with ID " + id + " deleted!");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    @Override
    public void updateRecord(Person person, int id) {
        try (Connection connection = DriverManager.getConnection(address, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE master SET first_name = ?,last_name = ?,  WHERE id_master = ?");) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
            System.out.println("Updated!");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
}
