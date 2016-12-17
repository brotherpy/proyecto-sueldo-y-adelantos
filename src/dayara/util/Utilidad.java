/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge Fabio
 */
public class Utilidad {
    public static Double formatoValorD(String valor){
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(',');
        simbolo.setGroupingSeparator('.');
        DecimalFormat formato = new DecimalFormat("###,###.##", simbolo);
        Number numero = 0;

        try {
            numero = formato.parse(valor);
        } catch (ParseException ex) {
            Logger.getLogger(Utilidad.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numero.doubleValue();
    }

    public static String formatoValorS(Double valor){
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(',');
        simbolo.setGroupingSeparator('.');
        DecimalFormat formato = new DecimalFormat("###,###.##", simbolo);

        return formato.format(valor);
    }

}
