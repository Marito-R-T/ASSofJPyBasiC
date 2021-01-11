/*
 * Copyright (C) 2020 Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.mycompany.assofjpybasic.frontend.analizador;

import com.mycompany.assofjpybasic.backend.analizador.LexicoPrincipal;
import com.mycompany.assofjpybasic.backend.analizador.SintaxisPrincipal;
import com.mycompany.assofjpybasic.backend.analizador.principal.LexicoPrograma;
import com.mycompany.assofjpybasic.backend.analizador.principal.SintaxisPrograma;
import com.mycompany.assofjpybasic.backend.classes.ArchivoMLG;
import com.mycompany.assofjpybasic.frontend.AssGUI;
import java.io.StringReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase donde se llama a los Analizadores Sintacticos y Lexicos, y cualquier
 * error lo informa a la terminal principal
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class ManejadorAnalisis {

    /**
     * Archivo de texto que se ingreso como programa
     *
     * @param s Texto a analizar
     * @return String del codigo 3 direcciones
     */
    public static List<String> regresar3D(String s) {
        try {
            AssGUI.editorTerminal.setText("");
            SintaxisPrincipal lengua = new SintaxisPrincipal(new LexicoPrincipal(new StringReader(s)));
            ArchivoMLG archivo = (ArchivoMLG) lengua.parse().value;
            SintaxisPrograma pro = new SintaxisPrograma(new LexicoPrograma(new StringReader(archivo.getPrograma())));
            pro.setLineas(lengua.getJV(), lengua.getPY(), lengua.getVB(), lengua.getC());
            pro.setTipo(archivo.getJava(), archivo.getVisual(), archivo.getPython());
            List<String> string = (List<String>) pro.parse().value;
            if (AssGUI.editorTerminal.getText().equals("")) {
                return string;
            } else {
                AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "\n"
                        + "<<<<<<<<<<<<<ERROR, NO SE PUEDE GENERAR CODIGO 3 DIRECCIONES>>>>>>>>>>>>>");
            }
        } catch (Exception ex) {
            Logger.getLogger(AssGUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            System.out.println(ex.getLocalizedMessage());
            AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "\n"
                    + "<<<<<<<<<<<<<ERROR, NO SE PUEDE GENERAR CODIGO 3 DIRECCIONES>>>>>>>>>>>>>");
        }
        return null;
    }

}
