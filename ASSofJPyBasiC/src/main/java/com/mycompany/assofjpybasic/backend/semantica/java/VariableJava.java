/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.java;

import java.util.List;

/**
 *
 * @author mari2bar
 */
public class VariableJava {
    
    private final String id;
    private int tipo;
    private final int ambito;
    
    /**
     * Constructor de variable que inicializa todos sus componentes
     * de la variable
     * @param id 
     * @param tipo     
     * @param ambito     
     */
    public VariableJava(String id, int tipo, int ambito) {
        this.id = id;
        this.tipo = tipo;
        this.ambito = ambito;
    }
    
    /**
     * Constructor de variable que inicializa todos sus componentes
     * de la variable, exceptuando su tipo, ya sea porque es un array de Variables
     * @param id    Id de la variable
     * @param ambito     ambito al que pertenece la variable
     */
    public VariableJava(String id, int ambito) {
        this.id = id;
        this.ambito = ambito;
    }

    public String getId() {
        return id;
    }

    public int getTipo() {
        return tipo;
    }

    public int getAmbito() {
        return ambito;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    /**
     * sobre escritura de equals, que hace de una manera más concreta
     * la función de verficiar si la variable tiene el mismo id y tipo
     * @param var Variable con la que se va a comparar
     * @return true si son iguales, false si no lo son
     */
    public boolean equals(VariableJava var) {
        return this.id.equals(var.getId()) && this.tipo == var.getTipo();
    }
    
    /**
     * Metodo para verificar que el parametro es o no del mismo tipo
     * @param var variable para verificar su tipo
     * @return verdadero si son del mismo tipo, falso si no lo son
    */
    public boolean isMismoTipo(VariableJava var) {
        return var.getTipo() == this.tipo;
    }
    
    /**
     * Metodo para agregar Tipos a una lista de variables
     * @param var Lista de variables en el cual se ingresara el tipo
     * @param tipo Tipo que se le asignara a las variables
     */
    public static final void agregarTipo(List<VariableJava> var, int tipo) {
        for (VariableJava variableJava : var) {
            variableJava.setTipo(tipo);
        }
    }

}
