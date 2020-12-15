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

import com.mycompany.assofjpybasic.backend.semantica.python.Input;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class AsignarValor extends Triplete {

    private final String OPERADOR = "=";
    protected String tipo;

    /**
     * Coonstructor para asignar un valor a una variable ya existente.
     *
     * @param id Id de la variable
     * @param operando1 Triplete al que se le va igualar
     * @param operando2 Triplete el que se va a agregar
     */
    public AsignarValor(String id, Triplete operando1, Triplete operando2) {
        super(id, operando1, operando2);
    }

    /**
     * Constructor para asignar un valor a una variable (inicializarla)
     *
     * @param operando1 Triplete de la variable a asignar
     * @param operando2 Triplete el que se va a agregar
     * @param tipo Tipo de la asignacion
     */
    public AsignarValor(Triplete operando1, Triplete operando2, String tipo) {
        super(null, operando1, operando2);
        this.tipo = tipo;
    }

    @Override
    public String devolverString() {
        if (!(operando2 instanceof Input)) {
            if (operando2 != null && tipo != null) {
                return this.operando1.getId() + " = " + operando2.getId();
            } else if (operando2 != null && tipo == null) {
                return this.operando1.getId() + " = " + this.operando2.getId();
            }
        } else {
            return "read " + operando1.getId();
        }
        return "";
    }

    @Override
    public String devolverStringE() {
        if (!(operando2 instanceof Input)) {
            if (operando2 != null && tipo != null) {
                return this.operando1.getId() + " = " + operando2.getId() + ";";
            } else if (operando2 != null && tipo == null) {
                return this.operando1.getId() + " = " + this.operando2.getId() + ";";
            }
        } else {
            return "scanf(\"%f\",&" + operando1.getId() + ");";
        }
        return "";
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String asm() {
        String s = "";
        if (!(operando2 instanceof Input)) {
            s += this.asigAssembler();
        }
        return s;
    }

    private String inputAssembler() {
        return "";
    }

    private String asigAssembler() {
        String s = "";
        if (this.operando2 instanceof GetchOperator) {
            s += "\tmovl\t$0, %eax\n"
                    + "\tcall\tgetch\n"
                    + "\tmovsbl\t%al, %eax\n"
                    + "\tcvtsi2ssl\t%eax, %xmm0\n";
        } else if (this.operando2 instanceof AsignarTemporal) {
            if (((AsignarTemporal) operando2).getTipo().equals("float")) {
                s += "\tmovss\t" + this.operando2.pos + "(%rbp), %xmm0\n";
            } else {
                s += "\tmovl\t" + this.operando2.pos + "(%rbp), %eax\n";
                if (!(this.operando1 instanceof P)) {
                    s += "\tcvtsi2ssl\t%eax, %xmm0\n";
                }
            }
        } else if (this.operando2 instanceof AritmeticaOperator) {
            if (((AritmeticaOperator) operando2).getTipo() == null || ((AritmeticaOperator) operando2).getTipo().equals("float")) {
                s += "\tmovss\t" + this.operando2.pos + "(%rbp), %xmm0\n";
            } else {
                s += "\tmovl\t" + this.operando2.pos + "(%rbp), %eax\n";
                if (!(this.operando1 instanceof P)) {
                    s += "\tcvtsi2ssl\t%eax, %xmm0\n";
                }
            }
        }
        s += stack();
        s += heap();
        if (this.operando2 instanceof Stack) {
            s += ((Stack) operando2).devolvers();
        } else if (this.operando2 instanceof Heap) {
            s += ((Heap) operando2).devolvers();
        } else if (this.operando2 instanceof P) {
            s += this.operando2.asm();
        }
        if (this.operando1 instanceof Stack) {
            s += "\tcltq\n"
                    + "\tleaq\t0(,%rax,4), %rdx\n"
                    + "\tleaq\tstack(%rip), %rax\n";
            if (this.operando2 instanceof TerminalOperator) {
                if (((TerminalOperator) operando2).isFlo()) {
                    s += "\tmovss\t" + ((TerminalOperator) operando2).getBin() + ", %xmm0\n";
                } else {
                    s += "\tpsrldq\t" + ((TerminalOperator) operando2).getBin() + ", %xmm0\n";
                }
            }
            s += "\tmovss\t%xmm0, (%rdx,%rax)\n";
        } else if (this.operando1 instanceof Heap) {
            s += "\tcltq\n"
                    + "\tleaq\t0(,%rax,4), %rdx\n"
                    + "\tleaq\theap(%rip), %rax\n";
            if (this.operando2 instanceof TerminalOperator) {
                if (((TerminalOperator) operando2).isFlo()) {
                    s += "\tcvtss2sd\t" + ((TerminalOperator) operando2).getBin() + ", %xmm0\n";
                } else {
                    s += "\tpsrldq\t" + ((TerminalOperator) operando2).getBin() + ", %xmm0\n";
                }
            }
            s += "\tmovss\t%xmm0, (%rdx,%rax)\n";
        } else if (this.operando1 instanceof P) {
            s += "\tmovl\t%eax, p(%rip)\n";
        }
        return s;
    }

    private String stack() {
        if (this.operando1 instanceof Stack && ((Stack) this.operando1).getRef() instanceof P) {
            return "\tmovl\tp(%rip), %eax\n";
        } else if ((this.operando1 instanceof Stack
                && ((Stack) this.operando1).getRef() instanceof AritmeticaOperator)) {
            return "\tmovl\t" + ((Stack) this.operando1).getRef().pos + "(%rbp), %eax\n";
        } else if ((this.operando1 instanceof Stack
                && ((Stack) this.operando1).getRef() instanceof TerminalOperator)) {
            if (((TerminalOperator) operando1).isFlo()) {
                return "\tcvtss2sd\t" + ((TerminalOperator) operando1).getBin() + ", %xmm0\n"
                        + "\tcvttsd2sil\t%xmm0, %eax";
            } else {
                return "\tmovl\t" + ((TerminalOperator) operando1).getBin() + ", %eax\n";
            }
        }
        return "";
    }

    private String heap() {
        if (this.operando1 instanceof Heap && ((Heap) this.operando1).getRef() instanceof P) {
            return "\tmovl\tp(%rip), %eax\n";
        } else if ((this.operando1 instanceof Heap
                && ((Heap) this.operando1).getRef() instanceof AritmeticaOperator)) {
            return "\tmovl\t" + ((Heap) this.operando1).getRef().pos + "(%rbp), %eax\n";
        } else if ((this.operando1 instanceof Heap
                && ((Heap) this.operando1).getRef() instanceof TerminalOperator)) {
            if (((TerminalOperator) operando1).isFlo()) {
                return "\tcvtss2sd\t" + ((TerminalOperator) operando1).getBin() + ", %xmm0\n"
                        + "\tcvttsd2sil\t%xmm0, %eax";
            } else {
                return "\tmovl\t" + ((TerminalOperator) operando1).getBin() + ", %eax\n";
            }
        }
        return "";
    }

}
