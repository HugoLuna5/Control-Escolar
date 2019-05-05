/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar.controller.admin;

import controlescolar.controller.alumno.LoginController;
import controlescolar.model.Administrador;
import controlescolar.model.Alumno;
import controlescolar.view.AdminHomeView;
import controlescolar.view.DatosAlumno;
import controlescolar.view.ListaAdmin;
import controlescolar.view.ListaAlumnos;
import controlescolar.view.LoginView;
import controlescolar.view.RegistroAdmin;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gustavo
 */
public class AdminHomeController {

    //variables globales
    private AdminHomeView adminHomeView;
    private Administrador administrador;
    private DatosAlumno datosAlumno;
    
    private RegistroAdmin registroAdmin;
    private ListaAlumnos listaAlumnos;
    private ListaAdmin listaAdmin;
   
    

    /**
     * *
     * Constructor de la clase el cual recibe un objeto de tipo Administrador, y
     * la vista AdminHomeView
     *
     * @param adminHomeView
     * @param administrador
     */
    public AdminHomeController(AdminHomeView adminHomeView, Administrador administrador) {
        this.adminHomeView = adminHomeView;
        this.administrador = administrador;
        this.adminHomeView.setVisible(true);
        datosAlumno = new DatosAlumno();
        registroAdmin = new RegistroAdmin();
        listaAlumnos = new ListaAlumnos();
        listaAdmin = new ListaAdmin();

       
        adminHomeView.contenedor.setLayout(new BorderLayout());

        events();
        showRegisterAlumnoView();
        
        adminHomeView.btnRegisterAlumn.doClick();
        
    }
    
    /**
     * Eventos
     */
    public void events(){
        
        adminHomeView.btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePreferences();
                goToLogin();
            }
        });
        adminHomeView.btnRegisterAlumn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegisterAlumnoView();
            }
        });
        adminHomeView.btnRegisterAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegisterAdminView();
            }
        });
        adminHomeView.btnShowAlumn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarListaAlumnos();
            }
        });
        adminHomeView.btnShowAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarListaAdministradores();
            }
        });
        
        
    }


    /**
     * *
     * Mostrar la vista para el registro del alumno
     */
    public void showRegisterAlumnoView() {

        quitarVistas();
        new DatosAlumnoController(datosAlumno);
        this.adminHomeView.contenedor.add(datosAlumno);

    }

    /**
     * Mostrar la lista de todos los alumnos registrados
     */
    public void mostrarListaAlumnos() {
        quitarVistas();
        new ListaAlumnoController(listaAlumnos);
        this.adminHomeView.contenedor.add(listaAlumnos);
        //cargarDatosTablaAlum();
    }

    /**
     * Mostrar la lista de todos los Admin registrados
     */
    public void mostrarListaAdministradores() {
        quitarVistas();
        new ListaAdminController(listaAdmin);
        this.adminHomeView.contenedor.add(listaAdmin);
    }

    /**
     * Mostrar la vista para registrar un nuevo Admin
     */
    public void showRegisterAdminView() {
        quitarVistas();
        new RegistroAdminController(registroAdmin);
        this.adminHomeView.contenedor.add(registroAdmin);
    }

    /**
     * *
     * Remover las vistas que se encuentren activas en el contenedor
     */
    public void quitarVistas() {
        this.adminHomeView.contenedor.remove(datosAlumno);
        this.adminHomeView.contenedor.remove(registroAdmin);
        this.adminHomeView.contenedor.remove(listaAlumnos);
        this.adminHomeView.contenedor.remove(listaAdmin);
        this.adminHomeView.contenedor.revalidate();
        this.adminHomeView.contenedor.repaint();

    }

    /**
     * *
     * Eliminar preferencias
     */
    public void deletePreferences() {

        Preferences prefs = Preferences.userNodeForPackage(controlescolar.controller.alumno.LoginController.class);
        final String PREF_NAME = "id";
        final String PREF_TYPE = "type";
        prefs.put(PREF_NAME, "default");
        prefs.put(PREF_TYPE, "default");
    }

    /**
     * Ir al inicio de sesion
     */
    public void goToLogin() {
        this.adminHomeView.setVisible(false);
        new LoginController(new LoginView());
    }

   
    

    
    
}
