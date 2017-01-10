/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge Fabio
 */
public class Conexion {
    
    public static final String DB = "dayara_db";
    public static final String URL = "jdbc:postgresql://localhost:5432/"+DB;
    public static final String USER = "brother";
    public static final String PASSWORD = "brother";
    public static Connection con = null;
    public static Statement st = null;

    public static void conectar(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.ALL.SEVERE, null, ex);
            System.out.println("Error al cargar el driver " + ex);
        }
        
       
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            st = con.createStatement();
            System.out.println("conectado base de datos "+ DB +" user: "+USER);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error de conexión " + ex);
        }
    }		

    public static void desconectar(){
        if(con != null){
            try {
                con.close();
                st.close();
                System.out.println("Sesion cerrada");
            } catch (SQLException e) {
                System.out.println("Error de desconexión" + e);
            }
        }
    }
    
}
