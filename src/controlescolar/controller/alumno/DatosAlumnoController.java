/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar.controller.alumno;

import controlescolar.model.Alumno;
import controlescolar.model.Carrera;
import controlescolar.model.Direccion;
import controlescolar.view.DataView;
import controlescolar.view.DirectionsView;
import controlescolar.view.components.Toaster.Toaster;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hugoluna
 */
public class DatosAlumnoController {

    private DataView dataView;
    private Alumno alumno;
    private String dat[] = {"Ciudad", "Colonia", "Calle", "Entidad", "C.P", "Numero"};
    private Toaster toaster;
    private DirectionsView directionsView;

    public DatosAlumnoController(DataView dataView, Alumno alumno) {
        this.dataView = dataView;
        this.alumno = alumno;
        toaster = new Toaster(dataView);
        directionsView = new DirectionsView();

        events();
        setDataToDataView();
    }

    public void events() {
        this.dataView.btnViewDirections.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                viewDirection();
            }
        });
        this.dataView.btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDataAlumn();
            }
        });
    }

    /**
     * Settear los datos en la vista donde se muestran los datos del alumno
     */
    public void setDataToDataView() {
        dataView.nameField.setText(alumno.getNombre());
        dataView.apField.setText(alumno.getApellido_p());
        dataView.amField.setText(alumno.getApellido_m());
        LocalDate date = LocalDate.parse(alumno.getFecha_nacimiento());

        dataView.fechaNacField.setDate(date);
        dataView.telephoneField.setText(alumno.getTelefono());

        switch (alumno.getSexo()) {
            case "Masculino":
                dataView.sexField.setSelectedIndex(0);
                break;
            case "Femenino":
                dataView.sexField.setSelectedIndex(1);
                break;
            default:
                break;

        }

        dataView.curpField.setText(alumno.getCurp());
        dataView.nacimientoField.setText(alumno.getLugar_nacimiento());
        dataView.carreraField.setText(new Carrera().getData(alumno.getId_carrera()).getNombre());
        dataView.btnGuardar.setVisible(false);

    }

    /**
     * *
     * Mostrar las direcciones del usuario
     */
    public void viewDirection() {
        JDialog dialog = new JDialog();

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.setColumnIdentifiers(dat);

        //"Ciudad", "Colonia", "Calle", "Entidad", "C.P", "Numero"
        for (int i = 0; i < new Direccion().getData(alumno.getNumControl()).size(); i++) {
            defaultTableModel.addRow(new Object[]{
                new Direccion().getData(alumno.getNumControl()).get(i).getCiudad(),
                new Direccion().getData(alumno.getNumControl()).get(i).getColonia(),
                new Direccion().getData(alumno.getNumControl()).get(i).getCalle(),
                new Direccion().getData(alumno.getNumControl()).get(i).getEntidadFederativa(),
                new Direccion().getData(alumno.getNumControl()).get(i).getCodigoPostal(),
                new Direccion().getData(alumno.getNumControl()).get(i).getNumeroInterior(),});

        }

        directionsView.tableField.setModel(defaultTableModel);
        new DirectionsController(directionsView);
        dialog.setContentPane(directionsView);
        dialog.setLocationRelativeTo(null);
        dialog.pack();
        dialog.setVisible(true);
    }

    /**
     * Actualizar los datos del alumno
     */
    public void saveDataAlumn() {
        String phone = dataView.telephoneField.getText();
        if (!phone.isEmpty()) {
            new Alumno().updateAlumn("telefono", phone, alumno.getNumControl());
            alumno = new Alumno().getData(alumno.getNumControl());
            toaster.success("¡Genial!", "Se actualizaron los datos correctmente.");
            dataView.btnGuardar.setVisible(false);
        }

    }

}
