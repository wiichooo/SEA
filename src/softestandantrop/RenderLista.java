/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softestandantrop;

import Modelos.RondaAntropometrista;
import java.awt.Component;
import java.awt.Font;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author DAVID
 */
public class RenderLista extends JLabel implements ListCellRenderer{
 
    HashMap<Object, ImageIcon> elementos;
    ImageIcon icononulo = new ImageIcon(this.getClass().getResource("../icons/16/logout.png"));
 
    public RenderLista(){
        elementos = new HashMap<Object, ImageIcon>();
        ImageIcon icono1 =  new ImageIcon(this.getClass().getResource("../icons/16/group.png"));
        ImageIcon icono2=  new ImageIcon(this.getClass().getResource("../icons/16/keyboard.png"));
        elementos.put("F", icono1);
        elementos.put("M", icono2);
    }


    @Override
    public Component getListCellRendererComponent(JList list, Object value,int index, boolean isSelected, boolean cellHasFocus) {
        RondaAntropometrista ronda = (RondaAntropometrista)value;
        if(elementos.get(ronda.getSujeto().getSexo())!=null){
            setIcon(elementos.get(ronda.getSujeto().getSexo()));
            setText(""+ronda.getSujeto().getNombre());
            if(isSelected){
                setFont(new Font("Verdana",Font.BOLD,16));
            }else{
                setFont(null);
            }
        }
        else{
            setIcon(icononulo);
            setText(""+ronda.getSujeto().getNombre());
            if(isSelected){
                setFont(new Font("Verdana",Font.BOLD,16));
            }else{
                setFont(null);
            }
        }
            return this;
    }
}