/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.java;

import com.mycompany.assofjpybasic.backend.semantica.programa.OperacionPrograma;
import com.mycompany.assofjpybasic.backend.semantica.programa.ProgramaSemantica;
import com.mycompany.assofjpybasic.backend.semantica.programa.VariablePrograma;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AsignarTemporal;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AsignarValor;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.CallMetodo;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.P;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.RestOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Stack;
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
    private final List<String> fl = new ArrayList<>();

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

    /**
     * Metodo para mostrar el constructor en codigo tres direcciones
     *
     * @param id String
     * @return String
     */
    public String mostrarMetodo(String id) {
        String comentario;
        if (id.equals(this.id)) {
            comentario = "//Constructor de la clase " + id + "\n";
        } else {
            comentario = "//Metodo " + this.id + " de la clase " + id + "\n";
        }
        String params = "JV_" + id + "_" + this.id;
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

    /**
     * Metodo para mostrar el constructor en codigo tres direcciones para
     * ejecutar
     *
     * @param id String
     * @return String
     */
    public String mostrarMetodoE(String id) {
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
            metodo += triplete.devolverStringE() + "\n";
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

    /**
     * Metodo para mostrar metodo de java
     *
     * @param id Id del metodo
     * @param tri Lista
     * @return
     */
    public String mostrarMetodo(String id, List<Triplete> tri) {
        String comentario;
        if (id.equals(this.id)) {
            comentario = "//Constructor de la clase " + id + "\n";
        } else {
            comentario = "//Metodo " + this.id + " de la clase " + id + "\n";
        }
        String params = "JV_" + id + "_" + this.id;
        params = this.parametros.stream().map((parametro) -> "_" + OperacionJava.obtenerTipo(parametro.getTipo())).reduce(params, String::concat);
        params += "()";
        String metodo = "{\n";
        metodo = tri.stream().map((triplete) -> triplete.devolverString() + "\n").reduce(metodo, String::concat);
        metodo = this.tripletes.stream().map((triplete) -> triplete.devolverString() + "\n").reduce(metodo, String::concat);
        metodo += "}\n";
        return comentario + params + metodo;
    }

    /**
     * Metodo para mostrar metodo de java Ejecutable
     *
     * @param id Id del metodo
     * @param tri Lista
     * @return
     */
    public String mostrarMetodoE(String id, List<Triplete> tri) {
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
        metodo = tri.stream().map((triplete) -> triplete.devolverStringE() + "\n").reduce(metodo, String::concat);
        metodo = this.tripletes.stream().map((triplete) -> triplete.devolverStringE() + "\n").reduce(metodo, String::concat);
        metodo += "}\n";
        return comentario + params + metodo;
    }

    public Integer getTIPO() {
        return TIPO;
    }

    public List<Triplete> verMetodo(Integer pos, List<OperacionJava> params) {
        if (pos != null) {
            List<Triplete> tri = new ArrayList<>();
            SumOperator sum = new SumOperator(null, new P(), new TerminalOperator("" + (pos + 2)), "int");
            tri.add(sum);
            Triplete ast2 = new AsignarTemporal(null, new Stack(new P()), "float");
            tri.add(ast2);
            tri.add(new AsignarValor(null, new Stack(sum), ast2));
            for (int i = 0; i < params.size(); i++) {
                tri.addAll(params.get(i).mostrarTripletes());
                SumOperator op1 = new SumOperator(null, new P(), new TerminalOperator((pos + i + 4) + ""), "int");
                tri.add(op1);
                tri.add(new AsignarValor(null, new Stack(op1), params.get(i).triplete));
            }
            SumOperator op2 = new SumOperator(null, new P(), new TerminalOperator((pos + 2) + ""), "int");
            tri.add(op2);
            tri.add(new AsignarValor(null, new P(), op2));
            tri.add(new CallMetodo(this.nombreMetodo()));
            RestOperator op3 = new RestOperator(null, new P(), new TerminalOperator((pos + 2) + ""), "int");
            tri.add(op3);
            tri.add(new AsignarValor(null, new P(), op3));
            return tri;
        } else {
            return new ArrayList<>();
        }
    }

    public List<Triplete> verMetodo(Integer pos, List<OperacionJava> params, VariablePrograma pro) {
        if (pos != null) {
            List<Triplete> tri = new ArrayList<>();
            SumOperator sum = new SumOperator(null, new P(), new TerminalOperator("" + pos), "int");
            tri.add(sum);
            tri.add(new AsignarValor(null, new Stack(sum), new TerminalOperator("" + pro.getHeap())));
            for (int i = 0; i < params.size(); i++) {
                tri.addAll(params.get(i).mostrarTripletes());
                SumOperator op1 = new SumOperator(null, new P(), new TerminalOperator((pos + i + 2) + ""), "int");
                tri.add(op1);
                tri.add(new AsignarValor(null, new Stack(op1), params.get(i).triplete));
            }
            SumOperator op2 = new SumOperator(null, new P(), new TerminalOperator(pos + ""), "int");
            tri.add(op2);
            tri.add(new AsignarValor(null, new P(), op2));
            tri.add(new CallMetodo(this.nombreMetodo()));
            RestOperator op3 = new RestOperator(null, new P(), new TerminalOperator(pos + ""), "int");
            tri.add(op3);
            tri.add(new AsignarValor(null, new P(), op3));
            return tri;
        } else {
            return new ArrayList<>();
        }
    }

    public List<Triplete> verMetodo(Integer pos, VariablePrograma pro, List<OperacionPrograma> params, ProgramaSemantica sem) {
        if (pos != null) {
            List<Triplete> tri = new ArrayList<>();
            SumOperator sum = new SumOperator(null, new P(), new TerminalOperator("" + pos), "int");
            tri.add(sum);
            String s = ".LC" + Triplete.FLOAT;
            Triplete.FLOAT += 1;
            sem.getFl().add("\t.align 4");
            sem.getFl().add(s + ":");
            sem.getFl().add("\t.long\t" + Float.floatToIntBits(pro.getHeap()));
            tri.add(new AsignarValor(null, new Stack(sum), new TerminalOperator("" + pro.getHeap(), s)));
            for (int i = 0; i < params.size(); i++) {
                tri.addAll(params.get(i).mostrarTripletes());
                SumOperator op1 = new SumOperator(null, new P(), new TerminalOperator((pos + i + 2) + ""), "int");
                tri.add(op1);
                tri.add(new AsignarValor(null, new Stack(op1), params.get(i).getTriplete()));
            }
            SumOperator op2 = new SumOperator(null, new P(), new TerminalOperator(pos + ""), "int");
            tri.add(op2);
            tri.add(new AsignarValor(null, new P(), op2));
            tri.add(new CallMetodo(this.nombreMetodo()));
            RestOperator op3 = new RestOperator(null, new P(), new TerminalOperator(pos + ""), "int");
            tri.add(op3);
            tri.add(new AsignarValor(null, new P(), op3));
            return tri;
        } else {
            return new ArrayList<>();
        }
    }

    public String mostrarMetodoAss(int lf, String str, int ite) {
        String nom = this.nombreMetodo();
        if (!str.equals("")) {
            str = "\t.section\t.rodata\n" + str + "\t.text\n";
        }
        String s = str
                + "\t.globl\t" + nom + "\n"
                + "\t.type\t" + nom + ", @function\n"
                + nom + ":\n"
                + ".LFB" + lf + ":\n"
                + "\t.cfi_startproc\n"
                + "\tendbr64\n"
                + "\tpushq\t%rbp\n"
                + "\t.cfi_def_cfa_offset 16\n"
                + "\t.cfi_offset 6, -16\n"
                + "\tmovq\t%rsp, %rbp\n"
                + "\t.cfi_def_cfa_register 6\n"
                + "\tsubq\t$" + (ite * -1) + ", %rsp\n";
        for (Triplete triplete : tripletes) {
            s += triplete.asm();
        }
        s += "\tnop\n"
                + "\tleave\n"
                + "\t.cfi_def_cfa 7, 8\n"
                + "\tret\n"
                + "\t.cfi_endproc\n"
                + ".LFE" + lf + ":\n"
                + "\t.size\t" + nom + ", .-" + nom + "\n";
        return s;
    }

    public String mostrarMetodoAss(int lf, List<Triplete> trip, String str, int ite) {
        String nom = this.nombreMetodo();
        List<Triplete> tr = new ArrayList<>();
        tr.addAll(trip);
        tr.addAll(this.tripletes);
        if (!str.equals("")) {
            str = "\t.section\t.rodata\n" + str + "\t.text\n";
        }
        String s = str
                + "\t.globl\t" + nom + "\n"
                + "\t.type\t" + nom + ", @function\n"
                + nom + ":\n"
                + ".LFB" + lf + ":\n"
                + "\t.cfi_startproc\n"
                + "\tendbr64\n"
                + "\tpushq\t%rbp\n"
                + "\t.cfi_def_cfa_offset 16\n"
                + "\t.cfi_offset 6, -16\n"
                + "\tmovq\t%rsp, %rbp\n"
                + "\t.cfi_def_cfa_register 6\n"
                + "\tsubq\t$" + (ite * -1) + ", %rsp\n";
        for (Triplete triplete : tripletes) {
            s += triplete.asm();
        }
        s += "\tnop\n"
                + "\tleave\n"
                + "\t.cfi_def_cfa 7, 8\n"
                + "\tret\n"
                + "\t.cfi_endproc\n"
                + ".LFE" + lf + ":\n"
                + "\t.size\t" + nom + ", .-" + nom + "\n";
        return s;
    }

    public List<String> getFl() {
        return fl;
    }

}
