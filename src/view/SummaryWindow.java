/*
 * Created by JFormDesigner on Wed Jan 29 22:21:01 IRST 2020
 */

package view;

import model.entity.EnrollmentAssitanceEntity;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author mahan
 */
public class SummaryWindow extends JFrame {
    List<EnrollmentAssitanceEntity> list;
    public SummaryWindow(List<EnrollmentAssitanceEntity> list) {
        initComponents();
        this.list = list;
        fillTable();
    }

    private void fillTable(){
        int _public = 0, _base = 0, _specilty = 0;
        for (EnrollmentAssitanceEntity entity : list){
            if (entity.getType().equalsIgnoreCase("public"))
                _public += entity.getUnit();
            else if (entity.getType().equalsIgnoreCase("base"))
                _base += entity.getUnit();
            else
                _specilty += entity.getUnit();
        }
        table1.getModel().setValueAt(_public, 0, 1);
        table1.getModel().setValueAt(_base, 1, 1);
        table1.getModel().setValueAt(_specilty, 2, 1);
        table1.getModel().setValueAt(_specilty + _base + _public, 3, 1);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mahan
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {"public", null},
                    {"base", null},
                    {"specialty", null},
                    {"total", null},
                },
                new String[] {
                    "title", "number"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = table1.getColumnModel();
                cm.getColumn(0).setResizable(false);
                cm.getColumn(0).setPreferredWidth(90);
                cm.getColumn(1).setResizable(false);
                cm.getColumn(1).setPreferredWidth(45);
            }
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 10, 140, 90);

        contentPane.setPreferredSize(new Dimension(160, 140));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mahan
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
