/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import FormClient.YourTrip;
import FormClient.BookTripNow;
import FormClient.Information;

/**
 *
 * @author proxc
 */
public class MainMenuClient extends javax.swing.JFrame {

    private CardLayout cardLayout;
    private YourTrip CAT;
    
    int IdClient;
    public int getIdClient() {
        return IdClient;
    }

    public void setIdClient(int IdClient) {
        this.IdClient = IdClient;
    }

    String FullName;
    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }
    /**
     * Creates new form Home20
     */
    public MainMenuClient() {
        initComponents();
        
        MainMenuClient.this.getRootPane().setBorder(new LineBorder(new Color(102, 102, 255)));
//        lblTitle.setText(this.getTitle());
        cardLayout = (CardLayout) pnlRight.getLayout();

        if (OSUtils.getOSType() == OSUtils.OSType.MacOS) {
            pnlTop.remove(pnlTitle);
            pnlTop.remove(pnlRight);

            pnlTop.add(pnlTitle, BorderLayout.EAST);
            pnlTop.add(pnlActions, BorderLayout.WEST);

            pnlActions.remove(lblClose);
            pnlActions.remove(lblMaximize);
            pnlActions.remove(lblMinimize);

            pnlActions.add(lblClose);
            pnlActions.add(lblMaximize);
            pnlActions.add(lblMinimize);

            pnlTitle.remove(lblTitle);
            pnlTitle.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 8));
            pnlTitle.add(lblTitle);

        }
        if (OSUtils.getOSType() == OSUtils.OSType.Windows) {
            pnlTop.remove(pnlTitle);
            pnlTop.remove(pnlRight);

            pnlTop.add(pnlTitle, BorderLayout.WEST);
            pnlTop.add(pnlActions, BorderLayout.EAST);

            pnlActions.remove(lblClose);
            pnlActions.remove(lblMaximize);
            pnlActions.remove(lblMinimize);

            pnlActions.add(lblMinimize);
            pnlActions.add(lblMaximize);
            pnlActions.add(lblClose);

            pnlTitle.remove(lblTitle);
            pnlTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 8));
            pnlTitle.add(lblTitle);

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

        pnlTop = new javax.swing.JPanel();
        pnlActions = new javax.swing.JPanel();
        lblMinimize = new javax.swing.JLabel();
        lblMaximize = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlParent = new javax.swing.JPanel();
        sidepane = new javax.swing.JPanel();
        btn_bookTrips = new javax.swing.JPanel();
        ind_bookTrips = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_yourTrips = new javax.swing.JPanel();
        ind_yourTrips = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_info = new javax.swing.JPanel();
        ind_icons = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        label_forClient = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_btns = new javax.swing.JPanel();
        ind_btns = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btn_data = new javax.swing.JPanel();
        ind_data = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btn_logOut = new javax.swing.JPanel();
        ind_logOut = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        pnlRight = new javax.swing.JPanel();
        pnlDataCards = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnlTypography = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Title Frame Test");
        setLocationByPlatform(true);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlTop.setBackground(new java.awt.Color(76, 41, 211));
        pnlTop.setPreferredSize(new java.awt.Dimension(1024, 30));
        pnlTop.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlTopMouseDragged(evt);
            }
        });
        pnlTop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlTopMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTopMousePressed(evt);
            }
        });
        pnlTop.setLayout(new java.awt.BorderLayout());

        pnlActions.setBackground(new java.awt.Color(50, 27, 140));
        pnlActions.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        lblMinimize.setIcon(new javax.swing.ImageIcon("F:\\Tourism-Management\\Tour Management\\Picture\\icons8_minus_18px_1.png")); // NOI18N
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMinimizeMousePressed(evt);
            }
        });
        pnlActions.add(lblMinimize);

        lblMaximize.setIcon(new javax.swing.ImageIcon("F:\\Tourism-Management\\Tour Management\\Picture\\icons8_rectangle_stroked_18px.png")); // NOI18N
        lblMaximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMaximizeMousePressed(evt);
            }
        });
        pnlActions.add(lblMaximize);

        lblClose.setIcon(new javax.swing.ImageIcon("F:\\Tourism-Management\\Tour Management\\Picture\\icons8_multiply_18px_1.png")); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCloseMousePressed(evt);
            }
        });
        pnlActions.add(lblClose);

        pnlTop.add(pnlActions, java.awt.BorderLayout.LINE_END);

        pnlTitle.setBackground(new java.awt.Color(76, 41, 211));
        pnlTitle.setPreferredSize(new java.awt.Dimension(200, 30));
        pnlTitle.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8));

        lblTitle.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Tour Managerment");
        pnlTitle.add(lblTitle);

        pnlTop.add(pnlTitle, java.awt.BorderLayout.LINE_START);

        getContentPane().add(pnlTop, java.awt.BorderLayout.PAGE_START);

        pnlParent.setLayout(new java.awt.BorderLayout());

        sidepane.setBackground(new java.awt.Color(102, 102, 255));
        sidepane.setForeground(new java.awt.Color(51, 51, 51));
        sidepane.setPreferredSize(new java.awt.Dimension(250, 200));
        sidepane.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sidepaneMouseDragged(evt);
            }
        });
        sidepane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sidepaneMousePressed(evt);
            }
        });

        btn_bookTrips.setBackground(new java.awt.Color(76, 41, 211));
        btn_bookTrips.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_bookTripsMousePressed(evt);
            }
        });
        btn_bookTrips.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_bookTrips.setOpaque(false);
        ind_bookTrips.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_bookTripsLayout = new javax.swing.GroupLayout(ind_bookTrips);
        ind_bookTrips.setLayout(ind_bookTripsLayout);
        ind_bookTripsLayout.setHorizontalGroup(
            ind_bookTripsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_bookTripsLayout.setVerticalGroup(
            ind_bookTripsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_bookTrips.add(ind_bookTrips, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Book Trip Now");
        btn_bookTrips.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tour Management");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Where you see, we can go");

        btn_yourTrips.setBackground(new java.awt.Color(76, 41, 211));
        btn_yourTrips.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_yourTripsMousePressed(evt);
            }
        });
        btn_yourTrips.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_yourTrips.setOpaque(false);
        ind_yourTrips.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_yourTripsLayout = new javax.swing.GroupLayout(ind_yourTrips);
        ind_yourTrips.setLayout(ind_yourTripsLayout);
        ind_yourTripsLayout.setHorizontalGroup(
            ind_yourTripsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_yourTripsLayout.setVerticalGroup(
            ind_yourTripsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_yourTrips.add(ind_yourTrips, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Your Trip");
        btn_yourTrips.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        btn_info.setBackground(new java.awt.Color(76, 41, 211));
        btn_info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_infoMousePressed(evt);
            }
        });
        btn_info.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_icons.setOpaque(false);
        ind_icons.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_iconsLayout = new javax.swing.GroupLayout(ind_icons);
        ind_icons.setLayout(ind_iconsLayout);
        ind_iconsLayout.setHorizontalGroup(
            ind_iconsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_iconsLayout.setVerticalGroup(
            ind_iconsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_info.add(ind_icons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Information");
        btn_info.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        label_forClient.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        label_forClient.setForeground(new java.awt.Color(255, 255, 255));
        label_forClient.setText("FOR CLIENT");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PROFILE");

        btn_btns.setBackground(new java.awt.Color(76, 41, 211));
        btn_btns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_btnsMousePressed(evt);
            }
        });
        btn_btns.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_btns.setOpaque(false);
        ind_btns.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_btnsLayout = new javax.swing.GroupLayout(ind_btns);
        ind_btns.setLayout(ind_btnsLayout);
        ind_btnsLayout.setHorizontalGroup(
            ind_btnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_btnsLayout.setVerticalGroup(
            ind_btnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_btns.add(ind_btns, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Buttons");
        btn_btns.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        btn_data.setBackground(new java.awt.Color(76, 41, 211));
        btn_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_dataMousePressed(evt);
            }
        });
        btn_data.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_data.setOpaque(false);
        ind_data.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_dataLayout = new javax.swing.GroupLayout(ind_data);
        ind_data.setLayout(ind_dataLayout);
        ind_dataLayout.setHorizontalGroup(
            ind_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_dataLayout.setVerticalGroup(
            ind_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_data.add(ind_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Datacards");
        btn_data.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        btn_logOut.setBackground(new java.awt.Color(76, 41, 211));
        btn_logOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_logOutMousePressed(evt);
            }
        });
        btn_logOut.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_logOut.setOpaque(false);
        ind_logOut.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_logOutLayout = new javax.swing.GroupLayout(ind_logOut);
        ind_logOut.setLayout(ind_logOutLayout);
        ind_logOutLayout.setHorizontalGroup(
            ind_logOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_logOutLayout.setVerticalGroup(
            ind_logOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_logOut.add(ind_logOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("LOG OUT");
        btn_logOut.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        javax.swing.GroupLayout sidepaneLayout = new javax.swing.GroupLayout(sidepane);
        sidepane.setLayout(sidepaneLayout);
        sidepaneLayout.setHorizontalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_bookTrips, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_yourTrips, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_btns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sidepaneLayout.createSequentialGroup()
                .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidepaneLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1))
                    .addGroup(sidepaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sidepaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label_forClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sidepaneLayout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(jLabel2))))
                .addContainerGap(34, Short.MAX_VALUE))
            .addComponent(btn_logOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidepaneLayout.setVerticalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepaneLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(46, 46, 46)
                .addComponent(label_forClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_bookTrips, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_yourTrips, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_btns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btn_logOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pnlParent.add(sidepane, java.awt.BorderLayout.LINE_START);

        pnlRight.setLayout(new java.awt.CardLayout());

        pnlDataCards.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("WELCOME TO OUR COMPANY, LETS CHOOSE YOUR TRIPS");

        javax.swing.GroupLayout pnlDataCardsLayout = new javax.swing.GroupLayout(pnlDataCards);
        pnlDataCards.setLayout(pnlDataCardsLayout);
        pnlDataCardsLayout.setHorizontalGroup(
            pnlDataCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataCardsLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        pnlDataCardsLayout.setVerticalGroup(
            pnlDataCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataCardsLayout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        pnlRight.add(pnlDataCards, "card1");

        pnlTypography.setBackground(new java.awt.Color(255, 255, 102));

        javax.swing.GroupLayout pnlTypographyLayout = new javax.swing.GroupLayout(pnlTypography);
        pnlTypography.setLayout(pnlTypographyLayout);
        pnlTypographyLayout.setHorizontalGroup(
            pnlTypographyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
        );
        pnlTypographyLayout.setVerticalGroup(
            pnlTypographyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pnlRight.add(pnlTypography, "card2");

        pnlParent.add(pnlRight, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlParent, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int xy, xx;
    private void sidepaneMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidepaneMouseDragged
        // TODO add your handling code here:

    }//GEN-LAST:event_sidepaneMouseDragged

    private void sidepaneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidepaneMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_sidepaneMousePressed

    private void btn_bookTripsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bookTripsMousePressed
        // TODO add your handling code here:
        //Màu sắc
        setColor(btn_bookTrips);
        resetColor(btn_data);
        resetColor(btn_btns);
        resetColor(btn_yourTrips);
        resetColor(btn_info);
        resetColor(btn_logOut);

        //Gạch nhỏ đầu màu trắng khi bấm vào
        ind_bookTrips.setOpaque(true);
        ind_btns.setOpaque(false);
        ind_data.setOpaque(false);
        ind_yourTrips.setOpaque(false);
        ind_icons.setOpaque(false);
        ind_logOut.setOpaque(false);

//        pnlRight.removeAll();
//        pnlRight.add(CAT).setVisible(true);
        pnlRight.removeAll();
        pnlRight.add(new BookTripNow()).setVisible(true);
        pnlRight.repaint();
        pnlRight.revalidate();
    }//GEN-LAST:event_btn_bookTripsMousePressed

    private void btn_yourTripsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_yourTripsMousePressed
        // TODO add your handling code here:
        setColor(btn_yourTrips);
        resetColor(btn_data);
        resetColor(btn_btns);
        resetColor(btn_bookTrips);
        resetColor(btn_info);
        resetColor(btn_logOut);

        //Gạch nhỏ đầu màu trắng khi bấm vào
        ind_bookTrips.setOpaque(false);
        ind_btns.setOpaque(false);
        ind_data.setOpaque(false);
        ind_yourTrips.setOpaque(true);
        ind_icons.setOpaque(false);
        ind_logOut.setOpaque(false);

        pnlRight.removeAll();
        pnlRight.add(new YourTrip()).setVisible(true);
        pnlRight.repaint();
        pnlRight.revalidate();


    }//GEN-LAST:event_btn_yourTripsMousePressed

    private void btn_infoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_infoMousePressed
        // TODO add your handling code here:
        setColor(btn_info);
        resetColor(btn_data);
        resetColor(btn_btns);
        resetColor(btn_yourTrips);
        resetColor(btn_bookTrips);
        resetColor(btn_logOut);

        //Gạch nhỏ đầu màu trắng khi bấm vào
        ind_bookTrips.setOpaque(false);
        ind_btns.setOpaque(false);
        ind_data.setOpaque(false);
        ind_yourTrips.setOpaque(false);
        ind_icons.setOpaque(true);
        ind_logOut.setOpaque(false);

        pnlRight.removeAll();
        pnlRight.add(new Information()).setVisible(true);
        pnlRight.repaint();
        pnlRight.revalidate();

    }//GEN-LAST:event_btn_infoMousePressed

    private void btn_btnsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_btnsMousePressed
        // TODO add your handling code here:
        setColor(btn_btns);
        resetColor(btn_data);
        resetColor(btn_bookTrips);
        resetColor(btn_yourTrips);
        resetColor(btn_info);
        resetColor(btn_logOut);

        //Gạch nhỏ đầu màu trắng khi bấm vào
        ind_bookTrips.setOpaque(false);
        ind_btns.setOpaque(true);
        ind_data.setOpaque(false);
        ind_yourTrips.setOpaque(false);
        ind_icons.setOpaque(false);
        ind_logOut.setOpaque(false);
    }//GEN-LAST:event_btn_btnsMousePressed

    private void btn_dataMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dataMousePressed
        // TODO add your handling code here:
        setColor(btn_data);
        resetColor(btn_bookTrips);
        resetColor(btn_btns);
        resetColor(btn_yourTrips);
        resetColor(btn_info);
        resetColor(btn_logOut);

        //Gạch nhỏ đầu màu trắng khi bấm vào
        ind_bookTrips.setOpaque(false);
        ind_btns.setOpaque(false);
        ind_data.setOpaque(true);
        ind_yourTrips.setOpaque(false);
        ind_icons.setOpaque(false);
        ind_logOut.setOpaque(false);

    }//GEN-LAST:event_btn_dataMousePressed


    private void lblMaximizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaximizeMousePressed
        if (MainMenuClient.this.getExtendedState() == MAXIMIZED_BOTH) {
            MainMenuClient.this.setExtendedState(JFrame.NORMAL);
        } else {
            MainMenuClient.this.setExtendedState(MAXIMIZED_BOTH);
        }
    }//GEN-LAST:event_lblMaximizeMousePressed

    private void lblCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMousePressed
        System.exit(0);
    }//GEN-LAST:event_lblCloseMousePressed

    private void lblMinimizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMousePressed
        MainMenuClient.this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMousePressed

    private void pnlTopMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlTopMousePressed

    private void pnlTopMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlTopMouseDragged

    private void pnlTopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            if (MainMenuClient.this.getExtendedState() == MAXIMIZED_BOTH) {
                MainMenuClient.this.setExtendedState(JFrame.NORMAL);
            } else {
                MainMenuClient.this.setExtendedState(MAXIMIZED_BOTH);
            }
        }
    }//GEN-LAST:event_pnlTopMouseClicked

    private void btn_logOutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logOutMousePressed
        // TODO add your handling code here:
        setColor(btn_logOut);

        resetColor(btn_bookTrips);
        resetColor(btn_yourTrips);
        resetColor(btn_info);

        resetColor(btn_btns);
        resetColor(btn_data);

        //Gạch nhỏ đầu màu trắng khi bấm vào
        ind_bookTrips.setOpaque(false);
        ind_btns.setOpaque(false);
        ind_data.setOpaque(false);
        ind_yourTrips.setOpaque(false);
        ind_icons.setOpaque(false);
        ind_logOut.setOpaque(true);
    }//GEN-LAST:event_btn_logOutMousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here
        label_forClient.setText("For Client: " + getFullName());
    }//GEN-LAST:event_formWindowOpened

    // set and reset color
    void setColor(JPanel panel) {
        panel.setBackground(new Color(135, 112, 225));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(76, 41, 211));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenuClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_bookTrips;
    private javax.swing.JPanel btn_btns;
    private javax.swing.JPanel btn_data;
    private javax.swing.JPanel btn_info;
    private javax.swing.JPanel btn_logOut;
    private javax.swing.JPanel btn_yourTrips;
    private javax.swing.JPanel ind_bookTrips;
    private javax.swing.JPanel ind_btns;
    private javax.swing.JPanel ind_data;
    private javax.swing.JPanel ind_icons;
    private javax.swing.JPanel ind_logOut;
    private javax.swing.JPanel ind_yourTrips;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel label_forClient;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblMaximize;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlActions;
    private javax.swing.JPanel pnlDataCards;
    private javax.swing.JPanel pnlParent;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JPanel pnlTypography;
    private javax.swing.JPanel sidepane;
    // End of variables declaration//GEN-END:variables
}
