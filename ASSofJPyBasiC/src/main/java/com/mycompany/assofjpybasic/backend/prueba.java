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
import com.mycompany.assofjpybasic.backend.analizador.principal.LexicoPrograma;
import com.mycompany.assofjpybasic.backend.analizador.principal.SintaxisPrograma;
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
        /*File file = new File("/home/mari2bar/Escritorio/prueba2.mlg");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String s = "";
        String a;
        while ((a = br.readLine()) != null) {
            s += a + "\n";
        }*/
        String s = "%%VB\n"
                + "\n"
                + "Public Sub Saludo()\n"
                + "\n"
                + "    Console.write(\"Segundo Proyecto de Compiladores 2\")\n"
                + "\n"
                + "End Sub \n"
                + "\n"
                + "Function Factorial(n As Integer) as integer\n"
                + "\n"
                + "    Dim Fact, Num As Integer\n"
                + "    Num = N\n"
                + "    If N = 0 Then\n"
                + "	Fact = 1\n"
                + "    Elseif N != 0 Then\n"
                + "     fact = 2\n"
                + "    Else\n"
                + "        Fact = 1\n"
                + "        Do\n"
                + "            Fact = Fact * N\n"
                + "            N = N - 1\n"
                + "        Loop While N > 1\n"
                + "	Fact = Fact\n"
                + "    End If\n"
                + "End Function\n"
                + "%%JAVA\n"
                + "public class algo {\n"
                + "\n"
                + "     int s2 = 25;\n"
                + "	    public int holaMundo() {\n"
                + "         int i2 = 12*3-2/8;\n"
                + "         System.out.println(\"la suma es:\"+i2);\n"
                + "         while(1<i2){\n"
                + "             int i3;\n"
                + "             System.out.print(\"i2 es: \" + i2);\n"
                + "         }\n"
                + "         if(12>1){\n"
                + "                if(65/2 == 15) {\n"
                + "                        return 14;\n"
                + "                } else {\n"
                + "                    return 15%8;\n"
                + "                }\n"
                + "            } else if(15<2) {\n"
                + "                 return 45;\n"
                + "            } else{\n"
                + "            }\n"
                + "             return 45;\n"
                + "	}\n"
                + "     \n"
                + "     public void holaMundo(int s) {\n"
                + "             int i2 = 12;\n"
                + "             int i3 = s*s2;\n"
                + "     }\n"
                + "}\n"
                + "\n"
                + "%%PY\n"
                + "\n"
                + "def edadmeses(edad, meses):\n"
                + "	edad = intinput(\"Ingrese su edad:\")\n"
                + "	meses = edad * 12.2\n"
                + "	print(\"meses = \",meses)\n"
                + "	intinput(\"\")"
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
                + "  base = 10*25 -5/5%1;\n"
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
                + "  i = Arreglo1[1*1][2];\n"
                + " \n"
                + "  printf(\"El factorial de %d es %d\",i,resultado);\n"
                + "    \n"
                + "  printf(\"Conversion de años a meses\");\n"
                + "\n"
                + "  PY.edadmeses(0 , 12);\n"
                + "  if(3<2 && i*3==6){\n"
                + "\n"
                + "  }\n"
                + "\n"
                + "  switch(i*2){\n"
                + "  case 0: \n"
                + "  printf(\"primer case\");"
                + "  break;\n"
                + "  case 1: \n"
                + "  printf(\"hola\");\n"
                + "  default: \n"
                + "  printf(\"aaaa\");"
                + "  }\n"
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
        SintaxisPrograma pro = new SintaxisPrograma(new LexicoPrograma(new StringReader(archivo.getPrograma())));
        pro.setTipo(archivo.getJava(), archivo.getVisual(), archivo.getPython());
        pro.parse();
    }

}
