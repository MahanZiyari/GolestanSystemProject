package view;

import controller.TeacherLessonsController;
import model.entity.TeacherEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;


public class TeacherLessonsWindow extends JFrame {


    // ..................... create components ......................
    Container container;

    JTable table = new JTable();

    JPanel panelBtn = new JPanel();

    JScrollPane scrollPane = new JScrollPane();

    JTableHeader tableHeader;
        // tabel model
        DefaultTableModel model = new DefaultTableModel() {

            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    default:
                        return String.class;

                }
            }
        };

        /*_____________________________________________________ constructor  _____________________________________________*/

        public TeacherLessonsWindow(TeacherEntity entity) throws Exception {
            String[][] rowData;
            rowData = TeacherLessonsController.getInstance().teacherLessons(entity);

            this.setVisible(true);

            // col
            model.addColumn("Code");
            model.addColumn("Course Name");
            model.addColumn("Day");
            model.addColumn("Time");
            /* _______________________________ set component ________________________________*/

            setBounds(200, 20,580 , 700);
            setVisible(true);



            tableHeader = table.getTableHeader();
            tableHeader.setBackground(Color.LIGHT_GRAY);
            table.setModel(model);


            /* width column*/
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.getColumnModel().getColumn(0).setPreferredWidth(150);
            table.getColumnModel().getColumn(1).setPreferredWidth(250);
            table.getColumnModel().getColumn(2).setPreferredWidth(80);
            table.getColumnModel().getColumn(3).setPreferredWidth(80);


            table.setRowHeight(25);


            /* show table*/

            container = getContentPane();

            /* ______________________________ add component ________________________________*/


            // Data Row
            int countRow = 0;
            for (String[] row : rowData) {
                int countCol = 0;
                model.addRow(new Object[]{row[0],row[1],row[2],row[3]});
                countRow += 1;
            }

            container.add(new JScrollPane(table));
        }



}
