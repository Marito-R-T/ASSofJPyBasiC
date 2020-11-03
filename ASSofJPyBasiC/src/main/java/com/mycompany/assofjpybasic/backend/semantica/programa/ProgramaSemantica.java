/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.programa;

import com.mycompany.assofjpybasic.backend.analizador.java.LexicoJava;
import com.mycompany.assofjpybasic.backend.analizador.java.SintaxisJava;
import com.mycompany.assofjpybasic.backend.analizador.python.LexicoPython;
import com.mycompany.assofjpybasic.backend.analizador.python.SintaxisPython;
import com.mycompany.assofjpybasic.backend.analizador.visual.LexicoVisual;
import com.mycompany.assofjpybasic.backend.analizador.visual.SintaxisVisual;
import com.mycompany.assofjpybasic.backend.semantica.java.MetodoJava;
import com.mycompany.assofjpybasic.backend.semantica.java.TablaJava;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import com.mycompany.assofjpybasic.backend.semantica.python.MetodoPython;
import com.mycompany.assofjpybasic.backend.semantica.visual.MetodoVisual;
import com.mycompany.assofjpybasic.frontend.AssGUI;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que contiene toda las referencias necesarias del programa de un codigo.
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class ProgramaSemantica {

    public static Integer AMBITO = 0;
    private final TablaVariables variables = new TablaVariables();
    private List<MetodoVisual> metodosVisual = new ArrayList<>();
    private List<MetodoPython> metodosPython = new ArrayList<>();
    private Integer heap = 0;
    private List<TablaJava> clasesJava = new ArrayList<>();
    private List<TablaJava> clasesImportadas = new ArrayList<>();
    private List<Triplete> tripletes = new ArrayList<>();
    private List<Triplete> var = new ArrayList<>();
    private List<String> imports = new ArrayList<>();

    /**
     * Constructor de la semantica del programa, donde se inicializa el ambito a
     * cero
     */
    public ProgramaSemantica() {
        ProgramaSemantica.AMBITO = 0;
    }

    /**
     * Metodo para agregar un listado de variables
     *
     * @param var Variables a verificar su existencia
     * @param tipo Tipo de las variables
     * @return retorna el tipo de variable que es, si no lo ingresa regresa
     * false, si lo ingresa regresa true
     */
    public boolean addListVar(List<VariablePrograma> var, Integer tipo) {
        for (VariablePrograma variableVisual : var) {
            if (this.existeVar(variableVisual) == null) {
                if (variableVisual.getTipo() == null || tipo >= variableVisual.getTipo()) {
                    variableVisual.setTipo(tipo);
                } else {
                    return false;
                }
                variableVisual.setDireccion(this.variables.size());
                variables.add(variableVisual);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo para agregar una variable del Prgorama
     *
     * @param var Variable para agregar en el listado
     * @return Regresa true si se pudo agregar la variable, false si no se puedo
     */
    public boolean addVar(VariablePrograma var) {
        if (this.existeVar(var) == null) {
            var.setDireccion(this.variables.size());
            variables.add(var);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo para verificar existencia de una variable
     *
     * @param var Variable a verificar su existencia
     * @return retorna el tipo de variable que es, si no lo encuentra regresa
     * null
     */
    public VariablePrograma existeVar(VariablePrograma var) {
        for (VariablePrograma variable : variables) {
            if (variable.getId().equals(var.getId())) {
                return variable;
            }
        }
        return null;
    }

    /**
     * Metodo para verificar existencia de una variable objeto
     *
     * @param var Variable a verificar su existencia
     * @return retorna el tipo de variable que es, si no lo encuentra regresa ""
     */
    public VariablePrograma existeObjeto(String var) {
        for (VariablePrograma variable : variables) {
            if (variable.getId().equals(var)) {
                return variable;
            }
        }
        return null;
    }

    /**
     * Metodo para verificar existencia de arreglo
     *
     * @param var Id del arreglo a buscar
     * @param size Tamaño de dimensiones del arreglo a buscar
     * @return True si existe, False si no existe
     */
    public VariablePrograma existeVar(String var, Integer size) {
        for (VariablePrograma variable : variables) {
            if (variable instanceof ArregloPrograma && variable.getId().equals(var) && ((ArregloPrograma) variable).getTam().size() == size) {
                return variable;
            }
        }
        return null;
    }

    /**
     * Metodo para eliminar ambito
     *
     * @param ambito Ambito a eliminar
     */
    public void eliminarAmbito(Integer ambito) {
        List<VariablePrograma> eliminar = new ArrayList<>();
        variables.stream().filter((variable) -> (Objects.equals(variable.getAmbito(), ambito))).forEachOrdered((variable) -> {
            eliminar.add(variable);
        });
        variables.removeAll(eliminar);
    }

    /**
     * Iniciar el codigo VisualBasic, para obtener su codigo 3 direcciones
     *
     * @param vb Codigo Visual Basic a analizar
     * @param v linea donde empieza el archivo
     */
    public void iniciarVB(String vb, int v) {
        try {
            SintaxisVisual visual = new SintaxisVisual(new LexicoVisual(new StringReader(vb)));
            visual.setLinea(v);
            visual.parse();
            metodosVisual = visual.getVisual().getMetodos();
        } catch (Exception ex) {
            AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "ERROR TERMINAL EN VISUALBASIC \n");
        }
    }

    /**
     * Iniciar el Codigo Python, para obetener su codigo 3 direcciones
     *
     * @param py Codigo Python a analizar
     * @param p linea donde empieza el archivo
     */
    public void iniciarPY(String py, int p) {
        try {
            SintaxisPython python = new SintaxisPython(new LexicoPython(new StringReader(py)));
            python.setLinea(p);
            python.parse();
            metodosPython = python.getPython().getMetodos();
        } catch (Exception ex) {
            AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "ERROR TERMINAL EN PYTHON \n");
        }
    }

    /**
     * Inciar el codigo Python, para conseguir su codigo 3 direcciones
     *
     * @param java Codigo Java a analizar
     * @param j linea donde empieza el archivo
     */
    public void iniciarJAVA(String java, int j) {
        try {
            SintaxisJava jv = new SintaxisJava(new LexicoJava(new StringReader(java)));
            jv.setLinea(j);
            jv.parse();
            this.clasesJava = jv.getJava().getTabla();
        } catch (Exception ex) {
            AssGUI.editorTerminal.setText(AssGUI.editorTerminal.getText() + "ERROR TERMINAL EN JAVA \n");
        }
    }

    /**
     * Metodo para importar Clases de Java
     *
     * @param id Id de la clase java a importar
     * @return True si existe clase a importar
     */
    public boolean importarClase(String id) {
        if (!existeImportado(id)) {
            for (TablaJava tablaJava : clasesJava) {
                if (tablaJava.getId().equals(id)) {
                    clasesImportadas.add(tablaJava);
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }

    /**
     * Metodo que sirve para importar todas las clases de Java
     */
    public void importarTodasClases() {
        clasesJava.stream().filter((tablaJava) -> (!existeImportado(tablaJava.getId()))).forEachOrdered((tablaJava) -> {
            clasesImportadas.add(tablaJava);
        });
    }

    /**
     * Metodo para verificar si ya se importo la clase Java de 3 Direcciones
     *
     * @param id Id para verificar si la clase Java ya se importo
     * @return True si ya se importo la clase, False si aún no se ha importado
     */
    public boolean existeImportado(String id) {
        return clasesImportadas.stream().anyMatch((clasesImportada) -> (clasesImportada.getId().equals(id)));
    }

    /**
     * Metodo Para verificar existencia de metodo Python Importado
     *
     * @param id Id del metodo Python a buscar
     * @param vars Parametros del metodo Python a buscar
     * @return True si el metodo Python existe con las especificaciones, False
     * si no existe
     */
    public MetodoPython existeMetodoPY(String id, List<OperacionPrograma> vars) {
        for (MetodoPython metodoPython : this.metodosPython) {
            if (metodoPython.equals(id, vars)) {
                return metodoPython;
            }
        }
        return null;
    }

    /**
     * Metodo para verificar existencia de metodo Visual Basic Importado
     *
     * @param id Id del metodo Visual Basic a buscar
     * @param vars Lista de Parametros del metodo Visual a buscar
     * @return True si existe metodo Visual con estas especificaciones, False si
     * no existe
     */
    public MetodoVisual existeMetodoVB(String id, List<OperacionPrograma> vars) {
        for (MetodoVisual metodoVisual : this.metodosVisual) {
            if (metodoVisual.equals(id.toLowerCase(), vars)) {
                return metodoVisual;
            }
        }
        return null;
    }

    /**
     * Metodo para verificar existencia de la clase y metodo en Java importado
     *
     * @param clase Id de la clase java que pertenece el parametro
     * @param metodo Id del metodo que se quiere buscar
     * @param vars Parametros del metodo a buscar
     * @return True si existe el metodo en la clase indicada, False si no existe
     * el metodo
     */
    public MetodoJava existeMetodoJV(String clase, String metodo, List<OperacionPrograma> vars) {
        for (TablaJava clasesImportada : clasesImportadas) {
            if (clasesImportada.getId().equals(clase)) {
                return clasesImportada.existeMetodo(metodo, vars);
            }
        }
        return null;
    }

    /**
     * Metodo para verificar existencia de la clase y metodo en Java importado
     *
     * @param clase Id de la clase java que pertenece el parametro
     * @param metodo Id del metodo que se quiere buscar
     * @param vars Parametros del metodo a buscar
     * @return True si existe el metodo en la clase indicada, False si no existe
     * el metodo
     */
    public MetodoJava existeConstructorJV(String clase, String metodo, List<OperacionPrograma> vars) {
        for (TablaJava clasesImportada : clasesImportadas) {
            if (clasesImportada.getId().equals(clase)) {
                return clasesImportada.existeConstructor(metodo, vars);
            }
        }
        return null;
    }

    public TablaJava existeClase(String id) {
        for (TablaJava clasesImportada : this.clasesImportadas) {
            if (clasesImportada.getId().equals(id)) {
                return clasesImportada;
            }
        }
        return null;
    }

    public String mostrarCodigo() {
        String s = "";
        s = this.imports.stream().map(aImport -> aImport + "\n").reduce(s, String::concat);
        s += this.librerias(s);
        s += this.principal();
        s += this.getch();
        if (metodosPython != null) {
            s += this.Python();
        }
        if (metodosVisual != null) {
            s += this.Visual();
        }
        if (this.clasesImportadas != null) {
            s += this.importadas();
        }
        s += "\n//Main de C \n";
        s += this.main();
        return s;
    }

    private String principal() {
        return "int p = 0;\n"
                + "int h = 0;\n"
                + "float stack[10000];\n"
                + "float heap[500];\n";
    }

    private String librerias(String text) {
        String s = "";
        if (!text.contains("#include <unistd.h>\n")) {
            s += "#include <unistd.h>\n";
        }
        if (!text.contains("#include <termios.h>\n")) {
            s += "#include <termios.h>\n";
        }
        if (!text.contains("#include <math.h>\n")) {
            s += "#include <math.h>\n";
        }
        if (!text.contains("#include <stdio.h>\n")) {
            s += "#include <stdio.h>\n";
        }
        if (!text.contains("#include <stdlib.h>\n")) {
            s += "#include <stdlib.h>\n";
        }
        return s + "\n";
    }

    private String getch() {
        return "char getch(){\n"
                + "       /*#include <unistd.h>   //_getch*/\n"
                + "       /*#include <termios.h>  //_getch*/\n"
                + "       char buf=0;\n"
                + "       struct termios old={0};\n"
                + "       fflush(stdout);\n"
                + "       if(tcgetattr(0, &old)<0)\n"
                + "           perror(\"tcsetattr()\");\n"
                + "       old.c_lflag&=~ICANON;\n"
                + "       old.c_lflag&=~ECHO;\n"
                + "       old.c_cc[VMIN]=1;\n"
                + "       old.c_cc[VTIME]=0;\n"
                + "       if(tcsetattr(0, TCSANOW, &old)<0)\n"
                + "           perror(\"tcsetattr ICANON\");\n"
                + "       if(read(0,&buf,1)<0)\n"
                + "           perror(\"read()\");\n"
                + "       old.c_lflag|=ICANON;\n"
                + "       old.c_lflag|=ECHO;\n"
                + "       if(tcsetattr(0, TCSADRAIN, &old)<0)\n"
                + "           perror (\"tcsetattr ~ICANON\");\n"
                + "       printf(\"%c\\n\",buf);\n"
                + "       return buf;\n"
                + "}";
    }

    public String Python() {
        String s = "";
        for (MetodoPython metodoPython : this.metodosPython) {
            s += "\n";
            s += metodoPython.mostrarMetodo();
        }
        return s;
    }

    public String Visual() {
        String s = "";
        for (MetodoVisual metodoVisual : this.metodosVisual) {
            s += "\n";
            s += metodoVisual.mostrarMetodo();
        }
        return s;
    }

    public String importadas() {
        String s = "";
        for (TablaJava clasesImportada : this.clasesImportadas) {
            s += clasesImportada.mostrarClase();
        }
        return s;
    }

    public String main() {
        String s = "int main() {\n";
        s += "\n//Variables y constantes Globales \n";
        for (Triplete triplete : this.var) {
            s += triplete.devolverString() + "\n";
        }
        s += "\n//empieza el main \n";
        for (Triplete triplete : this.tripletes) {
            s += triplete.devolverString() + "\n";
        }
        s += "}\n";
        return s;
    }

    private String var() {
        String s = "";
        for (Triplete triplete : this.var) {
            s += triplete.devolverString() + "\n";
        }
        return s;
    }

    public List<Triplete> getTripletes() {
        return tripletes;
    }

    public List<Triplete> getVar() {
        return var;
    }

    public List<String> getImports() {
        return imports;
    }

    public TablaVariables getVariables() {
        return variables;
    }

    public Integer getHeap() {
        return heap;
    }

    public void setHeap(Integer heap) {
        this.heap = heap;
    }

}
