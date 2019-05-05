/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar.controller.alumno;

import controlescolar.controller.admin.AdminLoginController;
import controlescolar.model.Alumno;
import controlescolar.model.Login;
import controlescolar.view.HomeView;
import controlescolar.view.LoginView;
import controlescolar.view.components.Toaster.Toaster;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hugoluna
 */
public class LoginController implements ActionListener {

    //variales globales
    private LoginView loginView;
    private Toaster toaster;

    
    /***
     * Constructor de la clase
     * @param loginView 
     */
    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.loginView.btnEntrar.addActionListener(this);
        this.loginView.btnResetPass.addActionListener(this);
        this.loginView.btnActionHelp.addActionListener(this);
        this.loginView.btnRegistrar.addActionListener(this);
        this.loginView.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginView.btnEntrar) {

            actionBtnEntrar();

        } else if (e.getSource() == loginView.btnRegistrar) {
            actionBtnRegister();
        } else if (e.getSource() == loginView.btnResetPass) {
            actionResetPass();
        } else if (e.getSource() == loginView.btnActionHelp) {
            actionHelp();
        } 

    }

    /***
     * Accion pata el boton Entrar
     */
    public void actionBtnEntrar() {
        
        //se extrae el texto de los campos en la vista
        String numControl = loginView.numField.getText().toString();
        String password = loginView.passField.getText().toString();
        //inicializar vista para avisos en la vista
        toaster = new Toaster(this.loginView.mainContainer);
        
        //validar que no sean vacios los valores
        if (!numControl.isEmpty() && !password.isEmpty()) {
            
           
            Alumno alumno = new Alumno();
            alumno.setNumControl(Integer.parseInt(numControl));
            alumno.setPassword(password);
            
            /**
             * Esperar respuesta de la BD
             *
             */
            if (new Login().loginAlumn(alumno)) {
                toaster.success("¡Genial!", "Has ingresado correctamente");

                savePreferences(String.valueOf(alumno.getNumControl()));

                this.loginView.setVisible(false);//hacer la vista invisible
                //llamar al controlador el cual lanzara la siguiente vista
                new HomeController(new Alumno().getData(alumno.getNumControl()), new HomeView());

            } else {//en caso de que suceda un error, informarle al usuario que esta pasando
                toaster.error("¡Ups ocurrio un error!", "Es posible que los datos no existan en nuestros registros");

            }

        } else {
            toaster.info("¡Ups!.", "Debes llenar los campos para ingresar");

        }
    }

    /***
     * Accion del boton registrar
     * el cual lanza la interfaz para el Admin
     */
    public void actionBtnRegister() {
        this.loginView.setVisible(false);
        new AdminLoginController(new LoginView());
            
        
    }

    /***
     * Accion para resetear la contraseña
     */
    public void actionResetPass() {
        

    }

    
    /***
     * Accion para solicitar ayuda
     */
    public void actionHelp() {
        try {
            Desktop.getDesktop().browse(new URI("https://google.com"));
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /***
     * Guardar los datos de los alumnos en las preferencias
     * @param id 
     */
    public void savePreferences(String id) {

        Preferences prefs = Preferences.userNodeForPackage(controlescolar.controller.alumno.LoginController.class);
        final String PREF_NAME = "id";
        final String PREF_TYPE = "type";
        
        prefs.put(PREF_NAME, id);
        prefs.put(PREF_TYPE, "alumno");

    }
    
    
    
    
    
    

}
