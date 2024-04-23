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
public class Principal extends Cita{
    
    public static void main(String[] args) {
        Cita cita1 = new Cita();
        
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite numero de cita"));
        int tipo = Integer.parseInt(JOptionPane.showInputDialog("Digite el tipo de cita"));
        double tarifa = Integer.parseInt(JOptionPane.showInputDialog("Digite tarifa"));
        
        cita1.setNumero(numero);
        cita1.setTipo(tipo);
        cita1.setTarifa(tarifa);
        cita1.calcularValorFinal();
       
        
        JOptionPane.showInternalMessageDialog(null, "El número de la cita es: "+numero+","+"y el valor final es de: "+cita1.getValorFinal());
    
    }
}
