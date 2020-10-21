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
package com.mycompany.assofjpybasic.backend.semantica.visual;

import com.mycompany.assofjpybasic.backend.semantica.programa.CondicionPrograma;
import com.mycompany.assofjpybasic.backend.semantica.programa.IfPrograma;
import com.mycompany.assofjpybasic.backend.semantica.programa.ListaTripletes;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Etiqueta;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.GoToOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.If_Operator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class CaseVisual extends ListaTripletes {

    private final Etiqueta salida;
    private final GoToOperator gotoo;
    private final List<If_Operator> iffs = new ArrayList<>();

    public CaseVisual() {
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
    public CaseVisual agregarCase(List<OperacionVisual> operacion, ListaTripletes tri) {
        for (OperacionVisual operacionVisual : operacion) {
            this.addAll(operacionVisual.getTripletes());
        }
        Etiqueta n1 = new Etiqueta();
        CondicionPrograma pro = null;
        for (OperacionVisual operacionVisual : operacion) {
            If_Operator iff = new If_Operator(operacionVisual.getTriplete(), new Etiqueta());
            if (pro == null) {
                pro = new IfPrograma(iff, operacionVisual.getTripletes());
            } else {
                pro = IfPrograma.OR(pro, new IfPrograma(iff, operacionVisual.getTripletes()));
            }
            this.iffs.add(iff);
        }
        this.addAll(pro.getTriplete());
        this.addAll(pro.getBueno());
        this.addAll(tri);
        this.add(gotoo);
        this.addAll(pro.getMalo());
        return this;
    }

    public ListaTripletes agregarDefault(OperacionVisual operacion, ListaTripletes tri) {
        this.addAll(0, operacion.mostrarTripletes());
        iffs.forEach((aIf) -> {
            aIf.setOp(operacion.getTriplete());
        });
        this.addAll(tri);
        this.add(salida);
        return this;
    }

}
