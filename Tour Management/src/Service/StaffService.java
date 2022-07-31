/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connect.JDBCConnection;
import Entity.Tour;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

/**
 *
 * @author hieut
 */
public class StaffService {
    private Connection connection = JDBCConnection.getConnection();
    
    public void createTour(Tour tour){
        String sql = "INSERT INTO TOUR(TourName,DayStart,DayEnd,CostAdo,CostChild) values(?,?,?,?,?)";
         java.util.Date dateStart  = tour.getDayStart();
         java.sql.Date sqlDateStart = new java.sql.Date(dateStart.getTime());
         java.util.Date dateEnd  = tour.getDayEnd();
         java.sql.Date sqlDateEnd = new java.sql.Date(dateEnd.getTime());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,tour.getTour());
            preparedStatement.setDate(2,sqlDateStart );
            preparedStatement.setDate(3, sqlDateEnd);
            preparedStatement.setDouble(4,tour.getCostAdo());
            preparedStatement.setDouble(5, tour.getCostChild());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   
}
