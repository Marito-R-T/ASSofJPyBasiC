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

import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class ConstantePrograma extends VariablePrograma {

    private final boolean inicializado;

    /**
     * Constructor de una variable del programa principal C
     *
     * @param id Es el id que tiene la variable
     * @param ambito Es el ambito al que pertenece la variable
     * @param tipo Tipo de la que es el variable, 1->char 2->int 3->float
     * @param expr Tipo de la expresión que venía, si es falso genera un error
     * @param tri Triplete que sera parte de esta constante
     */
    public ConstantePrograma(String id, Integer ambito, Integer tipo, Integer expr, Triplete tri) {
        super(id, ambito, tipo, tri);
        super.setConstant(true);
        inicializado = expr != null;
    }

}
