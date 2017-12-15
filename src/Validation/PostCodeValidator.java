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
 

public class PostCodeValidator extends AbstractValidator {
    public final String DEFAULT_MESSAGE = "Pole nie może być puste.";
    
    public PostCodeValidator(JFrame parent, JTextField c) {
        super(parent, c, "Pole nie może być puste.");
    }
    public PostCodeValidator(JFrame parent, JTextField c, String message) {
        super(parent, c, message);
    }
	
    protected boolean validationCriteria(JComponent c) {
        String text = ((JTextField) c).getText();

        if (text.equals("")) {
            return false;
        }
        
        
        try {
            Matcher m = Pattern.compile("[^\\d-]").matcher(text);        
            if (m.find()) {
                setMessage("To pole może zawierać tylko cyfry i myślnik");
                return false;
            }

            if(text.length()!=6) {
                setMessage("Nieprawidłowa długość kodu");
                return false;
            }
            
            if(text.charAt(2)!='-') {
                setMessage("Nieprawidłowy format kodu");
                return false;
            }
                
        } catch (Exception ex) {
            setMessage("Nieprawidłowy format");
            return false;
        }
        
        
        return true;
    }
}

