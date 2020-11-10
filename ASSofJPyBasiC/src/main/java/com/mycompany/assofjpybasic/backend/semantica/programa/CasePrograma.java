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
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Break;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Etiqueta;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.GoToOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.If_Operator;
import com.mycompany.assofjpybasic.frontend.AssGUI;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class CasePrograma extends ListaTripletes {

    private final Etiqueta salida;
    private final GoToOperator gotoo;
    private final List<If_Operator> iffs = new ArrayList<>();

    public CasePrograma() {
        this.ret = true;
        salida = new Etiqueta();
        gotoo = new GoToOperator(salida);
    }

    /**
     * Agregar case a un switch
     *
     * @param operacion Operación de la condición en especifico
     * @param tri Lista de Tripletes que pertenecen al Case
     * @return regresa el Case en cuestión
     */
    public CasePrograma agregarCase(OperacionPrograma operacion, ListaTripletes tri) {
        if (operacion != null && tri != null) {
            this.addAll(operacion.getTripletes());
            Etiqueta n1 = new Etiqueta();
            If_Operator op = new If_Operator(operacion.getTriplete(), n1);
            this.iffs.add(op);
            this.add(op);
            Etiqueta n2 = new Etiqueta();
            this.add(new GoToOperator(n2));
            this.add(n1);
            if (!tri.isEmpty() && tri.get(tri.size() - 1) instanceof Break) {
                tri.remove(tri.size() - 1);
                tri.add(gotoo);
            }
            this.addAll(tri);
            this.add(gotoo);
            this.add(n2);
            return this;
        } else {
            AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "Error en un Case\n");
            return this;
        }
    }

    /**
     * Agregar case a un switch
     *
     * @param operacion Operación de la condición en especifico
     * @param tri Lista de Tripletes que pertenecen al Case
     * @return regresa el Case en cuestión
     */
    public CasePrograma agregarCase(OperacionJava operacion, ListaTripletes tri) {
        if (operacion != null && tri != null) {
            this.addAll(operacion.getTripletes());
            Etiqueta n1 = new Etiqueta();
            If_Operator op = new If_Operator(operacion.getTriplete(), n1);
            this.iffs.add(op);
            this.add(op);
            Etiqueta n2 = new Etiqueta();
            this.add(new GoToOperator(n2));
            this.add(n1);
            if (!tri.isEmpty() && tri.get(tri.size() - 1) instanceof Break) {
                tri.remove(tri.size() - 1);
                tri.add(gotoo);
            }
            this.addAll(tri);
            this.add(gotoo);
            this.add(n2);
            return this;
        } else {
            AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "Error en un Case\n");
            return this;
        }
    }

    public ListaTripletes agregarDefault(OperacionPrograma operacion, ListaTripletes tri) {
        if (operacion != null && tri != null) {
            this.addAll(0, operacion.mostrarTripletes());
            for (If_Operator aIf : iffs) {
                aIf.setOp(operacion.getTriplete());
            }
            this.addAll(tri);
            this.add(gotoo);
            this.add(salida);
            return this;
        } else {
            AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "Error en un default\n");
            return this;
        }
    }

    public ListaTripletes agregarDefault(OperacionJava operacion, ListaTripletes tri) {
        if (operacion != null && tri != null) {
            this.addAll(0, operacion.mostrarTripletes());
            for (If_Operator aIf : iffs) {
                aIf.setOp(operacion.getTriplete());
            }
            this.addAll(tri);
            this.add(gotoo);
            this.add(salida);
            return this;
        } else {
            AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "Error en un Default\n");
            return this;
        }
    }

}
