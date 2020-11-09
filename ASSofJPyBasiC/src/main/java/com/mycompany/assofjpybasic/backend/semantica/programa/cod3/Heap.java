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
public class Heap extends TerminalOperator {

    private Triplete ref;

    public Heap(Triplete operador) {
        super("heap[" + operador.id + "]");
        ref = operador;
    }

    public String asm(boolean derecha) {
        String s = "";
        if (ref instanceof P) {
            s += "\tmovl\tp(%rip), %eax\n";
        } else {
            s += "\t" + ref.pos + "(%rbp), %eax\n"
                    + "\tcltq\n";
        }
        if (derecha) {
            s += "   leaq	0(,%rdx,4), %rcx\n"
                    + "leaq    stack(%rip), %rdx\n"
                    + " movss	(%rcx,%rdx), %xmm0\n";
        } else {
            s += "   cltq\n"
                    + " leaq	0(,%rax,4), %rdx\n"
                    + " leaq	heap(%rip), %rax\n";
        }
        return s;
    }

}
