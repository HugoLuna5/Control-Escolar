/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar.controller.admin;

import controlescolar.model.Alumno;
import controlescolar.view.DatosAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author hugoluna
 */
public class DatosAlumnoController {
    
    private DatosAlumno datosAlumno;

    public DatosAlumnoController(DatosAlumno datosAlumno) {
        this.datosAlumno = datosAlumno;
        events();
    }
    
    
    
    
    
    public void events(){
        datosAlumno.btnRegistar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAlumn();
            }
        });
    }
    
    
     /**
     * Falta validar los datos
     *
     */
    public void createAlumn() {

        try {
            String noControl = datosAlumno.no_control.getText();
            String nombre = datosAlumno.nombre.getText();
            String apellidoP = datosAlumno.ap_paterno.getText();
            String apellidoM = datosAlumno.ap_Materno.getText();
            String fecha_Nacimiento = datosAlumno.fechaNacField.getDateStringOrEmptyString();
            String lugar_nac = datosAlumno.lugar_nac.getText();
            String curp = datosAlumno.curpField.getText();
            String correo = datosAlumno.correo.getText();
            String telefono = datosAlumno.telefono.getText();
            String sexo = datosAlumno.sexo.getSelectedItem().toString();
            int carrera = datosAlumno.carrera.getSelectedIndex() + 1;
            String contrasena = datosAlumno.password.getText();

            Alumno alum = new Alumno();
            alum.setNumControl(Integer.parseInt(noControl));
            alum.setNombre(nombre);
            alum.setApellido_p(apellidoP);
            alum.setApellido_m(apellidoM);
            alum.setFecha_nacimiento(fecha_Nacimiento);
            alum.setLugar_nacimiento(lugar_nac);
            alum.setCurp(curp);
            alum.setCorreo(correo);
            alum.setTelefono(telefono);
            alum.setSexo(sexo);
            alum.setId_carrera(carrera);
            alum.setPassword(contrasena);

            if (new Alumno().createAlumn(alum)) {
                limpiarCamposAlumn();
                JOptionPane.showMessageDialog(datosAlumno, "Se completo con exito el registro del alumno");
            } else {
                JOptionPane.showMessageDialog(datosAlumno, "Ocurrio un error al registrarse, contacte al administrador");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

   
    /**
     * Limpiar compos de la vista de Alumnos
     */
    public void limpiarCamposAlumn() {
        datosAlumno.no_control.setText(null);
        datosAlumno.nombre.setText(null);
        datosAlumno.ap_paterno.setText(null);
        datosAlumno.ap_Materno.setText(null);
        datosAlumno.fechaNacField.setText(null);
        datosAlumno.curpField.setText(null);
        datosAlumno.lugar_nac.setText(null);
        datosAlumno.correo.setText(null);
        datosAlumno.telefono.setText(null);
        datosAlumno.sexo.setSelectedIndex(0);
        datosAlumno.carrera.setSelectedIndex(0);
        datosAlumno.password.setText(null);

    }

    
}
