/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.python;

import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AsignarValor;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.SumOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.TerminalOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa el codigo pytho, clases y variables
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
                    py.setDireccion(this.variables.size());
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

    public boolean addVar(VariablePython var) {
        VariablePython res = this.existeVar(var);
        if (res != null && !res.getTipo().equals(PythonSemantica.INT) && !res.getTipo().equals(PythonSemantica.VAR)) {
            return false;
        } else if (res == null) {
            var.setDireccion(this.variables.size());
            this.variables.add(var);
            var.setTipo(PythonSemantica.INT);
            return true;
        } else {
            var.setTipo(PythonSemantica.INT);
            return true;
        }
    }

    /**
     * Metodo para verificar existencia de una variable y agregarla si no existe
     *
     * @param var Variable a verificar su existencia
     * @param tipo lista tipos de Variables
     * @return retorna los tripletes de las asignaciones
     */
    public List<Triplete> devolverAsig(List<VariablePython> var, List<OperacionPython> tipo) {
        if (var.size() == tipo.size()) {
            List<Triplete> list = new ArrayList<>();
            for (int i = 0; i < var.size(); i++) {
                VariablePython py = var.get(i);
                OperacionPython t = tipo.get(i);
                list.addAll(t.mostrarTripletes());
                SumOperator sum = this.devolverSum(py.getId());
                list.add(sum);
                list.add(new AsignarValor(new TerminalOperator(this.devolverDireccion(sum.getId())), t.getTriplete(), null));
            }
            return list;
        } else {
            return new ArrayList<>();
        }
    }

    public String devolverDireccion(String id) {
        return "stack[" + id + "]";
    }

    public SumOperator devolverSum(String id) {
        return new SumOperator(null, new TerminalOperator("p"), new TerminalOperator(this.obtenerDireccion(id).toString()), "int");
    }

    /**
     * Obtiene la direccion en el stack[id]
     *
     * @param id id de la variable a obtener su posicion en la tabla de simbolos
     * @return la posicion en la tabla de simbolos del id
     */
    public Integer obtenerDireccion(String id) {
        for (VariablePython variable : this.variables) {
            if (variable.getId().equals(id)) {
                return variable.getDireccion() + 1;
            }
        }
        return 0;
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

    public List<MetodoPython> getMetodos() {
        return metodos;
    }

}
