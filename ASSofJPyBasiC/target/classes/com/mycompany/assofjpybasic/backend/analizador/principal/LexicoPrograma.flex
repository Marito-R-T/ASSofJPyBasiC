package com.mycompany.assofjpybasic.backend.analizador.principal;

import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.List;

%%
%class LexicoPrograma
%type java_cup.runtime.Symbol
%cupsym SintaxisProgramaSym
%public
%cup
%full
%line
%column
espacio=[\r|\f|" "|\t|\n]+
letras=[a-zA-Z]
onenine=[1-9]
cero= "0"

%{
    StringBuffer string = new StringBuffer();
    
    private Symbol symbol(int type, Object value){
        System.out.println(value);
        return new Symbol(type, yyline, yycolumn, value);
    }
    
    private Symbol symbol(int type){
        System.out.println(type);
        return new Symbol(type, yyline, yycolumn);
    }
%}

%state STRING, JAVA, ST

%%
    /*Palabras para referenciar otros lenguajes*/
<YYINITIAL> ("#include \"JAVA.") {yybegin(JAVA); System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.java, yycolumn, yyline, yytext());}
<YYINITIAL> ("#include \"PY\"") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.py, yycolumn, yyline, yytext());}
<YYINITIAL> ("#include \"VB\"") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.vb, yycolumn, yyline, yytext());}
<YYINITIAL> ("JAVA") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.javaa, yycolumn, yyline, yytext());}
<YYINITIAL> ("PY") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.pyy, yycolumn, yyline, yytext());}
<YYINITIAL> ("VB") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.vbb, yycolumn, yyline, yytext());}
    /*Palabras para procesos*/
<YYINITIAL> ("void") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.voidd, yycolumn, yyline, yytext());}
<YYINITIAL> ("main") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.mainn, yycolumn, yyline, yytext());}
<YYINITIAL> ("#include") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.includee, yycolumn, yyline, yytext());}
    /*Palabras para Condicional*/
<YYINITIAL> ("&&") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.andd, yycolumn, yyline, yytext());}
<YYINITIAL> ("||") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.orr, yycolumn, yyline, yytext());}
<YYINITIAL> ("!") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.nott, yycolumn, yyline, yytext());}
    /*Palabras para Tipos*/
<YYINITIAL> ("const") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.constt, yycolumn, yyline, yytext());}
<YYINITIAL> ("int") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.intt, yycolumn, yyline, yytext());}
<YYINITIAL> ("float") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.floatt, yycolumn, yyline, yytext());}
<YYINITIAL> ("char") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.charr, yycolumn, yyline, yytext());}
<YYINITIAL> ("&") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.asig, yycolumn, yyline, yytext());}
    /*Palabras de Funciones*/
<YYINITIAL> ("if") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.iff, yycolumn, yyline, yytext());}
<YYINITIAL> ("else") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.elsee, yycolumn, yyline, yytext());}
<YYINITIAL> ("for") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.forr, yycolumn, yyline, yytext());}
<YYINITIAL> ("switch") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.switchh, yycolumn, yyline, yytext());}
<YYINITIAL> ("case") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.casee, yycolumn, yyline, yytext());}
<YYINITIAL> ("while") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.whilee, yycolumn, yyline, yytext());}
<YYINITIAL> ("default") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.defaultt, yycolumn, yyline, yytext());}
<YYINITIAL> ("break") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.breakk, yycolumn, yyline, yytext());}
<YYINITIAL> ("doo") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.doo, yycolumn, yyline, yytext());}
    /*Palabras de Comparacion*/
<YYINITIAL> ("!=") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.noigual, yycolumn, yyline, yytext());}
<YYINITIAL> ("<") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.menor, yycolumn, yyline, yytext());}
<YYINITIAL> ("<=") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.menorig, yycolumn, yyline, yytext());}
<YYINITIAL> (">") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.mayor, yycolumn, yyline, yytext());}
<YYINITIAL> (">=") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.mayorig, yycolumn, yyline, yytext());}
<YYINITIAL> ("==") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.igig, yycolumn, yyline, yytext());}
    /*Palabras de Operadores*/
<YYINITIAL> ("+") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.mas, yycolumn, yyline, yytext());}
<YYINITIAL> ("-") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.menos, yycolumn, yyline, yytext());}
<YYINITIAL> ("*") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.por, yycolumn, yyline, yytext());}
<YYINITIAL> ("/") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.div, yycolumn, yyline, yytext());}
<YYINITIAL> ("%") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.mod, yycolumn, yyline, yytext());}
    /*Palabras de agrupacion*/
<YYINITIAL> ("(") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.para, yycolumn, yyline, yytext());}
<YYINITIAL> (")") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.parc, yycolumn, yyline, yytext());}
<YYINITIAL> ("{") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.llavea, yycolumn, yyline, yytext());}
<YYINITIAL> ("}") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.llavec, yycolumn, yyline, yytext());}
<YYINITIAL> ("[") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.cora, yycolumn, yyline, yytext());}
<YYINITIAL> ("]") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.corc, yycolumn, yyline, yytext());}
<YYINITIAL> (",") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.coma, yycolumn, yyline, yytext());}
<YYINITIAL> (".") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.punto, yycolumn, yyline, yytext());}
<YYINITIAL> (";") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.puntocoma, yycolumn, yyline, yytext());}
<YYINITIAL> (":") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.dosp, yycolumn, yyline, yytext());}
    /*palabras para manejar consola*/
<YYINITIAL> ("printf") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.printf, yycolumn, yyline, yytext());}
<YYINITIAL> ("scanf") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.scanf, yycolumn, yyline, yytext());}
<YYINITIAL> ("clrscr()") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.clrs, yycolumn, yyline, yytext());}
<YYINITIAL> ("getch()") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.getch, yycolumn, yyline, yytext());}
   /*Operandos de asignacion*/
<YYINITIAL> ("=") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.igual, yycolumn, yyline, yytext());}
<YYINITIAL> ("++") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.masmas, yycolumn, yyline, yytext());}
<YYINITIAL> ("--") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.menosmenos, yycolumn, yyline, yytext());}

/* Expresiones Regulares */
<YYINITIAL> ("/*")(.|{espacio})*("*/") {System.out.print(yytext()); /*return new Symbol(SintaxisProgramaSym.com, yycolumn, yyline, yytext());*/}
<YYINITIAL> ("//")(.)*("\n") {System.out.print(yytext()); /*return new Symbol(SintaxisProgramaSym.com, yycolumn, yyline, yytext());*/}
<YYINITIAL> "<"{letras}({letras}|{onenine}|{cero}|"_")*(".h")">" {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.idlib, yycolumn, yyline, yytext());}
<YYINITIAL> {letras}({letras}|{onenine}|{cero}|"_")* {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.id, yycolumn, yyline, yytext());}
<YYINITIAL> ({onenine}({onenine}|{cero})*)|{cero} {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.entero, yycolumn, yyline, yytext());}
<YYINITIAL> (({onenine}({onenine}|{cero})*)|{cero})(".")({onenine}|{cero})*{onenine} {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.decimal, yycolumn, yyline, yytext());}
<YYINITIAL> ("'")(.)("'") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.character, yycolumn, yyline, yytext().substring(1, yytext().length() - 1));} // "char"c
<YYINITIAL> \" {yybegin(STRING); return new Symbol(SintaxisProgramaSym.comilla, yycolumn, yyline, yytext());}

/* Espacios en blanco */
<YYINITIAL> {espacio}+ {System.out.print(yytext()); /*IGNORAR*/}

<YYINITIAL> . {System.out.print(yytext());/*error*/}

<JAVA> {
    <YYINITIAL> ("*") {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.por, yycolumn, yyline, yytext());}
    {letras}({letras}|{onenine}|{cero}|"_")* {System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.id, yycolumn, yyline, yytext());}
    \"                              { yybegin(YYINITIAL);
                                        return new Symbol(SintaxisProgramaSym.comilla, yycolumn, yyline, yytext()); }
}

<STRING> {
      \"                             { yybegin(YYINITIAL);
                                        return new Symbol(SintaxisProgramaSym.comilla, yycolumn, yyline, yytext());}
    "%d"|"%c"|"%f"                   {return new Symbol(SintaxisProgramaSym.string, yycolumn, yyline, yytext());}
      [^]                           {string.append(yytext()); yybegin(ST);}
}

<ST> {
      \"                             { yybegin(STRING); String s = string.toString(); string.setLength(0);
                                        this.yypushback(1);
                                        return new Symbol(SintaxisProgramaSym.string, yycolumn, yyline, s);}
    "%d"|"%c"|"%f"                   { yybegin(STRING); String s = string.toString(); string.setLength(0);
                                        this.yypushback(2);
                                        return new Symbol(SintaxisProgramaSym.string, yycolumn, yyline, s);}
    .                                {string.append(yytext());}
}