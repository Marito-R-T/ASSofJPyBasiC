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

import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Etiqueta;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.GoToOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.If_Operator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class IfPrograma extends CondicionPrograma {

    private If_Operator tri;

    /**
     * Constructor
     *
     * @param tri Triplete If del que pertenece
     * @param tripletes Tripletes de las Operaciones antes de hacer el If
     */
    public IfPrograma(If_Operator tri, List<Triplete> tripletes) {
        this.tri = tri;
        Etiqueta et = new Etiqueta();
        this.bueno.add(tri.getEt());
        this.malo.add(et);
        this.triplete.addAll(tripletes);
        this.triplete.add(tri);
        this.triplete.add(new GoToOperator(et));
    }

    /**
     * Constructor
     *
     * @param tri Triplete If del que pertenece
     */
    public IfPrograma(If_Operator tri) {
        this.tri = tri;
        Etiqueta et = new Etiqueta();
        bueno.add(tri.getEt());
        malo.add(et);
        this.triplete.add(tri);
        this.triplete.add(new GoToOperator(et));
    }

    public Triplete getTri() {
        return tri;
    }

    public static CondicionPrograma OR(CondicionPrograma pro1, CondicionPrograma pro2) {
        CondicionPrograma con = new CondicionPrograma();
        con.getMalo().addAll(pro2.getMalo());
        con.getBueno().addAll(pro1.getBueno());
        con.getBueno().addAll(pro2.getBueno());
        con.getTriplete().addAll(pro1.getTriplete());
        for (Etiqueta et : pro1.getMalo()) {
            con.getTriplete().add(et);
        }
        con.getTriplete().addAll(pro2.getTriplete());
        return con;
    }

    public static CondicionPrograma AND(CondicionPrograma pro1, CondicionPrograma pro2) {
        CondicionPrograma con = new CondicionPrograma();
        con.getMalo().addAll(pro1.getMalo());
        con.getMalo().addAll(pro2.getMalo());
        con.getBueno().addAll(pro2.getBueno());
        con.getTriplete().addAll(pro1.getTriplete());
        for (Etiqueta et : pro1.getBueno()) {
            con.getTriplete().add(et);
        }
        con.getTriplete().addAll(pro2.getTriplete());
        return con;
    }

    public static CondicionPrograma NOT(CondicionPrograma pro1) {
        CondicionPrograma programa = new CondicionPrograma();
        programa.getTriplete().addAll(pro1.getTriplete());
        programa.getBueno().addAll(pro1.getMalo());
        programa.getMalo().addAll(pro1.getBueno());
        return programa;
    }

}
