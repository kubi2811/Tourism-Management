/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FormAdmin;

import Connect.JDBCConnection;
import Service.AddressService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ranco
 */
public class CreateStaff extends javax.swing.JPanel {

    private Connection connect = JDBCConnection.getConnection();
    private AddressService addressService = new AddressService();
    
    public static int idAdmin;
    static String usernameAdmin;

    public String getusernameAdmin() {
        return usernameAdmin;
    }

    public void setusernameAdmin(String usernameAdmin) {
        this.usernameAdmin = usernameAdmin;
    }

    public CreateStaff() {
        initComponents();
        CountStaffInfo();
//        System.out.println("Id: " + idAdmin);
//        System.out.println("Username: " + usernameAdmin);
        adminVar.setText(usernameAdmin);
        adminVar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        passVar = new javax.swing.JTextField();
        searchAcBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        adminVar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        nameVar = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        usernameVar = new javax.swing.JTextField();
        countStaffLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 255));
        jLabel12.setText("Password");

        passVar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        passVar.setForeground(new java.awt.Color(153, 153, 255));
        passVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passVarActionPerformed(evt);
            }
        });

        searchAcBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        searchAcBtn.setForeground(new java.awt.Color(153, 153, 255));
        searchAcBtn.setText("Create Staff");
        searchAcBtn.setBorder(new javax.swing.border.MatteBorder(null));
        searchAcBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchAcBtnMouseClicked(evt);
            }
        });
        searchAcBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAcBtnActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 255));
        jLabel13.setText("Admin");

        adminVar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        adminVar.setForeground(new java.awt.Color(153, 153, 255));
        adminVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminVarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 255));
        jLabel14.setText("Full Name");

        nameVar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nameVar.setForeground(new java.awt.Color(153, 153, 255));
        nameVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameVarActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 255));
        jLabel15.setText("Username");

        usernameVar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        usernameVar.setForeground(new java.awt.Color(153, 153, 255));
        usernameVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameVarActionPerformed(evt);
            }
        });

        countStaffLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        countStaffLabel.setForeground(new java.awt.Color(153, 153, 255));
        countStaffLabel.setText("Number of all curent Staff in system now: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminVar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameVar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameVar, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(passVar))
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(countStaffLabel)
                .addGap(0, 111, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(searchAcBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminVar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(usernameVar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(passVar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(nameVar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(searchAcBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(countStaffLabel)
                .addContainerGap(171, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void passVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passVarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passVarActionPerformed

    private void searchAcBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchAcBtnMouseClicked
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            conn = JDBCConnection.getConnection();
            String sql = "insert into Staff values(?,?,?,?,1)";
            pre = conn.prepareStatement(sql);
            pre.setString(1, usernameAdmin);
            pre.setString(2, nameVar.getText());
            pre.setString(3, usernameVar.getText());
            pre.setString(4, passVar.getText());

            pre.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex);
        } finally {
            if (pre != null) {
                try {
                    pre.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi: " + ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi: " + ex);
                }
            }
        }
        CountStaffInfo();
    }//GEN-LAST:event_searchAcBtnMouseClicked

    private void searchAcBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAcBtnActionPerformed

    }//GEN-LAST:event_searchAcBtnActionPerformed

    private void adminVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminVarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminVarActionPerformed

    private void nameVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameVarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameVarActionPerformed

    private void usernameVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameVarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameVarActionPerformed

    public void CountStaffInfo() {
        try {
            String sql = "SELECT COUNT(*) FROM Staff";
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            countStaffLabel.setText("Number of all curent Staff in system now: " + String.valueOf(resultSet.getInt(1)));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adminVar;
    private javax.swing.JLabel countStaffLabel;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JTextField nameVar;
    private javax.swing.JTextField passVar;
    private javax.swing.JButton searchAcBtn;
    private javax.swing.JTextField usernameVar;
    // End of variables declaration//GEN-END:variables
}
