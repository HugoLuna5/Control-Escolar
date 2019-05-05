/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar.controller.admin;

import controlescolar.model.Administrador;
import controlescolar.view.RegistroAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author hugoluna
 */
public class RegistroAdminController {
    
    private RegistroAdmin registroAdmin;

    public RegistroAdminController(RegistroAdmin registroAdmin) {
        this.registroAdmin = registroAdmin;
        events();
    }
    
    public void events(){
        registroAdmin.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                createAdmin();
            }
        });
    }
    
     /**
     * *
     * Funcion para crear un nuevo Admin
     */
    public void createAdmin() {

        try {
            String nombre = registroAdmin.nombre.getText();
            String apellidoP = registroAdmin.apellido_p.getText();
            String apellidoM = registroAdmin.apellidoM.getText();
            String usuario = registroAdmin.usuario.getText();
            String contrasena = registroAdmin.contrasena.getText();

            Administrador admin = new Administrador();
            admin.setNombre(nombre);
            admin.setApellido_p(apellidoP);
            admin.setApellido_m(apellidoM);
            admin.setUsuario(usuario);
            admin.setPassword(contrasena);

            if (new Administrador().createAdmin(admin)) {
                limpiarCamposAdmin();
                JOptionPane.showMessageDialog(registroAdmin, "se registro el administrador");

            } else {
                JOptionPane.showMessageDialog(registroAdmin, "error al registrarse ");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    
    /**
     * *
     * Limpiar campos de la vista de Admin
     */
    public void limpiarCamposAdmin() {
        registroAdmin.nombre.setText(null);
        registroAdmin.apellido_p.setText(null);
        registroAdmin.apellidoM.setText(null);
        registroAdmin.usuario.setText(null);
        registroAdmin.contrasena.setText(null);

    }
    
    
    
}
