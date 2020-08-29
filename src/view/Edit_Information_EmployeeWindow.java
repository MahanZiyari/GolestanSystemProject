package view;

import controller.Edit_Information_Employee;
import model.entity.EmployeeEntity;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Edit_Information_EmployeeWindow extends JFrame implements ActionListener {

    //....................... create component .......................
    private JLabel labelPost;
    private JLabel labelID;
    private JLabel labelName;
    private JLabel labelPass;

    private JTextField textFieldName;
    private JTextField textFieldPass;

    private JButton buttonSave;

    EmployeeEntity entity;
    public Edit_Information_EmployeeWindow(EmployeeEntity entity){

        this.entity =entity;
        init();
        setValu();
        //frame:
        this.setVisible(true);
        setLocationRelativeTo(getOwner());
        this.setBounds(200,100,310,300);
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]",
                // rows
                "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));


        //---- labels ----

        labelPost.setFont(new Font("Calisto MT", Font.BOLD, 14));
        labelPost.setBackground(Color.white);


        labelID.setFont(new Font("Calisto MT", Font.BOLD, 14));


        labelName.setText("name :");
        labelName.setFont(new Font("Calisto MT", Font.BOLD, 14));

        labelPass.setText("pass:");
        labelPass.setFont(new Font("Calisto MT", Font.BOLD, 14));

        //---- textFields ----
        textFieldName.setAlignmentX(11.5F);



        //---- button ----
        buttonSave.setText("save");
        buttonSave.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
        buttonSave.setBackground(new Color(204, 204, 204));
        buttonSave.setForeground(Color.blue);


        //......................... add component ........................

        buttonSave.addActionListener(this);

        contentPane.add(labelPost, "cell 2 4 6 3");
        contentPane.add(labelID, "cell 2 9 2 1");
        contentPane.add(labelName, "cell 2 12");
        contentPane.add(textFieldName, "cell 3 10 11 5,hmax 200");
        contentPane.add(labelPass, "cell 2 17");
        contentPane.add(textFieldPass, "cell 3 17 11 1");
        contentPane.add(buttonSave, "cell 12 21 2 1");

        pack();


    }
    //......................... set component ........................
    public void setValu() {


        labelPost.setText("post :    " + Edit_Information_Employee.getInstance().show(entity).getPost());
        labelID.setText("ID :      " + Edit_Information_Employee.getInstance().show(entity).getId());

        textFieldName = new JTextField(Edit_Information_Employee.getInstance().show(entity).getName());
        textFieldPass = new JTextField(Edit_Information_Employee.getInstance().show(entity).getPass());
    }


    public void init(){

        labelName = new JLabel();
        labelPass = new JLabel();
        labelID = new JLabel();
        labelPost = new JLabel();

        buttonSave = new JButton();
    }

    //......................... Action listener ........................
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == buttonSave)
        {
            //set
            this.entity.setName(textFieldName.getText());
            this.entity.setPass(textFieldPass.getText());

            //edit
            Edit_Information_Employee.getInstance().edit(entity);
        }
    }

}

