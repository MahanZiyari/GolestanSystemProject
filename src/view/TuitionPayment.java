/*
 * Created by JFormDesigner on Wed Dec 25 18:07:42 IRST 2019
 */

package view;

import controller.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author nazanin
 */
public class TuitionPayment extends JFrame {
    public TuitionPayment() {
        initComponents();
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        captchaTextLabel.setText(CaptchaController.getInstance().getCaptcha());
    }

    private void refreshButtonMouseClicked(MouseEvent e)
    {
        captchaTextLabel.setText(CaptchaController.getInstance().getCaptcha());
    }

    private void payButtonMouseClicked(MouseEvent e)
    {

        try {
            PaymentController.getInstance().fieldsChecker(cardNumTxt.getText(), secondPassField.getText(),
                    cvv2Txt.getText(), yearTxt.getText(), monthTxt.getText(), captchaCodeTxt.getText());
            PaymentController.getInstance().checkCaptchaCode(captchaTextLabel.getText(), captchaCodeTxt.getText());

            PaymentController.getInstance().payment(cardNumTxt.getText(), secondPassField.getText());
        } catch (BlankException e1) {
            System.out.println("Blank Fields");
        } catch (CaptchaException e1) {
            JOptionPane.showMessageDialog(null, "Wrong Captcha Code! Try Again",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (CardNotFoundException e1) {
            System.out.println("card not found");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void cancelButtonMouseClicked(MouseEvent e)
    {
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mahan
        secondPassLabel = new JLabel();
        cvv2Label = new JLabel();
        cvv2Txt = new JTextField();
        expirationDateLabel = new JLabel();
        yearTxt = new JTextField();
        dateSeparatorLbl = new JLabel();
        monthTxt = new JTextField();
        PaymentPortalLabel = new JLabel();
        cardNumLabel = new JLabel();
        payButton = new JButton();
        cancelButton = new JButton();
        iconLbl = new JLabel();
        tokenCodeLabel = new JLabel();
        captchaCodeTxt = new JTextField();
        secondPassField = new JPasswordField();
        captchaTextLabel = new JLabel();
        refreshButton = new JButton();
        cardNumTxt = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();

        //---- secondPassLabel ----
        secondPassLabel.setText("Card's Second Password :");
        secondPassLabel.setBackground(new Color(253, 234, 226));
        secondPassLabel.setFont(secondPassLabel.getFont().deriveFont(secondPassLabel.getFont().getSize() + 2f));

        //---- cvv2Label ----
        cvv2Label.setText("CVV2 :");
        cvv2Label.setBackground(new Color(253, 234, 226));
        cvv2Label.setFont(cvv2Label.getFont().deriveFont(cvv2Label.getFont().getSize() + 2f));

        //---- cvv2Txt ----
        cvv2Txt.setBackground(new Color(209, 233, 250));

        //---- expirationDateLabel ----
        expirationDateLabel.setText("Card Expiration Date :");
        expirationDateLabel.setBackground(new Color(253, 234, 226));
        expirationDateLabel.setFont(expirationDateLabel.getFont().deriveFont(expirationDateLabel.getFont().getSize() + 2f));

        //---- yearTxt ----
        yearTxt.setBackground(new Color(209, 233, 250));

        //---- dateSeparatorLbl ----
        dateSeparatorLbl.setText("/");
        dateSeparatorLbl.setFont(dateSeparatorLbl.getFont().deriveFont(dateSeparatorLbl.getFont().getStyle() & ~Font.BOLD, dateSeparatorLbl.getFont().getSize() + 4f));
        dateSeparatorLbl.setHorizontalAlignment(SwingConstants.CENTER);

        //---- monthTxt ----
        monthTxt.setBackground(new Color(209, 233, 250));

        //---- PaymentPortalLabel ----
        PaymentPortalLabel.setText("Payment Portal");
        PaymentPortalLabel.setBackground(new Color(255, 102, 102));
        PaymentPortalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        PaymentPortalLabel.setFont(new Font("Bell MT", Font.BOLD, 45));

        //---- cardNumLabel ----
        cardNumLabel.setText("Card Number :");
        cardNumLabel.setFont(cardNumLabel.getFont().deriveFont(cardNumLabel.getFont().getSize() + 2f));
        cardNumLabel.setBackground(new Color(253, 234, 226));

        //---- payButton ----
        payButton.setText("Pay");
        payButton.setBackground(new Color(255, 229, 229));
        payButton.setFont(payButton.getFont().deriveFont(payButton.getFont().getSize() + 2f));
        payButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                payButtonMouseClicked(e);
            }
        });

        //---- cancelButton ----
        cancelButton.setText("Cancel");
        cancelButton.setBackground(new Color(255, 229, 229));
        cancelButton.setFont(cancelButton.getFont().deriveFont(cancelButton.getFont().getSize() + 2f));
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cancelButtonMouseClicked(e);
            }
        });

        //---- iconLbl ----
        iconLbl.setIcon(new ImageIcon(getClass().getResource("/view/PicsArt_12-25-08.17.52.jpg")));
        iconLbl.setHorizontalAlignment(SwingConstants.CENTER);

        //---- tokenCodeLabel ----
        tokenCodeLabel.setText("Enter the following code:");
        tokenCodeLabel.setFont(tokenCodeLabel.getFont().deriveFont(tokenCodeLabel.getFont().getSize() + 2f));

        //---- captchaCodeTxt ----
        captchaCodeTxt.setBackground(new Color(209, 233, 250));

        //---- secondPassField ----
        secondPassField.setBackground(new Color(209, 233, 250));

        //---- captchaTextLabel ----
        captchaTextLabel.setFont(new Font("Wide Latin", Font.BOLD, 25));

        //---- refreshButton ----
        refreshButton.setIcon(new ImageIcon(getClass().getResource("/view/download.png")));
        refreshButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                refreshButtonMouseClicked(e);
            }
        });

        //---- cardNumTxt ----
        cardNumTxt.setBackground(new Color(209, 233, 250));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(cardNumLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(expirationDateLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cvv2Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(secondPassLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                            .addComponent(yearTxt, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(dateSeparatorLbl, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(monthTxt, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(cardNumTxt, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                                        .addComponent(secondPassField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                                        .addComponent(cvv2Txt, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
                                    .addGap(25, 25, 25))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(tokenCodeLabel, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(captchaCodeTxt, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)))
                            .addComponent(iconLbl, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(payButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(captchaTextLabel, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(refreshButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGap(15, 15, 15))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(198, 198, 198)
                    .addComponent(PaymentPortalLabel, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PaymentPortalLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(71, 71, 71)
                                    .addComponent(cardNumLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cardNumTxt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(secondPassField)
                                .addComponent(secondPassLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(cvv2Label, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cvv2Txt, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(expirationDateLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addComponent(yearTxt, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(dateSeparatorLbl, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addComponent(monthTxt, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(tokenCodeLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(captchaCodeTxt, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(captchaTextLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                .addComponent(refreshButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                            .addGap(129, 129, 129))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(iconLbl, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                            .addGap(241, 241, 241)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(payButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25))))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mahan
    private JLabel secondPassLabel;
    private JLabel cvv2Label;
    private JTextField cvv2Txt;
    private JLabel expirationDateLabel;
    private JTextField yearTxt;
    private JLabel dateSeparatorLbl;
    private JTextField monthTxt;
    private JLabel PaymentPortalLabel;
    private JLabel cardNumLabel;
    private JButton payButton;
    private JButton cancelButton;
    private JLabel iconLbl;
    private JLabel tokenCodeLabel;
    private JTextField captchaCodeTxt;
    private JPasswordField secondPassField;
    private JLabel captchaTextLabel;
    private JButton refreshButton;
    private JTextField cardNumTxt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
