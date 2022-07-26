/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FormClient;

import Connect.JDBCConnection;
import Entity.Vehicle;
import Form.Login;
import Service.LocationStartService;
import Service.LocationVisitService;
import Service.OrderTourService;
import Service.TourService;
import Service.VehicleService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import static javax.management.remote.JMXConnectorFactory.connect;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ranco
 */
public class BookTripNow extends javax.swing.JPanel {

    private Connection connect = JDBCConnection.getConnection();
    private VehicleService vehicleService = new VehicleService();
    private LocationVisitService locationVisitService = new LocationVisitService();
    private LocationStartService locationStartService = new LocationStartService();
    private OrderTourService orderTourService = new OrderTourService();
    static String nameTour;
    public static String idClient;
    /**
     * Creates new form ClientAllTrips
     */
    public BookTripNow() {
        initComponents();
        ShowListTour();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        Adults = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Childs = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdTour", "Tour Name", "DayStart", "DayEnd", "Address Start", "Address Visit", "Vehicle"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jTable1ComponentHidden(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Register");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Description");

        Adults.setText("jTextField1");
        Adults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdultsActionPerformed(evt);
            }
        });

        jLabel2.setText("Enter number of Ado");

        jLabel3.setText("Enter number of childs");

        Childs.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(description, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(Childs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel3))
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Adults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(167, 167, 167)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Adults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Childs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentHidden
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable1ComponentHidden

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int index = jTable1.getSelectedRow();
        String temp = jTable1.getValueAt(index, 0).toString();
        TourService tourService = new TourService();
        description.setText(tourService.getDescription(temp));
        nameTour = tourService.getNameTourByIdTour(temp) ;
       
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void AdultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdultsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdultsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        int numberOfAdo = Integer.parseInt(Adults.getText());
        int numberOfChilds = Integer.parseInt(Childs.getText()); 
        orderTourService.OrderTour("3");
        orderTourService.OrderTourDetail(orderTourService.getIdOrderByIdClient("3"), "3", nameTour ,numberOfAdo, numberOfChilds);
        orderTourService.OrderStatusTour(orderTourService.getIdOrderByIdClient("3"), "TThai 1");
        JOptionPane.showMessageDialog(null, "You are registed successfully");
    
   
    }//GEN-LAST:event_jButton1MouseClicked
    public void ShowListTour() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try {
            String sql = "select * from Tour";
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
               
                    Vector vector = new Vector();
                    vector.add(resultSet.getString("IdTour"));
                    vector.add(resultSet.getString("TourName"));
                    vector.add(resultSet.getString("DayStart"));
                    vector.add(resultSet.getString("DayEnd"));
                    vector.add(locationStartService.getAddressStartById(String.valueOf(resultSet.getString("TourName"))));
                    vector.add(locationVisitService.getVisitPlaceById(String.valueOf(resultSet.getString("TourName"))));
                    vector.add(vehicleService.getTransportById(resultSet.getString("TourName")));
                    model.addRow(vector);
                  
                
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Adults;
    private javax.swing.JTextField Childs;
    private javax.swing.JLabel description;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
