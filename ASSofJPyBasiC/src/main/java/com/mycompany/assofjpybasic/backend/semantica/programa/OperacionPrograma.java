/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.programa;

import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.TemporalArreglo;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.TerminalOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class OperacionPrograma {

    private Integer tipo;
    private List<Triplete> tripletes = new ArrayList<>();
    protected Triplete triplete;

    /**
     * Constructor con el tipo de operacion
     *
     * @param tipo 1 -> Char || 2 -> Int || 3-FLOAT -> Float
     * @param triplete Triplete que va a representar esta función
     */
    public OperacionPrograma(Integer tipo, Triplete triplete) {
        this.tipo = tipo;
        this.triplete = triplete;
        if (triplete instanceof TemporalArreglo) {
            this.tripletes.add(triplete);
        }
    }

    /**
     * Constructor con el tipo de operacion
     *
     * @param tipo 1 -> Char || 2 -> Int || 3-FLOAT -> Float
     * @param triplete Triplete que va a representar esta función
     */
    public OperacionPrograma(Triplete triplete, OperacionPrograma tipo) {
        this.tipo = tipo.getTipo();
        this.triplete = triplete;
        if (triplete instanceof TemporalArreglo) {
            this.tripletes.add(triplete);
        }
        this.hacerTripletes(tipo);
    }

    /**
     * Constructor con el tipo de operacion
     *
     * @param tipo1 1 -> Char || 2 -> Int || 3-FLOAT -> Float
     * @param tipo2 1 -> Char || 2 -> Int || 3-FLOAT -> Float
     * @param triplete Triplete que va a representar esta funcion
     */
    public OperacionPrograma(Integer tipo1, Integer tipo2, Triplete triplete) {
        if (tipo1 > tipo2) {
            this.tipo = tipo1;
        } else if (tipo1 < tipo2) {
            this.tipo = tipo2;
        } else {
            this.tipo = tipo1;
        }
        this.triplete = triplete;
    }

    /**
     * Constructor que se inicia, a partir de 2 operaciones
     *
     * @param op1 Operador 1 con el que se compara
     * @param op2 Operador 2 con el que se compara
     * @param triplete Triplete que va a representar esta función
     */
    public OperacionPrograma(OperacionPrograma op1, OperacionPrograma op2, Triplete triplete) {
        if (op1.getTipo() > op2.getTipo()) {
            this.tipo = op1.getTipo();
        } else if (op2.getTipo() < op2.getTipo()) {
            this.tipo = op2.getTipo();
        } else {
            this.tipo = op1.getTipo();
        }
        this.triplete = triplete;
        this.hacerTripletes(op1, op2);
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public List<Triplete> getTripletes() {
        return tripletes;
    }

    public Triplete getTriplete() {
        return triplete;
    }

    /**
     * Metodo para agregar los tripletes necesarios que conforman todas las
     * operaciones anteriores
     *
     * @param op1 Operación del programa 1
     * @param op2 Operación del programa 2
     * @return True si los ingresa de manera correcta, False si hay un fallo
     */
    protected final boolean hacerTripletes(OperacionPrograma op1, OperacionPrograma op2) {
        this.tripletes.addAll(op1.getTripletes());
        if (!(op1.getTriplete() instanceof TerminalOperator)) {
            this.tripletes.add(op1.getTriplete());
        }
        this.tripletes.addAll(op2.getTripletes());
        if (!(op2.getTriplete() instanceof TerminalOperator)) {
            this.tripletes.add(op2.getTriplete());
        }
        return false;
    }

    /**
     *
     * @param op1 Operación uno que tiene las tripletas
     * @return True si se agreago todo correctamente
     */
    protected final boolean hacerTripletes(OperacionPrograma op1) {
        this.tripletes.addAll(op1.getTripletes());
        if (!(op1.getTriplete() instanceof TerminalOperator)) {
            this.tripletes.add(op1.getTriplete());
        }
        return false;
    }

    public List<Triplete> mostrarTripletes() {
        List<Triplete> trr = new ArrayList<>();
        trr.addAll(this.tripletes);
        if (!(this.triplete instanceof TerminalOperator)) {
            trr.add(this.triplete);
        }
        /*tripletes.forEach((trip) -> {
            System.out.println(trip.devolverString());
        });
        System.out.println(triplete.devolverString());*/
        return trr;
    }

}
