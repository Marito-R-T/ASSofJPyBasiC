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

import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class MenorIgOperator extends CondicionalOperator {

    private final String OPERADOR = "<=";

    public MenorIgOperator(Triplete operando1, Triplete operando2, List<Triplete> trip1, List<Triplete> trip2) {
        super(operando1, operando2, trip1, trip2);
        tripletes.addAll(trip1);
        tripletes.addAll(trip2);
        if (!(operando1 instanceof TerminalOperator)) {
            tripletes.add(operando1);
        }
        if (!(operando2 instanceof TerminalOperator)) {
            tripletes.add(operando2);
        }
    }

    @Override
    public String devolverString() {
        return "(" + this.operando1.getId() + this.OPERADOR + this.operando2.getId() + ")";
    }

    @Override
    public String devolverStringE() {
        return "(" + this.operando1.getId() + this.OPERADOR + this.operando2.getId() + ")";
    }

    @Override
    public String asm() {
        String s = "";
        s += super.asm();
        s += "\tucomiss\t%xmm1, %xmm0\n";
        s += "\tjae\t" + super.et + "\n";
        return s;
    }

}
