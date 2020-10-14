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
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
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
    public static String regresar3D(String s) {
        try {
            SintaxisPrincipal lengua = new SintaxisPrincipal(new LexicoPrincipal(new StringReader(s)));
            ArchivoMLG archivo = (ArchivoMLG) lengua.parse().value;
            SintaxisPrograma pro = new SintaxisPrograma(new LexicoPrograma(new StringReader(archivo.getPrograma())));
            pro.setTipo(archivo.getJava(), archivo.getVisual(), archivo.getPython());
            return (String) pro.parse().value;
        } catch (Exception ex) {
            System.out.println("Error en el reconocimiento del lenguaje");
        }
        return null;
    }

}
