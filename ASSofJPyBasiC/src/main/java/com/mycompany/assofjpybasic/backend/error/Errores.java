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
package com.mycompany.assofjpybasic.backend.error;

import com.mycompany.assofjpybasic.frontend.AssGUI;
import java_cup.runtime.Symbol;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class Errores {

    public void errorSintactico(Symbol sym, int line) {
        AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "No se esperaba el simbolo: " + sym.value
                + "\n\t<linea>: " + (sym.right + line + 1) + "  <columna>: " + (sym.left + 1) + "\n\n");
    }

    public void errorSemantico(Symbol sym, String texto, int line) {
        AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + texto
                + "\n\tEntre la <linea>: " + (sym.right + line + 1) + " y <linea>: " + (sym.right + line) + "\n\n");
    }

}
