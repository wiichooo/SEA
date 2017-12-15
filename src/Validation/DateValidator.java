/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class DateValidator extends AbstractValidator {

    private JTextField theOtherDate = null;
    private boolean after;

    public DateValidator(JDialog parent, JTextField c, JTextField d, boolean after) {
        super(parent, c, "Pole nie może być puste.");
        this.theOtherDate = d;
        this.after = after;
    }
    
    public DateValidator(JFrame parent, JTextField c, JTextField d, boolean after) {
        super(parent, c, "Pole nie może być puste.");
        this.theOtherDate = d;
        this.after = after;
    }

    public DateValidator(JDialog parent, JTextField c) {
        super(parent, c, "Pole nie może być puste.");
    }

   
    protected boolean validationCriteria(JComponent c) {
        String text = ((JTextField) c).getText();

        if (text.equals("")) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date testDate = null;

        try {
            testDate = sdf.parse(text);
        } catch (ParseException e) {
            setMessage("the date you provided is in an invalid date format.");
            return false;
        }
        if (!sdf.format(testDate).equals(text)) {
            setMessage("The date that you provided is invalid.");
            return false;
        }

        if (theOtherDate != null && theOtherDate.getText().length()>0) {
            try {
                if (after) {
                    
                    setMessage("Ta data musi być PO drugiej dacie");
                    return testDate.after(sdf.parse(theOtherDate.getText()));
                } else {
                    setMessage("Ta data musi być PRZED drugą datą");
                    return testDate.before(sdf.parse(theOtherDate.getText()));
                }
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                setMessage("Nie mogę porównać dat, sprawdź format daty obok");
                return false;
            }
        }

        return true;
    }
}

