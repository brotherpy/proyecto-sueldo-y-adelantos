/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.model;

import java.time.LocalDate;

/**
 *
 * @author jorge
 */
public class DescuentoDetalle {
    
    private int id;
    private String concepto;
    private LocalDate fecha;
    private Double monto;

    public DescuentoDetalle() {
        this.id = 0;
        this.concepto = "";
        this.monto = 0d;
    }

    public DescuentoDetalle(int id, String concepto, LocalDate fecha, Double monto) {
        this.id = id;
        this.concepto = concepto;
        this.fecha = fecha;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
}
