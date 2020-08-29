/*
 * Created by JFormDesigner on Thu Jan 30 10:55:29 IRST 2020
 */

package view;

import java.awt.event.*;
import controller.WeeklyController;
import model.entity.EnrollmentEntity;
import model.entity.StudentEntity;
import model.entity.TermCourseEntity;
import model.service.EnrollmentService;
import model.service.TermCourseService;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author mahan
 */
public class WeeklySchedule extends JFrame {
    int term;
    StudentEntity studentEntity;
    List<EnrollmentEntity> studentList;
    public WeeklySchedule(StudentEntity studentEntity,int term) {
        initComponents();
        this.setVisible(true);
        this.studentEntity = studentEntity;
        this.term = term;
        try {
            initializer();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

     private void initializer() throws Exception {
         nameLabel.setText(studentEntity.getName());
         idLabel.setText(String.valueOf(studentEntity.getId()));
         majorLabel.setText(studentEntity.getMaajor());
         studentList = WeeklyController.getInstance().selector(studentEntity.getId(), term);
         fillWeeklyTable();
     }

     private void fillWeeklyTable() throws Exception {
        Object[][] objects = new Object[studentList.size()][];
        for (int i = 0; i < studentList.size(); i++){
            objects[i] = new Object[8];
            objects[i][0] = WeeklyController.getInstance().nameFinder(studentList.get(i));
            objects[i][1] = WeeklyController.getInstance().TeacherFinder(studentList.get(i));
        }
        String[] titles = {"Course", "Teacher", "Sat", "Sun", "Mon", "Tue", "Wed", "Thu"};
        table1.setModel(new DefaultTableModel(objects, titles) {
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
            boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, false, false, false
            };
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnEditable[columnIndex];
            }
            Class<?>[] columnTypes = new Class<?>[] {
                    String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
            };
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
         {
             TableColumnModel cm = table1.getColumnModel();
             cm.getColumn(0).setResizable(false);
             cm.getColumn(0).setPreferredWidth(145);
             cm.getColumn(1).setResizable(false);
             cm.getColumn(1).setPreferredWidth(145);
             cm.getColumn(2).setResizable(false);
             cm.getColumn(2).setPreferredWidth(45);
             cm.getColumn(3).setResizable(false);
             cm.getColumn(3).setPreferredWidth(45);
             cm.getColumn(4).setResizable(false);
             cm.getColumn(4).setPreferredWidth(45);
             cm.getColumn(5).setResizable(false);
             cm.getColumn(5).setPreferredWidth(45);
             cm.getColumn(6).setResizable(false);
             cm.getColumn(6).setPreferredWidth(45);
             cm.getColumn(7).setResizable(false);
             cm.getColumn(7).setPreferredWidth(45);
         }
         weeklyTableTime(objects, titles);
     }

     private void weeklyTableTime(Object[][] objects, String[] titles) throws Exception {
        List<TermCourseEntity> fullList = TermCourseService.getInstance().report();
        List<TermCourseEntity> stdLIst = new ArrayList<>();
        for (EnrollmentEntity enrollmentEntity : studentList){
            for (TermCourseEntity entity : fullList){
                if (Long.valueOf(enrollmentEntity.getId().substring(0,7)) == entity.getCourse_id() && Long.parseLong(String.valueOf(enrollmentEntity.getId().charAt(8))) == entity.getgruop()){
                    stdLIst.add(entity);
                }
            }
        }
        for (int i = 0; i < stdLIst.size(); i++){
            if (stdLIst.get(i).getDay().contains("sat")){
                objects[i][2] = stdLIst.get(i).getTime();
            }
            if (stdLIst.get(i).getDay().contains("sun")){
                objects[i][3] = stdLIst.get(i).getTime();
            }
            if (stdLIst.get(i).getDay().contains("mon")){
                objects[i][4] = stdLIst.get(i).getTime();
            }
            if (stdLIst.get(i).getDay().contains("tue")){
                objects[i][5] = stdLIst.get(i).getTime();
            }
            if (stdLIst.get(i).getDay().contains("wed")){
                objects[i][6] = stdLIst.get(i).getTime();
            }
            if (stdLIst.get(i).getDay().contains("thu")){
                objects[i][7] = stdLIst.get(i).getTime();
            }


        }
         {
             table1.setModel(new DefaultTableModel(objects, titles) {
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
                 boolean[] columnEditable = new boolean[] {
                         false, false, false, false, false, false, false, false
                 };
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return columnEditable[columnIndex];
                 }
                 Class<?>[] columnTypes = new Class<?>[] {
                         String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
                 };
                 @Override
                 public Class<?> getColumnClass(int columnIndex) {
                     return columnTypes[columnIndex];
                 }
             });
             {
                 TableColumnModel cm = table1.getColumnModel();
                 cm.getColumn(0).setResizable(false);
                 cm.getColumn(0).setPreferredWidth(145);
                 cm.getColumn(1).setResizable(false);
                 cm.getColumn(1).setPreferredWidth(145);
                 cm.getColumn(2).setResizable(false);
                 cm.getColumn(2).setPreferredWidth(45);
                 cm.getColumn(3).setResizable(false);
                 cm.getColumn(3).setPreferredWidth(45);
                 cm.getColumn(4).setResizable(false);
                 cm.getColumn(4).setPreferredWidth(45);
                 cm.getColumn(5).setResizable(false);
                 cm.getColumn(5).setPreferredWidth(45);
                 cm.getColumn(6).setResizable(false);
                 cm.getColumn(6).setPreferredWidth(45);
                 cm.getColumn(7).setResizable(false);
                 cm.getColumn(7).setPreferredWidth(45);
             }
         }
     }

     private void button1ActionPerformed(ActionEvent e) {
         this.setVisible(false);
     }





























    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mahan
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        nameLabel = new JLabel();
        idLabel = new JLabel();
        majorLabel = new JLabel();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null, null},
                },
                new String[] {
                    "Course", "Teacher", "Sat", "Sun", "Mon", "Tue", "Wed", "Thu"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, false, false, false
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
                TableColumnModel cm = table1.getColumnModel();
                cm.getColumn(0).setResizable(false);
                cm.getColumn(0).setPreferredWidth(145);
                cm.getColumn(1).setResizable(false);
                cm.getColumn(1).setPreferredWidth(145);
                cm.getColumn(2).setResizable(false);
                cm.getColumn(2).setPreferredWidth(45);
                cm.getColumn(3).setResizable(false);
                cm.getColumn(3).setPreferredWidth(45);
                cm.getColumn(4).setResizable(false);
                cm.getColumn(4).setPreferredWidth(45);
                cm.getColumn(5).setResizable(false);
                cm.getColumn(5).setPreferredWidth(45);
                cm.getColumn(6).setResizable(false);
                cm.getColumn(6).setPreferredWidth(45);
                cm.getColumn(7).setResizable(false);
                cm.getColumn(7).setPreferredWidth(45);
            }
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 180, 870, 165);

        //---- label1 ----
        label1.setText("winter 98-99");
        label1.setFont(new Font("Algerian", Font.PLAIN, 30));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(335, 30), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("name: ");
        label2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(15, 30), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("major: ");
        label3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(15, 120), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("ID: ");
        label4.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(15, 80), label4.getPreferredSize()));

        //---- nameLabel ----
        nameLabel.setText("text");
        nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(nameLabel);
        nameLabel.setBounds(70, 30, 110, nameLabel.getPreferredSize().height);

        //---- idLabel ----
        idLabel.setText("text");
        idLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(idLabel);
        idLabel.setBounds(45, 80, 115, idLabel.getPreferredSize().height);

        //---- majorLabel ----
        majorLabel.setText("text");
        majorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(majorLabel);
        majorLabel.setBounds(70, 120, 100, majorLabel.getPreferredSize().height);

        //---- button1 ----
        button1.setText("BACK");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(790, 490), button1.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(895, 565));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mahan
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel nameLabel;
    private JLabel idLabel;
    private JLabel majorLabel;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
