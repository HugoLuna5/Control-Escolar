/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar.model;

/**
 *
 * @author Hugo Luna
 */
public class Docente {
    //atributos
    private String id_Docente;
    private String nombre;
    private String apellidoM;
    private String apellidoP;
    private String curp;
    private String sexo;
    private String fecha_Nac;

    
    /***
     * constructores
     */
    public Docente() {
    }

    public Docente(String id_Docente, String nombre, String apellidoM, String apellidoP, String curp, String sexo, String fecha_Nac) {
        this.id_Docente = id_Docente;
        this.nombre = nombre;
        this.apellidoM = apellidoM;
        this.apellidoP = apellidoP;
        this.curp = curp;
        this.sexo = sexo;
        this.fecha_Nac = fecha_Nac;
    }

    
    //getters and setters
    public String getId_Docente() {
        return id_Docente;
    }

    public void setId_Docente(String id_Docente) {
        this.id_Docente = id_Docente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha_Nac() {
        return fecha_Nac;
    }

    public void setFecha_Nac(String fecha_Nac) {
        this.fecha_Nac = fecha_Nac;
    }
    
}
