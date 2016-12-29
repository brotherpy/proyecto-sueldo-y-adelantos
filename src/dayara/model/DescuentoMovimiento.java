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

public class DescuentoMovimiento {
    private int id;
    private int idEmpleado;
    private Date fecha;
    private int idAdelanto;
    private Double monto;
    private String estado;

    public DescuentoMovimiento() {
        this.id = 0;
        this.idEmpleado = 0;
        this.fecha = new Date();
        this.idAdelanto = 0;
        this.monto = 0d;
        this.estado = "";
    }

    public DescuentoMovimiento(int idEmpleado, Date fecha, int idAdelanto, Double monto, String estado) {
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.idAdelanto = idAdelanto;
        this.monto = monto;
        this.estado = estado;
    }

    public DescuentoMovimiento(int id, int idEmpleado, Date fecha, int idAdelanto, Double monto, String estado) {
        this.id = id;
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.idAdelanto = idAdelanto;
        this.monto = monto;
        this.estado = estado;
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

    public int getIdAdelanto() {
        return idAdelanto;
    }

    public void setIdAdelanto(int idAdelanto) {
        this.idAdelanto = idAdelanto;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
