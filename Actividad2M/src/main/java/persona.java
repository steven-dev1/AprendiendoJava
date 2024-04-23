/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aprendiz SENA
 */
public class persona extends cliente {
    
    private String cedula;
    private int edad;

    public persona(String cedula, String nom, int edad) {
        this.cedula = cedula;
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }
    public void cumplirAños(){
    
    int AñoCumple = 2024 - edad; 
    
    }
    
}
