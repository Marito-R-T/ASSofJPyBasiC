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
public abstract class AritmeticaOperator extends Triplete {

    protected String tipo;

    public AritmeticaOperator(String id, Triplete operando1, Triplete operando2) {
        super(id, operando1, operando2);
    }

    @Override
    public String asm() {
        String s = "";
        if (operando1 instanceof Stack) {
            s += "\tcltq\n"
                    + ((Stack) this.operando1).asm();
        } else if (operando1 instanceof AritmeticaOperator || operando2 instanceof AsignarTemporal) {
            s += "\tmovss\t" + this.operando1.getPos() + "(%rip), %xmm0\n";
        } else if (operando1 instanceof P) {
            s += "\tmovl\tp(%rip), %eax\n";
        } else if (operando1 instanceof TerminalOperator) {
            s += "\tmovss\t." + ((TerminalOperator) operando1).getBin() + ", %xmm0\n";
        }
        return s;
    }

    protected String asm(String tipo) {
        String s = "";
        if (operando1 instanceof AritmeticaOperator) {
            if (((AritmeticaOperator) operando1).getTipo().equals("float")) {
                s += "\tmovss\t" + this.operando1.getPos() + "(%rip), %xmm0\n";
            } else {
                s += "\tmovss\t" + this.operando1.getPos() + "(%rip), %xmm0\n";
            }
        } else if (operando1 instanceof AsignarTemporal) {
            if (((AsignarTemporal) operando1).getTipo().equals("float")) {
                s += "\tmovss\t" + this.operando1.getPos() + "(%rip), %xmm0\n";
            } else {
                s += "\tmovss\t" + this.operando1.getPos() + "(%rip), %xmm0\n";
            }
        } else if (operando1 instanceof P) {
            s += "\tmovl\tp(%rip), %eax\n";
        } else if (operando1 instanceof TerminalOperator) {
            if (((TerminalOperator) operando1).isFlo()) {
                s += "\tmovss\t" + ((TerminalOperator) operando1).getBin() + ", %xmm0\n";
            } else {
                s += "\tmovl\t" + ((TerminalOperator) operando1).getBin() + ", %eax\n"
                        + "\tcvtsi2ssl\t%eax, %xmm0\n";
            }
        }
        return s;
    }

    public String asm(boolean a) {
        String s = "";
        if (operando1 instanceof AritmeticaOperator) {
            if (((AritmeticaOperator) operando1).getTipo().equals("float")) {
                s += "\tmovss\t" + this.operando1.getPos() + "(%rip), %xmm0\n";
            } else {
                s += "\tmovss\t" + this.operando1.getPos() + "(%rip), %xmm0\n";
            }
        } else if (operando1 instanceof AsignarTemporal) {
            if (((AsignarTemporal) operando1).getTipo().equals("float")) {
                s += "\tmovss\t" + this.operando1.getPos() + "(%rip), %xmm0\n";
            } else {
                s += "\tmovss\t" + this.operando1.getPos() + "(%rip), %xmm0\n";
            }
        } else if (operando1 instanceof P) {
            s += "\tmovss\tp(%rip), %xmm0\n";
        } else if (operando1 instanceof TerminalOperator) {
            s += "\tcvtss2sd\t" + ((TerminalOperator) operando1).getBin() + ", %xmm0\n";
        }
        return s;
    }

    public String getTipo() {
        return tipo;
    }

}
