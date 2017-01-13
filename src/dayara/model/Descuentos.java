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
public class Descuentos {
    
    private int id;
    private String concepto;

    public Descuentos() {
        this.id = 0;
        this.concepto = "";
    }

    public Descuentos(String concepto) {
        this.concepto = concepto;
    }

    public Descuentos(int id, String concepto) {
        this.id = id;
        this.concepto = concepto;
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

    @Override
    public String toString() {
        return this.concepto;
    }
    
    
}
