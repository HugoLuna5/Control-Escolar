package controlescolar.model;

public class Semestre {

    private int id_semestre;
    private String semestre;
    private String descripcionSemestre;


    public Semestre() {
    }

    public Semestre(int id_semestre, String semestre, String descripcionSemestre) {
        this.id_semestre = id_semestre;
        this.semestre = semestre;
        this.descripcionSemestre = descripcionSemestre;
    }

    public int getId_semestre() {
        return id_semestre;
    }

    public void setId_semestre(int id_semestre) {
        this.id_semestre = id_semestre;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getDescripcionSemestre() {
        return descripcionSemestre;
    }

    public void setDescripcionSemestre(String descripcionSemestre) {
        this.descripcionSemestre = descripcionSemestre;
    }
}
