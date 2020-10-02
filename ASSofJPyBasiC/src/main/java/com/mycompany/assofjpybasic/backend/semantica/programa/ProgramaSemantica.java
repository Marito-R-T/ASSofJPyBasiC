/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.programa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class ProgramaSemantica {

    public static Integer AMBITO = 0;
    private final List<VariablePrograma> variables = new ArrayList<>();

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
     * @return retorna el tipo de variable que es, si no lo ingresa regresa
     * false, si lo ingresa regresa true
     */
    public boolean addListVar(List<VariablePrograma> var) {
        for (VariablePrograma variableVisual : var) {
            if (this.existeVar(variableVisual) == null) {
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
            variables.add(var);
            return true;
        } else {
            return true;
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

}
