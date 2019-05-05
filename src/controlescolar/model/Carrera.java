/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar.model;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hugoluna
 */
public class Carrera {

    //atributos
    private int claveCarrera;
    private String nombre;
    private String descripcion;

    /**
     * *
     * Constructores
     */
    public Carrera() {
    }

    public Carrera(int claveCarrera, String nombre, String descripcion) {
        this.claveCarrera = claveCarrera;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getClaveCarrera() {
        return claveCarrera;
    }

    public void setClaveCarrera(int claveCarrera) {
        this.claveCarrera = claveCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    /***
     * Obtener los datos de la carrera
     * @param id_carrera
     * @return 
     */
    public Carrera getData(int id_carrera) {
        String query = "SELECT * FROM carrera where claveCarrera = ?";
        Carrera carrera = new Carrera();

        try {
            Connection conexion = new Conexion().getConnection();
            PreparedStatement sentencia = conexion.prepareStatement(query);
            sentencia.setString(1, String.valueOf(id_carrera));
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                carrera.setClaveCarrera(rs.getInt("claveCarrera"));
                carrera.setNombre(rs.getString("nombre"));
                carrera.setDescripcion(rs.getString("descripcion"));
            }

        } catch (SQLException e) {
            System.err.println(e.getStackTrace());
        }

        return carrera;

    }

}
