/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.java;

import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AsignarValor;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mari2bar
 */
public class VariableJava extends OperacionJava {

    private final String id;
    private Integer tipo;
    private final Integer ambito;

    /**
     * Constructor de variable que inicializa todos sus componentes de la
     * variable
     *
     * @param id Id de la variable
     * @param tipo Tipo de la Variable
     * @param ambito Ambito de la operacion
     * @param tri Triplete de la Operacion
     */
    public VariableJava(String id, Integer tipo, Integer ambito, Triplete tri) {
        super(tipo, tri);
        this.id = id;
        this.tipo = tipo;
        this.ambito = ambito;
    }

    /**
     * Constructor de variable que inicializa todos sus componentes de la
     * variable, exceptuando su tipo, ya sea porque es un array de Variables
     *
     * @param id Id de la variable
     * @param ambito ambito al que pertenece la variable
     * @param tri Triplete de la Operacion
     */
    public VariableJava(String id, Integer ambito, Triplete tri) {
        super(null, tri);
        this.id = id;
        this.ambito = ambito;
    }

    public String getId() {
        return id;
    }

    public Integer getTipo() {
        return tipo;
    }

    public Integer getAmbito() {
        return ambito;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    /**
     * sobre escritura de equals, que hace de una manera más concreta la función
     * de verficiar si la variable tiene el mismo id y tipo
     *
     * @param var Variable con la que se va a comparar
     * @return true si son iguales, false si no lo son
     */
    public boolean equals(VariableJava var) {
        return this.id.equals(var.getId()) && Objects.equals(this.tipo, var.getTipo());
    }

    /**
     * Metodo para verificar que el parametro es o no del mismo tipo
     *
     * @param var variable para verificar su tipo
     * @return verdadero si son del mismo tipo, falso si no lo son
     */
    public boolean isMismoTipo(VariableJava var) {
        return Objects.equals(var.getTipo(), this.tipo);
    }

    /**
     * Metodo para agregar Tipos a una lista de variables
     *
     * @param var Lista de variables en el cual se ingresara el tipo
     * @param tipo Tipo que se le asignara a las variables
     */
    public static final void agregarTipo(List<VariableJava> var, int tipo) {
        for (VariableJava variableJava : var) {
            variableJava.setTipo(tipo);
        }
    }

    public static List<Triplete> obtenerTripletes(List<VariableJava> var, Integer tipo) {
        List<Triplete> tri = new ArrayList<>();
        for (VariableJava variableJava : var) {
            ((AsignarValor) variableJava.getTriplete()).setTipo(OperacionJava.obtenerTipo(tipo));
            tri.addAll(variableJava.mostrarTripletes());
        }
        return tri;
    }

}
