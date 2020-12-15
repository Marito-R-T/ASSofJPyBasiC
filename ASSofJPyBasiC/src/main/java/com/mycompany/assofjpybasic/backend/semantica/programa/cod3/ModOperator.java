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
public class ModOperator extends AritmeticaOperator {

    private final String OPERADOR = "%";
    private final String tipo;

    public ModOperator(String id, Triplete operando1, Triplete operando2, String tipo) {
        super(id, operando1, operando2);
        this.tipo = tipo;
        this.id = "t" + Triplete.VARNUM;
        Triplete.VARNUM++;
    }

    @Override
    public String devolverString() {
        String d = this.id + " = " + this.operando1.getId() + " % " + this.operando2.getId();
        return d;
    }

    @Override
    public String devolverStringE() {
        String d = this.tipo + " " + this.id + " = " + "fmod(" + this.operando1.getId() + " , " + this.operando2.getId() + ");";
        return d;
    }

    @Override
    public String asm() {
        String s = "";
        s += super.asm(true);
        s += this.derecha();
        return s;
    }

    public String derecha() {
        if (this.tipo.equals("int") || this.tipo.equals("char")) {
            String s = "";
            if (operando2 instanceof AritmeticaOperator) {
                if (((AritmeticaOperator) operando2).getTipo().equals("float")) {
                    s += "\tmovss\t" + this.operando2.pos + "(%rbp), %xmm1\n";
                } else {
                    s += "\tmovl\t" + this.operando2.pos + "(%rbp), %eax\n"
                            + "\tcvtsi2ssl\t%eax, %xmm1\n";
                }
                s += "\tcall\tfmod@PLT\n";
            } else if (operando2 instanceof AsignarTemporal) {
                if (((AsignarTemporal) operando2).getTipo().equals("float")) {
                    s += "\tmovss\t" + this.operando2.pos + "(%rbp), %xmm1\n";
                } else {
                    s += "\tmovl\t" + this.operando2.pos + "(%rbp), %eax\n"
                            + "\tcvtsi2ssl\t%eax, %xmm1\n";
                }
                s += "\tcall\tfmod@PLT\n";
            } else if (operando2 instanceof TerminalOperator) {
                if (((TerminalOperator) operando2).isFlo()) {
                    s += "\tmovss\t" + ((TerminalOperator) operando2).getBin() + ", %xmm1\n";
                } else {
                    s += "\tmovl\t" + ((TerminalOperator) operando2).getBin() + ", %eax\n"
                            + "\tcvtsi2ssl\t%eax, %xmm1\n";
                }
                s += "\tcall\tfmod@PLT\n";
            }
            return s + "\tcvttss2sil\t%xmm0, %eax\n"
                    + "\tmovl\t%eax, " + this.pos + "(%rbp)\n";
        } else {
            String s = "";
            if (operando2 instanceof AritmeticaOperator) {
                if (((AritmeticaOperator) operando2).getTipo().equals("float")) {
                    s += "\tmovss\t" + this.operando2.pos + "(%rbp), %xmm1\n";
                } else {
                    s += "\tmovl\t" + this.operando2.pos + "(%rbp), %eax\n"
                            + "\tcvtsi2ssl\t%eax, %xmm1\n";
                }
                s += "\tcall\tfmod@PLT\n";
            } else if (operando2 instanceof AsignarTemporal) {
                if (((AsignarTemporal) operando2).getTipo().equals("float")) {
                    s += "\tmovss\t" + this.operando2.pos + "(%rbp), %xmm1\n";
                } else {
                    s += "\tmovl\t" + this.operando2.pos + "(%rbp), %eax\n"
                            + "\tcvtsi2ssl\t%eax, %xmm1\n";
                }
                s += "\tcall\tfmod@PLT\n";
            } else if (operando2 instanceof TerminalOperator) {
                if (((TerminalOperator) operando2).isFlo()) {
                    s += "\tmovss\t" + ((TerminalOperator) operando2).getBin() + ", %xmm1\n"
                            + "\tcall\tfmod@PLT\n";
                } else {
                    s += "\tmovl\t" + ((TerminalOperator) operando2).getBin() + ", %eax\n"
                            + "\tcvtsi2ssl\t%eax, %xmm1\n"
                            + "\tcall\tfmod@PLT\n";
                }
            }
            return s + "\tcvtsd2ss\t%xmm0, %xmm0\n"
                    + "\tmovss\t%xmm0, " + this.pos + "(%rbp)\n";
        }
    }

}
