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
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una lista de tripletes y ayuda a obtener si ya tiene
 * return o no
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class ListaTripletes extends ArrayList<Triplete> {

    protected boolean ret = false;
    protected boolean fin = false;

    public ListaTripletes() {

    }

    public ListaTripletes(boolean fin) {
        this.fin = fin;
    }

    public ListaTripletes(List<Triplete> list) {
        super.addAll(list);
    }

    public ListaTripletes(Triplete list) {
        super.add(list);
    }

    public void setRet(boolean isReturn) {
        this.ret = isReturn;
    }

    public boolean isRet() {
        return ret;
    }

    public boolean addAll(ListaTripletes tripletes) {
        this.ret = this.ret && tripletes.isRet();
        return super.addAll(tripletes);
    }

    public boolean isFin() {
        return fin;
    }

}
