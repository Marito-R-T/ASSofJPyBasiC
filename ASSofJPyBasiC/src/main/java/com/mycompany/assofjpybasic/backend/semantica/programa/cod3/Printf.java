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

import com.mycompany.assofjpybasic.backend.semantica.programa.ListaTripletes;
import com.mycompany.assofjpybasic.backend.semantica.programa.OperacionPrograma;
import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class Printf extends Triplete {

    private final String tipo;
    private final String cast;
    private String valor;

    /**
     * Constructor cuando se necesita de una variable
     *
     * @param tipo Tipo al que pertenece la variable
     * @param operando2 Id al valor que se hace referencia
     * @param cast Tipo de cast relacionado al tipo
     */
    public Printf(String tipo, Triplete operando2, String cast) {
        super(null, null, operando2);
        this.tipo = tipo;
        this.cast = cast;
    }

    /**
     * Constructor cuando solo se escribirá texto
     *
     * @param texto Texto a mostrar en pantalla
     */
    public Printf(String texto) {
        super(null, null, null);
        this.valor = texto;
        this.tipo = null;
        this.cast = null;
    }

    @Override
    public String devolverString() {
        if (tipo != null) {
            return "printf(\"" + tipo + "\", (" + cast + ")" + this.operando2.getId() + ");";
        } else {
            return "printf(\"" + valor + "\");";
        }
    }

    /**
     * Metodo para devolver todos los print segun se requieran
     *
     * @param texto Texto que se va a imprimir
     * @param ope Operaciones que se van a necesitar
     * @return Lista de tripletes a devolver
     */
    public static ListaTripletes regresarTripletes(List<String> texto, List<OperacionPrograma> ope) {
        ListaTripletes tri = new ListaTripletes();
        int term = 0;
        for (String string : texto) {
            if (string.equals("%d") || string.equals("%f") || string.equals("%c")) {
                if (term < ope.size()) {
                    tri.addAll(ope.get(term).getTripletes());
                    if (string.equals("%v")) {
                        tri.add(new Printf("%f", ope.get(term).getTriplete(), "float"));
                    } else {
                        tri.add(new Printf(string, ope.get(term).getTriplete(), Triplete.devolverTipo(ope.get(term))));
                    }
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
