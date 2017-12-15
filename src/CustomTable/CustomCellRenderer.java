/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DAVID
 */
public class CustomCellRenderer extends DefaultTableCellRenderer {

  /* (non-Javadoc)
   * @see javax.swing.table.DefaultTableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
   */
  public Component getTableCellRendererComponent(JTable table, Object value,
    boolean isSelected, boolean hasFocus, int row, int column) {

   Component rendererComp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
     row, column);
   
   if((row%2)==0){
       rendererComp.setForeground(Color.black);
       rendererComp .setBackground(new Color(223,234,241));
   }
   else{
       rendererComp.setForeground(Color.black);
       rendererComp .setBackground(Color.white);
   }
   //Set foreground color
   
   //Set background color
   

   return rendererComp ;
  }

 }
