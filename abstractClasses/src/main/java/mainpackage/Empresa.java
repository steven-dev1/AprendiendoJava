/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

/**
 *
 * @author Aprendiz SENA
 */
public class Empresa extends Cliente{
    private String nit;
    private String representante;

    public Empresa(String nit, String representante, String nombre) {
        super(nombre);
        this.nit = nit;
        this.representante = representante;
    }


    public String getRepresentante() {
        return this.representante;
    }
    
    public String cambiarRepres(String repres) {
        representante = repres;
        return representante;
    }
    
    @Override
    public String obtIdentificacion() {
        return "Empresa";
    }
}
