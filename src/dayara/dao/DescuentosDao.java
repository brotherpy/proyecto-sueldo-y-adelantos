/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.dao;

import dayara.model.Descuentos;
import dayara.util.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge Fabio
 */
public class DescuentosDao {
    
    public void guardar(Descuentos desc){

        String sql = "INSERT INTO public.descuentos(concepto) VALUES ('"+desc.getConcepto()+"');";
        
        Conexion.conectar();

        try {

            Conexion.st.execute(sql);
            System.out.println("Ejecutando: "+sql);

        } catch (SQLException ex) {

            Logger.getLogger(DescuentosDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+ ex);

        }

        Conexion.desconectar();

    }

    public boolean modificar(Descuentos desc) {
        
        String sql = "UPDATE public.descuentos SET concepto='"+desc.getConcepto()+"' WHERE id="+desc.getId()+";";
        
        boolean resultado = false;
        
        Conexion.conectar();

        try {
        
            resultado = Conexion.st.execute(sql);
            System.out.println("Ejecutando: "+sql);
            
        } catch (SQLException ex) {
            
            Logger.getLogger(DescuentosDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+sql+ ex);
            
        }

        Conexion.desconectar();
        
        return resultado;

    }

    public Descuentos recuperarPorCodigo(int codigo) {
        
        String sql = "SELECT concepto FROM public.descuentos "
                + "WHERE id="+codigo+";";
        
        Conexion.conectar();
        
        Descuentos desc = null;
        
        ResultSet rs;
        
        try {
            
            rs = Conexion.st.executeQuery(sql);
            System.out.println("Ejecutando: "+sql);
            
            if (rs.next()) {
                desc = new Descuentos();
                desc.setConcepto(rs.getString("concepto"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DescuentosDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar SQL: "+ex);

        }
 
        Conexion.desconectar();
        
        return desc;
    }

    public List<Descuentos> recuperarPorFiltro(String filtro) {

        String sql = "SELECT id, concepto FROM public.descuentos "
                + "WHERE (nombre LIKE '%"+filtro+"%') "
                + "ORDER BY nombres;";
        
        List<Descuentos> lista = new ArrayList<>();
        
        System.out.println("SQL = " + sql);
        
        Conexion.conectar();
        
        Descuentos empl = null;
        
        ResultSet rs;
        
        try {

            rs = Conexion.st.executeQuery(sql);
            
            System.out.println("Ejecutando: "+sql);

            
            while (rs.next()) {
                
                empl = new Descuentos();
                
                empl.setId(rs.getInt("codigo"));

                lista.add(empl);
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(DescuentosDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+ex);
            
        }

        Conexion.desconectar();
        
        return lista;

    }

    public void eliminar(int codigo) {

        String sql = "";
        
        System.out.println("SQL = "+sql);
        
        Conexion.conectar();

        try {

            Conexion.st.execute(sql);
            System.out.println("Ejecutando: "+sql);

        } catch (SQLException ex) {

            Logger.getLogger(DescuentosDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+ ex);

        }

        Conexion.desconectar();

    }
}
