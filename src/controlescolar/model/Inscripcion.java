package controlescolar.model;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Inscripcion {
    //Atributos
    private int id_Inscrip;
    private int status;
    private int pago;
    private int no_Control;
    private int semestre;
    
    /***
     * Constructores
     */
    
    public Inscripcion() {
    }

    public Inscripcion(int id_Inscrip, int status, int pago, int no_Control, int semestre) {
        this.id_Inscrip = id_Inscrip;
        this.status = status;
        this.pago = pago;
        this.no_Control = no_Control;
        this.semestre = semestre;
    }

    //getters and setters
    public int getId_Inscrip() {
        return id_Inscrip;
    }

    public void setId_Inscrip(int id_Inscrip) {
        this.id_Inscrip = id_Inscrip;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public int getNo_Control() {
        return no_Control;
    }

    public void setNo_Control(int no_Control) {
        this.no_Control = no_Control;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    
    /***
     * Inscribir un alumno
     * @param inscripcion
     * @param alumno
     * @return 
     */
    public boolean create(Inscripcion inscripcion, Alumno alumno) {
        
        boolean aux = false;
        String consulta = "INSERT INTO inscripcion (num_control, importe, semestre, status) VALUES (?, ?, ?, ?)";
        
        try {
            Connection conexion = (Connection) new Conexion().getConnection();
            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, alumno.getNumControl());
            sentencia.setInt(2, inscripcion.getPago());
            sentencia.setInt(3, alumno.getSemestre());
            sentencia.setInt(4, 0);
            
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
     * Obtener todos los datos de la inscripcion de los alumnos
     * @param numControl
     * @return 
     */
    public ArrayList<Inscripcion> getData(int numControl) {
        ArrayList<Inscripcion> listaIns = new ArrayList<>();
        String query = "SELECT * FROM inscripcion where num_control = ?";
        
        try {
            Connection conexion = (Connection) new Conexion().getConnection();
            
            PreparedStatement sentencia = conexion.prepareStatement(query);
            sentencia.setString(1, String.valueOf(numControl));
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                Inscripcion ins = new Inscripcion();
                ins.setNo_Control(rs.getInt("num_control"));
                ins.setPago(rs.getInt("importe"));
                ins.setSemestre(rs.getInt("semestre"));
                ins.setStatus(rs.getInt("status"));
                listaIns.add(ins);
            }
            
        } catch (SQLException e) {
            System.err.println(e.getStackTrace());
        }
        
        return listaIns;
        
    }
    
    /**
     * Obtener la info de la inscripcion
     * @param numControl
     * @return 
     */
    public Inscripcion data(int numControl) {
        String query = "SELECT * FROM inscripcion where num_control = ?";
        Inscripcion inscripcion = new Inscripcion();
        
        try {
            Connection conexion = new Conexion().getConnection();
            PreparedStatement sentencia = conexion.prepareStatement(query);
            sentencia.setString(1, String.valueOf(numControl));
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                inscripcion.setNo_Control(rs.getInt("num_control"));
                inscripcion.setPago(rs.getInt("importe"));
                inscripcion.setSemestre(rs.getInt("semestre"));
                inscripcion.setStatus(rs.getInt("status"));
            }
            
        } catch (SQLException e) {
            System.err.println(e.getStackTrace());
        }
        
        return inscripcion;
        
    }
    
    /**
     * Actualizar los datos de la inscripcion
     * @param campo
     * @param value
     * @param numControl
     * @return 
     */
    public Inscripcion update(String campo, String value, int numControl) {
        String query = "UPDATE inscripcion SET " + campo + "=" + value + " WHERE num_control = ?";        
        boolean aux = false;        
        Inscripcion inscripcion = new Inscripcion();
        
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
        
        return new Inscripcion().data(numControl);
        
    }
    
}
