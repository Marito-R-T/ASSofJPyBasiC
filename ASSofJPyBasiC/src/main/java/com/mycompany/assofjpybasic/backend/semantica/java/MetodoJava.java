/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.java;

import com.mycompany.assofjpybasic.backend.semantica.programa.OperacionPrograma;
import com.mycompany.assofjpybasic.backend.semantica.programa.VariablePrograma;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AsignarValor;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.CallMetodo;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.RestOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.SumOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.TerminalOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mari2bar
 */
public class MetodoJava {

    private final String id;
    private final Integer TIPO;
    private final List<VariableJava> parametros;
    private final List<Triplete> tripletes = new ArrayList<>();
    private final String clase;

    /**
     *
     *
     * @param id Id del metodo
     * @param TIPO Tipo del metodo 1 - CHAR 2 - INT 3 - FLOAT 4 - VOID
     * @param parametros lista de parametros del metodo
     * @param clase Id de la clase padre
     */
    public MetodoJava(String id, Integer TIPO, List<VariableJava> parametros, String clase) {
        this.id = id;
        this.TIPO = TIPO;
        this.parametros = parametros;
        this.clase = clase;
    }

    /**
     * Metodo para verificar si ya existe este Metodo
     *
     * @param var el metodo con el que se comparara este metodo
     * @return true si es igual, false si no lo es
     */
    public boolean isnotEquals(MetodoJava var) {
        return !this.id.equals(var.getId()) || !Objects.equals(this.TIPO, var.TIPO) || !MetodoJava.sonMismosParametros(this.parametros, var.getParametros());
    }

    /**
     * Metodo para verificar si ya existe este Constructor
     *
     * @param var el metodo con el que se comparara este metodo
     * @return true si es igual, false si no lo es
     */
    public boolean equalsConstructor(MetodoJava var) {
        return MetodoJava.sonMismosParametros(this.parametros, var.getParametros());
    }

    /**
     * Metodo para ver si el array1 es igual al array2
     *
     * @param parametros1 Parametros del primer metodo
     * @param parametros2 Parametros del segundo metodo
     * @return true Si son los mismos, false si no lo son
     */
    public static final boolean sonMismosParametros(final List<VariableJava> parametros1, final List<VariableJava> parametros2) {
        if (parametros1.size() == parametros2.size()) {
            for (int i = 0; i < parametros1.size(); i++) {
                if (!parametros1.get(i).isMismoTipo(parametros2.get(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public List<VariableJava> getParametros() {
        return parametros;
    }

    public String getId() {
        return id;
    }

    /**
     * Metodo para verificar su similitud con el actual
     *
     * @param id Id a comparar con este metodo
     * @param params Parametros a comparar con este metodo
     * @return True si es igual a este Metodo, False si no lo es
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
     * Metodo para verificar su similitud con el actual
     *
     * @param id Id a comparar con este metodo
     * @param params Parametros a comparar con este metodo
     * @return True si es igual a este Metodo, False si no lo es
     */
    public boolean equals(List<OperacionJava> params, String id) {
        if (id.equals(this.id) && params.size() == this.parametros.size()) {
            for (int i = 0; i < params.size(); i++) {
                System.out.println("");
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
     * Metodo para verificar que sea el mismo tipo de metodo -> char, int, float
     *
     * @param tipo1 Tipo del parametro de este metodo
     * @param tipo2 Tipo del parametro del metodo a comparar
     * @return True si el tipo 1 es mayor o igual al tipo 2, False si el tipo1
     * es menor al tipo 2
     */
    private boolean isMismoTipo(Integer tipo1, Integer tipo2) {
        return tipo1 >= tipo2;
    }

    public List<Triplete> getTripletes() {
        return tripletes;
    }

    public String mostrarMetodo(String id) {
        String comentario;
        if (id.equals(this.id)) {
            comentario = "//Constructor de la clase " + id + "\n";
        } else {
            comentario = "//Metodo " + this.id + " de la clase " + id + "\n";
        }
        String params = "void JV_" + id + "_" + this.id;
        for (VariableJava parametro : this.parametros) {
            params += "_" + OperacionJava.obtenerTipo(parametro.getTipo());
        }
        params += "()";
        String metodo = "{\n";
        for (Triplete triplete : this.tripletes) {
            metodo += triplete.devolverString() + "\n";
        }
        metodo += "}\n";
        return comentario + params + metodo;
    }

    public String nombreMetodo() {
        String params = "JV_" + this.clase + "_";
        params += this.id;
        for (VariableJava parametro : this.parametros) {
            params += "_" + OperacionJava.obtenerTipo(parametro.getTipo());
        }
        return params;
    }

    public String mostrarMetodo(String id, List<Triplete> tri) {
        String comentario;
        if (id.equals(this.id)) {
            comentario = "//Constructor de la clase " + id + "\n";
        } else {
            comentario = "//Metodo " + this.id + " de la clase " + id + "\n";
        }
        String params = "void JV_" + id + "_" + this.id;
        params = this.parametros.stream().map((parametro) -> "_" + OperacionJava.obtenerTipo(parametro.getTipo())).reduce(params, String::concat);
        params += "()";
        String metodo = "{\n";
        metodo = tri.stream().map((triplete) -> triplete.devolverString() + "\n").reduce(metodo, String::concat);
        metodo = this.tripletes.stream().map((triplete) -> triplete.devolverString() + "\n").reduce(metodo, String::concat);
        metodo += "}\n";
        return comentario + params + metodo;
    }

    public Integer getTIPO() {
        return TIPO;
    }

    public List<Triplete> verMetodo(Integer pos, List<OperacionJava> params) {
        if (pos != null) {
            List<Triplete> tri = new ArrayList<>();
            SumOperator sum = new SumOperator(null, new TerminalOperator("p"), new TerminalOperator("" + pos + 2), "int");
            tri.add(sum);
            tri.add(new AsignarValor(null, new TerminalOperator("stack[" + sum.getId() + "]"), new TerminalOperator("stack[p]")));
            for (int i = 0; i < params.size(); i++) {
                tri.addAll(params.get(i).mostrarTripletes());
                SumOperator op1 = new SumOperator(null, new TerminalOperator("p"), new TerminalOperator((pos + i + 3) + ""), "int");
                tri.add(op1);
                tri.add(new AsignarValor(null, new TerminalOperator("stack[" + op1.getId() + "]"), params.get(i).triplete));
            }
            SumOperator op2 = new SumOperator(null, new TerminalOperator("p"), new TerminalOperator((pos + 2) + ""), "int");
            tri.add(op2);
            tri.add(new AsignarValor(null, new TerminalOperator("p"), op2));
            tri.add(new CallMetodo(this.nombreMetodo()));
            RestOperator op3 = new RestOperator(null, new TerminalOperator("p"), new TerminalOperator((pos + 2) + ""), "int");
            tri.add(op3);
            tri.add(new AsignarValor(null, new TerminalOperator("p"), op3));
            return tri;
        } else {
            return new ArrayList<>();
        }
    }

    public List<Triplete> verMetodo(Integer pos, List<OperacionJava> params, VariablePrograma pro) {
        if (pos != null) {
            List<Triplete> tri = new ArrayList<>();
            SumOperator sum = new SumOperator(null, new TerminalOperator("p"), new TerminalOperator("" + pos), "int");
            tri.add(sum);
            tri.add(new AsignarValor(null, new TerminalOperator("stack[" + sum.getId() + "]"), new TerminalOperator("" + pro.getHeap())));
            for (int i = 0; i < params.size(); i++) {
                tri.addAll(params.get(i).mostrarTripletes());
                SumOperator op1 = new SumOperator(null, new TerminalOperator("p"), new TerminalOperator((pos + i + 2) + ""), "int");
                tri.add(op1);
                tri.add(new AsignarValor(null, new TerminalOperator("stack[" + op1.getId() + "]"), params.get(i).triplete));
            }
            SumOperator op2 = new SumOperator(null, new TerminalOperator("p"), new TerminalOperator(pos + ""), "int");
            tri.add(op2);
            tri.add(new AsignarValor(null, new TerminalOperator("p"), op2));
            tri.add(new CallMetodo(this.nombreMetodo()));
            RestOperator op3 = new RestOperator(null, new TerminalOperator("p"), new TerminalOperator(pos + ""), "int");
            tri.add(op3);
            tri.add(new AsignarValor(null, new TerminalOperator("p"), op3));
            return tri;
        } else {
            return new ArrayList<>();
        }
    }

    public List<Triplete> verMetodo(Integer pos, VariablePrograma pro, List<OperacionPrograma> params) {
        if (pos != null) {
            List<Triplete> tri = new ArrayList<>();
            SumOperator sum = new SumOperator(null, new TerminalOperator("p"), new TerminalOperator("" + pos), "int");
            tri.add(sum);
            tri.add(new AsignarValor(null, new TerminalOperator("stack[" + sum.getId() + "]"), new TerminalOperator("" + pro.getHeap())));
            for (int i = 0; i < params.size(); i++) {
                tri.addAll(params.get(i).mostrarTripletes());
                SumOperator op1 = new SumOperator(null, new TerminalOperator("p"), new TerminalOperator((pos + i + 2) + ""), "int");
                tri.add(op1);
                tri.add(new AsignarValor(null, new TerminalOperator("stack[" + op1.getId() + "]"), params.get(i).getTriplete()));
            }
            SumOperator op2 = new SumOperator(null, new TerminalOperator("p"), new TerminalOperator(pos + ""), "int");
            tri.add(op2);
            tri.add(new AsignarValor(null, new TerminalOperator("p"), op2));
            tri.add(new CallMetodo(this.nombreMetodo()));
            RestOperator op3 = new RestOperator(null, new TerminalOperator("p"), new TerminalOperator(pos + ""), "int");
            tri.add(op3);
            tri.add(new AsignarValor(null, new TerminalOperator("p"), op3));
            return tri;
        } else {
            return new ArrayList<>();
        }
    }

}
