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
public class Banco {
    private String nombre;
    private final Cliente [] clientes;
    private int numeroDeClientes;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.clientes = new Cliente[1000];
        this.numeroDeClientes = 0;
    }


    public String getNombre() {
        return nombre;
    }
    
    public void cambiarNombre(String nuevoNombre){
        nombre = nuevoNombre;
    }
    
    public void adCliente(Cliente clie){
        clientes[numeroDeClientes] = clie;
        numeroDeClientes++;
    }

    public int getNumeroDeClientes() {
        return numeroDeClientes;
    }
    
    public Cliente obtCliente(int posicion) {
        if(posicion >= 0 && posicion < numeroDeClientes) {
            return clientes[posicion];
        } else {
            return null;
        }
    }

    public Cliente [] obtClientes() {
        return clientes;
    }
    
    
}
