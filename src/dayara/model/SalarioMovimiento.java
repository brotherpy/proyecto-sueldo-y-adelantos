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

public class SalarioMovimiento {
    private int idCabecera;
    private Date fecha;
    private int idDescuento;

    public SalarioMovimiento() {
    }

    public SalarioMovimiento(Date fecha, int idDescuento) {
        this.fecha = fecha;
        this.idDescuento = idDescuento;
    }

    public SalarioMovimiento(int idCabecera, Date fecha, int idDescuento) {
        this.idCabecera = idCabecera;
        this.fecha = fecha;
        this.idDescuento = idDescuento;
    }

    public int getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(int idCabecera) {
        this.idCabecera = idCabecera;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(int idDescuento) {
        this.idDescuento = idDescuento;
    }

    
}
