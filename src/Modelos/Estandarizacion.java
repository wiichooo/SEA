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
public class Estandarizacion {
    
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_ENCUESTA = "encuesta";
    public static final String CAMPO_FECHAINI = "fechaIni";
    public static final String CAMPO_FECHAFIN = "fechaFin";
    
    @DatabaseField(id = true, columnName = CAMPO_ID)
    private int id;
     
    @DatabaseField(columnName=CAMPO_ENCUESTA)
    private String encuesta;
    
    @DatabaseField(columnName=CAMPO_FECHAINI)
    private String fechaIni;
    
    @DatabaseField(columnName=CAMPO_FECHAFIN)
    private String fechaFin;
    
    public Estandarizacion() {
        // ORMLite needs a no-arg constructor 
    }
    
    public Estandarizacion(String encuesta, String fechaIni, String fechaFin){
        this.encuesta = encuesta;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }
    
    public Estandarizacion(int id, String encuesta, String fechaIni, String fechaFin){
        this.encuesta = encuesta;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(String encuesta) {
        this.encuesta = encuesta;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    @Override
    public boolean equals(Object other) {
        boolean res;
        if (other == null || other.getClass() != getClass()) {
            res=false;
        }
        else {
            if (id==((Estandarizacion) other).id) {
                res=true;
            }
            else {
                res=false;
            }
        }
        return res;
    }
    
}
