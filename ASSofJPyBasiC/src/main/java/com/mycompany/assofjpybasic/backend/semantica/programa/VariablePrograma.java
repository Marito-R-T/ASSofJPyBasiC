/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.programa;

import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class VariablePrograma extends OperacionPrograma {

    protected final String id;
    protected final Integer ambito;
    protected Integer tipo;
    public final static Integer CHAR = 1, INT = 2, FLOAT = 3, CLASS = 4;

    /**
     * Constructor de una variable del programa principal C
     *
     * @param id Es el id que tiene la variable
     * @param ambito Es el ambito al que pertenece la variable
     * @param tipo Tipo de la que es el variable, 1->char 2->int 3->float
     * @param tri Triplete que sera esta variable
     */
    public VariablePrograma(String id, Integer ambito, Integer tipo, Triplete tri) {
        super(tipo, tri);
        this.id = id;
        this.ambito = ambito;
        this.tipo = tipo;
    }

    /**
     * Constructor de una variable del programa principal C
     *
     * @param id Es el id que tiene la variable
     * @param ambito Es el ambito al que pertenece la variable
     * @param tri Triplete que sera de esta variable
     */
    public VariablePrograma(String id, Integer ambito, Triplete tri) {
        super(null, tri);
        this.id = id;
        this.ambito = ambito;
    }

    /**
     * Constructor de una variable del programa principal C
     *
     * @param id Es el id que tiene la variable
     * @param ambito Es el ambito al que pertenece la variable
     * @param tipo Tipo de la que es el variable, 1->char 2->int 3->float
     * @param tri Triplete que pertenece a la variable
     */
    public VariablePrograma(String id, Integer ambito, OperacionPrograma tipo, Triplete tri) {
        super(tipo.getTipo(), tri);
        this.id = id;
        this.ambito = ambito;
        this.tipo = tipo.getTipo();
        super.hacerTripletes(tipo);
    }

    public String getId() {
        return id;
    }

    public Integer getAmbito() {
        return ambito;
    }

    @Override
    public Integer getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

}
