/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar.controller.admin;

import controlescolar.controller.alumno.LoginController;
import controlescolar.model.Administrador;
import controlescolar.model.Alumno;
import controlescolar.model.Login;
import controlescolar.view.AdminHomeView;
import controlescolar.view.HomeView;
import controlescolar.view.LoginView;
import controlescolar.view.components.Toaster.Toaster;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

/**
 *
 * @author hugoluna
 */
public class AdminLoginController implements ActionListener {

    //variables globales
    private LoginView loginView;
    private Toaster toaster;

    /**
     * *
     * Constructor de la clase la cual recibe una vista de tipo LoginView
     *
     * @param loginView
     */
    public AdminLoginController(LoginView loginView) {
        this.loginView = loginView;
        this.loginView.setVisible(true);
        this.loginView.textPrincipal.setText("Administrador");
        this.loginView.setTitle("Ingresar como administrador");
        this.loginView.textNum.setText("Usuario");
        this.loginView.textNum.setToolTipText("Usuario");
        this.loginView.btnEntrar.addActionListener(this);
        this.loginView.btnRegistrar.setText("Alumno");
        this.loginView.btnRegistrar.addActionListener(this);

    }

    /**
     * *
     * Eventos
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginView.btnEntrar) {
            btnLogin();
        }

        if (e.getSource() == loginView.btnRegistrar) {
            goToLoginAlumno();
        }

    }

    /**
     * *
     * Accion para el inicio de sesion
     */
    public void btnLogin() {
        try {
            String usuario = loginView.numField.getText().toString();
            String password = loginView.passField.getText().toString();
            toaster = new Toaster(this.loginView.mainContainer);
            if (!usuario.isEmpty() && !password.isEmpty()) {

                Administrador admin = new Administrador();
                admin.setUsuario(usuario);
                admin.setPassword(password);

                /**
                 * Esperar respuesta de la BD
                 *
                 */
                if (new Login().loginAdmin(admin)) {
                    toaster.success("¡Genial!", "Has ingresado correctamente");

                    savePreferences(String.valueOf(admin.getUsuario()));

                    this.loginView.setVisible(false);
                    System.out.println("Go To Admin Home");
                    new AdminHomeController(new AdminHomeView(), new Administrador().getData(usuario));

                } else {
                    toaster.error("¡Ups ocurrio un error!", "Es posible que los datos no existan en nuestros registros");

                }

            } else {
                toaster.info("¡Ups!.", "Debes llenar los campos para ingresar");

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     * *
     * Ir al inicio de sesion para el alumno
     */
    public void goToLoginAlumno() {

        this.loginView.setVisible(false);
        new LoginController(new LoginView());

    }

    /**
     * *
     * Guardar las preferencias del usuario simulando una sesion
     *
     * @param id
     */
    public void savePreferences(String id) {

        Preferences prefs = Preferences.userNodeForPackage(controlescolar.controller.alumno.LoginController.class);
        final String PREF_NAME = "id";
        final String PREF_TYPE = "type";

        prefs.put(PREF_NAME, id);
        prefs.put(PREF_TYPE, "admin");

    }

}
