/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
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
        variables.add(0, var);
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
            var_definidas.add(variable);
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
    public int existeVar(VariableJava var) {
        for (VariableJava variable : variables) {
            if (variable.getId().equals(var.getId())) {
                return variable.getTipo();
            }
        }
        return -1;
    }

    /**
     * Metodo para verificar existencia de una variable global
     *
     * @param var Variable a verificar su existencia en la clase
     * @return Retorna el tipo de variable que es la variable
     */
    public int existeVarGlobal(VariableJava var) {
        for (VariableJava variable : variables) {
            if (variable.getId().equals(var.getId()) && variable.getAmbito() == 1) {
                return variable.getTipo();
            }
        }
        return -1;
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

    public List<VariableJava> getVariables() {
        return variables;
    }

    public String getId() {
        return id;
    }

}
