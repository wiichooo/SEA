/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author JOSE
 */
public final class TiposValidator {
    
   public static boolean esNumero(JComponent c) {
        String text = ((JTextField) c).getText();
        boolean res = true;

        if (text.equals("")) {
            res=false;
        }
        else {
            Float testFloat = null;
            try {
                Matcher m = Pattern.compile("[^\\d]").matcher(text);        
                if (m.find()) {
                    res=false;
                }
                testFloat = Float.parseFloat(text);
                if(testFloat<=0) {
                    res=false;
                }
            } catch (Exception ex) {
                res=false;
            }
        }
        return res;
    }
   
   public static boolean esNumeroDecimal(JComponent c){
       String text = ((JTextField) c).getText();
        boolean res = true;

        if (text.equals("")) {
            res=false;
        }
        else {
            Float testFloat = null;
            try {
                testFloat = Float.parseFloat(text);
                if(testFloat<0) {
                    res=false;
                }
            } catch (Exception ex) {
                res=false;
            }
        }
        return res;
   }
   
   /* public static boolean esFecha(JComponent c) {
        String text = ((DateChooserCombo) c).getText();
        boolean res = true;
        
        SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyyy");

        if (text.equals("")) {
            res=false;
        }
        Date testDate = null;
        try {
            testDate = datef.parse(text);
        } catch (ParseException pe) {
            res=false;
        }
        return res;
    }*/
    
    
    public static boolean esHora(JComponent c) {
        String text = ((JTextField) c).getText();
        boolean res = true;

        if (text.equals("")) {
            res=false;
        }
        else {
            Float testFloat = null;
            try {
                Matcher m = Pattern.compile("[^\\d]").matcher(text);        
                if (m.find()) {
                    res=false;
                }
                testFloat = Float.parseFloat(text);
                if(testFloat<0 || testFloat>59) {
                    res=false;
                }
            } catch (Exception ex) {
                res=false;
            }
        }
        return res;
    }
}
