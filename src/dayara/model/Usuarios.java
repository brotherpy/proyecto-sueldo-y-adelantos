/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.model;

/**
 *
 * @author Jorge Fabio
 */
public class Usuarios {
    private int id;
    private String usuario;
    private String clave;
    private boolean estado;

    public Usuarios() {
        this.id = 0;
        this.usuario = "";
        this.clave = "";
        this.estado = false;
    }

    public Usuarios(String usuario, String clave, boolean estado) {
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
    }

    public Usuarios(int id, String clave) {
        this.id = id;
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
