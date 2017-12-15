/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JDialog;
import javax.swing.JFrame;
 

public class NumberValidator extends AbstractValidator {
    public final String DEFAULT_MESSAGE = "El campo no puede estar vacío.";
    
    public NumberValidator(JDialog parent, JTextField c) {
        super(parent, c, "El campo no puede estar vacío.");
    }
    public NumberValidator(JDialog parent, JTextField c, String message) {
        super(parent, c, message);
    }
	
    protected boolean validationCriteria(JComponent c) {
        String text = ((JTextField) c).getText();

        if (text.equals("")) {
            return false;
        }
        
        Float testFloat = null;
        try {
            Matcher m = Pattern.compile("[^\\d.]").matcher(text);        
            if (m.find()) {
                setMessage("Este campo puede contener sólo dígitos y punto");
                return false;
            }

            testFloat = Float.parseFloat(text);
        } catch (Exception ex) {
            setMessage("Formato de número no válido");
            return false;
        }
        if(testFloat<=0) {
            setMessage("El número debe ser no negativo");
            return false;
        }
        
        
        return true;
    }
}

