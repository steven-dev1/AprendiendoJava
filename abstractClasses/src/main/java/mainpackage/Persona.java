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
public class Persona extends Cliente{
    private String cedula;
    private int edad;
    
    public Persona(String cedula, int edad, String nombre) {
        super(nombre);
        this.cedula = cedula;
        this.edad = edad;
    }
    
    // Method to obtain the identification (assuming cedula is the identification)
    @Override
    public String obtIdentificacion() {
        return "Persona";
    }
    
    // Method to obtain the age as a String
    public int getEdad() {
        return edad;
    }
    
}
