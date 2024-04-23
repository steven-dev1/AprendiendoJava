/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stevenjava2;

import javax.swing.JOptionPane;

/**
 *
 * @author Aprendiz SENA
 */
public class Cita {
    int numero;
    int tipo;
    double tarifa;
    double valorFinal;

    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getValorFinal() {
        return valorFinal;
    }
    
    public void calcularValorFinal() {
        if(this.tipo <= 3) {
            this.valorFinal = this.tarifa - (this.tarifa*0.50);
        } else {
            this.valorFinal = this.tarifa + (this.tarifa*0.50);
        }
    }
}
