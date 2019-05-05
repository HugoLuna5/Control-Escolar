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
public class Alumno {
    //Atributos
    private int numControl;
    private String nombre;
    private String apellido_p;
    private String apellido_m;
    private String fecha_nacimiento;
    private String sexo;
    private String curp;
    private String lugar_nacimiento;
    private int id_carrera;
    private String password;
    private int semestre;
    private String telefono;
    private String correo;

    
    /***
     * Constructor
     */
    public Alumno() {
    }

    public Alumno(int numControl, String nombre, String apellido_p, String apellido_m, String fecha_nacimiento, String sexo, String curp, String lugar_nacimiento, int id_carrera, String password, int semestre, String telefono, String correo) {
        this.numControl = numControl;
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.curp = curp;
        this.lugar_nacimiento = lugar_nacimiento;
        this.id_carrera = id_carrera;
        this.password = password;
        this.semestre = semestre;
        this.telefono = telefono;
        this.correo = correo;
    }

    //getters and setters
    
    public int getNumControl() {
        return numControl;
    }

    public void setNumControl(int numControl) {
        this.numControl = numControl;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /***
     * Obtener toda la info del alumno
     * @param numeroControl
     * @return 
     */
    public Alumno getData(int numeroControl) {
        String query = "SELECT * FROM alumno where numControl = ?";
        Alumno alumno = new Alumno();

        try {
            Connection conexion = new Conexion().getConnection();
            PreparedStatement sentencia = conexion.prepareStatement(query);
            sentencia.setString(1, String.valueOf(numeroControl));
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                alumno.setNumControl(rs.getInt("numControl"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido_p(rs.getString("apellido_p"));
                alumno.setApellido_m(rs.getString("apellido_m"));
                alumno.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                alumno.setLugar_nacimiento(rs.getString("lugar_nacimiento"));
                alumno.setCurp(rs.getString("curp"));
                alumno.setCorreo(rs.getString("correo"));
                alumno.setSexo(rs.getString("sexo"));
                alumno.setSemestre(rs.getInt("semestre"));
                alumno.setTelefono(rs.getString("telefono"));
                alumno.setId_carrera(rs.getInt("id_carrera"));
            }

        } catch (SQLException e) {
            System.err.println(e.getStackTrace());
        }

        return alumno;

    }

    /**
     * generar la imagen para el usuario utilizando 
     * las primeras letras
     * @param cadena
     * @return 
     */
    public char getFirstLetter(String cadena) {
        char letter = cadena.charAt(0);
        return letter;
    }

    
    

    
    /***
     * Crear un nuevo alumno
     * @param alumno
     * @return 
     */
    public boolean createAlumn(Alumno alumno) {
        boolean aux = false;
        String consulta = "INSERT INTO alumno (numControl , nombre , apellido_p, apellido_m, fecha_nacimiento, lugar_nacimiento , curp , correo , telefono , sexo , id_carrera , password, semestre )  "
                + "VALUES (?, ? ,? ,? ,? ,? ,? ,? ,? ,?,?,?, ?)";

        try {
            Connection conexion = (Connection) new Conexion().getConnection();

            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, alumno.getNumControl());
            sentencia.setString(2, alumno.getNombre());
            sentencia.setString(3, alumno.getApellido_p());
            sentencia.setString(4, alumno.getApellido_m());
            sentencia.setString(5, alumno.getFecha_nacimiento());
            sentencia.setString(6, alumno.getLugar_nacimiento());
            sentencia.setString(7, alumno.getCurp());
            sentencia.setString(8, alumno.getCorreo());
            sentencia.setString(9, alumno.getTelefono());
            sentencia.setString(10, alumno.getSexo());
            sentencia.setInt(11, alumno.getId_carrera());
            sentencia.setString(12, Security.cifrar(alumno.getPassword()));
            sentencia.setInt(13, 1);

            int insert = sentencia.executeUpdate();

            if (insert == 1) {
                aux = true;
            }

        } catch (SQLException e) {
            System.err.println(e);

        }

        return aux;

    }

    
    /***
     * Obtener todos los alumno registrados
     * @return 
     */
    public ArrayList<Alumno> obtenerTodo() {

        String query = "SELECT * FROM alumno";
        ArrayList<Alumno> alumnoLista = new ArrayList<>();
        try {
            Connection conexion = (Connection) new Conexion().getConnection();

            PreparedStatement sentencia = conexion.prepareStatement(query);

            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setNumControl(Integer.parseInt(rs.getString("numControl")));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido_p(rs.getString("apellido_p"));
                alumno.setApellido_m(rs.getString("apellido_m"));
                alumno.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                alumno.setLugar_nacimiento(rs.getString("lugar_nacimiento"));
                alumno.setCurp(rs.getString("curp"));
                alumno.setCorreo(rs.getString("correo"));
                alumno.setSexo(rs.getString("sexo"));
                alumno.setSemestre(rs.getInt("semestre"));
                alumno.setTelefono(rs.getString("telefono"));
                alumno.setId_carrera(Integer.parseInt(rs.getString("id_carrera")));
                alumnoLista.add(alumno);

            }

        } catch (SQLException e) {
            System.err.println(e);

        }

        return alumnoLista;

    }

    
    /***
     * Actualizar campos del alumno
     * @param campo
     * @param value
     * @param numControl
     * @return 
     */
    public Alumno updateAlumn(String campo, String value, int numControl) {
        String query = "UPDATE alumno SET " + campo + "=" + value + " WHERE numControl = ?";
        boolean aux = false;
        Alumno alumno = new Alumno();

        try {
            Connection conexion = new Conexion().getConnection();
            PreparedStatement sentencia = conexion.prepareStatement(query);
            sentencia.setInt(1, numControl);
            int result = sentencia.executeUpdate();

            if (result == 1) {
                aux = true;
            }

        } catch (SQLException e) {
            System.err.println(e.getStackTrace());
        }

        return alumno.getData(numControl);

    }

}
