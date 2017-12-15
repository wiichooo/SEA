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
 

public class NameValidator extends AbstractValidator {
    public final String DEFAULT_MESSAGE = "El campo no puede estar vacío";
    
    public NameValidator(JFrame parent, JTextField c) {
        super(parent, c, "El campo no puede estar vacío.");
    }
    public NameValidator(JFrame parent, JTextField c, String message) {
        super(parent, c, message);
    }
	
    protected boolean validationCriteria(JComponent c) {
        String text = ((JTextField) c).getText();

        if (text.equals("")) {
            return false;
        }
        
        
        try {
            Matcher m = Pattern.compile("^[A-Za-z]+$").matcher(text);        
            if (!m.find()) {
                setMessage("Este campo sólo puede contener letras");
                return false;
            }

            
            
                
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            setMessage("Formato no válido");
            return false;
        }
        
        
        return true;
    }
}

