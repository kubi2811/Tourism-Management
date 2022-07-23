/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connect.JDBCConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author hieut
 */
public class TourService {

    private Connection connection = JDBCConnection.getConnection();

    public String getDescription(String id) {
        String description = null;
        try {
            Statement statement = connection.createStatement();
            String sql = " Select Description from Tour where idTour = '" + id + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                description = resultSet.getString("Description");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return description;
    }
}
