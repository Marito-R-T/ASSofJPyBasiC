/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.visual;

import com.mycompany.assofjpybasic.backend.semantica.programa.OperacionPrograma;
import com.mycompany.assofjpybasic.backend.semantica.programa.VariablePrograma;
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

    /**
     * Metodo para verificar similitud de metodos con el actual
     *
     * @param id Id del metodo a comparar
     * @param params Parametros del metodo a comparar
     * @return True si son iguales los metodos, False si no son iguales los
     * metodos
     */
    public boolean equals(String id, List<OperacionPrograma> params) {
        if (id.equals(this.id) && params.size() == this.parametros.size()) {
            for (int i = 0; i < params.size(); i++) {
                if (!this.isMismoTipo(this.parametros.get(i).getTipo(), params.get(i).getTipo())) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo para evaluar que sean los mismos tipos, así poder usar el metodo
     *
     * @param tipo1 Tipo del parametro del metodo Python
     * @param tipo2 Tipo del parametro enviado
     * @return True si tienen el mismo tipo de parametro con el metodo
     */
    private boolean isMismoTipo(String tipo1, Integer tipo2) {
        if (tipo1.equals(VisualSemantica.FLOAT) && tipo2 <= 3) {
            return true;
        } else if (tipo1.equals(VisualSemantica.INT) && tipo2 <= 2) {
            return true;
        } else {
            return tipo1.equals(VisualSemantica.CHAR) && tipo2 == 1;
        }
    }

}
