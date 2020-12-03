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
public class AsignarTemporal extends Triplete {

    private String tipo;

    public AsignarTemporal(String id, Triplete operando1, String tipo) {
        super(id, operando1, null);
        this.tipo = tipo;
        this.id = "t" + Triplete.VARNUM;
        Triplete.VARNUM++;
    }

    @Override
    public String devolverString() {
        String d = this.id + " = " + this.operando1.getId();
        return d;
    }

    @Override
    public String devolverStringE() {
        String d = this.tipo + " " + this.id + " = " + this.operando1.getId() + ";";
        return d;
    }

    @Override
    public String asm() {
        String s = "";
        if (this.tipo != null && this.tipo.equals("float")) {
            return this.floatString();
        } else if (this.tipo != null && (this.tipo.equals("int") || this.tipo.equals("char"))) {
            return this.intString();
        }
        return s;
    }

    /**
     * Es el metodo donde se devuelve el string del assembler si es tipo float
     *
     * @return devuelve la linea ingresandola en xmm0
     */
    public String floatString() {
        if (operando1 instanceof Stack) {
            return ((Stack) this.operando1).asm()
                    + "\tmovss\t" + " %xmm0, " + this.getPos() + "(%rbp)\n";
        } else if (operando1 instanceof Heap) {
            return ((Heap) this.operando1).asm()
                    + "\tmovss\t" + " %xmm0, " + this.getPos() + "(%rbp)\n";
        } else if (operando1 instanceof AritmeticaOperator) {
            return "\tmovss\t" + operando1.getPos() + "(%rbp), " + this.getPos() + "(%rbp)\n";
        } else if (operando1 instanceof P) {
            return "\tmovss\tp(%rip), " + this.getPos() + "(%rbp)\n";
        } else if (operando1 instanceof TerminalOperator) {
            return "\tmovss\t." + ((TerminalOperator) operando1).getBin() + ", " + this.getPos() + "(%rbp)\n";
        }
        return "";
    }

    /**
     * Es el metodo donde se devuelve el string del assembler si es tipo int o
     * char
     *
     * @return devuelve la linea ingresandola en eax
     */
    public String intString() {
        if (operando1 instanceof Stack) {
            return ((Stack) this.operando1).asm()
                    + "\tmovl\t" + " %xmm0, " + this.getPos() + "(%rbp)\n";
        } else if (operando1 instanceof Heap) {
            return ((Heap) this.operando1).asm()
                    + "\tmovl\t" + " %xmm0, " + this.getPos() + "(%rbp)\n";
        } else if (operando1 instanceof AritmeticaOperator) {
            return "\tmovl\t" + operando1.getPos() + "(%rbp), " + this.getPos() + "(%rbp)\n";
        } else if (operando1 instanceof P) {
            return "\tmovl\tp(%rip), " + this.getPos() + "(%rbp)\n";
        } else if (operando1 instanceof TerminalOperator) {
            return "\tmovl\t" + ((TerminalOperator) operando1).getBin() + ", " + this.getPos() + "(%rbp)\n";
        }
        return "";
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
