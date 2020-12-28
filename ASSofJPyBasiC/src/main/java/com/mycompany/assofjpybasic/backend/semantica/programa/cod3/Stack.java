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
 * Clase que hace referencia al Stack
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class Stack extends TerminalOperator {

    private Triplete ref;

    public Stack(Triplete trip) {
        super("stack[" + trip.id + "]");
        ref = trip;
    }

    public Triplete getRef() {
        return ref;
    }

    public String asm(boolean derecha) {
        String s = "";
        if (ref instanceof P) {
            s += "\tmovl\tp(%rip), %rax\n";
        } else {
            s += "\tmovss\t" + ref.pos + "(%rbp), %rax\n"
                    + "\tcltq\n";
        }
        if (derecha) {
            s += "\tleaq\t0(,%rdx,4), %rcx\n"
                    + "\tleaq\tstack(%rip), %rdx\n"
                    + "\tmovss\t(%rcx,%rdx), %xmm0\n";
        } else {
            s += "\tleaq\t0(,%rax,4), %rdx\n"
                    + "\tleaq\tstack[%rip], %rax\n"
                    + "\tmovss\t(%rdx,%rax), %xmm0\n";
        }
        return s;
    }

    public String scanf() {
        String s = "";
        if (ref instanceof P) {
            s += "\tmovl\tp(%rip), %eax\n"
                    + "\tcltq\n";
        } else {
            s += "\tmovl\t" + ref.pos + "(%rbp), %eax\n"
                    + "\tcltq\n";
        }
        s += "\tleaq\t0(,%rax,4), %rdx\n"
                + "\tleaq\tstack(%rip), %rax\n";
        return s;
    }

    @Override
    public String asm() {
        String s = "";
        if (ref instanceof P) {
            s += "\tmovl\tp(%rip), %eax\n"
                    + "\tcltq\n";
        } else {
            s += "\tmovl\t" + ref.pos + "(%rbp), %eax\n"
                    + "\tcltq\n";
        }
        return s + "\tleaq\t0(,%rax,4), %rdx\n"
                + "\tleaq\tstack(%rip), %rax\n"
                + "\tmovss\t(%rdx,%rax), %xmm0\n";
    }

    public String devolver() {
        String s = "";
        if (ref instanceof P) {
            s += "\tmovl\tp(%rip), %eax\n";
        } else {
            s += "\tmovss\t" + ref.pos + "(%rbp), %eax\n"
                    + "\tcltq\n";
        }
        s += "\tleaq     0(,%rax,4), %rdx\n"
                + "\tleaq    stack(%rip), %rax\n"
                + "\tmovss	%xmm0, (%rdx,%rax)\n";
        return s;
    }

    public String devolvers() {
        String s = "";
        if (ref instanceof P) {
            s += "\tmovl\tp(%rip), %eax\n";
        } else {
            s += "\tmovss\t" + ref.pos + "(%rbp), %eax\n"
                    + "\tcltq\n";
        }
        s += "\tleaq\t0(,%rax,4), %rdx\n"
                + "\tleaq\tstack(%rip), %rax\n"
                + "\tmovss\t(%rdx,%rax), %xmm0\n";
        return s;
    }

}
