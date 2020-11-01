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

import com.mycompany.assofjpybasic.backend.semantica.python.Input;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class AsignarValor extends Triplete {

    private final String OPERADOR = "=";
    protected String tipo;

    /**
     * Coonstructor para asignar un valor a una variable ya existente.
     *
     * @param id Id de la variable
     * @param operando1 Triplete al que se le va igualar
     * @param operando2 Triplete el que se va a agregar
     */
    public AsignarValor(String id, Triplete operando1, Triplete operando2) {
        super(id, operando1, operando2);
    }

    /**
     * Constructor para asignar un valor a una variable (inicializarla)
     *
     * @param operando1 Triplete de la variable a asignar
     * @param operando2 Triplete el que se va a agregar
     * @param tipo Tipo de la asignacion
     */
    public AsignarValor(Triplete operando1, Triplete operando2, String tipo) {
        super(null, operando1, operando2);
        this.tipo = tipo;
    }

    @Override
    public String devolverString() {
        if (!(operando2 instanceof Input)) {
            if (operando2 != null && tipo != null) {
                return this.operando1.getId() + " = " + operando2.getId() + ";";
            } else if (tipo != null && operando2 == null) {
                return this.operando1.getId() + ";";
            } else if (operando2 != null && tipo == null) {
                return this.operando1.getId() + " = " + this.operando2.getId() + ";";
            } else {
                return this.operando1.getId() + ";";
            }
        } else {
            return "scanf(\"%f\",&" + operando1.getId() + ");";
        }
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
