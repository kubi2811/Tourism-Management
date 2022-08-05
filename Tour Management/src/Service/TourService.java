/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connect.JDBCConnection;
import Entity.OrderDetail;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieut
 */
public class TourService {

    private Connection connection = JDBCConnection.getConnection();
    private ClientService clientService = null;
            

    public String getDescription(String id) {
        String description = null;
        try {
            Statement statement = connection.createStatement();
            String sql = " Select Description from Tour where idTour = '"+ id + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                description = resultSet.getString("Description");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return description;
    }
    public String getNameTourByIdTour(String id){
        String nameTour = null;
        try {
            Statement statement = connection.createStatement();
            String sql = " Select TourName from Tour where idTour'"+ id + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                nameTour = resultSet.getString("TourName");
            }   
        } catch (Exception e) {
            e.getMessage();
        }
        return nameTour;
    }
    public List<OrderDetail> getMyTour(){
        List<OrderDetail> myTours = new ArrayList<>();
        String sql = "select * from OrderDetail" ;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                OrderDetail orderDetail = new OrderDetail(resultSet.getString("IdOrderDetail"),resultSet.getString("IdOrder"), resultSet.getString("IdClient"), resultSet.getString("Tour"), resultSet.getInt("Adluts"), resultSet.getInt("Childs"));
                myTours.add(orderDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myTours;
    }
    public List<String> getListTourName (){
        List<String> listTour = new ArrayList<>();
        String sql = "Select * from Tour";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                listTour.add(resultSet.getString("TourName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTour;
    }
    public double getCostAdoByName(String nameTour){
        String sql = " select * from Tour where TourName =N'"+nameTour+"'";
        double cost = 0.0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                cost = resultSet.getDouble("CostAdo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
                
        return cost;
    }
     public double getCostChildByName(String nameTour){
        String sql = " select * from Tour where TourName = N'"+nameTour+"'";
        double cost = 0.0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                cost = resultSet.getDouble("CostChild");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
                
        return cost;
    }
  
}
