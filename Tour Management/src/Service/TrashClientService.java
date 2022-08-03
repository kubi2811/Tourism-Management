/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connect.JDBCConnection;
import Form.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hieut
 */
public class TrashClientService {
    private Connection connection = JDBCConnection.getConnection();
    private OrderTourService orderTourService = new OrderTourService();
    private TourService tourService = new TourService();
    public boolean checkTourDelete(int idOrder){
        String sql = "select IsDelete from OrderTour where idOrder ='" + idOrder +"'";
        int check = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                if(resultSet.getInt("IsDelete") == 0 ){
                    check = 1;
                }
            }      
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(check == 1 ) return false;
        return true;   
    }
    public void safeDelete(int idOrder){
        String sql= "update OrderTour set IsDelete = ? where IdOrder ='"+idOrder+"'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void reStoreTour(int idOrder){
         String sql= "update OrderTour set IsDelete = ? where IdOrder ='"+idOrder+"'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void destroyTour(int idOrder){
        String sql = "delete from OrderTour where IdOrder ='"+idOrder+"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                 JOptionPane.showMessageDialog(null, "Delete successfull");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public List<String> getListTrash(){
//        List<String> nameTours = new ArrayList<>();
//        try {
//           
//        } catch (Exception e) {
//        }
//    }
    public List<Integer> getListIdOrderDelete(int delete){
        List<Integer> listIdOrder = new ArrayList<>();
        try {
               String sql = "select * from OrderTour where IsDelete = '"+delete+"' and IdClient ='" +Login.IdClient+"'";
               Statement statement = connection.createStatement();
               ResultSet resultSet = statement.executeQuery(sql);
               while(resultSet.next()){
                   listIdOrder.add(resultSet.getInt("IdOrder"));
               }
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listIdOrder;
    }
    public List<String> getListNameTourTrash(int delete){
        List<String> names = new ArrayList<>();
        for(int id : getListIdOrderDelete(delete)){
            String name = orderTourService.getNameTourByIdOrder(id);
            names.add(name);
        }
        return names;
    }
}
