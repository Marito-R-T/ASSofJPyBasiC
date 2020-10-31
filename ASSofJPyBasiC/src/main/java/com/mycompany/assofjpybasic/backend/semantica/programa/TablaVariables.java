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
package com.mycompany.assofjpybasic.backend.semantica.programa;

import com.mycompany.assofjpybasic.backend.semantica.java.OperacionJava;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AsignarValor;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.SumOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.TerminalOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la tabla de simbolos
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class TablaVariables extends ArrayList<VariablePrograma> {

    private int tamano = 0;

    public Integer direccionVar(String var) {
        int i = 0;
        for (VariablePrograma thi : this) {
            if (thi.getId().equals(var)) {
                return i;
            }
            i += thi.getTamano();
        }
        return i;
    }

    @Override
    public boolean add(VariablePrograma var) {
        var.setDireccion(tamano);
        tamano += var.getTamano();
        return super.add(var);
    }

    public Integer obtenerDireccion(String id) {
        for (VariablePrograma variable : this) {
            if (variable.getId().equals(id)) {
                return variable.getDireccion();
            }
        }
        return 0;
    }

    public String devolverDireccion(String id) {
        return "stack[" + id + "]";
    }

    public SumOperator devolverSum(String id) {
        return new SumOperator(null, new TerminalOperator("p"), new TerminalOperator(this.obtenerDireccion(id).toString()), "int");
    }

    /**
     * Metodo para obtener Tripletes de asignacion de variables
     *
     * @param var Lista de variables de java
     * @param tipo tipo de la variable a asignar
     * @return Lista de tripletes final
     */
    public List<Triplete> obtenerTripletes(List<VariablePrograma> var, Integer tipo) {
        List<Triplete> tri = new ArrayList<>();
        for (VariablePrograma variableJava : var) {
            if (variableJava.getTriplete() instanceof AsignarValor) {
                ((AsignarValor) variableJava.getTriplete()).setTipo(OperacionJava.obtenerTipo(tipo));
                tri.addAll(variableJava.getTripletes());
                if (variableJava.getTriplete().getOperando2() != null) {
                    SumOperator sum = this.devolverSum(variableJava.getId());
                    tri.add(sum);
                    tri.add(new AsignarValor(new TerminalOperator(this.devolverDireccion(sum.getId())), variableJava.getTriplete().getOperando2(), null));
                }
            }
        }
        return tri;
    }

    /**
     * Metodo para obtener Tripletes de asignacion de variables
     *
     * @param var Lista de variables de java
     * @param tipo tipo de la variable a asignar
     * @return Lista de tripletes final
     */
    public List<Triplete> obtenerTriplete(VariablePrograma var, Integer tipo) {
        List<Triplete> tri = new ArrayList<>();
        if (var.getTriplete() instanceof AsignarValor) {
            ((AsignarValor) var.getTriplete()).setTipo(OperacionJava.obtenerTipo(tipo));
            tri.addAll(var.getTripletes());
            if (var.getTriplete().getOperando2() != null) {
                SumOperator sum = this.devolverSum(var.getId());
                tri.add(sum);
                tri.add(new AsignarValor(new TerminalOperator(this.devolverDireccion(sum.getId())), var.getTriplete().getOperando2(), null));
            }
        }
        return tri;
    }

    public int getTamano() {
        return tamano;
    }

}
