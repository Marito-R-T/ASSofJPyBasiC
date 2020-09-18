/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mari2bar
 */
public class GuardarArchivo {

    private final JFileChooser choser;

    /**
     * constructor de GuardarArchivo
     */
    public GuardarArchivo() {
        choser = new JFileChooser();
        choser.setAcceptAllFileFilterUsed(false);
    }

    /**
     * metodo para pedir que segun el archivo regrese un string
     *
     * @param guardar archivo en donde se guardara
     * @param texto cadena de texto a guardar
     * @return boolean representando si se guardo con exito o no
     */
    public File guardarTexto(File guardar, String texto) {
        FileWriter fichero = null;
        PrintWriter reader = null;
        try {
            fichero = new FileWriter(guardar);
            reader = new PrintWriter(fichero);
            reader.print(texto);
            reader.close();
            return guardar;
        } catch (IOException ex) {
            Logger.getLogger(GuardarArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * metodo para pedir que segun el archivo regrese un string
     *
     * @param texto texto a guardar en el archivo
     * @param ext extension con la que se guardara
     * @param descripcion descripcion del tipo de archivo
     * @return boolean representando si se guardo con exito o no
     */
    public File guardarComo(String texto, String ext, String descripcion) {
        choser.setFileFilter(new FileNameExtensionFilter("archivo de: " + descripcion, new String[]{ext}));
        if (choser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File guardar = new File(choser.getSelectedFile().getPath().concat(ext));
            if (!guardar.exists()) {
                try {
                    guardar.createNewFile();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
            if (texto != null && !texto.equals("")) {
                return guardarTexto(guardar, texto);
            } else {
                return guardarTexto(guardar, " ");
            }
        }
        return null;
    }

}
