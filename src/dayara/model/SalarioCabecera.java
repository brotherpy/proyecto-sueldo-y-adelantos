/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.model;

import java.util.Date;

/**
 *
 * @author Jorge Fabio
 */
public class SalarioCabecera {
    private int id;
    private int idEmpleado;
    private Date fecha;
    private Double salario;
    private Double descuento;
    private Double liquidoCobrar;

    public SalarioCabecera() {
        this.id = 0;
        this.idEmpleado = 0;
        this.fecha = new Date();
        this.salario = 0d;
        this.descuento = 0d;
        this.liquidoCobrar = 0d;
    }

    public SalarioCabecera(int idEmpleado, Date fecha, Double salario, Double descuento, Double liquidoCobrar) {
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.salario = salario;
        this.descuento = descuento;
        this.liquidoCobrar = liquidoCobrar;
    }

    public SalarioCabecera(int id, int idEmpleado, Date fecha, Double salario, Double descuento, Double liquidoCobrar) {
        this.id = id;
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.salario = salario;
        this.descuento = descuento;
        this.liquidoCobrar = liquidoCobrar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getLiquidoCobrar() {
        return liquidoCobrar;
    }

    public void setLiquidoCobrar(Double liquidoCobrar) {
        this.liquidoCobrar = liquidoCobrar;
    }
    
    
}
