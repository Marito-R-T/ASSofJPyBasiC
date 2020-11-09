/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.visual;

import com.mycompany.assofjpybasic.backend.semantica.programa.OperacionPrograma;
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

/**
 * Clase como representasión del metodo que ingresa el usuario de Visual Basic
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class MetodoVisual {

    private final String id;
    private final String TIPO;
    private final List<VariableVisual> parametros;
    private VariableVisual visual;
    private final List<Triplete> tripletes = new ArrayList<>();

    /**
     *
     *
     * @param id Id del metodo
     * @param parametros lista de parametros del metodo
     * @param tipo Tipo del retorno del metodo
     */
    public MetodoVisual(String id, List<VariableVisual> parametros, String tipo) {
        this.id = id.toLowerCase();
        this.parametros = parametros;
        this.TIPO = tipo;
    }

    /**
     * Metodo para verificar si ya existe este Metodo
     *
     * @param var el metodo con el que se comparara este metodo
     * @return true si es igual, false si no lo es
     */
    public boolean isnotEquals(MetodoVisual var) {
        return !this.id.equals(var.getId()) || !this.TIPO.equals(var.getTIPO()) || !MetodoVisual.sonMismosParametros(this.parametros, var.getParametros());
    }

    /**
     * Metodo para ver si el array1 es igual al array2
     *
     * @param parametros1 Parametros del primer metodo
     * @param parametros2 Parametros del segundo metodo
     * @return true Si son los mismos, false si no lo son
     */
    public static final boolean sonMismosParametros(List<VariableVisual> parametros1, List<VariableVisual> parametros2) {
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

    public List<VariableVisual> getParametros() {
        return parametros;
    }

    public String getTIPO() {
        return TIPO;
    }

    public String getId() {
        return id;
    }

    public VariableVisual getVisual() {
        return visual;
    }

    public void setVisual(VariableVisual visual) {
        this.visual = visual;
    }

    /**
     * Metodo para verificar similitud de metodos con el actual
     *
     * @param id Id del metodo a comparar
     * @param params Parametros del metodo a comparar
     * @return True si son iguales los metodos, False si no son iguales los
     * metodos
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
     * Metodo para verificar similitud de metodos con el actual
     *
     * @param id Id del metodo a comparar
     * @param params Parametros del metodo a comparar
     * @return True si son iguales los metodos, False si no son iguales los
     * metodos
     */
    public boolean equals(List<OperacionVisual> params, String id) {
        if (id.equals(this.id) && params.size() == this.parametros.size()) {
            for (int i = 0; i < params.size(); i++) {
                System.out.println(parametros.get(i).getTipo());
                System.out.println(params.get(i).getTipo());
                if (!this.parametros.get(i).getTipo().contains(params.get(i).getTipo())) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo para evaluar que sean los mismos tipos, así poder usar el metodo
     *
     * @param tipo1 Tipo del parametro del metodo Python
     * @param tipo2 Tipo del parametro enviado
     * @return True si tienen el mismo tipo de parametro con el metodo
     */
    private boolean isMismoTipo(String tipo1, Integer tipo2) {
        if (tipo1.equals(VisualSemantica.FLOAT) && tipo2 <= 3) {
            return true;
        } else if (tipo1.equals(VisualSemantica.INT) && tipo2 <= 2) {
            return true;
        } else {
            return tipo1.equals(VisualSemantica.CHAR) && tipo2 == 1;
        }
    }

    public List<Triplete> getTripletes() {
        return tripletes;
    }

    public String nombreMetodo() {
        String params = "VB_";
        params += this.id;
        for (VariableVisual parametro : this.parametros) {
            params += "_" + OperacionVisual.obtenerTipo(parametro.getTipo());
        }
        return params;
    }

    public String mostrarMetodo() {
        String com = "//Metodo de VISUAL BASIC con id: " + this.id + "\n";
        String params = "VB_";
        params += this.id;
        for (VariableVisual parametro : this.parametros) {
            params += "_" + OperacionVisual.obtenerTipo(parametro.getTipo());
        }
        params += "()";
        String metodo = "{\n";
        for (Triplete triplete : tripletes) {
            metodo += triplete.devolverString() + "\n";
        }
        metodo += "}\n";
        return com + params + metodo;
    }

    public String mostrarMetodoE() {
        String com = "//Metodo de VISUAL BASIC con id: " + this.id + "\n";
        String params = "void VB_";
        params += this.id;
        for (VariableVisual parametro : this.parametros) {
            params += "_" + OperacionVisual.obtenerTipo(parametro.getTipo());
        }
        params += "()";
        String metodo = "{\n";
        for (Triplete triplete : tripletes) {
            metodo += triplete.devolverStringE() + "\n";
        }
        metodo += "}\n";
        return com + params + metodo;
    }

    public List<Triplete> verMetodo(Integer pos, List<OperacionVisual> params) {
        if (pos != null) {
            List<Triplete> tri = new ArrayList<>();
            for (int i = 0; i < params.size(); i++) {
                tri.addAll(params.get(i).mostrarTripletes());
                SumOperator op1 = new SumOperator(null, new P(), new TerminalOperator((pos + i + 1) + ""), "int");
                tri.add(op1);
                tri.add(new AsignarValor(null, new Stack(op1), params.get(i).triplete));
            }
            SumOperator op2 = new SumOperator(null, new P(), new TerminalOperator(pos.toString()), "int");
            tri.add(op2);
            tri.add(new AsignarValor(null, new P(), op2));
            tri.add(new CallMetodo(this.nombreMetodo()));
            RestOperator op3 = new RestOperator(null, new P(), new TerminalOperator(pos.toString()), "int");
            tri.add(op3);
            tri.add(new AsignarValor(null, new P(), op3));
            return tri;
        } else {
            return new ArrayList<>();
        }
    }

    public List<Triplete> verMetodo(List<OperacionPrograma> params, Integer pos) {
        if (pos != null) {
            List<Triplete> tri = new ArrayList<>();
            for (int i = 0; i < params.size(); i++) {
                tri.addAll(params.get(i).mostrarTripletes());
                SumOperator op1 = new SumOperator(null, new P(), new TerminalOperator((pos + i + 1) + ""), "int");
                tri.add(op1);
                tri.add(new AsignarValor(null, new Stack(op1), params.get(i).getTriplete()));
            }
            SumOperator op2 = new SumOperator(null, new P(), new TerminalOperator(pos.toString()), "int");
            tri.add(op2);
            tri.add(new AsignarValor(null, new P(), op2));
            tri.add(new CallMetodo(this.nombreMetodo()));
            RestOperator op3 = new RestOperator(null, new P(), new TerminalOperator(pos.toString()), "int");
            tri.add(op3);
            tri.add(new AsignarValor(null, new P(), op3));
            return tri;
        } else {
            return new ArrayList<>();
        }
    }

    public String mostrarMetodoAss(int lf) {
        String nom = this.nombreMetodo();
        String s = "    .globl  " + nom + "\n"
                + "     .type   " + nom + ", @function\n"
                + nom + "\n"
                + ".LFB" + lf + ":\n"
                + "	.cfi_startproc\n"
                + "	endbr64\n"
                + "	pushq	%rbp\n"
                + "	.cfi_def_cfa_offset 16\n"
                + "	.cfi_offset 6, -16\n"
                + "	movq	%rsp, %rbp\n"
                + "	.cfi_def_cfa_register 6\n";
        for (Triplete triplete : tripletes) {
            s += triplete.asm();
        }
        s += "  "
                + "nop\n"
                + "	popq	%rbp\n"
                + "	.cfi_def_cfa 7, 8\n"
                + "	ret\n"
                + "	.cfi_endproc\n"
                + ".LFE" + lf + ":\n"
                + "	.size	" + nom + ", .-" + nom + "\n"
                + "	.section	.rodata\n";
        return s;
    }

}
