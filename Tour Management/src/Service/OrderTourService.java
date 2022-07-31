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
import java.sql.PreparedStatement;
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tour;
    }

    public void OrderTour(String idClient) {
        try {
            String sql = "INSERT INTO OrderTour (idClient) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,idClient);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void OrderTourDetail(String idOrder, String idClient , String nameTour , int audlts , int childs){
        try {
            String sql = "Insert into OrderDetail(IdOrder,IdClient,Tour,Adluts,Childs) values(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, idOrder);
            preparedStatement.setString(2,idClient);
            preparedStatement.setString(3,nameTour);
            preparedStatement.setInt(4,audlts);
            preparedStatement.setInt(5,childs);
            preparedStatement.execute();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void OrderStatusTour(String idOrder , String status){
        try {
            String sql = "insert into OrderStatus(IdOrder,Status) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,idOrder);
            preparedStatement.setString(2,status);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getIdOrderByIdClient ( String idClient){ 
        String idTour  = null;
        try {
            String sql = "select IdOrder from OrderTour where idClient ='" + idClient +"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){                
                idTour = resultSet.getString("IdOrder");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          return idTour;
    }
    public int getTotalbyIdOrder(String idOrder){
        int total = 0;
        try {
            String sql = "select Total from OrderTour where idOrder ='"+idOrder+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                total = (int)(resultSet.getFloat("Total")) ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
    public int getIdOrderByName(String nameTour) {
        int idOrder = 0 ;
        String sql = "select IdOrder from OrderDetail where Tour ='"+nameTour+"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                idOrder = resultSet.getInt("IdOrder");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idOrder;        
    }
    public String getNameTourByIdOrder(int idOrder){
        String sql = "select Tour from OrderDetail where idOrder = '"+idOrder+"'";
        String name = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                name = resultSet.getString("Tour");
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    
}
