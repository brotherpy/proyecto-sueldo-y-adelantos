/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.util;

import dayara.dao.EmpleadoDao;
import dayara.model.Empleado;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Jorge Fabio
 */
public class ConexionTest {
    public static void main(String[] args) {
        
        Calendar calendario = GregorianCalendar.getInstance();
        Date fecha = calendario.getTime();
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
        
        Empleado emp = new Empleado(
                "juan", 
                "carlos", 
                2997198, 
                "0981680414", 
                fecha,
                fecha, 
                1000000.00, 
                "", 
                true);
        
        EmpleadoDao dao = new EmpleadoDao();
        dao.guardar(emp);
    }
}
