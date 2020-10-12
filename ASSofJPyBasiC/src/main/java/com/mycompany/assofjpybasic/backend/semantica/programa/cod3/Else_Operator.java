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

import com.mycompany.assofjpybasic.backend.semantica.programa.CondicionPrograma;
import com.mycompany.assofjpybasic.backend.semantica.python.OperacionPython;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class Else_Operator extends ArrayList<Triplete> {

    private final Etiqueta salida;
    private final GoToOperator gotoo;

    /**
     * Iniciar constructor de IF_ELSE
     */
    public Else_Operator() {
        salida = new Etiqueta();
        gotoo = new GoToOperator(salida);
    }

    /**
     * Agregar IF al constructor
     *
     * @param con Condiciones del If
     * @param tri Lista de tripletes del If
     */
    public void agregarIf(CondicionPrograma con, List<Triplete> tri) {
        List<Triplete> nuevos = new ArrayList<>();
        nuevos.addAll(con.getTriplete());
        nuevos.addAll(con.getBueno());
        nuevos.addAll(tri);
        nuevos.add(gotoo);
        nuevos.addAll(con.getMalo());
        this.addAll(0, nuevos);
    }

    /**
     * Agregar If_else de un if
     *
     * @param con Condiciones del Else
     * @param tri Lista de Tripletes que pertenecen al If
     * @return
     */
    public Else_Operator agregarElseIf(CondicionPrograma con, List<Triplete> tri) {
        this.addAll(con.getTriplete());
        this.addAll(con.getBueno());
        this.addAll(tri);
        this.add(gotoo);
        this.addAll(con.getMalo());
        return this;
    }

    /**
     * Juntar todos los tripletes
     *
     * @param tri Lista de todos los tipletes del Elese
     * @return Retorn todos los tripletes de todos los Ifs
     */
    public List<Triplete> juntarTripletes(List<Triplete> tri) {
        this.addAll(tri);
        this.add(salida);
        return this;
    }

    /**
     * Armar un WHILE
     *
     * @param con Condicion del While
     * @param tri Tripletes que pertenecen al While
     * @return Retora todos los del While
     */
    public static List<Triplete> WHILE(CondicionPrograma con, List<Triplete> tri) {
        Etiqueta et = new Etiqueta();
        List<Triplete> nuevos = new ArrayList<>();
        nuevos.add(et);
        nuevos.addAll(con.getTriplete());
        nuevos.addAll(con.getBueno());
        nuevos.addAll(tri);
        nuevos.add(new GoToOperator(et));
        nuevos.addAll(con.getMalo());
        return nuevos;
    }

    /**
     * Armar Un Do-While
     *
     * @param con Condicion del Do-While
     * @param tri Tripletes del Do-While
     * @return Retora la lista de todo el While
     */
    public static List<Triplete> DOWHILE(CondicionPrograma con, List<Triplete> tri) {
        Etiqueta et = new Etiqueta();
        List<Triplete> nuevos = new ArrayList<>();
        nuevos.add(et);
        nuevos.addAll(tri);
        nuevos.addAll(con.getTriplete());
        nuevos.addAll(con.getBueno());
        nuevos.add(new GoToOperator(et));
        nuevos.addAll(con.getMalo());
        return nuevos;
    }

    /**
     * Armar el For
     *
     * @param asignacion Inicialización del For
     * @param definición Step del For
     * @param con Condición para finalización del for
     * @param tri Tripletes del For
     * @return Regresa los tripletes del for
     */
    public static List<Triplete> FOR(List<Triplete> asignacion, List<Triplete> definición, CondicionPrograma con, List<Triplete> tri) {
        Etiqueta et = new Etiqueta();
        List<Triplete> nuevos = new ArrayList<>();
        nuevos.addAll(asignacion);
        nuevos.add(et);
        nuevos.addAll(con.getTriplete());
        nuevos.addAll(con.getBueno());
        nuevos.addAll(tri);
        nuevos.addAll(definición);
        nuevos.add(new GoToOperator(et));
        nuevos.addAll(con.getMalo());
        return nuevos;
    }

    /**
     * Armar el For de Python
     *
     * @param id
     * @param op
     * @param tri Tripletes del For
     * @return Regresa los tripletes del for
     */
    public static List<Triplete> FORP(String id, List<OperacionPython> op, List<Triplete> tri) {
        TerminalOperator terminal = new TerminalOperator(id);
        Etiqueta et = new Etiqueta(), mala = new Etiqueta(), buena = new Etiqueta();
        MenorOperator men;
        List<Triplete> nuevos = new ArrayList<>();
        if (op.size() >= 2) {
            nuevos.addAll(op.get(0).getTripletes());
            nuevos.add(new AsignarValor(terminal, op.get(0).getTriplete(), "int"));
        } else {
            nuevos.add(new AsignarValor(terminal, new TerminalOperator("0"), "int"));
        }
        nuevos.add(et);
        if (op.size() < 2) {
            nuevos.addAll(op.get(0).mostrarTripletes());
            men = new MenorOperator(op.get(0).getTriplete(), terminal);
        } else {
            nuevos.addAll(op.get(1).mostrarTripletes());
            men = new MenorOperator(op.get(1).getTriplete(), terminal);
        }
        If_Operator iff = new If_Operator(men, buena);// Manejo del If
        nuevos.add(iff);
        nuevos.add(new GoToOperator(mala));
        nuevos.add(buena);
        nuevos.addAll(tri);
        if (op.size() < 3) {
            SumOperator sum = new SumOperator(null, terminal, new TerminalOperator("1"), "int");
            nuevos.add(sum);
            nuevos.add(new AsignarValor(terminal, sum, null));
        } else {
            nuevos.addAll(op.get(2).getTripletes());
            SumOperator sum = new SumOperator(null, terminal, op.get(2).getTriplete(), "int");
            nuevos.add(sum);
            nuevos.add(new AsignarValor(terminal, sum, null));
        }
        nuevos.add(new GoToOperator(et));
        nuevos.add(mala);
        return nuevos;
    }

}
