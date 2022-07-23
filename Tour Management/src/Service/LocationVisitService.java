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
public class LocationVisitService {
            private Connection connection = JDBCConnection.getConnection();
            public String getVisitPlaceById(String id){
            String sql = " Select * from LocationVisit where IdRandomVisit='" + id +"'";
            String addressVisit = null;
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
                    addressVisit = resultSet.getString("VisitPlace");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return addressVisit;
        }
      
}
