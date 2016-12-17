/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dayara.dao;

import dayara.util.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Fabio
 */
public class LoginDao {
    
    public int validarIngreso(String usuario, String clave){
        
        int resultado = 0;
        
        String sql = "SELECT * FROM usuarios WHERE usuario = '"+usuario+"' AND clave = '"+clave+"';";
        
        try {
            
            Conexion.conectar();
            ResultSet rs = Conexion.st.executeQuery(sql);
            
            if (rs.next()) {
                
                resultado = 1;
                
            }
            
        } catch (SQLException e) {
        
            JOptionPane.showMessageDialog(null, e, "Error al conectar con BD", JOptionPane.ERROR_MESSAGE);
        
        }finally{
            
            Conexion.desconectar();
            
        }
                
        return resultado;
    }
    
    
}
