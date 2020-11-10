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

import com.mycompany.assofjpybasic.backend.semantica.java.TablaJava;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AritmeticaOperator;
import com.mycompany.assofjpybasic.backend.semantica.programa.cod3.AsignarTemporal;
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
        s += this.finalizar();
        return s;
    }

    public String Python() {
        String s = "";
        for (MetodoPython metodoPython : this.metodosPython) {
            int pos = -4;
            for (int i = metodoPython.getTrip().size() - 1; i >= 0; i--) {
                Triplete trip = metodoPython.getTrip().get(i);
                if (trip instanceof AritmeticaOperator || trip instanceof AsignarTemporal) {
                    trip.setPos(pos + "");
                    pos -= 4;
                }
            }
            s += "\n";
            s += metodoPython.mostrarMetodoAss(lf);
            lf++;
        }
        return s;
    }

    public String Visual() {
        String s = "";
        for (MetodoVisual metodoVisual : this.metodosVisual) {
            int pos = -4;
            for (int i = metodoVisual.getTripletes().size() - 1; i >= 0; i--) {
                Triplete trip = metodoVisual.getTripletes().get(i);
                if (trip instanceof AritmeticaOperator || trip instanceof AsignarTemporal) {
                    trip.setPos(pos + "");
                    pos -= 4;
                }
            }
            s += "\n";
            s += metodoVisual.mostrarMetodoAss(lf);
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
        for (int i = this.main.size() - 1; i >= 0; i--) {
            Triplete tr = this.main.get(i);
            if (tr instanceof AritmeticaOperator || tr instanceof AsignarTemporal) {
                tr.setPos(ite + "");
                ite -= 4;
            }
        }
        s += "	.globl	main\n"
                + "	.type	main, @function\n"
                + "main:\n";
        s += ".LFB" + lf + ":\n	"
                + "\t.cfi_startproc\n"
                + "	endbr64\n"
                + "	pushq	%rbp\n"
                + "	.cfi_def_cfa_offset 16\n"
                + "	.cfi_offset 6, -16\n"
                + "	movq	%rsp, %rbp\n"
                + "	.cfi_def_cfa_register 6\n";
        for (Triplete triplete : this.main) {
            s += triplete.asm();
        }
        s += "\tleave\n"
                + "	.cfi_def_cfa 7, 8\n"
                + "	ret\n"
                + "	.cfi_endproc\n"
                + ".LFE9:\n"
                + "	.size	main, .-main";
        return s;
    }

    public List<Triplete> getMain() {
        return main;
    }

    public String principio() {
        return "	.file	\"programa.c\"\n"
                + "	.text\n"
                + "	.globl	p\n"
                + "	.bss\n"
                + "	.align 4\n"
                + "	.type	p, @object\n"
                + "	.size	p, 4\n"
                + "p:\n"
                + "	.zero	4\n"
                + "	.globl	h\n"
                + "	.align 4\n"
                + "	.type	h, @object\n"
                + "	.size	h, 4\n"
                + "h:\n"
                + "	.zero	4\n"
                + "	.comm	stack,40000,32\n"
                + "	.comm	heap,2000,32\n"
                + "	.section	.rodata\n"
                + ".LC0:\n"
                + "	.string	\"tcsetattr()\"\n"
                + ".LC1:\n"
                + "	.string	\"tcsetattr ICANON\"\n"
                + ".LC2:\n"
                + "	.string	\"read()\"\n"
                + ".LC3:\n"
                + "	.string	\"tcsetattr ~ICANON\"\n"
                + ".LC4:\n"
                + "	.string	\"%c\\n\"\n"
                + "	.text\n"
                + "	.globl	getch\n"
                + "	.type	getch, @function\n"
                + "getch:\n"
                + ".LFB6:\n"
                + "	.cfi_startproc\n"
                + "	endbr64\n"
                + "	pushq	%rbp\n"
                + "	.cfi_def_cfa_offset 16\n"
                + "	.cfi_offset 6, -16\n"
                + "	movq	%rsp, %rbp\n"
                + "	.cfi_def_cfa_register 6\n"
                + "	subq	$96, %rsp\n"
                + "	movq	%fs:40, %rax\n"
                + "	movq	%rax, -8(%rbp)\n"
                + "	xorl	%eax, %eax\n"
                + "	movb	$0, -81(%rbp)\n"
                + "	movq	$0, -80(%rbp)\n"
                + "	movq	$0, -72(%rbp)\n"
                + "	movq	$0, -64(%rbp)\n"
                + "	movq	$0, -56(%rbp)\n"
                + "	movq	$0, -48(%rbp)\n"
                + "	movq	$0, -40(%rbp)\n"
                + "	movq	$0, -32(%rbp)\n"
                + "	movl	$0, -24(%rbp)\n"
                + "	movq	stdout(%rip), %rax\n"
                + "	movq	%rax, %rdi\n"
                + "	call	fflush@PLT\n"
                + "	leaq	-80(%rbp), %rax\n"
                + "	movq	%rax, %rsi\n"
                + "	movl	$0, %edi\n"
                + "	call	tcgetattr@PLT\n"
                + "	testl	%eax, %eax\n"
                + "	jns	.L2\n"
                + "	leaq	.LC0(%rip), %rdi\n"
                + "	call	perror@PLT\n"
                + ".L2:\n"
                + "	movl	-68(%rbp), %eax\n"
                + "	andl	$-3, %eax\n"
                + "	movl	%eax, -68(%rbp)\n"
                + "	movl	-68(%rbp), %eax\n"
                + "	andl	$-9, %eax\n"
                + "	movl	%eax, -68(%rbp)\n"
                + "	movb	$1, -57(%rbp)\n"
                + "	movb	$0, -58(%rbp)\n"
                + "	leaq	-80(%rbp), %rax\n"
                + "	movq	%rax, %rdx\n"
                + "	movl	$0, %esi\n"
                + "	movl	$0, %edi\n"
                + "	call	tcsetattr@PLT\n"
                + "	testl	%eax, %eax\n"
                + "	jns	.L3\n"
                + "	leaq	.LC1(%rip), %rdi\n"
                + "	call	perror@PLT\n"
                + ".L3:\n"
                + "	leaq	-81(%rbp), %rax\n"
                + "	movl	$1, %edx\n"
                + "	movq	%rax, %rsi\n"
                + "	movl	$0, %edi\n"
                + "	call	read@PLT\n"
                + "	testq	%rax, %rax\n"
                + "	jns	.L4\n"
                + "	leaq	.LC2(%rip), %rdi\n"
                + "	call	perror@PLT\n"
                + ".L4:\n"
                + "	movl	-68(%rbp), %eax\n"
                + "	orl	$2, %eax\n"
                + "	movl	%eax, -68(%rbp)\n"
                + "	movl	-68(%rbp), %eax\n"
                + "	orl	$8, %eax\n"
                + "	movl	%eax, -68(%rbp)\n"
                + "	leaq	-80(%rbp), %rax\n"
                + "	movq	%rax, %rdx\n"
                + "	movl	$1, %esi\n"
                + "	movl	$0, %edi\n"
                + "	call	tcsetattr@PLT\n"
                + "	testl	%eax, %eax\n"
                + "	jns	.L5\n"
                + "	leaq	.LC3(%rip), %rdi\n"
                + "	call	perror@PLT\n"
                + ".L5:\n"
                + "	movzbl	-81(%rbp), %eax\n"
                + "	movsbl	%al, %eax\n"
                + "	movl	%eax, %esi\n"
                + "	leaq	.LC4(%rip), %rdi\n"
                + "	movl	$0, %eax\n"
                + "	call	printf@PLT\n"
                + "	movzbl	-81(%rbp), %eax\n"
                + "	movq	-8(%rbp), %rcx\n"
                + "	xorq	%fs:40, %rcx\n"
                + "	je	.L7\n"
                + "	call	__stack_chk_fail@PLT\n"
                + ".L7:\n"
                + "	leave\n"
                + "	.cfi_def_cfa 7, 8\n"
                + "	ret\n"
                + "	.cfi_endproc\n"
                + ".LFE6:\n"
                + "	.size	getch, .-getch\n"
                + "	.section	.rodata\n"
                + ".LC5:\n"
                + "	.string	\"clear\"\n"
                + "	.text";
    }

    private String finalizar() {
        return "	.ident	\"GCC: (Ubuntu 9.3.0-17ubuntu1~20.04) 9.3.0\"\n"
                + "	.section	.note.GNU-stack,\"\",@progbits\n"
                + "	.section	.note.gnu.property,\"a\"\n"
                + "	.align 8\n"
                + "	.long	 1f - 0f\n"
                + "	.long	 4f - 1f\n"
                + "	.long	 5\n"
                + "0:\n"
                + "	.string	 \"GNU\"\n";
    }

}
