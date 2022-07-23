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
public class LocationStartService {
        private Connection connection = JDBCConnection.getConnection();
       
        public String getAddressStartById(String id){
            String sql = " Select * from LocationStart where IdRandomStart='" + id +"'";
            String addressStart = null;
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
                    addressStart = resultSet.getString("Province");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return addressStart;
        }
       

}
