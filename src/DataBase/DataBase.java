/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Modelos.Antropometrista;
import Modelos.Estandarizacion;
import Modelos.Ronda;
import Modelos.RondaAntropometrista;
import Modelos.Sujeto;
import Modelos.TipoRonda_Parametro;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import softestandantrop.Midirectorio;

/**
 *
 * @author DAVID
 */
public class DataBase {
    
    private JdbcConnectionSource connectionSource=null;
    private Dao<Antropometrista, Integer> antropometristaDao;
    private Dao<Estandarizacion, Integer> estandarizacionDao;
    private Dao<Ronda, Integer> rondaDao;
    private Dao<RondaAntropometrista, Integer> rondaAntroDao;
    private Dao<Sujeto, Integer> sujetoDao;
    private Dao<TipoRonda_Parametro, Integer> tipoRondaParamDao;
    private String direccion = null;
    
    public DataBase () {
        direccion = Midirectorio.dar() + "\\lib\\db.db";
        System.out.println(direccion);
        try{System.in.read();}catch(Exception ex){}
    }
    
    public String devolverDireccion() {
        return direccion;
    }
        
 
    private void iniciarConexion() throws SQLException {
        if (direccion == null) {
            throw new SQLException("Archivo no encontrado");
        } else {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:" + direccion);
            antropometristaDao = DaoManager.createDao(connectionSource, Antropometrista.class);
            estandarizacionDao = DaoManager.createDao(connectionSource, Estandarizacion.class);
            rondaDao = DaoManager.createDao(connectionSource, Ronda.class);
            rondaAntroDao = DaoManager.createDao(connectionSource, RondaAntropometrista.class);
            sujetoDao = DaoManager.createDao(connectionSource, Sujeto.class);
            tipoRondaParamDao = DaoManager.createDao(connectionSource, TipoRonda_Parametro.class);
        }
    }
    
    private void terminarConexion() throws SQLException {
        if (connectionSource != null) {
            connectionSource.close();
        }
    }
    
    
    public void borrarBase() throws SQLException {
        iniciarConexion();
        /*TableUtils.clearTable(connectionSource, Muestra.class);
        TableUtils.clearTable(connectionSource, Boleta.class);
        TableUtils.clearTable(connectionSource, Infante.class);*/
        terminarConexion();
    }

    /*
     * FUNCIONES DE ANTROPOMETRISTAS
     */
    
    
    public int insertarAntropometrista(Antropometrista antropometrista) throws SQLException {
        int id;
        iniciarConexion();
        id=antropometristaDao.create(antropometrista);
        terminarConexion();
        return id;
    }
    
    public Antropometrista getAntropometristaById(int codigo) throws SQLException {
        Antropometrista antropometrista;
        iniciarConexion();
        antropometrista = antropometristaDao.queryForId(codigo);
        terminarConexion();
        return antropometrista;
    }
    
    public List<Antropometrista> getAllAntropometristas() throws SQLException{
        List<Antropometrista> antropometristas;
        iniciarConexion();
        QueryBuilder<Antropometrista, Integer> antropConsulta = antropometristaDao.queryBuilder();
        antropConsulta.orderBy("codigo", true);
        antropometristas = antropometristaDao.query(antropConsulta.prepare());
        terminarConexion();
        return antropometristas;
    }
    
    public List<Antropometrista> getAllNoSupervisores() throws SQLException{
        List<Antropometrista> antropometristas;
        iniciarConexion();
        QueryBuilder<Antropometrista, Integer> antropConsulta = antropometristaDao.queryBuilder();
        antropConsulta.where().eq(Antropometrista.CAMPO_SUPERVISOR,0);
        antropConsulta.orderBy("codigo", true);
        antropometristas = antropometristaDao.query(antropConsulta.prepare());
        terminarConexion();
        return antropometristas;
    }
    
    public List<Antropometrista> getAllSupervisores() throws SQLException{
        List<Antropometrista> antropometristas;
        iniciarConexion();
        QueryBuilder<Antropometrista, Integer> antropConsulta = antropometristaDao.queryBuilder();
        antropConsulta.where().eq(Antropometrista.CAMPO_SUPERVISOR,1);
        antropConsulta.orderBy("codigo", true);
        antropometristas = antropometristaDao.query(antropConsulta.prepare());
        terminarConexion();
        return antropometristas;
    }
    
    /*FUNCIONES DE SUJETOS*/
    
    public int insertarSujeto(Sujeto sujeto) throws SQLException{
        int id;
        iniciarConexion();
        id=sujetoDao.create(sujeto);
        terminarConexion();
        return id; 
    }
    
    public Sujeto getSujetoById(int id) throws SQLException{
        Sujeto sujeto;
        iniciarConexion();
        sujeto = sujetoDao.queryForId(id);
        terminarConexion();
        return sujeto;
    }
    
    public List<Sujeto> getAllSujetos() throws SQLException{
        List<Sujeto> sujetos;
        iniciarConexion();
        QueryBuilder<Sujeto, Integer> sujetoConsulta = sujetoDao.queryBuilder();
        sujetoConsulta.orderBy("id", true);
        sujetos = sujetoDao.query(sujetoConsulta.prepare());
        terminarConexion();
        return sujetos;
    }
    
    /* OPERACIONES DE RONDAS */
    
    
    public int insertarRonda(Ronda ronda) throws SQLException{
        int id;
        iniciarConexion();
        id=rondaDao.create(ronda);
        terminarConexion();
        return id; 
    }
    
    public Ronda getRondaById(int id) throws SQLException{
        Ronda ronda;
        iniciarConexion();
        ronda = rondaDao.queryForId(id);
        terminarConexion();
        return ronda;
    }
    
    public List<Ronda> getAllRondas() throws SQLException{
        List<Ronda> rondas;
        iniciarConexion();
        QueryBuilder<Ronda, Integer> rondaConsulta = rondaDao.queryBuilder();
        rondaConsulta.orderBy("id", true);
        rondas = rondaDao.query(rondaConsulta.prepare());
        terminarConexion();
        return rondas;
    }
    
    public List<Ronda> getAllRondasByEnstandarizacion(int idEstandarizacion) throws SQLException{
        List<Ronda> rondas;
        iniciarConexion();
        QueryBuilder<Ronda, Integer> rondaConsulta = rondaDao.queryBuilder();
        rondaConsulta.where().eq("estandarizacion", idEstandarizacion);
        rondaConsulta.orderBy("id", true);
        rondas = rondaDao.query(rondaConsulta.prepare());
        terminarConexion();
        return rondas;
    }
    
    /*FUNCIONES DE ESTANDARIZACIONES*/
    
    public int insertarEstandarizacion(Estandarizacion e) throws SQLException{
        int id;
        iniciarConexion();
        id=estandarizacionDao.create(e);
        terminarConexion();
        return id; 
    }
    
    public Estandarizacion getEstandarizacionById(int idEstandarizacion) throws SQLException{
        Estandarizacion estandarizacion;
        iniciarConexion();
        estandarizacion = estandarizacionDao.queryForId(idEstandarizacion);
        terminarConexion();
        return estandarizacion;
    }
    
    public List<Estandarizacion> getAllEstandarizacion() throws SQLException{
        List<Estandarizacion> estandarizaciones;
        iniciarConexion();
        QueryBuilder<Estandarizacion, Integer> estandarizacionConsulta = estandarizacionDao.queryBuilder();
        estandarizacionConsulta.orderBy("id", true);
        estandarizaciones = estandarizacionDao.query(estandarizacionConsulta.prepare());
        terminarConexion();
        return estandarizaciones;
    }
    
    public List<Antropometrista> getAllAntropometristasByRonda(int idRonda) throws SQLException{
        List<RondaAntropometrista> rondasAntropometrista;
        List<Antropometrista> antropometristas = new ArrayList<Antropometrista>();
        iniciarConexion();
        QueryBuilder<RondaAntropometrista, Integer> rondaAntropConsulta = rondaAntroDao.queryBuilder();
        rondaAntropConsulta.where().eq("ronda", idRonda);
        rondaAntropConsulta.orderBy("antropometrista", true);
        rondaAntropConsulta.groupBy("antropometrista");
        rondasAntropometrista = rondaAntroDao.query(rondaAntropConsulta.prepare());
        for(RondaAntropometrista ra:rondasAntropometrista){
            antropometristas.add(getAntropometristaById(ra.getIdAntropometrista()));
        }
        terminarConexion();
        return antropometristas;
    }
    
    public List<RondaAntropometrista> getAllRondaAntropometristaByAntropometristasByRonda(int idRonda, int idAntropometrista) throws SQLException{
        List<RondaAntropometrista> rondasAntropometrista;
        iniciarConexion();
        QueryBuilder<RondaAntropometrista, Integer> rondaAntropConsulta = rondaAntroDao.queryBuilder();
        rondaAntropConsulta.where().eq("ronda", idRonda).and().eq("antropometrista", idAntropometrista);
        rondaAntropConsulta.orderBy("id", true);
        rondasAntropometrista = rondaAntroDao.query(rondaAntropConsulta.prepare());
        for(RondaAntropometrista ra:rondasAntropometrista){
            ra.setSujeto(getSujetoById(ra.getIdSujeto()));
        }
        terminarConexion();
        return rondasAntropometrista;
    }
    
    /* FUNCIONES PARA RONDA-ANTROPOMETRISTA */
    
    public int insertarRondaAntropometrista(RondaAntropometrista ra) throws SQLException{        
        int id;
        iniciarConexion();
        id=rondaAntroDao.create(ra);
        terminarConexion();
        return id;
    }
    
    public Antropometrista getSuperviorByRonda(int idRonda) throws SQLException{
        List<Antropometrista> antropometristas = getAllAntropometristasByRonda(idRonda);
        for(Antropometrista a:antropometristas){
            if(a.getSupervisor()==1){
                return a;
            }
        }
        if(!antropometristas.isEmpty()){
            return antropometristas.get(0);
        }
        return null;
    }
    
    public List<Sujeto> getAllSujetosByRonda(int idRonda) throws SQLException{
        List<RondaAntropometrista> rondasAntropometrista;
        List<Sujeto> sujetos = new ArrayList<Sujeto>();
        iniciarConexion();
        QueryBuilder<RondaAntropometrista, Integer> rondaAntropConsulta = rondaAntroDao.queryBuilder();
        rondaAntropConsulta.where().eq("ronda", idRonda);
        rondaAntropConsulta.orderBy("id", true);
        rondaAntropConsulta.groupBy("sujeto");
        rondasAntropometrista = rondaAntroDao.query(rondaAntropConsulta.prepare());
        for(RondaAntropometrista ra:rondasAntropometrista){
            sujetos.add(getSujetoById(ra.getIdSujeto()));
        }
        terminarConexion();
        return sujetos;
    }
    
    public List<Sujeto> getAllSujetosByAntropometristasByRonda(int idRonda, int idAntropometrista) throws SQLException{
        List<RondaAntropometrista> rondasAntropometrista;
        List<Sujeto> sujetos = new ArrayList<Sujeto>();
        iniciarConexion();
        QueryBuilder<RondaAntropometrista, Integer> rondaAntropConsulta = rondaAntroDao.queryBuilder();
        rondaAntropConsulta.where().eq("ronda", idRonda).and().eq("antropometrista", idAntropometrista);
        rondaAntropConsulta.orderBy("id", true);
        rondasAntropometrista = rondaAntroDao.query(rondaAntropConsulta.prepare());
        for(RondaAntropometrista ra:rondasAntropometrista){
            sujetos.add(getSujetoById(ra.getIdSujeto()));
        }
        terminarConexion();
        return sujetos;
    }
     
     public List<RondaAntropometrista> getAllRondaAntropometristaByRonda(int idRonda) throws SQLException{
        List<RondaAntropometrista> rondasAntropometrista;
        iniciarConexion();
        QueryBuilder<RondaAntropometrista, Integer> rondaAntropConsulta = rondaAntroDao.queryBuilder();
        rondaAntropConsulta.where().eq("ronda", idRonda);
        rondaAntropConsulta.orderBy("sujeto", true);
        rondaAntropConsulta.orderBy("antropometrista", true);
        rondasAntropometrista = rondaAntroDao.query(rondaAntropConsulta.prepare());
        for(RondaAntropometrista ra:rondasAntropometrista){
            ra.setSujeto(getSujetoById(ra.getIdSujeto()));
            ra.setAntropometrista(getAntropometristaById(ra.getIdAntropometrista()));
        }
        terminarConexion();
        return rondasAntropometrista;
    }
    
    public int updateRondaAntropometrista(RondaAntropometrista ra) throws SQLException{
        int id;
        iniciarConexion();
        id=rondaAntroDao.update(ra);
        terminarConexion();
        return id;
    }
    
    public List<TipoRonda_Parametro> getAllTipoRondaParamByTipoRonda(int tipoRonda) throws SQLException{
        List<TipoRonda_Parametro> parametros;
        iniciarConexion();
        QueryBuilder<TipoRonda_Parametro, Integer> parametrosConsulta = tipoRondaParamDao.queryBuilder();
        parametrosConsulta.where().eq("tipoRonda", tipoRonda);
        parametrosConsulta.orderBy("id", true);
        parametros = tipoRondaParamDao.query(parametrosConsulta.prepare());
        terminarConexion();
        return parametros;
    }
    
    /* FUNCIONES DE TIPORONDA_PARAMETROS*/
    
    public int insertarRondaAntropometrista(TipoRonda_Parametro trp) throws SQLException{        
        int id;
        iniciarConexion();
        id=tipoRondaParamDao.create(trp);
        terminarConexion();
        return id;
    }
    
    /* FUNCIONES EXTRAS */
    /*
     * Devuelve el ultimo ID + 1 de la tabla enviada como parametro. Debe de tener como llave primaria un campo
     * llamad ID.
     */
   /* public int getLastId(String nombreTabla){
        int last = 0;
        ResultSet r = consultar("SELECT max(id)+1 FROM "+nombreTabla);
        try{
            if(r.next()){
                last = r.getInt(1);
            }
        }
        catch(SQLException se){
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LA CUENTA DE "+nombreTabla+". \n\n"+se.getMessage());
        }
        return last;    
    }*/
    
    /*FUNCIOES DE TIPO DE RONDA POR ESTANDARIZACION*/
    
    /*public boolean insertarTipoRondaEstandarizacion(TipoRondaEstandarizacion tre){
        return insertar("INSERT INTO "
                + "tiporondaestandarizacion(tiporonda,estandarizacion, dimension,tipoSujeto,maximo,minimo)"
                + " VALUES("+tre.getIdTipoRonda()+","+tre.getIdEstandarizacion()+"'"+tre.getDimension()+"',"
                +tre.getIdTipoSujeto()+ ", "+tre.getMaximo()+","+tre.getMinimo()
        );
    }*/
    
    /*public List<TipoRondaEstandarizacion> getAllTipoRondaEstandarizacionByEstandarizacion(int idEstandarizacion){
        ResultSet r = consultar("SELECT * FROM TipoRondaEstandarizacion TRE, TipoRonda TR"
                + " WHERE TRE.tiporonda = TR.id"
                + "     AND TRE.estandarizacion="+idEstandarizacion);
        List<TipoRondaEstandarizacion> lista = new ArrayList<TipoRondaEstandarizacion>();
        try{
            while(r.next()){
                TipoRondaEstandarizacion tre = new TipoRondaEstandarizacion(
                        r.getInt(1), r.getInt(2), r.getString(3), r.getInt(4),r.getFloat(5),r.getFloat(6));
                //RondaAntropometrista ra = new RondaAntropometrista(r.getInt(1), r.getInt(2), r.getInt(3), r.getInt(4));
                tre.setTipoRonda(new TipoRonda(r.getInt(7), r.getString(8)));
                lista.add(tre);
            }
        }
        catch(SQLException se){
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER TIPOS DE RONDAS POR ESTANDARIZACION. \n\n"+se.getMessage());
        }
        catch(Exception ex){
            
        }
        return lista;
    }*/
    
    public List<String[]> getPromedioMedicionesBySujetoByRonda(int idRonda) throws SQLException{
        List<RondaAntropometrista> rondasAntropometrista;
        iniciarConexion();
        GenericRawResults<String[]> rawResults = 
                rondaAntroDao.queryRaw("SELECT sujeto, AVG(med1) med1, avg(med2) med2 "
                + " FROM rondaantropometrista "
                + " WHERE ronda= "+idRonda
                + " GROUP BY sujeto");
        List<String[]> results = rawResults.getResults();
        terminarConexion();
        return results;
    }
    
}
