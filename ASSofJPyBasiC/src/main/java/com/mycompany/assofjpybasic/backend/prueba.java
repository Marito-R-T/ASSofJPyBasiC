/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend;

import com.mycompany.assofjpybasic.backend.analizador.LexicoPrincipal;
import com.mycompany.assofjpybasic.backend.analizador.SintaxisPrincipal;
import com.mycompany.assofjpybasic.backend.analizador.java.LexicoJava;
import com.mycompany.assofjpybasic.backend.analizador.java.SintaxisJava;
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

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        String s = "%%VB\n"
                + "\n"
                + "Public Sub Saludo()\n"
                + "\n"
                + "    Console.write(\"Segundo Proyecto de Compiladores 2\")\n"
                + "\n"
                + "End Sub \n"
                + "\n"
                + "\n"
                + "Function Factorial(N As Integer) as integer\n"
                + "\n"
                + "    Dim Fact, Num As Integer\n"
                + "    Num = N\n"
                + "    If N = 0 Then\n"
                + "	Factorial = 1\n"
                + "    Else\n"
                + "        Fact = 1\n"
                + "        Do\n"
                + "            Fact = Fact * N\n"
                + "            N = N - 1\n"
                + "        Loop While N > 1\n"
                + "	Factorial = Fact\n"
                + "    End If\n"
                + "End Function\n"
                + "\n"
                + "%%JAVA\n"
                + "public class algo {\n"
                + "\n"
                + "	public int holaMundo() {\n"
                + "		System.out.println(\"asasasd\");\n"
                + "	}\n"
                + "}\n"
                + "\n"
                + "%%PY\n"
                + "\n"
                + "def edadmeses(edad, meses):\n"
                + "	edad = intinput(\"Ingrese su edad:\")\n"
                + "	meses = edad * 12\n"
                + "	print(\"meses = \",meses)\n"
                + "	intinput(\"\")\n"
                + "\n"
                + "\n"
                + "\n"
                + "%%PROGRAMA\n"
                + "\n"
                + "#include <stdio.h>\n"
                + "#include <stdlib.h>\n"
                + "#include \"VB\"\n"
                + "#include \"PY\"\n"
                + "\n"
                + "// Constantes\n"
                + "const int constante1 = 10;\n"
                + "\n"
                + "// Variables globales\n"
                + "int Arreglo1[1][4];\n"
                + "\n"
                + "void main()\n"
                + "{\n"
                + "  int base, exp, i, resultado;\n"
                + "  \n"
                + "  clrscr();\n"
                + "  \n"
                + "  printf(\"Bienvenido\");\n"
                + "\n"
                + "  VB.Saludo();\n"
                + "\n"
                + "  printf(\"Ingrese el primer valor entero\");\n"
                + "  scanf(\"%d\",&base);\n"
                + "  printf(\"Ingrese el segudo valor entero\");\n"
                + "  scanf(\"%d\",&exp);\n"
                + "\n"
                + "  // Factorial\n"
                + "  resultado = VB.Factorial(i);\n"
                + " \n"
                + "  printf(\"El factorial de %d es %d\",&a,&resultado);\n"
                + "    \n"
                + "  printf(\"Conversion de años a meses\");\n"
                + "\n"
                + "  PY.edadmeses();\n"
                + "\n"
                + "  // Arreglo\n"
                + "  Arreglo1[1][1] = 0;\n"
                + "  \n"
                + "  // inicio for\n"
                + "  for(i = 0; i <= exp; i = i + 1)\n"
                + "  {\n"
                + "	resultado = resultado * base;\n"
                + "	\n"
                + "  } // fin for\n"
                + "  \n"
                + "  printf(\"%d \",base);\n"
                + "  printf(\"^ %d\",exp);\n"
                + "  printf(\" = %d\",resultado);\n"
                + "\n"
                + "  getch();\n"
                + "}";
        SintaxisPrincipal lengua = new SintaxisPrincipal(new LexicoPrincipal(new StringReader(s)));
        ArchivoMLG archivo = (ArchivoMLG) lengua.parse().value;
        System.out.println("visual = " + archivo.getVisual());
        System.out.println("java = " + archivo.getJava());
        System.out.println("python = " + archivo.getPython());
        System.out.println("programa = " + archivo.getPrograma());
        SintaxisVisual vb = new SintaxisVisual(new LexicoVisual(new StringReader(archivo.getVisual())));
        vb.parse();
        SintaxisPython py = new SintaxisPython(new LexicoPython(new StringReader(archivo.getPython())));
        py.parse();
        SintaxisJava jv = new SintaxisJava(new LexicoJava(new StringReader(archivo.getJava())));
        jv.parse();
        char ii = 'c' + 65;
        System.out.println(ii);
    }

}
