/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.python;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class PythonSemantica {

    public static String INT = "INT", FLOAT = "FLOAT", CHAR = "CHAR", VAR = "VAR", VOID = "VOID";
    public static Integer AMBITO = 0;
    private final List<VariablePython> variables = new ArrayList<>();
    private final List<MetodoPython> metodos = new ArrayList<>();

    /**
     * constructor para incializar AMBITO a 0 e Inicializar el primer ambito
     */
    public PythonSemantica() {
        PythonSemantica.AMBITO = 0;
    }

    /**
     * Metodo para verificar existencia de una variable y agregarla si no existe
     *
     * @param var Variable a verificar su existencia
     * @param tipo lista tipos de Variables
     * @return retorna el tipo de variable que es, si no lo encuentra regresa -1
     */
    public boolean addVar(List<VariablePython> var, List<OperacionPython> tipo) {
        if (var.size() == tipo.size()) {
            for (int i = 0; i < var.size(); i++) {
                VariablePython py = var.get(i);
                OperacionPython t = tipo.get(i);
                VariablePython res = this.existeVar(py);
                if (res == null) {
                    py.setTipo(t.getTipo());
                    variables.add(py);
                } else if (res.getTipo().equals(PythonSemantica.VAR)) {
                    res.setTipo(t.getTipo());
                } else if (!res.getTipo().contains(t.getTipo())) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo para agregar las variables de los parametros
     *
     * @param var Variable a verificar su existencia
     */
    public void addVar(List<VariablePython> var) {
        var.stream().map((variablePython) -> {
            variablePython.setTipo(PythonSemantica.VAR);
            return variablePython;
        }).forEachOrdered((variablePython) -> {
            this.variables.add(variablePython);
        });
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
        List<VariablePython> eliminar = new ArrayList<>();
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
    public VariablePython existeVar(VariablePython var) {
        for (VariablePython variable : variables) {
            if (variable.getId().equals(var.getId())) {
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
    public boolean addMetodo(MetodoPython metodo) {
        for (MetodoPython met : metodos) {
            if (!met.isnotEquals(metodo)) {
                Integer pos = metodos.indexOf(met);
                metodos.remove(pos.intValue());
                metodos.add(pos, metodo);
                return true;
            }
        }
        metodos.add(metodo);
        return true;
    }

    public List<VariablePython> getVariables() {
        return variables;
    }

}
