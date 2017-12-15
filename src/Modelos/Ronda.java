/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import com.j256.ormlite.field.DatabaseField;

/**
 *
 * @author DAVID
 */
public class Ronda {
    
    
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_TIPO = "tipoRonda";
    public static final String CAMPO_FECHA = "fecha";
    public static final String CAMPO_ESTANDARIZACION = "estandarizacion";

    
    @DatabaseField(id = true, columnName = CAMPO_ID)
    private int id;
     
    @DatabaseField(columnName=CAMPO_NOMBRE)
    private String nombre;
    
    @DatabaseField(columnName=CAMPO_TIPO)
    private int tipoRonda;
    
    @DatabaseField(columnName=CAMPO_FECHA)
    private String fecha;
    
    @DatabaseField(columnName=CAMPO_ESTANDARIZACION)
    private int estandarizacion;
    
    public Ronda(){
        
    }
        
    public Ronda(String nombre, int tipoRonda, String fecha, int estandarizacion){
        this.nombre = nombre;
        this.tipoRonda = tipoRonda;
        this.fecha = fecha;
        this.estandarizacion = estandarizacion;
    }
    
     public Ronda(int id, String nombre, int tipoRonda, String fecha, int estandarizacion){
        this.nombre = nombre;
        this.tipoRonda = tipoRonda;
        this.fecha = fecha;
        this.estandarizacion = estandarizacion;
        this.id = id;
    }

    public int getTipoRonda() {
        return tipoRonda;
    }

    public void setTipoRonda(int tipoRonda) {
        this.tipoRonda = tipoRonda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public int getEstandarizacion() {
        return estandarizacion;
    }

    public void setEstandarizacion(int estandarizacion) {
        this.estandarizacion = estandarizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public boolean equals(Object other) {
        boolean res;
        if (other == null || other.getClass() != getClass()) {
            res=false;
        }
        else {
            if (id==((Ronda) other).id) {
                res=true;
            }
            else {
                res=false;
            }
        }
        return res;
    }
    
    
}
