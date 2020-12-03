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

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class TerminalOperator extends Triplete {

    private String operador;
    private String bin;
    private boolean flo;

    /**
     * iniciar tripleta
     *
     * @param operador Nombre o valor del operador
     */
    public TerminalOperator(String operador) {
        super(operador, null, null);
        this.operador = operador;
        bin = operador;
        flo = false;
    }

    /**
     * iniciar tripleta su es un float
     *
     * @param operador Nombre o valor del operador
     * @param f si lo que se esta ingresando es un float
     */
    public TerminalOperator(String operador, String f) {
        super(operador, null, null);
        this.operador = operador;
        bin = f;//Float.floatToIntBits(Float.parseFloat("15.5"));
        flo = true;
    }

    @Override
    public String devolverString() {
        return this.id;
    }

    @Override
    public String devolverStringE() {
        return this.id + ";";
    }

    public String getBin() {
        if (flo) {
            return bin + "(%rip)";
        } else {
            return "$" + bin;
        }
    }

    public String getBinario() {
        return bin;
    }

    public String getBin(String s) {
        if (flo) {
            return "\t" + s + "\t$" + bin + ", %eax\n";
        } else {
            return bin + "(%rip)";
        }
    }

    public boolean isFlo() {
        return flo;
    }

}
