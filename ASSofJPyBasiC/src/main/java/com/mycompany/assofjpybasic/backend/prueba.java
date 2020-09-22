/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend;

import com.mycompany.assofjpybasic.backend.analizador.LexicoPrincipal;
import com.mycompany.assofjpybasic.backend.analizador.SintaxisPrincipal;
import com.mycompany.assofjpybasic.backend.analizador.python.LexicoPython;
import com.mycompany.assofjpybasic.backend.analizador.python.SintaxisPython;
import com.mycompany.assofjpybasic.backend.analizador.visual.LexicoVisual;
import com.mycompany.assofjpybasic.backend.analizador.visual.SintaxisVisual;
import com.mycompany.assofjpybasic.backend.classes.ArchivoMLG;
import java.io.StringReader;

/**
 *
 * @author mari2bar
 */
public class prueba {

    int a_$as = 1;

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        String s = "%%VB\n"
                + "Public Module mod1\n"
                + "    public SUB main()\n"
                + "    dIm n1 as Integer = 5*5/8 mod 9+2\n"
                + "    console.writeline(\"hola\")\n"
                + "    if n1 > 3\n"
                + "        console.writeline(n1)\n"
                + "    end if\n"
                + "    end sub\n"
                + "end module\n"
                + "\n"
                + "%%JAVA\n"
                + "\n"
                + "%%PY\n"
                + "def n1():\n"
                + "\t\tprint(\"hola\")\n"
                + "\t\tprint(\"hola\")\n"
                + "\t\tprint(\"hola\")\n"
                + "def n2():\n"
                + "\tprint(\"hola2\")\n"
                + "def n3(i2, i3):\n"
                + "\twhile i2 < i3:\n"
                + "\t\tprint(\"hola\")\n"
                + "\t\ti2 += 1\n"
                + "\n"
                + "%%PROGRAMA";
        LexicoPrincipal p = new LexicoPrincipal(new StringReader(s));
        SintaxisPrincipal lengua = new SintaxisPrincipal(new LexicoPrincipal(new StringReader(s)));
        ArchivoMLG archivo = (ArchivoMLG) lengua.parse().value;
        System.out.println("visual = " + archivo.getVisual());
        System.out.println("java = " + archivo.getJava());
        System.out.println("python = " + archivo.getPython());
        System.out.println("programa = " + archivo.getPrograma());
        SintaxisVisual sv = new SintaxisVisual(new LexicoVisual(new StringReader(archivo.getVisual())));
        sv.parse();
        SintaxisPython py = new SintaxisPython(new LexicoPython(new StringReader(archivo.getPython())));
        py.parse();
    }

}
