/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.java;

/**
 *
 * @author mari2bar
 */
public class OperacionJava {

    private Integer tipo;

    /**
     * Constructor con el tipo de operacion
     *
     * @param tipo 1 -> Char || 2 -> Int || 3 -> Float
     */
    public OperacionJava(Integer tipo) {
        this.tipo = tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

}
