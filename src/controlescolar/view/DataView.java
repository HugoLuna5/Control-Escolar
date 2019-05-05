/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar.view;

import java.awt.Color;
import javax.swing.JPanel;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

/**
 *
 * @author hugoluna
 */
public class DataView extends JPanel {

    /**
     * Creates new form DataView
     */
    public DataView() {
        initComponents();
        configViews();
        
    }

    
    public void configViews(){
        
        //fechaNacField.setEnabled(false);
        btnViewDirections.setBackground(MaterialColors.CYAN_500);
        btnViewDirections.setForeground(Color.white);
        
        
        
        MaterialUIMovement.add(btnViewDirections, MaterialColors.CYAN_400);
        MaterialUIMovement.add(btnGuardar, MaterialColors.GRAY_400);
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainContainer = new javax.swing.JPanel();
        textName = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        textAP = new javax.swing.JLabel();
        apField = new javax.swing.JTextField();
        textSex = new javax.swing.JLabel();
        amField = new javax.swing.JTextField();
        textAM1 = new javax.swing.JLabel();
        fechaNacField = new com.github.lgooddatepicker.components.DatePicker();
        textAM2 = new javax.swing.JLabel();
        sexField = new javax.swing.JComboBox<>();
        textCurp = new javax.swing.JLabel();
        curpField = new javax.swing.JTextField();
        textCurp1 = new javax.swing.JLabel();
        nacimientoField = new javax.swing.JTextField();
        textCurp2 = new javax.swing.JLabel();
        textCurp3 = new javax.swing.JLabel();
        btnViewDirections = new javax.swing.JButton();
        textTelephone = new javax.swing.JLabel();
        carreraField = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        telephoneField = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(920, 480));
        setMinimumSize(new java.awt.Dimension(920, 480));
        setPreferredSize(new java.awt.Dimension(920, 480));

        mainContainer.setBackground(new java.awt.Color(255, 255, 255));
        mainContainer.setMaximumSize(new java.awt.Dimension(920, 480));
        mainContainer.setMinimumSize(new java.awt.Dimension(920, 480));
        mainContainer.setPreferredSize(new java.awt.Dimension(920, 480));

        textName.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        textName.setText("Nombre: ");

        nameField.setEditable(false);

        textAP.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        textAP.setText("Apellido P.");

        apField.setEditable(false);

        textSex.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        textSex.setText("Sexo");

        amField.setEditable(false);

        textAM1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        textAM1.setText("Fecha de Nacimiento");

        textAM2.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        textAM2.setText("Apellido M.");

        sexField.setEditable(true);
        sexField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", " " }));
        sexField.setEnabled(false);

        textCurp.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        textCurp.setText("Curp");

        curpField.setEditable(false);

        textCurp1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        textCurp1.setText("Lugar de nacimiento");

        nacimientoField.setEditable(false);

        textCurp2.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        textCurp2.setText("Carrera");

        textCurp3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        textCurp3.setText("Dirección");

        btnViewDirections.setText("Ver direcciones");

        textTelephone.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        textTelephone.setText("Telefono");

        carreraField.setEditable(false);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        telephoneField.setEditable(false);

        javax.swing.GroupLayout mainContainerLayout = new javax.swing.GroupLayout(mainContainer);
        mainContainer.setLayout(mainContainerLayout);
        mainContainerLayout.setHorizontalGroup(
            mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainContainerLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainContainerLayout.createSequentialGroup()
                            .addComponent(textCurp1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nacimientoField, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainContainerLayout.createSequentialGroup()
                            .addComponent(textAM2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(amField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainContainerLayout.createSequentialGroup()
                            .addComponent(textAP, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(apField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainContainerLayout.createSequentialGroup()
                            .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainContainerLayout.createSequentialGroup()
                            .addComponent(textAM1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(fechaNacField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(mainContainerLayout.createSequentialGroup()
                                .addComponent(textCurp, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(curpField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainContainerLayout.createSequentialGroup()
                                .addComponent(textSex, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sexField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(mainContainerLayout.createSequentialGroup()
                        .addGroup(mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textCurp3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textCurp2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnViewDirections, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telephoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainContainerLayout.createSequentialGroup()
                    .addGap(149, 149, 149)
                    .addComponent(carreraField, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(376, Short.MAX_VALUE)))
        );
        mainContainerLayout.setVerticalGroup(
            mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainContainerLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textAP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(apField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textAM2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainContainerLayout.createSequentialGroup()
                        .addComponent(textAM1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sexField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textSex, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainContainerLayout.createSequentialGroup()
                        .addComponent(fechaNacField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textCurp, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(curpField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textCurp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nacimientoField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textCurp2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textCurp3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnViewDirections, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telephoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainContainerLayout.createSequentialGroup()
                    .addContainerGap(332, Short.MAX_VALUE)
                    .addComponent(carreraField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(113, 113, 113)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField amField;
    public javax.swing.JTextField apField;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnViewDirections;
    public javax.swing.JTextField carreraField;
    public javax.swing.JTextField curpField;
    public com.github.lgooddatepicker.components.DatePicker fechaNacField;
    private javax.swing.JPanel mainContainer;
    public javax.swing.JTextField nacimientoField;
    public javax.swing.JTextField nameField;
    public javax.swing.JComboBox<String> sexField;
    public javax.swing.JTextField telephoneField;
    private javax.swing.JLabel textAM1;
    private javax.swing.JLabel textAM2;
    private javax.swing.JLabel textAP;
    private javax.swing.JLabel textCurp;
    private javax.swing.JLabel textCurp1;
    private javax.swing.JLabel textCurp2;
    private javax.swing.JLabel textCurp3;
    private javax.swing.JLabel textName;
    private javax.swing.JLabel textSex;
    private javax.swing.JLabel textTelephone;
    // End of variables declaration//GEN-END:variables
}
