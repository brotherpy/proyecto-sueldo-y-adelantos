/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.dao;

import dayara.model.DescuentoDetalle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dayara.model.DescuentoMovimiento;
import dayara.util.Conexion;

/**
 *
 * @author Jorge Fabio
 */
public class AdelantoMovimientoDao {
    
    public void guardar(DescuentoMovimiento adelanto){

        String sql = "INSERT INTO public.descuentomovimiento"
                + "(idempleado, fecha, idadelanto, monto, estado)"
                + "VALUES ("+adelanto.getIdEmpleado()+", '"+adelanto.getFecha()+"', "+adelanto.getIdAdelanto()+", "
                + ""+adelanto.getMonto()+", '"+adelanto.getEstado()+"');";
        
        Conexion.conectar();

        try {

            Conexion.st.execute(sql);
            System.out.println("Ejecutando: "+sql);

        } catch (SQLException ex) {

            Logger.getLogger(AdelantoMovimientoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+ ex+", "+sql);

        }
        
        Conexion.desconectar();
    }
    
    public List<DescuentoMovimiento> recuperarPorFuncionario(int codigo) {

        String sql = "SELECT id, fecha, idadelanto, monto, salariocabeceraid, estado FROM public.descuentomovimiento WHERE idempleado = "+codigo+" AND estado = 'PENDIENTE';";
        
        List<DescuentoMovimiento> lista = null;
        
        Conexion.conectar();
        
        DescuentoMovimiento adelanto;
        
        ResultSet rs;
        
        try {

            rs = Conexion.st.executeQuery(sql);
            
            System.out.println("Ejecutando: "+sql);

            
            while (rs.next()) {
                
                lista = new ArrayList<>();
                
                adelanto = new DescuentoMovimiento();
                
                adelanto.setId(rs.getInt("id"));
                adelanto.setFecha(rs.getDate("fecha"));
                adelanto.setIdAdelanto(rs.getInt("idadelanto"));
                adelanto.setMonto(rs.getDouble("monto"));

                lista.add(adelanto);
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(AdelantoMovimientoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+ex);
            
        }

        Conexion.desconectar();
        
        return lista;

    }
    
    public void anular(int codigo){

        String sql = "UPDATE public.descuentomovimiento SET estado = 'ANULADO' WHERE id="+codigo+";";
        
        Conexion.conectar();

        try {

            Conexion.st.execute(sql);
            System.out.println("Ejecutando: "+sql);

        } catch (SQLException ex) {

            Logger.getLogger(AdelantoMovimientoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+ ex+", "+sql);

        }
        
        Conexion.desconectar();
    }
    
    public DescuentoMovimiento recuperarPorMovimiento(int movimiento) {
        
        String sql = "SELECT idempleado, fecha, idadelanto, monto FROM public.descuentomovimiento WHERE id = "+movimiento+" AND estado = 'PENDIENTE';";
        
        Conexion.conectar();
        
        DescuentoMovimiento adelanto = null;
        
        ResultSet rs;
        
        try {
            
            rs = Conexion.st.executeQuery(sql);
            System.out.println("Ejecutando: "+sql);
            
            if (rs.next()) {
                adelanto = new DescuentoMovimiento();
                adelanto.setIdEmpleado(rs.getInt("idempleado"));
                adelanto.setFecha(rs.getDate("fecha"));
                adelanto.setIdAdelanto(rs.getInt("idadelanto")-1);
                adelanto.setMonto(rs.getDouble("monto"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdelantoMovimientoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar SQL: "+ex);

        }
 
        Conexion.desconectar();
        
        return adelanto;
    }
    
    public List<DescuentoDetalle> recuperarTodoPorFuncionario(int movimiento) {
        
        String sql = "SELECT descuentomovimiento.\"id\" AS id, "
                + "descuentos.\"concepto\" AS concepto, "
                + "descuentomovimiento.\"fecha\" AS fecha, "
                + "descuentomovimiento.\"monto\" AS monto "
                + "FROM \"public\".\"descuentomovimiento\" descuentomovimiento "
                + "INNER JOIN \"public\".\"descuentos\" descuentos "
                + "ON descuentomovimiento.\"idadelanto\" = descuentos.\"id\" "
                + "WHERE idempleado = 1 AND estado = 'PENDIENTE';";
        
        Conexion.conectar();
        
        List<DescuentoDetalle> adelantoList = new ArrayList<>();
        
        DescuentoDetalle adelanto = null;
                

        
        ResultSet rs;
        
        try {
            
            rs = Conexion.st.executeQuery(sql);
            System.out.println("Ejecutando: "+sql);
            
            while (rs.next()) {
                adelanto = new DescuentoDetalle();
                adelanto.setId(rs.getInt("id"));
                adelanto.setFecha(rs.getDate("fecha").toLocalDate());
                adelanto.setConcepto(rs.getString("concepto"));
                adelanto.setMonto(rs.getDouble("monto"));
                adelantoList.add(adelanto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdelantoMovimientoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar SQL: "+ex);

        }
 
        Conexion.desconectar();
        
        return adelantoList;
    }
}
