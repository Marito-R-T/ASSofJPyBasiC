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
public class AsignarValor extends Triplete {

    private final String OPERADOR = "=";
    private String tipo;

    public AsignarValor(String id, Triplete operando1, Triplete operando2) {
        super(id, operando1, operando2);
    }

    @Override
    public String devolverString() {
        if (operando2 != null && tipo != null) {
            return this.tipo + " " + this.operando1.getId() + " = " + operando2.getId() + ";";
        } else if (tipo != null && operando2 == null) {
            return this.tipo + " " + this.operando1.getId() + ";";
        } else if (operando2 != null && tipo == null) {
            return this.operando1.getId() + " = " + this.operando2.getId() + ";";
        } else {
            return this.operando1.getId() + ";";
        }
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
