/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HelpReport;

import Modelos.Antropometrista;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAVID
 */
public class EvaluacionAntropometrista {
    
    private Antropometrista antropometrista;
    
    private Object[][] datosPrecalculos;
    private List<AnalisisCalificacion> precision;
    private List<AnalisisCalificacion> exactitud;
    
    private int totalPrecision0;
    private int totalPrecision1;
    private int totalPrecision2;
    private int totalPrecision3;
    
    private int totalExactitud0;
    private int totalExactitud1;
    private int totalExactitud2;
    private int totalExactitud3;
    
    private String resultadoPrecision;
    private String resultadoExactitud;
    
    public EvaluacionAntropometrista(){
        precision = new ArrayList<AnalisisCalificacion>();
        exactitud = new ArrayList<AnalisisCalificacion>();
    }
    
    public void setTotales(){
        for(AnalisisCalificacion ac : precision){
            totalPrecision0 += ac.getNota0()*10;
            totalPrecision1 += ac.getNota1()*10;
            totalPrecision2 += ac.getNota2()*10;
            totalPrecision3 += ac.getNota3()*10;
        }
        
        for(AnalisisCalificacion ac : exactitud){
            totalExactitud0 += ac.getNota0()*10;
            totalExactitud1 += ac.getNota1()*10;
            totalExactitud2 += ac.getNota2()*10;
            totalExactitud3 += ac.getNota3()*10;
        }
        if(totalPrecision0>0) resultadoPrecision = "NE";
        else if( (totalPrecision2+totalPrecision3) >= 80) resultadoPrecision = "E";
        else resultadoPrecision = "NM";
        
        if(totalExactitud0>0) resultadoExactitud = "NE";
        else if( (totalExactitud2+totalExactitud3) >= 80) resultadoExactitud = "E";
        else resultadoExactitud = "NM";
    }

    public Antropometrista getAntropometrista() {
        return antropometrista;
    }

    public void setAntropometrista(Antropometrista antropometrista) {
        this.antropometrista = antropometrista;
    }

    public List<AnalisisCalificacion> getPrecision() {
        return precision;
    }

    public void setPrecision(List<AnalisisCalificacion> precision) {
        this.precision = precision;
    }

    public List<AnalisisCalificacion> getExactitud() {
        return exactitud;
    }

    public void setExactitud(List<AnalisisCalificacion> exactitud) {
        this.exactitud = exactitud;
    }

    public int getTotalPrecision0() {
        return totalPrecision0;
    }

    public void setTotalPrecision0(int totalPrecision0) {
        this.totalPrecision0 = totalPrecision0;
    }

    public int getTotalPrecision1() {
        return totalPrecision1;
    }

    public void setTotalPrecision1(int totalPrecision1) {
        this.totalPrecision1 = totalPrecision1;
    }

    public int getTotalPrecision2() {
        return totalPrecision2;
    }

    public void setTotalPrecision2(int totalPrecision2) {
        this.totalPrecision2 = totalPrecision2;
    }

    public int getTotalPrecision3() {
        return totalPrecision3;
    }

    public void setTotalPrecision3(int totalPrecision3) {
        this.totalPrecision3 = totalPrecision3;
    }

    public int getTotalExactitud0() {
        return totalExactitud0;
    }

    public void setTotalExactitud0(int totalExactitud0) {
        this.totalExactitud0 = totalExactitud0;
    }

    public int getTotalExactitud1() {
        return totalExactitud1;
    }

    public void setTotalExactitud1(int totalExactitud1) {
        this.totalExactitud1 = totalExactitud1;
    }

    public int getTotalExactitud2() {
        return totalExactitud2;
    }

    public void setTotalExactitud2(int totalExactitud2) {
        this.totalExactitud2 = totalExactitud2;
    }

    public int getTotalExactitud3() {
        return totalExactitud3;
    }

    public void setTotalExactitud3(int totalExactitud3) {
        this.totalExactitud3 = totalExactitud3;
    }

    public String getResultadoPrecision() {
        return resultadoPrecision;
    }

    public void setResultadoPrecision(String resultadoPrecision) {
        this.resultadoPrecision = resultadoPrecision;
    }

    public String getResultadoExactitud() {
        return resultadoExactitud;
    }

    public void setResultadoExactitud(String resultadoExactitud) {
        this.resultadoExactitud = resultadoExactitud;
    }

    public Object[][] getDatosPrecalculos() {
        return datosPrecalculos;
    }

    public void setDatosPrecalculos(Object[][] datosPrecalculos) {
        this.datosPrecalculos = datosPrecalculos;
    }
}
