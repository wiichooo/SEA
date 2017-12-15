/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HelpReport;

import CustomTable.ColumnGroup;
import CustomTable.CustomCellRenderer;
import CustomTable.GroupableTableHeader;
import DataBase.DataBase;
import Modelos.Antropometrista;
import Modelos.Ronda;
import Modelos.RondaAntropometrista;
import Modelos.TipoRonda_Parametro;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import softestandantrop.Inicio;

/**
 *
 * @author DAVID
 */
public class Reporte {
    
    private List<AnalisisCalificacion> analisisPrecision;
    private List<AnalisisCalificacion> analisisExactitud;
    
    public JTable mediciones(int idRonda, Inicio inicio){
        try{
            DefaultTableModel dm = new DefaultTableModel();
            DataBase op = new DataBase();
            List<Antropometrista> antrop = op.getAllAntropometristasByRonda(idRonda);
            inicio.updateProgressBar(20, "Obteniendo datos");
            List<Object> antrops = new ArrayList<Object>();
            List<RondaAntropometrista > listaRA = op.getAllRondaAntropometristaByRonda(idRonda);
            inicio.updateProgressBar(30, "Calculando Meciciones");
            int sujetos = op.getAllSujetosByRonda(idRonda).size();
            /*datos
             * sujetos: numero de sujetos que midieron los antropometristas en la ronda
             * antrop.size()*2: antropometristas que participaron en la ronda *2 por las mediciones realizadas
             * +1: primer columna de "Sujetos a medir"
             * +3: por las tres columnas de promedios y sumas.
             */
            Object datos[][] = new Object[sujetos][antrop.size()*2+1+3];
            HashMap h = new HashMap();
            //Hashtable h = new Hashtable();
            int ii=-1;
            int jj=0;
            double promedioMed1 = 0;
            double promedioMed2 = 0;
            int val = 30, valSum = 60/sujetos;
            for(RondaAntropometrista ra:listaRA){
                if(h.isEmpty() || !h.containsKey(ra.getIdSujeto())){
                    if(!h.isEmpty() && !h.containsKey(ra.getIdSujeto())){
                        promedioMed1 = promedioMed1/(jj/2);
                        promedioMed2 = promedioMed2/(jj/2);
                        jj++;
                        datos[ii][jj] = Redondear(promedioMed1,2);
                        jj++;
                        datos[ii][jj] = Redondear(promedioMed2,2);
                        jj++;
                        datos[ii][jj] = Redondear(promedioMed1+promedioMed2,2);
                        promedioMed1=0;
                        promedioMed2=0;
                    }
                    ii++;
                    jj=0;
                    datos[ii][jj] = ra.getSujeto().getNombre();
                    h.put(ra.getIdSujeto(), ra.getIdSujeto());
                    val += valSum;
                    inicio.updateProgressBar(val, "Calculando Mediciones");
                }
                jj++;
                datos[ii][jj] = ra.getMedicion1();
                jj++;
                datos[ii][jj] = ra.getMedicion2();
                promedioMed1 += ra.getMedicion1();
                promedioMed2 += ra.getMedicion2();
            }
            promedioMed1 = promedioMed1/(jj/2);
            promedioMed2 = promedioMed2/(jj/2);
            jj++;
            datos[ii][jj] = Redondear(promedioMed1,2);
            jj++;
            datos[ii][jj] = Redondear(promedioMed2,2);
            jj++;
            datos[ii][jj] = Redondear(promedioMed1+promedioMed2,2);
            promedioMed1=0;
            promedioMed2=0;
            inicio.updateProgressBar(90, "Creando Reporte");
            antrops.add("Sujetos a medir");
            for(Antropometrista a:antrop){
                antrops.add("Med 1");
                antrops.add("Med 2");
            }
            antrops.add("Prom. 1a med");
            antrops.add("Prom. 2a med");
            antrops.add("Suma");
            dm.setDataVector(datos, antrops.toArray());
            final CustomCellRenderer renderer = new CustomCellRenderer();
            JTable table = new JTable( dm ) {
              protected JTableHeader createDefaultTableHeader() {
                  return new GroupableTableHeader(columnModel);
              }
              @Override
                public TableCellRenderer getCellRenderer(int row, int column) {
                 // TODO Auto-generated method stub
                 return renderer;
                }
            };
            renderer.setHorizontalAlignment(JLabel.CENTER);
            table.setDefaultRenderer(Object.class, renderer);
            /*CONSTRUIR HEADER DE TABLE CON AGRUPAMIENTO DE COLUMNAS*/  
            TableColumnModel cm = table.getColumnModel();
            ColumnGroup vacio = new ColumnGroup("  ");
            vacio.add(cm.getColumn(0));
            ColumnGroup g_name = new ColumnGroup("Participantes");
            int j=0;
            int i;
            for(i=1;i<antrops.size()-3;i=i+2){
                //g_name.add(cm.getColumn(i));
                ColumnGroup g_otro = new ColumnGroup(antrop.get(j).getNombre());
                g_otro.add(cm.getColumn(i));
                g_otro.add(cm.getColumn(i+1));
                g_name.add(g_otro);
                j++;
            }
            ColumnGroup g_name2 = new ColumnGroup("Promedios");
            i=i-2; //por el aumento en el for anterior
            g_name2.add(cm.getColumn(i+1));
            g_name2.add(cm.getColumn(i+2));
            g_name2.add(cm.getColumn(i+3));

            GroupableTableHeader header = (GroupableTableHeader)table.getTableHeader();
            header.addColumnGroup(vacio);
            header.addColumnGroup(g_name);
            header.addColumnGroup(g_name2);
            //Rectangle r = header.getBounds();
            //header.setBounds(r.x, r.y, 2000, r.height);
            header.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102),1,false));
            return table;
        }
        catch(SQLException se){
            softestandantrop.Error.mostrarMensajeError(inicio, "Error al actualizar las mediciones. \n\n"
                                + "MENSAJE: "+se.getMessage(), "Edicion de Mediciones");
            return null;
        }
    }
    
    public JTable calculosPreExact(Antropometrista antropometrista, int idRonda, Inicio inicio){
        int idAntropometrista = antropometrista.getCodigo();        
        analisisPrecision = new ArrayList<AnalisisCalificacion>();
        analisisExactitud = new ArrayList<AnalisisCalificacion>();
        try{
            DefaultTableModel dm = new DefaultTableModel();
            DataBase op = new DataBase();
            Ronda ronda = op.getRondaById(idRonda);
            List<TipoRonda_Parametro> parametros = op.getAllTipoRondaParamByTipoRonda(ronda.getTipoRonda());
            int nDecimales = 2;
            try{ nDecimales = parametros.get(0).getDecimales(); }catch(Exception ex){}
            List<RondaAntropometrista> rondas = 
                    op.getAllRondaAntropometristaByAntropometristasByRonda(idRonda, idAntropometrista);
            int nSujetos = rondas.size();
            List<String[]> promedios = op.getPromedioMedicionesBySujetoByRonda(idRonda);
            Object datos[][] = new Object[nSujetos][10];
            
            int ii=0;
            int jj=0;
            int n = 1;
            for(RondaAntropometrista ra:rondas){
                datos[ii][jj] = n; jj++;
                datos[ii][jj] = ra.getSujeto().getNombre(); jj++;
                datos[ii][jj] = ra.getMedicion1(); jj++;
                datos[ii][jj] = ra.getMedicion2(); jj++;
                double precision = Redondear(Math.abs(ra.getMedicion1()-ra.getMedicion2()),nDecimales);
                datos[ii][jj] = precision; jj++;
                int evalPrecision = getEvaluacion(precision,parametros);
                datos[ii][jj] =  evalPrecision; jj++;
                double sumaMediciones = Redondear(ra.getMedicion1()+ra.getMedicion2(),nDecimales);
                datos[ii][jj] = sumaMediciones; jj++;
                double promedio = Redondear(
                        Double.parseDouble(promedios.get(n-1)[1]) + Double.parseDouble(promedios.get(n-1)[2]),nDecimales);
                datos[ii][jj] = promedio; jj++; // dato de suma promedio
                double exactitud = Redondear(Math.abs(sumaMediciones-promedio),nDecimales);
                datos[ii][jj] = exactitud; jj++; // exactitud en promedio
                int evalExactitud = getEvaluacion(exactitud,parametros);
                datos[ii][jj] = evalExactitud; jj++; // evaluacion de promedio
                ii++;
                jj=0;
                n++;
                
                /*PREPARANDO REPORTE ANALISIS DE PRECISION Y EXACTITUD*/
                pushAnalisis(analisisPrecision, ra.getSujeto().getNombre(), evalPrecision);
                pushAnalisis(analisisExactitud, ra.getSujeto().getNombre(), evalExactitud);
                
            }
            List<Object> encabezado = new ArrayList();
            encabezado.add("No.");
            encabezado.add("Nombre");
            encabezado.add("1a. Medida");
            encabezado.add("2a. Medida");
            encabezado.add("(1a - 2a)");
            encabezado.add("");
            encabezado.add("1a + 2a");
            encabezado.add("");
            encabezado.add("(4-5)");
            encabezado.add("");
            
            dm.setDataVector(datos, encabezado.toArray());
            final CustomCellRenderer renderer = new CustomCellRenderer();
            JTable table = new JTable( dm ) {
              protected JTableHeader createDefaultTableHeader() {
                  return new GroupableTableHeader(columnModel);
              }
              
              @Override
                public TableCellRenderer getCellRenderer(int row, int column) {
                 // TODO Auto-generated method stub
                 return renderer;
                }
            };

            renderer.setHorizontalAlignment(JLabel.CENTER);
            table.setDefaultRenderer(Object.class, renderer);

            /*CONSTRUIR HEADER DE TABLE CON AGRUPAMIENTO DE COLUMNAS*/  
            TableColumnModel cm = table.getColumnModel();
            /*GRUPO DE COLUMNAS PARA */
            ColumnGroup enc_codigo = new ColumnGroup(""+antropometrista.getCodigo());
            ColumnGroup enc_nombre = new ColumnGroup(antropometrista.getNombre());
            
            ColumnGroup enc_sujetos = new ColumnGroup("Sujetos a Medir");
            ColumnGroup enc_paso1 = new ColumnGroup("PASO 1");
            ColumnGroup enc_paso2 = new ColumnGroup("PASO 2");
            ColumnGroup enc_paso3 = new ColumnGroup("PASO 3");
            ColumnGroup enc_paso4 = new ColumnGroup("PASO 4");
            ColumnGroup enc_paso5 = new ColumnGroup("PASO 5");
            
            ColumnGroup enc_medicion = new ColumnGroup("MEDICIÓN");
            ColumnGroup enc_precision = new ColumnGroup("PRECISIÓN");
            ColumnGroup enc_evaluacion = new ColumnGroup("EVALUACIÓN");
            ColumnGroup enc_sumaMed = new ColumnGroup("SUMA MEDICIONES");
            ColumnGroup enc_sumaProm = new ColumnGroup("SUMA PROMEDIO MEDICIONES");
            ColumnGroup enc_exactitud = new ColumnGroup("EXACTITUD");
            ColumnGroup enc_evaluacion2 = new ColumnGroup("EVALUACIÓN");
                       
            enc_medicion.add(cm.getColumn(2));
            enc_medicion.add(cm.getColumn(3));            
            enc_precision.add(cm.getColumn(4));
            enc_evaluacion.add(cm.getColumn(5));
            enc_sumaMed.add(cm.getColumn(6));
            enc_sumaProm.add(cm.getColumn(7));
            enc_exactitud.add(cm.getColumn(8));
            enc_evaluacion2.add(cm.getColumn(9));
            
            enc_paso1.add(enc_medicion);
            enc_paso2.add(enc_precision);
            enc_paso2.add(enc_evaluacion);
            enc_paso3.add(enc_sumaMed);
            enc_paso4.add(enc_sumaProm);
            enc_paso5.add(enc_exactitud);
            enc_paso5.add(enc_evaluacion2);

            enc_sujetos.add(cm.getColumn(0));
            enc_sujetos.add(cm.getColumn(1));
            enc_codigo.add(enc_sujetos);
            
            enc_nombre.add(enc_paso1);
            enc_nombre.add(enc_paso2);
            enc_nombre.add(enc_paso3);
            enc_nombre.add(enc_paso4);
            enc_nombre.add(enc_paso5);
            
            GroupableTableHeader header = (GroupableTableHeader)table.getTableHeader();
            header.addColumnGroup(enc_sujetos);
            header.addColumnGroup(enc_paso1);
            header.addColumnGroup(enc_paso2);
            header.addColumnGroup(enc_paso3);
            header.addColumnGroup(enc_paso4);
            header.addColumnGroup(enc_paso5);
            header.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102),1,false));
            
            return table;
        }
        catch(SQLException se){
            softestandantrop.Error.mostrarMensajeError(inicio, "Error al actualizar las mediciones. \n\n"
                                + "MENSAJE: "+se.getMessage(), "Mediciones por Antropometrista");
            return null;
        }
    }
    
    public JTable ReporteAnalisis(List<AnalisisCalificacion> lista, String titulo){
        int nSujetos = lista.size();
        int nMediciones = 4; //cantidad de notas
        
        /*DATOS
         * Filas  +2 por filas de totales
         * Columnas +1 por el nombre del sujeto
         */
        Object[][] datos = new Object[nSujetos+2][nMediciones+1];
        int i=0;
        int j=0;
        int total0=0, total1=0, total2=0, total3=0;
        for(AnalisisCalificacion ac:lista){
            datos[i][j] = ac.getSujeto(); j++;
            datos[i][j] = ac.getNota3(); total3+=ac.getNota3(); j++;
            datos[i][j] = ac.getNota2(); total2+=ac.getNota2(); j++;
            datos[i][j] = ac.getNota1(); total1+=ac.getNota1(); j++;
            datos[i][j] = ac.getNota0(); total0+=ac.getNota0(); 
            j=0;
            i++;
        }
        datos[i][j] = "Total"; j++;
        datos[i][j] = total3; 
        datos[i+1][j] = total3*10; j++;
        datos[i][j] = total2; 
        datos[i+1][j] = total2*10; j++;
        datos[i][j] = total1; 
        datos[i+1][j] = total1*10; j++;
        datos[i][j] = total0; 
        datos[i+1][j] = total0*10; 
        
        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(datos, new Object[]{
            "Sujeto","3","2","1","0"
        });
        final CustomCellRenderer renderer = new CustomCellRenderer();
        
        JTable table = new JTable( dm ) {
          protected JTableHeader createDefaultTableHeader() {
              return new GroupableTableHeader(columnModel);
          }
          @Override
            public TableCellRenderer getCellRenderer(int row, int column) {
             // TODO Auto-generated method stub
             return renderer;
            }
          
        };
        
        renderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(Object.class, renderer);

        /*CONSTRUIR HEADER DE TABLE CON AGRUPAMIENTO DE COLUMNAS*/  
        TableColumnModel cm = table.getColumnModel();
        /*GRUPO DE COLUMNAS PARA */
        ColumnGroup encabezado = new ColumnGroup(titulo);
        encabezado.add(cm.getColumn(0));
        encabezado.add(cm.getColumn(1));
        encabezado.add(cm.getColumn(2));
        encabezado.add(cm.getColumn(3));
        encabezado.add(cm.getColumn(4));
        
        GroupableTableHeader header = (GroupableTableHeader)table.getTableHeader();
        header.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102),1,false));
        header.addColumnGroup(encabezado);
            
        return table;
    }
    
    private int getEvaluacion(double precision, List<TipoRonda_Parametro> parametros){
        double param1 = 0;   double param2 = 0.05;   double param3=0.1;
        int puntaje1 = 3;   int puntaje2 = 2;   int puntaje3=1;
        try{
            if(parametros.isEmpty() && parametros.size()==3){
                param1 = parametros.get(0).getMenorigualq();
                puntaje1 = parametros.get(0).getPuntaje();
                param2 = parametros.get(1).getMenorigualq();
                puntaje2 = parametros.get(1).getPuntaje();
                param3 = parametros.get(2).getMenorigualq();
                puntaje3 = parametros.get(2).getPuntaje();
            }
        }
        catch(Exception ex){}
        
        if(precision==param1){
            return puntaje1;
        }
        else if(precision>param1 && precision<=param2){
            return puntaje2;
        }
        else if(precision>param2 && precision<=param3){
            return puntaje3;
        }
        else{
            return 0;
        }
    }
    
    private void pushAnalisis(List<AnalisisCalificacion> lista, String sujeto, int evaluacion){
        AnalisisCalificacion ac = new AnalisisCalificacion(sujeto);
        if(evaluacion==3){ 
            ac.setNota3(1);
        }
        else if(evaluacion==2){
            ac.setNota2(1);
        }
        else if(evaluacion==1){
            ac.setNota1(1);
        }
        else{
            ac.setNota0(1);
        }
        lista.add(ac);
    }
    
    public double Redondear(double numero,int digitos){
        int cifras=(int) Math.pow(10,digitos);
        return Math.rint(numero*cifras)/cifras;
    }

    public List<AnalisisCalificacion> getAnalisisPrecision() {
        return analisisPrecision;
    }

    public List<AnalisisCalificacion> getAnalisisExactitud() {
        return analisisExactitud;
    }
    
    public List<EvaluacionAntropometrista> calcular(int idRonda, Inicio inicio){
        List<EvaluacionAntropometrista> evalAntropometristas = new ArrayList<EvaluacionAntropometrista>();
        EvaluacionAntropometrista ea;
        try{
            DataBase op = new DataBase();
            Ronda ronda = op.getRondaById(idRonda);
            List<Antropometrista> antropometristas = op.getAllAntropometristasByRonda(idRonda);
            List<TipoRonda_Parametro> parametros = op.getAllTipoRondaParamByTipoRonda(ronda.getTipoRonda());
            int nDecimales = 2;
            try{ nDecimales = parametros.get(0).getDecimales(); }catch(Exception ex){}
            inicio.updateProgressBar(10, "Calculando Datos de Antropometrista");
            int val = 10, valSum=40/antropometristas.size();
            for(Antropometrista a:antropometristas){
                val+=valSum;
                if(val<50) inicio.updateProgressBar(val, "Calculando Datos de Antropometrista");
                ea = new EvaluacionAntropometrista();
                ea.setAntropometrista(a);
                List<RondaAntropometrista> rondas = 
                    op.getAllRondaAntropometristaByAntropometristasByRonda(idRonda, a.getCodigo());
                int nSujetos = rondas.size();
                List<String[]> promedios = op.getPromedioMedicionesBySujetoByRonda(idRonda);
                Object datos[][] = new Object[nSujetos][10];
                int ii=0;
                int jj=0;
                int n = 1;
                for(RondaAntropometrista ra:rondas){
                    datos[ii][jj] = n; jj++;
                    datos[ii][jj] = ra.getSujeto().getNombre(); jj++;
                    datos[ii][jj] = ra.getMedicion1(); jj++;
                    datos[ii][jj] = ra.getMedicion2(); jj++;
                    double precision = Redondear(Math.abs(ra.getMedicion1()-ra.getMedicion2()),nDecimales);
                    datos[ii][jj] = precision; jj++;
                    int evalPrecision = getEvaluacion(precision,parametros);
                    datos[ii][jj] =  evalPrecision; jj++;
                    double sumaMediciones = Redondear(ra.getMedicion1()+ra.getMedicion2(),nDecimales);
                    datos[ii][jj] = sumaMediciones; jj++;
                    double promedio = Redondear(
                            Double.parseDouble(promedios.get(n-1)[1]) + 
                            Double.parseDouble(promedios.get(n-1)[2]),nDecimales);
                    datos[ii][jj] = promedio; jj++; // dato de suma promedio
                    double exactitud = Redondear(Math.abs(sumaMediciones-promedio),nDecimales);
                    datos[ii][jj] = exactitud; jj++; // exactitud en promedio
                    int evalExactitud = getEvaluacion(exactitud,parametros);
                    datos[ii][jj] = evalExactitud; jj++; // evaluacion de promedio
                    ii++;
                    jj=0;
                    n++;

                    /*PREPARANDO REPORTE ANALISIS DE PRECISION Y EXACTITUD*/
                    pushAnalisis(ea.getPrecision(), ra.getSujeto().getNombre(), evalPrecision);
                    pushAnalisis(ea.getExactitud(), ra.getSujeto().getNombre(), evalExactitud);
                }
                ea.setDatosPrecalculos(datos);
                evalAntropometristas.add(ea);
            }
        }
        catch(SQLException se){
            se.printStackTrace();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return evalAntropometristas;
    }
    
    public JTable calculosPreExact(EvaluacionAntropometrista evaluacion){
        DefaultTableModel dm = new DefaultTableModel();
        List<Object> encabezado = new ArrayList();
        encabezado.add("No.");
        encabezado.add("Nombre");
        encabezado.add("1a. Medida");
        encabezado.add("2a. Medida");
        encabezado.add("(1a - 2a)");
        encabezado.add("");
        encabezado.add("1a + 2a");
        encabezado.add("");
        encabezado.add("(4-5)");
        encabezado.add("");
        /*DATOS DE LA TABLA*/
        dm.setDataVector(evaluacion.getDatosPrecalculos(), encabezado.toArray());
        final CustomCellRenderer renderer = new CustomCellRenderer();
        JTable table = new JTable( dm ) {
          protected JTableHeader createDefaultTableHeader() {
              return new GroupableTableHeader(columnModel);
          }
          
          @Override
            public TableCellRenderer getCellRenderer(int row, int column) {
             // TODO Auto-generated method stub
             return renderer;
            }
          
        };

        renderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, renderer);

        /*CONSTRUIR HEADER DE TABLE CON AGRUPAMIENTO DE COLUMNAS*/  
        TableColumnModel cm = table.getColumnModel();
        /*GRUPO DE COLUMNAS PARA */
        ColumnGroup enc_codigo = new ColumnGroup(""+evaluacion.getAntropometrista().getCodigo());
        ColumnGroup enc_nombre = new ColumnGroup(evaluacion.getAntropometrista().getNombre());

        ColumnGroup enc_sujetos = new ColumnGroup("Sujetos a Medir");
        ColumnGroup enc_paso1 = new ColumnGroup("PASO 1");
        ColumnGroup enc_paso2 = new ColumnGroup("PASO 2");
        ColumnGroup enc_paso3 = new ColumnGroup("PASO 3");
        ColumnGroup enc_paso4 = new ColumnGroup("PASO 4");
        ColumnGroup enc_paso5 = new ColumnGroup("PASO 5");

        ColumnGroup enc_medicion = new ColumnGroup("MEDICIÓN");
        ColumnGroup enc_precision = new ColumnGroup("PRECISIÓN");
        ColumnGroup enc_evaluacion = new ColumnGroup("EVALUACIÓN");
        ColumnGroup enc_sumaMed = new ColumnGroup("SUMA MEDICIONES");
        ColumnGroup enc_sumaProm = new ColumnGroup("SUMA PROMEDIO MEDICIONES");
        ColumnGroup enc_exactitud = new ColumnGroup("EXACTITUD");
        ColumnGroup enc_evaluacion2 = new ColumnGroup("EVALUACIÓN");

        enc_medicion.add(cm.getColumn(2));
        enc_medicion.add(cm.getColumn(3));            
        enc_precision.add(cm.getColumn(4));
        enc_evaluacion.add(cm.getColumn(5));
        enc_sumaMed.add(cm.getColumn(6));
        enc_sumaProm.add(cm.getColumn(7));
        enc_exactitud.add(cm.getColumn(8));
        enc_evaluacion2.add(cm.getColumn(9));

        enc_paso1.add(enc_medicion);
        enc_paso2.add(enc_precision);
        enc_paso2.add(enc_evaluacion);
        enc_paso3.add(enc_sumaMed);
        enc_paso4.add(enc_sumaProm);
        enc_paso5.add(enc_exactitud);
        enc_paso5.add(enc_evaluacion2);

        enc_sujetos.add(cm.getColumn(0));
        enc_sujetos.add(cm.getColumn(1));
        enc_codigo.add(enc_sujetos);

        enc_nombre.add(enc_paso1);
        enc_nombre.add(enc_paso2);
        enc_nombre.add(enc_paso3);
        enc_nombre.add(enc_paso4);
        enc_nombre.add(enc_paso5);

        GroupableTableHeader header = (GroupableTableHeader)table.getTableHeader();
        header.addColumnGroup(enc_sujetos);
        header.addColumnGroup(enc_paso1);
        header.addColumnGroup(enc_paso2);
        header.addColumnGroup(enc_paso3);
        header.addColumnGroup(enc_paso4);
        header.addColumnGroup(enc_paso5);
        header.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102),1,false));
        
        return table;
    }
    
    public JTable ReporteEvaluaciones(List<EvaluacionAntropometrista> evaluaciones, Inicio inicio){
        try{
            int nAntropometristas = evaluaciones.size();
            Object[][] datos = new Object[nAntropometristas][12]; //12 columnas
            int i=0;
            int j=0;
            for(EvaluacionAntropometrista ea:evaluaciones){
                ea.setTotales();
                datos[i][j] = i+1; j++;
                datos[i][j] = ea.getAntropometrista().getNombre(); j++;
                datos[i][j] = ea.getTotalPrecision3(); j++;
                datos[i][j] = ea.getTotalPrecision2(); j++;
                datos[i][j] = ea.getTotalPrecision1(); j++;
                datos[i][j] = ea.getTotalPrecision0(); j++;
                datos[i][j] = ea.getResultadoPrecision(); j++;
                datos[i][j] = ea.getTotalExactitud3(); j++;
                datos[i][j] = ea.getTotalExactitud2(); j++;
                datos[i][j] = ea.getTotalExactitud1(); j++;
                datos[i][j] = ea.getTotalExactitud0(); j++;
                datos[i][j] = ea.getResultadoExactitud();
                j=0;
                i++;
            }
            
            DefaultTableModel dm = new DefaultTableModel();
            List<Object> encabezado = new ArrayList();
            encabezado.add("No.");
            encabezado.add("Antropometrista");
            encabezado.add("3");
            encabezado.add("2");
            encabezado.add("1");
            encabezado.add("0");
            encabezado.add("Resultado");
            encabezado.add("3");
            encabezado.add("2");
            encabezado.add("1");
            encabezado.add("0");
            encabezado.add("Resultado");
            /*DATOS DE LA TABLA*/
            dm.setDataVector(datos, encabezado.toArray());
            final CustomCellRenderer renderer = new CustomCellRenderer();
            JTable table = new JTable( dm ) {
              protected JTableHeader createDefaultTableHeader() {
                  return new GroupableTableHeader(columnModel);
              }
              @Override
            public TableCellRenderer getCellRenderer(int row, int column) {
             // TODO Auto-generated method stub
             return renderer;
            }
              
            };

            renderer.setHorizontalAlignment(JLabel.CENTER);
            table.setDefaultRenderer(Object.class, renderer);

            /*CONSTRUIR HEADER DE TABLE CON AGRUPAMIENTO DE COLUMNAS*/  
            TableColumnModel cm = table.getColumnModel();
            /*GRUPO DE COLUMNAS PARA */
            ColumnGroup enc_precision= new ColumnGroup("Análisis de Calificaciones Precisión");
            ColumnGroup enc_exactitud = new ColumnGroup("Análisis de Calificaciones Exactitud");
            
            enc_precision.add(cm.getColumn(2));
            enc_precision.add(cm.getColumn(3));
            enc_precision.add(cm.getColumn(4));
            enc_precision.add(cm.getColumn(5));
            enc_precision.add(cm.getColumn(6));
            
            enc_exactitud.add(cm.getColumn(7));
            enc_exactitud.add(cm.getColumn(8));
            enc_exactitud.add(cm.getColumn(9));
            enc_exactitud.add(cm.getColumn(10));
            enc_exactitud.add(cm.getColumn(11));
            
            GroupableTableHeader header = (GroupableTableHeader)table.getTableHeader();
            header.addColumnGroup(enc_precision);
            header.addColumnGroup(enc_exactitud);
            header.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102),1,false));
            return table;

        }
        catch(Exception se){
            softestandantrop.Error.mostrarMensajeError(inicio, "Error al actualizar las evaluaciones. \n\n"
                                + "MENSAJE: "+se.getMessage(), "Evaluaciones de Antropometristas");
            
            return null;
        }
    }
    
    
    
}
