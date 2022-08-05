/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FormStaff;

import Connect.JDBCConnection;
import Form.Login;
import Service.StaffService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author HP
 */
public class StaffInformation extends javax.swing.JPanel {
    private Connection connect = JDBCConnection.getConnection();
    public static int IdStaff = Login.idStaff;
    StaffService staffService = new StaffService();
    /**
     * Creates new form StaffInformation
     */
    public StaffInformation() {
        initComponents();
        System.out.println("Hello staff" + IdStaff);
        ShowStaffInfo();
    }
    
    public void ShowStaffInfo(){
        try {
            String sql = "select * from Staff where IdStaff = N'"+ IdStaff + "'";
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                label_username.setText(resultSet.getString("Username"));
                label_fullname.setText(resultSet.getString("Fullname"));
                label_admin.setText(resultSet.getString("Admin"));
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_username = new javax.swing.JLabel();
        label_fullname = new javax.swing.JLabel();
        label_admin = new javax.swing.JLabel();
        Username_Input = new javax.swing.JTextField();
        Fullname_Input = new javax.swing.JTextField();
        Password_Input = new javax.swing.JPasswordField();
        activeStaffLabel = new javax.swing.JLabel();
        activeStaffLabel1 = new javax.swing.JLabel();
        activeStaffLabel2 = new javax.swing.JLabel();
        activeStaffLabel3 = new javax.swing.JLabel();
        activeStaffLabel4 = new javax.swing.JLabel();
        activeStaffLabel5 = new javax.swing.JLabel();
        activeStaffLabel6 = new javax.swing.JLabel();
        activeStaffLabel7 = new javax.swing.JLabel();
        deactivateStaffBtn = new javax.swing.JButton();
        deactivateStaffBtn1 = new javax.swing.JButton();
        deactivateStaffBtn2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        label_username.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_username.setText("None");

        label_fullname.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_fullname.setText("None");

        label_admin.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_admin.setText("None");

        activeStaffLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        activeStaffLabel.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel.setText("Profile Management");

        activeStaffLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        activeStaffLabel1.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel1.setText("Username:");

        activeStaffLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        activeStaffLabel2.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel2.setText("Fullname:");

        activeStaffLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        activeStaffLabel3.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel3.setText("Your Admin:");

        activeStaffLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        activeStaffLabel4.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel4.setText("Update Profile");

        activeStaffLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        activeStaffLabel5.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel5.setText("Username:");

        activeStaffLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        activeStaffLabel6.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel6.setText("Fulname:");

        activeStaffLabel7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        activeStaffLabel7.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel7.setText("Password:");

        deactivateStaffBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        deactivateStaffBtn.setForeground(new java.awt.Color(153, 153, 255));
        deactivateStaffBtn.setText("Update");
        deactivateStaffBtn.setBorder(new javax.swing.border.MatteBorder(null));
        deactivateStaffBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deactivateStaffBtnMouseClicked(evt);
            }
        });
        deactivateStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deactivateStaffBtnActionPerformed(evt);
            }
        });

        deactivateStaffBtn1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        deactivateStaffBtn1.setForeground(new java.awt.Color(153, 153, 255));
        deactivateStaffBtn1.setText("Update");
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

        deactivateStaffBtn2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        deactivateStaffBtn2.setForeground(new java.awt.Color(153, 153, 255));
        deactivateStaffBtn2.setText("Update");
        deactivateStaffBtn2.setBorder(new javax.swing.border.MatteBorder(null));
        deactivateStaffBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deactivateStaffBtn2MouseClicked(evt);
            }
        });
        deactivateStaffBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deactivateStaffBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(activeStaffLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(activeStaffLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(activeStaffLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_username, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(activeStaffLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(activeStaffLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Password_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(activeStaffLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Username_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(activeStaffLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Fullname_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(deactivateStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deactivateStaffBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deactivateStaffBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(activeStaffLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(242, 242, 242))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(activeStaffLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_username, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(activeStaffLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(activeStaffLabel2))
                        .addGap(39, 39, 39))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(activeStaffLabel3)
                        .addComponent(label_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addComponent(activeStaffLabel4)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Username_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deactivateStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(activeStaffLabel5)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fullname_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activeStaffLabel6)
                    .addComponent(deactivateStaffBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Password_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activeStaffLabel7)
                    .addComponent(deactivateStaffBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(165, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deactivateStaffBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deactivateStaffBtnMouseClicked
        // TODO add your handling code here:
        String newUsername = Username_Input.getText();
        if(staffService.updateUsernameStaff(String.valueOf(IdStaff), newUsername)){
            JOptionPane.showMessageDialog(null, "Update Success");
            ShowStaffInfo();
        }
        Username_Input.setText("");
    }//GEN-LAST:event_deactivateStaffBtnMouseClicked

    private void deactivateStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deactivateStaffBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deactivateStaffBtnActionPerformed

    private void deactivateStaffBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deactivateStaffBtn1MouseClicked
        // TODO add your handling code here:
        String newFullname = Fullname_Input.getText();
        if(staffService.updateFullnameStaff(String.valueOf(IdStaff), newFullname)){
            JOptionPane.showMessageDialog(null, "Update Success");
            ShowStaffInfo();
        }
        Fullname_Input.setText("");
    }//GEN-LAST:event_deactivateStaffBtn1MouseClicked

    private void deactivateStaffBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deactivateStaffBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deactivateStaffBtn1ActionPerformed

    private void deactivateStaffBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deactivateStaffBtn2MouseClicked
        // TODO add your handling code here:
        String newPass = Password_Input.getText();
        JPasswordField pf = new JPasswordField();
        int oldPass = JOptionPane.showConfirmDialog(null, pf, "Enter old password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        String oldPassStr = String.valueOf(oldPass);
        //String oldPass = JOptionPane.showInputDialog("Confrim your password");
        System.out.println(oldPassStr);
        if (newPass.equals(oldPassStr)){
           JOptionPane.showMessageDialog(null, "You need change your password again !"); 
        }
        else {
            if(staffService.updatePasswordStaff(String.valueOf(IdStaff), newPass)){
                JOptionPane.showMessageDialog(null, "Update Success");
                ShowStaffInfo();
            }
        }
        Password_Input.setText("");
    }//GEN-LAST:event_deactivateStaffBtn2MouseClicked

    private void deactivateStaffBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deactivateStaffBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deactivateStaffBtn2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Fullname_Input;
    private javax.swing.JPasswordField Password_Input;
    private javax.swing.JTextField Username_Input;
    private javax.swing.JLabel activeStaffLabel;
    private javax.swing.JLabel activeStaffLabel1;
    private javax.swing.JLabel activeStaffLabel2;
    private javax.swing.JLabel activeStaffLabel3;
    private javax.swing.JLabel activeStaffLabel4;
    private javax.swing.JLabel activeStaffLabel5;
    private javax.swing.JLabel activeStaffLabel6;
    private javax.swing.JLabel activeStaffLabel7;
    private javax.swing.JButton deactivateStaffBtn;
    private javax.swing.JButton deactivateStaffBtn1;
    private javax.swing.JButton deactivateStaffBtn2;
    private javax.swing.JLabel label_admin;
    private javax.swing.JLabel label_fullname;
    private javax.swing.JLabel label_username;
    // End of variables declaration//GEN-END:variables
}
