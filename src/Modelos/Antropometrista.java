/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author DAVID
 */
@DatabaseTable(tableName = "antropometrista")
public class Antropometrista {
    
    public static final String CAMPO_CODIGO = "codigo";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_TELEFONO = "telefono";
    public static final String CAMPO_SUPERVISOR = "supervisor";

    
    @DatabaseField(id = true, columnName = CAMPO_CODIGO)
    private int codigo;
     
    @DatabaseField(columnName=CAMPO_NOMBRE)
    private String nombre;
    
    @DatabaseField(columnName=CAMPO_TELEFONO)
    private String telefono;
    
    @DatabaseField(columnName=CAMPO_SUPERVISOR)
    private int supervisor;
    
    public Antropometrista() {
        // ORMLite needs a no-arg constructor 
    }
    
    public Antropometrista(int codigo, String nombre, String telefono, int supervisor){
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.supervisor = supervisor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }
    
    @Override
    public boolean equals(Object other) {
        boolean res;
        if (other == null || other.getClass() != getClass()) {
            res=false;
        }
        else {
            if (codigo==((Antropometrista) other).codigo) {
                res=true;
            }
            else {
                res=false;
            }
        }
        return res;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
}
