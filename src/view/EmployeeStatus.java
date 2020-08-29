/*
 * Created by JFormDesigner on Tue Jan 28 13:49:19 IRST 2020
 */

package view;

import java.awt.event.*;
import model.entity.EmployeeEntity;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author nazanin
 */
public class EmployeeStatus extends JFrame
{
    EmployeeEntity entity;

    public EmployeeStatus(EmployeeEntity entity)
    {
        initComponents();
        this.setVisible(true);
        this.entity=entity;
        nameTxt.setText(entity.getName());
        idTxt.setText(String.valueOf(entity.getId()));
        postTxt.setText(entity.getPost());
        salaryTxt.setText(String.valueOf(entity.getSalary()));
    }

    public EmployeeStatus ()
    {
        initComponents();
        this.setVisible(true);
    }

    private void button2MouseClicked(MouseEvent e)
    {
        EmployeeLogStatus employeeLogStatus=new EmployeeLogStatus(entity);
    }

    private void backButtonMouseClicked(MouseEvent e) {
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - nazanin
        titleLbl = new JLabel();
        iconLbl = new JLabel();
        nameLbl = new JLabel();
        idLbl = new JLabel();
        postLbl = new JLabel();
        salaryLbl = new JLabel();
        nameTxt = new JLabel();
        idTxt = new JLabel();
        postTxt = new JLabel();
        salaryTxt = new JLabel();
        backButton = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- titleLbl ----
        titleLbl.setText("\"  Your Last Status : \"");
        titleLbl.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 38));
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);

        //---- iconLbl ----
        iconLbl.setIcon(new ImageIcon(getClass().getResource("/view/status-179x179.png")));

        //---- nameLbl ----
        nameLbl.setText("Name :");
        nameLbl.setFont(new Font("Sitka Text", Font.ITALIC, 28));

        //---- idLbl ----
        idLbl.setText("ID :");
        idLbl.setFont(new Font("Sitka Text", Font.ITALIC, 28));

        //---- postLbl ----
        postLbl.setText("Post :");
        postLbl.setFont(new Font("Sitka Text", Font.ITALIC, 28));

        //---- salaryLbl ----
        salaryLbl.setText("Salary :");
        salaryLbl.setFont(new Font("Sitka Text", Font.ITALIC, 28));

        //---- nameTxt ----
        nameTxt.setBackground(new Color(232, 232, 232, 232));
        nameTxt.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 24));

        //---- idTxt ----
        idTxt.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 24));

        //---- postTxt ----
        postTxt.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 24));

        //---- salaryTxt ----
        salaryTxt.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 24));

        //---- backButton ----
        backButton.setText("Back");
        backButton.setFont(backButton.getFont().deriveFont(backButton.getFont().getSize() + 2f));
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backButtonMouseClicked(e);
            }
        });

        //---- button2 ----
        button2.setText("Show Requests");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 2f));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(iconLbl, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(titleLbl, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(200, 200, 200)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(nameLbl, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                .addComponent(idLbl, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                .addComponent(postLbl, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                .addComponent(salaryLbl, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                            .addGap(80, 80, 80)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(salaryTxt, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                                .addComponent(postTxt, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                                .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                                .addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(156, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 450, Short.MAX_VALUE)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                    .addGap(19, 19, 19))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(iconLbl))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(titleLbl, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLbl, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idLbl, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(postLbl, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addComponent(postTxt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(salaryLbl, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addComponent(salaryTxt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(backButton)
                        .addComponent(button2))
                    .addGap(23, 23, 23))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - nazanin
    private JLabel titleLbl;
    private JLabel iconLbl;
    private JLabel nameLbl;
    private JLabel idLbl;
    private JLabel postLbl;
    private JLabel salaryLbl;
    private JLabel nameTxt;
    private JLabel idTxt;
    private JLabel postTxt;
    private JLabel salaryTxt;
    private JButton backButton;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
