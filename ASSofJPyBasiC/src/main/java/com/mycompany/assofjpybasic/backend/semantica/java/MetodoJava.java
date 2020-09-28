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
public class MetodoJava {
    
    private final String id;
    private final int TIPO;
    private final List<VariableJava> parametros; 
    
    /**
     * 
     * 
     * @param id Id del metodo
     * @param TIPO Tipo del metodo
     * 1 - CHAR
     * 2 - INT
     * 3 - FLOAT
     * 4 - VOID
     * @param parametros lista de parametros del metodo
     */
    public MetodoJava(String id, int TIPO, List<VariableJava> parametros) {
        this.id = id;
        this.TIPO = TIPO;
        this.parametros = parametros;
    }
    
    /**
     * Metodo para verificar si ya existe este Metodo
     * @param var el metodo con el que se comparara este metodo
     * @return true si es igual, false si no lo es
     */
    public boolean isnotEquals(MetodoJava var) {
        return this.TIPO!=var.TIPO || !MetodoJava.sonMismosParametros(this.parametros, var.getParametros());
    }
    
    /**
     * Metodo para ver si el array1 es igual al array2
     * @param parametros1 Parametros del primer metodo
     * @param parametros2 Parametros del segundo metodo
     * @return true Si son los mismos, false si no lo son
     */
    public static final boolean sonMismosParametros(List<VariableJava> parametros1, List<VariableJava> parametros2){
        if(parametros1.size() == parametros2.size()){
            for (int i = 0; i < parametros1.size(); i++) {
                if(!parametros1.get(i).isMismoTipo(parametros2.get(i))) return false; 
            }
            return true;
        } else {
            return false;
        }
    }

    public List<VariableJava> getParametros() {
        return parametros;
    }
    
}
