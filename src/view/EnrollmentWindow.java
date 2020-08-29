/*
 * Created by JFormDesigner on Wed Jan 15 17:58:06 IRST 2020
 */

package view;

import java.awt.event.*;
import controller.EnrollmentController;
import controller.InputException;
import model.entity.*;
import model.service.EnrollmentService;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.naming.Name;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author mahan
 */
public class EnrollmentWindow extends JFrame {
    int correntTerm;
    StudentEntity entity;
    List<TermCourseEntity> studentList;
    List<CourseEntity> courseEntityList;
    List<EnrollmentAssitanceEntity> list = new ArrayList<>();


    public EnrollmentWindow(StudentEntity studentEntity, int correntTerm) throws Exception {
        initComponents();
        this.entity = studentEntity;
        this.setVisible(true);
        this.correntTerm = correntTerm;
        initializer();
    }
    private void initializer() throws Exception {
        nameLabel.setText(entity.getName());
        idLabel.setText(String.valueOf(entity.getId()));
        gradeLabel.setText(entity.getGrade());
        majorLabel.setText(entity.getMaajor());
        studentList = EnrollmentController.getInstance().fillSelectionTable(entity);
        courseEntityList = EnrollmentController.getInstance().completeSelectionTable(studentList);
        fillSelectionTable();
    }

    private void fillResultTable(List<EnrollmentAssitanceEntity> enrollmentEntityList){
        Object[][] objects = new Object[enrollmentEntityList.size()][];
        for (int i = 0; i < enrollmentEntityList.size(); i++){
            objects[i] = new Object[4];
            //objects[i][0] = "add";
            objects[i][0] = enrollmentEntityList.get(i).getCode();
            objects[i][1] = enrollmentEntityList.get(i).getName();
            objects[i][2] = enrollmentEntityList.get(i).getUnit();
            objects[i][3] = enrollmentEntityList.get(i).getType();
            //System.out.println(objects[i][4]);
        }
        String titles[] = {"code", "name", "unit", "type"};
        resultTable.setModel(new DefaultTableModel(objects, titles){
            Class<?>[] columnTypes = new Class<?>[] {
                    String.class, String.class, Integer.class, String.class
            };
            boolean[] columnEditable = new boolean[] {
                    false, false, false, false
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
            public int getColumnCount(){
                return titles.length;
            }
            @Override
            public Object getValueAt(int rowIndex, int columnIndex){
                return objects[rowIndex][columnIndex];
            }
            @Override
            public String getColumnName(int column){
                return titles[column];
            }
            {
                TableColumnModel cm = resultTable.getColumnModel();
                cm.getColumn(0).setResizable(false);
                cm.getColumn(0).setPreferredWidth(85);
                cm.getColumn(1).setResizable(false);
                cm.getColumn(1).setPreferredWidth(160);
                cm.getColumn(2).setResizable(false);
                cm.getColumn(2).setPreferredWidth(30);
                cm.getColumn(3).setResizable(false);
            }
        });

    }

    private void fillSelectionTable(){
        Object[][] objects = new Object[studentList.size()][];
        for (int i = 0; i < studentList.size(); i++){
            objects[i] = new Object[8];
            objects[i][0] = studentList.get(i).getCourse_id();
            objects[i][1] = studentList.get(i).getgruop();
            objects[i][2] = courseEntityList.get(i).getName();
            objects[i][3] = courseEntityList.get(i).getUnit();
            objects[i][4] = studentList.get(i).getTime();
            objects[i][5] = studentList.get(i).getDay();
            objects[i][6] = courseEntityList.get(i).getPrerequisite();
            objects[i][7] = courseEntityList.get(i).getNeed();
        }
        String[] titles = {"code", "group", "name", "units", "time", "day", "prerequisites", "need"};

        selectionTable.setModel( new DefaultTableModel(objects, titles)
        {
            Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Integer.class, String.class, Integer.class, String.class, String.class, Long.class, Long.class
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
            @Override
            public String getColumnName(int column){
                return titles[column];
            }
        });
        {
            TableColumnModel cm = selectionTable.getColumnModel();
            cm.getColumn(0).setResizable(false);
            cm.getColumn(1).setResizable(false);
            cm.getColumn(1).setPreferredWidth(35);
            cm.getColumn(2).setResizable(false);
            cm.getColumn(2).setPreferredWidth(145);
            cm.getColumn(3).setResizable(false);
            cm.getColumn(3).setPreferredWidth(30);
            cm.getColumn(4).setResizable(false);
            cm.getColumn(4).setPreferredWidth(35);
            cm.getColumn(5).setResizable(false);
            cm.getColumn(5).setPreferredWidth(50);
            cm.getColumn(6).setResizable(false);
            cm.getColumn(7).setResizable(false);
        }
    }

    private void backButtonMouseClicked(MouseEvent e) {
        this.setVisible(false);
    }

    private void selectionTablMouseClicked(MouseEvent e) {
        EnrollmentAssitanceEntity assitanceEntity = new EnrollmentAssitanceEntity();
        String id, name = null, type = null;
        int unit = 0;
        JTable source = (JTable)e.getSource();
        int row = source.rowAtPoint(e.getPoint());
        int column = source.columnAtPoint(e.getPoint());
        if (e.getClickCount() == 2){
            id = source.getModel().getValueAt(row, 0) + "_" + source.getModel().getValueAt(row, 1);
            name = (String) source.getModel().getValueAt(row, 2);
            unit = (int) source.getModel().getValueAt(row, 3);
            for (CourseEntity entity: courseEntityList){
                if (entity.getCode() == (long)source.getModel().getValueAt(row, 0)){
                    assitanceEntity.setType(entity.getField())
                            .setId((Long) source.getModel().getValueAt(row, 0))
                            .setNeed((Long) source.getModel().getValueAt(row, 7))
                            .setPrerequisite((Long) source.getModel().getValueAt(row, 6));
                    break;
                }
            }
            assitanceEntity.setCode(id).setName(name).setUnit(unit);
            list.add(assitanceEntity);
            System.out.println(assitanceEntity.toString());
            fillResultTable(list);
        }

    }

    private void checkButtonActionPerformed(ActionEvent e) {
        int state = 0;
        try {
            EnrollmentController.getInstance().resultTableChecker(list, entity.getId());
        } catch (InputException ex) {
            panel1.setBackground(Color.red);
            label4.setText(ex.getMessage());
            state++;
        }
        if (state == 0){
            panel1.setBackground(Color.GREEN);
            label4.setText("no problem found");
        }
    }

    private void summaryToggleButtonActionPerformed(ActionEvent e) {
        SummaryWindow summaryWindow = new SummaryWindow(list);
        if (summaryToggleButton.isSelected())
            summaryWindow.setVisible(true);
        else
            summaryWindow.setVisible(false);


    }

    private void resultTableMouseClicked(MouseEvent e) {
        JTable source = (JTable) e.getSource();
        int row = source.rowAtPoint(e.getPoint());
        if (e.getClickCount() == 2){
            list.remove(row);
        }
        fillResultTable(list);
    }

    private void saveButtonActionPerformed(ActionEvent e) {
        List<EnrollmentEntity> entityList = null;
        int state = 0, i = 0;
        try {
            EnrollmentController.getInstance().resultTableChecker(list, entity.getId());
            entityList = EnrollmentService.getInstance().report();
        } catch (InputException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "WARNING", 0);
            state++;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (state == 0){
            for (i = 0; i < entityList.size(); i++){
                if (entityList.get(i).getIndex() == i){
                    try {
                        EnrollmentService.getInstance().edit(new EnrollmentEntity().setState(entityList.get(i).getState())
                                .setAbsence(entityList.get(i).getAbsence())
                                .setMark(entityList.get(i).getMark())
                                .setIndex(i));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            i = entityList.size();
            for (EnrollmentAssitanceEntity assitanceEntity : list){
                try {
                    EnrollmentService.getInstance().add(new EnrollmentEntity()
                            .setId(assitanceEntity.getCode())
                            .setStdId(entity.getId())
                            .setTerm(correntTerm)
                            .setIndex(i));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                i++;
            }
        }
    }

    private void clearButtonActionPerformed(ActionEvent e) {
        list.removeAll(list);
        fillResultTable(list);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mahan
        scrollPane1 = new JScrollPane();
        selectionTable = new JTable();
        scrollPane2 = new JScrollPane();
        resultTable = new JTable();
        backButton = new JButton();
        checkButton = new JButton();
        saveButton = new JButton();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        nameLabel = new JLabel();
        idLabel = new JLabel();
        majorLabel = new JLabel();
        gradeLabel = new JLabel();
        label3 = new JLabel();
        summaryToggleButton = new JToggleButton();
        clearButton = new JButton();
        panel1 = new JPanel();
        label4 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- selectionTable ----
            selectionTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "code", "group", "name", "units", "time", "day", "prerequisites", "need"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Integer.class, String.class, Integer.class, String.class, String.class, Long.class, Long.class
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
                TableColumnModel cm = selectionTable.getColumnModel();
                cm.getColumn(0).setResizable(false);
                cm.getColumn(1).setResizable(false);
                cm.getColumn(1).setPreferredWidth(35);
                cm.getColumn(2).setResizable(false);
                cm.getColumn(2).setPreferredWidth(145);
                cm.getColumn(3).setResizable(false);
                cm.getColumn(3).setPreferredWidth(30);
                cm.getColumn(4).setResizable(false);
                cm.getColumn(4).setPreferredWidth(35);
                cm.getColumn(5).setResizable(false);
                cm.getColumn(5).setPreferredWidth(50);
                cm.getColumn(6).setResizable(false);
                cm.getColumn(7).setResizable(false);
            }
            selectionTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    selectionTablMouseClicked(e);
                }
            });
            scrollPane1.setViewportView(selectionTable);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(300, 260, 550, 178);

        //======== scrollPane2 ========
        {

            //---- resultTable ----
            resultTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "code", "name", "unit", "type"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    String.class, String.class, Integer.class, String.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false
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
                TableColumnModel cm = resultTable.getColumnModel();
                cm.getColumn(0).setResizable(false);
                cm.getColumn(0).setPreferredWidth(85);
                cm.getColumn(1).setResizable(false);
                cm.getColumn(1).setPreferredWidth(160);
                cm.getColumn(2).setResizable(false);
                cm.getColumn(2).setPreferredWidth(30);
                cm.getColumn(3).setResizable(false);
            }
            resultTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    resultTableMouseClicked(e);
                }
            });
            scrollPane2.setViewportView(resultTable);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(30, 80, 820, 175);

        //---- backButton ----
        backButton.setText("back");
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backButtonMouseClicked(e);
            }
        });
        contentPane.add(backButton);
        backButton.setBounds(new Rectangle(new Point(750, 445), backButton.getPreferredSize()));

        //---- checkButton ----
        checkButton.setText("check");
        checkButton.addActionListener(e -> checkButtonActionPerformed(e));
        contentPane.add(checkButton);
        checkButton.setBounds(new Rectangle(new Point(660, 445), checkButton.getPreferredSize()));

        //---- saveButton ----
        saveButton.setText("save");
        saveButton.addActionListener(e -> saveButtonActionPerformed(e));
        contentPane.add(saveButton);
        saveButton.setBounds(new Rectangle(new Point(565, 445), saveButton.getPreferredSize()));

        //---- label5 ----
        label5.setText("average: ");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(15, 55), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("name: ");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(15, 5), label6.getPreferredSize()));

        //---- label7 ----
        label7.setText("ID: ");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(15, 30), label7.getPreferredSize()));

        //---- label1 ----
        label1.setText("major: ");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(170, 5), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("grade: ");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(170, 35), label2.getPreferredSize()));

        //---- nameLabel ----
        nameLabel.setText("text");
        contentPane.add(nameLabel);
        nameLabel.setBounds(60, 5, 100, nameLabel.getPreferredSize().height);

        //---- idLabel ----
        idLabel.setText("text");
        contentPane.add(idLabel);
        idLabel.setBounds(45, 30, 120, idLabel.getPreferredSize().height);

        //---- majorLabel ----
        majorLabel.setText("text");
        contentPane.add(majorLabel);
        majorLabel.setBounds(220, 5, 115, majorLabel.getPreferredSize().height);

        //---- gradeLabel ----
        gradeLabel.setText("text");
        contentPane.add(gradeLabel);
        gradeLabel.setBounds(210, 35, 105, gradeLabel.getPreferredSize().height);
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(355, 500), label3.getPreferredSize()));

        //---- summaryToggleButton ----
        summaryToggleButton.setText("summary");
        summaryToggleButton.addActionListener(e -> summaryToggleButtonActionPerformed(e));
        contentPane.add(summaryToggleButton);
        summaryToggleButton.setBounds(new Rectangle(new Point(760, 40), summaryToggleButton.getPreferredSize()));

        //---- clearButton ----
        clearButton.setText("clear");
        clearButton.addActionListener(e -> clearButtonActionPerformed(e));
        contentPane.add(clearButton);
        clearButton.setBounds(new Rectangle(new Point(670, 40), clearButton.getPreferredSize()));

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
            ( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
            . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
            propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );

            //---- label4 ----
            label4.setText("designed by mahan ziyari");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(641, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label4)
                        .addContainerGap(18, Short.MAX_VALUE))
            );
        }
        contentPane.add(panel1);
        panel1.setBounds(5, 480, 880, 40);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mahan
    private JScrollPane scrollPane1;
    private JTable selectionTable;
    private JScrollPane scrollPane2;
    private JTable resultTable;
    private JButton backButton;
    private JButton checkButton;
    private JButton saveButton;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label1;
    private JLabel label2;
    private JLabel nameLabel;
    private JLabel idLabel;
    private JLabel majorLabel;
    private JLabel gradeLabel;
    private JLabel label3;
    private JToggleButton summaryToggleButton;
    private JButton clearButton;
    private JPanel panel1;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
