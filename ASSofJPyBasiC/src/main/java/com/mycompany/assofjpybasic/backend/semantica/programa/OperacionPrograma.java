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
public class OperacionPrograma {

    private Integer tipo;

    /**
     * Constructor con el tipo de operacion
     *
     * @param tipo 1 -> Char || 2 -> Int || 3-FLOAT -> Float
     */
    public OperacionPrograma(Integer tipo) {
        this.tipo = tipo;
    }

    /**
     * Constructor con el tipo de operacion
     *
     * @param tipo1 1 -> Char || 2 -> Int || 3-FLOAT -> Float
     * @param tipo2 1 -> Char || 2 -> Int || 3-FLOAT -> Float
     */
    public OperacionPrograma(Integer tipo1, Integer tipo2) {
        if (tipo1 > tipo2) {
            this.tipo = tipo1;
        } else if (tipo1 < tipo2) {
            this.tipo = tipo2;
        } else {
            this.tipo = tipo1;
        }
    }

    /**
     * Constructor que se inicia, a partir de 2 operaciones
     *
     * @param op1 Operador 1 con el que se compara
     * @param op2 Operador 2 con el que se compara
     */
    public OperacionPrograma(OperacionPrograma op1, OperacionPrograma op2) {
        if (op1.getTipo() > op2.getTipo()) {
            this.tipo = op1.getTipo();
        } else if (op2.getTipo() < op2.getTipo()) {
            this.tipo = op2.getTipo();
        } else {
            this.tipo = op1.getTipo();
        }
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

}
