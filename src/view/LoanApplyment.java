/*
 * Created by JFormDesigner on Wed Jan 29 20:18:53 IRST 2020
 */

package view;

import controller.BlankException;
import controller.LoanController;
import controller.LoanException;
import model.entity.EmployeeEntity;
import model.entity.LogEntity;
import model.service.LogService;

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
public class LoanApplyment extends JFrame
{
    private List<LogEntity> logList;
    EmployeeEntity employeeEntity;
    public LoanApplyment() throws Exception {
        initComponents();
        logList= LogService.getInstance().report();
        fillLogTable();
        this.setVisible(true);
    }
    public LoanApplyment(EmployeeEntity employeeEntity) throws Exception {
        initComponents();
        this.employeeEntity=employeeEntity;
        logList= LogService.getInstance().report();
        fillLogTable();
        this.setVisible(true);
    }

    public void fillLogTable()
    {
        List<LogEntity> logEntityList=new ArrayList<>();
        for(LogEntity logEntity :logList)
        {
            logEntityList.add(logEntity);
        }
        Object[][] objects=new Object[logEntityList.size()][];
        for( int i=0 ; i<logEntityList.size() ; i++ )
        {
            objects[i]=new Object[3];
            objects[i][0] = logEntityList.get(i).getId();
            objects[i][1] = logEntityList.get(i).getDateAndTime();
            objects[i][2] = logEntityList.get(i).getSubject();
        }
        String[] titles = {"ID", "Date And Time", "Subject"};
        logTable.setModel(new DefaultTableModel(objects,titles)
        {
            Class<?>[] columnTypes = new Class<?>[] {
                    String.class, String.class, String.class
            };
            boolean[] columnEditable = new boolean[] {
                    false, false, false
            };
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return columnEditable[columnIndex];
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
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
            public Object getValueAt(int rowIndex, int columnIndex)
            {
                return objects[rowIndex][columnIndex];
            }
        });
        {
            TableColumnModel cm = logTable.getColumnModel();
            cm.getColumn(0).setPreferredWidth(170);
            cm.getColumn(1).setPreferredWidth(170);
            cm.getColumn(2).setPreferredWidth(155);
        }
    }

    private void backButtonMouseClicked(MouseEvent e)
    {
        this.setVisible(false);
    }

    private void requestButtonMouseClicked(MouseEvent e) throws LoanException {
        // TODO add your code here
        try {
            LoanController.getInstance().blanksChecker
                    (textField.getText(), String.valueOf(subjectCombo.getSelectedItem()));
            LoanController.getInstance().request
                    (employeeEntity.getId(),textField.getText(),
                            String.valueOf(subjectCombo.getSelectedItem()));
            JOptionPane.showMessageDialog(null,
                    "Your Request Will Be Examined");
        } catch (BlankException e1) {
            System.out.println("Empty Fields!");
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - nazanin
        scrollPane1 = new JScrollPane();
        logTable = new JTable();
        textField = new JTextField();
        textLbl = new JLabel();
        subjectCombo = new JComboBox<>();
        subjectLbl = new JLabel();
        backButton = new JButton();
        requestButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- logTable ----
            logTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, "", null},
                    {null, null, ""},
                },
                new String[] {
                    "ID", "Date And Time", "SUBJECT"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Long.class, String.class, String.class
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
                TableColumnModel cm = logTable.getColumnModel();
                cm.getColumn(0).setPreferredWidth(170);
                cm.getColumn(1).setPreferredWidth(170);
                cm.getColumn(2).setPreferredWidth(155);
            }
            scrollPane1.setViewportView(logTable);
        }

        //---- textLbl ----
        textLbl.setText("Enter The Text Here :");
        textLbl.setFont(textLbl.getFont().deriveFont(textLbl.getFont().getSize() + 8f));

        //---- subjectCombo ----
        subjectCombo.setModel(new DefaultComboBoxModel<>(new String[] {
            "Apply For A Loan",
            "Take Time Off"
        }));

        //---- subjectLbl ----
        subjectLbl.setText("Choose The Subject :");
        subjectLbl.setFont(subjectLbl.getFont().deriveFont(subjectLbl.getFont().getSize() + 8f));

        //---- backButton ----
        backButton.setText("BACK");
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backButtonMouseClicked(e);
            }
        });

        //---- requestButton ----
        requestButton.setText("REQUEST");
        requestButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    requestButtonMouseClicked(e);
                } catch (LoanException e1) {
                    e1.printStackTrace();
                }
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(textLbl, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)))
                    .addGap(94, 94, 94)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(requestButton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addComponent(subjectCombo, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(subjectLbl, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 21, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textLbl, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(subjectLbl, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(subjectCombo, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(requestButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(28, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - nazanin
    private JScrollPane scrollPane1;
    private JTable logTable;
    private JTextField textField;
    private JLabel textLbl;
    private JComboBox<String> subjectCombo;
    private JLabel subjectLbl;
    private JButton backButton;
    private JButton requestButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
