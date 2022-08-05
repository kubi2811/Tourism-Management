/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connect.JDBCConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieut
 */
public class LocationStartService {

    private Connection connection = JDBCConnection.getConnection();

    public List<String> getAddressStartByName(String nameTour) {
        List<String> listStart = new ArrayList<>();
        String sql = " Select * from LocationStart where Tour = N'" + nameTour + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                listStart.add(resultSet.getString("Province"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStart;
    }
    public int getIDByNameStart(String name){
        String sql = "select * from LocationStart where Province = N'" + name + "'";
        int id = 0 ;
         try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                id  =  resultSet.getInt("IdLocationStart");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public String getAddressStartByName2(String nameTour) {
        String listStart = null;
        String sql = " Select * from LocationStart where Tour = N'" + nameTour + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                listStart = resultSet.getString("Province");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStart;
    }
}
