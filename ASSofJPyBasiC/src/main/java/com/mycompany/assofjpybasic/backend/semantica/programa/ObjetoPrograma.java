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
import com.mycompany.assofjpybasic.backend.semantica.java.TablaJava;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AsignarValor;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.CallMetodo;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.P;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.RestOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Stack;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.SumOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.TerminalOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un Objeto Java en el lenguaje C
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class ObjetoPrograma {

    private final String id;
    private final List<OperacionPrograma> op;

    public ObjetoPrograma(String id, List<OperacionPrograma> op) {
        this.id = id;
        this.op = op;
    }

    public String getId() {
        return id;
    }

    public List<OperacionPrograma> getOp() {
        return op;
    }

    public static List<Triplete> triplete(String id, List<ObjetoPrograma> lista, ProgramaSemantica sem, Integer ambito) {
        List<Triplete> tri = new ArrayList<>();
        for (ObjetoPrograma objetoPrograma : lista) {
            Integer integ = sem.getVariables().getTamano();
            TablaJava met = objetoPrograma.obtenerMetodo(id, sem);
            CallPrograma pro = objetoPrograma.getCall(id, sem, integ);
            VariablePrograma var = new VariablePrograma(objetoPrograma.id, ambito, id, pro.getTriplete());
            var.setHeap(sem.getHeap());
            sem.setHeap(sem.getHeap() + met.getVar_definidas().size());
            if (pro != null && sem.addVar(var)) {
                SumOperator sum = new SumOperator(null, new P(), new TerminalOperator("" + integ), "int");
                tri.add(sum);
                tri.add(new AsignarValor(null, new Stack(sum), new TerminalOperator("" + var.getHeap())));
                tri.addAll(pro.mostrarTripletes());
                tri.add(pro.getTriplete());
                RestOperator rest = new RestOperator(null, new P(), new TerminalOperator("" + integ), "int");
                tri.add(rest);
                tri.add(new AsignarValor(null, new P(), rest));
            }
        }
        return tri;
    }

    public CallPrograma getCall(String id, ProgramaSemantica sem, Integer size) {
        MetodoJava met = sem.existeConstructorJV(id, id, op);
        if (met != null) {
            return new CallPrograma(op, new CallMetodo(CallPrograma.regresarJava(met, id)),
                    CallPrograma.regresarTipo(met), size);
        } else {
            return null;
        }
    }

    public TablaJava obtenerMetodo(String id, ProgramaSemantica sem) {
        return sem.existeClase(id);
    }

}
