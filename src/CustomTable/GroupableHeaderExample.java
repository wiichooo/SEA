/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import DataBase.DataBase;
import Modelos.Antropometrista;
import Modelos.RondaAntropometrista;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;


/**
 * @version 1.0 11/09/98
 */
public class GroupableHeaderExample extends JFrame {

  GroupableHeaderExample() {
    super( "Groupable Header Example" );

    /*DefaultTableModel dm = new DefaultTableModel();
    DataBase op = new DataBase();
    List<Antropometrista> antrop = op.getAllAntropometristasByRonda(1);
    List<Object> antrops = new ArrayList<Object>();
    List<RondaAntropometrista > listaRA = op.getAllRondaAntropometristaByRonda(1);
    int sujetos = op.getAllSujetosByRonda(1).size();
    Object o[][] = new Object[sujetos][antrop.size()*2+1];
    Hashtable h = new Hashtable();
    int ii=-1;
    int jj=0;
    for(RondaAntropometrista ra:listaRA){
        if(h.isEmpty() || !h.containsKey(ra.getIdSujeto())){
            ii++;
            jj=0;
            o[ii][jj] = ra.getSujeto().getNombre();
            h.put(ra.getIdSujeto(), ra.getIdSujeto());
        }
        jj++;
        o[ii][jj] = ra.getMedicion1();
        jj++;
        o[ii][jj] = ra.getMedicion2();
    }
    
    antrops.add("Suetos a medir");
    for(Antropometrista a:antrop){
        //antrops.add(a);
        antrops.add("Med 1");
        antrops.add("Med 2");
    }
    dm.setDataVector(o,
    antrops.toArray());

    JTable table = new JTable( dm ) {
      protected JTableHeader createDefaultTableHeader() {
          return new GroupableTableHeader(columnModel);
      }
    };
    
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
    table.setDefaultRenderer(Object.class, centerRenderer);
    
      
    TableColumnModel cm = table.getColumnModel();
    ColumnGroup g_name = new ColumnGroup("Participantes");
    int j=0;
    for(int i=1;i<antrops.size();i=i+2){
        //g_name.add(cm.getColumn(i));
        ColumnGroup g_otro = new ColumnGroup(antrop.get(j).getNombre());
        g_otro.add(cm.getColumn(i));
        g_otro.add(cm.getColumn(i+1));
        g_name.add(g_otro);
        j++;
    }
    
    
    GroupableTableHeader header = (GroupableTableHeader)table.getTableHeader();
    header.addColumnGroup(g_name);
    //header.addColumnGroup(g_lang);
    JScrollPane scroll = new JScrollPane( table );
    getContentPane().add( scroll );
    setSize( 400, 120 );   */
  }
  
}