/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.python;

import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class VariablePython {

    private final String id;
    private String tipo;
    private final Integer ambito;

    /**
     * Constructor de variable que inicializa todos sus componentes de la
     * variable, exceptuando su tipo, ya sea porque es un array de Variables
     *
     * @param id Id de la variable
     * @param ambito ambito al que pertenece la variable
     */
    public VariablePython(String id, Integer ambito) {
        this.id = id;
        this.ambito = ambito;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getAmbito() {
        return ambito;
    }

    /**
     * sobre escritura de equals, que hace de una manera más concreta la función
     * de verficiar si la variable tiene el mismo id y tipo
     *
     * @param var Variable con la que se va a comparar
     * @return true si son iguales, false si no lo son
     */
    public boolean equals(VariablePython var) {
        return this.id.equals(var.getId()) && this.tipo.equals(var.getTipo());
    }

    /**
     * Metodo para verificar que el parametro es o no del mismo tipo
     *
     * @param var variable para verificar su tipo
     * @return verdadero si son del mismo tipo, falso si no lo son
     */
    public boolean isMismoTipo(VariablePython var) {
        return var.getTipo().equals(this.tipo);
    }

    /**
     * Metodo para agregar Tipos a una lista de variables
     *
     * @param var Lista de variables en el cual se ingresara el tipo
     * @param tipo Tipo que se le asignara a las variables
     */
    public static final void agregarTipo(List<VariablePython> var, String tipo) {
        for (VariablePython variableJava : var) {
            variableJava.setTipo(tipo);
        }
    }

}
