/*
 * Created by JFormDesigner on Wed Jan 29 18:30:20 IRST 2020
 */

package view;

import java.awt.event.*;

import controller.EmployeeIncomeController;
import model.entity.EmployeeEntity;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author nazanin
 */
public class EmployeeSalary extends JFrame
{
    EmployeeEntity employeeEntity;
    String income;
    public EmployeeSalary(EmployeeEntity employeeEntity)
    {
        initComponents();
        this.setVisible(true);
        this.employeeEntity=employeeEntity;
        initializer();
    }
    public EmployeeSalary()
    {
        initComponents();
        this.setVisible(true);
    }
    private void initializer()
    {
        try {
            income = String.valueOf
                    (EmployeeIncomeController.getInstance().CalculateSalary(employeeEntity));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error While Calculating Salary",
                    "Alert",JOptionPane.WARNING_MESSAGE);
        }
        salaryTxt.setText(income);
    }

    private void backButtonMouseClicked(MouseEvent e)
    {
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - nazanin
        salaryLbl = new JLabel();
        iconLbl = new JLabel();
        salaryTxt = new JTextField();
        backButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- salaryLbl ----
        salaryLbl.setText("\" Your Total Salary Is: \"");
        salaryLbl.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
        salaryLbl.setHorizontalAlignment(SwingConstants.CENTER);

        //---- iconLbl ----
        iconLbl.setIcon(new ImageIcon(getClass().getResource("/view/cash-money-salary-investment-512-128x128.png")));

        //---- backButton ----
        backButton.setText("BACK");
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backButtonMouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(101, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(salaryLbl, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
                            .addGap(179, 179, 179))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(iconLbl, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                            .addGap(78, 78, 78)
                            .addComponent(salaryTxt, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                            .addGap(279, 279, 279))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(salaryLbl, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(salaryTxt, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(iconLbl, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                    .addComponent(backButton)
                    .addGap(23, 23, 23))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - nazanin
    private JLabel salaryLbl;
    private JLabel iconLbl;
    private JTextField salaryTxt;
    private JButton backButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
