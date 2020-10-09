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
package com.mycompany.assofjpybasic.backend.semantica.programa.cod3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class Scanf extends Triplete {

    private final String tipo;

    /**
     * Constructor de Scanf
     *
     * @param tipo Tipo del scaner, %d, %c o %f
     * @param operando2 Triplete del Id al que representa
     */
    public Scanf(String tipo, Triplete operando2) {
        super(null, null, operando2);
        this.tipo = tipo;
    }

    @Override
    public String devolverString() {
        return "scanf(" + "\"" + this.tipo + "\", &" + operando2.getId() + ")";
    }

    /**
     * Metodo que devuelve los scaner cuando es solo un scanner y los printf,
     * para las cadenas que se agreguen.
     *
     * @param texto Array de texto que vino
     * @param terminales Ids de los que se ingresaran
     * @return Lista de tripletes que se obtiene
     */
    public static List<Triplete> regresarTripletes(List<String> texto, List<TerminalOperator> terminales) {
        List<Triplete> tri = new ArrayList<>();
        int term = 0;
        for (String string : texto) {
            if (string.equals("%d") || string.equals("%f") || string.equals("%c")) {
                if (term < terminales.size()) {
                    tri.add(new Scanf(string, terminales.get(term)));
                } else {
                    return null;
                }
                term++;
            } else {
                tri.add(new Printf(string));
            }
        }
        return tri;
    }

}
