/*
 * Created by JFormDesigner on Tue Dec 24 18:52:57 IRST 2019
 */

package view;

import java.awt.event.*;
import model.entity.TeacherEntity;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author nazanin
 */
public class TeacherPanel extends JFrame
{
    int term = 981;
    TeacherEntity entity;
    public TeacherPanel(TeacherEntity entity) {
        initComponents();
        this.entity=entity;
        nameTxt.setText(entity.getName());
        idTxt.setText(String.valueOf(entity.getId()));
        majorTxt.setText(entity.getExperties());
        this.setVisible(true);
    }






    private void salaryItemActionPerformed(ActionEvent e) {
        TeacherSalary teacherSalary=new TeacherSalary(entity);
    }

    private void studentListItemActionPerformed(ActionEvent e) {
        try {
            EnteringGrades enteringGrades=new EnteringGrades(entity, term);

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null,"Error While Opening The Page!",
                    "Alert",JOptionPane.WARNING_MESSAGE);
        }
    }

    private void teacherLessonItemActionPerformed(ActionEvent e) {
        try {
            TeacherLessonsWindow teacherLessons=new TeacherLessonsWindow(entity);
            teacherLessons.setVisible(true);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog
                    (null,"Error While Opening Teacher Lessons Page",
                            "Alert",JOptionPane.WARNING_MESSAGE);
        }
    }

    private void teacherLessonItemMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void evaluationItemActionPerformed(ActionEvent e) {
        try {
            EvaluationWindow window = new EvaluationWindow(entity);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mahan
        menuBar1 = new JMenuBar();
        viewMenu = new JMenu();
        teacherLessonItem = new JMenuItem();
        studentsItem = new JMenuItem();
        evaluationItem = new JMenuItem();
        gradeExclusion = new JMenu();
        studentListItem = new JMenuItem();
        financialMenu = new JMenu();
        salaryItem = new JMenuItem();
        nameLbl = new JLabel();
        idLbl = new JLabel();
        majorLbl = new JLabel();
        iconLbl = new JLabel();
        nameTxt = new JLabel();
        idTxt = new JLabel();
        majorTxt = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== viewMenu ========
            {
                viewMenu.setText("View");
                viewMenu.setFont(new Font("Times New Roman", Font.BOLD, 20));

                //---- teacherLessonItem ----
                teacherLessonItem.setText("Teacher Lessons");
                teacherLessonItem.setFont(teacherLessonItem.getFont().deriveFont(teacherLessonItem.getFont().getSize() + 3f));
                teacherLessonItem.setBackground(new Color(255, 226, 219));
                teacherLessonItem.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        teacherLessonItemMouseClicked(e);
                    }
                });
                teacherLessonItem.addActionListener(e -> teacherLessonItemActionPerformed(e));
                viewMenu.add(teacherLessonItem);

                //---- studentsItem ----
                studentsItem.setText("Students");
                studentsItem.setBackground(new Color(255, 226, 219));
                studentsItem.setFont(studentsItem.getFont().deriveFont(studentsItem.getFont().getSize() + 3f));
                viewMenu.add(studentsItem);

                //---- evaluationItem ----
                evaluationItem.setText("Teacher Evaluation");
                evaluationItem.setFont(evaluationItem.getFont().deriveFont(evaluationItem.getFont().getSize() + 3f));
                evaluationItem.setBackground(new Color(255, 226, 219));
                evaluationItem.addActionListener(e -> evaluationItemActionPerformed(e));
                viewMenu.add(evaluationItem);
            }
            menuBar1.add(viewMenu);

            //======== gradeExclusion ========
            {
                gradeExclusion.setText("Entering Grades And Student Exclusion ");
                gradeExclusion.setFont(new Font("Times New Roman", Font.BOLD, 20));

                //---- studentListItem ----
                studentListItem.setText("Students List");
                studentListItem.setBackground(new Color(255, 226, 219));
                studentListItem.setFont(studentListItem.getFont().deriveFont(studentListItem.getFont().getSize() + 3f));
                studentListItem.addActionListener(e -> studentListItemActionPerformed(e));
                gradeExclusion.add(studentListItem);
            }
            menuBar1.add(gradeExclusion);

            //======== financialMenu ========
            {
                financialMenu.setText("Financial Statements");
                financialMenu.setFont(new Font("Times New Roman", Font.BOLD, 20));

                //---- salaryItem ----
                salaryItem.setText("Salary");
                salaryItem.setFont(salaryItem.getFont().deriveFont(salaryItem.getFont().getSize() + 3f));
                salaryItem.setBackground(new Color(255, 226, 219));
                salaryItem.addActionListener(e -> salaryItemActionPerformed(e));
                financialMenu.add(salaryItem);
            }
            menuBar1.add(financialMenu);
        }
        setJMenuBar(menuBar1);

        //---- nameLbl ----
        nameLbl.setText("Name :");
        nameLbl.setFont(nameLbl.getFont().deriveFont(nameLbl.getFont().getSize() + 2f));

        //---- idLbl ----
        idLbl.setText("ID :");
        idLbl.setFont(idLbl.getFont().deriveFont(idLbl.getFont().getSize() + 2f));

        //---- majorLbl ----
        majorLbl.setText("Experties :");
        majorLbl.setFont(majorLbl.getFont().deriveFont(majorLbl.getFont().getSize() + 2f));

        //---- iconLbl ----
        iconLbl.setIcon(new ImageIcon(getClass().getResource("/view/TeacherIcon.png")));
        iconLbl.setHorizontalAlignment(SwingConstants.CENTER);

        //---- nameTxt ----
        nameTxt.setText("text");
        nameTxt.setFont(nameTxt.getFont().deriveFont(nameTxt.getFont().getStyle() | Font.ITALIC, nameTxt.getFont().getSize() + 2f));

        //---- idTxt ----
        idTxt.setText("text");
        idTxt.setFont(idTxt.getFont().deriveFont(idTxt.getFont().getStyle() | Font.ITALIC, idTxt.getFont().getSize() + 2f));

        //---- majorTxt ----
        majorTxt.setText("text");
        majorTxt.setFont(majorTxt.getFont().deriveFont(majorTxt.getFont().getStyle() | Font.ITALIC, majorTxt.getFont().getSize() + 2f));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(majorLbl, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(majorTxt, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(nameLbl, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(idLbl, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                    .addComponent(iconLbl, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nameLbl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(idLbl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(majorTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addComponent(majorLbl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(iconLbl, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(163, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mahan
    private JMenuBar menuBar1;
    private JMenu viewMenu;
    private JMenuItem teacherLessonItem;
    private JMenuItem studentsItem;
    private JMenuItem evaluationItem;
    private JMenu gradeExclusion;
    private JMenuItem studentListItem;
    private JMenu financialMenu;
    private JMenuItem salaryItem;
    private JLabel nameLbl;
    private JLabel idLbl;
    private JLabel majorLbl;
    private JLabel iconLbl;
    private JLabel nameTxt;
    private JLabel idTxt;
    private JLabel majorTxt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
