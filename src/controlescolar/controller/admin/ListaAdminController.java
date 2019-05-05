/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar.controller.admin;

import controlescolar.model.Administrador;
import controlescolar.view.ListaAdmin;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hugoluna
 */
public class ListaAdminController {
    
    private ListaAdmin listaAmin;
    
    private String cabeceraAdmin[] = {
        "Nombre", "Apellido P.", "Apellido M.", "Usuario"
    };

    public ListaAdminController(ListaAdmin listaAmin) {
        this.listaAmin = listaAmin;
        cargarDatosTablaAdmin();
    }
    
    
    /**
     * Mostrar los datos en la tabla de Admin
     */
    public void cargarDatosTablaAdmin() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabeceraAdmin);

        //  "Telefono", "Sexo", "Carrera"
        for (int i = 0; i < new Administrador().obtenerTodo().size(); i++) {

            modelo.addRow(new Object[]{
                new Administrador().obtenerTodo().get(i).getNombre(),
                new Administrador().obtenerTodo().get(i).getApellido_p(),
                new Administrador().obtenerTodo().get(i).getApellido_m(),
                new Administrador().obtenerTodo().get(i).getUsuario()

            });

        }

        listaAmin.tablaAdmins.setModel(modelo);

        for (int i = 0; i < cabeceraAdmin.length; i++) {
            listaAmin.tablaAdmins.getColumnModel().getColumn(i).setPreferredWidth(160);

        }

    }
    
    
    
}
