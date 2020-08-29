/*
 * Created by JFormDesigner on Fri Jan 31 16:38:03 IRST 2020
 */

package view;

import controller.EmployeeStatusController;
import model.entity.EmployeeEntity;
import model.entity.LogEntity;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;


/**
 * @author nazanin
 */
public class EmployeeLogStatus extends JFrame
{
    EmployeeEntity entity;
    LogEntity logEntity;
    public EmployeeLogStatus(EmployeeEntity entity)
    {
        initComponents();
        this.entity=entity;
        fillStatusTable();
        this.setVisible(true);
    }

    public void fillStatusTable()
    {
            List<LogEntity> list = EmployeeStatusController.getInstance().display(entity.getId());
            Object[][] objects = new Object[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                objects[i] = new Object[2];
                objects[i][0] = list.get(i).getDateAndTime();
                objects[i][1] = list.get(i).getSubject();
            }
            String[] titles = {"Date And Time", "Subject"};
            logStatusTable.setModel(new DefaultTableModel(objects, titles) {
                Class<?>[] columnTypes = new Class<?>[]{
                        String.class, String.class
                };

                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }

            });
            {
                TableColumnModel cm = logStatusTable.getColumnModel();
                cm.getColumn(0).setMinWidth(50);
                cm.getColumn(0).setPreferredWidth(190);
                cm.getColumn(1).setPreferredWidth(175);
            }

        }
    private void backButtonMouseClicked(MouseEvent e)
    {
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mahan
        scrollPane1 = new JScrollPane();
        logStatusTable = new JTable();
        backButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- logStatusTable ----
            logStatusTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null},
                    {null, null},
                },
                new String[] {
                    "Date And Time", "Subject"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    String.class, String.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            {
                TableColumnModel cm = logStatusTable.getColumnModel();
                cm.getColumn(0).setMinWidth(50);
                cm.getColumn(0).setPreferredWidth(190);
                cm.getColumn(1).setPreferredWidth(175);
            }
            logStatusTable.setFont(logStatusTable.getFont().deriveFont(logStatusTable.getFont().getSize() + 3f));
            scrollPane1.setViewportView(logStatusTable);
        }

        //---- backButton ----
        backButton.setText("Back");
        backButton.setFont(backButton.getFont().deriveFont(backButton.getFont().getSize() + 2f));
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
                    .addGap(40, 40, 40)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 723, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(686, Short.MAX_VALUE)
                    .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addGap(17, 17, 17))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                    .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mahan
    private JScrollPane scrollPane1;
    private JTable logStatusTable;
    private JButton backButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
