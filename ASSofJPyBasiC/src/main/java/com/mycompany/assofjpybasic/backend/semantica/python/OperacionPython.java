/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.python;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class OperacionPython {

    private String tipo;

    /**
     * Constructor con el tipo de operacion
     *
     * @param tipo CHAR -> Char || INT -> Int || INT-FLOAT -> Float
     */
    public OperacionPython(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Constructor que se inicia, a partir de 2 operaciones
     *
     * @param op1 Operador 1 con el que se compara
     * @param op2 Operador 2 con el que se compara
     */
    public OperacionPython(OperacionPython op1, OperacionPython op2) {
        if (op2.getTipo().contains("FLOAT") || op1.getTipo().contains("FLOAT")) {
            this.tipo = PythonSemantica.FLOAT;
        } else {
            this.tipo = PythonSemantica.INT;
        }
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
