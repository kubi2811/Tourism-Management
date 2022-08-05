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
    
    public long getTotalREvenuebyMonth(int month){
        String sql = "select * from OrderTour";
        long total = 0L;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                if(resultSet.getDate("createDate").getMonth()+ 1 == month){
                    total += (long)resultSet.getDouble("Total");
                }
            }         
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
    public long getTotalChiByMonth(int month){
        String sql = "select * from Descriptions";
        long total = 0 ;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                if(month == resultSet.getDate("CreateDate").getMonth() + 1){
                    total += (long)resultSet.getDouble("Total");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
    public long getTotalREvenue(){
        String sql  = " select SUM(TotalEvenue) as Total from OrderTour";
        long total = 0L ;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                total = (long)resultSet.getDouble("TotalEvenue");
            }
        
        
        } catch (Exception e) {
            e.printStackTrace();
                  
        }
        return total;
    }
    public long getTotalDes(){
        String sql = "select SUM(Total) as TotalPrice from Descriptions";
        long total = 0 ;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                total = (long)resultSet.getDouble("TotalPrice");
            }
        } catch (Exception e) {
            e.printStackTrace();
                    
        }
        return total;
    }
    
         
}
