/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softestandantrop;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public final class Error {

    public static void mostrarMensajeError(Component forma, String mensaje, String titulo) {
        JOptionPane.showMessageDialog(forma,
                mensaje,
                titulo,
                JOptionPane.ERROR_MESSAGE);
    }
}
