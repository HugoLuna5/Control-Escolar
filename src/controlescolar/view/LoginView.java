/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar.view;

import controlescolar.utils.GUIState;
import controlescolar.view.components.PanelBackgroundImage;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.shadows.DropShadowBorder;
import mdlaf.utils.MaterialBorders;
import mdlaf.utils.MaterialColors;

/**
 *
 * @author hugoluna
 */
public class LoginView extends javax.swing.JFrame {

    private GUIState lookManager;

    /**
     * Creates new form LoginView
     */
    public LoginView() {
        initComponents();
        configViews();

    }

    /**
     * Configuraciones a componentes de la vista
     *
     */
    public void configViews() {
        lookManager = GUIState.getInstance();

        /**
         * Setear colores a los elementos
         *
         */
        containerElements.setBackground(MaterialColors.BLUE_500);
        btnEntrar.setBackground(MaterialColors.CYAN_500);
        btnEntrar.setForeground(Color.white);
        textPrincipal.setBackground(MaterialColors.BLUE_500);
        textNum.setBackground(MaterialColors.BLUE_500);
        textPass.setBackground(MaterialColors.BLUE_500);
        numField.setBackground(MaterialColors.BLUE_500);
        passField.setBackground(MaterialColors.BLUE_500);
        btnResetPass.setBackground(MaterialColors.BLUE_500);
        btnActionHelp.setBackground(MaterialColors.BLUE_500);
        btnRegistrar.setBackground(MaterialColors.BLUE_500);
        containerElements.setBorder(MaterialBorders.LIGHT_LINE_BORDER);

        MaterialUIMovement.add(btnEntrar, MaterialColors.CYAN_300);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainContainer = new PanelBackgroundImage();
        containerElements = new javax.swing.JPanel();
        textPrincipal = new javax.swing.JLabel();
        numField = new javax.swing.JTextField();
        textNum = new javax.swing.JLabel();
        textPass = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnResetPass = new javax.swing.JButton();
        btnActionHelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión");
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 700));

        containerElements.setBackground(new java.awt.Color(51, 153, 255));
        containerElements.setMaximumSize(new java.awt.Dimension(400, 700));
        containerElements.setPreferredSize(new java.awt.Dimension(400, 700));
        containerElements.setRequestFocusEnabled(false);

        textPrincipal.setBackground(new java.awt.Color(51, 153, 255));
        textPrincipal.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        textPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        textPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textPrincipal.setText("INCIAR SESIÓN");
        textPrincipal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        numField.setBackground(new java.awt.Color(51, 153, 255));
        numField.setForeground(new java.awt.Color(255, 255, 255));
        numField.setToolTipText("Numero de control");
        numField.setCaretColor(new java.awt.Color(255, 255, 255));
        numField.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        numField.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        numField.setSelectionColor(new java.awt.Color(255, 255, 255));

        textNum.setBackground(new java.awt.Color(51, 153, 255));
        textNum.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        textNum.setForeground(new java.awt.Color(255, 255, 255));
        textNum.setText("Número de control");

        textPass.setBackground(new java.awt.Color(51, 153, 255));
        textPass.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        textPass.setForeground(new java.awt.Color(255, 255, 255));
        textPass.setText("Contraseña");
        textPass.setMaximumSize(new java.awt.Dimension(190, 30));
        textPass.setMinimumSize(new java.awt.Dimension(190, 30));
        textPass.setPreferredSize(new java.awt.Dimension(190, 30));
        textPass.setSize(new java.awt.Dimension(190, 30));

        passField.setBackground(new java.awt.Color(51, 153, 255));
        passField.setForeground(new java.awt.Color(255, 255, 255));
        passField.setCaretColor(new java.awt.Color(255, 255, 255));
        passField.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        passField.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        passField.setSelectionColor(new java.awt.Color(255, 255, 255));

        btnEntrar.setText("ENTRAR");

        btnRegistrar.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Administrador");

        btnResetPass.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        btnResetPass.setForeground(new java.awt.Color(255, 255, 255));
        btnResetPass.setText("¿Olvidaste tu contraseña?");

        btnActionHelp.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnActionHelp.setForeground(new java.awt.Color(255, 255, 255));
        btnActionHelp.setText("Ayuda");

        javax.swing.GroupLayout containerElementsLayout = new javax.swing.GroupLayout(containerElements);
        containerElements.setLayout(containerElementsLayout);
        containerElementsLayout.setHorizontalGroup(
            containerElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerElementsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(containerElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerElementsLayout.createSequentialGroup()
                            .addComponent(textPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerElementsLayout.createSequentialGroup()
                            .addComponent(numField, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)))
                    .addGroup(containerElementsLayout.createSequentialGroup()
                        .addGroup(containerElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(containerElementsLayout.createSequentialGroup()
                                .addComponent(btnActionHelp)
                                .addGap(84, 84, 84)
                                .addComponent(btnRegistrar))
                            .addGroup(containerElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textNum, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textPass, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, containerElementsLayout.createSequentialGroup()
                                .addComponent(btnResetPass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))))
        );
        containerElementsLayout.setVerticalGroup(
            containerElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerElementsLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(textPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(textNum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(textPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(containerElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetPass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addGroup(containerElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnActionHelp))
                .addContainerGap())
        );

        javax.swing.GroupLayout mainContainerLayout = new javax.swing.GroupLayout(mainContainer);
        mainContainer.setLayout(mainContainerLayout);
        mainContainerLayout.setHorizontalGroup(
            mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainContainerLayout.createSequentialGroup()
                .addGap(0, 800, Short.MAX_VALUE)
                .addComponent(containerElements, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainContainerLayout.setVerticalGroup(
            mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerElements, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActionHelp;
    public javax.swing.JButton btnEntrar;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JButton btnResetPass;
    private javax.swing.JPanel containerElements;
    public javax.swing.JPanel mainContainer;
    public javax.swing.JTextField numField;
    public javax.swing.JPasswordField passField;
    public javax.swing.JLabel textNum;
    private javax.swing.JLabel textPass;
    public javax.swing.JLabel textPrincipal;
    // End of variables declaration//GEN-END:variables
}
