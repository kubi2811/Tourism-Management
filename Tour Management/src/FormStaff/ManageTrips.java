/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FormStaff;

import Connect.JDBCConnection;
import Entity.DescriptionDetail;
import Entity.Descriptions;
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
import javax.swing.JOptionPane;
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
    public String listTourNameVar;

    /**
     * Creates new form ManageTrips
     */
    public ManageTrips() {
        initComponents();
        showInfoManageTrips();
        tourNameVar.setEnabled(false);
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
        TourName = new javax.swing.JTextField();
        CostAdo = new javax.swing.JTextField();
        CostChild = new javax.swing.JTextField();
        ListTourName = new javax.swing.JComboBox<>();
        DayStart = new com.toedter.calendar.JDateChooser();
        DayEnd = new com.toedter.calendar.JDateChooser();
        activeStaffLabel = new javax.swing.JLabel();
        activeStaffLabel1 = new javax.swing.JLabel();
        activeStaffLabel2 = new javax.swing.JLabel();
        activeStaffLabel3 = new javax.swing.JLabel();
        activeStaffLabel4 = new javax.swing.JLabel();
        deactivateStaffBtn = new javax.swing.JButton();
        deactivateStaffBtn1 = new javax.swing.JButton();
        CreateDescriptionCard = new javax.swing.JPanel();
        descriptionVar = new javax.swing.JTextField();
        adultVar = new javax.swing.JTextField();
        childVar = new javax.swing.JTextField();
        incurredVar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        addDescription = new javax.swing.JButton();
        tourNameVar = new javax.swing.JTextField();
        activeStaffLabel5 = new javax.swing.JLabel();
        activeStaffLabel6 = new javax.swing.JLabel();
        activeStaffLabel7 = new javax.swing.JLabel();
        activeStaffLabel8 = new javax.swing.JLabel();
        activeStaffLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());

        ManageTripsCard.setBackground(new java.awt.Color(255, 255, 255));

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

        TourName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TourNameActionPerformed(evt);
            }
        });

        ListTourName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        ListTourName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListTourNameActionPerformed(evt);
            }
        });

        DayStart.setBackground(new java.awt.Color(255, 255, 255));

        DayEnd.setBackground(new java.awt.Color(255, 255, 255));

        activeStaffLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        activeStaffLabel.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel.setText("Tour Name");

        activeStaffLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        activeStaffLabel1.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel1.setText("Cost Adult");

        activeStaffLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        activeStaffLabel2.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel2.setText("Date Start");

        activeStaffLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        activeStaffLabel3.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel3.setText("Cost Child");

        activeStaffLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        activeStaffLabel4.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel4.setText("Date End");

        deactivateStaffBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        deactivateStaffBtn.setForeground(new java.awt.Color(153, 153, 255));
        deactivateStaffBtn.setText("Create Tour");
        deactivateStaffBtn.setBorder(new javax.swing.border.MatteBorder(null));
        deactivateStaffBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deactivateStaffBtnMouseClicked(evt);
            }
        });

        deactivateStaffBtn1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        deactivateStaffBtn1.setForeground(new java.awt.Color(153, 153, 255));
        deactivateStaffBtn1.setText("Add Description for Tour");
        deactivateStaffBtn1.setBorder(new javax.swing.border.MatteBorder(null));
        deactivateStaffBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deactivateStaffBtn1MouseClicked(evt);
            }
        });
        deactivateStaffBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deactivateStaffBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ManageTripsCardLayout = new javax.swing.GroupLayout(ManageTripsCard);
        ManageTripsCard.setLayout(ManageTripsCardLayout);
        ManageTripsCardLayout.setHorizontalGroup(
            ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageTripsCardLayout.createSequentialGroup()
                .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ManageTripsCardLayout.createSequentialGroup()
                        .addContainerGap(48, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ManageTripsCardLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activeStaffLabel2)
                            .addComponent(activeStaffLabel)
                            .addComponent(activeStaffLabel1))
                        .addGap(41, 41, 41)
                        .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TourName)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageTripsCardLayout.createSequentialGroup()
                                .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DayStart, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                    .addComponent(CostAdo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(activeStaffLabel3)
                                    .addComponent(activeStaffLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DayEnd, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                    .addComponent(CostChild))))))
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageTripsCardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deactivateStaffBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageTripsCardLayout.createSequentialGroup()
                        .addComponent(ListTourName, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(deactivateStaffBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(229, 229, 229))
        );
        ManageTripsCardLayout.setVerticalGroup(
            ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageTripsCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ManageTripsCardLayout.createSequentialGroup()
                        .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TourName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(activeStaffLabel))
                        .addGap(18, 18, 18)
                        .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DayEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(activeStaffLabel2)
                            .addComponent(activeStaffLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activeStaffLabel1)
                            .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CostChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(activeStaffLabel3))))
                    .addGroup(ManageTripsCardLayout.createSequentialGroup()
                        .addComponent(DayStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CostAdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(deactivateStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(ManageTripsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ListTourName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deactivateStaffBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );

        add(ManageTripsCard, "card01");

        CreateDescriptionCard.setBackground(new java.awt.Color(255, 255, 255));

        descriptionVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionVarActionPerformed(evt);
            }
        });

        adultVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adultVarActionPerformed(evt);
            }
        });

        incurredVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incurredVarActionPerformed(evt);
            }
        });

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

        tourNameVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tourNameVarActionPerformed(evt);
            }
        });

        activeStaffLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        activeStaffLabel5.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel5.setText("Tour Name");

        activeStaffLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        activeStaffLabel6.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel6.setText("Description");

        activeStaffLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        activeStaffLabel7.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel7.setText("Incurred");

        activeStaffLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        activeStaffLabel8.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel8.setText("Adults Number");

        activeStaffLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        activeStaffLabel9.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel9.setText("Childs Number");

        javax.swing.GroupLayout CreateDescriptionCardLayout = new javax.swing.GroupLayout(CreateDescriptionCard);
        CreateDescriptionCard.setLayout(CreateDescriptionCardLayout);
        CreateDescriptionCardLayout.setHorizontalGroup(
            CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                        .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(activeStaffLabel5)
                            .addComponent(activeStaffLabel6)
                            .addComponent(activeStaffLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                                .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(descriptionVar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tourNameVar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(73, 73, 73)
                                .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(activeStaffLabel9)
                                    .addComponent(activeStaffLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(adultVar, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(childVar))
                                .addGap(118, 118, 118))
                            .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                                .addComponent(incurredVar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 52, Short.MAX_VALUE))))
            .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(addDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CreateDescriptionCardLayout.setVerticalGroup(
            CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                        .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                                .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tourNameVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(activeStaffLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(activeStaffLabel6)
                                    .addComponent(descriptionVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                                .addComponent(activeStaffLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(activeStaffLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CreateDescriptionCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(activeStaffLabel7)
                            .addComponent(incurredVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CreateDescriptionCardLayout.createSequentialGroup()
                        .addComponent(adultVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(childVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addComponent(addDescription)
                .addGap(60, 60, 60)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
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

    private void TourNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TourNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TourNameActionPerformed

    private void ListTourNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListTourNameActionPerformed
        // TODO add your handling code here:
        listTourNameVar = (String) ListTourName.getSelectedItem();
        tourNameVar.setText((String) ListTourName.getSelectedItem());
    }//GEN-LAST:event_ListTourNameActionPerformed

    private void adultVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adultVarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adultVarActionPerformed

    private void addDescriptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addDescriptionMouseClicked
        // TODO add your handling code here:
//        Descriptions description = new Descriptions(listTourNameVar,0);
//        descriptionService.createDescription(description);

        int numberIdDescription;

        numberIdDescription = staffService.getIdDescription(listTourNameVar);
        int numAdults = Integer.parseInt(adultVar.getText());
        int numChilds = Integer.parseInt(childVar.getText());
        long total = (long) (numAdults * ((long) tourService.getCostAdoByName(listTourNameVar)) * 0.5) + (long) (numChilds * ((long) tourService.getCostChildByName(listTourNameVar)) * 0.5) + (long) Double.parseDouble(incurredVar.getText());
        DescriptionDetail descriptionDetail = new DescriptionDetail(numberIdDescription, descriptionVar.getText(), numAdults, numChilds, Double.parseDouble(incurredVar.getText()), total);
        descriptionService.createDescriptionDetail(descriptionDetail);
//        System.out.println(descriptionDetail.getTotal());
        showDescriptionDetail();

    }//GEN-LAST:event_addDescriptionMouseClicked

    private void descriptionVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionVarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionVarActionPerformed

    private void tourNameVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tourNameVarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tourNameVarActionPerformed

    private void incurredVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incurredVarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_incurredVarActionPerformed

    private void deactivateStaffBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deactivateStaffBtnMouseClicked
        Date dateStart = DayStart.getDate();
        Date dateEnd = DayEnd.getDate();
        Tour tour = new Tour(TourName.getText(), dateStart, dateEnd, Double.parseDouble(CostAdo.getText()), Double.parseDouble(CostChild.getText()));
        staffService.createTour(tour);
        JOptionPane.showMessageDialog(null, "You created Tour successfully !!!");
        showInfoManageTrips();
        showDescriptionDetail();
    }//GEN-LAST:event_deactivateStaffBtnMouseClicked

    private void deactivateStaffBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deactivateStaffBtn1MouseClicked
        // TODO add your handling code here:
        CardLayout cards = (CardLayout) (this.getLayout());
        cards.show(this, "card02");
        listTourNameVar = String.valueOf(ListTourName.getSelectedItem());
        tourName = String.valueOf(ListTourName.getSelectedItem());
        System.out.print(listTourNameVar);
        String sql = "Select Count(Tour) as size from Descriptions where Tour = N'" + listTourNameVar + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (resultSet.getInt("size") == 0) {
                    Descriptions descriptions = new Descriptions(listTourNameVar, 0);
                    descriptionService.createDescription(descriptions);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        showDescriptionDetail();
    }//GEN-LAST:event_deactivateStaffBtn1MouseClicked

    private void deactivateStaffBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deactivateStaffBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deactivateStaffBtn1ActionPerformed
    public void showInfoManageTrips() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
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
        for (String tourName : listTour) {
            ListTourName.addItem(tourName);
        }
    }

    public void showDescriptionDetail() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);

        int numberIdDescription;
        StaffService temp = new StaffService();
        numberIdDescription = temp.getIdDescription(listTourNameVar);

        try {
            String sql = "select * from DescriptionDetail where idDescription ='" + numberIdDescription + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                Vector vector = new Vector();
                vector.add(resultSet.getString("nameDescription"));
                vector.add(resultSet.getString("Adults"));
                vector.add(resultSet.getString("Childs"));
                vector.add(resultSet.getString("Incurred"));
                vector.add(resultSet.getLong("Total"));
                model.addRow(vector);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CostAdo;
    private javax.swing.JTextField CostChild;
    private javax.swing.JPanel CreateDescriptionCard;
    private com.toedter.calendar.JDateChooser DayEnd;
    private com.toedter.calendar.JDateChooser DayStart;
    private javax.swing.JComboBox<String> ListTourName;
    private javax.swing.JPanel ManageTripsCard;
    private javax.swing.JTextField TourName;
    private javax.swing.JLabel activeStaffLabel;
    private javax.swing.JLabel activeStaffLabel1;
    private javax.swing.JLabel activeStaffLabel2;
    private javax.swing.JLabel activeStaffLabel3;
    private javax.swing.JLabel activeStaffLabel4;
    private javax.swing.JLabel activeStaffLabel5;
    private javax.swing.JLabel activeStaffLabel6;
    private javax.swing.JLabel activeStaffLabel7;
    private javax.swing.JLabel activeStaffLabel8;
    private javax.swing.JLabel activeStaffLabel9;
    private javax.swing.JButton addDescription;
    private javax.swing.JTextField adultVar;
    private javax.swing.JTextField childVar;
    private javax.swing.JButton deactivateStaffBtn;
    private javax.swing.JButton deactivateStaffBtn1;
    private javax.swing.JTextField descriptionVar;
    private javax.swing.JTextField incurredVar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField tourNameVar;
    // End of variables declaration//GEN-END:variables
}
