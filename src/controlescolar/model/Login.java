/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar.model;

import com.mysql.jdbc.Connection;
import controlescolar.utils.Security;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hugoluna
 */
public class Login {
    
    
    /***
     * Proceso para el inicio de sesion
     * @param alumno
     * @return 
     */
    public boolean loginAlumn(Alumno alumno) {

        String query = "SELECT * FROM alumno where numControl = ? AND password = ?";
        boolean checkUser = false;

        try {
            Connection conexion = new Conexion().getConnection();
            PreparedStatement sentencia = conexion.prepareStatement(query);
            sentencia.setString(1, String.valueOf(alumno.getNumControl()));
            sentencia.setString(2, Security.cifrar(alumno.getPassword()));
            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                checkUser = true;
            }
        } catch (SQLException e) {

        }

        return checkUser;

    }
    
    
    
    /**
     * Metodo para el inicio de sesion del Admin
     * @param admin
     * @return 
     */
    public boolean loginAdmin(Administrador admin) {

        String query = "SELECT * FROM administrador where usuario = ? AND password = ?";
        boolean checkUser = false;

        try {
            Connection conexion = new Conexion().getConnection();
            PreparedStatement sentencia = conexion.prepareStatement(query);
            sentencia.setString(1, String.valueOf(admin.getUsuario()));
            sentencia.setString(2, Security.cifrar(admin.getPassword()));
            ResultSet rs = sentencia.executeQuery();
            
            if (rs.next()) {
                checkUser = true;
            }
        } catch (SQLException e) {

        }
        
        return checkUser;

    }
    
}
