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
public class StaticService {
    private Connection connection = JDBCConnection.getConnection();
    
    public double getTotalREvenuebyMonth(int month){
        String sql = "select * from OrderTour";
        double total = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                if(resultSet.getDate("createDate").getMonth()+ 1 == month){
                    total += resultSet.getDouble("Total");
                }
            }         
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
    public double getTotalREvenue(){
        String sql  = " select SUM(TotalEvenue) as Total from OrderTour";
        double total = 0 ;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                total = resultSet.getDouble("TotalEvenue");
            }
        
        
        } catch (Exception e) {
            e.printStackTrace();
                  
        }
        return total;
    }
         
}
