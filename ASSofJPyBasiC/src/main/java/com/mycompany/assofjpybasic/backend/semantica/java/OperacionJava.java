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
    
    private int tipo;

    /**
     * Constructor con el tipo de operacion
     * @param tipo 1 -> Char
     * ||  2 -> Int
     * ||  3 -> Float
     */
    public OperacionJava(int tipo){
        this.tipo = tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

}
