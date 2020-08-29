package controller;


import javax.swing.*;

public class CardNotFoundException extends Exception
{
    public CardNotFoundException()
    {
        JOptionPane.showMessageDialog(null,
                "No information was found with this card number.","Error",
                JOptionPane.OK_OPTION);
    }
}
