/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.java;

import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.TerminalOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mari2bar
 */
public class OperacionJava {

    private Integer tipo;
    private final List<Triplete> tripletes = new ArrayList<>();
    protected Triplete triplete;

    /**
     * Constructor con el tipo de operacion
     *
     * @param entero Tipo de la operación en Java
     * @param trip Triplete para ingresar
     */
    public OperacionJava(Integer entero, Triplete trip) {
        this.tipo = entero;
        this.triplete = trip;
    }

    /**
     * Constructor con el tipo de operacion
     *
     * @param op1 Operación Java de
     * @param op2
     * @param trip Triplete para ingresar
     */
    public OperacionJava(OperacionJava op1, OperacionJava op2, Triplete trip) {
        this.tipo = TablaJava.regresarTipo(op1.tipo, op2.tipo);
        this.triplete = trip;
        this.hacerTripletes(op1, op2);
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    /**
     * Forma de obtner el tipo de c desde python por medio de dos
     * variables/operaciones
     *
     * @param op1 Operación 1 que se evaluara
     * @param op2 Operacion 2 que se evaluara
     * @return Caracter con el que se reconoce en c el tipo en cuestión
     */
    public static String obtenerTipo(OperacionJava op1, OperacionJava op2) {
        if (op1.getTipo() == 3 || op2.getTipo() == 3) {
            return "float";
        } else if (op1.getTipo() == 2 || op2.getTipo() == 2) {
            return "int";
        } else {
            return "char";
        }
    }

    public static String obtenerTipo(OperacionJava op1) {
        switch (op1.getTipo()) {
            case 1:
                return "char";
            case 2:
                return "int";
            case 3:
                return "float";
        }
        return "float";
    }

    public static String obtenerTipo(Integer op1) {
        switch (op1) {
            case 1:
                return "char";
            case 2:
                return "int";
            case 3:
                return "float";
        }
        return "float";
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

    /**
     * Metodo para agregar los tripletes necesarios que conforman todas las
     * operaciones anteriores
     *
     * @param op1 Operación del programa 1
     * @param op2 Operación del programa 2
     * @return True si los ingresa de manera correcta, False si hay un fallo
     */
    protected final boolean hacerTripletes(OperacionJava op1, OperacionJava op2) {
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

    public List<Triplete> getTripletes() {
        return tripletes;
    }

    public Triplete getTriplete() {
        return triplete;
    }

}
