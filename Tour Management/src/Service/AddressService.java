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
 * @author ranco
 */
public class AddressService {
    private Connection connection = JDBCConnection.getConnection();
        public  String getAddressByUsername(String Username){
        String getNumber = null;
        String getStreet = null;
        String getWard = null;
        String getCity = null;
        String getprovince = null;
        String Address = null;
            String sql = "Select * from UserAddress where Username = '"+Username+"'";
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                
                while(resultSet.next()){
                    getNumber = resultSet.getString("number");
                    getStreet = resultSet.getString("street");
                    getWard = resultSet.getString("ward");
                    getCity = resultSet.getString("city");
                    getprovince = resultSet.getString("provience");
                }
                
                Address = getNumber + " " + getStreet + ", " + getWard + ", " + getCity + ", " + getprovince;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Address;
        }
}
