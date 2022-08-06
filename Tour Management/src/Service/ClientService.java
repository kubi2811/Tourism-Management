/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connect.JDBCConnection;
import Objects.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieut
 */
public class ClientService {

    private Connection connection = JDBCConnection.getConnection();

    public String getFullNameById(int idClient) {
        String fullname = null;
        String sql = "select * from Client where IdClient = " + idClient;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                fullname = resultSet.getString("Username");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fullname;
    }

    public boolean updateClientInformation(String idClient, String name, String phone, String gmail) {
        String sql = "update Client set Fullname = N'" + name + "',Phone ='" + phone + "', Email = N'" + gmail + "' where idClient = " + idClient;
        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql); 
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void insertClient(String fullname, String phone, String userName, String pass, String Email) {
        String sql = "insert into Client values(?, ? , ?, ? , ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, fullname);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, pass);
            preparedStatement.setString(5, Email);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void updateClient(int Id, String fullname, String phone, String userName, String pass, String Email){
        String sql = "update  Client set Fullname = ?,Phone = ?,  Username = ?, Password = ?, Email = ? where IdClient = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, fullname);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, pass);
            preparedStatement.setString(5, Email);
            preparedStatement.setInt(6, Id);
            preparedStatement.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteRowClient(int id){
        String sql = "delete from Client where IdClient = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
