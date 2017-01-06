/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.dao;

import dayara.model.Usuarios;
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
public class UsuariosDao {
    
    public void guardar(Usuarios usuario){

        String sql = "INSERT INTO public.usuarios("
                + "usuario, clave) "
                + "VALUES ('"+usuario.getUsuario()+"', '"+usuario.getClave()+"');";
        
        Conexion.conectar();

        try {

            Conexion.st.execute(sql);
            System.out.println("Ejecutando: "+sql);

        } catch (SQLException ex) {

            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+ ex);

        }
        Conexion.desconectar();
    }

    public boolean modificar(Usuarios usuario) {
        
        String sql = "UPDATE public.usuarios "
                + "SET clave='"+usuario.getClave()+"' "
                + "WHERE id="+usuario.getId()+";";
        
        boolean resultado = false;
        
        Conexion.conectar();

        try {
        
            resultado = Conexion.st.execute(sql);
            System.out.println("Ejecutando: "+sql);
            
        } catch (SQLException ex) {
            
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+sql+ ex);
            
        }

        Conexion.desconectar();
        
        return resultado;

    }

    public Usuarios recuperarPorCodigo(int codigo) {
        
        String sql = "SELECT usuario "
                + "FROM public.usuarios "
                + "WHERE id="+codigo+";";
        
        Conexion.conectar();
        
        Usuarios usuario = null;
        
        ResultSet rs;
        
        try {
            
            rs = Conexion.st.executeQuery(sql);
            System.out.println("Ejecutando: "+sql);
            
            if (rs.next()) {
                usuario = new Usuarios();
                usuario.setUsuario(rs.getString("usuario"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar SQL: "+ex);

        }
 
        Conexion.desconectar();
        
        return usuario;
    }

    public List<Usuarios> recuperarPorFiltro(String filtro) {

        String sql = "SELECT id, usuario "
                + "FROM public.usuarios "
                + "WHERE (usuario LIKE '%"+filtro+"%') "
                + "ORDER BY usuario;";
        
        List<Usuarios> lista = new ArrayList<>();
        
        System.out.println("SQL = " + sql);
        
        Conexion.conectar();
        
        Usuarios usuario = null;
        
        ResultSet rs;
        
        try {

            rs = Conexion.st.executeQuery(sql);
            
            System.out.println("Ejecutando: "+sql);

            
            while (rs.next()) {                
             usuario = new Usuarios();
             usuario.setId(rs.getInt("id"));
             usuario.setUsuario(rs.getString("usuario"));
                lista.add(usuario);
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+ex);
            
        }

        Conexion.desconectar();
        
        return lista;

    }
    
    public List<Usuarios> llenarTabla(){
        
        //String sql = "SELECT * FROM usuarios WHERE estado = true order by usuario;";
        String sql = "SELECT * FROM usuarios order by usuario;";
        
        List<Usuarios> llenar = new ArrayList<>();
        
        Conexion.conectar();
        
        Usuarios usuario;
        
        try {
            ResultSet rs = Conexion.st.executeQuery(sql);
            
            System.out.println("Ejecutando llenarTabla" + sql);
            
            while (rs.next()) {                
             usuario = new Usuarios();
             usuario.setId(rs.getInt("id"));
             usuario.setUsuario(rs.getString("usuario"));
             llenar.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Conexion.desconectar();
        return llenar;
    }
    
    public String validarPassword(int codigo){
        
        String resultado = "";
        
        String sql = "SELECT clave FROM usuarios WHERE id = "+codigo+";";
        
        Conexion.conectar();
        
        ResultSet rs;
        
        try {
            
            rs = Conexion.st.executeQuery(sql);
            System.out.println("Ejecutando: "+sql);
            
            if (rs.next()) {
                resultado = rs.getString("clave");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar SQL: "+ex);

        }
 
        Conexion.desconectar();
        
        return resultado;
    }
       
}
