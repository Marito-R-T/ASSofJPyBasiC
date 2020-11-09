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

import com.mycompany.assofjpybasic.backend.semantica.programa.OperacionPrograma;

/**
 * Clase que representa un triplete
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public abstract class Triplete {

    protected String id, pos;
    protected final Triplete operando1;
    protected final Triplete operando2;
    public static int VARNUM = 0, ETNUM = 0;
    public static final String[] tipos = {"char", "int", "float", "void"};

    /**
     * Constructor para iniciar Triplete
     *
     * @param id Numero de la posicion del triplete
     * @param operando1 Operador 1 que usará el triplete
     * @param operando2 Operador 2 que usará el triplete
     */
    public Triplete(String id, Triplete operando1, Triplete operando2) {
        this.id = id;
        this.operando1 = operando1;
        this.operando2 = operando2;

    }

    public String getId() {
        return id;
    }

    public Triplete getOperando1() {
        return operando1;
    }

    public Triplete getOperando2() {
        return operando2;
    }

    /**
     * Cambia el id del operando que no sea nulo
     *
     * @param id del operando a buscar
     * @param cambio El id nuevo del operando
     * @return true
     */
    public boolean cambiarId(String id, String cambio) {
        if (this.operando1 != null && operando2.getId() != null && operando1.getId().equals(id)) {
            operando1.setId(cambio);
        }
        if (this.operando2 != null && operando2.getId() != null && operando2.getId().equals(id)) {
            operando2.setId(cambio);
        }
        return true;
    }

    public abstract String devolverString();

    public abstract String devolverStringE();

    public static String devolverTipo(OperacionPrograma op1, OperacionPrograma op2) {
        if (op1.getTipo() >= op2.getTipo()) {
            return Triplete.tipos[op1.getTipo() - 1];
        } else {
            return Triplete.tipos[op2.getTipo() - 1];
        }
    }

    public static String devolverTipo(OperacionPrograma op1) {
        return Triplete.tipos[op1.getTipo() - 1];
    }

    public static String devolverTipoP(String string) {
        switch (string) {
            case "%d":
                return "int";
            case "%f":
                return "float";
            case "%c":
                return "char";
            default:
                return "float";
        }
    }

    public void setId(String id) {
        this.id = id;
    }

    public String asm() {
        return "\n";
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

}
