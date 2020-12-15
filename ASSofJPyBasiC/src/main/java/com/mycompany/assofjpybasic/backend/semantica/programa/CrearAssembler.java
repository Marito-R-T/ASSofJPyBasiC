/*
 * Copyright (C) 2020 Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.mycompany.assofjpybasic.backend.semantica.programa;

import com.mycompany.assofjpybasic.backend.semantica.java.MetodoJava;
import com.mycompany.assofjpybasic.backend.semantica.java.TablaJava;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AritmeticaOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AsignarTemporal;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Clrs;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Printf;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.Triplete;
import com.mycompany.assofjpybasic.backend.semantica.python.MetodoPython;
import com.mycompany.assofjpybasic.backend.semantica.visual.MetodoVisual;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario Tobar <marioramirez201830007 at cunoc.edu.gt>
 */
public class CrearAssembler {

    private List<MetodoVisual> metodosVisual = new ArrayList<>();
    private List<MetodoPython> metodosPython = new ArrayList<>();
    private List<TablaJava> clasesJava = new ArrayList<>();
    private List<Triplete> main = new ArrayList<>();
    private Integer lf = 7;
    private List<String> fl = new ArrayList<>();

    public List<MetodoVisual> getMetodosVisual() {
        return metodosVisual;
    }

    public List<MetodoPython> getMetodosPython() {
        return metodosPython;
    }

    public List<TablaJava> getClasesJava() {
        return clasesJava;
    }

    public String getAssembler() {
        String s = "";
        s += this.principio();
        s += this.Python();
        s += this.Visual();
        s += this.importadas();
        s += this.main();
        s += this.floats();
        s += this.finalizar();
        return s;
    }

    public String Python() {
        String s = "";
        for (MetodoPython metodoPython : this.metodosPython) {
            int pos = -4;
            String tr = "";
            for (int i = metodoPython.getTrip().size() - 1; i >= 0; i--) {
                Triplete trip = metodoPython.getTrip().get(i);
                if (trip instanceof AritmeticaOperator || trip instanceof AsignarTemporal) {
                    trip.setPos(pos + "");
                    pos -= 4;
                } else if (trip instanceof Printf) {
                    String lc = ".LC" + Triplete.FLOAT;
                    Triplete.FLOAT++;
                    ((Printf) trip).setEt(lc);
                    if (((Printf) trip).getValor() == null) {
                        tr += lc + ":\n"
                                + "\t.string \"" + ((Printf) trip).getTipo() + "\"\n";
                    } else {
                        tr += lc + ":\n"
                                + "\t.string \"" + ((Printf) trip).getValor() + "\"\n";
                    }
                } else if (trip instanceof Clrs) {
                    String lc = ".LC" + Triplete.FLOAT;
                    Triplete.FLOAT++;
                    ((Clrs) trip).setEt(lc);
                    tr += lc + ":\n"
                            + "\t.string \"clear\"\n";
                }
            }
            s += metodoPython.mostrarMetodoAss(lf, tr, pos);
            lf++;
        }
        return s;
    }

    public String Visual() {
        String s = "";
        for (MetodoVisual metodoVisual : this.metodosVisual) {
            int pos = -4;
            String tr = "";
            for (int i = metodoVisual.getTripletes().size() - 1; i >= 0; i--) {
                Triplete trip = metodoVisual.getTripletes().get(i);
                if (trip instanceof AritmeticaOperator || trip instanceof AsignarTemporal) {
                    trip.setPos(pos + "");
                    pos -= 4;
                } else if (trip instanceof Printf) {
                    String lc = ".LC" + Triplete.FLOAT;
                    Triplete.FLOAT++;
                    ((Printf) trip).setEt(lc);
                    if (((Printf) trip).getValor() == null) {
                        tr += lc + ":\n"
                                + "\t.string \"" + ((Printf) trip).getTipo() + "\"\n";
                    } else {
                        tr += lc + ":\n"
                                + "\t.string \"" + ((Printf) trip).getValor() + "\"\n";
                    }
                } else if (trip instanceof Clrs) {
                    String lc = ".LC" + Triplete.FLOAT;
                    Triplete.FLOAT++;
                    ((Clrs) trip).setEt(lc);
                    tr += lc + ":\n"
                            + "\t.string \"clear\"\n";
                }
            }
            s += metodoVisual.mostrarMetodoAss(lf, tr, pos);
            lf++;
        }
        return s;
    }

    public String importadas() {
        String s = "";
        for (TablaJava clasesImportada : this.clasesJava) {
            s += clasesImportada.mostrarClaseAss(lf);
            lf = clasesImportada.getNum();
        }
        return s;
    }

    public String main() {
        String s = "";
        int ite = - 4;
        String str = "";
        for (int i = this.main.size() - 1; i >= 0; i--) {
            Triplete tr = this.main.get(i);
            if (tr instanceof AritmeticaOperator || tr instanceof AsignarTemporal) {
                tr.setPos(ite + "");
                ite -= 4;
            } else if (tr instanceof Printf) {
                String lc = ".LC" + Triplete.FLOAT;
                Triplete.FLOAT++;
                ((Printf) tr).setEt(lc);
                if (((Printf) tr).getValor() == null) {
                    str += lc + ":\n"
                            + "\t.string \"" + ((Printf) tr).getTipo() + "\"\n";
                } else {
                    str += lc + ":\n"
                            + "\t.string \"" + ((Printf) tr).getValor() + "\"\n";
                }
            } else if (tr instanceof Clrs) {
                String lc = ".LC" + Triplete.FLOAT;
                Triplete.FLOAT++;
                ((Clrs) tr).setEt(lc);
                str += lc + ":\n"
                        + "\t.string \"clear\"\n";
            }
        }
        if (!str.equals("")) {
            str = "\t.section\t.rodata\n" + str + "\t.text\n";
        }
        ite -= 8;
        s += str
                + "\t.globl\tmain\n"
                + "\t.type\tmain, @function\n"
                + "main:\n";
        s += ".LFB" + lf + ":\n"
                + "\t.cfi_startproc\n"
                + "\tendbr64\n"
                + "\tpushq\t%rbp\n"
                + "\t.cfi_def_cfa_offset 16\n"
                + "\t.cfi_offset 6, -16\n"
                + "\tmovq\t%rsp, %rbp\n"
                + "\t.cfi_def_cfa_register 6\n"
                + "\tsubq\t$" + (ite * -1) + ", %rsp\n";
        for (Triplete triplete : this.main) {
            s += triplete.asm();
        }
        s += "\tmovl\t$0, %eax\n"
                + "\tleave\n"
                + "\t.cfi_def_cfa 7, 8\n"
                + "\tret\n"
                + "\t.cfi_endproc\n"
                + ".LFE" + lf + ":\n"
                + "\t.size\tmain, .-main\n"
                + "\t.section\t.rodata\n";
        return s;
    }

    public List<Triplete> getMain() {
        return main;
    }

    public String principio() {
        return "\t.file\t\"programa.c\"\n"
                + "\t.text\n"
                + "\t.globl\tp\n"
                + "\t.bss\n"
                + "\t.align 4\n"
                + "\t.type\tp, @object\n"
                + "\t.size\tp, 4\n"
                + "p:\n"
                + "\t.zero\t4\n"
                + "\t.globl\th\n"
                + "\t.align 4\n"
                + "\t.type\th, @object\n"
                + "\t.size\th, 4\n"
                + "h:\n"
                + "\t.zero\t4\n"
                + "\t.comm\tstack,40000,32\n"
                + "\t.comm\theap,2000,32\n"
                + "\t.section\t.rodata\n"
                + ".LC0:\n"
                + "\t.string\t\"tcsetattr()\"\n"
                + ".LC1:\n"
                + "\t.string\t\"tcsetattr ICANON\"\n"
                + ".LC2:\n"
                + "\t.string\t\"read()\"\n"
                + ".LC3:\n"
                + "\t.string\t\"tcsetattr ~ICANON\"\n"
                + ".LC4:\n"
                + "\t.string\t\"%c\\n\"\n"
                + ".LC5:\n"
                + "\t.string\t\"%f\"\n"
                + "\t.text\n"
                + "\t.globl\tgetch\n"
                + "\t.type\tgetch, @function\n"
                + "getch:\n"
                + ".LFB6:\n"
                + "\t.cfi_startproc\n"
                + "\tendbr64\n"
                + "\tpushq\t%rbp\n"
                + "\t.cfi_def_cfa_offset 16\n"
                + "\t.cfi_offset 6, -16\n"
                + "\tmovq\t%rsp, %rbp\n"
                + "\t.cfi_def_cfa_register 6\n"
                + "\tsubq\t$96, %rsp\n"
                + "\tmovq\t%fs:40, %rax\n"
                + "\tmovq\t%rax, -8(%rbp)\n"
                + "\txorl\t%eax, %eax\n"
                + "\tmovb\t$0, -81(%rbp)\n"
                + "\tmovq\t$0, -80(%rbp)\n"
                + "\tmovq\t$0, -72(%rbp)\n"
                + "\tmovq\t$0, -64(%rbp)\n"
                + "\tmovq\t$0, -56(%rbp)\n"
                + "\tmovq\t$0, -48(%rbp)\n"
                + "\tmovq\t$0, -40(%rbp)\n"
                + "\tmovq\t$0, -32(%rbp)\n"
                + "\tmovl\t$0, -24(%rbp)\n"
                + "\tmovq\tstdout(%rip), %rax\n"
                + "\tmovq\t%rax, %rdi\n"
                + "\tcall\tfflush@PLT\n"
                + "\tleaq\t-80(%rbp), %rax\n"
                + "\tmovq\t%rax, %rsi\n"
                + "\tmovl\t$0, %edi\n"
                + "\tcall\ttcgetattr@PLT\n"
                + "\ttestl\t%eax, %eax\n"
                + "\tjns\t.L2\n"
                + "\tleaq\t.LC0(%rip), %rdi\n"
                + "\tcall\tperror@PLT\n"
                + ".L2:\n"
                + "\tmovl\t-68(%rbp), %eax\n"
                + "\tandl\t$-3, %eax\n"
                + "\tmovl\t%eax, -68(%rbp)\n"
                + "\tmovl\t-68(%rbp), %eax\n"
                + "\tandl\t$-9, %eax\n"
                + "\tmovl\t%eax, -68(%rbp)\n"
                + "\tmovb\t$1, -57(%rbp)\n"
                + "\tmovb\t$0, -58(%rbp)\n"
                + "\tleaq\t-80(%rbp), %rax\n"
                + "\tmovq\t%rax, %rdx\n"
                + "\tmovl\t$0, %esi\n"
                + "\tmovl\t$0, %edi\n"
                + "\tcall\ttcsetattr@PLT\n"
                + "\ttestl\t%eax, %eax\n"
                + "\tjns\t.L3\n"
                + "\tleaq\t.LC1(%rip), %rdi\n"
                + "\tcall\tperror@PLT\n"
                + ".L3:\n"
                + "\tleaq\t-81(%rbp), %rax\n"
                + "\tmovl\t$1, %edx\n"
                + "\tmovq\t%rax, %rsi\n"
                + "\tmovl\t$0, %edi\n"
                + "\tcall\tread@PLT\n"
                + "\ttestq\t%rax, %rax\n"
                + "\tjns\t.L4\n"
                + "\tleaq\t.LC2(%rip), %rdi\n"
                + "\tcall\tperror@PLT\n"
                + ".L4:\n"
                + "\tmovl\t-68(%rbp), %eax\n"
                + "\torl\t$2, %eax\n"
                + "\tmovl\t%eax, -68(%rbp)\n"
                + "\tmovl\t-68(%rbp), %eax\n"
                + "\torl\t$8, %eax\n"
                + "\tmovl\t%eax, -68(%rbp)\n"
                + "\tleaq\t-80(%rbp), %rax\n"
                + "\tmovq\t%rax, %rdx\n"
                + "\tmovl\t$1, %esi\n"
                + "\tmovl\t$0, %edi\n"
                + "\tcall\ttcsetattr@PLT\n"
                + "\ttestl\t%eax, %eax\n"
                + "\tjns\t.L5\n"
                + "\tleaq\t.LC3(%rip), %rdi\n"
                + "\tcall\tperror@PLT\n"
                + ".L5:\n"
                + "\tmovzbl\t-81(%rbp), %eax\n"
                + "\tmovsbl\t%al, %eax\n"
                + "\tmovl\t%eax, %esi\n"
                + "\tleaq\t.LC4(%rip), %rdi\n"
                + "\tmovl\t$0, %eax\n"
                + "\tcall\tprintf@PLT\n"
                + "\tmovzbl\t-81(%rbp), %eax\n"
                + "\tmovq\t-8(%rbp), %rcx\n"
                + "\txorq\t%fs:40, %rcx\n"
                + "\tje	.L7\n"
                + "\tcall\t__stack_chk_fail@PLT\n"
                + ".L7:\n"
                + "\tleave\n"
                + "\t.cfi_def_cfa 7, 8\n"
                + "\tret\n"
                + "\t.cfi_endproc\n"
                + ".LFE6:\n"
                + "\t.size\tgetch, .-getch\n";
    }

    private String finalizar() {
        return "\t.ident\t\"GCC: (Ubuntu 9.3.0-17ubuntu1~20.04) 9.3.0\"\n"
                + "\t.section\t.note.GNU-stack,\"\",@progbits\n"
                + "\t.section\t.note.gnu.property,\"a\"\n"
                + "\t.align 8\n"
                + "\t.long\t1f - 0f\n"
                + "\t.long\t4f - 1f\n"
                + "\t.long\t5\n"
                + "0:\n"
                + "\t.string\t\"GNU\"\n"
                + "1:\n"
                + "\t.align 8\n"
                + "\t.long\t0xc0000002\n"
                + "\t.long\t3f - 2f\n"
                + "2:\n"
                + "\t.long\t0x3\n"
                + "3:\n"
                + "\t.align 8\n"
                + "4:\n";
    }

    private String floats() {
        String s = "";
        for (MetodoPython metodoPython : this.metodosPython) {
            for (String string : metodoPython.getFl()) {
                s += string + "\n";
            }
        }
        for (MetodoVisual metodoVisual : this.metodosVisual) {
            for (String string : metodoVisual.getFl()) {
                s += string + "\n";
            }
        }
        for (TablaJava tablaJava : this.clasesJava) {
            for (MetodoJava metodo : tablaJava.getConstructores()) {
                for (String string : metodo.getFl()) {
                    s += string + "\n";
                }
            }
            for (MetodoJava metodo : tablaJava.getMetodos()) {
                for (String string : metodo.getFl()) {
                    s += string + "\n";
                }
            }
        }
        for (String string : fl) {
            s += string + "\n";
        }
        return s;
    }

    public List<String> getFl() {
        return fl;
    }

    public void setFl(List<String> fl) {
        this.fl = fl;
    }

}
