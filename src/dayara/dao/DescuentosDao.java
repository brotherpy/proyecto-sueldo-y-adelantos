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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge Fabio
 */
public class DescuentosDao {
    
    public void guardar(Descuentos adelanto){

        String sql = "INSERT INTO public.descuentos(concepto) VALUES ('"+adelanto.getConcepto()+"');";
        
        Conexion.conectar();

        try {

            Conexion.st.execute(sql);
            System.out.println("Ejecutando: " + sql);

        } catch (SQLException ex) {

            Logger.getLogger(DescuentosDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+ ex + ", " + sql);

        }

        Conexion.desconectar();

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
            System.out.println("Error al ejecutar "+ ex + ", " + sql);

        }
 
        Conexion.desconectar();
        
        return desc;
    }

    public List<Descuentos> recuperarTodo() {

        String sql = "SELECT * FROM public.descuentos ORDER BY concepto;";
        
        List<Descuentos> lista = new ArrayList<>();
        
        Conexion.conectar();
        
        Descuentos empl;
        
        ResultSet rs;
        
        try {

            rs = Conexion.st.executeQuery(sql);
            
            System.out.println("Ejecutando: "+sql);

            
            while (rs.next()) {
                empl = new Descuentos();
                
                empl.setId(rs.getInt("id"));
                empl.setConcepto(rs.getString("concepto"));

                lista.add(empl);
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(DescuentosDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+ ex + ", " + sql);
            
        }

        Conexion.desconectar();
        
        return lista;

    }

    public Vector<Descuentos> cargarComboBox() {
        
        String sql = "SELECT id, concepto FROM public.descuentos;";
        
        Vector<Descuentos> ciudadList = new Vector<>();
        Descuentos ciu;
        Conexion.conectar();
        try {
            ResultSet rs = Conexion.st.executeQuery(sql);
            System.out.println("SQL "+sql);
            
            while(rs.next()){
                ciu = new Descuentos();
                ciu.setId(rs.getInt("id"));
                ciu.setConcepto(rs.getString("concepto"));
                ciudadList.add(ciu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DescuentosDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+ ex + ", " + sql);
        }
        Conexion.desconectar();
        return ciudadList;
    }
}
