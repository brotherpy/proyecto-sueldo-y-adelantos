/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.dao;

import dayara.model.Empleado;
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
public class EmpleadoDao {
    
    public void guardar(Empleado emp){

        String sql = "INSERT INTO public.empleado("
                + "nombre, apellido, cedula, telefono, fecalta, fecbaja, salario, observacion, estado) "
                + "VALUES ('"+emp.getNombre()+"', '"+emp.getApellido()+"', "+emp.getCedula()+", "
                + "'"+emp.getTelefono()+"', '"+emp.getFecAlta()+"', '"+emp.getFecBaja()+"', "
                + ""+emp.getSalario()+", '"+emp.getObservacion()+"', "+emp.isEstado()+");";
        
        Conexion.conectar();

        try {

            Conexion.st.execute(sql);
            System.out.println("Ejecutando: "+sql);

        } catch (SQLException ex) {

            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+ ex);

        }
        Conexion.desconectar();
    }

    public boolean modificar(Empleado emp) {
        
        String sql = "UPDATE public.empleado "
                + "SET nombre='"+emp.getNombre()+"', apellido='"+emp.getApellido()+"', cedula="+emp.getCedula()+", "
                + "telefono='"+emp.getTelefono()+"', fecalta='"+emp.getFecAlta()+"', fecbaja='"+emp.getFecBaja()+"', "
                + "salario="+emp.getSalario()+", observacion='"+emp.getObservacion()+"', estado="+emp.isEstado()+" "
                + "WHERE id="+emp.getId()+";";
        
        boolean resultado = false;
        
        Conexion.conectar();

        try {
        
            resultado = Conexion.st.execute(sql);
            System.out.println("Ejecutando: "+sql);
            
        } catch (SQLException ex) {
            
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+sql+ ex);
            
        }

        Conexion.desconectar();
        
        return resultado;

    }

    public Empleado recuperarPorCodigo(int codigo) {
        
        String sql = "SELECT nombre, apellido, cedula, "
                + "telefono, fecalta, fecbaja, "
                + "salario, observacion, estado "
                + "FROM public.empleado "
                + "WHERE id="+codigo+";";
        
        Conexion.conectar();
        
        Empleado empl = null;
        
        ResultSet rs;
        
        try {
            
            rs = Conexion.st.executeQuery(sql);
            System.out.println("Ejecutando: "+sql);
            
            if (rs.next()) {
                empl = new Empleado();
                empl.setNombre(rs.getString("nombre"));
                empl.setApellido(rs.getString("apellido"));
                empl.setCedula(rs.getInt("cedula"));
                empl.setTelefono(rs.getString("telefono"));
                empl.setFecAlta(rs.getDate("fecAlta"));
                empl.setFecBaja(rs.getDate("fecBaja"));
                empl.setSalario(rs.getDouble("salario"));
                empl.setObservacion(rs.getString("observacion"));
                empl.setEstado(rs.getBoolean("estado"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar SQL: "+ex);

        }
 
        Conexion.desconectar();
        
        return empl;
    }

    public List<Empleado> recuperarPorFiltro(String filtro) {

        String sql = "SELECT nombre, apellido, cedula, "
                + "telefono, fecalta, fecbaja, "
                + "salario, observacion, estado "
                + "FROM public.empleado "
                + "WHERE (nombre LIKE '%"+filtro+"%') "
                + "or (apellido LIKE '%"+filtro+"%') "
                + "ORDER BY nombres;";
        
        List<Empleado> lista = new ArrayList<>();
        
        System.out.println("SQL = " + sql);
        
        Conexion.conectar();
        
        Empleado empl = null;
        
        ResultSet rs;
        
        try {

            rs = Conexion.st.executeQuery(sql);
            
            System.out.println("Ejecutando: "+sql);

            
            while (rs.next()) {
                
                empl = new Empleado();
                
                empl.setId(rs.getInt("codigo"));

                lista.add(empl);
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
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

            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+ ex);

        }

        Conexion.desconectar();

    }
}
