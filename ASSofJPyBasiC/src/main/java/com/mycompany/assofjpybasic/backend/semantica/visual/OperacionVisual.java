/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.visual;

import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.TemporalArreglo;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.TerminalOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una operacion en Visual Basic
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class OperacionVisual {

    private String tipo;
    private List<Triplete> tripletes = new ArrayList<>();
    protected Triplete triplete;

    /**
     * Constructor con el tipo de operacion
     *
     * @param tipo CHAR -> Char || INT -> Int || INT-FLOAT -> Float
     * @param triplete Triplete de la operacion
     */
    public OperacionVisual(String tipo, Triplete triplete) {
        this.tipo = tipo;
        this.triplete = triplete;
        if (triplete instanceof TemporalArreglo) {
            this.tripletes.add(triplete);
        }
    }

    /**
     * Constructor que se inicia, a partir de 2 operaciones
     *
     * @param op1 Operador 1 con el que se compara
     * @param op2 Operador 2 con el que se compara
     * @param triplete Triplete de la operacion
     */
    public OperacionVisual(OperacionVisual op1, OperacionVisual op2, Triplete triplete) {
        if (op2.getTipo().contains("FLOAT") || op1.getTipo().contains("FLOAT")) {
            this.tipo = VisualSemantica.FLOAT;
        } else {
            this.tipo = VisualSemantica.INT;
        }
        this.triplete = triplete;
        this.hacerTripletes(op1, op2);
    }

    /**
     * Metodo para agregar los tripletes necesarios que conforman todas las
     * operaciones anteriores
     *
     * @param op1 Operación del programa 1
     * @param op2 Operación del programa 2
     * @return True si los ingresa de manera correcta, False si hay un fallo
     */
    protected final boolean hacerTripletes(OperacionVisual op1, OperacionVisual op2) {
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

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public Triplete getTriplete() {
        return triplete;
    }

    public List<Triplete> getTripletes() {
        return tripletes;
    }

    /**
     * Forma de obtner el tipo de c desde python por medio de dos
     * variables/operaciones
     *
     * @param op1 Operación 1 que se evaluara
     * @param op2 Operacion 2 que se evaluara
     * @return Caracter con el que se reconoce en c el tipo en cuestión
     */
    public static String obtenerTipo(OperacionVisual op1, OperacionVisual op2) {
        if (op1.getTipo().equals("INT-FLOAT") || op2.getTipo().equals("INT-FLOAT")) {
            return "float";
        } else {
            return "int";
        }
    }

    public static String obtenerTipo(OperacionVisual op1) {
        switch (op1.getTipo()) {
            case "INT-FLOAT":
                return "float";
            case "INT":
                return "int";
            default:
                return "char";
        }
    }

    public static String obtenerTipo(String op1) {
        if (op1 != null) {
            switch (op1) {
                case "INT-FLOAT":
                    return "float";
                case "INT":
                    return "int";
                default:
                    return "char";
            }
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

}
