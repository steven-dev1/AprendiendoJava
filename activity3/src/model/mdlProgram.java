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

    public static int addProgram(Program pro) {
        Conexion o = new Conexion();
        Connection con = o.getConexion();
        String sql = "INSERT INTO t_programa (PRO_NOMBRE, PRO_CODIGO, PRO_UID)"
                + " VALUES (?, ?, ?)";
        int r = 0;
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, pro.getNombre());
            st.setString(2, pro.getCodigo());
            st.setString(3, pro.getUid());
            r = st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al registrar " + ex.getMessage());
        }
        return r;
    }

    public static int editProgram(Program pro, String codigo) {
        Conexion o = new Conexion();
        Connection con = o.getConexion();
        int r = 0;
        String sql = "UPDATE t_programa SET PRO_NOMBRE = ?, PRO_CODIGO = ? WHERE PRO_CODIGO = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, pro.getNombre());
            st.setString(2, pro.getCodigo());
            st.setString(3, codigo);
            r = st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al editar");
        }
        return r;
    }

    public static int delProgram(String uid) {
        Conexion o = new Conexion();
        Connection con = o.getConexion();
        int r = 0;
        String sql = "DELETE FROM t_programa WHERE PRO_UID = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, uid);
            r = st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar"+ex);
        }

        return r;
    }

    public static Program findProgram(String code) {
        Conexion o = new Conexion();
        Connection con = o.getConexion();
        ResultSet rs = null;
        Program p = new Program();
        String sql = "SELECT * FROM t_programa WHERE PRO_CODIGO = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, code);
            rs = st.executeQuery();
            if (rs.next()) {
                p.setId(rs.getInt("PRO_ID"));
                p.setNombre(rs.getString("PRO_NOMBRE"));
                p.setCodigo(rs.getString("PRO_CODIGO"));
                p.setUid(rs.getString("PRO_UID"));
                System.out.println(p.getNombre());
            } else {
                p = null;
            }
        } catch (SQLException ex) {
            System.out.println("No se encontraron los datos: "+ex);
        } finally {
        // Cerrar la conexión y el ResultSet en un bloque finally para asegurar su cierre adecuado
        try {
            if (rs != null) rs.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e);
        }
    }


        return p;
    }
}
