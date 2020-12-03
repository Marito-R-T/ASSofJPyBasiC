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

import com.mycompany.assofjpybasic.backend.semantica.programa.CallPrograma;
import com.mycompany.assofjpybasic.backend.semantica.programa.CondicionPrograma;
import com.mycompany.assofjpybasic.backend.semantica.programa.ListaTripletes;
import com.mycompany.assofjpybasic.backend.semantica.python.OperacionPython;
import com.mycompany.assofjpybasic.backend.semantica.visual.OperacionVisual;
import com.mycompany.assofjpybasic.frontend.AssGUI;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un If de nivel bajo, donde se pueden obtener ifs,
 * whiles, y fors.
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class Else_Operator extends ListaTripletes {

    private final Etiqueta salida;
    private final GoToOperator gotoo;

    /**
     * Iniciar constructor de IF_ELSE
     */
    public Else_Operator() {
        this.ret = true;
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
        if (con != null && tri != null) {
            List<Triplete> nuevos = new ArrayList<>();
            nuevos.addAll(con.getTriplete());
            nuevos.addAll(con.getBueno());
            nuevos.addAll(tri);
            nuevos.add(gotoo);
            nuevos.addAll(con.getMalo());
            this.addAll(0, nuevos);
        } else {
            AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "Error en el if\n");
        }
    }

    /**
     * Agregar If_else de un if
     *
     * @param con Condiciones del Else
     * @param tri Lista de Tripletes que pertenecen al If
     * @return
     */
    public Else_Operator agregarElseIf(CondicionPrograma con, ListaTripletes tri) {
        if (con != null && tri != null) {
            this.addAll(con.getTriplete());
            this.addAll(con.getBueno());
            this.addAll(tri);
            this.add(gotoo);
            this.addAll(con.getMalo());
            return this;
        } else {
            AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "Error en un Else If\n");
            return this;
        }
    }

    /**
     * Juntar todos los tripletes
     *
     * @param tri Lista de todos los tipletes del Elese
     * @return Retorn todos los tripletes de todos los Ifs
     */
    public ListaTripletes juntarTripletes(ListaTripletes tri) {
        if (tri != null) {
            this.addAll(tri);
            this.add(salida);
            return this;
        } else {
            AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "Error en un Else\n");
            this.ret = false;
            return this;
        }
    }

    /**
     * Armar un WHILE
     *
     * @param con Condicion del While
     * @param tri Tripletes que pertenecen al While
     * @return Retora todos los del While
     */
    public static ListaTripletes WHILE(CondicionPrograma con, ListaTripletes tri) {
        if (con != null && tri != null) {
            Etiqueta et = new Etiqueta();
            ListaTripletes nuevos = new ListaTripletes();
            nuevos.add(et);
            nuevos.addAll(con.getTriplete());
            nuevos.addAll(con.getBueno());
            nuevos.addAll(tri);
            nuevos.add(new GoToOperator(et));
            nuevos.addAll(con.getMalo());
            nuevos.setRet(false);
            return nuevos;
        } else {
            AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "Error en un While\n");
            return new ListaTripletes();
        }
    }

    /**
     * Armar Un Do-While
     *
     * @param con Condicion del Do-While
     * @param tri Tripletes del Do-While
     * @return Retora la lista de todo el While
     */
    public static ListaTripletes DOWHILE(CondicionPrograma con, ListaTripletes tri) {
        if (con != null && tri != null) {
            Etiqueta et = new Etiqueta();
            ListaTripletes nuevos = new ListaTripletes();
            nuevos.add(et);
            nuevos.addAll(tri);
            nuevos.addAll(con.getTriplete());
            nuevos.addAll(con.getBueno());
            nuevos.add(new GoToOperator(et));
            nuevos.addAll(con.getMalo());
            nuevos.setRet(false);
            return nuevos;
        } else {
            AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "Error en un Do While\n");
            return new ListaTripletes();
        }
    }

    /**
     * Armar el For
     *
     * @param asignacion Inicialización del For
     * @param definicion Lista de definicion
     * @param con Condición para finalización del for
     * @param tri Tripletes del For
     * @return Regresa los tripletes del for
     */
    public static ListaTripletes FOR(List<Triplete> asignacion, List<Triplete> definicion, CondicionPrograma con, List<Triplete> tri) {
        if (asignacion != null && definicion != null && con != null && tri != null) {
            Etiqueta et = new Etiqueta();
            ListaTripletes nuevos = new ListaTripletes();
            nuevos.addAll(asignacion);
            nuevos.add(et);
            nuevos.addAll(con.getTriplete());
            nuevos.addAll(con.getBueno());
            nuevos.addAll(tri);
            nuevos.addAll(definicion);
            nuevos.add(new GoToOperator(et));
            nuevos.addAll(con.getMalo());
            nuevos.setRet(false);
            return nuevos;
        } else {
            AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "Error en un For\n");
            return new ListaTripletes();
        }
    }

    /**
     * Armar el For de Python
     *
     * @param ss Suma de p, para encontrar en la pila la variable
     * @param id Id del stack
     * @param op Operaciones de RANGE de python
     * @param tri Tripletes del For
     * @return Regresa los tripletes del for
     */
    public static ListaTripletes FORP(SumOperator ss, Stack id, List<OperacionPython> op, ListaTripletes tri) {
        if (id != null && op != null && tri != null) {
            Etiqueta et = new Etiqueta(), mala = new Etiqueta(), buena = new Etiqueta();
            MenorOperator men;
            ListaTripletes nuevos = new ListaTripletes();
            if (op.size() >= 2) {
                nuevos.addAll(op.get(0).getTripletes());
                nuevos.add(ss);
                nuevos.add(new AsignarValor(id, op.get(0).getTriplete(), "int"));
            } else {
                nuevos.add(ss);
                nuevos.add(new AsignarValor(id, new TerminalOperator("0"), "int"));
            }
            nuevos.add(et);
            SumOperator ss2 = new SumOperator(null, ss.operando1, ss.operando2, "int");
            if (op.size() < 2) {
                nuevos.addAll(op.get(0).mostrarTripletes());
                Triplete ast = new AsignarTemporal(null, new Stack(ss2), "float");
                nuevos.add(ast);
                men = new MenorOperator(op.get(0).getTriplete(), ast);
            } else {
                nuevos.addAll(op.get(1).mostrarTripletes());
                Triplete ast = new AsignarTemporal(null, new Stack(ss2), "float");
                nuevos.add(ast);
                men = new MenorOperator(op.get(1).getTriplete(), ast);
            }
            nuevos.add(ss2);
            If_Operator iff = new If_Operator(men, buena);// Manejo del If
            nuevos.add(iff);
            nuevos.add(new GoToOperator(mala));
            nuevos.add(buena);
            nuevos.addAll(tri);
            SumOperator ss3 = new SumOperator(null, ss.operando1, ss.operando2, "int");
            nuevos.add(ss3);
            if (op.size() < 3) {
                Triplete ast = new AsignarTemporal(null, new Stack(ss3), "float");
                nuevos.add(ast);
                SumOperator sum = new SumOperator(null, ast, new TerminalOperator("1"), "int");
                nuevos.add(sum);
                nuevos.add(new AsignarValor(new Stack(ss3), sum, null));
            } else {
                nuevos.addAll(op.get(2).getTripletes());
                Triplete ast = new AsignarTemporal(null, new Stack(ss3), "float");
                nuevos.add(ast);
                SumOperator sum = new SumOperator(null, ast, op.get(2).getTriplete(), "int");
                nuevos.add(sum);
                nuevos.add(new AsignarValor(new Stack(ss3), sum, null));
            }
            nuevos.add(new GoToOperator(et));
            nuevos.add(mala);
            nuevos.setRet(false);
            return nuevos;
        } else {
            AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "Error en un for de Python\n");
            return new ListaTripletes();
        }
    }

    /**
     * Armar el For de Visual
     *
     * @param direccion Nombre del Id
     * @param tipo Tipo del Id
     * @param inicio Operación de Inicio
     * @param fin Operacion del Fin
     * @param step Operación del Step
     * @param tri Lista de tripletes dentro del For
     * @return Regresa los tripletes del for
     */
    public static ListaTripletes FORV(Integer direccion, String tipo, OperacionVisual inicio, OperacionVisual fin, OperacionVisual step, ListaTripletes tri) {
        if (direccion != null && tipo != null && inicio != null && fin != null && step != null && tri != null) {
            SumOperator smm = new SumOperator(null, new P(), new TerminalOperator(direccion.toString()), "int");
            TerminalOperator term = new Stack(smm);
            Etiqueta et = new Etiqueta(), mala = new Etiqueta(), buena = new Etiqueta();
            ListaTripletes nuevos = new ListaTripletes();
            nuevos.addAll(inicio.mostrarTripletes());
            nuevos.add(smm);
            nuevos.add(new AsignarValor(term, inicio.getTriplete(), tipo));
            nuevos.add(et);
            nuevos.addAll(fin.mostrarTripletes());
            MenorOperator op = new MenorOperator(term, fin.getTriplete());
            nuevos.add(new If_Operator(op, buena));
            nuevos.add(new GoToOperator(mala));
            nuevos.add(buena);
            nuevos.addAll(tri);
            nuevos.addAll(step.mostrarTripletes());
            SumOperator sum = new SumOperator(null, term, step.getTriplete(), CallPrograma.regresarTipo(tipo));
            nuevos.add(sum);
            nuevos.add(new AsignarValor(term, sum, null));
            nuevos.add(new GoToOperator(et));
            nuevos.add(mala);
            nuevos.setRet(false);
            return nuevos;
        } else {
            AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "Error en un For de Visual\n");
            return new ListaTripletes();
        }
    }

    /**
     *
     * @param con Condicion
     * @param tri
     * @return
     */
    public static ListaTripletes IFSIMPLE(CondicionPrograma con, ListaTripletes tri) {
        if (con != null && tri != null) {
            ListaTripletes nuevos = new ListaTripletes();
            nuevos.addAll(con.getTriplete());
            nuevos.addAll(con.getBueno());
            nuevos.addAll(tri);
            nuevos.addAll(con.getMalo());
            nuevos.setRet(false);
            return nuevos;
        } else {
            AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "Error en un If\n");
            return new ListaTripletes();
        }
    }

}
