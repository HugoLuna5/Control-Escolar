/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar.controller.alumno;

import controlescolar.model.Alumno;
import controlescolar.model.Direccion;
import controlescolar.model.Inscripcion;
import controlescolar.view.PaymentView;
import controlescolar.view.ReferenceView;
import controlescolar.view.components.Toaster.Toaster;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hugoluna
 */
public class PaymentController {

    private PaymentView paymentView;
    private Alumno alumno;
    private Inscripcion ins;
    private Toaster toaster;
    private JDialog dialogReference;
    private ReferenceView referenceView;
    private String product[] = {"Producto", "Importe"};

    public PaymentController(PaymentView paymentView, Alumno alumno) {
        this.paymentView = paymentView;
        this.alumno = alumno;
        toaster = new Toaster(this.paymentView);

        ins = new Inscripcion();
        dialogReference = new JDialog();
        referenceView = new ReferenceView();

        validateDataView();
        setDataPayment();
        events();
    }

    public void events() {

        paymentView.btnPrintRef.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Inscripcion().create(ins, alumno);
                toaster.success("¡Genial!", "Se generara tu referencia de pago");
                setDataReferenceView();
                showViewReference();
            }
        });

        referenceView.btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ins = new Inscripcion().update("status", "1", alumno.getNumControl());
                dialogReference.setVisible(false);
                paymentView.btnPrintRef.setEnabled(false);
                paymentView.statusField.setText("Inscrito");
            }
        });

    }

    /**
     * *
     * Validar que el usuario este inscrito o no
     */
    public void validateDataView() {

        int size = new Inscripcion().getData(alumno.getNumControl()).size();
        ArrayList<Inscripcion> lista = new Inscripcion().getData(alumno.getNumControl());
        for (int i = 0; i < size; i++) {
            System.out.println(lista.get(i).getStatus());

            if (lista.get(i).getNo_Control() == alumno.getNumControl() && lista.get(i).getStatus() == 1 && lista.get(i).getSemestre() == alumno.getSemestre()) {
                paymentView.btnPrintRef.setEnabled(false);
                paymentView.statusField.setText("Inscrito");
            } else {
                paymentView.btnPrintRef.setEnabled(true);
                paymentView.statusField.setText("Inscrito");
            }

        }

    }

    /**
     * *
     * Mostrar la vista para generar la referencia
     */
    public void showViewReference() {

        dialogReference.setContentPane(referenceView);
        dialogReference.setLocationRelativeTo(null);
        dialogReference.pack();
        dialogReference.setVisible(true);
        setDataReferenceView();
    }

    /**
     * *
     * Settear los datos para solicitar la referencia
     */
    public void setDataReferenceView() {
        referenceView.lblnumControl.setText(String.valueOf(alumno.getNumControl()));
        referenceView.lblnombre.setText(alumno.getNombre());
        referenceView.lblapellidoP.setText(alumno.getApellido_p());
        referenceView.lblapellidoM.setText(alumno.getApellido_m());

        referenceView.totalField.setText(String.valueOf(ins.getPago()));

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.setColumnIdentifiers(product);

        for (int i = 0; i < new Direccion().getData(alumno.getNumControl()).size(); i++) {
            defaultTableModel.addRow(new Object[]{
                "Inscripcion",
                ins.getPago(),});

        }

        referenceView.descricpionTable.setModel(defaultTableModel);

    }

    /**
     * *
     * Settear los datos para generar la referencia de pago
     */
    public void setDataPayment() {
        paymentView.matriculaField.setText(String.valueOf(alumno.getNumControl()));
        String importe = "";
        if (alumno.getSemestre() == 1) {
            importe = "1300";
        } else {
            importe = "1000";
        }
        paymentView.paymentField.setText(importe);
        paymentView.statusField.setText("");
        ins.setNo_Control(alumno.getNumControl());
        ins.setPago(Integer.parseInt(importe));
        ins.setSemestre(alumno.getSemestre());
        ins.setStatus(0);

    }

}
