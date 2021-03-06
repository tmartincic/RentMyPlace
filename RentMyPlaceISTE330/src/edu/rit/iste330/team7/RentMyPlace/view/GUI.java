package edu.rit.iste330.team7.RentMyPlace.view;

import com.toedter.calendar.JDateChooser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class GUI extends javax.swing.JFrame {

    /**
     * Creates new main app GUI
     * constructor, load components and set Nimbus LookAndFeel
     */
    public GUI() {
        initComponents();
    }

    /**
     * Skeleton content was generated separately
     * We built on it and added further styling, sections, some later added ui elements, all methods and connected everything in controller
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="GUI Code">
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        rentPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        searchScrollPane = new javax.swing.JScrollPane();
        searchPanel = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();

        jLabel13 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        myRentalsScrollPane = new javax.swing.JScrollPane();
        myRentalsPanel = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabelSearchInputName2 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabelSearchLocation2 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabelSearchPrice2 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jLabel48 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jTextField21 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        favoritesScrollPane = new javax.swing.JScrollPane();
        favoritesPanel = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        favoritesPropertiesPanel = new javax.swing.JPanel();
        favoritesPropertyPanel1 = new javax.swing.JPanel();

        settingsPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldContactEmail = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldContactFullName = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldContactZip = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextFieldContactCity = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextFieldContactStreet = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextFieldBillingOwnerName = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextFieldBillingCardNumber = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextFieldBillingAddress = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextFieldBillingCVC = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextFieldBillingExpirationDate = new javax.swing.JTextField();
        saveSettingsButton = new javax.swing.JButton();
        jDateChooserExpirationDate = new com.toedter.calendar.JDateChooser();
        jDateChooserExpirationDate.setDateFormatString("yyyy-MM-dd");

        buttonGroup = new ButtonGroup();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1120, 670));
        setResizable(false);

        jTabbedPane2.setBackground(new java.awt.Color(188, 205, 213));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        rentPanel.setBackground(new java.awt.Color(188, 205, 213));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("RENT");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Location:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("<name>");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Property name:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("<location>");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Price per night: ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("<price>");

        jButton3.setText("See more details...");
        jButton15.setText("Reserve");

        jLabel12.setBackground(new java.awt.Color(153, 153, 153));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("<imageHere>");

        jButton7.setIcon(bufferImageIcon(this.createURL("https://www.pngrepo.com/png/105815/180/favorite.png"), 20, 20));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addComponent(jButton3))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(95, 95, 95)
                                                .addComponent(jButton15))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(21, 21, 21)
                                                                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel10)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(89, 89, 89)
                                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(69, 69, 69)
                                .addComponent(jButton7)
                                .addGap(39, 39, 39)
                                .addComponent(jButton3)
                                .addGap(28, 28, 28)
                                .addComponent(jButton15)
                        .addGap(10, 10, 10))
                                //.addGap(38, 38, 38))
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

        );
/////
        jButton1.setText("PREV");

        jButton2.setText("NEXT");

        javax.swing.GroupLayout rentPanelLayout = new javax.swing.GroupLayout(rentPanel);
        rentPanel.setLayout(rentPanelLayout);
        rentPanelLayout.setHorizontalGroup(
                rentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(rentPanelLayout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(193, 193, 193))
                        .addGroup(rentPanelLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(92, Short.MAX_VALUE))
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        rentPanelLayout.setVerticalGroup(
                rentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(rentPanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel4)
                                .addGap(33, 33, 33)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(rentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        //css styling tabs
        String tabStyle1 = "<html><body style = 'padding: 10px'>";
        String tabStyle2 = "</body><html>";

        jTabbedPane2.addTab(tabStyle1 + "RENT" + tabStyle2, bufferImageIcon(this.createURL("https://img.icons8.com/ios/452/sell-property--v2.png"), 25, 25), rentPanel);

        searchScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        searchScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        searchPanel.setBackground(new java.awt.Color(188, 205, 213));

        jLabel21.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("SEARCH");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Sort by:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setText("<enter property location>");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Search by location:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Price (ascending)", "Price (descending)"}));

        jButton5.setText(">");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        /*
         * dynamically generate jPanels depending on property search result
         *  using method createSearchPanel(int)
         */

        //empty search result panel container
        searchPanelContainer = new JPanel();
        //add layout

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
                searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(searchPanelLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, searchPanelLayout.createSequentialGroup()
                                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, searchPanelLayout.createSequentialGroup()
                                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(searchPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        )

                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                                .addContainerGap(28, Short.MAX_VALUE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        searchPanelLayout.setVerticalGroup(
                searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(searchPanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel21)
                                .addGap(45, 45, 45)
                                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))

                        .addGap(64, 64, 64)
                                .addComponent(searchPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))


        );

        searchScrollPane.setViewportView(searchPanel);

        jTabbedPane2.addTab(tabStyle1 + "SEARCH" + tabStyle2, bufferImageIcon(this.createURL("https://img.icons8.com/pastel-glyph/2x/search--v3.png"), 25, 25), searchScrollPane);

        myRentalsScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        myRentalsPanel.setBackground(new java.awt.Color(188, 205, 213));

        jLabel33.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("MY RENTALS");

        jPanel2.setBackground(new java.awt.Color(213, 220, 223));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Location:");

        jLabelSearchInputName2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSearchInputName2.setText("<name>");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Property name:");

        jLabelSearchLocation2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSearchLocation2.setText("<location>");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setText("Price per night: ");

        jLabelSearchPrice2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSearchPrice2.setText("<price>");

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton12.setText("Delete");

        jLabel42.setBackground(new java.awt.Color(255, 204, 204));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("<imageHere>");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jLabelSearchInputName2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabelSearchLocation2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabelSearchPrice2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelSearchInputName2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelSearchLocation2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelSearchPrice2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton12)
                                .addGap(151, 151, 151))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("My properties:");

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PropertyName1", "PropertyName2" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
        );

        jPanel3.setBackground(new java.awt.Color(213, 220, 223));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Property name:");

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField13.setText("<name>");
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Street:");

        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField14.setText("<street>");
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Bedrooms:");

        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField15.setText("<number>");
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("City:");

        jTextField16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField16.setText("<name>");
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Zip:");

        jTextField17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField17.setText("<zip>");
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        jTextField18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField18.setText("<Price per night>");
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Price per night:");

        jTextField19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField19.setText("<size>");
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Size:");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Description:");

        jTextField20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField20.setText("<description text>");
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText("ADD PROPERTY:");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setText("TYPE:");

        jCheckBox1.setBackground(new java.awt.Color(213, 220, 223));
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox1.setText("Parking");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setBackground(new java.awt.Color(213, 220, 223));
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox2.setText("Wifi");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setBackground(new java.awt.Color(213, 220, 223));
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox3.setText("Jacuzzi");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setBackground(new java.awt.Color(213, 220, 223));
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox4.setText("Room service");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setBackground(new java.awt.Color(213, 220, 223));
        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox5.setText("Smoking room");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jCheckBox6.setBackground(new java.awt.Color(213, 220, 223));
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox6.setText("Pet friendly");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jCheckBox7.setBackground(new java.awt.Color(213, 220, 223));
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox7.setText("Air conditioning");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jCheckBox8.setBackground(new java.awt.Color(213, 220, 223));
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox8.setText("Swimming pool");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setText("FEATURES:");

        jRadioButton1.setBackground(new java.awt.Color(213, 220, 223));
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton1.setText("House");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(213, 220, 223));
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton2.setText("Apartment");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setBackground(new java.awt.Color(213, 220, 223));
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton3.setText("Villa");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setBackground(new java.awt.Color(213, 220, 223));
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton4.setText("Garage");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jRadioButton5.setBackground(new java.awt.Color(213, 220, 223));
        jRadioButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton5.setText("Office");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jTextField21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField21.setText("Enter image URL");
        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton9.setText("ADD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(72, 72, 72)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                                .addGap(228, 228, 228))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(69, 69, 69)
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(100, 100, 100)
                                                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jCheckBox6)
                                                        .addComponent(jCheckBox7)
                                                        .addComponent(jCheckBox8)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jCheckBox4)
                                                                        .addComponent(jCheckBox5))
                                                                .addGap(96, 96, 96)
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(9, 9, 9)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jRadioButton1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jRadioButton2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jRadioButton3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jRadioButton5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jRadioButton4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout myRentalsPanelLayout = new javax.swing.GroupLayout(myRentalsPanel);
        myRentalsPanel.setLayout(myRentalsPanelLayout);
        myRentalsPanelLayout.setHorizontalGroup(
                myRentalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(myRentalsPanelLayout.createSequentialGroup()
                                .addGroup(myRentalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(myRentalsPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addGroup(myRentalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(myRentalsPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(361, Short.MAX_VALUE))
        );
        myRentalsPanelLayout.setVerticalGroup(
                myRentalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(myRentalsPanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel33)
                                .addGap(40, 40, 40)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        myRentalsScrollPane.setViewportView(myRentalsPanel);
        jTabbedPane2.addTab(tabStyle1 + "MY RENTALS" + tabStyle2, bufferImageIcon(this.createURL("https://img.icons8.com/pastel-glyph/2x/key-exchange.png"), 25, 25), myRentalsScrollPane);

        favoritesScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        favoritesPanel.setBackground(new java.awt.Color(188, 205, 213));

        jLabel49.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("FAVORITES");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setText("Sort by:");

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setText("Rentals marked as favorite will appear here:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Price (ascending)", "Price (descending)" }));

        favoritesPropertiesPanel.setBackground(new java.awt.Color(213, 220, 223));

        javax.swing.GroupLayout favoritesPanelLayout = new javax.swing.GroupLayout(favoritesPanel);
        favoritesPanel.setLayout(favoritesPanelLayout);
        favoritesPanelLayout.setHorizontalGroup(
                favoritesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(favoritesPanelLayout.createSequentialGroup()
                                .addGroup(favoritesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(favoritesPanelLayout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addGroup(favoritesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(favoritesPanelLayout.createSequentialGroup()
                                                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel55)
                                                        .addComponent(favoritesPropertiesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(favoritesPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(80, Short.MAX_VALUE))
        );
        favoritesPanelLayout.setVerticalGroup(
                favoritesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(favoritesPanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel49)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(favoritesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                                .addGap(63, 63, 63)
                                .addComponent(favoritesPropertiesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
        );

        favoritesScrollPane.setViewportView(favoritesPanel);
        jTabbedPane2.addTab(tabStyle1 + "FAVORITES" + tabStyle2, bufferImageIcon(this.createURL("https://www.pngrepo.com/png/105815/180/favorite.png"), 25, 25),  favoritesScrollPane);
        settingsPanel.setBackground(new java.awt.Color(188, 205, 213));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("SETTINGS CONTAINER");
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("CONTACT INFO");
        jTextFieldContactEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldContactEmail.setText("<email>");
        jTextFieldContactEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Email:");
        jTextFieldContactFullName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldContactFullName.setText("<name>");
        jTextFieldContactFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Full name:");
        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Street:");
        jTextFieldContactZip.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldContactZip.setText("<zip>");
        jTextFieldContactZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("City:");
        jTextFieldContactCity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldContactCity.setText("<name>");
        jTextFieldContactCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Zip:");
        jTextFieldContactStreet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldContactStreet.setText("<street>");
        jTextFieldContactStreet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("BILLING INFO");
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Owner name:");
        jTextFieldBillingOwnerName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldBillingOwnerName.setText("<name>");
        jTextFieldBillingOwnerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Card number:");
        jTextFieldBillingCardNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldBillingCardNumber.setText("<card number>");
        jTextFieldBillingCardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Billing address:");
        jTextFieldBillingAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldBillingAddress.setText("<address>");
        jTextFieldBillingAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("CVC:");
        jTextFieldBillingCVC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldBillingCVC.setText("<cvc>");
        jTextFieldBillingCVC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Expires:");

        saveSettingsButton.setText("SAVE");
        saveSettingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
                settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(settingsPanelLayout.createSequentialGroup()
                                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(settingsPanelLayout.createSequentialGroup()
                                                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(settingsPanelLayout.createSequentialGroup()
                                                                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jTextFieldBillingOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(settingsPanelLayout.createSequentialGroup()
                                                                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jTextFieldBillingCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(72, 72, 72)
                                                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                                                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jTextFieldBillingCVC)
                                                                        .addComponent(jDateChooserExpirationDate, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(settingsPanelLayout.createSequentialGroup()
                                                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(settingsPanelLayout.createSequentialGroup()
                                                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jTextFieldContactFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(settingsPanelLayout.createSequentialGroup()
                                                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jTextFieldContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(settingsPanelLayout.createSequentialGroup()
                                                                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jTextFieldContactStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(72, 72, 72)
                                                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextFieldContactCity, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextFieldContactZip, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(settingsPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldBillingAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(saveSettingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(63, 63, 63))))
        );
        settingsPanelLayout.setVerticalGroup(
                settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel8)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldContactFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldContactCity, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldContactZip, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldContactStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldBillingOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldBillingCVC, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldBillingCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jDateChooserExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextFieldBillingAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(saveSettingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        JPanel logoutPanel = new JPanel(new FlowLayout());
        logOutButton = new JButton("LOG OUT");
        jLabelLogOutUsername = new JLabel();
        logoutPanel.add(jLabelLogOutUsername);
        jTabbedPane2.addTab(tabStyle1 + "SETTINGS" + tabStyle2, bufferImageIcon(this.createURL("https://www.pngrepo.com/png/13646/180/settings.png"), 25, 25), settingsPanel);

        jTabbedPane2.addTab(tabStyle1 + "LOG OUT" + tabStyle2, logoutPanel);
        logoutPanel.add(logOutButton);

        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);
        buttonGroup.add(jRadioButton4);
        buttonGroup.add(jRadioButton5);

        getContentPane().add(jTabbedPane2, java.awt.BorderLayout.CENTER);

        pack();

    }// </editor-fold>
    public void addLogOutButtonEventListener(ActionListener ae) {
        this.getLogOutButton().setActionCommand("log_out");
        this.getLogOutButton().addActionListener(ae);
    }

    public void addjButton2EventListener(ActionListener ae) {
        this.getjButton2().setActionCommand("rent_next");
        this.getjButton2().addActionListener(ae);
    }

    public void addjButton1EventListener(ActionListener ae) {
        this.getjButton1().setActionCommand("rent_prev");
        this.getjButton1().addActionListener(ae);
    }

    public void addjButton3EventListener(ActionListener ae) {
        this.getjButton3().setActionCommand("rent_details");
        this.getjButton3().addActionListener(ae);
    }

    public void addjButton15EventListener(ActionListener ae) {
        this.getjButton15().setActionCommand("reserve");
        this.getjButton15().addActionListener(ae);
    }

    public void addjButton6EventListener(ActionListener ae){
        this.getSaveSettingsButton().setActionCommand("save_settings");
        this.getSaveSettingsButton().addActionListener(ae);
    }

    public void addjButton5EventListener(ActionListener ae){
        this.getjButton5().setActionCommand("search");
        this.getjButton5().addActionListener(ae);
    }

    public void addAddPropertyEventListener(ActionListener ae) {
        this.getjButton9().setActionCommand("add_property");
        this.getjButton9().addActionListener(ae);
    }

    public void addAddFavoritesEventListener(ActionListener ae){
        this.getjButton7().setActionCommand("add_favorite");
        this.getjButton7().addActionListener(ae);
    }

    public void addDeletePropertyFromMyRentalsListener(ActionListener ae){
        this.getjButton12().setActionCommand("myrentals_delete");
        this.getjButton12().addActionListener(ae);
    }

    //DELETE BUTTON
    public JButton getjButton12() {
        return jButton12;
    }

    public JButton getjButton7() {
        return jButton7;
    }

    public JPanel getFavoritesPanel() { return favoritesPanel; }

    public JLabel getjLabelSearchInputName2() { return jLabelSearchInputName2; }

    public JLabel getjLabelSearchLocation2() { return jLabelSearchLocation2; }

    public JLabel getjLabelSearchPrice2() { return jLabelSearchPrice2; }

    public JButton getjButton9() {
        return jButton9;
    }

    public ArrayList<JRadioButton> getJRadioButtons(){
        ArrayList<JRadioButton> radioButtons = new ArrayList<>();
        radioButtons.add(jRadioButton1);
        radioButtons.add(jRadioButton2);
        radioButtons.add(jRadioButton3);
        radioButtons.add(jRadioButton4);
        radioButtons.add(jRadioButton5);
        return radioButtons;
    }

    public ArrayList<JCheckBox> getCheckBoxes(){
        ArrayList<JCheckBox> checkBoxes = new ArrayList<>();

        checkBoxes.add(jCheckBox1);
        checkBoxes.add(jCheckBox2);
        checkBoxes.add(jCheckBox3);
        checkBoxes.add(jCheckBox4);
        checkBoxes.add(jCheckBox5);
        checkBoxes.add(jCheckBox6);
        checkBoxes.add(jCheckBox7);
        checkBoxes.add(jCheckBox8);

        return checkBoxes;
    }

    public JButton getjButton5() {
        return jButton5;
    }

    public JButton getjButton15() {
        return jButton15;
    }

    public JButton getSaveSettingsButton() {
        return saveSettingsButton;
    }

    public JComboBox<String> getjComboBox1() {
        return jComboBox1;
    }

    public JComboBox<String> getjComboBox2() {
        return jComboBox2;
    }

    public JComboBox<String> getjComboBox3() {
        return jComboBox3;
    }

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public JLabel getjLabel42() { return jLabel42; }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton14jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     *  GETTERS
     */

    public JTextField getjTextField13() { return jTextField13; }

    public JTextField getjTextField14() { return jTextField14; }

    public JTextField getjTextField15() { return jTextField15; }

    public JTextField getjTextField16() { return jTextField16; }

    public JTextField getjTextField17() { return jTextField17; }

    public JTextField getjTextField18() { return jTextField18; }

    public JTextField getjTextField19() { return jTextField19; }

    public JTextField getjTextField20() { return jTextField20; }

    public JTextField getjTextField21() { return jTextField21; }

    public JLabel getjLabel11() { return jLabel11; }

    public JLabel getjLabel12() { return jLabel12; }

    public JLabel getjLabel2() { return jLabel2; }

    public JLabel getjLabel9() { return jLabel9; }

    public JLabel getjLabelUsername() { return jLabelLogOutUsername; }

    public JButton getjButton1() { return jButton1; }

    public JButton getjButton2() { return jButton2; }

    public JButton getjButton3() { return jButton3; }

    public JButton getLogOutButton() { return logOutButton; }

    public JTextField getjTextFieldContactFullName() { return jTextFieldContactFullName; }

    public JTextField getjTextFieldBillingAddress() { return jTextFieldBillingAddress; }

    public JTextField getjTextFieldContactEmail() { return jTextFieldContactEmail; }

    public JTextField getjTextFieldContactStreet() { return jTextFieldContactStreet; }

    public JTextField getjTextFieldBillingOwnerName() { return jTextFieldBillingOwnerName; }

    public JTextField getjTextFieldBillingCardNumber() { return jTextFieldBillingCardNumber; }

    public JTextField getjTextFieldContactCity() { return jTextFieldContactCity; }

    public JTextField getjTextFieldContactZip() { return jTextFieldContactZip; }

    public JTextField getjTextFieldBillingCVC() { return jTextFieldBillingCVC; }

    public JTextField getjTextFieldBillingExpirationDate() { return jTextFieldBillingExpirationDate; }

    public JTabbedPane getjTabbedPane2() { return jTabbedPane2; }

    public JPanel getjPanelRent() { return rentPanel; }

    //search section

    public ArrayList<JLabel> getSearchNameLabel() { return searchNameLabel; }

    public ArrayList<JLabel> getSearchLocationLabel() { return searchLocationLabel; }

    public ArrayList<JLabel> getSearchPriceLabel() { return searchPriceLabel; }

    public ArrayList<JButton> getSearchAddFavoritesButton() { return searchAddFavoritesButton; }

    public ArrayList<JButton> getSearchMoreDetailsButton() { return searchMoreDetailsButton; }

    public ArrayList<JPanel> getSearchResultPanels() { return searchResultPanels; }

    public ArrayList<JLabel> getSearchResultNameLabel() { return searchResultNameLabel; }

    public ArrayList<JLabel> getSearchResultLocationLabel() { return searchResultLocationLabel; }

    public ArrayList<JLabel> getSearchResultPriceLabel() { return searchResultPriceLabel; }

    public ArrayList<JLabel> getSearchResultImageLabel() { return searchResultImageLabel; }

    //favorites section

    public ArrayList<JPanel> getFavoritesResultPanels() { return favoritesResultPanels; }

    public ArrayList<JLabel> getFavoritesResultNameLabel() { return favoritesResultNameLabel; }

    public ArrayList<JLabel> getFavoritesResultLocationLabel() { return favoritesResultLocationLabel; }

    public ArrayList<JLabel> getFavoritesResultPriceLabel() { return favoritesResultPriceLabel; }

    public ArrayList<JLabel> getFavoritesResultImageLabel() { return favoritesResultImageLabel; }

    public ArrayList<JLabel> getFavoritesNameLabel() { return favoritesNameLabel; }

    public ArrayList<JLabel> getFavoritesLocationLabel() { return favoritesLocationLabel; }

    public ArrayList<JLabel> getFavoritesPriceLabel() { return favoritesPriceLabel; }

    public ArrayList<JButton> getFavoritesRemoveFavoritesButton() { return favoritesRemoveFavoritesButton; }

    public ArrayList<JButton> getFavoritesMoreDetailsButton() { return favoritesMoreDetailsButton; }

    /**
     * @param link
     * @return
     */
    public URL createURL(String link) {
        URL url = null;
        try {
            url = new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    /**
     * @param link
     * @return boolean
     */
    public boolean checkURL(String link) {
        URL url = null;
        try {
            url = new URL(link);
        } catch (MalformedURLException e) {
            return false;
        }
        return true;
    }

    /**
     * @param url
     * @param width
     * @param height
     * @return
     */
    public ImageIcon bufferImageIcon(URL url, int width, int height) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(this.createURL(url.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert image != null;
        try {
            Image newImg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(newImg);
        }
        catch (NullPointerException npe) {
            System.out.println("Image is not in correct format.");
        }
        return new ImageIcon();
    }

    /**
     * FAVORITES PANELS
     * @param num
     */
    public void createFavoritesResultPanel(int num){
        //attribute LISTS
        if(favoritesResultPanels == null){
            favoritesResultPanels = new ArrayList<>();

            favoritesResultNameLabel = new ArrayList<>();
            favoritesResultLocationLabel = new ArrayList<>();
            favoritesResultPriceLabel = new ArrayList<>();
            favoritesResultImageLabel = new ArrayList<>();

            favoritesNameLabel = new ArrayList<>();
            favoritesLocationLabel = new ArrayList<>();
            favoritesPriceLabel =  new ArrayList<>();
            favoritesRemoveFavoritesButton = new ArrayList<>();
            favoritesMoreDetailsButton = new ArrayList<>();
        }

        //dynamic elements
        favoritesResultPanels.add(new JPanel());

        JLabel jLabelFavoritesName = new JLabel();
        favoritesResultNameLabel.add(jLabelFavoritesName);

        JLabel jLabelFavoritesLocation = new JLabel();
        favoritesResultLocationLabel.add(jLabelFavoritesLocation);

        JLabel jLabelFavoritesPrice = new JLabel();
        favoritesResultPriceLabel.add(jLabelFavoritesPrice);

        JLabel jLabelFavoritesImage = new JLabel();
        favoritesResultImageLabel.add(jLabelFavoritesImage);

        //fixed elements
        JLabel jLabelFavoritesNameTitle = new JLabel();
        favoritesNameLabel.add(jLabelFavoritesNameTitle);

        JLabel jLabelFavoritesLocationTitle = new JLabel();
        favoritesLocationLabel.add(jLabelFavoritesLocationTitle);

        JLabel jLabelFavoritesPriceTitle = new JLabel();
        favoritesPriceLabel.add(jLabelFavoritesPriceTitle);

        JButton jButtonFavoritesRemoveFavorites = new JButton();
        favoritesRemoveFavoritesButton.add(jButtonFavoritesRemoveFavorites);

        JButton jButtonFavoritesMoreDetails = new JButton();
        //favoritesMoreDetailsButton.add(jButtonFavoritesMoreDetails);

        ///styling
        favoritesLocationLabel.get(num).setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        favoritesLocationLabel.get(num).setText("Location:");

        favoritesResultNameLabel.get(num).setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        favoritesResultNameLabel.get(num).setText("<name>");

        favoritesNameLabel.get(num).setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        favoritesNameLabel.get(num).setText("Property name:");

        favoritesResultLocationLabel.get(num).setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        favoritesResultLocationLabel.get(num).setText("<location>");

        favoritesPriceLabel.get(num).setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        favoritesPriceLabel.get(num).setText("Price per night: ");

        favoritesResultPriceLabel.get(num).setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        favoritesResultPriceLabel.get(num).setText("<price>");

        //favoritesMoreDetailsButton.get(num).setText("See more details...");
        /*favoritesMoreDetailsButton.get(num).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton10ActionPerformed(evt);
            }
        });*/

        favoritesResultImageLabel.get(num).setBackground(new java.awt.Color(255, 204, 204));
        favoritesResultImageLabel.get(num).setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        favoritesResultImageLabel.get(num).setText("<imageHere>");

        favoritesRemoveFavoritesButton.get(num).setText("Remove from fav");
        favoritesRemoveFavoritesButton.get(num).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton14jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout favoritesPropertyPanel1Layout = new javax.swing.GroupLayout(favoritesResultPanels.get(num));
        favoritesResultPanels.get(num).setLayout(favoritesPropertyPanel1Layout);
        favoritesPropertyPanel1Layout.setHorizontalGroup(
                favoritesPropertyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(favoritesPropertyPanel1Layout.createSequentialGroup()
                                .addGroup(favoritesPropertyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(favoritesPropertyPanel1Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(favoritesPropertyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(favoritesPriceLabel.get(num), javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                                        .addComponent(favoritesLocationLabel.get(num), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(favoritesNameLabel.get(num), javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(favoritesPropertyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, favoritesPropertyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(favoritesResultNameLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(favoritesResultLocationLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(favoritesResultPriceLabel.get(num), javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(favoritesPropertyPanel1Layout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addGroup(favoritesPropertyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        //.addComponent(favoritesMoreDetailsButton.get(num), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(favoritesRemoveFavoritesButton.get(num), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(favoritesResultImageLabel.get(num), javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                                .addContainerGap())
        );
        favoritesPropertyPanel1Layout.setVerticalGroup(
                favoritesPropertyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(favoritesPropertyPanel1Layout.createSequentialGroup()
                                .addGroup(favoritesPropertyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(favoritesPropertyPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(favoritesPropertyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(favoritesNameLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(favoritesResultNameLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(favoritesPropertyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(favoritesLocationLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(favoritesResultLocationLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(favoritesPropertyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(favoritesPriceLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(favoritesResultPriceLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                                .addComponent(favoritesRemoveFavoritesButton.get(num))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                //.addComponent(favoritesMoreDetailsButton.get(num)))
                                        .addComponent(favoritesResultImageLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 16, Short.MAX_VALUE))
        );
    }

    /**
     * create one search result panel
     * store all generated elements in lists - set text and image in controller based on results
     * @use first createSearchResultPanel(int num), next add to main searchPanel .attachSearchResultPanels()
     * @param num index of element that will be created
     */
    public void createSearchResultPanel(int num){
        if(searchResultPanels == null) {
            searchResultPanels = new ArrayList<>();
            searchResultNameLabel = new ArrayList<>();
            searchResultLocationLabel = new ArrayList<>();
            searchResultPriceLabel = new ArrayList<>();
            searchResultImageLabel = new ArrayList<>();

            searchNameLabel = new ArrayList<>();
            searchLocationLabel = new ArrayList<>();
            searchPriceLabel = new ArrayList<>();
            searchAddFavoritesButton = new ArrayList<>();
            searchMoreDetailsButton = new ArrayList<>();
        }

        //dynamic elements
        searchResultPanels.add(new JPanel());

        JLabel jLabelSearchName = new JLabel();
        searchResultNameLabel.add(jLabelSearchName);

        JLabel jLabelSearchLocation = new JLabel();
        searchResultLocationLabel.add(jLabelSearchLocation);

        JLabel jLabelSearchPrice = new JLabel();
        searchResultPriceLabel.add(jLabelSearchPrice);

        JLabel jLabelSearchImage = new JLabel();
        searchResultImageLabel.add(jLabelSearchImage);

        //fixed elements
        JLabel jLabelSearchNameTitle = new JLabel();
        searchNameLabel.add(jLabelSearchNameTitle);

        JLabel jLabelSearchLocationTitle = new JLabel();
        searchLocationLabel.add(jLabelSearchLocationTitle);

        JLabel jLabelSearchPriceTitle = new JLabel();
        searchPriceLabel.add(jLabelSearchPriceTitle);

       /* JButton jButtonSearchAddFavorites = new JButton();
        searchAddFavoritesButton.add(jButtonSearchAddFavorites);*/

        //JButton jButtonSearchMoreDetails = new JButton();
        //searchMoreDetailsButton.add(jButtonSearchMoreDetails);


        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(searchResultPanels.get(num));
        searchResultPanels.get(num).setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(searchLocationLabel.get(num), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(searchNameLabel.get(num), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(searchPriceLabel.get(num), javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(searchResultNameLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(searchResultLocationLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(searchResultPriceLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        /*.addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(92, 92, 92))
                                                //.addComponent(searchAddFavoritesButton.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(73, 73, 73)))
                                               // .addComponent(searchMoreDetailsButton.get(num))))*/
                                //.addGap(18, 18, 18)
                                .addComponent(searchResultImageLabel.get(num), javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
        );

        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchNameLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchResultNameLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchLocationLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchResultLocationLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchPriceLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchResultPriceLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(100, 100, 100))
                                //.addComponent(searchAddFavoritesButton.get(num))
                                //.addGap(18, 18, 18)
                                //.addComponent(searchMoreDetailsButton.get(num))
                                //.addGap(112, 112, 112))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(searchResultImageLabel.get(num), javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        //styling
        searchLocationLabel.get(num).setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchLocationLabel.get(num).setText("Location:");

        searchResultNameLabel.get(num).setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchResultNameLabel.get(num).setText("<name>");

        searchNameLabel.get(num).setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchNameLabel.get(num).setText("Property name:");


        searchResultLocationLabel.get(num).setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchResultLocationLabel.get(num).setText("<location>");


        searchPriceLabel.get(num).setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchPriceLabel.get(num).setText("Price per night: ");


        searchResultPriceLabel.get(num).setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchResultPriceLabel.get(num).setText("<price>");


        searchResultImageLabel.get(num).setBackground(new java.awt.Color(255, 204, 204));
        searchResultImageLabel.get(num).setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchResultImageLabel.get(num).setText("<imageHere>");


       /* searchMoreDetailsButton.get(num).setText("See more details...");
        searchMoreDetailsButton.get(num).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton4ActionPerformed(evt);
            }
        });*/

       /* searchAddFavoritesButton.get(num).setText("Add to favorites");
        searchAddFavoritesButton.get(num).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton8ActionPerformed(evt);
            }
        });*/
    }

    /**
     * @param gl groupLayout of panel that will hold multiple generated search/favorite result panels
     * @return g grouped generated panels vertically, ready to attach to one main panel using attachSearchResultPanels()
     */
    public javax.swing.GroupLayout.Group getVerticalSearchGroup(GroupLayout gl, ArrayList<JPanel> resultPanels){
        javax.swing.GroupLayout.Group g = gl.createParallelGroup();
        if(resultPanels!=null) {
            javax.swing.GroupLayout.Group gSequential = gl.createSequentialGroup();
            for (int i = 0; i < resultPanels.size(); i++) {
                gSequential.addGap(24, 24, 24).addComponent(resultPanels.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)

                ;
            }
            g.addGroup(gSequential);
        }
        return g;
    }

    /**
     * @param gl groupLayout of panel that will hold multiple generated search/favorite result panels
     * @return g grouped generated panels horizontally, ready to attach to one main panel using attachSearchResultPanels()
     */
    public javax.swing.GroupLayout.Group getHorizontalSearchGroup(GroupLayout gl,  ArrayList<JPanel> resultPanels){
        javax.swing.GroupLayout.Group g = gl.createSequentialGroup();
        if(resultPanels!=null) {
            //javax.swing.GroupLayout.Group g = gl.createSequentialGroup();
            javax.swing.GroupLayout.Group gSequential = gl.createParallelGroup();
            for (int i = 0; i < resultPanels.size(); i++) {

                gSequential.addComponent(resultPanels.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                ;
            }
            g.addGroup(gSequential);
        }
        return g;
    }

    /**
     * toggle dynamic search result elements visibility
     * @param index element to hide/show
     * @param toggle
     */
    public void resetSearchResultPanels(int index, boolean toggle) {
        getSearchResultPanels().get(index).setVisible(toggle);

        getSearchResultLocationLabel().get(index).setVisible(toggle);
        getSearchResultNameLabel().get(index).setVisible(toggle);
        getSearchResultImageLabel().get(index).setVisible(toggle);
        getSearchResultPriceLabel().get(index).setVisible(toggle);

        getSearchLocationLabel().get(index).setVisible(toggle);
        getSearchPriceLabel().get(index).setVisible(toggle);
        getSearchNameLabel().get(index).setVisible(toggle);
        //getSearchAddFavoritesButton().get(index).setVisible(toggle);
        //getSearchMoreDetailsButton().get(index).setVisible(toggle);
    }

    /**
     * remove element from list, used when switching search results
     * @param index location of element to remove
     */
    public void removeSearchResultPanels(int index){
        getSearchResultPanels().remove(index);

        getSearchResultLocationLabel().remove(index);
        getSearchResultNameLabel().remove(index);
        getSearchResultImageLabel().remove(index);
        getSearchResultPriceLabel().remove(index);

        getSearchLocationLabel().remove(index);
        getSearchPriceLabel().remove(index);
        getSearchNameLabel().remove(index);
       // getSearchAddFavoritesButton().remove(index);
        //getSearchMoreDetailsButton().remove(index);
    }

    /**
     * toggle dynamic search result elements visibility
     * @param index element to hide/show
     * @param toggle
     */
    public void resetFavoritesResultPanels(int index, boolean toggle) {
        getFavoritesResultPanels().get(index).setVisible(toggle);

        getFavoritesResultLocationLabel().get(index).setVisible(toggle);
        getFavoritesResultNameLabel().get(index).setVisible(toggle);
        getFavoritesResultImageLabel().get(index).setVisible(toggle);
        getFavoritesResultPriceLabel().get(index).setVisible(toggle);

        getFavoritesLocationLabel().get(index).setVisible(toggle);
        getFavoritesPriceLabel().get(index).setVisible(toggle);
        getFavoritesNameLabel().get(index).setVisible(toggle);
        getFavoritesRemoveFavoritesButton().get(index).setVisible(toggle);
        //getFavoritesMoreDetailsButton().get(index).setVisible(toggle);
    }

    /**
     * remove element from list, used when switching search results
     * @param index location of element to remove
     */
    public void removeFavoritesResultPanels(int index){
        getFavoritesResultPanels().remove(index);

        getFavoritesResultLocationLabel().remove(index);
        getFavoritesResultNameLabel().remove(index);
        getFavoritesResultImageLabel().remove(index);
        getFavoritesResultPriceLabel().remove(index);

        getFavoritesLocationLabel().remove(index);
        getFavoritesPriceLabel().remove(index);
        getFavoritesNameLabel().remove(index);
        getFavoritesRemoveFavoritesButton().remove(index);
        //getFavoritesMoreDetailsButton().remove(index);
    }


    /**
     * create layout, attach generated panels to one searchPanelContainer
     * @use getHorizontalSearchGroup(GroupLayout gl) and getVerticalSearchGroup(GroupLayout gl)
     */
    public void attachSearchResultPanels(){
        //set new layout
        javax.swing.GroupLayout newSearchLayout = new javax.swing.GroupLayout(getSearchPanelContainer());
        getSearchPanelContainer().setLayout(newSearchLayout);

        //add generated panels horizontal
        newSearchLayout.setHorizontalGroup(
                newSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(getHorizontalSearchGroup(newSearchLayout, searchResultPanels))

        );

        //add generated panels vertical
        newSearchLayout.setVerticalGroup(
                newSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(getVerticalSearchGroup(newSearchLayout, searchResultPanels))

        );
        //searchPanelContainer is already in main search searchPanel
    }

    /**
     * create layout, attach generated panels to one favoritesPropertiesPanel
     * @use getHorizontalSearchGroup(GroupLayout gl) and getVerticalSearchGroup(GroupLayout gl)
     */
    public void attachFavoritesResultPanels(){
        //set new layout
        javax.swing.GroupLayout newFavoritesLayout = new javax.swing.GroupLayout(favoritesPropertiesPanel);
        favoritesPropertiesPanel.setLayout(newFavoritesLayout);

        //add generated panels horizontal
        newFavoritesLayout.setHorizontalGroup(
                newFavoritesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(getHorizontalSearchGroup(newFavoritesLayout, favoritesResultPanels))

        );

        //add generated panels vertical
        newFavoritesLayout.setVerticalGroup(
                newFavoritesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(getVerticalSearchGroup(newFavoritesLayout, favoritesResultPanels))

        );
        //searchPanelContainer is already in main search searchPanel
    }

    public JDateChooser getjDateChooserExpirationDate() {
        return jDateChooserExpirationDate;
    }

    /**
     *  variable declaration
     */
    private com.toedter.calendar.JDateChooser jDateChooserExpirationDate;
    private javax.swing.JPanel favoritesPanel;
    private javax.swing.JPanel favoritesPropertiesPanel;
    private javax.swing.JPanel favoritesPropertyPanel1;
    private javax.swing.JScrollPane favoritesScrollPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton saveSettingsButton;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton logOutButton;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelLogOutUsername;
    private javax.swing.JLabel jLabelSearchInputName2;
    private javax.swing.JLabel jLabelSearchLocation2;
    private javax.swing.JLabel jLabelSearchPrice2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextFieldBillingAddress;
    private javax.swing.JTextField jTextFieldBillingCVC;
    private javax.swing.JTextField jTextFieldBillingExpirationDate;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextFieldContactEmail;
    private javax.swing.JTextField jTextFieldContactFullName;
    private javax.swing.JTextField jTextFieldContactZip;
    private javax.swing.JTextField jTextFieldContactCity;
    private javax.swing.JTextField jTextFieldContactStreet;
    private javax.swing.JTextField jTextFieldBillingOwnerName;
    private javax.swing.JTextField jTextFieldBillingCardNumber;
    private javax.swing.JPanel myRentalsPanel;
    private javax.swing.JScrollPane myRentalsScrollPane;
    private javax.swing.JPanel rentPanel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JScrollPane searchScrollPane;
    private javax.swing.JPanel settingsPanel;

    private ButtonGroup buttonGroup;

    public JPanel getSearchPanelContainer() {
        return searchPanelContainer;
    }

    //FAVORITES
    private ArrayList<JPanel> favoritesResultPanels;

    private ArrayList<JLabel> favoritesResultNameLabel;
    private ArrayList<JLabel> favoritesResultLocationLabel;
    private ArrayList<JLabel> favoritesResultPriceLabel;
    private ArrayList<JLabel> favoritesResultImageLabel;

    private ArrayList<JLabel> favoritesNameLabel;
    private ArrayList<JLabel> favoritesLocationLabel;
    private ArrayList<JLabel> favoritesPriceLabel;
    private ArrayList<JButton> favoritesRemoveFavoritesButton;
    private ArrayList<JButton> favoritesMoreDetailsButton;
    //END FAVORITES

    private javax.swing.JPanel searchPanelContainer;
    // search panel dynamic elements
    private ArrayList<JPanel> searchResultPanels;
    private ArrayList<JLabel> searchResultNameLabel;
    private ArrayList<JLabel> searchResultLocationLabel;
    private ArrayList<JLabel> searchResultPriceLabel;
    private ArrayList<JLabel> searchResultImageLabel;

    //non-dynamic labels and buttons
    private ArrayList<JLabel> searchNameLabel;
    private ArrayList<JLabel> searchLocationLabel;
    private ArrayList<JLabel> searchPriceLabel;
    private ArrayList<JButton> searchAddFavoritesButton;
    private ArrayList<JButton> searchMoreDetailsButton;


    /** End of variables declaration **/
}
