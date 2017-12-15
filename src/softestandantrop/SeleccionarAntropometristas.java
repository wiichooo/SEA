/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softestandantrop;

import DataBase.DataBase;
import Modelos.Antropometrista;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Luis
 */
public class SeleccionarAntropometristas extends javax.swing.JDialog {

    /**
     * Creates new form SeleccionarAntropometristas
     */
    DefaultListModel listTotales = new DefaultListModel();
    DefaultListModel listSelec = new DefaultListModel();
    AgregarRonda Ronda;
    Inicio inicio;
    public SeleccionarAntropometristas(AgregarRonda agregarronda, Inicio inicio) {

        super(new JFrame(), true);
        initComponents();
        this.inicio = inicio;
        this.setLocationRelativeTo(null);
        Ronda = agregarronda;
        Actualizar();
        
//        System.out.println(String.valueOf(agregarronda.cboEstandarizacion.getSelectedItem()));
//        System.out.println(String.valueOf(agregarronda.cboSupervisor.getSelectedItem()));
//        System.out.println(agregarronda.txtNombre.getText());
//        System.out.println(agregarronda.fecha.getDate().toString());
        
        this.setVisible(true);
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ltTotal = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        ltSelec = new javax.swing.JList();
        BtnEliminar = new javax.swing.JButton();
        BtnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtnAgregarA = new javax.swing.JButton();
        BtnSelecionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccionar Antropometristas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccionar Antropometristas", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        ltTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ltTotal.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ltTotal);

        ltSelec.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ltSelec.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(ltSelec);

        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/16/Navigation Left.png"))); // NOI18N
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/16/Navigation Right.png"))); // NOI18N
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        jLabel1.setText("Total:");

        jLabel2.setText("Seleccionados:");

        BtnAgregarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/16/Symbol Add.png"))); // NOI18N
        BtnAgregarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarAActionPerformed(evt);
            }
        });

        BtnSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/16/Navigation Right.png"))); // NOI18N
        BtnSelecionar.setText("Agregar Sujetos");
        BtnSelecionar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BtnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtnEliminar)
                                    .addComponent(BtnAgregar)))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnAgregarA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnSelecionar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(BtnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnAgregar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnAgregarA)
                    .addComponent(BtnSelecionar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSelecionarActionPerformed
        //        new SeleccionarSujetos(cboEstandarizacion.getSelectedItem(), txtNombre.getText(),
            //            fecha.getDate(), rbPeso.isSelected(), rbTalla.isSelected(), cboSupervisor.getSelectedItem());
        if(ltSelec.getModel().getSize()!=0){
            this.dispose();
            new SeleccionarSujetos(Ronda,this, inicio);
        }
        else{
            Error.mostrarMensajeError(this, "Seleccione al menos un antropometrista.", "Seleccionar Antropometristas");
        }

    }//GEN-LAST:event_BtnSelecionarActionPerformed

    private void BtnAgregarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarAActionPerformed
        new AgregarAntropometrista();
        Actualizar();
    }//GEN-LAST:event_BtnAgregarAActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        try{

            Object seleccionado = listTotales.getElementAt(ltTotal.getSelectedIndex());

            listTotales.removeElementAt(ltTotal.getSelectedIndex());

            listSelec.addElement(seleccionado);

            ltSelec.setModel(listSelec);

        }catch(Exception e){
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        try{
            Object seleccionado = listSelec.getElementAt(ltSelec.getSelectedIndex());

            listSelec.removeElementAt(ltSelec.getSelectedIndex());

            listTotales.addElement(seleccionado);

            ltTotal.setModel(listTotales);

        }catch(Exception e){
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnAgregarA;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList ltSelec;
    private javax.swing.JList ltTotal;
    // End of variables declaration//GEN-END:variables

    private void Actualizar() {
        listSelec = new DefaultListModel();
        listTotales = new DefaultListModel();
        try{
            ArrayList antropometristas = (ArrayList) new DataBase().getAllNoSupervisores();

            Iterator iantropometristas = antropometristas.iterator();
            Antropometrista an = null;

            while(iantropometristas.hasNext()){
                an = (Antropometrista) iantropometristas.next();
    //            listTotales.addElement(an.getCodigo() + "   " + an.getNombre());
                listTotales.addElement(an.getCodigo() + " - " +an.getNombre() + " Tel: " + an.getTelefono());

            }
        }
        catch(SQLException se){
            JOptionPane.showMessageDialog(null, 
                                    "Ocurrió un error al obtener los antropometristas que no son supervisores.");
        }
        ltTotal.setModel(listTotales);
        ltSelec.setModel(listSelec);
    }
}
