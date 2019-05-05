/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar;

import controlescolar.controller.admin.AdminHomeController;
import controlescolar.controller.alumno.HomeController;
import controlescolar.controller.alumno.LoginController;
import controlescolar.model.Administrador;
import controlescolar.model.Alumno;
import controlescolar.view.AdminHomeView;
import controlescolar.view.HomeView;
import controlescolar.view.LoginView;
import java.util.prefs.Preferences;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mdlaf.MaterialLookAndFeel;

/**
 *
 * @author hugoluna
 */
public class ControlEscolar {

    public String ID = "";
    public String type = "";

    public ControlEscolar() {
        initMaterialDesign();
        launchScreen();

    }

    public void initMaterialDesign() {

        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());

        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new ControlEscolar();

    }

    public void launchScreen() {
        if (getSessionID() && getSessionType()) {
            
            
            if (type.equals("alumno")) {
                 new HomeController(new Alumno().getData(Integer.parseInt(ID)), new HomeView());
                
            }else{
                new AdminHomeController(new AdminHomeView(), new Administrador().getData(ID));
            }
            
           

        } else {

            new LoginController(new LoginView());
        }
    }

    public boolean getSessionID() {
        Preferences prefs = Preferences.userNodeForPackage(controlescolar.controller.alumno.LoginController.class);
        final String PREF_NAME = "id";
        String defaultValue = "default";
        
        String id = prefs.get(PREF_NAME, defaultValue);

        boolean val = false;
        if (!id.equals("default")) {
            val = true;
            ID = id;
        }

        return val;

    }
    
    public boolean getSessionType() {
        Preferences prefs = Preferences.userNodeForPackage(controlescolar.controller.alumno.LoginController.class);
        final String PREF_TYPE = "type";
        String defaultValueType = "default";
        
        String type = prefs.get(PREF_TYPE, defaultValueType);

        boolean val = false;
        if (!type.equals("default")) {
            val = true;
            this.type = type;
        }

        return val;

    }
    
    
    

}
