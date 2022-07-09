/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tour.management;

import Connect.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ranco
 */
public class TourManagement {
    DefaultTableModel tableModel;
    Connection conn = null;
    PreparedStatement pre = null;
    ResultSet rs = null;
    
    public void test(){
         try {
            conn = JDBCConnection.getConnection();
            String sql = "select * from Admin";
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                
                System.out.print(rs.getString("IdAdmin"));
                
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TourManagement helo = new TourManagement();
        helo.test();
    }
    
}
