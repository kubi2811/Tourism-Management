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
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ranco
 */
public class StaffInformation extends javax.swing.JPanel {

    private Connection connect = JDBCConnection.getConnection();
    private AddressService addressService = new AddressService();

    public static int IdClient;
    public static String nameClient;

    /**
     * Creates new form ManageRole
     */
    public StaffInformation() {
        initComponents();
        ShowStaffDeactiveInfo();
        ShowStaffActiveInfo();
        CountStaffActiveInfo();
        CountStaffDeactiveInfo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        temp = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        activeTable = new javax.swing.JTable();
        StaffLabel = new javax.swing.JLabel();
        nameClientVar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        deactiveTable = new javax.swing.JTable();
        activeStaffLabel = new javax.swing.JLabel();
        deactivateStaffLabel = new javax.swing.JLabel();
        activeStaffBtn = new javax.swing.JButton();
        deactivateStaffBtn = new javax.swing.JButton();
        searchAcBtn = new javax.swing.JButton();
        searchDacBtn = new javax.swing.JButton();

        temp.setText("jTextField1");

        jTextField1.setText("jTextField1");

        setBackground(new java.awt.Color(255, 255, 255));

        activeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Staff", "Full Name", "Username", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        activeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(activeTable);

        StaffLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        StaffLabel.setForeground(new java.awt.Color(153, 153, 255));
        StaffLabel.setText("Staff");

        nameClientVar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nameClientVar.setForeground(new java.awt.Color(153, 153, 255));
        nameClientVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameClientVarActionPerformed(evt);
            }
        });

        deactiveTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Staff", "Full Name", "Username", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        deactiveTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deactiveTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(deactiveTable);

        activeStaffLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        activeStaffLabel.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffLabel.setText("Active Staff");

        deactivateStaffLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        deactivateStaffLabel.setForeground(new java.awt.Color(153, 153, 255));
        deactivateStaffLabel.setText("Deactivate Staff");

        activeStaffBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        activeStaffBtn.setForeground(new java.awt.Color(153, 153, 255));
        activeStaffBtn.setText("Active");
        activeStaffBtn.setBorder(new javax.swing.border.MatteBorder(null));
        activeStaffBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activeStaffBtnMouseClicked(evt);
            }
        });
        activeStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activeStaffBtnActionPerformed(evt);
            }
        });

        deactivateStaffBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        deactivateStaffBtn.setForeground(new java.awt.Color(153, 153, 255));
        deactivateStaffBtn.setText("Deactivate");
        deactivateStaffBtn.setBorder(new javax.swing.border.MatteBorder(null));
        deactivateStaffBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deactivateStaffBtnMouseClicked(evt);
            }
        });

        searchAcBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        searchAcBtn.setForeground(new java.awt.Color(153, 153, 255));
        searchAcBtn.setText("Search AC");
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

        searchDacBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        searchDacBtn.setForeground(new java.awt.Color(153, 153, 255));
        searchDacBtn.setText("Search DAC");
        searchDacBtn.setBorder(new javax.swing.border.MatteBorder(null));
        searchDacBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchDacBtnMouseClicked(evt);
            }
        });
        searchDacBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDacBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(activeStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deactivateStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                                .addComponent(jScrollPane2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(StaffLabel)
                                .addGap(29, 29, 29)
                                .addComponent(nameClientVar, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchAcBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchDacBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 63, Short.MAX_VALUE)))
                        .addContainerGap(33, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(deactivateStaffLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(activeStaffLabel)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameClientVar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StaffLabel)
                    .addComponent(searchAcBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchDacBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(activeStaffLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deactivateStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activeStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deactivateStaffLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameClientVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameClientVarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameClientVarActionPerformed

    private void activeStaffBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activeStaffBtnMouseClicked
        // TODO add your handling code here:
        if(temp.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You're not chossing Staff yet !!!");
        } else {
            connect = JDBCConnection.getConnection();

            String sql = "UPDATE Staff SET Status = 1 WHERE IdStaff = ?";
            
            try{
                PreparedStatement pre = connect.prepareStatement(sql);
                pre = connect.prepareStatement(sql);
                System.out.println(temp.getText());
                pre.setString(1, temp.getText());
                
                pre.execute();
                
                JOptionPane.showMessageDialog(this, "Information have been Updated !!!");
            } catch (Exception e){
                e.printStackTrace();
                
            } 
        }
        DefaultTableModel model = (DefaultTableModel) activeTable.getModel();
        model.setRowCount(0);
        
        ShowStaffActiveInfo();
        ShowStaffDeactiveInfo();
        CountStaffDeactiveInfo();
        CountStaffActiveInfo();
    }//GEN-LAST:event_activeStaffBtnMouseClicked

    private void deactivateStaffBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deactivateStaffBtnMouseClicked
        // TODO add your handling code here:
        if(temp.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You're not chossing Staff yet !!!");
        } else {
            connect = JDBCConnection.getConnection();

            String sql = "UPDATE Staff SET Status = 0 WHERE IdStaff = ?";
            
            try{
                PreparedStatement pre = connect.prepareStatement(sql);
                pre = connect.prepareStatement(sql);
                System.out.println(temp.getText());
                pre.setString(1, temp.getText());
                
                pre.execute();
                
                JOptionPane.showMessageDialog(this, "Information have been Updated !!!");
            } catch (Exception e){
                e.printStackTrace();
                
            } 
        }
        DefaultTableModel model = (DefaultTableModel) activeTable.getModel();
        model.setRowCount(0);
        
        ShowStaffActiveInfo();
        ShowStaffDeactiveInfo();
        CountStaffDeactiveInfo();
        CountStaffActiveInfo();
    }//GEN-LAST:event_deactivateStaffBtnMouseClicked

    private void activeStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activeStaffBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_activeStaffBtnActionPerformed

    private void searchAcBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchAcBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchAcBtnMouseClicked

    private void searchAcBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAcBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) activeTable.getModel();
        model.setRowCount(0);
        try {
            //            String tenSP = JOptionPane.showInputDialog(this, "Nhập tên sản phẩm cần tìm");
            if (nameClientVar.getText().equals("") == false) {
                Connection conn = JDBCConnection.getConnection();
                String sql = "select * from Staff where FullName like ? And Status = 1";
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setString(1, "%" + nameClientVar.getText() + "%");
                ResultSet resultSet = pre.executeQuery();
                model.setRowCount(0);
                while (resultSet.next()) {
                    Vector vector = new Vector();
                    vector.add(resultSet.getString("IdStaff"));
                vector.add(resultSet.getString("FullName"));
                vector.add(resultSet.getString("Username"));
                vector.add(resultSet.getString("Status"));

                    model.addRow(vector);
                }
            } else {
                ShowStaffActiveInfo();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy!");
        }
    }//GEN-LAST:event_searchAcBtnActionPerformed

    private void searchDacBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchDacBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchDacBtnMouseClicked

    private void searchDacBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDacBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) deactiveTable.getModel();
        model.setRowCount(0);
        try {
            //            String tenSP = JOptionPane.showInputDialog(this, "Nhập tên sản phẩm cần tìm");
            if (nameClientVar.getText().equals("") == false) {
                Connection conn = JDBCConnection.getConnection();
                String sql = "select * from Staff where FullName like ? And Status = 0";
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setString(1, "%" + nameClientVar.getText() + "%");
                ResultSet resultSet = pre.executeQuery();
                model.setRowCount(0);
                while (resultSet.next()) {
                    Vector vector = new Vector();
                    vector.add(resultSet.getString("IdStaff"));
                vector.add(resultSet.getString("FullName"));
                vector.add(resultSet.getString("Username"));
                vector.add(resultSet.getString("Status"));

                    model.addRow(vector);
                }
                CountStaffDeactiveInfo();
            } else {
                ShowStaffDeactiveInfo();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy!");
        }
    }//GEN-LAST:event_searchDacBtnActionPerformed

    private void activeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activeTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) activeTable.getModel();
        int Myindex = activeTable.getSelectedRow();
        temp.setText(model.getValueAt(Myindex, 0).toString());
    }//GEN-LAST:event_activeTableMouseClicked

    private void deactiveTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deactiveTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) deactiveTable.getModel();
        int Myindex = deactiveTable.getSelectedRow();
        temp.setText(model.getValueAt(Myindex, 0).toString());
    }//GEN-LAST:event_deactiveTableMouseClicked

    public void ShowStaffActiveInfo() {
        DefaultTableModel model = (DefaultTableModel) activeTable.getModel();
        model.setRowCount(0);
        try {

            String sql = "select * from Staff where Status = 1";
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Vector vector = new Vector();
                vector.add(resultSet.getString("IdStaff"));
                vector.add(resultSet.getString("FullName"));
                vector.add(resultSet.getString("Username"));
                vector.add(resultSet.getString("Status"));
                model.addRow(vector);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void ShowStaffDeactiveInfo() {
        DefaultTableModel model = (DefaultTableModel) deactiveTable.getModel();
        model.setRowCount(0);
        try {

            String sql = "select * from Staff where Status = 0";
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Vector vector = new Vector();
                vector.add(resultSet.getString("IdStaff"));
                vector.add(resultSet.getString("FullName"));
                vector.add(resultSet.getString("Username"));
                vector.add(resultSet.getString("Status"));
                model.addRow(vector);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void CountStaffDeactiveInfo() {
        try {
            String sql = "SELECT COUNT(*) FROM Staff where Status = 0";
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            deactivateStaffLabel.setText("Deactivate Staff: " + String.valueOf(resultSet.getInt(1)));
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void CountStaffActiveInfo() {
        try {
            String sql = "SELECT COUNT(*) FROM Staff where Status = 1";
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            activeStaffLabel.setText("Activate Staff: " + String.valueOf(resultSet.getInt(1)));
        } catch (Exception e) {
            e.getMessage();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel StaffLabel;
    private javax.swing.JButton activeStaffBtn;
    private javax.swing.JLabel activeStaffLabel;
    private javax.swing.JTable activeTable;
    private javax.swing.JButton deactivateStaffBtn;
    private javax.swing.JLabel deactivateStaffLabel;
    private javax.swing.JTable deactiveTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField nameClientVar;
    private javax.swing.JButton searchAcBtn;
    private javax.swing.JButton searchDacBtn;
    private javax.swing.JTextField temp;
    // End of variables declaration//GEN-END:variables
}
