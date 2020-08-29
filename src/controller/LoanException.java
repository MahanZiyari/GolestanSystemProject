package controller;


import javax.swing.*;

/**
 * Created by Nazanin
 */
public class LoanException extends Exception
{
    public LoanException()
    {
        JOptionPane.showMessageDialog
                (null,"Your Request Could Not Be Registered",
                        "Error",JOptionPane.ERROR_MESSAGE);
    }
}
