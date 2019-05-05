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
import java.util.ArrayList;

/**
 *
 * @author gustavo
 */
public class Administrador {
    
    //atributos 
    private int id;
    private String nombre;
    private String apellido_p;
    private String apellido_m;
    private String usuario;
    private String password;

    /***
     * Constructores
     */
    public Administrador() {
    }

    public Administrador(int id, String nombre, String apellido_p, String apellido_m, String usuario, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.usuario = usuario;
        this.password = password;
    }
    
    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    /**
     * Obtener los datos del usuario
     * @param usuario
     * @return 
     */
    public Administrador getData(String usuario){
         String query = "SELECT * FROM administrador where usuario = ?";
        Administrador admin = new Administrador();

        try {
            Connection conexion = new Conexion().getConnection();
            PreparedStatement sentencia = conexion.prepareStatement(query);
            sentencia.setString(1, String.valueOf(id));
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                 admin.setId(rs.getInt("id"));
                 admin.setNombre(rs.getString("nombre"));
                 admin.setApellido_p(rs.getString("apellido_p"));
                 admin.setApellido_m(rs.getString("apellido_m"));
                 admin.setUsuario(rs.getString("usuario"));
            }
            
            
        } catch (SQLException e) {
            System.err.println(e.getStackTrace());
        }
        
        return admin;
        
    }
    
    
    /**
     * Crear un nuevo Admin
     * @param admin
     * @return 
     */
    public boolean createAdmin(Administrador admin){
        boolean aux = false;
        String consulta = "INSERT INTO administrador ( nombre, apellido_p, apellido_m, usuario,password) VALUES (?, ?, ?, ?, ?)";
        
         try {
            Connection conexion = (Connection) new Conexion().getConnection();

            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, admin.getNombre());
            sentencia.setString(2, admin.getApellido_p());
            sentencia.setString(3, admin.getApellido_m());
            sentencia.setString(4, admin.getUsuario());
             sentencia.setString(5, Security.cifrar(admin.getPassword()));

            int insert = sentencia.executeUpdate();
            
            if (insert == 1) {
                aux = true;
            }

        } catch (SQLException e) {
            System.err.println(e);

        }        
        return aux;
        
   
    }
    
    
    
    
    
    
    
    
    /**
     * Obtener todos los alumnos
     * @return 
     */
    public ArrayList<Administrador> obtenerTodo(){
        
        
        String query ="SELECT * FROM administrador";
        ArrayList<Administrador> adminLista = new ArrayList<>();
         try {
            Connection conexion = (Connection) new Conexion().getConnection();

            PreparedStatement sentencia = conexion.prepareStatement(query);
            
            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {
                Administrador admin = new Administrador();
                admin.setNombre(rs.getString("nombre"));
                admin.setApellido_p(rs.getString("apellido_p"));
                admin.setApellido_m(rs.getString("apellido_m"));
                admin.setUsuario(rs.getString("usuario"));
                adminLista.add(admin);

            }

        } catch (SQLException e) {
             System.err.println(e);

        }

         return adminLista;
        
    }
    
}
