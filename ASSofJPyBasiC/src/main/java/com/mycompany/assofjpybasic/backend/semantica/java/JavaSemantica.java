/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.java;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mari2bar
 */
public class JavaSemantica {

    private final List<TablaJava> tabla;

    public JavaSemantica() {
        tabla = new ArrayList<>();
    }

    public List<TablaJava> getTabla() {
        return tabla;
    }

    /**
     * Metodo para verificar que se pueda agregar Clase Y agregarla
     * seguidamente.
     *
     * @param tab Clase java que se va a ingresar
     * @return True si no hay otra clase con el mismo nombre, False si ya esta
     * repetida la clase
     */
    public boolean agregarTabla(TablaJava tab) {
        if (tabla.stream().noneMatch((tablaJava) -> (tablaJava.getId().equals(tab.getId())))) {
            this.tabla.add(tab);
            return true;
        } else {
            return false;
        }
    }

    public void mostrarClases() {
        for (TablaJava tablaJava : tabla) {
            System.out.println("");
            System.out.println(tablaJava.getId() + "  CLASE");
            tablaJava.getPrincipales().forEach((prin) -> {
                System.out.println(prin.devolverString());
            });
            System.out.println("");
            tablaJava.getConstructores().forEach((con) -> {
                System.out.println("");
                System.out.println(con.getId() + " CONSTRUCTOR");
                con.getTripletes().forEach((tri) -> {
                    System.out.println(tri.devolverString());
                });
                System.out.println("------------------------");
            });
            tablaJava.getMetodos().forEach((con) -> {
                System.out.println("");
                System.out.println(con.getId() + " METODOS");
                con.getTripletes().forEach((tri) -> {
                    System.out.println(tri.devolverString());
                });
                System.out.println("------------------------");
            });
        }
    }

}
