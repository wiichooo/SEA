/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softestandantrop;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author DAVID
 */
public class CustomMutableTreeNode extends DefaultMutableTreeNode{
    
    private int idEstandarizacion;
    private int idRonda;
    private int idAntropometrista;
    private int tipo;
    private String nombre;
    
    public CustomMutableTreeNode(String nombre, int tipo, int idEstandarizacion){
        super(nombre);
        this.tipo = tipo;
        this.idEstandarizacion = idEstandarizacion;
        this.nombre = nombre;        
    }
    
    public CustomMutableTreeNode(String nombre, int tipo, int idEstandarizacion, int idRonda){
        super(nombre);
        this.tipo = tipo;
        this.idEstandarizacion = idEstandarizacion;
        this.idRonda = idRonda;
        this.nombre = nombre;
    }
    
    public CustomMutableTreeNode(String nombre, int tipo, int idRonda, int idAntropometrista, boolean noSirve){
        super(nombre);
        this.tipo = tipo;
        this.idRonda = idRonda;
        this.idAntropometrista = idAntropometrista;
        this.nombre = nombre;
    }

    public int getIdEstandarizacion() {
        return idEstandarizacion;
    }

    public void setIdEstandarizacion(int idEstandarizacion) {
        this.idEstandarizacion = idEstandarizacion;
    }

    public int getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    public int getIdAntropometrista() {
        return idAntropometrista;
    }

    public void setIdAntropometrista(int idAntropometrista) {
        this.idAntropometrista = idAntropometrista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
}
