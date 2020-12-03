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

import com.mycompany.assofjpybasic.backend.semantica.java.MetodoJava;
import com.mycompany.assofjpybasic.backend.semantica.java.OperacionJava;
import com.mycompany.assofjpybasic.backend.semantica.java.VariableJava;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AsignarTemporal;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AsignarValor;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.P;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Stack;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.SumOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.TerminalOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import com.mycompany.assofjpybasic.backend.semantica.python.MetodoPython;
import com.mycompany.assofjpybasic.backend.semantica.python.OperacionPython;
import com.mycompany.assofjpybasic.backend.semantica.python.VariablePython;
import com.mycompany.assofjpybasic.backend.semantica.visual.MetodoVisual;
import com.mycompany.assofjpybasic.backend.semantica.visual.OperacionVisual;
import com.mycompany.assofjpybasic.backend.semantica.visual.VariableVisual;
import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class CallPrograma extends OperacionPrograma {

    public CallPrograma(List<OperacionPrograma> operaciones, Triplete triplete, Integer tipo, Integer size) {
        super(tipo, triplete);
        this.hacerTripletes(operaciones, size);
    }

    /**
     * Metodo para agregar los tripletes de los parametros
     *
     * @param operaciones Parametros a ingresar
     * @param size tamaño de p al inicio
     */
    public final void hacerTripletes(List<OperacionPrograma> operaciones, Integer size) {
        int i = 2;
        for (OperacionPrograma operacione : operaciones) {
            this.getTripletes().addAll(operacione.getTripletes());
            SumOperator sum = new SumOperator(null, new P(), new TerminalOperator("" + (i + size)), "int");
            this.getTripletes().add(sum);
            this.getTripletes().add(new AsignarValor(null, new Stack(sum), operacione.triplete));
            i++;
        }
        SumOperator sum = new SumOperator(null, new P(), new TerminalOperator("" + size), "int");
        this.getTripletes().add(sum);
        this.getTripletes().add(new AsignarValor(null, new P(), sum));
    }

    public static String regresarJava(MetodoJava java, String id) {
        String s = "JV_" + id + "_" + java.getId();
        int i = 0;
        for (VariableJava parametro : java.getParametros()) {
            i++;
            s += "_" + OperacionJava.obtenerTipo(parametro.getTipo());
        }
        return s;
    }

    public static String regresarPy(MetodoPython java) {
        String s = "PY_" + java.getId();
        int i = 0;
        for (VariablePython parametro : java.getParametros()) {
            i++;
            s += "_" + OperacionPython.obtenerTipo(parametro.getTipo());
        }
        return "call " + s + " " + i;
    }

    public static String regresarVB(MetodoVisual java) {
        String s = "VB_" + java.getId();
        int i = 0;
        for (VariableVisual parametro : java.getParametros()) {
            i++;
            s += "_" + OperacionVisual.obtenerTipo(parametro.getTipo());
        }
        return "call " + s + " " + i;
    }

    public static int regresarTipo(MetodoJava java) {
        switch (java.getTIPO()) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                return 4;
        }
    }

    public static int regresarTipo(MetodoPython py) {
        switch (py.getTIPO()) {
            case "INT":
                return 2;
            case "CHAR":
                return 1;
            case "INT-FLOAT":
                return 3;
            default:
                return 4;
        }
    }

    public static int regresarTipo(MetodoVisual vb) {
        switch (vb.getTIPO()) {
            case "INT":
                return 2;
            case "CHAR":
                return 1;
            case "INT-FLOAT":
                return 3;
            default:
                return 4;
        }
    }

    public static String regresarTipo(String tipo) {
        switch (tipo) {
            case "INT":
                return "int";
            case "CHAR":
                return "char";
            case "INT-FLOAT":
                return "float";
            default:
                return null;
        }
    }

}
