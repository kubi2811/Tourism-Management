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
    public String getFullNameById(String idClient){
        String fullname = null;
        String sql = "select Fullname from Client where IdClient =N'"+ idClient+"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                fullname = resultSet.getString("FullName");
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fullname;
    }
    
              
    public boolean updateClientInformation(String idClient, String name, String phone, String gmail) {
        String sql = "update Client set Fullname = '" + name +"',Phone ='" + phone +"', Email = N'" + gmail + "' where idClient = " + idClient;
        try{
//            PreparedStatement preparedStatement = connection.prepareStatement(sql); 
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
