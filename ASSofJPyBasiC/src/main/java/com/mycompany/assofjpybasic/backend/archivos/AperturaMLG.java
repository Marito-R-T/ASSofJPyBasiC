/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mari2bar clase para abir archivos .mlg
 */
public final class AperturaMLG {

    private final JFileChooser choser;

    /**
     * constructor de AperturaMLG se le pone extensión predefinida .mlg
     */
    public AperturaMLG() {
        choser = new JFileChooser();
        choser.setFileFilter(new FileNameExtensionFilter("archivos MLG (Programa fuente)", new String[]{"mlg"}));
        choser.setAcceptAllFileFilterUsed(false);
        choser.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
    }

    /**
     * metodo para pedir que segun el archivo regrese un string
     *
     * @param abierto
     * @return String
     */
    public String abrirTexto(File abierto) {
        try (BufferedReader reader = new BufferedReader(new FileReader(abierto))) {
            String s2;
            String s1;
            s2 = "";
            while ((s1 = reader.readLine()) != null) {
                s2 += s1 + "\n";
            }
            return s2;
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return null;
    }

    /**
     * metodo para abrir archivo en el JFileChooser
     * @return 
     */
    public File abrirArchivo() {
        if (choser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File abierto = choser.getSelectedFile();
            return abierto;
        }
        return null;
    }

}
