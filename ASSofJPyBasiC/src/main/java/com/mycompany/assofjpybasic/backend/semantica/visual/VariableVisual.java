/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.visual;

import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import java.util.List;

/**
 * Clase que representa una Variable en Visual Basic
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class VariableVisual extends OperacionVisual {

    private final String id;
    private String tipo;
    private Integer direccion;
    private final Integer ambito;
    private boolean definido = false, astipo = false;

    /**
     * Constructor de variable que inicializa todos sus componentes de la
     * variable.
     *
     * @param id Id de la variable
     * @param ambito ambito al que pertenece la variable
     * @param tipo Tipo de la variable
     * @param tri Triplete que corresponde a la variable
     */
    public VariableVisual(String id, Integer ambito, String tipo, Triplete tri) {
        super(tipo, tri);
        this.id = id.toLowerCase();
        this.ambito = ambito;
        this.tipo = tipo;
        this.triplete = tri;
    }

    /**
     * Constructor de variable que inicializa todos sus componentes de la
     * variable, exceptuando su tipo, ya sea porque es un array de Variables
     *
     * @param id Id de la variable
     * @param ambito ambito al que pertenece la variable
     * @param tri Triplete de la variable
     */
    public VariableVisual(String id, Integer ambito, Triplete tri) {
        super(null, tri);
        this.id = id.toLowerCase();
        this.ambito = ambito;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAmbito() {
        return ambito;
    }

    /**
     * sobre escritura de equals, que hace de una manera más concreta la función
     * de verficiar si la variable tiene el mismo id y tipo
     *
     * @param var Variable con la que se va a comparar
     * @return true si son iguales, false si no lo son
     */
    public boolean equals(VariableVisual var) {
        return this.id.equals(var.getId()) && this.tipo.equals(var.getTipo());
    }

    /**
     * Metodo para verificar que el parametro es o no del mismo tipo
     *
     * @param var variable para verificar su tipo
     * @return verdadero si son del mismo tipo, falso si no lo son
     */
    public boolean isMismoTipo(VariableVisual var) {
        return var.getTipo().equals(this.tipo);
    }

    /**
     * Metodo para agregar Tipos a una lista de variables
     *
     * @param var Lista de variables en el cual se ingresara el tipo
     * @param tipo Tipo que se le asignara a las variables
     */
    public static final void agregarTipo(List<VariableVisual> var, String tipo) {
        var.forEach((variableJava) -> {
            variableJava.setTipo(tipo);
        });
    }

    public static String verificarTipo(String tipo, OperacionVisual op) {
        if (tipo == null && op != null) {
            return op.getTipo();
        } else if (tipo != null && op == null) {
            return tipo;
        } else if (tipo == null && op == null) {
            return null;
        } else if (tipo.contains(op.getTipo())) {
            return tipo;
        } else {
            return null;
        }
    }

    public boolean isDefinido() {
        return definido;
    }

    public void setDefinido(boolean definido) {
        this.definido = definido;
    }

    public boolean isAstipo() {
        return astipo;
    }

    public void setAstipo(boolean astipo) {
        this.astipo = astipo;
    }

    public Integer getDireccion() {
        return direccion;
    }

    public void setDireccion(Integer direccion) {
        this.direccion = direccion;
    }

}
