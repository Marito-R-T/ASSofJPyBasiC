/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.programa;

import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AsignarTemporal;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.DefinirArreglo;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.PorOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.SumOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.TerminalOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un arreglo en el programa
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
        this.obtenerTam(tam);
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
     * Metodo para obtener tamaño del arreglo
     *
     * @param tam Lista de operaciones que contiene el valor de las casillas
     */
    public final void obtenerTam(List<OperacionPrograma> tam) {
        int tamano = 1;
        for (OperacionPrograma operacionPrograma : tam) {
            tamano *= Math.round(operacionPrograma.getValor());
        }
        super.setTamano(tamano);
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
            //super.getTripletes().addAll(operacionPrograma.getTripletes());
            this.finales.add(new TerminalOperator(Math.round(operacionPrograma.getValor()) + ""));
            /*if (!(operacionPrograma.getTriplete() instanceof TerminalOperator)) {
                this.finales.add(operacionPrograma.getTriplete());
            } else {
                Triplete tri = new AsignarTemporal(null, operacionPrograma.getTriplete(), null);
                ((AsignarTemporal) tri).setTipo(Triplete.tipos[operacionPrograma.getTipo() - 1]);
                super.getTripletes().add(tri);
                this.finales.add(tri);
            }
            /*if (anterior != null) {
                super.getTripletes().add(new PorOperator(null, anterior.getTriplete(),
                        operacionPrograma.getTriplete(),
                        Triplete.devolverTipo(anterior, operacionPrograma)));
            }
            anterior = operacionPrograma;*/
        }
        /*if (super.getTripletes() != null && !super.getTripletes().isEmpty()) {
            ((DefinirArreglo) super.getTriplete()).setTriplete(super.getTripletes().get(super.getTripletes().size() - 1));
            }*/
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
        if (this.finales.size() > 1) {
            this.obtenerS(trip, 0, this.finales.size() - 1);
        } else {
        }
        TerminalOperator ter = new TerminalOperator(this.getTripletes().get(this.getTripletes().size() - 1).getId());
        this.getTripletes().addAll(op.getTripletes());
        return ter;
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
        if (this.finales.size() > 1) {
            this.obtenerS(trip, 0, this.finales.size() - 1);
        } else {
        }
        return this.getTripletes().get(this.getTripletes().size() - 1);
    }

    /**
     * Metodo recursivo para obtener la suma los tripletes de un arreglo ya
     * iniciado
     *
     * @param trip Lista de tripletes a obtener sus sumas
     * @param posi Posicion donde inicialmente queremos la suma
     * @param posf Posicion donde finaliza la suma requerida
     * @return
     */
    public final Triplete obtenerS(List<Triplete> trip, int posi, int posf) {
        if (posi == posf) {
            return obtener(trip, 0, posf);
        }
        Triplete sum = new SumOperator(null, this.obtener(trip, 0, posi), this.obtenerS(trip, (posi + 1), posf), "int");
        this.getTripletes().add(sum);
        return sum;
    }

    /**
     * Metodo recursivo para obtener las multiplicaciones necesaria para un
     * arreglo ya iniciado
     *
     * @param trip Lista de tripletes para obtener su multiplicacion
     * @param posi Posicion inicial de la lista que queremos la suma
     * @param posf Posicion final de la lista para la que falta para la suma
     * @return
     */
    public final Triplete obtener(List<Triplete> trip, int posi, int posf) {
        if (posi == posf) {
            return this.finales.get(posf);
        } else {
            Triplete por = new PorOperator(null, trip.get(posi), this.obtener(trip, (posi + 1), posf), "int");
            this.getTripletes().add(por);
            return por;
        }
    }

}
