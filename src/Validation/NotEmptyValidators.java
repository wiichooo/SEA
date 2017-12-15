/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JTextField;

/**
 *
 * @author UTIL
 */
/**
 * A class for performing basic validation on text fields. All it does is make 
 * sure that they are not null.
 * 
 * @author Michael Urban
 */
 
public class NotEmptyValidators extends AbstractValidator {
    public NotEmptyValidators(JDialog parent, JTextField c, String message) {
        super(parent, c, message);
    }
	
    @Override
    protected boolean validationCriteria(JComponent c) {
        if (((JTextField)c).getText().equals(""))
            return false;
        return true;
    }
}