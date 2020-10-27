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
 * Clase que representa la suma como un triplete especial
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class SumOperator extends Triplete {

    private final String OPERADOR = "+";
    private final String tipo;

    /**
     * Constructor de la suma
     *
     * @param id Id de la suma en cuestión
     * @param operando1 Triplete de referencia del primer operando de la suma
     * @param operando2 Triplete de referencia del segundo operando de la suma
     * @param tipo Tipo de la suma a realizar
     */
    public SumOperator(String id, Triplete operando1, Triplete operando2, String tipo) {
        super(id, operando1, operando2);
        this.id = "t" + Triplete.VARNUM;
        Triplete.VARNUM++;
        this.tipo = tipo;
    }

    @Override
    public String devolverString() {
        String d = this.tipo + " " + this.id + " = " + this.operando1.getId() + " + " + this.operando2.getId() + ";";
        return d;
    }

}
