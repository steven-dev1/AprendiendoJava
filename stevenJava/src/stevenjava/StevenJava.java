/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stevenjava;

import java.util.Scanner;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author Aprendiz SENA
 */
public class StevenJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Carro carro1 = new Carro();
        Carro carro2 = new Carro();
        
        Carro cr[] = new Carro[10];
        
        int modelo = Integer.parseInt(JOptionPane.showInputDialog("Digite modelo"));
        int precio = Integer.parseInt(JOptionPane.showInputDialog("Digite precio"));
        String color = JOptionPane.showInputDialog("Digite color");
        String marca = JOptionPane.showInputDialog("Digite marca");
        carro1.setColor(color);
        carro1.setMarca(marca);
        carro1.setModelo(modelo);
        carro1.setPrecio(precio);
       
        
        JOptionPane.showInternalMessageDialog(null, carro1.toString(), "Informacion", JOptionPane.ERROR_MESSAGE);
        
    }
}
