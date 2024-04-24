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
        if (e.getSource().equals(vPrograma.btnRegistrar)) {
            String nombre = vPrograma.txtNombre.getText();
            String codigo = vPrograma.txtCodigo.getText();
            Program p = new Program();
            p.setCodigo(codigo);
            p.setNombre(nombre);
            p.setUid(UUID.randomUUID().toString());
            int r = mdlProgram.addProgram(p);
            if (r > 0) {
                JOptionPane.showMessageDialog(vPrograma, "Se registró");
            } else {
                JOptionPane.showMessageDialog(vPrograma, "Error al registrar");
            }

            System.out.println("Registrado");
        } else if (e.getSource().equals(vPrograma.btnConsultar)) {
            String codigo = vPrograma.txtCValorBusqueda.getText();
            /*String codigo = vPrograma.txtCodigo.getText();*/
            Program p = new Program();
            /*p.setCodigo(codigo);*/
            p.setCodigo(codigo);
            /*p.setUid(UUID.randomUUID().toString());*/
            Program r = mdlProgram.findProgram(codigo);
            if (r == null) {
                System.out.println("Código no encontrado");
            } else {
                vPrograma.txtCNombre1.setText(r.getNombre());
                vPrograma.txtCCodigo.setText(r.getCodigo());
                vPrograma.txtId.setText(r.getUid());
            }
            /*if (r > 0) {
                JOptionPane.showMessageDialog(vPrograma, "Se consultó");
            } else {
                JOptionPane.showMessageDialog(vPrograma, "Falló");
            }*/
        } else if (e.getSource().equals(vPrograma.btnEditar)) {
            String nombre = vPrograma.txtCNombre1.getText();
            String codigo = vPrograma.txtCCodigo.getText();
            String oldCode = vPrograma.txtCValorBusqueda.getText();
            /*String codigo = vPrograma.txtCodigo.getText();*/
            Program p = new Program();
            /*p.setCodigo(codigo);*/
            p.setCodigo(codigo);
            p.setNombre(nombre);
            /*p.setUid(UUID.randomUUID().toString());*/
            int r = mdlProgram.editProgram(p, oldCode);
            

            if (r > 0) {
                JOptionPane.showMessageDialog(vPrograma, "Se editó correctamente");
                vPrograma.txtCNombre1.setText("");
                vPrograma.txtCCodigo.setText("");
            } else {
                JOptionPane.showMessageDialog(vPrograma, "Falló");
            }
        } else if (e.getSource().equals(vPrograma.btnEliminar)) {
            String uid = vPrograma.txtId.getText();
            /*String codigo = vPrograma.txtCodigo.getText();*/
            /*p.setCodigo(codigo);*/
            /*p.setUid(UUID.randomUUID().toString());*/
            int r = 0;
            int validate = JOptionPane.showConfirmDialog(vPrograma, "¿Seguro que deseas eliminar este registro?");
            if(validate == 0) {
                r = mdlProgram.delProgram(uid);
            } else if (validate == 1){
                JOptionPane.showMessageDialog(vPrograma, "Cancelaste el registro");
            }

            if (r > 0) {
                JOptionPane.showMessageDialog(vPrograma, "Se eliminó");
                vPrograma.txtCNombre1.setText("");
                vPrograma.txtCCodigo.setText("");
            } else if( r <= 0 && validate != 1) {
                JOptionPane.showMessageDialog(vPrograma, "Error al eliminar");
            }
        };
    }

}
