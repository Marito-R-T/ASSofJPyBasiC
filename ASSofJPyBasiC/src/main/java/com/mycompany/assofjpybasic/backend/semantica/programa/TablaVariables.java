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

import java.util.ArrayList;

/**
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

}
