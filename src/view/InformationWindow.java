/*
 * Created by JFormDesigner on Fri Jan 31 02:14:42 IRST 2020
 */

package view;

import java.awt.event.*;
import controller.StudentInformationController;
import model.entity.StudentEntity;
import model.entity.TermSummaryEntity;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author mahan
 */
public class InformationWindow extends JFrame {
    StudentEntity studentEntity;
    List<TermSummaryEntity> termSummaryEntities = new ArrayList<>();
    public InformationWindow(StudentEntity studentEntity) throws Exception {
        this.setSize(1024, 768);
        initComponents();
        //initializer();
        this.studentEntity = studentEntity;
        this.setVisible(true);
        nameLabel.setText(studentEntity.getName());
        idLabel.setText(String.valueOf(studentEntity.getId()));
        majorLabel.setText(studentEntity.getMaajor());
        gradeLabel.setText(studentEntity.getGrade());
        //System.out.println(studentEntity.toString());
        termSummaryEntities = StudentInformationController.getInstance().lister(studentEntity.getId(), termSummaryEntities);
        fillTermTable();
        totalAverage();
    }

    private void fillTermTable(){
        Object[][] objects = new Object[termSummaryEntities.size()][];
        for (int i = 0; i < termSummaryEntities.size(); i++){
            objects[i] = new Object[6];
            objects[i][0] = i+1;
            objects[i][1] = termSummaryEntities.get(i).getTermNumber();
            objects[i][2] = termSummaryEntities.get(i).getAverage() == 0 ? "not finished" : "finished";
            objects[i][3] = StudentInformationController.getInstance().unitCounter(termSummaryEntities.get(i).getTermCourses());
            objects[i][4] = termSummaryEntities.get(i).getAverage();
            objects[i][5] = termSummaryEntities.get(i).getAverage() <= 12 ? true : false;
        }
        String[] titles = {"No", "Term", "Status", "Units Passed", "average", "Constitutional"};
        objects[objects.length-1][3] = 0;
        objects[objects.length-1][5] = false;
        termTable.setModel(new DefaultTableModel(objects, titles) {
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
                    Integer.class, Integer.class, String.class, Integer.class, Float.class, Boolean.class
            };
            boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, false
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
            TableColumnModel cm = termTable.getColumnModel();
            cm.getColumn(0).setResizable(false);
            cm.getColumn(0).setPreferredWidth(25);
            cm.getColumn(1).setResizable(false);
            cm.getColumn(1).setPreferredWidth(35);
            cm.getColumn(2).setResizable(false);
            cm.getColumn(2).setPreferredWidth(95);
            cm.getColumn(3).setResizable(false);
            cm.getColumn(3).setPreferredWidth(70);
            cm.getColumn(4).setResizable(false);
            cm.getColumn(4).setPreferredWidth(50);
            cm.getColumn(5).setResizable(false);
            cm.getColumn(5).setPreferredWidth(125);
        }

        //how many units he/she passed
        {
            int units = 0;
            for (int i = 0; i < termSummaryEntities.size()-1; i++)
                units += (int)objects[i][3];
            unitsPassedLabel.setText(String.valueOf(units));
            unitsLeftLabel.setText(String.valueOf(124-units));
        }
    }

    private void totalAverage(){
        float averages = 0;
        int count = termSummaryEntities.size()-1;
        for (int i = 0; i < count; i++){
            averages += termSummaryEntities.get(i).getAverage();
        }
        averageLabel.setText(String.valueOf(averages/count));
    }

    private void backButtonActionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    private void termTableMouseClicked(MouseEvent e) {
        JTable source = (JTable)e.getSource();
        int row = source.rowAtPoint(e.getPoint());
        if (e.getClickCount() == 2){
            for (TermSummaryEntity entity : termSummaryEntities){
                if (entity.getTermNumber() == (int)source.getModel().getValueAt(row, 1)){
                    TermSummaryWindow window = new TermSummaryWindow(entity);
                    break;
                }
            }
        }
    }





    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - nazanin
        scrollPane1 = new JScrollPane();
        termTable = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        idLabel = new JLabel();
        nameLabel = new JLabel();
        averageLabel = new JLabel();
        unitsPassedLabel = new JLabel();
        majorLabel = new JLabel();
        gradeLabel = new JLabel();
        unitsLeftLabel = new JLabel();
        backButton = new JButton();
        iconLbl = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        this.setSize(1024, 768);

        //======== scrollPane1 ========
        {

            //---- termTable ----
            termTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, false},
                },
                new String[] {
                    "No", "Term", "Status", "Units Passed", "average", "Constitutional"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, Integer.class, String.class, Integer.class, Float.class, Boolean.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, false
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
                TableColumnModel cm = termTable.getColumnModel();
                cm.getColumn(0).setResizable(false);
                cm.getColumn(0).setPreferredWidth(25);
                cm.getColumn(1).setResizable(false);
                cm.getColumn(1).setPreferredWidth(35);
                cm.getColumn(2).setResizable(false);
                cm.getColumn(2).setPreferredWidth(95);
                cm.getColumn(3).setResizable(false);
                cm.getColumn(3).setPreferredWidth(70);
                cm.getColumn(4).setResizable(false);
                cm.getColumn(4).setPreferredWidth(50);
                cm.getColumn(5).setResizable(false);
                cm.getColumn(5).setPreferredWidth(125);
            }
            termTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    termTableMouseClicked(e);
                }
            });
            scrollPane1.setViewportView(termTable);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 225, 585, 130);

        //---- label1 ----
        label1.setText("Student ID :");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        contentPane.add(label1);
        label1.setBounds(10, 20, label1.getPreferredSize().width, 35);

        //---- label2 ----
        label2.setText("Name : ");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
        contentPane.add(label2);
        label2.setBounds(10, 60, label2.getPreferredSize().width, 35);

        //---- label3 ----
        label3.setText("Total Average :");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        contentPane.add(label3);
        label3.setBounds(10, 105, 125, 35);

        //---- label4 ----
        label4.setText("Units Passed : ");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));
        contentPane.add(label4);
        label4.setBounds(10, 150, label4.getPreferredSize().width, 34);

        //---- label5 ----
        label5.setText("Units Left : ");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));
        contentPane.add(label5);
        label5.setBounds(255, 150, 95, 35);

        //---- label6 ----
        label6.setText("Major : ");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 2f));
        contentPane.add(label6);
        label6.setBounds(315, 20, label6.getPreferredSize().width, 35);

        //---- label7 ----
        label7.setText("Grade : ");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 2f));
        contentPane.add(label7);
        label7.setBounds(315, 60, label7.getPreferredSize().width, 35);

        //---- idLabel ----
        idLabel.setText("text");
        idLabel.setFont(idLabel.getFont().deriveFont(idLabel.getFont().getSize() + 2f));
        contentPane.add(idLabel);
        idLabel.setBounds(140, 20, 135, 35);

        //---- nameLabel ----
        nameLabel.setText("text");
        nameLabel.setFont(nameLabel.getFont().deriveFont(nameLabel.getFont().getSize() + 2f));
        contentPane.add(nameLabel);
        nameLabel.setBounds(140, 60, 125, 35);

        //---- averageLabel ----
        averageLabel.setText("text");
        averageLabel.setFont(averageLabel.getFont().deriveFont(averageLabel.getFont().getSize() + 2f));
        contentPane.add(averageLabel);

        averageLabel.setBounds(95, 100, 70, averageLabel.getPreferredSize().height);

        averageLabel.setBounds(140, 105, 130, 35);


        //---- unitsPassedLabel ----
        unitsPassedLabel.setText("text");
        unitsPassedLabel.setFont(unitsPassedLabel.getFont().deriveFont(unitsPassedLabel.getFont().getSize() + 2f));
        contentPane.add(unitsPassedLabel);
        unitsPassedLabel.setBounds(140, 150, 70, 34);

        //---- majorLabel ----
        majorLabel.setText("text");
        majorLabel.setFont(majorLabel.getFont().deriveFont(majorLabel.getFont().getSize() + 2f));
        contentPane.add(majorLabel);
        majorLabel.setBounds(425, 20, 150, 35);

        //---- gradeLabel ----
        gradeLabel.setText("text");
        gradeLabel.setFont(gradeLabel.getFont().deriveFont(gradeLabel.getFont().getSize() + 2f));
        contentPane.add(gradeLabel);
        gradeLabel.setBounds(425, 60, 145, 35);

        //---- unitsLeftLabel ----
        unitsLeftLabel.setText("text");
        unitsLeftLabel.setFont(unitsLeftLabel.getFont().deriveFont(unitsLeftLabel.getFont().getSize() + 2f));
        contentPane.add(unitsLeftLabel);
        unitsLeftLabel.setBounds(345, 150, 70, 35);

        //---- backButton ----
        backButton.setText("Back");
        backButton.addActionListener(e -> backButtonActionPerformed(e));

        //---- backButton ----
        backButton.setText("Back");
        backButton.setFont(backButton.getFont().deriveFont(backButton.getFont().getSize() + 2f));
        contentPane.add(backButton);
        backButton.setBounds(880, 525, 86, 42);

        //---- iconLbl ----
        iconLbl.setHorizontalAlignment(SwingConstants.CENTER);
        iconLbl.setIcon(new ImageIcon(getClass().getResource("/view/StudentInfo.png")));
        contentPane.add(iconLbl);
        iconLbl.setBounds(680, 15, 305, 310);

        contentPane.setPreferredSize(new Dimension(795, 506));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - nazanin
    private JScrollPane scrollPane1;
    private JTable termTable;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel averageLabel;
    private JLabel unitsPassedLabel;
    private JLabel majorLabel;
    private JLabel gradeLabel;
    private JLabel unitsLeftLabel;
    private JButton backButton;
    private JLabel iconLbl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
