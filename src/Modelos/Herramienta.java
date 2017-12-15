/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author DAVID
 */
public class Herramienta {
    
    private String nombre;
    private int antropometrista;
    
    public Herramienta(String nombre, int antropometrista){
        this.nombre = nombre;
        this.antropometrista = antropometrista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAntropometrista() {
        return antropometrista;
    }

    public void setAntropometrista(int antropometrista) {
        this.antropometrista = antropometrista;
    }
    
}
