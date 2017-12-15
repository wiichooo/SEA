/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softestandantrop;

import java.io.File;

/**
 *
 * @author DAVID
 */
public class Midirectorio {

    public static String dar() {
        File miDir = new File (".");
     try {
      System.out.println ("Directorio actual: " + miDir.getCanonicalPath());
    return miDir.getCanonicalPath().toString();
     }
     catch(Exception e) {
       e.printStackTrace();
       return "";
       }
    
    }
    
}
