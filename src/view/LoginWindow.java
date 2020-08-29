/*
 * Created by JFormDesigner on Tue Dec 17 22:44:36 IRST 2019
 */

package view;

import controller.LoginController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author mahan
 */
public class LoginWindow extends JFrame {
    public LoginWindow() {
        initComponents();
        this.setVisible(true);
    }

    private void loginButtonMouseClicked(MouseEvent e) {
        try {
            LoginController.getInstance().navigator(userNameField.getText(), passwordField.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", 0);
        }

    }

    private void exitButtonMouseClicked(MouseEvent e) {
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - nazanin
        userNameField = new JTextField();
        usernameLbl = new JLabel();
        passLbl = new JLabel();
        golestanLbl = new JLabel();
        passwordField = new JPasswordField();
        loginButton = new JButton();
        exitButton = new JButton();
        uscIcon = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //---- userNameField ----
        userNameField.setText("971113024");

        //---- usernameLbl ----
        usernameLbl.setText("USERNAME :");
        usernameLbl.setFont(usernameLbl.getFont().deriveFont(usernameLbl.getFont().getSize() + 4f));

        //---- passLbl ----
        passLbl.setText("PASSWORD :");
        passLbl.setFont(passLbl.getFont().deriveFont(passLbl.getFont().getSize() + 4f));

        //---- golestanLbl ----
        golestanLbl.setText("\" Comprehensive Academic Golestan System \"");
        golestanLbl.setFont(new Font("Yu Gothic", Font.BOLD, 26));
        golestanLbl.setHorizontalAlignment(SwingConstants.CENTER);

        //---- loginButton ----
        loginButton.setText("LOG IN");
        loginButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        loginButton.setBackground(new Color(255, 249, 86));
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginButtonMouseClicked(e);
            }
        });

        //---- exitButton ----
        exitButton.setText("EXIT");
        exitButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        exitButton.setBackground(new Color(255, 249, 86));
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exitButtonMouseClicked(e);
            }
        });

        //---- uscIcon ----
        uscIcon.setHorizontalAlignment(SwingConstants.CENTER);
        uscIcon.setIcon(new ImageIcon(getClass().getResource("/view/University_of_Science_&_Culture_logo.png")));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(210, 210, 210)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(passLbl, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                .addComponent(usernameLbl, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userNameField, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(342, 342, 342)
                            .addComponent(uscIcon, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(338, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 156, Short.MAX_VALUE)
                    .addComponent(golestanLbl, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
                    .addGap(142, 142, 142))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(uscIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(golestanLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(usernameLbl)
                        .addComponent(userNameField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addGap(11, 11, 11)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passLbl)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                        .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                    .addGap(69, 69, 69))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - nazanin
    private JTextField userNameField;
    private JLabel usernameLbl;
    private JLabel passLbl;
    private JLabel golestanLbl;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton exitButton;
    private JLabel uscIcon;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
