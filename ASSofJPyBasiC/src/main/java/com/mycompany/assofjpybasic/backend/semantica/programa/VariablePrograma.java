/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.programa;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class VariablePrograma {

    protected final String id;
    protected final Integer ambito;
    protected final Integer tipo;
    public final static Integer CHAR = 1, INT = 2, FLOAT = 3, CLASS = 4;

    /**
     * Constructor de una variable del programa principal C
     *
     * @param id Es el id que tiene la variable
     * @param ambito Es el ambito al que pertenece la variable
     * @param tipo Tipo de la que es el variable, 1->char 2->int 3->float
     */
    public VariablePrograma(String id, Integer ambito, Integer tipo) {
        this.id = id;
        this.ambito = ambito;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public Integer getAmbito() {
        return ambito;
    }

    public Integer getTipo() {
        return tipo;
    }

}
