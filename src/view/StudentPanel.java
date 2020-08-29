/*
 * Created by JFormDesigner on Tue Dec 24 18:52:30 IRST 2019
 */

package view;

import java.awt.event.*;

import controller.StudentInformationController;
import model.entity.StudentEntity;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author mahan
 */
public class StudentPanel extends JFrame {
    private JMenuItem menuItem5 = new JMenuItem();
    int term = 981;
    StudentEntity entity;
    public StudentPanel(StudentEntity entity) {
        initComponents();
        this.setVisible(true);
        this.entity = entity;
        initializer();
    }


    private void initializer(){
        name.setText(entity.getName());
        id.setText(String.valueOf(entity.getId()));
        major.setText(entity.getMaajor());
        grade.setText(entity.getGrade());
        dateLabel.setText(String.valueOf(LocalDate.now()));
        dateAndTime();
    }

    private void dateAndTime(){
        Runnable runnable = () -> {
            while (true){
                String time = String.valueOf(LocalTime.now());
                String mytime = time.substring(0, 8);
                timeLabel.setText(mytime);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread timeThread = new Thread(runnable);
        timeThread.start();
    }

    private void navigatorButtonMouseClicked(MouseEvent e) {
        switch (Integer.parseInt(textField1.getText())){
            case 522:
                TuitionPayment payment = new TuitionPayment();
                break;
            case 256:
                try {
                    EnrollmentWindow enrollmentWindow = new EnrollmentWindow(entity, term);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                break;
            case 77:
                WeeklySchedule schedule = new WeeklySchedule(entity, term);
                break;
            case 101:
                try {
                    InformationWindow window = new InformationWindow(entity);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            default:
                    JOptionPane.showMessageDialog(null, "report not found", "error", 0);
        }
    }

    private void enrollmentActionPerformed(ActionEvent e) {
        try {
            EnrollmentWindow window = new EnrollmentWindow(entity, term);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void tuitionActionPerformed(ActionEvent e) {
        TuitionPayment payment = new TuitionPayment();
    }

    private void button2MouseClicked(MouseEvent e) {
        ReportGuide guide = new ReportGuide();
    }

    private void menuItem3ActionPerformed(ActionEvent e) {
        WeeklySchedule schedule = new WeeklySchedule(entity, term);
    }

    private void menu4ActionPerformed(ActionEvent e){
        try {
            InformationWindow window = new InformationWindow(entity);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void menuItem5ActionPerformed(ActionEvent e) {
        try {
            InformationWindow window = new InformationWindow(entity);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - nazanin
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        enrollment = new JMenuItem();
        menu2 = new JMenu();
        tuition = new JMenuItem();
        menu3 = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menu4 = new JMenu();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        textField1 = new JTextField();
        navigatorButton = new JButton();
        button2 = new JButton();
        name = new JLabel();
        id = new JLabel();
        major = new JLabel();
        grade = new JLabel();
        label1 = new JLabel();
        timeLabel = new JLabel();
        dateLabel = new JLabel();
        iconLbl = new JLabel();

        //======== this ========
        setBackground(new Color(232, 232, 232));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("Educational");
                menu1.setBackground(new Color(255, 209, 209));
                menu1.setFont(new Font("Times New Roman", Font.BOLD, 20));

                //---- enrollment ----
                enrollment.setText("Enrollment");
                enrollment.setBackground(new Color(255, 226, 219));
                enrollment.setFont(enrollment.getFont().deriveFont(enrollment.getFont().getSize() + 3f));
                enrollment.addActionListener(e -> enrollmentActionPerformed(e));
                menu1.add(enrollment);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Financial");
                menu2.setBackground(new Color(255, 209, 209));
                menu2.setFont(new Font("Times New Roman", Font.BOLD, 20));

                //---- tuition ----
                tuition.setText("Payment of Tuition");
                tuition.setBackground(new Color(255, 226, 219));
                tuition.setFont(tuition.getFont().deriveFont(tuition.getFont().getSize() + 3f));
                tuition.addActionListener(e -> tuitionActionPerformed(e));
                menu2.add(tuition);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("Requests and Reports");
                menu3.setBackground(new Color(255, 209, 209));
                menu3.setFont(new Font("Times New Roman", Font.BOLD, 20));

                //---- menuItem3 ----

                menuItem3.setText("unit's report");
                menuItem3.addActionListener(e -> menuItem3ActionPerformed(e));

                menuItem3.setText("Unit's Report");
                menuItem3.setBackground(new Color(255, 226, 219));
                menuItem3.setFont(menuItem3.getFont().deriveFont(menuItem3.getFont().getSize() + 3f));

                menu3.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("Courses");
                menuItem4.setBackground(new Color(255, 226, 219));
                menuItem4.setFont(menuItem4.getFont().deriveFont(menuItem4.getFont().getSize() + 3f));
                menu3.add(menuItem4);
            }
            menuBar1.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("Student Information");
                menu4.setBackground(new Color(255, 226, 219));
                menu4.setFont(new Font("Times New Roman", Font.BOLD, 20));
                menu4.addActionListener(e -> menu4ActionPerformed(e));


                menuItem5.setText("Student Information");
                menuItem5.addActionListener(e -> menuItem5ActionPerformed(e));
                menuItem5.setBackground(new Color(255, 226, 219));
                menuItem5.setFont(menuItem5.getFont().deriveFont(menuItem5.getFont().getSize() + 3f));
                menu4.add(menuItem5);
            }
            menuBar1.add(menu4);
        }
        setJMenuBar(menuBar1);

        //---- label5 ----
        label5.setText("NAME :");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));
        contentPane.add(label5);
        label5.setBounds(10, 20, 65, label5.getPreferredSize().height);

        //---- label6 ----
        label6.setText("ID :");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 2f));
        contentPane.add(label6);
        label6.setBounds(10, 60, 35, label6.getPreferredSize().height);

        //---- label7 ----
        label7.setText("MAJOR :");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 2f));
        contentPane.add(label7);
        label7.setBounds(10, 95, 70, label7.getPreferredSize().height);

        //---- label8 ----
        label8.setText("GRADE :");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 2f));
        contentPane.add(label8);
        label8.setBounds(10, 130, 65, label8.getPreferredSize().height);

        //---- label9 ----
        label9.setText("Report :");
        label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 2f));
        contentPane.add(label9);
        label9.setBounds(5, 525, 75, 30);
        contentPane.add(textField1);
        textField1.setBounds(70, 525, 100, 30);

        //---- navigatorButton ----
        navigatorButton.setText("find");
        navigatorButton.setFont(navigatorButton.getFont().deriveFont(navigatorButton.getFont().getSize() + 3f));
        navigatorButton.setBackground(new Color(154, 253, 253));
        navigatorButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                navigatorButtonMouseClicked(e);
            }
        });
        contentPane.add(navigatorButton);
        navigatorButton.setBounds(180, 525, 70, 30);

        //---- button2 ----
        button2.setIcon(null);
        button2.setText("?");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 3f));
        button2.setBackground(new Color(154, 253, 253));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(260, 525, 70, 30);

        //---- name ----
        name.setText("text");
        name.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        contentPane.add(name);
        name.setBounds(95, 20, 120, name.getPreferredSize().height);

        //---- id ----
        id.setText("text");
        id.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        contentPane.add(id);
        id.setBounds(95, 55, 140, id.getPreferredSize().height);

        //---- major ----
        major.setText("text");
        major.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        contentPane.add(major);
        major.setBounds(95, 95, 115, major.getPreferredSize().height);

        //---- grade ----
        grade.setText("text");
        grade.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        contentPane.add(grade);
        grade.setBounds(95, 130, 120, grade.getPreferredSize().height);

        //---- label1 ----
        label1.setText("Date :");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        contentPane.add(label1);
        label1.setBounds(340, 525, 90, 30);

        //---- timeLabel ----
        timeLabel.setText("text");
        timeLabel.setFont(timeLabel.getFont().deriveFont(timeLabel.getFont().getSize() + 2f));
        contentPane.add(timeLabel);
        timeLabel.setBounds(440, 525, 90, 30);

        //---- dateLabel ----
        dateLabel.setText("text");
        dateLabel.setFont(dateLabel.getFont().deriveFont(dateLabel.getFont().getSize() + 2f));
        contentPane.add(dateLabel);
        dateLabel.setBounds(550, 525, 90, 30);

        //---- iconLbl ----
        iconLbl.setIcon(new ImageIcon(getClass().getResource("/view/studentIcon.png")));
        iconLbl.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(iconLbl);
        iconLbl.setBounds(605, 20, 335, 280);

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
        setSize(950, 656);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - nazanin
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem enrollment;
    private JMenu menu2;
    private JMenuItem tuition;
    private JMenu menu3;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenu menu4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JTextField textField1;
    private JButton navigatorButton;
    private JButton button2;
    private JLabel name;
    private JLabel id;
    private JLabel major;
    private JLabel grade;
    private JLabel label1;
    private JLabel timeLabel;
    private JLabel dateLabel;
    private JLabel iconLbl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
