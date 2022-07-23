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
public class VehicleService {
        private Connection connection = JDBCConnection.getConnection();
        public  String getTransportById(String idVehicle){
        String vehicle = null;
            String sql = "Select * from Vehicle where idRandomVehicle = '"+idVehicle+"'";
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
                    vehicle = resultSet.getString("Transport");
           
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return vehicle;
        }
}
