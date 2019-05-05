/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar.controller.admin;

import controlescolar.model.Alumno;
import controlescolar.view.ListaAlumnos;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hugoluna
 */
public class ListaAlumnoController {
    
    private ListaAlumnos listaAlumnos;
    private String cabecera[] = {
        "No. control ", "Nombre", "Apellido P.", "Apellido M.", "Fecha Nacimiento", "Lugar Nacimiento", "Curp", "Correo", "Telefono", "Sexo", "Carrera"
    };
    public ListaAlumnoController(ListaAlumnos listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
        cargarDatosTablaAlum();
    }
    
    
    
    /**
     * *
     * Mostrar los datos en la tabla de alumnos
     */
    public void cargarDatosTablaAlum() {
        try{
            DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabecera);

        //  "Telefono", "Sexo", "Carrera"
        for (int i = 0; i < new Alumno().obtenerTodo().size(); i++) {

            modelo.addRow(new Object[]{
                new Alumno().obtenerTodo().get(i).getNumControl(),
                new Alumno().obtenerTodo().get(i).getNombre(),
                new Alumno().obtenerTodo().get(i).getApellido_p(),
                new Alumno().obtenerTodo().get(i).getApellido_m(),
                new Alumno().obtenerTodo().get(i).getFecha_nacimiento(),
                new Alumno().obtenerTodo().get(i).getLugar_nacimiento(),
                new Alumno().obtenerTodo().get(i).getCurp(),
                new Alumno().obtenerTodo().get(i).getCorreo(),
                new Alumno().obtenerTodo().get(i).getTelefono(),
                new Alumno().obtenerTodo().get(i).getSexo(),
                new Alumno().obtenerTodo().get(i).getId_carrera()
            });

        }

        listaAlumnos.tablaAlumnos.setModel(modelo);

        for (int i = 0; i < cabecera.length; i++) {
            listaAlumnos.tablaAlumnos.getColumnModel().getColumn(i).setPreferredWidth(160);

        }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }

    }

    
}
