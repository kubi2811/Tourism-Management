/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FormStaff;

import Connect.JDBCConnection;
import Entity.DescriptionDetail;
import Entity.Tour;
import Form.MainMenuStaff;
import Service.DescriptionService;
import Service.StaffService;
import Service.TourService;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ranco
 */
public class ManageTrips extends javax.swing.JPanel {
    private Connection connection = JDBCConnection.getConnection();
    private StaffService staffService = new StaffService();
    private DescriptionService descriptionService = new DescriptionService();
    private TourService tourService = new TourService();
    static String idTour;
    static int idDescription;
    public static String tourName;
    

    /**
     * Creates new form ManageTrips
     */
    public ManageTrips() {
        initComponents();
        showInfoManageTrips();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ManageTripsCard = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        TourName = new javax.swing.JTextField();
        CostAdo = new javax.swing.JTextField();
        CostChild = new javax.swing.JTextField();
        Des = new javax.swing.JButton();
        ListTourName = new javax.swing.JComboBox<>();
        DayStart = new com.toedter.calendar.JDateChooser();
        DayEnd = new com.toedter.calendar.JDateChooser();
        CreateDescriptionCard = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        IdDescription = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        NameDescription = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Adults = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Childs = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Incurred = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        addDescription = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TourName", "DayStart", "DayEnd", "Costado", "CostChild"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Tour Name");

        jLabel2.setText("Date Start");

        jLabel3.setText("Date End");

        jLabel4.setText("Cost Ado");

        jLabel5.setText("Cost Child");

        jButton1.setText("Create Tour");
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

        TourName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TourNameActionPerformed(evt);
            }
        });

        Des.setText("Go to add Description");
        Des.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DesMouseClicked(evt);
            }
        });

        ListTourName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        ListTourName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListTourNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ManageTripsCardLayout = new javax.swing.GroupLayout(ManageTripsCard);
        ManageTripsCard.setLayout(ManageTripsCardLayout);
        ManageTripsCardLayout.setHorizontalGroup(
            ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageTripsCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(ManageTripsCardLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageTripsCardLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(ManageTripsCardLayout.createSequentialGroup()
                                .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ManageTripsCardLayout.createSequentialGroup()
                                        .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(37, 37, 37)
                                        .addComponent(TourName))
                                    .addGroup(ManageTripsCardLayout.createSequentialGroup()
                                        .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ListTourName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(55, 55, 55)
                                        .addComponent(Des)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(ManageTripsCardLayout.createSequentialGroup()
                                        .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(ManageTripsCardLayout.createSequentialGroup()
                                                .addGap(96, 96, 96)
                                                .addComponent(DayStart, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(CostAdo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(ManageTripsCardLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DayEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(ManageTripsCardLayout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                                .addComponent(CostChild, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(46, 46, 46))))))
        );
        ManageTripsCardLayout.setVerticalGroup(
            ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageTripsCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TourName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(DayStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DayEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(CostAdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CostChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Des)
                    .addComponent(ListTourName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(262, Short.MAX_VALUE))
        );

        add(ManageTripsCard, "card01");

        CreateDescriptionCard.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("IdDesctiption : ");

        IdDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdDescriptionActionPerformed(evt);
            }
        });

        jLabel7.setText("NameDescription");

        jLabel8.setText("Adults");

        Adults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdultsActionPerformed(evt);
            }
        });

        jLabel9.setText("Childs");

        jLabel10.setText("Incurred");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name Description", "Adults", "Childs", "Incurred", "Total"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        addDescription.setText("Add");
        addDescription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addDescriptionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout CreateDescriptionCardLayout = new javax.swing.GroupLayout(CreateDescriptionCard);
        CreateDescriptionCard.setLayout(CreateDescriptionCardLayout);
        CreateDescriptionCardLayout.setHorizontalGroup(
            CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(Adults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(Childs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                                    .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addGap(39, 39, 39)
                                    .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(IdDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NameDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Incurred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(150, 150, 150))
                            .addComponent(addDescription, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(223, Short.MAX_VALUE))
        );
        CreateDescriptionCardLayout.setVerticalGroup(
            CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(IdDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(NameDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Adults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(Childs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Incurred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addDescription)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(CreateDescriptionCard, "card02");
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
//                 DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//                int index = jTable1.getSelectedRow();
//                String idOfTour = jTable1.getValueAt(index, 0).toString();
//                TourService tourService = new TourService();
//                TourEdit.setText(tourService.getNameTourByIdTour(idOfTour));
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        Date dateStart = DayStart.getDate();
        Date dateEnd = DayEnd.getDate();
        Tour tour = new Tour(TourName.getText(),dateStart,dateEnd,Double.parseDouble(CostAdo.getText()),Double.parseDouble(CostChild.getText()));
        staffService.createTour(tour);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TourNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TourNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TourNameActionPerformed

    private void DesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DesMouseClicked
        // TODO add your handling code here:
//        idDescription = descriptionService.getIdDescriptionByTourName(String.valueOf(ListTourName.getSelectedItem()));
//        CreateDescriptionForm createDescriptionForm = new CreateDescriptionForm();
//        createDescriptionForm.setVisible(true);
//
        CardLayout cards = (CardLayout)(this.getLayout());
        cards.show(this, "card02");
        tourName = String.valueOf(ListTourName.getSelectedItem());
    }//GEN-LAST:event_DesMouseClicked

    private void ListTourNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListTourNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListTourNameActionPerformed

    private void IdDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdDescriptionActionPerformed

    private void AdultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdultsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdultsActionPerformed

    private void addDescriptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addDescriptionMouseClicked
        // TODO add your handling code here:
        DescriptionDetail descriptionDetail = new DescriptionDetail(ManageTrips.idDescription, NameDescription.getText(),Integer.parseInt(Adults.getText()) , Integer.parseInt(Childs.getText()), Double.parseDouble(Incurred.getText()));
        descriptionService.createDescriptionDetail(descriptionDetail);

    }//GEN-LAST:event_addDescriptionMouseClicked
    public void showInfoManageTrips(){
         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try {
            String sql = "select * from Tour";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Vector vector = new Vector();
                vector.add(resultSet.getString("TourName"));
                vector.add(resultSet.getString("DayStart"));
                vector.add(resultSet.getString("DayEnd"));
                vector.add(resultSet.getString("CostAdo"));
                vector.add(resultSet.getString("CostChild"));
                model.addRow(vector);                  
            }
        } catch (Exception e) {
            e.getMessage();
        }
        List<String> listTour = tourService.getListTourName();
        for(String tourName : listTour){
            ListTourName.addItem(tourName);
        }
    }
    
    public void showDescription(){
         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try {
            String sql = "select * from DescriptionDetail where idDescription ='" + ManageTrips.idDescription +"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
               
                    Vector vector = new Vector();
                    vector.add(resultSet.getString("nameDescription"));
                    vector.add(resultSet.getString("Adults"));
                    vector.add(resultSet.getString("Childs"));
                    vector.add(resultSet.getString("Incurred"));
                    vector.add(resultSet.getString("Total"));   
                    model.addRow(vector);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Adults;
    private javax.swing.JTextField Childs;
    private javax.swing.JTextField CostAdo;
    private javax.swing.JTextField CostChild;
    private javax.swing.JPanel CreateDescriptionCard;
    private com.toedter.calendar.JDateChooser DayEnd;
    private com.toedter.calendar.JDateChooser DayStart;
    private javax.swing.JButton Des;
    private javax.swing.JTextField IdDescription;
    private javax.swing.JTextField Incurred;
    private javax.swing.JComboBox<String> ListTourName;
    private javax.swing.JPanel ManageTripsCard;
    private javax.swing.JTextField NameDescription;
    private javax.swing.JTextField TourName;
    private javax.swing.JButton addDescription;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
