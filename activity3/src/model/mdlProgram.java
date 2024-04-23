/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author Aprendiz SENA
 */
public class mdlProgram {
    public int addProgram(Program pro) {
        Conexion o = new Conexion();
        Connection con = o.getConexion();
        String sql = "INSERT INTO t_programa (PRO_NOMBRE, PRO_CODIGO, PRO_UID)"
                + " VALUES (?, ?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(0, pro.getNombre());
            st.setString(1, pro.getCodigo());
            st.setString(2, pro.getUid());
        } catch (SQLException ex) {
            System.out.println("Error al registrar");
        }
        return 0;
    }
    
    public int editProgram(Program pro) {
        Conexion o = new Conexion();
        Connection con = o.getConexion();
        int r = 0;
        String sql = "UPDATE t_programa SET PRO_NOMBRE = ? , PRO_CODIGO = ? WHERE PRO_ID = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(0, pro.getNombre());
            st.setString(1, pro.getCodigo());
            st.setString(2, pro.getUid());
            r = st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al editar");
        }
        return r;
    }
    
    public int delProgram() {
        Conexion o = new Conexion();
        Connection con = o.getConexion();
        int r = 0;
        String sql = "DELETE t_programa WHERE PRO_ID = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            r = st.executeUpdate();
        } catch(SQLException ex) {
            System.out.println("Error al eliminar");
        }
         
        return r;
    }
    
    public Program findProgram(String code) {
        Conexion o = new Conexion();
        Connection con = o.getConexion();
        ResultSet rs = null;
        Program p = new Program();
        String sql = "SELECT * WHERE PRO_COD = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(0, code);
            rs = st.executeQuery();
            p.setId(rs.getInt(1));
            p.setNombre(rs.getString(2));
            p.setCodigo(rs.getString(3));
            p.setUid(rs.getString("PRO_UID"));
        } catch(SQLException ex) {
            System.out.println("No se encontraron los datos");
        }
         
        return (Program) rs;
    }
}
