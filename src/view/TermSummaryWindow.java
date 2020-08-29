/*
 * Created by JFormDesigner on Fri Jan 31 16:30:44 IRST 2020
 */

package view;

import controller.StudentInformationController;
import model.entity.TermSummaryEntity;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author mahan
 */
public class TermSummaryWindow extends JFrame {
    TermSummaryEntity entity;
    public TermSummaryWindow(TermSummaryEntity entity) {
        initComponents();
        this.setVisible(true);
        this.entity = entity;
        fillTable();
    }

    private void fillTable(){
        Object[][] objects = new Object[entity.getTermCourses().size()][];
        for (int i = 0; i < objects.length; i++){
            objects[i] = new Object[5];
            objects[i][0] = i+1;
            objects[i][1] = entity.getTermCourses().get(i).getId();
            objects[i][2] = StudentInformationController.getInstance().courseFinder(entity.getTermCourses().get(i).getId()).getName();
            objects[i][3] = StudentInformationController.getInstance().giveUnit(entity.getTermCourses().get(i).getId());
            objects[i][4] = entity.getTermCourses().get(i).getMark();
        }
        String[] titles = {
                "No", "Code", "Course", "Unit", "mark"
        };
        termSummaryTable.setModel(new DefaultTableModel(objects,titles) {
            @Override
            public int getRowCount() {
                return objects.length;
            }

            @Override
            public int getColumnCount() {
                return titles.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return objects[rowIndex][columnIndex];
            }
            Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, String.class, String.class, Integer.class, Float.class
            };
            boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false
            };
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnEditable[columnIndex];
            }
        });
        {
            TableColumnModel cm = termSummaryTable.getColumnModel();
            cm.getColumn(0).setResizable(false);
            cm.getColumn(0).setPreferredWidth(25);
            cm.getColumn(1).setResizable(false);
            cm.getColumn(1).setPreferredWidth(75);
            cm.getColumn(2).setResizable(false);
            cm.getColumn(2).setPreferredWidth(160);
            cm.getColumn(3).setResizable(false);
            cm.getColumn(3).setPreferredWidth(30);
            cm.getColumn(4).setResizable(false);
            cm.getColumn(4).setPreferredWidth(45);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mahan
        scrollPane1 = new JScrollPane();
        termSummaryTable = new JTable();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- termSummaryTable ----
            termSummaryTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null},
                },
                new String[] {
                    "No", "Code", "Course", "Unit", "mark"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, String.class, String.class, Integer.class, Float.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = termSummaryTable.getColumnModel();
                cm.getColumn(0).setResizable(false);
                cm.getColumn(0).setPreferredWidth(25);
                cm.getColumn(1).setResizable(false);
                cm.getColumn(1).setPreferredWidth(75);
                cm.getColumn(2).setResizable(false);
                cm.getColumn(2).setPreferredWidth(160);
                cm.getColumn(3).setResizable(false);
                cm.getColumn(3).setPreferredWidth(30);
                cm.getColumn(4).setResizable(false);
                cm.getColumn(4).setPreferredWidth(45);
            }
            scrollPane1.setViewportView(termSummaryTable);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 15, 605, 160);

        contentPane.setPreferredSize(new Dimension(625, 450));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mahan
    private JScrollPane scrollPane1;
    private JTable termSummaryTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
