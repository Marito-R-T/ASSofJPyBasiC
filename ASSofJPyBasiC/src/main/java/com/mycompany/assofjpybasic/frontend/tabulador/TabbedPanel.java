/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.frontend.tabulador;

import com.mycompany.assofjpybasic.backend.archivos.GuardarArchivo;
import com.mycompany.assofjpybasic.frontend.NumeroLinea;
import java.io.File;

/**
 *
 * @author mari2bar
 */
public final class TabbedPanel extends javax.swing.JPanel {

    private final File[] archivo;
    private boolean compilado;

    /**
     * Creates new form TabbedPanel
     *
     * @param file
     * @param texto
     */
    public TabbedPanel(File file, String texto) {
        this.compilado = false;
        this.archivo = new File[4];
        archivo[0] = file;
        this.initComponents();
        this.arreglosExtras();
        this.panePrograma.setText(texto);
    }

    /**
     * Creates new form TabbedPanel
     */
    public TabbedPanel() {
        this.archivo = new File[4];
        this.initComponents();
        this.arreglosExtras();
    }

    /**
     * inicio de componentes y arreglos manejados a mano.
     */
    private void arreglosExtras() {
        NumeroLinea p1 = new NumeroLinea(panePrograma);
        NumeroLinea p2 = new NumeroLinea(paneCodigoT);
        NumeroLinea p3 = new NumeroLinea(paneOptimizacion);
        NumeroLinea p4 = new NumeroLinea(paneAssembler);
        this.spPrograma.setRowHeaderView(p1);
        this.spCodigoT.setRowHeaderView(p2);
        this.spOptimizacion.setRowHeaderView(p3);
        this.spAssembler.setRowHeaderView(p4);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabedGeneral = new javax.swing.JTabbedPane();
        spPrograma = new javax.swing.JScrollPane();
        panePrograma = new javax.swing.JTextPane();
        spCodigoT = new javax.swing.JScrollPane();
        paneCodigoT = new javax.swing.JTextPane();
        spOptimizacion = new javax.swing.JScrollPane();
        paneOptimizacion = new javax.swing.JTextPane();
        spAssembler = new javax.swing.JScrollPane();
        paneAssembler = new javax.swing.JTextPane();

        tabedGeneral.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tabedGeneral.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        spPrograma.setViewportView(panePrograma);

        tabedGeneral.addTab("Programa", spPrograma);

        paneCodigoT.setEditable(false);
        spCodigoT.setViewportView(paneCodigoT);

        tabedGeneral.addTab("Codigo en Tres Direcciones", spCodigoT);

        paneOptimizacion.setEditable(false);
        spOptimizacion.setViewportView(paneOptimizacion);

        tabedGeneral.addTab("Optimización", spOptimizacion);

        paneAssembler.setEditable(false);
        spAssembler.setViewportView(paneAssembler);

        tabedGeneral.addTab("Assembler", spAssembler);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabedGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabedGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * metodo que sirve para cambiar archivo en uso. (GuardarComo)
     *
     * @param file
     */
    public void cambiarArchivo(File file) {
        this.archivo[0] = file;
    }

    /**
     * llama a GuardarArchivo a guardar un documento ya existente, y le asigna
     * su extensión
     *
     * @param guardado objeto de transferencia de ASSGUI, para que maneje el
     * guardado
     */
    public void guardarArchivo(GuardarArchivo guardado) {
        switch (tabedGeneral.getSelectedIndex()) {
            case 0:
                if (archivo[0] == null) {
                    guardarComoArchivo(guardado);
                } else {
                    guardado.guardarTexto(archivo[0], panePrograma.getText());
                }
                break;
            case 1:
                if (archivo[1] == null && compilado) {
                    guardarComoArchivo(guardado);
                } else {
                    guardado.guardarTexto(archivo[1], paneCodigoT.getText());
                }
                break;
            case 2:
                if (archivo[2] == null && compilado) {
                    guardarComoArchivo(guardado);
                } else {
                    guardado.guardarTexto(archivo[2], paneOptimizacion.getText());
                }
                break;
            case 3:
                if (archivo[3] == null && compilado) {
                    guardarComoArchivo(guardado);
                } else {
                    guardado.guardarTexto(archivo[3], paneAssembler.getText());
                }
                break;
        }
    }

    /**
     * llama a GuardarArchivo a guardar un documento de nuevo, y le asigna su
     * extensión
     *
     * @param guardado objeto de transferencia de ASSGUI, para que maneje el
     * guardado
     */
    public void guardarComoArchivo(GuardarArchivo guardado) {
        switch (tabedGeneral.getSelectedIndex()) {
            case 0:
                archivo[0] = guardado.guardarComo(panePrograma.getText(), ".mlg", "Lenguaje de JPyBasiC");
                break;
            case 1:
                if (compilado) {
                    archivo[1] = guardado.guardarComo(paneCodigoT.getText(), ".cpp", "Codigo en 3 Direcciones");
                }
                break;
            case 2:
                if (compilado) {
                    archivo[2] = guardado.guardarComo(paneOptimizacion.getText(), ".cpp", "3 Direcciones Optimizado");
                }
                break;
            case 3:
                if (compilado) {
                    archivo[3] = guardado.guardarComo(paneAssembler.getText(), ".asm", "Codigo en Assembler");
                }
                break;
        }
    }

    public void setCompilado(boolean compilado) {
        this.compilado = compilado;
    }

    public File[] getArchivo() {
        return archivo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane paneAssembler;
    private javax.swing.JTextPane paneCodigoT;
    private javax.swing.JTextPane paneOptimizacion;
    private javax.swing.JTextPane panePrograma;
    private javax.swing.JScrollPane spAssembler;
    private javax.swing.JScrollPane spCodigoT;
    private javax.swing.JScrollPane spOptimizacion;
    private javax.swing.JScrollPane spPrograma;
    private javax.swing.JTabbedPane tabedGeneral;
    // End of variables declaration//GEN-END:variables
}
