/*
 * Created by JFormDesigner on Tue Dec 24 18:53:09 IRST 2019
 */

package view;

import java.awt.event.*;
import model.entity.EmployeeEntity;

import java.awt.*;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author mahan
 */
public class EmployeePanel extends JFrame
{
    EmployeeEntity entity;
    public EmployeePanel(EmployeeEntity entity)
    {
        initComponents();
        this.entity=entity;
        nameTxt.setText(entity.getName());
        idTxt.setText(String.valueOf(entity.getId()));
        postTxt.setText(entity.getPost());
        this.setVisible(true);
    }




    private void enterRecordsItemActionPerformed(ActionEvent e)
    {
        try {
            RecordsWindow recordsWindow=new RecordsWindow(entity);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null,
                    "Error While Opening Page!","Alert",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void loanItemActionPerformed(ActionEvent e) {
        try {
            LoanApplyment loanApplyment=new LoanApplyment(entity);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null,"Error While Opening Requests Page!",
                    "Alert",JOptionPane.WARNING_MESSAGE);
        }
    }

    private void salaryItemActionPerformed(ActionEvent e) {
        EmployeeSalary employeeSalary=new EmployeeSalary(entity);
    }

    private void editItemActionPerformed(ActionEvent e) {
        Edit_Information_EmployeeWindow window = new Edit_Information_EmployeeWindow(entity);
    }

    private void statusItemActionPerformed(ActionEvent e) {
        EmployeeStatus status = new EmployeeStatus(entity);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mahan
        EmployeeMenu = new JMenuBar();
        viewMenu = new JMenu();
        salaryItem = new JMenuItem();
        statusItem = new JMenuItem();
        recordsMenu = new JMenu();
        editItem = new JMenuItem();
        enterRecordsItem = new JMenuItem();
        requestMenu = new JMenu();
        loanItem = new JMenuItem();
        nameLbl = new JLabel();
        idLbl = new JLabel();
        postLbl = new JLabel();
        nameTxt = new JLabel();
        idTxt = new JLabel();
        postTxt = new JLabel();
        iconLbl = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //======== EmployeeMenu ========
        {

            //======== viewMenu ========
            {
                viewMenu.setText("View");
                viewMenu.setFont(new Font("Times New Roman", Font.BOLD, 20));

                //---- salaryItem ----
                salaryItem.setText("Salary");
                salaryItem.setFont(salaryItem.getFont().deriveFont(salaryItem.getFont().getSize() + 3f));
                salaryItem.setBackground(new Color(255, 226, 219));
                salaryItem.addActionListener(e -> salaryItemActionPerformed(e));
                viewMenu.add(salaryItem);

                //---- statusItem ----
                statusItem.setText("Full Record Of Employee Latest Status");
                statusItem.setBackground(new Color(255, 226, 219));
                statusItem.setFont(statusItem.getFont().deriveFont(statusItem.getFont().getSize() + 3f));
                statusItem.addActionListener(e -> statusItemActionPerformed(e));
                viewMenu.add(statusItem);
            }
            EmployeeMenu.add(viewMenu);

            //======== recordsMenu ========
            {
                recordsMenu.setText("Records");
                recordsMenu.setFont(new Font("Times New Roman", Font.BOLD, 20));

                //---- editItem ----
                editItem.setText("Edit Information");
                editItem.setBackground(new Color(255, 226, 219));
                editItem.setFont(editItem.getFont().deriveFont(editItem.getFont().getSize() + 3f));
                editItem.addActionListener(e -> editItemActionPerformed(e));
                recordsMenu.add(editItem);

                //---- enterRecordsItem ----
                enterRecordsItem.setText("Entering Records");
                enterRecordsItem.setBackground(new Color(255, 226, 219));
                enterRecordsItem.setFont(enterRecordsItem.getFont().deriveFont(enterRecordsItem.getFont().getSize() + 3f));
                enterRecordsItem.addActionListener(e -> enterRecordsItemActionPerformed(e));
                recordsMenu.add(enterRecordsItem);
            }
            EmployeeMenu.add(recordsMenu);

            //======== requestMenu ========
            {
                requestMenu.setText("Requests");
                requestMenu.setFont(new Font("Times New Roman", Font.BOLD, 20));

                //---- loanItem ----
                loanItem.setText("Loan And Time Off");
                loanItem.setBackground(new Color(255, 226, 219));
                loanItem.setFont(loanItem.getFont().deriveFont(loanItem.getFont().getSize() + 3f));
                loanItem.addActionListener(e -> loanItemActionPerformed(e));
                requestMenu.add(loanItem);
            }
            EmployeeMenu.add(requestMenu);
        }
        setJMenuBar(EmployeeMenu);

        //---- nameLbl ----
        nameLbl.setText("Name :");
        nameLbl.setFont(nameLbl.getFont().deriveFont(nameLbl.getFont().getSize() + 2f));

        //---- idLbl ----
        idLbl.setText("ID :");
        idLbl.setFont(idLbl.getFont().deriveFont(idLbl.getFont().getSize() + 2f));

        //---- postLbl ----
        postLbl.setText("Post :");
        postLbl.setFont(postLbl.getFont().deriveFont(postLbl.getFont().getSize() + 2f));

        //---- nameTxt ----
        nameTxt.setText("text");
        nameTxt.setFont(nameTxt.getFont().deriveFont(nameTxt.getFont().getStyle() | Font.ITALIC, nameTxt.getFont().getSize() + 2f));

        //---- idTxt ----
        idTxt.setText("text");
        idTxt.setFont(idTxt.getFont().deriveFont(idTxt.getFont().getStyle() | Font.ITALIC, idTxt.getFont().getSize() + 2f));

        //---- postTxt ----
        postTxt.setText("text");
        postTxt.setFont(postTxt.getFont().deriveFont(postTxt.getFont().getStyle() | Font.ITALIC, postTxt.getFont().getSize() + 2f));

        //---- iconLbl ----
        iconLbl.setHorizontalAlignment(SwingConstants.CENTER);
        iconLbl.setIcon(new ImageIcon(getClass().getResource("/view/Employee Icon.png")));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(postLbl, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(postTxt, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(idLbl, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(nameLbl, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                    .addComponent(iconLbl, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(69, 69, 69)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nameLbl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(idLbl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(postLbl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addComponent(postTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(iconLbl, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(128, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mahan
    private JMenuBar EmployeeMenu;
    private JMenu viewMenu;
    private JMenuItem salaryItem;
    private JMenuItem statusItem;
    private JMenu recordsMenu;
    private JMenuItem editItem;
    private JMenuItem enterRecordsItem;
    private JMenu requestMenu;
    private JMenuItem loanItem;
    private JLabel nameLbl;
    private JLabel idLbl;
    private JLabel postLbl;
    private JLabel nameTxt;
    private JLabel idTxt;
    private JLabel postTxt;
    private JLabel iconLbl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
