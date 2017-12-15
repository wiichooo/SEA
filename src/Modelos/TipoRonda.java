/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author DAVID
 */
public class TipoRonda {
    
    private int id;
    private String nombre;
    
    public TipoRonda(String nombre){
        this.nombre = nombre;
    }
    
    public TipoRonda(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
