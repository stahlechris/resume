//***************************************************************************
//	File:                       Lineup.Java
//
//	Student:                    Chris Stahle
//
//	Assignment:                 Program  # 7
//
//	Course Name:                Java Programming I
//
//	Course Number:              COSC 2050 - 01
//
//      Due:                        October 11, 2016
//
//      Description:                This GUI program allows users to enter
//                                  names and assign those names to a baseball 
//                                  position.
//***************************************************************************
package Utilities;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.text.JTextComponent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class Validator {

    public boolean isPresent(JTextComponent c, String fieldName) {
        if (c.getText().length() == 0) { //c is the textField, fieldname is the name u called the textField
            showMessage(c, fieldName + "is a required field.");
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }

    public boolean isFormattedName(JTextComponent c, String fieldName) {
        String name = c.getText();
        String REGIX = "^\\D*$"; //dont allow numbers D for "any digit"
        Pattern pattern = Pattern.compile(REGIX);
        Matcher matcher = pattern.matcher(name);
        if (name.isEmpty() || !matcher.matches()) {
            showMessage(c, fieldName + "cant have numbers");
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }

    public boolean isAButtonSelected(JRadioButton h, JRadioButton v, String fieldName) {
        if (h.isSelected() == true || v.isSelected() == true) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "You must select either Home or Away", //where null centers the message 
                "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        h.requestFocusInWindow();
        return false;
    }

    public boolean isComboBoxSet(JComboBox c, String fieldName) {
        if (c.getSelectedIndex() == 0) //"Choose a selection" default is chosen
        {
            JOptionPane.showMessageDialog(null, fieldName + "entry is missing.", //where null centers the message 
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }

    public boolean isTheSamePositionAlreadyAssigned(JComboBox a, JComboBox b) {
        if (a.getSelectedIndex() == b.getSelectedIndex()) {
            JOptionPane.showMessageDialog(null, "That position is already assigned to a player!",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            b.requestFocusInWindow();
            return false;
        }
        return true;

    }

    public boolean isTheSamePlayerAlreadyAssigned(JTextComponent a, JTextComponent b) {
        if (a.getText() == b.getText()) {
            JOptionPane.showMessageDialog(null, "That player is already assigned a position!",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            b.requestFocusInWindow();
            return false;
        }
        return true;
    }

    private void showMessage(JTextComponent c, String message) //only for textFields
    {//message is the string literal u passed as an argument from caller
        //"invalid entry" is the title of the error  msg
        JOptionPane.showMessageDialog(c, message, "Invalid Entry",
                JOptionPane.ERROR_MESSAGE);
    }

}//end class
