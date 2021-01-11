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

    /**
     * Constructor de la suma
     *
     * @param id Id de la suma en cuestión
     * @param operando1 Triplete de referencia del primer operando de la suma
     * @param operando2 Triplete de referencia del segundo operando de la suma
     * @param tipo Tipo de la suma a realizar
     */
    public SumOperator(String id, Triplete operando1, Triplete operando2, String tipo) {
        super(id, operando1, operando2, tipo);
        this.id = "t" + Triplete.VARNUM;
        Triplete.VARNUM++;
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
        s += super.asm(this.tipo);
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
                s += "\taddss\t%xmm1, %xmm0\n"
                        + "\tcvttss2sil\t%xmm0, %eax\n";
            } else if (operando2 instanceof AsignarTemporal) {
                if (((AsignarTemporal) operando2).getTipo().equals("float")) {
                    s += "\tmovss\t" + this.operando2.pos + "(%rbp), %xmm1\n";
                } else {
                    s += "\tmovl\t" + this.operando2.pos + "(%rbp), %eax\n"
                            + "\tcvtsi2ssl\t%eax, %xmm1\n";
                }
                s += "\taddss\t%xmm1, %xmm0\n"
                        + "\tcvttss2sil\t%xmm0, %eax\n";
            } else if (operando2 instanceof TerminalOperator) {
                if (((TerminalOperator) operando2).isFlo()) {
                    s += "\tmovss\t" + ((TerminalOperator) operando2).getBin() + ", %xmm1\n"
                            + "\taddss\t%xmm1, %xmm0\n"
                            + "\tcvttss2sil\t%xmm0, %eax\n";
                } else {
                    if (operando1 instanceof P) {
                        s += "\taddl\t" + ((TerminalOperator) operando2).getBin() + ", %eax\n";
                    } else {
                        s += "\tmovl\t" + ((TerminalOperator) operando2).getBin() + ", %eax\n"
                                + "\tcvtsi2ssl\t%eax, %xmm1\n"
                                + "\taddss\t%xmm1, %xmm0\n"
                                + "\tcvttss2sil\t%xmm0, %eax\n";
                    }
                }
            }
            return s + "\tmovl\t%eax, " + this.pos + "(%rbp)\n";
        } else {
            String s = "";
            if (operando2 instanceof AritmeticaOperator) {
                if (((AritmeticaOperator) operando2).getTipo().equals("float")) {
                    s += "\tmovss\t" + this.operando2.pos + "(%rbp), %xmm1\n";
                } else {
                    s += "\tmovl\t" + this.operando2.pos + "(%rbp), %eax\n"
                            + "\tcvtsi2ssl\t%eax, %xmm1\n";
                }
                s += "\taddss\t%xmm1, %xmm0\n";
            } else if (operando2 instanceof AsignarTemporal) {
                if (((AsignarTemporal) operando2).getTipo().equals("float")) {
                    s += "\tmovss\t" + this.operando2.pos + "(%rbp), %xmm1\n";
                } else {
                    s += "\tmovl\t" + this.operando2.pos + "(%rbp), %eax\n"
                            + "\tcvtsi2ssl\t%eax, %xmm1\n";
                }
                s += "\taddss\t%xmm1, %xmm0\n";
            } else if (operando2 instanceof TerminalOperator) {
                if (((TerminalOperator) operando2).isFlo()) {
                    s += "\tmovss\t" + ((TerminalOperator) operando2).getBin() + ", %xmm1\n"
                            + "\taddss\t%xmm1, %xmm0\n";
                } else {
                    if (operando1 instanceof P) {
                        s += "\taddl\t" + ((TerminalOperator) operando2).getBin() + ", %eax\n";
                    } else {
                        s += "\tmovl\t" + ((TerminalOperator) operando2).getBin() + ", %eax\n"
                                + "\tcvtsi2ssl\t%eax, %xmm1\n"
                                + "\taddss\t%xmm1, %xmm0\n";
                    }
                }
            }
            return s + "\tmovss\t%xmm0, " + this.pos + "(%rbp)\n";
        }
    }

}
