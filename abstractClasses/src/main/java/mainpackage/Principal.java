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
public class Principal {
    public static void main(String [] args) {
        Banco bn = new Banco("Bancolombia");
        
        Empresa emp1 = new Empresa("23847", "Steven", "SENA Learn");
        Empresa emp2 = new Empresa("23847", "Steven2", "SENA Learn2");
        Persona p1 = new Persona("2348", 30, "Steven Gonzalez");
        Persona p2 = new Persona("2348", 41, "Steven GonzalezViejo");

        bn.adCliente(emp1);
        bn.adCliente(emp2);
        bn.adCliente(p1);
        bn.adCliente(p2);
        
        Cliente [] c = bn.obtClientes();
        for (int x = 0; x < bn.getNumeroDeClientes(); x++){
            System.out.println("El nombre del cliente es: " + c[x].getNombre());
        }
        
        int maxAge = 0;
        int minAge = 100;
        String nameMaxAge = "";
        String nameMinAge = "";
        
        for(int x = 0; x < bn.getNumeroDeClientes(); x++){
            if( c[x].obtIdentificacion().equals("Persona")){
                Persona p = (Persona) c[x];
                if(p.getEdad() < 18){
                 System.out.println("El nombre del cliente es: " + c[x].getNombre());   
                }
                if(p.getEdad() > maxAge){
                    nameMaxAge = c[x].getNombre();
                    maxAge = p.getEdad();
                } if(p.getEdad() < minAge){
                    nameMinAge = c[x].getNombre();
                    minAge = p.getEdad();
                }
            }
        }
        
        System.out.println("El cliente más viejo tiene: "+ maxAge);
        System.out.println("El cliente más viejo se llama: "+ nameMaxAge); 
        
        System.out.println("El cliente más joven tiene: "+ minAge);
        System.out.println("El cliente más joven se llama: "+ nameMinAge); 
    }
}
