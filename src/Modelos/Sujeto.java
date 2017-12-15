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
@DatabaseTable(tableName = "sujeto")
public class Sujeto {
    
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_EDAD = "edad";
    public static final String CAMPO_SEXO = "sexo";
    
    @DatabaseField(id = true, columnName = CAMPO_ID)
    private int id;
     
    @DatabaseField(columnName=CAMPO_NOMBRE)
    private String nombre;
    
    @DatabaseField(columnName=CAMPO_EDAD)
    private int edad;
    
    @DatabaseField(columnName=CAMPO_SEXO)
    private String sexo;
    
    public Sujeto(){
        
    }
    
    public Sujeto(String nombre, int edad, String sexo){
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public Sujeto(int id, String nombre, int edad, String sexo){
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
    @Override
    public boolean equals(Object other) {
        boolean res;
        if (other == null || other.getClass() != getClass()) {
            res=false;
        }
        else {
            if (id==((Sujeto) other).id) {
                res=true;
            }
            else {
                res=false;
            }
        }
        return res;
    }
    
}
