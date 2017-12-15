/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author DAVID
 */
public class TipoRondaEstandarizacion {
    
    private int id;
    private int idTipoRonda;
    private int idEstandarizacion;
    private String dimension;
    private int idTipoSujeto;
    private float maximo;
    private float minimo;
    
    private TipoRonda tipoRonda;
    private Estandarizacion estandarizacion;
    
    public TipoRondaEstandarizacion(int id, int idTipoRonda, int idEstandarizacion, 
            String dimension, int idTipoSujeto, float maximo, float minimo){
        this.id = id;
        this.idTipoRonda = idTipoRonda;
        this.idEstandarizacion = idEstandarizacion;
        this.dimension = dimension;
        this.idTipoSujeto = idTipoSujeto;
        this.maximo = maximo;
        this.minimo = minimo;
    }
    
    public TipoRondaEstandarizacion(int idTipoRonda, int idEstandarizacion, String dimension, 
            int idTipoSujeto, float maximo, float minimo){
        this.idTipoRonda = idTipoRonda;
        this.idEstandarizacion = idEstandarizacion;
        this.dimension = dimension;
        this.idTipoSujeto = idTipoSujeto;
        this.maximo = maximo;
        this.minimo = minimo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTipoRonda() {
        return idTipoRonda;
    }

    public void setIdTipoRonda(int idTipoRonda) {
        this.idTipoRonda = idTipoRonda;
    }

    public int getIdEstandarizacion() {
        return idEstandarizacion;
    }

    public void setIdEstandarizacion(int idEstandarizacion) {
        this.idEstandarizacion = idEstandarizacion;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public int getIdTipoSujeto() {
        return idTipoSujeto;
    }

    public void setIdTipoSujeto(int idTipoSujeto) {
        this.idTipoSujeto = idTipoSujeto;
    }

    public float getMaximo() {
        return maximo;
    }

    public void setMaximo(float maximo) {
        this.maximo = maximo;
    }

    public float getMinimo() {
        return minimo;
    }

    public void setMinimo(float minimo) {
        this.minimo = minimo;
    }

    public TipoRonda getTipoRonda() {
        return tipoRonda;
    }

    public void setTipoRonda(TipoRonda tipoRonda) {
        this.tipoRonda = tipoRonda;
    }

    public Estandarizacion getEstandarizacion() {
        return estandarizacion;
    }

    public void setEstandarizacion(Estandarizacion estandarizacion) {
        this.estandarizacion = estandarizacion;
    }
    
}
