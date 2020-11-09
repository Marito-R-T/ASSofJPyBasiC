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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public abstract class CondicionalOperator extends Triplete {

    protected List<Triplete> tripletes = new ArrayList<>();
    protected String et;

    public CondicionalOperator(Triplete operando1, Triplete operando2, List<Triplete> trip1, List<Triplete> trip2) {
        super(null, operando1, operando2);
    }

    @Override
    public abstract String devolverString();

    public List<Triplete> getTripletes() {
        return tripletes;
    }

    public void setEt(String et) {
        this.et = et;
    }

    @Override
    public String asm() {
        String s = "";
        if (operando1 instanceof Stack) {
            s += "\tcltq\n"
                    + ((Stack) this.operando1).asm(false)
                    + "\tmovss\t(%rdx,%rax), %xmm0\n";
        } else if (operando1 instanceof Heap) {
            s += "\tcltq\n"
                    + ((Heap) this.operando1).asm(false)
                    + "\tmovss\t(%rdx,%rax), %xmm0\n";
        } else if (operando1 instanceof TerminalOperator) {
            s += "  movss\t$" + ((TerminalOperator) operando1).getBin() + ", %xmm0\n";
        } else {
            s += "  movss\t" + operando1.pos + "(%rbp), %xmm0\n";
        }
        if (operando2 instanceof Stack) {
            s += "\tcltq\n"
                    + ((Stack) this.operando2).asm(false)
                    + "\tmovss\t(%rdx,%rax), %xmm1\n";
        } else if (operando2 instanceof Heap) {
            s += "\tcltq\n"
                    + ((Heap) this.operando2).asm(false)
                    + "\tmovss\t(%rdx,%rax), %xmm1\n";
        } else if (operando1 instanceof TerminalOperator) {
            s += "\tmovss\t$" + ((TerminalOperator) operando1).getBin() + ", %xmm1\n";
        } else {
            s += "\tmovss\t" + operando1.pos + "(%rbp), %xmm1\n";
        }
        return s;
    }
}
