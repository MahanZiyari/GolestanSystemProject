/*
 * Created by JFormDesigner on Tue Dec 17 21:40:54 IRST 2019
 */

package view;

import java.awt.event.*;
import controller.CaptchaController;
import controller.CaptchaException;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author mahan
 */
public class CaptchaWindow extends JFrame {
    //private String captcha;
    public CaptchaWindow() {
        initComponents();
        this.setVisible(true);
        captchaLabel.setText(CaptchaController.getInstance().getCaptcha());
    }

    private void refreshButtonMouseClicked(MouseEvent e) {
        captchaLabel.setText(CaptchaController.getInstance().getCaptcha());
    }

    private void refreshButtonKeyReleased(KeyEvent e) {
        captchaLabel.setText(CaptchaController.getInstance().getCaptcha());
    }

    private void sendButtonMouseClicked(MouseEvent e) {
        int state = 0;
        try {
            CaptchaController.getInstance().checkCaptcha(captchaLabel.getText(), captchaField.getText());
        } catch (CaptchaException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", 0);
            captchaLabel.setText(CaptchaController.getInstance().getCaptcha());
            state++;
        }
        if (state == 0)
            this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - nazanin
        captchaLabel = new JLabel();
        captchaField = new JTextField();
        textLbl = new JLabel();
        sendButton = new JButton();
        refreshButton = new JButton();
        icon = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //---- captchaLabel ----
        captchaLabel.setText("text");
        captchaLabel.setFont(new Font("Wide Latin", Font.PLAIN, 20));

        //---- captchaField ----
        captchaField.setFont(captchaField.getFont().deriveFont(captchaField.getFont().getSize() + 6f));

        //---- textLbl ----
        textLbl.setText("Please Enter The Following Code :");
        textLbl.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));

        //---- sendButton ----
        sendButton.setText("SEND");
        sendButton.setForeground(Color.red);
        sendButton.setBackground(Color.darkGray);
        sendButton.setFont(sendButton.getFont().deriveFont(sendButton.getFont().getSize() + 4f));
        sendButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sendButtonMouseClicked(e);
            }
        });

        //---- refreshButton ----
        refreshButton.setIcon(new ImageIcon(getClass().getResource("/view/download.png")));
        refreshButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                refreshButtonMouseClicked(e);
            }
        });
        refreshButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                refreshButtonKeyReleased(e);
            }
        });

        //---- icon ----
        icon.setHorizontalAlignment(SwingConstants.CENTER);
        icon.setIcon(new ImageIcon(getClass().getResource("/view/Captcha Icon.png")));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(textLbl, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(captchaLabel, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(captchaField, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(refreshButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(icon)
                    .addContainerGap(38, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(captchaLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(captchaField, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(refreshButton))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(icon, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                    .addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - nazanin
    private JLabel captchaLabel;
    private JTextField captchaField;
    private JLabel textLbl;
    private JButton sendButton;
    private JButton refreshButton;
    private JLabel icon;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
