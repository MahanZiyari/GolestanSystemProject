package controller;

import javax.swing.*;

public class BlankException extends Exception
{
    public BlankException()
    {
        JOptionPane.showMessageDialog(null,"Fields Can Not Be Empty",
                "Blank Field Error",JOptionPane.ERROR_MESSAGE);
    }
}
