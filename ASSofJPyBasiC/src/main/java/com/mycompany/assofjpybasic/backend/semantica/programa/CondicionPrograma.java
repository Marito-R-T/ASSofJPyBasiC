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
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class CondicionPrograma {

    protected List<Triplete> triplete = new ArrayList<>();
    protected List<Etiqueta> malo = new ArrayList<>();
    protected List<Etiqueta> bueno = new ArrayList<>();

    public List<Triplete> getTriplete() {
        return triplete;
    }

    public List<Etiqueta> getMalo() {
        return malo;
    }

    public List<Etiqueta> getBueno() {
        return bueno;
    }

    public void leerBuenos() {
        triplete.forEach((trip) -> {
            System.out.println(trip.devolverString());
        });
        malo.forEach((etiqueta) -> {
            System.out.println(etiqueta.devolverString());
        });
        System.out.println("malos");
        bueno.forEach((etiqueta) -> {
            System.out.println(etiqueta.devolverString());
        });
        System.out.println("buenos");
    }

}
