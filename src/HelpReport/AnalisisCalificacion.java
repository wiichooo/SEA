/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HelpReport;

/**
 *
 * @author DAVID
 */
public class AnalisisCalificacion {
    
    private String sujeto;
    private int nota3=0;
    private int nota2=0;
    private int nota1=0;
    private int nota0=0;
    
    public AnalisisCalificacion(int nota3, int nota2, int nota1, int nota0){
        this.nota3= nota3;
        this.nota2= nota2;
        this.nota1= nota1;
        this.nota0= nota0;       
    }
    
    public AnalisisCalificacion(String sujeto, int nota3, int nota2, int nota1, int nota0){
        this.sujeto = sujeto;
        this.nota3= nota3;
        this.nota2= nota2;
        this.nota1= nota1;
        this.nota0= nota0;       
    }
    
    public AnalisisCalificacion(String sujeto){
        this.sujeto = sujeto;   
    }

    public int getNota3() {
        return nota3;
    }

    public void setNota3(int nota3) {
        this.nota3 = nota3;
    }

    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }

    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public int getNota0() {
        return nota0;
    }

    public void setNota0(int nota0) {
        this.nota0 = nota0;
    }

    public String getSujeto() {
        return sujeto;
    }

    public void setSujeto(String sujeto) {
        this.sujeto = sujeto;
    }
    
    
    
    
}
