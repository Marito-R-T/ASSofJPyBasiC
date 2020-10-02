/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.frontend;

import com.mycompany.assofjpybasic.backend.archivos.AperturaMLG;
import com.mycompany.assofjpybasic.backend.archivos.GuardarArchivo;
import com.mycompany.assofjpybasic.frontend.tabulador.TabbedPanel;
import java.io.File;
import javax.swing.JScrollPane;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class AssGUI extends javax.swing.JFrame {

    private final AperturaMLG apertura;
    private final GuardarArchivo guardar;
    private File abierto;

    /**
     * Creates new form AssGUI
     */
    public AssGUI() {
        this.initComponents();
        this.arreglosExtras();
        apertura = new AperturaMLG();
        guardar = new GuardarArchivo();
    }

    /**
     * inicio de componentes y arreglos manejados a mano.
     */
    private void arreglosExtras() {
        this.setLocationRelativeTo(null);
        this.setTitle("JPyBasiC");
        Document doc = AssGUI.editorTerminal.getDocument();
        if (doc instanceof PlainDocument) {
            doc.putProperty(PlainDocument.tabSizeAttribute, 2);
            System.out.println("hola");
        }
        /*NumeroLinea p1 = new NumeroLinea(panePrograma);
        NumeroLinea p2 = new NumeroLinea(paneTresD);
        NumeroLinea p3 = new NumeroLinea(paneOptimizacion);
        NumeroLinea p4 = new NumeroLinea(paneAssembler);
        this.spPrograma.setRowHeaderView(p1);
        this.spTresDirecciones.setRowHeaderView(p2);
        this.spOptimizacion.setRowHeaderView(p3);
        this.spAssembler.setRowHeaderView(p4);*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        splitPrincipal = new javax.swing.JSplitPane();
        tabbedArchivo = new javax.swing.JTabbedPane();
        spTerminal = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemAbrir = new javax.swing.JMenuItem();
        itemGuardar = new javax.swing.JMenuItem();
        itemGuardarComo = new javax.swing.JMenuItem();
        itemCerrar = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();
        menuCodigo = new javax.swing.JMenu();
        menuEjecutar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        splitPrincipal.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        tabbedArchivo.setMinimumSize(new java.awt.Dimension(895, 500));
        splitPrincipal.setTopComponent(tabbedArchivo);

        spTerminal.setViewportView(editorTerminal);

        splitPrincipal.setRightComponent(spTerminal);

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(splitPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(splitPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuArchivo.setText("Archivo");

        itemNuevo.setText("Nuevo");
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        menuArchivo.add(itemNuevo);

        itemAbrir.setText("Abrir");
        itemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAbrirActionPerformed(evt);
            }
        });
        menuArchivo.add(itemAbrir);

        itemGuardar.setText("Guardar");
        itemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarActionPerformed(evt);
            }
        });
        menuArchivo.add(itemGuardar);

        itemGuardarComo.setText("Guardar Como");
        itemGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarComoActionPerformed(evt);
            }
        });
        menuArchivo.add(itemGuardarComo);

        itemCerrar.setText("Cerrar");
        itemCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarActionPerformed(evt);
            }
        });
        menuArchivo.add(itemCerrar);

        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(itemSalir);

        jMenuBar1.add(menuArchivo);

        menuCodigo.setText("Generar Código");
        jMenuBar1.add(menuCodigo);

        menuEjecutar.setText("Ejecutar");
        jMenuBar1.add(menuEjecutar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Sale de la Ventana
     */
    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_itemSalirActionPerformed

    /**
     * Crea un nuevo archivo en Programa, que contendrá exclusivamente el código
     * del programa a compilar
     */
    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        // TODO add your handling code here:
        TabbedPanel tab = new TabbedPanel();
        JScrollPane sp = new JScrollPane(tab);
        tabbedArchivo.add(sp);
    }//GEN-LAST:event_itemNuevoActionPerformed

    /**
     * Permite abir un archivo .mlg, de un programa almacenado con anterioridad.
     * Este será mostrado en la pestaña Programa, solo para extensión .mlg
     */
    private void itemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAbrirActionPerformed
        // TODO add your handling code here:
        File ab = apertura.abrirArchivo();
        if (ab != null) {
            this.abierto = ab;
            String string = apertura.abrirTexto(abierto);
            if (string != null) {
                TabbedPanel tab = new TabbedPanel(abierto, string);
                JScrollPane sp = new JScrollPane(tab);
                tabbedArchivo.add(sp);
                tabbedArchivo.setSelectedComponent(sp);
                tabbedArchivo.setTitleAt(tabbedArchivo.getSelectedIndex(), ab.getName().substring(0, ab.getName().length() - 4));
                tabbedArchivo.setToolTipTextAt(tabbedArchivo.getSelectedIndex(), ab.getPath());
            }
        }
    }//GEN-LAST:event_itemAbrirActionPerformed

    /**
     * Guarda el contenido de la pestaña Programa activa. Lo guarda en la
     * dirección que el usuario desee, o que ya haya sido guardada.
     */
    private void itemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarActionPerformed
        // TODO add your handling code here:
        JScrollPane sp = (JScrollPane) tabbedArchivo.getSelectedComponent();
        TabbedPanel tb = (TabbedPanel) sp.getViewport().getView();
        tb.guardarArchivo(guardar);
        if (tb.getArchivo()[0] != null) {
            tabbedArchivo.setTitleAt(tabbedArchivo.getSelectedIndex(), tb.getArchivo()[0].getName().substring(0, tb.getArchivo()[0].getName().length() - 4));
            tabbedArchivo.setToolTipTextAt(tabbedArchivo.getSelectedIndex(), tb.getArchivo()[0].getPath());
        } else {
            tabbedArchivo.setTitleAt(tabbedArchivo.getSelectedIndex(), null);
            tabbedArchivo.setToolTipTextAt(tabbedArchivo.getSelectedIndex(), null);
        }
    }//GEN-LAST:event_itemGuardarActionPerformed

    /**
     * Guarda el contenido en la pestaña activa en ese momento. Este lo guarda
     * con diferente nombre, pero con la extensión que corresponda.
     */
    private void itemGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarComoActionPerformed
        // TODO add your handling code here:
        JScrollPane sp = (JScrollPane) tabbedArchivo.getSelectedComponent();
        TabbedPanel tb = (TabbedPanel) sp.getViewport().getView();
        tb.guardarComoArchivo(guardar);
        if (tb.getArchivo()[0] != null) {
            tabbedArchivo.setTitleAt(tabbedArchivo.getSelectedIndex(), tb.getArchivo()[0].getName().substring(0, tb.getArchivo()[0].getName().length() - 4));
            tabbedArchivo.setToolTipTextAt(tabbedArchivo.getSelectedIndex(), tb.getArchivo()[0].getPath());
        } else {
            tabbedArchivo.setTitleAt(tabbedArchivo.getSelectedIndex(), null);
            tabbedArchivo.setToolTipTextAt(tabbedArchivo.getSelectedIndex(), null);
        }
    }//GEN-LAST:event_itemGuardarComoActionPerformed

    /**
     * Sirve para cuando se quiera cerrar una pestaña del archivo seleccionado
     */
    private void itemCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarActionPerformed
        // TODO add your handling code here:
        tabbedArchivo.remove(tabbedArchivo.getSelectedIndex());
    }//GEN-LAST:event_itemCerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JEditorPane editorTerminal = new javax.swing.JEditorPane();
    private javax.swing.JMenuItem itemAbrir;
    private javax.swing.JMenuItem itemCerrar;
    private javax.swing.JMenuItem itemGuardar;
    private javax.swing.JMenuItem itemGuardarComo;
    private javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuCodigo;
    private javax.swing.JMenu menuEjecutar;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JScrollPane spTerminal;
    private javax.swing.JSplitPane splitPrincipal;
    private javax.swing.JTabbedPane tabbedArchivo;
    // End of variables declaration//GEN-END:variables
}
