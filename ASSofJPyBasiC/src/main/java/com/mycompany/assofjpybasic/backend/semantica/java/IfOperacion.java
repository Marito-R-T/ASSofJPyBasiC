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
public class IfOperacion extends StatementJava{
 
    private final boolean ret;
    private final StatementsJava states;

    /**
     * Constructor que inicia las variables de if operacion,
     * De statements que contiene, y si tiene un return
     * @param states Lista de Statements de la operacion If
     */
    public IfOperacion(StatementsJava states) {
        this.states = states;
        ret = states.isRet();
    }

    public boolean isRet() {
        return ret;
    }
    
    /**
     * 
     * @param op Operacion del primer If
     * @param op2 Lista de Operciones que pertenecen a los If-Else
     * @param op3 Operacion ELSE
     * @return retorna true si todos son retornables, false si alguno no lo es
     */
    public static boolean esRetornable(IfOperacion op, List<IfOperacion> op2, IfOperacion op3){
        if(!op.isRet() || !op3.isRet()) return false;
        return op2.stream().allMatch((ifOperacion) -> (ifOperacion.isRet()));
    }
    
}
