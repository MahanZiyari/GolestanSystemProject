/*
 * Created by JFormDesigner on Fri Jan 31 12:48:51 IRST 2020
 */

package view;

import controller.BlankException;
import controller.RecordsController;
import model.entity.EmployeeEntity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author nazanin
 */
public class RecordsWindow extends JFrame
{
    EmployeeEntity entity;
    public RecordsWindow(EmployeeEntity entity) throws Exception
    {
        initComponents();
        this.entity=entity;
        this.setVisible(true);
    }
    public RecordsWindow()
    {
        initComponents();
        this.setVisible(true);
    }


    private void backButtonMouseClicked(MouseEvent e)
    {
        this.setVisible(false);
    }

    private void saveButtonMouseClicked(MouseEvent e)throws Exception
    {
        try {
            RecordsController.getInstance().blanksChecker(textField.getText(),
                    String.valueOf(subjectCombo.getSelectedItem()));
            RecordsController.getInstance().save(1111,textField.getText(),
                    String.valueOf(subjectCombo.getSelectedItem()));
            JOptionPane.showMessageDialog(null,
                    "Saved");
        } catch (BlankException e1) {
            e1.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - nazanin
        titleLbl = new JLabel();
        iconLbl = new JLabel();
        recordLbl = new JLabel();
        textField = new JTextField();
        subjectLbl = new JLabel();
        subjectCombo = new JComboBox<>();
        backButton = new JButton();
        saveButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- titleLbl ----
        titleLbl.setText("\" Entering Records In System \"");
        titleLbl.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);

        //---- iconLbl ----
        iconLbl.setHorizontalAlignment(SwingConstants.CENTER);
        iconLbl.setIcon(new ImageIcon(getClass().getResource("/view/PngItem_556703-150x146.png")));

        //---- recordLbl ----
        recordLbl.setText("Enter Record Text :");
        recordLbl.setFont(recordLbl.getFont().deriveFont(recordLbl.getFont().getSize() + 4f));

        //---- subjectLbl ----
        subjectLbl.setText("Choose The Subject :");
        subjectLbl.setFont(subjectLbl.getFont().deriveFont(subjectLbl.getFont().getSize() + 4f));

        //---- subjectCombo ----
        subjectCombo.setFont(subjectCombo.getFont().deriveFont(subjectCombo.getFont().getSize() + 2f));
        subjectCombo.setModel(new DefaultComboBoxModel<>(new String[] {
            "Insurance",
            "Academic Endorsement",
            "Advance Money"
        }));

        //---- backButton ----
        backButton.setText("BACK");
        backButton.setFont(backButton.getFont().deriveFont(backButton.getFont().getSize() + 2f));
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backButtonMouseClicked(e);
            }
        });

        //---- saveButton ----
        saveButton.setText("SAVE");
        saveButton.setFont(saveButton.getFont().deriveFont(saveButton.getFont().getSize() + 2f));
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    saveButtonMouseClicked(e);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(recordLbl, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(subjectLbl, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                        .addComponent(subjectCombo, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
                    .addGap(67, 67, 67))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(657, Short.MAX_VALUE)
                            .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(259, 259, 259)
                            .addComponent(titleLbl, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                            .addComponent(iconLbl, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)))
                    .addGap(17, 17, 17))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(titleLbl, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addGap(63, 63, 63)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(recordLbl, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addComponent(subjectLbl, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(iconLbl, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(subjectCombo, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                        .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                    .addGap(19, 19, 19))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - nazanin
    private JLabel titleLbl;
    private JLabel iconLbl;
    private JLabel recordLbl;
    private JTextField textField;
    private JLabel subjectLbl;
    private JComboBox<String> subjectCombo;
    private JButton backButton;
    private JButton saveButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
