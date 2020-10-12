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

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class AsignarTemporal extends Triplete {

    private String tipo;

    public AsignarTemporal(String id, Triplete operando1, String tipo) {
        super(id, operando1, null);
        this.tipo = tipo;
        this.id = "t" + Triplete.VARNUM;
        Triplete.VARNUM++;
    }

    @Override
    public String devolverString() {
        String d = this.tipo + " " + this.id + " = " + this.operando1.getId() + ";";
        return d;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
