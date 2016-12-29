/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import javafx.util.converter.LocalDateTimeStringConverter;

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
    private LocalDate fecAlta;
    private LocalDate fecBaja;
    private Double salario;
    private String Observacion;
    private boolean estado;

    public Empleado() {
        this.id = 0;
        this.nombre = "";
        this.apellido = "";
        this.cedula = 0;
        this.telefono = "";
 
        this.salario = 0d;
        this.Observacion = "";
        this.estado = false;
    }

    public Empleado(String nombre, String apellido, int cedula, String telefono, LocalDate fecAlta, Double salario, String Observacion, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.fecAlta = fecAlta;
        this.salario = salario;
        this.Observacion = Observacion;
        this.estado = estado;
    }

    public Empleado(int id, String nombre, String apellido, int cedula, String telefono, LocalDate fecAlta, Double salario, String Observacion, boolean estado) {
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

    public Empleado(int id, String nombre, String apellido, int cedula, String telefono, LocalDate fecAlta, LocalDate fecBaja, Double salario, String Observacion, boolean estado) {
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

    public LocalDate getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(LocalDate fecAlta) {
        this.fecAlta = fecAlta;
    }

    public LocalDate getFecBaja() {
        return fecBaja;
    }

    public void setFecBaja(LocalDate fecBaja) {
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
