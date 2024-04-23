/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stevenjava;

/**
 *
 * @author Aprendiz SENA
 */
public class Carro {

    public Carro() {
    }
    

    public Carro(int modelo, String color, double precio, String marca) {
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.marca = marca;
    }
    
    int modelo;
    String color;
    double precio;
    String marca;

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
}
