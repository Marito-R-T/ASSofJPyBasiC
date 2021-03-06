/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.java;

import com.mycompany.assofjpybasic.backend.semantica.programa.OperacionPrograma;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AritmeticaOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AsignarTemporal;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AsignarValor;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Clrs;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Heap;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.P;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Printf;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Scanf;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Stack;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.SumOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.TerminalOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import com.mycompany.assofjpybasic.backend.semantica.python.Input;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa una clase en java
 *
 * @author mari2bar
 */
public class TablaJava {

    public static final Integer VOID = 4, CHAR = 1, INT = 2, FLOAT = 3;
    public static Integer AMBITO = 0;
    private final String id;
    private final List<VariableJava> variables = new ArrayList<>();
    private final List<VariableJava> var_definidas = new ArrayList<>();
    private final List<MetodoJava> metodos = new ArrayList<>();
    private final List<MetodoJava> constructores = new ArrayList<>();
    private final List<Triplete> principales = new ArrayList<>();
    private Integer num;

    /**
     * constructor para incializar AMBITO a 0 e Inicializar el primer ambito
     *
     * @param id Identificador de la clase java
     */
    public TablaJava(String id) {
        this.id = id;
        TablaJava.AMBITO = 0;
    }

    /**
     * Metodo para agregar una variable
     *
     * @param var es la variable a ingresar
     * @return regresa un booleano para verificar si se puede ingresar variable
     */
    public boolean addVar(VariableJava var) {
        if (!variables.stream().noneMatch((variable) -> (variable.getId().equals(var.getId())))) {
            return false;
        }
        var.setDireccion(variables.size());
        if (TablaJava.AMBITO == 1) {
            var_definidas.add(var);
        }
        variables.add(var);
        return true;
    }

    /**
     * Metodo para agregar una lista completa de variables
     *
     * @param var Es la lista de variables a agregar
     * @return true - si todas las variables son ingresadas false - si alguna
     * variable no se puede ingresar
     */
    public boolean addListVar(List<VariableJava> var) {
        if (!var.stream().noneMatch((variableJava) -> (!this.addVar(variableJava)))) {
            return false;
        }
        return true;
    }

    /**
     * Regresa el tipo que se obtiene al realizar una operacion entre diferentes
     * tipos
     *
     * @param tipo1 tipo de operador del primer valor
     * @param tipo2 tipo de operador del segundo valor
     * @return regresa el tipo padre: 3>2>1
     */
    public static Integer regresarTipo(Integer tipo1, Integer tipo2) {
        if (tipo1 > tipo2) {
            return tipo1;
        } else if (tipo2 > tipo1) {
            return tipo2;
        } else {
            return tipo1;
        }
    }

    /**
     * Metodo para eliminar ambito
     *
     * @param ambito Ambito a eliminar
     */
    public void eliminarAmbito(Integer ambito) {
        List<VariableJava> eliminar = new ArrayList<>();
        variables.stream().filter((variable) -> (Objects.equals(variable.getAmbito(), ambito))).forEachOrdered((variable) -> {
            eliminar.add(variable);
        });
        variables.removeAll(eliminar);
    }

    /**
     * Metodo para verificar existencia de una variable
     *
     * @param var Variable a verificar su existencia
     * @return retorna el tipo de variable que es, si no lo encuentra regresa -1
     */
    public VariableJava existeVar(VariableJava var) {
        for (int i = this.variables.size() - 1; i >= 0; i--) {
            if (variables.get(i).getId().equals(var.getId())) {
                return variables.get(i);
            }
        }
        return null;
    }

    /**
     * Metodo para verificar existencia de una variable global
     *
     * @param var Variable a verificar su existencia en la clase
     * @return Retorna el tipo de variable que es la variable
     */
    public VariableJava existeVarGlobal(VariableJava var) {
        for (VariableJava variable : variables) {
            if (variable.getId().equals(var.getId()) && variable.getAmbito() == 1) {
                return variable;
            }
        }
        return null;
    }

    /**
     * Metodo para verificar los metodos de llava al momento de ingresarlo
     *
     * @param metodo Metodo Java a ingresar
     * @return true si se pudo ingresar, false si ya estaba repetido
     */
    public boolean addMetodo(MetodoJava metodo) {
        if (!metodos.stream().noneMatch((met) -> (!met.isnotEquals(metodo)))) {
            return false;
        }
        metodos.add(metodo);
        return true;
    }

    /**
     * Metodo para verificar los metodos de llava al momento de ingresarlo
     *
     * @param metodo Metodo Java a ingresar
     * @return true si se pudo ingresar, false si ya estaba repetido
     */
    public boolean addConstructor(MetodoJava metodo) {
        for (MetodoJava constructor : this.constructores) {
            if (constructor.equalsConstructor(metodo)) {
                return false;
            }
        }
        constructores.add(metodo);
        return true;
    }

    public List<VariableJava> getVariables() {
        return variables;
    }

    public String getId() {
        return id;
    }

    /**
     * Metodo para mostrar si existe o no un metodo que tenga los mismos
     * parametros y mismo id
     *
     * @param id Id del metodo a buscar
     * @param params Parametros del metodo a verificar similitud
     * @return True si existe el metodo, False si no existe el metodo
     */
    public MetodoJava existeMetodo(String id, List<OperacionPrograma> params) {
        for (MetodoJava metodo : this.metodos) {
            if (metodo.equals(id, params)) {
                return metodo;
            }
        }
        return null;
    }

    /**
     * Metodo para mostrar si existe o no un metodo que tenga los mismos
     * parametros y mismo id
     *
     * @param id Id del metodo a buscar
     * @param params Parametros del metodo a verificar similitud
     * @return True si existe el metodo, False si no existe el metodo
     */
    public MetodoJava existeConstructor(String id, List<OperacionPrograma> params) {
        for (MetodoJava metodo : this.constructores) {
            if (metodo.equals(id, params)) {
                return metodo;
            }
        }
        return null;
    }

    public List<VariableJava> getVar_definidas() {
        return var_definidas;
    }

    public List<MetodoJava> getMetodos() {
        return metodos;
    }

    public List<MetodoJava> getConstructores() {
        return constructores;
    }

    public List<Triplete> getPrincipales() {
        return principales;
    }

    public String mostrarClase() {
        String s = "// Clase de JAVA con nombre " + this.id + "\n";
        for (MetodoJava constructor : this.constructores) {
            s += constructor.mostrarMetodo(this.id, this.principales);
        }
        for (MetodoJava metodo : this.metodos) {
            s += metodo.mostrarMetodo(this.id);
        }
        return s;
    }

    public String mostrarClaseE() {
        String s = "// Clase de JAVA con nombre " + this.id + "\n";
        for (MetodoJava constructor : this.constructores) {
            s += constructor.mostrarMetodoE(this.id, this.principales);
        }
        for (MetodoJava metodo : this.metodos) {
            s += metodo.mostrarMetodoE(this.id);
        }
        return s;
    }

    public void verificarConstructores() {
        if (constructores.isEmpty()) {
            constructores.add(new MetodoJava(this.id, 5, new ArrayList<>(), this.id));
        }
    }

    /**
     * Metodo para obtener Tripletes de asignacion de variables
     *
     * @param var Lista de variables de java
     * @param tipo tipo de la variable a asignar
     * @return Lista de tripletes final
     */
    public List<Triplete> obtenerTripletes(List<VariableJava> var, Integer tipo) {
        List<Triplete> tri = new ArrayList<>();
        for (VariableJava variableJava : var) {
            ((AsignarValor) variableJava.getTriplete()).setTipo(OperacionJava.obtenerTipo(tipo));
            System.out.println(variableJava.getId());
            tri.addAll(variableJava.getTripletes());
            if (variableJava.getTriplete().getOperando2() != null) {
                if (this.var_definidas.contains(variableJava)) {
                    Triplete ast = new AsignarTemporal(null, new Stack(new P()), "float");
                    tri.add(ast);
                    SumOperator sum = this.devolverSum(variableJava.getId(), true, ast);
                    tri.add(sum);
                    tri.add(new AsignarValor(this.devolverDireccionH(sum), variableJava.getTriplete().getOperando2(), null));
                } else {
                    SumOperator sum = this.devolverSum(variableJava.getId());
                    tri.add(sum);
                    tri.add(new AsignarValor(this.devolverDireccion(sum), variableJava.getTriplete().getOperando2(), null));
                }
            }
        }
        return tri;
    }

    public Stack devolverDireccion(Triplete tri) {
        return new Stack(tri);
    }

    public Heap devolverDireccionH(Triplete id) {
        return new Heap(id);
    }

    public SumOperator devolverSum(String id) {
        return new SumOperator(null, new P(), new TerminalOperator(this.obtenerDireccion(id).toString()), "int");
    }

    public SumOperator devolverSum(String id, boolean global, Triplete ast) {
        if (global) {
            return new SumOperator(null, ast, new TerminalOperator(this.obtenerDireccionG(id).toString()), "int");
        } else {
            return new SumOperator(null, new P(), new TerminalOperator(this.obtenerDireccion(id).toString()), "int");
        }
    }

    /**
     * Obtener la direccion en la tabla de simbolos
     *
     * @param id Id de la variable
     * @return posicion de la variable
     */
    public Integer obtenerDireccion(String id) {
        for (int i = this.variables.size() - 1; i >= 0; i--) {
            if (variables.get(i).getId().equals(id)) {
                System.out.println(variables.get(i).getDireccion());
                return variables.get(i).getDireccion() + 2 - this.var_definidas.size();
            }
        }
        return 0;
    }

    /**
     * Metodo para obtener la direccion de una variable global en la tabla de
     * simbolos
     *
     * @param id Id de la variable global
     * @return La posicion en memoria de la variable
     */
    public Integer obtenerDireccionG(String id) {
        int i = 0;
        for (VariableJava variable : this.var_definidas) {
            if (variable.getId().equals(id) && variable.getAmbito() == 1) {
                return i;
            }
            i++;
        }
        return 0;
    }

    public MetodoJava existeMetodo(List<OperacionJava> params, String id) {
        for (MetodoJava metodo : this.metodos) {
            if (metodo.equals(params, id)) {
                return metodo;
            }
        }
        return null;
    }

    public String mostrarClaseAss(int lf) {
        String s = "";
        int num = lf;
        for (MetodoJava constructor : this.constructores) {
            List<Triplete> trip = new ArrayList<>();
            trip.addAll(this.principales);
            trip.addAll(constructor.getTripletes());
            int pos = -4;
            boolean flo = false;
            boolean ent = false;
            String tr = "";
            for (int i = trip.size() - 1; i >= 0; i--) {
                Triplete triplete = trip.get(i);
                if (triplete instanceof AritmeticaOperator || triplete instanceof AsignarTemporal) {
                    triplete.setPos(pos + "");
                    pos -= 4;
                } else if (trip instanceof Printf) {
                    String lc = ".LC" + Triplete.FLOAT;
                    Triplete.FLOAT++;
                    ((Printf) trip).setEt(lc);
                    if (((Printf) trip).getValor() == null) {
                        tr += lc + ":\n"
                                + "\t.string \"" + ((Printf) trip).getTipo() + "\"\n";
                    } else {
                        tr += lc + ":\n"
                                + "\t.string \"" + ((Printf) trip).getValor() + "\"\n";
                    }
                    /*if (((Printf) trip).getTipo() != null) {
                        if (((Printf) trip).getTipo().equals("%f")) {
                            flo = true;
                        } else if ((((Printf) trip).getTipo().equals("%d") || ((Printf) trip).getTipo().equals("%c"))) {
                            ent = true;
                        }
                    }*/
                } else if (trip instanceof Clrs) {
                    String lc = ".LC" + Triplete.FLOAT;
                    Triplete.FLOAT++;
                    ((Clrs) trip).setEt(lc);
                    tr += lc + ":\n"
                            + "\t.string \"clear\"\n";
                } else if (trip instanceof Scanf) {
                    flo = true;
                } else if (trip instanceof AsignarValor
                        && ((AsignarValor) trip).getOperando2() instanceof Input
                        && ((AsignarValor) trip).getOperando1() instanceof Heap) {
                    ent = true;
                }
            }
            if (flo) {
                pos -= 8;
            } else if (ent) {
                pos -= 4;
            } else {
                pos -= 0;
            }
            s += constructor.mostrarMetodoAss(num, this.principales, tr, pos);
            num++;
        }
        for (MetodoJava metodo : this.metodos) {
            int pos = -4;
            boolean flo = false;
            boolean ent = false;
            String tr = "";
            for (int i = metodo.getTripletes().size() - 1; i >= 0; i--) {
                Triplete triplete = metodo.getTripletes().get(i);
                if (triplete instanceof AritmeticaOperator || triplete instanceof AsignarTemporal) {
                    triplete.setPos(pos + "");
                    pos -= 4;
                } else if (triplete instanceof Printf) {
                    String lc = ".LC" + Triplete.FLOAT;
                    Triplete.FLOAT++;
                    ((Printf) triplete).setEt(lc);
                    if (((Printf) triplete).getValor() == null) {
                        tr += lc + ":\n"
                                + "\t.string \"" + ((Printf) triplete).getTipo() + "\"\n";
                    } else {
                        tr += lc + ":\n"
                                + "\t.string \"" + ((Printf) triplete).getValor() + "\"\n";
                    }
                    /*if (((Printf) triplete).getTipo() != null) {
                        if (((Printf) triplete).getTipo().equals("%f")) {
                            flo = true;
                        } else if ((((Printf) triplete).getTipo().equals("%d") || ((Printf) triplete).getTipo().equals("%c"))) {
                            ent = true;
                        }
                    }*/
                } else if (triplete instanceof Clrs) {
                    String lc = ".LC" + Triplete.FLOAT;
                    Triplete.FLOAT++;
                    ((Clrs) triplete).setEt(lc);
                    tr += lc + ":\n"
                            + "\t.string \"clear\"\n";
                } else if (triplete instanceof Scanf) {
                    flo = true;
                } else if (triplete instanceof AsignarValor
                        && ((AsignarValor) triplete).getOperando2() instanceof Input
                        && ((AsignarValor) triplete).getOperando1() instanceof Heap) {
                    ent = true;
                }
            }
            if (flo) {
                pos -= 8;
            } else if (ent) {
                pos -= 4;
            } else {
                pos -= 0;
            }
            s += metodo.mostrarMetodoAss(num, tr, pos);
            num++;
        }
        this.num = num;
        return s;
    }

    public Integer getNum() {
        return num;
    }

}
