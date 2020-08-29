package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Tue Dec 17 20:54:18 IRST 2019
 */



/**
 * @author mahan
 */
public class GreetingWindow extends JFrame {
    public GreetingWindow() {
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        initComponents();
    }

    private void exitButtonMouseClicked(MouseEvent e) {
        System.exit(0);
    }

    private void exitButtonKeyReleased(KeyEvent e) {
        System.exit(0);
    }

    private void loginButtonMouseClicked(MouseEvent e) {
        CaptchaWindow window = new CaptchaWindow();
        //LoginWindow window = new LoginWindow();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mahan
        loginButton = new JButton();
        exitButton = new JButton();
        iconLbl = new JLabel();
        uscIcon2 = new JLabel();
        uscIcon1 = new JLabel();

        //======== this ========
        setForeground(Color.black);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- loginButton ----
        loginButton.setText("LOG IN");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginButtonMouseClicked(e);
            }
        });
        contentPane.add(loginButton);
        loginButton.setBounds(371, 304, 100, loginButton.getPreferredSize().height);

        //---- exitButton ----
        exitButton.setText("EXIT");
        exitButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exitButtonMouseClicked(e);
            }
        });
        exitButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                exitButtonKeyReleased(e);
            }
        });
        contentPane.add(exitButton);
        exitButton.setBounds(371, 360, 100, exitButton.getPreferredSize().height);

        //---- iconLbl ----
        iconLbl.setHorizontalAlignment(SwingConstants.CENTER);
        iconLbl.setIcon(new ImageIcon(getClass().getResource("/view/golestan.jpg")));
        contentPane.add(iconLbl);
        iconLbl.setBounds(210, 0, 428, 218);

        //---- uscIcon2 ----
        uscIcon2.setHorizontalAlignment(SwingConstants.CENTER);
        uscIcon2.setIcon(new ImageIcon(getClass().getResource("/view/uscIcon1.png")));
        contentPane.add(uscIcon2);
        uscIcon2.setBounds(656, 14, 198, 190);

        //---- uscIcon1 ----
        uscIcon1.setHorizontalAlignment(SwingConstants.CENTER);
        uscIcon1.setIcon(new ImageIcon(getClass().getResource("/view/uscIcon1.png")));
        contentPane.add(uscIcon1);
        uscIcon1.setBounds(6, 6, 198, 190);

        contentPane.setPreferredSize(new Dimension(894, 445));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mahan
    private JButton loginButton;
    private JButton exitButton;
    private JLabel iconLbl;
    private JLabel uscIcon2;
    private JLabel uscIcon1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
