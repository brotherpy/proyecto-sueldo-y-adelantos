/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.model;

import java.util.Date;

/**
 *
 * @author brother
 */
public class Empleado {
    private int id;
    private String nombre;
    private String apellido;
    private int cedula;
    private String telefono;
    private Date fecAlta;
    private Date fecBaja;
    private Double salario;
    private String Observacion;
    private boolean estado;

    public Empleado() {
        this.id = 0;
        this.nombre = "";
        this.apellido = "";
        this.cedula = 0;
        this.telefono = "";
        this.fecAlta = new Date();
        this.fecBaja = new Date();
        this.salario = 0d;
        this.Observacion = "";
        this.estado = false;
    }

    public Empleado(String nombre, String apellido, int cedula, String telefono, Date fecAlta, Double salario, String Observacion, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.fecAlta = fecAlta;
        this.salario = salario;
        this.Observacion = Observacion;
        this.estado = estado;
    }

    public Empleado(int id, String nombre, String apellido, int cedula, String telefono, Date fecAlta, Double salario, String Observacion, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.fecAlta = fecAlta;
        this.salario = salario;
        this.Observacion = Observacion;
        this.estado = estado;
    }

    public Empleado(int id, String nombre, String apellido, int cedula, String telefono, Date fecAlta, Date fecBaja, Double salario, String Observacion, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.fecAlta = fecAlta;
        this.fecBaja = fecBaja;
        this.salario = salario;
        this.Observacion = Observacion;
        this.estado = estado;
    }
    

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    public Date getFecBaja() {
        return fecBaja;
    }

    public void setFecBaja(Date fecBaja) {
        this.fecBaja = fecBaja;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
    
}
