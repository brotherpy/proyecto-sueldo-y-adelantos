/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.util;

import dayara.dao.UsuariosDao;

/**
 *
 * @author jorge
 */
public class ConexionTest {
    public static void main(String[] args) {
        int codigo = 1;
        String pass = "123";
        
        UsuariosDao dao = new UsuariosDao();
    
        String valido = dao.validarPassword(codigo);
        
        System.out.println("El resultado es "+valido);
    }
    
}
