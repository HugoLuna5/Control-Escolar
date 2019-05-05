package controlescolar.model;

public class Materia {


    private int clave_materia;
    private String nombreMateria;

    public Materia() {
    }

    public Materia(int clave_materia, String nombreMateria) {
        this.clave_materia = clave_materia;
        this.nombreMateria = nombreMateria;
    }


    public int getClave_materia() {
        return clave_materia;
    }

    public void setClave_materia(int clave_materia) {
        this.clave_materia = clave_materia;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }
}
