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

import com.mycompany.assofjpybasic.backend.semantica.programa.OperacionPrograma;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public abstract class Triplete {

    protected final String id;
    protected final Triplete operando1;
    protected final Triplete operando2;
    protected static int VARNUM = 0, ETNUM = 0;
    private static final String[] tipos = {"char", "int", "float"};

    /**
     * Constructor para iniciar Triplete
     *
     * @param id Numero de la posicion del triplete
     * @param operando1 Operador 1 que usará el triplete
     * @param operando2 Operador 2 que usará el triplete
     */
    public Triplete(String id, Triplete operando1, Triplete operando2) {
        this.id = id;
        this.operando1 = operando1;
        this.operando2 = operando2;

    }

    public String getId() {
        return id;
    }

    public Triplete getOperando1() {
        return operando1;
    }

    public Triplete getOperando2() {
        return operando2;
    }

    public abstract String devolverString();

    public static String devolverTipo(OperacionPrograma op1, OperacionPrograma op2) {
        if (op1.getTipo() >= op2.getTipo()) {
            return Triplete.tipos[op1.getTipo()];
        } else {
            return Triplete.tipos[op2.getTipo()];
        }
    }

}
