/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aprendiz SENA
 */
public class mdlUser {
    public int addUser(User user) {
        Conexion o = new Conexion();
        Connection con = o.getConexion();
        String sql = "INSERT INTO t_usuario (USU_NOMBRES, USU_APELLIDOS, USU_EMAIL, USU_UID, USU_PASSWORD, USU_ROL)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        int r = 0;
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(0, user.getUsuName());
            st.setString(1, user.getUsuLastname());
            st.setString(2, user.getUsuEmail());
            st.setString(3, user.getUsuUid());
            st.setString(4, user.getUsuPass());
            st.setInt(5, user.getUsuRol());
            r = st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al registrar");
        }
        return r;
    }
    
    public int editUser(User user) {
        Conexion o = new Conexion();
        Connection con = o.getConexion();
        String sql = "UPDATE t_usuario SET USU_NOMBRES = ?, USU_APELLIDOS = ?, USU_EMAIL = ?, USU_PASSWORD = ?, USU_ROL = ? WHERE PRO_UID = ?"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        int r = 0;
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(0, user.getUsuName());
            st.setString(1, user.getUsuLastname());
            st.setString(2, user.getUsuEmail());
            st.setString(3, user.getUsuUid());
            st.setString(4, user.getUsuPass());
            st.setInt(5, user.getUsuRol());
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
        String sql = "DELETE t_usuario WHERE USU_ID = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            r = st.executeUpdate();
        } catch(SQLException ex) {
            System.out.println("Error al eliminar");
        }
         
        return r;
    }
    
    public User findUser(String code) {
        Conexion o = new Conexion();
        Connection con = o.getConexion();
        ResultSet rs = null;
        User u = new User();
        String sql = "SELECT * WHERE PRO_COD = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(0, code);
            rs = st.executeQuery();
            u.setUsuId(rs.getInt(1));
            u.setUsuName(rs.getString(2));
            u.setUsuLastname(rs.getString(3));
            u.setUsuEmail(rs.getString(4));
            u.setUsuUid(rs.getString("USU_UID"));
            u.setUsuPass(rs.getString(6));
            u.setUsuRol(rs.getInt(7));
        } catch(SQLException ex) {
            System.out.println("No se encontraron los datos");
        }
         
        return (User) rs;
    }
}
