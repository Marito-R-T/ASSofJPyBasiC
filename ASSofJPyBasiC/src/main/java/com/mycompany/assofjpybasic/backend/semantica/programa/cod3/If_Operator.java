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
 * Clase que representa un if de bajo nivel como triplete
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class If_Operator extends Triplete {

    public final String operacion = "if";
    private Etiqueta et;
    private Triplete op;

    /**
     * Constructor que contiene el triplete de condicional y la etiqueta de a
     * donde se dirigira si es cierta la condicional
     *
     * @param operando1 Triplete condicional
     * @param operando2 etiqueta de donde se redirigira este if si es verdadero
     */
    public If_Operator(Triplete operando1, Etiqueta operando2) {
        super(null, operando1, operando2);
        this.et = operando2;
    }

    @Override
    public String devolverString() {
        if (op == null) {
            return "if" + this.operando1.devolverString() + " goto " + et.getId();
        } else {
            return "if" + this.op.devolverString() + " goto " + et.getId();
        }
    }

    public Etiqueta getEt() {
        return et;
    }

    public void setEt(Etiqueta et) {
        this.et = et;
    }

    public void setOp(Triplete op) {
        this.op = new IgualOperator(this.operando1, op);
    }

}
