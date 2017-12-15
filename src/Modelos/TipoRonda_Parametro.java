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
@DatabaseTable(tableName = "TipoRonda_Parametros")
public class TipoRonda_Parametro {
    
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_TIPORONDA = "tipoRonda";
    public static final String CAMPO_MENORIGUALQ = "menorigualq";
    public static final String CAMPO_PUNTAJE = "puntaje";
    public static final String CAMPO_DECIMALES = "decimales";
    
    @DatabaseField(id=true, columnName = CAMPO_ID)
    private int id;
     
    @DatabaseField(columnName=CAMPO_TIPORONDA)
    private int tipoRonda;
    
    @DatabaseField(columnName=CAMPO_MENORIGUALQ)
    private double menorigualq;
    
    @DatabaseField(columnName=CAMPO_PUNTAJE)
    private int puntaje;
    
    @DatabaseField(columnName=CAMPO_DECIMALES)
    private int decimales;
    
    public TipoRonda_Parametro(){
        
    }
    
    public TipoRonda_Parametro(int id, int tipoRonda, double menorigualq, int puntaje, int decimales){
        this.id = id;
        this.tipoRonda = tipoRonda;
        this.menorigualq = menorigualq;
        this.puntaje = puntaje;
        this.decimales = decimales;
    }
    
    public TipoRonda_Parametro(int tipoRonda, double menorigualq, int puntaje, int decimales){
        this.tipoRonda = tipoRonda;
        this.menorigualq = menorigualq;
        this.puntaje = puntaje;
        this.decimales = decimales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoRonda() {
        return tipoRonda;
    }

    public void setTipoRonda(int tipoRonda) {
        this.tipoRonda = tipoRonda;
    }

    public double getMenorigualq() {
        return menorigualq;
    }

    public void setMenorigualq(double menorigualq) {
        this.menorigualq = menorigualq;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getDecimales() {
        return decimales;
    }

    public void setDecimales(int decimales) {
        this.decimales = decimales;
    }
    
    
}
