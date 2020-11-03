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
package com.mycompany.assofjpybasic.backend;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class prueba2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        prueba2 p = new prueba2();
        p.hacer();
    }

    public void hacer() {
        try {
            String s;
            s = this.getClass().getResource("/programa.c").getPath();
            File file = new File(s);
            System.out.println(s);
            Process pr = Runtime.getRuntime().exec(new String[]{"gcc", "programa.c", "-lm", "-o", "programa"}, null, file.getParentFile());
            pr.waitFor();
            int i = pr.exitValue();
            System.out.println(i);
            pr = Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", "xterm -e \"./programa\""}, null, file.getParentFile());
            //pr = Runtime.getRuntime().exec(new String[]{"xterm", "-e", "./programa.c"}, null, file.getParentFile());
            pr.waitFor();
            i = pr.exitValue();
            System.out.println(i);
        } catch (IOException ex) {
            Logger.getLogger(prueba2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(prueba2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
