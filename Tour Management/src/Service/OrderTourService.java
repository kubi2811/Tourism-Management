/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connect.JDBCConnection;
import Entity.Tour;
import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author hieut
 */
public class OrderTourService {

    private Connection connection = JDBCConnection.getConnection();

    public Tour getTourbyId(String id) {
        String sql = "Select * from Tour where IdTour ='" + id + "'";
        Tour tour = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                tour.setIdTour(resultSet.getString("IdTour"));
                tour.setTour(resultSet.getString("Tour"));
                tour.setDayStart(Date.valueOf(resultSet.getString("DayStart")));
                tour.setDayEnd(Date.valueOf(resultSet.getString("DayEnd")));
                tour.setDiscription(resultSet.getString("Description"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tour;
    }
    public void OrderTour(String id){
    }
}
