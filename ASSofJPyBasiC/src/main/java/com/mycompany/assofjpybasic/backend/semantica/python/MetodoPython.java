/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.python;

import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MetodoPython {

    private final String id;
    private String TIPO;
    private final List<VariablePython> parametros;

    /**
     *
     *
     * @param id Id del metodo
     * @param parametros lista de parametros del metodo
     */
    public MetodoPython(String id, List<VariablePython> parametros) {
        this.id = id;
        this.parametros = parametros;
    }

    /**
     * Metodo para verificar si ya existe este Metodo
     *
     * @param var el metodo con el que se comparara este metodo
     * @return true si es igual, false si no lo es
     */
    public boolean isnotEquals(MetodoPython var) {
        return !this.id.equals(var.getId()) || !MetodoPython.sonMismosParametros(parametros, var.getParametros());
    }

    /**
     * Metodo para ver si el array1 es igual al array2
     *
     * @param parametros1 Parametros del primer metodo
     * @param parametros2 Parametros del segundo metodo
     * @return true Si son los mismos, false si no lo son
     */
    public static final boolean sonMismosParametros(List<VariablePython> parametros1, List<VariablePython> parametros2) {
        return parametros1.size() == parametros2.size();
    }

    public List<VariablePython> getParametros() {
        return parametros;
    }

    public String getTIPO() {
        return TIPO;
    }

    /**
     * @param TIPO Tipo del metodo 1 - CHAR 2 - INT 3 - FLOAT 4 - VOID
     */
    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public String getId() {
        return id;
    }

}
