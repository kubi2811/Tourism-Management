/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connect.JDBCConnection;
import Entity.Tour;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

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

    public void OrderTour(int idClient) {
        try {
            String sql = "INSERT INTO OrderTour (idClient) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idClient);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void OrderTourDetail(int idOrder, int idClient, String nameTour, int audlts, int childs) {
        try {
            String sql = "Insert into OrderDetail(IdOrder,IdClient,Tour,Adluts,Childs) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idOrder);
            preparedStatement.setInt(2, idClient);
            preparedStatement.setString(3, nameTour);
            preparedStatement.setInt(4, audlts);
            preparedStatement.setInt(5, childs);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public void OrderStatusTour(int idOrder, String userClient, String status) {
        try {
            String sql = "insert into OrderStatus(IdOrder,ClientUserName,Status) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idOrder);
            preparedStatement.setString(2, userClient);
            preparedStatement.setString(3, status);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getIdOrderByIdClient(int idClient) {
        int idTour = 0;
        try {
            String sql = "select IdOrder from OrderTour where idClient ='" + idClient + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                idTour = resultSet.getInt("IdOrder");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idTour;
    }

    public int getTotalbyIdOrder(int idOrder) {
        int total = 0;
        try {
            String sql = "select Total from OrderTour where idOrder ='" + idOrder + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                total = (int) (resultSet.getFloat("Total"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public int getIdOrderByName(String nameTour) {
        int idOrder = 0;
        String sql = "select IdOrder from OrderDetail where Tour = N'" + nameTour + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                idOrder = resultSet.getInt("IdOrder");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idOrder;
    }

    public String getNameTourByIdOrder(int idOrder) {
        String sql = "select Tour from OrderDetail where idOrder = '" + idOrder + "'";
        String name = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                name = resultSet.getString("Tour");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    public void updateOrderClient(int idOrder, int numsAdults, int numChilds) {
        String sql = "update OrderDetail set Adluts = ? , Childs = ? where IdOrder = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, numsAdults);
            preparedStatement.setInt(2, numChilds);
            preparedStatement.setInt(3, idOrder);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getNameByIdClient(int id) {
        String sql = "Select * from Client where id = '" + id + "'";
        String name = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                name = resultSet.getString("FullName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    public List<Integer> getIdOrderOnOrderTour(int idClient) {
        List<Integer> list = new ArrayList<>();
        String sql = "select * from OrderTour where idClient = " + idClient;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(resultSet.getInt("IdOrder"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Integer> getIdOrderOnOrderDeTail(int idClient) {
        List<Integer> list = new ArrayList<>();
        String sql = "select * from OrderDetail where idClient = " + idClient;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(resultSet.getInt("IdOrder"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int findDifferIdOrder(int clientId) {
        List<Integer> list2 = getIdOrderOnOrderDeTail(clientId);
        List<Integer> list1 = getIdOrderOnOrderTour(clientId);
        List<Integer> differences = list1.stream()
            .filter(element -> !list2.contains(element))
            .collect(Collectors.toList());
        return differences.get(0);
    }
}
