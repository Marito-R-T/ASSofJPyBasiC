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
public class Scanf extends Triplete {

    private final String tipo;
    private String et;

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
        return "read " + operando2.getId();
    }

    @Override
    public String devolverStringE() {
        return "scanf(" + "\" " + this.tipo + "\", &" + operando2.getId() + ");";
    }

    /**
     * Metodo que devuelve los scaner cuando es solo un scanner y los printf,
     * para las cadenas que se agreguen.
     *
     * @param texto Array de texto que vino
     * @param terminales Ids de los que se ingresaran
     * @return Lista de tripletes que se obtiene
     */
    public static ListaTripletes regresarTripletes(List<String> texto, List<OperacionPrograma> terminales) {
        ListaTripletes tri = new ListaTripletes();
        int term = 0;
        for (String string : texto) {
            if (string.equals("%d") || string.equals("%f") || string.equals("%c")) {
                if (term < terminales.size()) {
                    tri.addAll(terminales.get(term).getTripletes());
                    tri.add(new Scanf(string, terminales.get(term).getTriplete()));
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

    public String asm() {
        if (this.operando2 instanceof Stack) {
            return "\tcltq\n"
                    + ((Stack) this.operando2).asm(false)
                    + "\taddq    %rdx, %rax\n"
                    + "\tmovq    %rax, %rsi\n"
                    + "\tleaq    " + et + "(%rip), %rdi\n"
                    + "\tmovl    $0, %eax\n"
                    + "\tcall    __isoc99_scanf@PLT\n";
        } else if (this.operando2 instanceof Heap) {
            return "\tcltq\n"
                    + ((Heap) this.operando2).asm(false)
                    + "\taddq    %rdx, %rax\n"
                    + "\tmovq    %rax, %rsi\n"
                    + "\tleaq    " + et + "(%rip), %rdi\n"
                    + "\tmovl    $0, %eax\n"
                    + "\tcall    __isoc99_scanf@PLT\n";
        }
        return "\n";
    }

}
