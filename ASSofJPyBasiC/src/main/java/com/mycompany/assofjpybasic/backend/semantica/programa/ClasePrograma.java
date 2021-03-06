/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.programa;

import com.mycompany.assofjpybasic.backend.semantica.java.TablaJava;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;

/**
 * Clase java como variable en el programa principal
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class ClasePrograma extends VariablePrograma {

    private final TablaJava clase;

    /**
     * Variable que soporta una clase java en el programa C
     *
     * @param id Id de la clase Java en el programa C
     * @param ambito Ambito en donde se instancia la clase
     * @param clase Clase a la que pertenece la variable
     * @param tri Triplete que usará esta clase
     */
    public ClasePrograma(String id, Integer ambito, TablaJava clase, Triplete tri) {
        super(id, ambito, VariablePrograma.CLASS, tri);
        this.clase = clase;
    }

}
