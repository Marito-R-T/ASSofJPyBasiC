/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.programa;

import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AsignarArreglo;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AsignarTemporal;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.DefinirArreglo;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.PorOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.SumOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.TerminalOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class ArregloPrograma extends VariablePrograma {

    private final List<OperacionPrograma> tam;
    private final List<Triplete> finales = new ArrayList<>();

    /**
     * Constructor del arreglo de una variable
     *
     * @param id Nombre del id del arreglo
     * @param ambito Ambito del arreglo en cuestion
     * @param tipo Tipo del arreglo, 1->char 2->int 3->float
     * @param tam Dimensiones del arreglo, el tamaño de la lista es las
     * dimensiones que contiene el arreglo
     * @param tri Triplete que es parte de la variable
     */
    public ArregloPrograma(String id, Integer ambito, Integer tipo, List<OperacionPrograma> tam, Triplete tri) {
        super(id, ambito, tipo, tri);
        this.tam = tam;
        if (tri instanceof DefinirArreglo) {
            this.obtenerTripletes(tam);
        }
    }

    /**
     * Constructor para agregar una operación a una parte del arreglo
     *
     * @param id Id del arreglo
     * @param ambito Ambito
     * @param tipo
     * @param tam
     * @param arreglo
     * @param op
     */
    public ArregloPrograma(String id, Integer ambito, Integer tipo, List<OperacionPrograma> tam, ArregloPrograma arreglo, OperacionPrograma op) {
        super(id, ambito, tipo, null);
        this.triplete = this.obtenerTriplete(tam, arreglo.getFinales(), op);
        this.tam = tam;
    }

    /**
     * Constructor para agregar a un temporal un arreglo
     *
     * @param id Id del Triplete
     * @param ambito Ambito del Triplete
     * @param tipo Tipo del triplete
     * @param tam Lista de Operaciones Para asignar el arreglo
     * @param arreglo Arreglo del que se va sacar los datos
     */
    public ArregloPrograma(String id, Integer ambito, Integer tipo, List<OperacionPrograma> tam, ArregloPrograma arreglo) {
        super(id, ambito, tipo, null);
        this.triplete = this.obtenerTriplete(tam, arreglo.getFinales());
        this.tam = tam;
    }

    public List<Triplete> getFinales() {
        return finales;
    }

    public List<OperacionPrograma> getTam() {
        return tam;
    }

    /**
     * Metodo para obtener todos los tripletes de las operaciones dentro de los
     * parentesis
     *
     * @param tam Operaciones dentro de los parentesis
     */
    public final void obtenerTripletes(List<OperacionPrograma> tam) {
        OperacionPrograma anterior = null;
        for (OperacionPrograma operacionPrograma : tam) {
            super.getTripletes().addAll(operacionPrograma.getTripletes());
            if (!(operacionPrograma.getTriplete() instanceof TerminalOperator)) {
                super.getTripletes().add(operacionPrograma.getTriplete());
                this.finales.add(operacionPrograma.getTriplete());
            } else {
                Triplete tri = new AsignarTemporal(null, operacionPrograma.getTriplete(), null);
                ((AsignarTemporal) tri).setTipo(Triplete.tipos[operacionPrograma.getTipo() - 1]);
                super.getTripletes().add(tri);
                this.finales.add(tri);
            }
            if (anterior != null) {
                super.getTripletes().add(new PorOperator(null, anterior.getTriplete(),
                        operacionPrograma.getTriplete(),
                        Triplete.devolverTipo(anterior, operacionPrograma)));
            }
            anterior = operacionPrograma;
        }
        if (super.getTripletes() != null && !super.getTripletes().isEmpty()) {
            ((DefinirArreglo) super.getTriplete()).setTriplete(super.getTripletes().get(super.getTripletes().size() - 1));
        }
    }

    /**
     * Metodo para obtener todos los tripletes de las operaciones dentro de los
     * parentesis
     *
     * @param tam Operaciones dentro de los parentesis
     */
    public final void hacerTripletes(List<OperacionPrograma> tam) {
        OperacionPrograma anterior = null;
        for (OperacionPrograma operacionPrograma : tam) {
            super.getTripletes().addAll(operacionPrograma.getTripletes());
            if (!(operacionPrograma.getTriplete() instanceof TerminalOperator)) {
                super.getTripletes().add(operacionPrograma.getTriplete());
                this.finales.add(operacionPrograma.getTriplete());
            } else {
                Triplete tri = new AsignarTemporal(null, operacionPrograma.getTriplete(), null);
                ((AsignarTemporal) tri).setTipo(Triplete.tipos[operacionPrograma.getTipo() - 1]);
                super.getTripletes().add(tri);
                this.finales.add(tri);
            }
            anterior = operacionPrograma;
        }
    }

    /**
     * Metodo para obtener todos los tripletes de las operaciones dentro de los
     * parentesis
     *
     * @param tam Operaciones dentro de los parentesis
     */
    public final void hacerTripletes2(List<OperacionPrograma> tam) {
        OperacionPrograma anterior = null;
        for (OperacionPrograma operacionPrograma : tam) {
            super.getTripletes().addAll(operacionPrograma.getTripletes());
            if (!(operacionPrograma.getTriplete() instanceof TerminalOperator)) {
                super.getTripletes().add(operacionPrograma.getTriplete());
                this.finales.add(operacionPrograma.getTriplete());
            } else {
                Triplete tri = new AsignarTemporal(null, operacionPrograma.getTriplete(), null);
                ((AsignarTemporal) tri).setTipo(Triplete.tipos[operacionPrograma.getTipo() - 1]);
                super.getTripletes().add(tri);
                this.finales.add(tri);
            }
            if (anterior != null) {
                super.getTripletes().add(new PorOperator(null, anterior.getTriplete(),
                        operacionPrograma.getTriplete(),
                        Triplete.devolverTipo(anterior, operacionPrograma)));
            }
            anterior = operacionPrograma;
        }
    }

    /**
     * Obtener triplete de la asignación de las variables
     *
     * @param tam Lista de Operaciones de donde va a ser el arreglo
     * @param trip Lista de Tripletes del arreglo operacion
     * @param op Operacion de programa
     * @return El triplete final
     */
    public final Triplete obtenerTriplete(List<OperacionPrograma> tam, List<Triplete> trip, OperacionPrograma op) {
        this.hacerTripletes2(tam);
        Triplete tr = null;
        if (this.finales.size() > 1) {
            for (int i = this.finales.size() - 1; i > 0; i--) {
                if (i != 0) {
                    Triplete por = new PorOperator(null, this.finales.get(i), trip.get(i - 1), "int");
                    this.getTripletes().add(por);
                    this.getTripletes().add(new SumOperator(null, this.finales.get(i - 1), por, "int"));
                }
            }
        } else {
            this.getTripletes().add(this.finales.get(0));
        }
        this.getTripletes().addAll(op.getTripletes());
        return new AsignarArreglo(this.id, this.getTripletes().get(this.getTripletes().size() - 1), op.getTriplete());
    }

    /**
     * Obtener triplete de la asignación de las variables
     *
     * @param tam Lista de Operaciones de donde va a ser el arreglo
     * @param trip Lista de Tripletes del arreglo operacion
     * @return El triplete final
     */
    public final Triplete obtenerTriplete(List<OperacionPrograma> tam, List<Triplete> trip) {
        this.hacerTripletes(tam);
        Triplete tr = null;
        if (this.finales.size() > 1) {
            for (int i = this.finales.size() - 1; i > 0; i--) {
                if (i != 0) {
                    Triplete por = new PorOperator(null, this.finales.get(i), trip.get(i - 1), "int");
                    this.getTripletes().add(por);
                    this.getTripletes().add(new SumOperator(null, this.finales.get(i - 1), por, "int"));
                }
            }
        } else {
            this.getTripletes().add(this.finales.get(0));
        }
        return this.getTripletes().get(this.getTripletes().size() - 1);
    }

}
