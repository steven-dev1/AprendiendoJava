/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import javax.swing.JOptionPane;
import model.Program;
import model.mdlProgram;
import views.vistaPrograma;
/**
 *
 * @author Aprendiz SENA
 */
public class cntPrograma implements ActionListener {
    vistaPrograma vPrograma;

    public cntPrograma(vistaPrograma vPrograma) {
        this.vPrograma = vPrograma;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vPrograma.btnRegistrar)){
            String nombre = vPrograma.txtNombre.getText();
            String codigo = vPrograma.txtCodigo.getText();
            Program p = new Program ();
            p.setCodigo((codigo));
            p.setNombre(nombre);
            p.setUid(UUID.randomUUID().toString());
            int r = mdlProgram.addProgram(p);
            if(r > 0) {
                JOptionPane.showMessageDialog(vPrograma, "Se registró");
            } else {
                JOptionPane.showMessageDialog(vPrograma, "Error");
            }
            
            System.out.println("Registrado");
        };
    }
    
}
