/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FormClient;

import Connect.JDBCConnection;
import Entity.Vehicle;
import Form.Login;
import Service.ClientService;
import Service.DescriptionService;
import Service.LocationStartService;
import Service.LocationVisitService;
import Service.OrderTourService;
import Service.StaffService;
import Service.TourService;
import Service.VehicleService;
import static java.lang.String.valueOf;
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
    private ClientService clientService = new ClientService();
    private LocationVisitService locationVisitService = new LocationVisitService();
    private LocationStartService locationStartService = new LocationStartService();
    private OrderTourService orderTourService = new OrderTourService();
    private TourService tourService = new TourService();
    static String nameTour;
    public static String idClient;
    private DescriptionService descriptionService = new DescriptionService();
    public String listTourNameVar;

    /**
     * Creates new form ClientAllTrips
     */
    public BookTripNow() {
        initComponents();
        List<String> listTour = tourService.getListTourName();
        for (String tourName : listTour) {
            TourDescription.addItem(tourName);
        }
        ShowListTour();
        showDes();

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
        Adults = new javax.swing.JTextField();
        Childs = new javax.swing.JTextField();
        TourDescription = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        OrderTourCbx = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdTour", "Tour Name", "DayStart", "DayEnd", "Address Start", "Vehicle"
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

        Adults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdultsActionPerformed(evt);
            }
        });

        TourDescription.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        TourDescription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TourDescriptionMouseClicked(evt);
            }
        });
        TourDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TourDescriptionActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Detail Description"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        OrderTourCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 255));
        jLabel10.setText("Number of Adult");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 255));
        jLabel11.setText("Number of Child");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 255));
        jLabel12.setText("Chose Tour you want to Order");

        deleteBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(153, 153, 255));
        deleteBtn.setText("Register Tour");
        deleteBtn.setBorder(new javax.swing.border.MatteBorder(null));
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 255));
        jLabel13.setText("Chose for Detail");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(136, 136, 136)
                                    .addComponent(jLabel10))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))))
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Adults, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                        .addComponent(Childs)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(OrderTourCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(TourDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TourDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OrderTourCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Adults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Childs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
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

        nameTour = tourService.getNameTourByIdTour(temp);


    }//GEN-LAST:event_jTable1MouseClicked

    private void AdultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdultsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdultsActionPerformed

    private void TourDescriptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TourDescriptionMouseClicked
        // TODO add your handling code here:

   
       


    }//GEN-LAST:event_TourDescriptionMouseClicked

    private void TourDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TourDescriptionActionPerformed
        // TODO add your handling code here:
        listTourNameVar = (String) TourDescription.getSelectedItem();
        showDes();
    }//GEN-LAST:event_TourDescriptionActionPerformed

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
        // TODO add your handling code here:
        int numberOfAdo = Integer.parseInt(Adults.getText());
        int numberOfChilds = Integer.parseInt(Childs.getText());
        orderTourService.OrderTour(Login.IdClient);
        int idOrder = orderTourService.findDifferIdOrder(Login.IdClient);

        orderTourService.OrderTourDetail(idOrder, Login.IdClient, String.valueOf(OrderTourCbx.getSelectedItem()), numberOfAdo, numberOfChilds);
        orderTourService.OrderStatusTour(orderTourService.getIdOrderByIdClient(Login.IdClient), clientService.getFullNameById(Login.IdClient), "Chua thanh toán");


        JOptionPane.showMessageDialog(null, "You are registed successfully");
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteBtnActionPerformed
    public void ShowListTour() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        VehicleService vehicle = new VehicleService();
        try {
            String sql = "select * from Tour";
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                for (String s : locationStartService.getAddressStartByName(resultSet.getString("TourName"))) {
                    Vector vector = new Vector();
                    vector.add(resultSet.getString("IdTour"));
                    vector.add(resultSet.getString("TourName"));
                    vector.add(resultSet.getString("DayStart"));
                    vector.add(resultSet.getString("DayEnd"));
                    vector.add(s);
                    vector.add(vehicleService.getTransportById(locationStartService.getIDByNameStart(s)));                
                    model.addRow(vector);     
                    System.out.println(vehicleService.getTransportById(locationStartService.getIDByNameStart(s)));
//                    vector.add(vehicleService.getTransportById(locationStartService.getIDByNameStart(s)));
                        System.out.println(vehicle.getIdLocationStartByProviceAndTour(resultSet.getString("TourName"), locationStartService.getAddressStartByName2(resultSet.getString("TourName"))));
//                    System.out.println(String.valueOf(vehicle.getTransportById(vehicle.getIdLocationStartByProviceAndTour(resultSet.getString("TourName"), s))));
                    vector.add(String.valueOf(vehicle.getTransportById(vehicle.getIdLocationStartByProviceAndTour(resultSet.getString("TourName"), s))));
                    model.addRow(vector);

                }

            }
        } catch (Exception e) {
            e.getMessage();
        }
        List<String> listTour = tourService.getListTourName();
        for (String tourName : listTour) {
            OrderTourCbx.addItem(tourName);
        }
    }

    public void showDes() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);

        int numberIdDescription;
        StaffService temp = new StaffService();
        numberIdDescription = temp.getIdDescription(listTourNameVar);

        try {
            String sql = "select * from DescriptionDetail where idDescription ='" + numberIdDescription + "'";
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                Vector vector = new Vector();
                vector.add(resultSet.getString("nameDescription"));
                System.out.println(resultSet.getString("nameDescription"));
                model.addRow(vector);
            }
        } catch (Exception e) {
            e.getMessage();
        }
//        List<String> listTour = tourService.getListTourName();
//        for (String tourName : listTour) {
//            TourDescription.addItem(tourName);
//        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Adults;
    private javax.swing.JTextField Childs;
    private javax.swing.JComboBox<String> OrderTourCbx;
    private javax.swing.JComboBox<String> TourDescription;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
