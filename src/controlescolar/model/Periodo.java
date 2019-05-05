package controlescolar.model;

public class Periodo {


    private int id_periodo;
    private String periodo;


    public Periodo() {
    }

    public Periodo(int id_periodo, String periodo) {
        this.id_periodo = id_periodo;
        this.periodo = periodo;
    }

    public int getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(int id_periodo) {
        this.id_periodo = id_periodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
