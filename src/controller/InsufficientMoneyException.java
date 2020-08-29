package controller;
import javax.swing.*;

public class InsufficientMoneyException extends Exception
{
    public InsufficientMoneyException()
    {
        JOptionPane.showMessageDialog(null,
                "There's not enough money in your bank account!",
                "Not Enough Money",JOptionPane.ERROR_MESSAGE);
    }
}
