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

import com.mycompany.assofjpybasic.backend.semantica.programa.ListaTripletes;
import com.mycompany.assofjpybasic.backend.semantica.programa.OperacionPrograma;
import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class Printf extends Triplete {

    private final String tipo;
    private final String cast;
    private String valor;
    private String et;

    /**
     * Constructor cuando se necesita de una variable
     *
     * @param tipo Tipo al que pertenece la variable
     * @param operando2 Id al valor que se hace referencia
     * @param cast Tipo de cast relacionado al tipo
     */
    public Printf(String tipo, Triplete operando2, String cast) {
        super(null, null, operando2);
        this.tipo = tipo;
        this.cast = cast;
    }

    /**
     * Constructor cuando solo se escribirá texto
     *
     * @param texto Texto a mostrar en pantalla
     */
    public Printf(String texto) {
        super(null, null, null);
        this.valor = texto;
        this.tipo = null;
        this.cast = null;
    }

    @Override
    public String devolverString() {
        if (tipo != null) {
            return "print " + this.operando2.getId();
        } else {
            return "printf \"" + valor + "\"";
        }
    }

    @Override
    public String devolverStringE() {
        if (tipo != null) {
            return "printf(\"" + tipo + "\", (" + cast + ")" + this.operando2.getId() + ");";
        } else {
            return "printf(\"" + valor + "\");";
        }
    }

    /**
     * Metodo para devolver todos los print segun se requieran
     *
     * @param texto Texto que se va a imprimir
     * @param ope Operaciones que se van a necesitar
     * @return Lista de tripletes a devolver
     */
    public static ListaTripletes regresarTripletes(List<String> texto, List<OperacionPrograma> ope) {
        ListaTripletes tri = new ListaTripletes();
        int term = 0;
        for (String string : texto) {
            if (string.equals("%d") || string.equals("%f") || string.equals("%c")) {
                if (term < ope.size()) {
                    tri.addAll(ope.get(term).mostrarTripletes());
                    if (string.equals("%v")) {
                        tri.add(new Printf("%f", ope.get(term).getTriplete(), "float"));
                    } else {
                        tri.add(new Printf(string, ope.get(term).getTriplete(), Triplete.devolverTipoP(string)));
                    }
                } else {
                    return null;
                }
                term++;
            } else {
                tri.add(new Printf(string));
            }
        }
        return tri;
    }

    @Override
    public String asm() {
        if (valor == null) {
            if (this.operando2 instanceof TerminalOperator) {
                if (((TerminalOperator) this.operando2).isFlo()) {
                    if (this.tipo.equals("%d")) {
                        return "\tmovss\t" + ((TerminalOperator) operando2).getBin() + ", %xmm0\n"
                                + "\tcvttss2sil\t%xmm0, %eax\n"
                                + "\tmovl\t%eax, %esi\n"
                                + "\tleaq\t" + et + "(%rip), %rdi\n"
                                + "\tmovl\t$1, %eax\n"
                                + "\tcall\tprintf@PLT\n";
                    } else {
                        return "\tmovss\t" + ((TerminalOperator) operando2).getBin() + ", %xmm0\n"
                                + "\tleaq\t" + et + "(%rip), %rdi\n"
                                + "\tmovl\t$1, %eax\n"
                                + "\tcall\tprintf@PLT\n";
                    }
                } else {
                    if (this.tipo.equals("%d")) {
                        return "\tmovl\t" + ((TerminalOperator) operando2).getBin() + ", %esi\n"
                                + "\tleaq\t" + et + "(%rip), %rdi\n"
                                + "\tmovl\t$0, %eax\n"
                                + "\tcall\tprintf@PLT\n";
                    } else {
                        return "\tmovl\t" + ((TerminalOperator) operando2).getBin() + ", %eax\n"
                                + "\tcvtsi2ssl\t%eax, %xmm0\n"
                                + "\tleaq\t" + et + "(%rip), %rdi\n"
                                + "\tmovl\t$0, %eax\n"
                                + "\tcall\tprintf@PLT\n";
                    }
                }
            } else if (this.operando2 instanceof AritmeticaOperator) {
                if (((AritmeticaOperator) this.operando2).getTipo().equals("float")) {
                    if (this.tipo.equals("%d")) {
                        return "\tmovss\t" + this.operando2.getPos() + "(%rbp), %xmm0\n"
                                + "\tcvttss2sil\t%xmm0, %eax\n"
                                + "\tmovl\t%eax, %esi\n"
                                + "\tleaq\t" + et + "(%rip), %rdi\n"
                                + "\tmovl\t$0, %eax\n"
                                + "\tcall\tprintf@PLT\n";
                    } else {
                        return "\tcvtss2sd\t" + this.operando2.getPos() + "(%rbp), %xmm0\n"
                                + "\tleaq\t" + et + "(%rip), %rdi\n"
                                + "\tmovl\t$1, %eax\n"
                                + "\tcall\tprintf@PLT\n";
                    }
                } else {
                    if (this.tipo.equals("%d")) {
                        return "\tmovl\t" + this.operando2.getPos() + "(%rbp), %eax\n"
                                + "\tmovl\t%eax, %esi\n"
                                + "\tleaq\t" + et + "(%rip), %rdi\n"
                                + "\tmovl\t$0, %eax\n"
                                + "\tcall\tprintf@PLT\n";
                    } else {
                        return "\tmovl\t" + this.operando2.getPos() + "(%rbp), %eax\n"
                                + "\tcvtsi2ssl\t%eax, %xmm0\n"
                                + "\tleaq\t" + et + "(%rip), %rdi\n"
                                + "\tmovl\t$0, %eax\n"
                                + "\tcall\tprintf@PLT\n";

                    }
                }
            } else if (this.operando2 instanceof AsignarTemporal) {
                if (((AsignarTemporal) this.operando2).getTipo().equals("float")) {
                    if (this.tipo.equals("%d")) {
                        return "\tmovss\t" + this.operando2.getPos() + "(%rbp), %xmm0\n"
                                + "\tcvttss2sil\t%xmm0, %eax\n"
                                + "\tmovl\t%eax, %esi\n"
                                + "\tleaq\t" + et + "(%rip), %rdi\n"
                                + "\tmovl\t$0, %eax\n"
                                + "\tcall\tprintf@PLT\n";
                    } else {
                        return "\tcvtss2sd\t" + this.operando2.getPos() + "(%rbp), %xmm0\n"
                                + "\tleaq\t" + et + "(%rip), %rdi\n"
                                + "\tmovl\t$1, %eax\n"
                                + "\tcall\tprintf@PLT\n";
                    }
                } else {
                    if (this.tipo.equals("%d")) {
                        return "\tmovl\t" + this.operando2.getPos() + "(%rbp), %eax\n"
                                + "\tmovl\t%eax, %esi\n"
                                + "\tleaq\t" + et + "(%rip), %rdi\n"
                                + "\tmovl\t$0, %eax\n"
                                + "\tcall\tprintf@PLT\n";
                    } else {
                        return "\tmovl\t" + this.operando2.getPos() + "(%rbp), %eax\n"
                                + "\tcvtsi2ssl\t%eax, %xmm0\n"
                                + "\tleaq\t" + et + "(%rip), %rdi\n"
                                + "\tmovl\t$0, %eax\n"
                                + "\tcall\tprintf@PLT\n";

                    }
                }
            }
        } else {
            return "\tleaq\t" + et + "(%rip), %rdi\n"
                    + "\tmovl\t$0, %eax\n"
                    + "\tcall\tprintf@PLT\n";
        }
        return "";
    }

    public void setEt(String et) {
        this.et = et;
    }

    public String getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

}
