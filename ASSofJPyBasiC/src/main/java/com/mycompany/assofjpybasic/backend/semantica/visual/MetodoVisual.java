/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.visual;

import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class MetodoVisual {

    private final String id;
    private final String TIPO;
    private final List<VariableVisual> parametros;
    private VariableVisual visual;

    /**
     *
     *
     * @param id Id del metodo
     * @param parametros lista de parametros del metodo
     * @param tipo Tipo del retorno del metodo
     */
    public MetodoVisual(String id, List<VariableVisual> parametros, String tipo) {
        this.id = id.toLowerCase();
        this.parametros = parametros;
        this.TIPO = tipo;
    }

    /**
     * Metodo para verificar si ya existe este Metodo
     *
     * @param var el metodo con el que se comparara este metodo
     * @return true si es igual, false si no lo es
     */
    public boolean isnotEquals(MetodoVisual var) {
        return !this.id.equals(var.getId()) || !this.TIPO.equals(var.getTIPO()) || !MetodoVisual.sonMismosParametros(this.parametros, var.getParametros());
    }

    /**
     * Metodo para ver si el array1 es igual al array2
     *
     * @param parametros1 Parametros del primer metodo
     * @param parametros2 Parametros del segundo metodo
     * @return true Si son los mismos, false si no lo son
     */
    public static final boolean sonMismosParametros(List<VariableVisual> parametros1, List<VariableVisual> parametros2) {
        if (parametros1.size() == parametros2.size()) {
            for (int i = 0; i < parametros1.size(); i++) {
                if (!parametros1.get(i).isMismoTipo(parametros2.get(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public List<VariableVisual> getParametros() {
        return parametros;
    }

    public String getTIPO() {
        return TIPO;
    }

    public String getId() {
        return id;
    }

    public VariableVisual getVisual() {
        return visual;
    }

    public void setVisual(VariableVisual visual) {
        this.visual = visual;
    }

}
