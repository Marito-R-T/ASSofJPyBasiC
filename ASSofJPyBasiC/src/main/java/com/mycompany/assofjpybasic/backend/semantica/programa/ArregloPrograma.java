/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.programa;

import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class ArregloPrograma extends VariablePrograma {

    private final List<Integer> tam;

    /**
     * Constructor del arreglo de una variable
     *
     * @param id Nombre del id del arreglo
     * @param ambito Ambito del arreglo en cuestion
     * @param tipo Tipo del arreglo, 1->char 2->int 3->float
     * @param tam Dimensiones del arreglo, el tamaño de la lista es las
     * dimensiones que contiene el arreglo
     */
    public ArregloPrograma(String id, Integer ambito, Integer tipo, List<Integer> tam) {
        super(id, ambito, tipo);
        this.tam = tam;
    }

}
