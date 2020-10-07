package com.mycompany.assofjpybasic.backend.analizador.java;

import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.List;

%%
%class LexicoJava
%type java_cup.runtime.Symbol
%cupsym SintaxisJavaSym
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

%state STRING

%%

    /*Palabras para procesos*/
<YYINITIAL> ("public") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.publicc, yycolumn, yyline, yytext());}
<YYINITIAL> ("class") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.classs, yycolumn, yyline, yytext());}
<YYINITIAL> ("void") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.voidd, yycolumn, yyline, yytext());}
<YYINITIAL> ("this") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.thiss, yycolumn, yyline, yytext());}
<YYINITIAL> ("return") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.returnn, yycolumn, yyline, yytext());}
    /*Palabras para Tipos*/
<YYINITIAL> ("int") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.intt, yycolumn, yyline, yytext());}
<YYINITIAL> ("float") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.floatt, yycolumn, yyline, yytext());}
<YYINITIAL> ("char") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.charr, yycolumn, yyline, yytext());}
    /*Palabras para Condicional*/
<YYINITIAL> ("&&") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.andd, yycolumn, yyline, yytext());}
<YYINITIAL> ("||") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.orr, yycolumn, yyline, yytext());}
<YYINITIAL> ("!") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.nott, yycolumn, yyline, yytext());}
    /*Palabras de Funciones*/
<YYINITIAL> ("if") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.iff, yycolumn, yyline, yytext());}
<YYINITIAL> ("else") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.elsee, yycolumn, yyline, yytext());}
<YYINITIAL> ("for") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.forr, yycolumn, yyline, yytext());}
<YYINITIAL> ("switch") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.switchh, yycolumn, yyline, yytext());}
<YYINITIAL> ("case") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.casee, yycolumn, yyline, yytext());}
<YYINITIAL> ("while") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.whilee, yycolumn, yyline, yytext());}
<YYINITIAL> ("default") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.defaultt, yycolumn, yyline, yytext());}
<YYINITIAL> ("breakk") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.breakk, yycolumn, yyline, yytext());}
<YYINITIAL> ("doo") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.doo, yycolumn, yyline, yytext());}
    /*Palabras de Comparacion*/
<YYINITIAL> ("!=") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.noigual, yycolumn, yyline, yytext());}
<YYINITIAL> ("<") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.menor, yycolumn, yyline, yytext());}
<YYINITIAL> ("<=") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.menorig, yycolumn, yyline, yytext());}
<YYINITIAL> (">") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.mayor, yycolumn, yyline, yytext());}
<YYINITIAL> (">=") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.mayorig, yycolumn, yyline, yytext());}
<YYINITIAL> ("==") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.igig, yycolumn, yyline, yytext());}
    /*Palabras de Operadores*/
<YYINITIAL> ("+") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.mas, yycolumn, yyline, yytext());}
<YYINITIAL> ("-") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.menos, yycolumn, yyline, yytext());}
<YYINITIAL> ("*") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.por, yycolumn, yyline, yytext());}
<YYINITIAL> ("/") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.div, yycolumn, yyline, yytext());}
<YYINITIAL> ("%") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.mod, yycolumn, yyline, yytext());}
    /*Palabras de agrupacion*/
<YYINITIAL> ("(") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.para, yycolumn, yyline, yytext());}
<YYINITIAL> (")") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.parc, yycolumn, yyline, yytext());}
<YYINITIAL> ("{") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.llavea, yycolumn, yyline, yytext());}
<YYINITIAL> ("}") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.llavec, yycolumn, yyline, yytext());}
<YYINITIAL> (",") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.coma, yycolumn, yyline, yytext());}
<YYINITIAL> (";") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.puntocoma, yycolumn, yyline, yytext());}
<YYINITIAL> (".") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.punto, yycolumn, yyline, yytext());}
<YYINITIAL> (":") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.dosp, yycolumn, yyline, yytext());}
    /*palabras para manejar consola*/
<YYINITIAL> ("System.out.println") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.println, yycolumn, yyline, yytext());}
<YYINITIAL> ("System.out.print") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.print, yycolumn, yyline, yytext());}
<YYINITIAL> ("charinput") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.charinput, yycolumn, yyline, yytext());}
<YYINITIAL> ("intinput") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.intinput, yycolumn, yyline, yytext());}
<YYINITIAL> ("floatinput") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.floatinput, yycolumn, yyline, yytext());}
    /*Operandos de asignacion*/
<YYINITIAL> ("=") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.igual, yycolumn, yyline, yytext());}
<YYINITIAL> ("++") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.masmas, yycolumn, yyline, yytext());}
<YYINITIAL> ("--") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.menosmenos, yycolumn, yyline, yytext());}

/* Expresiones Regulares */
<YYINITIAL> ("/*")(.|{espacio})*("*/") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.com, yycolumn, yyline, yytext());}
<YYINITIAL> ("//")(.)*("\n") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.com, yycolumn, yyline, yytext());}
<YYINITIAL> {letras}({letras}|{onenine}|{cero}|"_")* {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.id, yycolumn, yyline, yytext());}
<YYINITIAL> ({onenine}({onenine}|{cero})*)|{cero} {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.entero, yycolumn, yyline, yytext());}
<YYINITIAL> (({onenine}({onenine}|{cero})*)|{cero})(".")({onenine}|{cero})*{onenine} {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.decimal, yycolumn, yyline, yytext());}
<YYINITIAL> ("'")(.)("'") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.character, yycolumn, yyline, yytext().substring(1, yytext().length() - 1));} // "char"c
<YYINITIAL> ("\"")(.)*("\"") {System.out.print(yytext()); return new Symbol(SintaxisJavaSym.string, yycolumn, yyline, yytext().substring(1, yytext().length() - 1));}

/* Espacios en blanco */
{espacio}+ {System.out.print(yytext()); /*IGNORAR*/}

<YYINITIAL> (.) {System.out.print(yytext()); /*error*/}