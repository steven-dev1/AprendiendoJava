/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Aprendiz SENA
 */
public class Conexion {
    private Connection con;
    private String usuario = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost/bdmvc?serverTimezone=UTC";

    public Conexion() {
         try {
             con = DriverManager.getConnection(url, usuario, password);
         } catch(SQLException e) {
             System.out.println("Error en la conexion: "+e.getMessage());
         }
    }
    
    public Connection getConexion() {
        return con;
    }
    
    
    
}
