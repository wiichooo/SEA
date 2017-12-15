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
@DatabaseTable(tableName = "RondaAntropometrista")
public class RondaAntropometrista {
    
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_IDSUJETO = "sujeto";
    public static final String CAMPO_IDANTROPOMETRISTA = "antropometrista";
    public static final String CAMPO_RONDA = "ronda";
    public static final String CAMPO_MEDICION1 = "med1";
    public static final String CAMPO_MEDICION2 = "med2";

    
    @DatabaseField(columnName = CAMPO_ID, generatedId = true)
    private int id;
     
    @DatabaseField(columnName=CAMPO_IDSUJETO)
    private int idSujeto;
    
    @DatabaseField(columnName=CAMPO_IDANTROPOMETRISTA)
    private int idAntropometrista;
    
    @DatabaseField(columnName=CAMPO_RONDA)
    private int ronda;
    
    @DatabaseField(columnName=CAMPO_MEDICION1)
    private float medicion1;
    
    @DatabaseField(columnName=CAMPO_MEDICION2)
    private float medicion2;
        
    private Sujeto sujeto;
    private Antropometrista antropometrista;
    
    public RondaAntropometrista(){
        
    }
    
    public RondaAntropometrista(int idSujeto, int idAntropometrista, int ronda){
        this.idSujeto = idSujeto;
        this.idAntropometrista = idAntropometrista;
        this.ronda = ronda;
    }
    
    public RondaAntropometrista(int id, int idSujeto, int idAntropometrista, int ronda){
        this.id = id;
        this.idSujeto = idSujeto;
        this.idAntropometrista = idAntropometrista;
        this.ronda = ronda;
    }
    
    public RondaAntropometrista(int id, int idSujeto, int idAntropometrista, int ronda, float med1, float med2){
        this.id = id;
        this.idSujeto = idSujeto;
        this.idAntropometrista = idAntropometrista;
        this.ronda = ronda;
        this.medicion1 = med1;
        this.medicion2 = med2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAntropometrista() {
        return idAntropometrista;
    }

    public void setIdAntropometrista(int idAntropometrista) {
        this.idAntropometrista = idAntropometrista;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public float getMedicion1() {
        return medicion1;
    }

    public void setMedicion1(float medicion1) {
        this.medicion1 = medicion1;
    }

    public float getMedicion2() {
        return medicion2;
    }

    public void setMedicion2(float medicion2) {
        this.medicion2 = medicion2;
    }

    public int getIdSujeto() {
        return idSujeto;
    }

    public void setIdSujeto(int idSujeto) {
        this.idSujeto = idSujeto;
    }

    public Sujeto getSujeto() {
        return sujeto;
    }

    public void setSujeto(Sujeto sujeto) {
        this.sujeto = sujeto;
    }

    public Antropometrista getAntropometrista() {
        return antropometrista;
    }

    public void setAntropometrista(Antropometrista antropometrista) {
        this.antropometrista = antropometrista;
    }
    
    @Override
    public String toString(){
        if(this.sujeto!=null){
            return this.sujeto.getNombre();
        }
        return "String de ronda antropometrista";
    }
    
    @Override
    public boolean equals(Object other) {
        boolean res;
        if (other == null || other.getClass() != getClass()) {
            res=false;
        }
        else {
            if (id==((RondaAntropometrista) other).id) {
                res=true;
            }
            else {
                res=false;
            }
        }
        return res;
    }
    
}
