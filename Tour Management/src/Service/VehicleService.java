/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connect.JDBCConnection;
import Entity.Vehicle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author hieut
 */
public class VehicleService {

    private Connection connection = JDBCConnection.getConnection();

    public String getTransportById(int idLocation) {
        String vehicle = null;
        String sql = "Select * from Vehicle where IdLocationStart= " + idLocation;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                vehicle = resultSet.getString("Transport");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicle;
    }
    
    public int getIdLocationStartByProviceAndTour(String tour, String province){
        int idLocation = 0;
        String sql = "Select * from LocationStart where Tour = N'" + tour + "' AND Province = N'" + province + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                idLocation = Integer.valueOf(resultSet.getString("IdLocationStart"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idLocation;
    }
}
