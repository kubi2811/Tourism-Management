/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connect.JDBCConnection;
import Entity.Tour;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author hieut
 */
public class StaffService {

    private Connection connection = JDBCConnection.getConnection();

    public void createTour(Tour tour) {
        String sql = "INSERT INTO TOUR(TourName,DayStart,DayEnd,CostAdo,CostChild) values(?,?,?,?,?)";
        java.util.Date dateStart = tour.getDayStart();
        java.sql.Date sqlDateStart = new java.sql.Date(dateStart.getTime());
        java.util.Date dateEnd = tour.getDayEnd();
        java.sql.Date sqlDateEnd = new java.sql.Date(dateEnd.getTime());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tour.getTour());
            preparedStatement.setDate(2, sqlDateStart);
            preparedStatement.setDate(3, sqlDateEnd);
            preparedStatement.setDouble(4, tour.getCostAdo());
            preparedStatement.setDouble(5, tour.getCostChild());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateUsernameStaff(String idStaff, String Username) {
        String sql = "update Staff set Username = '" + Username + "' where idStaff = " + idStaff;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateFullnameStaff(String idStaff, String Fullname) {
        String sql = "update Staff set FullName = '" + Fullname + "' where idStaff = " + idStaff;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePasswordStaff(String idStaff, String Password) {
        String sql = "update Staff set Password = '" + Password + "' where idStaff = " + idStaff;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public int getIdDescription(String nameTour) {
        int IdDescription = 0;
        String sql = "Select * from Description where IdDescription = '" + nameTour + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                IdDescription = Integer. valueOf(resultSet.getString("IdDescription"));
            }} catch (Exception e) {
            e.printStackTrace();
        }
        
        return IdDescription;
    }
}
