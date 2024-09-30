package laba4.service;

import laba4.model.Repair;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepairService {
    private Connection connection;

    public RepairService() {
        String url = "jdbc:mysql://localhost:3306/repair?useSSL=false";
        String username = "root";
        String password = "root";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Repair> getAllRepair() {
        List<Repair> requests = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM repair");

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String problemSubject = resultSet.getString("problem_subject");
                String description = resultSet.getString("description");

                Repair repair = new Repair(id, problemSubject, description);
                requests.add(repair);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return requests;
    }

    public void addRepair(Repair repair) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO requests (problem_subject, description) VALUES (?, ?)"
            );
            statement.setString(1, repair.getProblemSubject());
            statement.setString(2, repair.getDescription());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRepair(Repair updatedRequest) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE repair SET problem_subject = ?, description = ? WHERE id = ?"
            );
            statement.setString(1, updatedRequest.getProblemSubject());
            statement.setString(2, updatedRequest.getDescription());
            statement.setLong(3, updatedRequest.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRepair(long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM repair WHERE id = ?"
            );
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
