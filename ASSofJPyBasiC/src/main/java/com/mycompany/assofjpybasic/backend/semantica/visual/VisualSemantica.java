/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.visual;

import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AsignarValor;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.SumOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.TerminalOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el codigo contenido en la seccion de Visual Basic
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class VisualSemantica {

    public static String CHAR = "CHAR", INT = "INT", FLOAT = "INT-FLOAT", VOID = "VOID";
    public static Integer AMBITO = 0;
    private final List<VariableVisual> variables = new ArrayList<>();
    private final List<MetodoVisual> metodos = new ArrayList<>();

    /**
     * constructor para incializar AMBITO a 0 e Inicializar el primer ambito
     */
    public VisualSemantica() {
        VisualSemantica.AMBITO = 0;
    }

    /**
     * Metodo para agregar un listado de variables
     *
     * @param var Variables a verificar su existencia
     * @return retorna el tipo de variable que es, si no lo ingresa regresa
     * false, si lo ingresa regresa true
     */
    public boolean addListVar(List<VariableVisual> var) {
        for (VariableVisual variableVisual : var) {
            if (this.existeVar(variableVisual) == null) {
                variableVisual.setDireccion(this.variables.size());
                variables.add(variableVisual);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo para agregar un listado de variables
     *
     * @param var Variable a verificar su existencia
     * @return retorna el tipo de variable que es, si no lo encuentra regresa -1
     */
    public boolean addVar(VariableVisual var) {
        if (this.existeVar(var) == null) {
            var.setDireccion(this.variables.size());
            variables.add(var);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Cambia los tipos del arreglo que no tienen tipos asignados aún
     *
     * @param var Lista de variables que se buscaran
     * @param tipo Tipo de variable que van a ser
     */
    public static void cambiarT(List<VariableVisual> var, String tipo) {
        var.stream().filter((variableVisual) -> (variableVisual.getTipo() == null)).forEachOrdered((variableVisual) -> {
            variableVisual.setTipo(tipo);
            ((AsignarValor) variableVisual.getTriplete()).setTipo(OperacionVisual.obtenerTipo(tipo));
        });
    }

    /**
     * Metodo para verificar que todas las variables de la lista tengan tipos
     *
     * @param var variables que se evaluaran
     * @return True si todos tienen un tipo definido, false si no tienen un tipo
     * definido
     */
    public static boolean tienenTipos(List<VariableVisual> var) {
        Integer f = 0, d = 0;
        for (VariableVisual variableVisual : var) {
            if (variableVisual.isDefinido()) {
                f++;
            }
            if (variableVisual.isAstipo()) {
                d++;
            }
            if (variableVisual.getTipo() == null) {
                return false;
            }
        }
        return var.size() == (f + d) || f == 0;
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
        List<VariableVisual> eliminar = new ArrayList<>();
        variables.stream().filter((variable) -> (variable.getAmbito() == ambito)).forEachOrdered((variable) -> {
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
    public VariableVisual existeVar(VariableVisual var) {
        for (VariableVisual variable : variables) {
            if (variable.getId().equals(var.getId())) {
                return variable;
            }
        }
        return null;
    }

    /**
     * Metodo para verificar existencia de una variable
     *
     * @param var id de la variable con la que se comparara
     * @return retorna el tipo de variable que es, si no lo encuentra regresa -1
     */
    public VariableVisual existeVar(String var) {
        for (VariableVisual variable : variables) {
            if (variable.getId().equals(var)) {
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
    public boolean addMetodo(MetodoVisual metodo) {
        for (MetodoVisual met : metodos) {
            if (!met.isnotEquals(metodo)) {
                Integer pos = metodos.indexOf(met);
                metodos.remove(pos.intValue());
                metodos.add(pos, metodo);
                return false;
            }
        }
        metodos.add(metodo);
        return true;
    }

    public List<VariableVisual> getVariables() {
        return variables;
    }

    public List<MetodoVisual> getMetodos() {
        return metodos;
    }

    /**
     * Metodo que devuelve una lista de tripletes de las variables de visual
     *
     * @param va Lista de variables para obtener sus tripletes
     * @return Lista de tripletes de la asignacion o definicion de valor a una
     * variable
     */
    public List<Triplete> devolverTrip(List<VariableVisual> va) {
        List<Triplete> tri = new ArrayList<>();
        va.forEach((variableVisual) -> {
            if (variableVisual.getTripletes().size() > 0) {
                SumOperator sum = new SumOperator(null, new TerminalOperator("p"), new TerminalOperator(variableVisual.getDireccion().toString()), null);
                variableVisual.getTripletes().add(sum);
                tri.addAll(variableVisual.getTripletes());
                tri.add(new AsignarValor(new TerminalOperator(this.devolverDireccion(sum.getId())), variableVisual.getTriplete().getOperando2(), null));
            } else {
                tri.addAll(variableVisual.getTripletes());
            }
        });
        return tri;
    }

    /**
     * Metodo para mostrar los metodos como codigo 3 direcciones
     */
    public void mostrarMetodos() {
        this.metodos.forEach((metodo) -> {
            System.out.println(metodo.getId() + " METODO \n");
            metodo.getTripletes().forEach((triplete) -> {
                System.out.println(triplete.devolverString());
            });
        });
    }

    public String devolverDireccion(String id) {
        return "stack[" + id + "]";
    }

    public SumOperator devolverSum(String id) {
        return new SumOperator(null, new TerminalOperator("p"), new TerminalOperator(this.obtenerDireccion(id).toString()), "int");
    }

    public Integer obtenerDireccion(String id) {
        for (VariableVisual variable : this.variables) {
            if (variable.getId().equals(id.toLowerCase())) {
                return variable.getDireccion();
            }
        }
        return 0;
    }

}
