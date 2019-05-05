/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar.controller.alumno;

import controlescolar.controller.alumno.LoginController;
import controlescolar.model.Administrador;
import controlescolar.model.Alumno;
import controlescolar.model.Carrera;
import controlescolar.model.Direccion;
import controlescolar.model.Inscripcion;
import controlescolar.view.AddAddressView;
import controlescolar.view.DataView;
import controlescolar.view.DirectionsView;
import controlescolar.view.HomeView;
import controlescolar.view.LoginView;
import controlescolar.view.PaymentView;
import controlescolar.view.ReferenceView;
import controlescolar.view.components.Toaster.Toaster;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.prefs.Preferences;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

/**
 *
 * @author gustavo
 */
public class HomeController {

    //variables globales
    private Alumno alumno;
    private HomeView homeView;
    private DataView dataView;
    private PaymentView paymentView;
    private Toaster toaster;

    /**
     * *
     * Constructor de la clase el cual espera un objeto de tipo Alumno y la
     * vista a mostrar
     *
     * @param alumno
     * @param homeView
     */
    public HomeController(Alumno alumno, HomeView homeView) {
        this.alumno = alumno;
        this.homeView = homeView;
        this.homeView.setVisible(true);
        this.homeView.containerBody.setLayout(new BorderLayout());
        initVars();

        initEvents();

        setData();
        
        
        

    }

    /**
     * Inicializar las variables
     */
    public void initVars() {
        dataView = new DataView();
        paymentView = new PaymentView();
        toaster = new Toaster(this.homeView.containerBody);
        this.homeView.btnHome.doClick();
        addPanelInfo();
    }

    /**
     * *
     * Settear los datos principales en la vista
     */
    public void setData() {
        this.homeView.labelName.setText(alumno.getNombre() + " " + alumno.getApellido_p() + " " + alumno.getApellido_m());
        this.homeView.labelNumControl.setText(String.valueOf(alumno.getNumControl()));
        this.homeView.labelIcon.setText(alumno.getFirstLetter(alumno.getNombre()) + "" + alumno.getFirstLetter(alumno.getApellido_p()));
        

    }

   
   
    
    
     /**
     * *
     * Inicializar los eventos
     */
    public void initEvents() {
        
      
        this.homeView.btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPanelInfo();
            }
        });
        this.homeView.btnReinscribir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewReinscribir();
            }
        });
        this.homeView.btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePreferences();
                goToLogin();
            }
        });
        this.homeView.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 modificar();
            }
        });
       

        
    }

   
    /**
     * Desbloquear los componentes en la vista para que se puedan editar y
     * actualizar
     */
    public void modificar() {
        dataView.nameField.setEditable(true);
        dataView.apField.setEditable(true);
        dataView.amField.setEditable(true);
        dataView.fechaNacField.setEnabled(true);
        dataView.sexField.setEditable(true);
        dataView.curpField.setEditable(true);
        dataView.nacimientoField.setEditable(true);
        dataView.carreraField.setEditable(true);
        dataView.telephoneField.setEditable(true);
        dataView.btnGuardar.setVisible(true);

        String nombre = dataView.nameField.getText();
        String apellidoP = dataView.apField.getText();
        String apellidoM = dataView.amField.getText();
        String fechaNacimiento = dataView.fechaNacField.getText();
        String sexo = dataView.sexField.getSelectedItem().toString();
        String curp = dataView.curpField.getText();
        String lugarNAcimiento = dataView.nacimientoField.getText();

        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setApellido_p(apellidoP);
        alumno.setApellido_m(apellidoM);
        alumno.setFecha_nacimiento(fechaNacimiento);
        alumno.setSexo(sexo);
        alumno.setCurp(curp);
        alumno.setLugar_nacimiento(lugarNAcimiento);

    }

    /**
     * Mostrar la vista para reinscribir
     */
    public void viewReinscribir() {
        deleteAllViewsContainer();
        new PaymentController(paymentView, alumno);
        this.homeView.containerBody.add(paymentView);
    }

    
    /**
     * *
     * Agregar el panel de la informacion
     */
    public void addPanelInfo() {
        deleteAllViewsContainer();
        new DatosAlumnoController(dataView, alumno);
        this.homeView.containerBody.add(dataView);

    }

    /**
     * *
     * Eliminar la preferencia en las cuales se guardan los datos del alumno
     * simulando una sesion
     */
    public void deletePreferences() {

        Preferences prefs = Preferences.userNodeForPackage(controlescolar.controller.alumno.LoginController.class);
        final String PREF_NAME = "num_control";
        prefs.put(PREF_NAME, "default");

    }

    /**
     * *
     * Ir a la pantalla de inicio
     */
    public void goToLogin() {
        this.homeView.setVisible(false);
        new LoginController(new LoginView());
    }

    /**
     * *
     * Eliminar las vistas del contenedor "ContainerBody"
     */
    public void deleteAllViewsContainer() {
        this.homeView.containerBody.remove(dataView);
        this.homeView.containerBody.remove(paymentView);
        this.homeView.containerBody.revalidate();
        this.homeView.containerBody.repaint();
    }
}
