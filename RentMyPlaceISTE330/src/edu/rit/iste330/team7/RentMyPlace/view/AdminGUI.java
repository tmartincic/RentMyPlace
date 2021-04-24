package edu.rit.iste330.team7.RentMyPlace.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminGUI extends JFrame{
    private JList jListUsersInfo;
    private JPanel main;
    private JPanel usersSection;
    private JPanel buttonsPanel;
    private JButton buttonPromote;
    private JButton buttonDemote;
    private JLabel title;
    private String[] usersList;
    private JButton buttonRemove;

    /**
     * constructor, load components and set Nimbus LookAndFeel
     */
    public AdminGUI() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        initComponents();

    }
    // <editor-fold defaultstate="collapsed" desc="GUI Code">
    private void initComponents(){
        main = new JPanel(new GridLayout(0,1));

        usersSection = new JPanel(new GridLayout(0,1));

        title = new JLabel("", JLabel.CENTER);
        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        buttonRemove = new JButton("Remove user");
        buttonPromote = new JButton("Promote to admin");
        buttonDemote = new JButton("Demote to user");
        buttonRemove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonPromote.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonDemote.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jListUsersInfo = new JList();
        jListUsersInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usersSection.add(jListUsersInfo);

        buttonsPanel.add(buttonRemove);
        buttonsPanel.add(buttonPromote);
        buttonsPanel.add(buttonDemote);

        main.add(title);
        main.add(usersSection);
        main.add(buttonsPanel);

        add(main);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(new java.awt.Dimension(535, 343));
        setResizable(true);
    }// </editor-fold>

    /**
     * GETTERS
     */
    public JList getjListUsersInfo() {
        return jListUsersInfo;
    }

    public String[] getUsersList() {
        return usersList;
    }

    public JButton getButtonRemove() {
        return buttonRemove;
    }

    public JButton getButtonDemote() {
        return buttonDemote;
    }

    public JButton getButtonPromote() {
        return buttonPromote;
    }

    /**
     * Takes a list of users and adds them to JList
     * @param users ArrayList of users in database
     * @return usersList
     */
    public String[] addUsers(ArrayList<String> users){
        usersList = new String[users.size()];
        for (int i = 0; i < users.size(); i++) {
            usersList[i] = users.get(i);
        }
        jListUsersInfo.setListData(users.toArray());

        return usersList;
    }

    /**
     * Set welcoming title
     * @param name of currentUser
     */
    public void setName(String name){
        String result = "Welcome admin: " + name;
        title.setText(result);
    }

    /**
     * @param ae click on remove user button
     */
    public void addRemoveUserListener(ActionListener ae){
        this.getButtonRemove().addActionListener(ae);
    }

    /**
     * @param ae click on promote user button
     */
    public void addPromoteUserListener(ActionListener ae){
        this.getButtonPromote().addActionListener(ae);
    }

    /**
     * @param ae click on demote user button
     */
    public void addDemoteUserListener(ActionListener ae){
        this.getButtonDemote().addActionListener(ae);
    }



}
