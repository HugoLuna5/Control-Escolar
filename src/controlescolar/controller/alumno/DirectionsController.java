/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar.controller.alumno;

import controlescolar.model.Direccion;
import controlescolar.view.AddAddressView;
import controlescolar.view.DirectionsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hugoluna
 */
public class DirectionsController {
    private DirectionsView directionsView;
    private AddAddressView addressView;

    
    
    public DirectionsController(DirectionsView directionsView) {
        this.directionsView = directionsView;
        
         addressView = new AddAddressView();
         events();
    }
    
    
    
    
    
    public void events(){
        
         directionsView.btnAddDirection.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 showViewAddDirection();
             }
         });
       
        
    }
    
    
     /***
     * Mostrar vista para agregar direccion
     */
    public void showViewAddDirection(){
        JDialog dialogAddDirections = new JDialog();

       
        dialogAddDirections.setContentPane(addressView);
        new AddressController(addressView);
        dialogAddDirections.setLocationRelativeTo(null);
        dialogAddDirections.pack();
        dialogAddDirections.setVisible(true);
    }
   
    
}
