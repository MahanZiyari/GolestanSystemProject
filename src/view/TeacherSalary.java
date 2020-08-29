/*
 * Created by JFormDesigner on Wed Jan 15 14:43:12 IRST 2020
 */

package view;

import controller.EmployeeIncomeController;
import controller.TeacherIncomeController;
import model.entity.TeacherEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author nazanin
 */
public class TeacherSalary extends JFrame
{
    TeacherEntity entity;
    String income;
    public TeacherSalary(TeacherEntity entity)
    {

        initComponents();
        this.entity=entity;
        this.setVisible(true);
        initializer();
    }
    public TeacherSalary()
    {
        initComponents();
        this.setVisible(true);
    }
    private void initializer()
    {
        try {
            income=String.valueOf(TeacherIncomeController.getInstance().CalculateSalary(entity));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error While Calculating Salary",
                    "Alert",JOptionPane.WARNING_MESSAGE);
        }
        this.setVisible(true);
        incomeTxt.setText(income);
    }

    private void backButtonMouseClicked(MouseEvent e)
    {
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - nazanin
        incomeLbl = new JLabel();
        incomeTxt = new JTextField();
        backButton = new JButton();
        iconLbl = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //---- incomeLbl ----
        incomeLbl.setText("\" Your Income Of This Semester : \"");
        incomeLbl.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 26));
        incomeLbl.setHorizontalAlignment(SwingConstants.CENTER);

        //---- incomeTxt ----
        incomeTxt.setBackground(UIManager.getColor("Button.darcula.disabledText.shadow"));

        //---- backButton ----
        backButton.setText("BACK");
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backButtonMouseClicked(e);
            }
        });

        //---- iconLbl ----
        iconLbl.setIcon(new ImageIcon("C:\\Users\\Dear User\\Desktop\\Golestan-System-master\\src\\view\\income-128x128.png"));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 649, Short.MAX_VALUE)
                    .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(78, 78, 78)
                    .addComponent(iconLbl)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(incomeTxt, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(198, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(112, Short.MAX_VALUE)
                    .addComponent(incomeLbl, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE)
                    .addGap(106, 106, 106))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(incomeLbl, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(iconLbl))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(incomeTxt, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                    .addComponent(backButton)
                    .addGap(21, 21, 21))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - nazanin
    private JLabel incomeLbl;
    private JTextField incomeTxt;
    private JButton backButton;
    private JLabel iconLbl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
