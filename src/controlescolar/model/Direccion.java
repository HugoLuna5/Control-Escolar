package controlescolar.model;

import com.mysql.jdbc.Connection;
import controlescolar.utils.Security;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Direccion {

    //atributos
    private int id_direccion;
    private String numControl;
    private String calle;
    private String colonia;
    private String ciudad;
    private String codigoPostal;
    private String entidadFederativa;
    private String numeroInterior;

    /**
     * *
     * Constructores
     */
    public Direccion() {
    }

    public Direccion(int id_direccion, String numControl, String calle, String colonia, String ciudad, String codigoPostal, String entidadFederativa, String numeroInterior) {
        this.id_direccion = id_direccion;
        this.numControl = numControl;
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.entidadFederativa = entidadFederativa;
        this.numeroInterior = numeroInterior;
    }

    //getters and setters
    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getNumControl() {
        return numControl;
    }

    public void setNumControl(String numControl) {
        this.numControl = numControl;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEntidadFederativa() {
        return entidadFederativa;
    }

    public void setEntidadFederativa(String entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    
    /***
     * Obtener las direcciones de cada alumno
     * @param numeroControl
     * @return 
     */
    public ArrayList<Direccion> getData(int numeroControl) {
        String query = "SELECT * FROM direccion where numControl = ?";
        ArrayList<Direccion> direccionList = new ArrayList<>();

        try {
            Connection conexion = new Conexion().getConnection();
            PreparedStatement sentencia = conexion.prepareStatement(query);
            sentencia.setString(1, String.valueOf(numeroControl));
            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {
                Direccion direccion = new Direccion();
                direccion.setCalle(rs.getString("calle"));
                direccion.setNumeroInterior(rs.getString("numero"));
                direccion.setColonia(rs.getString("colonia"));
                direccion.setCiudad(rs.getString("ciudad"));
                direccion.setEntidadFederativa(rs.getString("entidad"));
                direccion.setCodigoPostal(rs.getString("cp"));
                direccionList.add(direccion);

            }

        } catch (SQLException e) {
            System.err.println(e.getStackTrace());
        }

        return direccionList;

    }

    
    /***
     * Crear una nueva direccion
     * @param direccion
     * @return 
     */
    public boolean createDirection(Direccion direccion) {
        boolean aux = false;
        String consulta = "INSERT INTO direccion (numControl, ciudad , colonia, calle, numero, entidad, cp )  "
                + "VALUES (?, ? ,? ,? ,? ,?, ?)";

        try {
            Connection conexion = (Connection) new Conexion().getConnection();

            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, direccion.getNumControl());
            sentencia.setString(2, direccion.getCiudad());
            sentencia.setString(3, direccion.getColonia());
            sentencia.setString(4, direccion.getCalle());
            sentencia.setString(5, direccion.getNumeroInterior());
            sentencia.setString(6, direccion.getEntidadFederativa());
            sentencia.setString(7, direccion.getCodigoPostal());

            int insert = sentencia.executeUpdate();

            if (insert == 1) {
                aux = true;
            }

        } catch (SQLException e) {
            System.err.println(e);

        }

        return aux;
    }

}
