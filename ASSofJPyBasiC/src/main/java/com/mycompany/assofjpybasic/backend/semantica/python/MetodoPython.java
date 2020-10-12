/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.python;

import com.mycompany.assofjpybasic.backend.semantica.programa.OperacionPrograma;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class MetodoPython {

    private final String id;
    private String TIPO;
    private final List<VariablePython> parametros;
    private final List<Triplete> trip = new ArrayList<>();
    private String nombre;

    /**
     *
     *
     * @param id Id del metodo
     * @param parametros lista de parametros del metodo
     */
    public MetodoPython(String id, List<VariablePython> parametros) {
        this.id = id;
        this.parametros = parametros;
        String params = "";
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

    /**
     * Metodo para verificar coincidencia de metodo con el actual
     *
     * @param id Id del metodo a comparar
     * @param params Parametros del metodo Visual a comparar
     * @return True si es igual el metodo Python con los parametros ingresados
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
        if (tipo1.equals(PythonSemantica.FLOAT) && tipo2 <= 3) {
            return true;
        } else if (tipo1.equals(PythonSemantica.INT) && tipo2 <= 2) {
            return true;
        } else {
            return tipo1.equals(PythonSemantica.CHAR) && tipo2 == 1;
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Triplete> getTrip() {
        return trip;
    }

    public String getNombre() {
        return nombre;
    }

}
