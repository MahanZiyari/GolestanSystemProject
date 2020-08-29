/*
 * Created by JFormDesigner on Wed Jan 15 17:11:11 IRST 2020
 */

package view;

import java.awt.event.*;

import controller.EnteringGradesController;
import model.entity.*;
import model.service.CourseService;
import model.service.EnrollmentService;
import model.service.StudentService;
import model.service.TermCourseService;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author naznin
 */
public class EnteringGrades extends JFrame {
    private List<TermCourseEntity> termCourseList;
    private List<TermCourseEntity> teacheList = new ArrayList<>();
    private TeacherEntity myEntity;
    private String selectedCourse;
    private int term;


    public EnteringGrades(TeacherEntity teacherEntity, int term) throws Exception {
        initComponents();
        termCourseList = TermCourseService.getInstance().report();
        this.myEntity = teacherEntity;
        this.term = term;
        fillSelectionTable();
        this.setVisible(true);
    }


    //a method to set new model for selection table and filling it with correct information
    private void fillSelectionTable(){
        for (TermCourseEntity entity : termCourseList){
            if (entity.getTeacher_id() == myEntity.getId())
                teacheList.add(entity);
        }
        Object[][] objects = new Object[teacheList.size()][];
        for (int i = 0; i < teacheList.size(); i++){
            objects[i] = new Object[3];
            objects[i][0] = teacheList.get(i).getCourse_id();
            objects[i][1] = EnteringGradesController.getInstance().nameFinder(teacheList.get(i).getCourse_id());
            objects[i][2] = teacheList.get(i).getgruop();
        }
        String[] titles = {"CODE", "NAME", "GROUP"};
        selecetionTable.setModel(new DefaultTableModel(objects, titles)
        {
            Class<?>[] columnTypes = new Class<?>[] {
                    Long.class, String.class, Integer.class
            };
            boolean[] columnEditable = new boolean[] {
                    false, false, false
            };
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnEditable[columnIndex];
            }
            // new added methods
            @Override
            public int getRowCount(){
                return objects.length;
            }
            @Override
            public int getColumnCount(){
                return titles.length;
            }
            @Override
            public Object getValueAt(int rowIndex, int columnIndex){
                return objects[rowIndex][columnIndex];
            }
        });
        {
            TableColumnModel cm = selecetionTable.getColumnModel();
            cm.getColumn(0).setPreferredWidth(95);
            cm.getColumn(1).setPreferredWidth(140);
            cm.getColumn(2).setPreferredWidth(50);
        }
    }


    //same as selection table
    private void fillTermicTable(List<EnrollmentEntity> students) throws Exception {
        Object[][] objects = new Object[students.size()][];
        for (int i = 0; i < students.size(); i++){
            objects[i] = new Object[7];
            objects[i][0] = students.get(i).getIndex();
            objects[i][1] = EnteringGradesController.getInstance().studentFinder(students.get(i).getStdId()).getId();
            objects[i][2] = EnteringGradesController.getInstance().studentFinder(students.get(i).getStdId()).getName();
            objects[i][3] = EnteringGradesController.getInstance().studentFinder(students.get(i).getStdId()).getMaajor();
            objects[i][4] = EnteringGradesController.getInstance().absenceChecker(students.get(i).getStdId(), students.get(i).getId());
            objects[i][5] = students.get(i).getMark();
            objects[i][6] = students.get(i).getState();
        }

        String[] titles = {"NUMBER", "ID", "NAME", "MAJOR", "ABSENCE", "GRADE", "STATE"};
        termicTable.setModel(new DefaultTableModel(objects, titles)
        {
            Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, Long.class, String.class, String.class, Integer.class, Float.class, String.class
            };
            boolean[] columnEditable = new boolean[] {
                    false, false, false, false, true, true, true
            };
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnEditable[columnIndex];
            }
            @Override
            public int getRowCount(){
                return objects.length;
            }
            @Override
            public int getColumnCount(){ return titles.length; }

        });
        {
            TableColumnModel cm = termicTable.getColumnModel();
            cm.getColumn(0).setResizable(false);
            cm.getColumn(0).setPreferredWidth(35);
            cm.getColumn(1).setResizable(false);
            cm.getColumn(1).setPreferredWidth(90);
            cm.getColumn(2).setResizable(false);
            cm.getColumn(2).setPreferredWidth(130);
            cm.getColumn(3).setResizable(false);
            cm.getColumn(3).setPreferredWidth(85);
            cm.getColumn(4).setResizable(false);
            cm.getColumn(4).setPreferredWidth(65);
            cm.getColumn(5).setPreferredWidth(60);
        }
    }


    private void selecetionTableMouseClicked(MouseEvent e) {
        JTable source = (JTable)e.getSource();
        int row = source.rowAtPoint(e.getPoint());
        int column = source.columnAtPoint(e.getPoint());
        String courseCode = source.getModel().getValueAt(row, 0) + "_"
                + source.getModel().getValueAt(row, 2);
        try {
            fillTermicTable(EnteringGradesController.getInstance().studentSelector(courseCode, term));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        selectedCourse = courseCode;
    }

    private void saveButtonMouseClicked(MouseEvent e) {
        int state = 0;
        for (int i = 0; i < termicTable.getRowCount(); i++){
            EnrollmentEntity entity = new EnrollmentEntity().setIndex((Integer) termicTable.getModel().getValueAt(i, 0))
                    .setAbsence((Integer) termicTable.getModel().getValueAt(i,4))
                    .setMark((Float) termicTable.getModel().getValueAt(i,5))
                    .setState((String) termicTable.getModel().getValueAt(i,6));
            try {
                EnrollmentService.getInstance().edit(entity);
            } catch (Exception ex) {
                state++;
                label1.setForeground(Color.red);
                label1.setText(ex.getMessage());
            }
        }
        if (state == 0){
            label1.setForeground(Color.GREEN);
            label1.setText("list updated successfully");
        }

    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mahan
        scrollPane1 = new JScrollPane();
        termicTable = new JTable();
        scrollPane2 = new JScrollPane();
        selecetionTable = new JTable();
        saveButton = new JButton();
        label1 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- termicTable ----
            termicTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                },
                new String[] {
                    "number", "ID", "NAME", "MAJOR", "ABSENCE", "GRADE", "STATE"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, Long.class, String.class, String.class, Integer.class, Float.class, String.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, true, true, true
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
                TableColumnModel cm = termicTable.getColumnModel();
                cm.getColumn(0).setResizable(false);
                cm.getColumn(0).setPreferredWidth(35);
                cm.getColumn(1).setResizable(false);
                cm.getColumn(1).setPreferredWidth(90);
                cm.getColumn(2).setResizable(false);
                cm.getColumn(2).setPreferredWidth(130);
                cm.getColumn(3).setResizable(false);
                cm.getColumn(3).setPreferredWidth(85);
                cm.getColumn(4).setResizable(false);
                cm.getColumn(4).setPreferredWidth(65);
                cm.getColumn(5).setPreferredWidth(60);
            }
            scrollPane1.setViewportView(termicTable);
        }

        //======== scrollPane2 ========
        {

            //---- selecetionTable ----
            selecetionTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null},
                    {null, null, null},
                },
                new String[] {
                    "CODE", "NAME", "GROUP"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Long.class, String.class, Integer.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, false, false
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
                TableColumnModel cm = selecetionTable.getColumnModel();
                cm.getColumn(0).setPreferredWidth(95);
                cm.getColumn(1).setPreferredWidth(140);
                cm.getColumn(2).setPreferredWidth(50);
            }
            selecetionTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    selecetionTableMouseClicked(e);
                }
            });
            scrollPane2.setViewportView(selecetionTable);
        }

        //---- saveButton ----
        saveButton.setText("save");
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saveButtonMouseClicked(e);
            }
        });

        //---- label1 ----
        label1.setFont(new Font("Engravers MT", Font.BOLD | Font.ITALIC, 20));
        label1.setForeground(new Color(204, 0, 0));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(0, 348, Short.MAX_VALUE)
                            .addComponent(saveButton))
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
                    .addGap(15, 15, 15))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(saveButton)
                            .addGap(29, 29, 29)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(20, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mahan
    private JScrollPane scrollPane1;
    private JTable termicTable;
    private JScrollPane scrollPane2;
    private JTable selecetionTable;
    private JButton saveButton;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
