/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connect.JDBCConnection;
import Entity.DescriptionDetail;
import Entity.Descriptions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author hieut
 */
public class DescriptionService {

    private Connection connection = JDBCConnection.getConnection();

    public void createDescription(Descriptions descriptions) {
        String sql = "insert into Descriptions(Tour , Total) values (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, descriptions.getTour());
            preparedStatement.setDouble(2, 0);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createDescriptionDetail(DescriptionDetail descriptionDetail) {
        String sql = "insert into DescriptionDetail(IdDescription , nameDescription,Adults,Childs,Incurred,Total) values (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, descriptionDetail.getIdDescription());
            preparedStatement.setString(2, descriptionDetail.getNameDescription());
            preparedStatement.setInt(3, descriptionDetail.getAdults());
            preparedStatement.setInt(4, descriptionDetail.getChilds());
            preparedStatement.setDouble(5, descriptionDetail.getInccurred());
            preparedStatement.setDouble(6, descriptionDetail.getTotal());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getIdDescriptionByTourName(String tourName){
        String sql = "select idDescription from Descriptions where Tour ='"+ tourName +"'";
        int id = 0 ;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                id = resultSet.getInt("idDescription");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}