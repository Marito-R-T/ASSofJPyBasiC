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
public class SumOperator extends AritmeticaOperator {

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
        String d = this.id + " = " + this.operando1.getId() + " + " + this.operando2.getId();
        return d;
    }

    @Override
    public String devolverStringE() {
        String d = this.tipo + " " + this.id + " = " + this.operando1.getId() + " + " + this.operando2.getId() + ";";
        return d;
    }

    @Override
    public String asm() {
        String s = "";
        s += super.asm();
        if (operando2 instanceof Stack) {
            s += "\tcltq\n"
                    + ((Stack) this.operando2).asm(false)
                    + "\taddss\t%xmm1, %xmm0\n";
        } else if (operando2 instanceof AritmeticaOperator) {
            s += "\taddss\t" + this.operando2.getPos() + "(%rip), %xmm0\n";
        } else if (operando2 instanceof TerminalOperator) {
            s += "\taddss\t$" + ((TerminalOperator) operando2).getBin() + ", %xmm0\n";
        }
        s += "\tmovss\t%xmm0, " + this.pos + "(%rbp)\n";
        return s;
    }

}
