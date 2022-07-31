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
        String sql = "select Fullname from Client where IdClient ='"+ idClient+"'";
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
    
              
    
}
