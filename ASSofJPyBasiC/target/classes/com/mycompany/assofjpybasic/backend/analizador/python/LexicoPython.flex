package com.mycompany.assofjpybasic.backend.analizador.python;

import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.List;

%%
%class LexicoPython
%type java_cup.runtime.Symbol
%cupsym SintaxisPythonSym
%public
%cup
%full
%line
%column
%init{
    integers.add(0);
%init}
espacio=[\r|\f|" "]+
tab="    "|"\t"
letras=[a-zA-Z]
onenine=[1-9]
cero= "0"

%{
    StringBuffer string = new StringBuffer();
    ArrayList<Integer> integers = new ArrayList<>();
    boolean verificarident = false;
    
    private Symbol symbol(String value, int tam) {
        if(verificarident){
            int i = integers.get(integers.size()-1);
            if(i>(tam-1-value.lastIndexOf('\n'))){
                integers.remove(integers.size()-1);
                this.yypushback(tam - value.lastIndexOf('\n'));
                return new Symbol(SintaxisPythonSym.dedent, yyline, yycolumn, value);
            } else if(i< (tam-1-value.lastIndexOf('\n'))) {
                integers.add(tam-1-value.lastIndexOf('\n'));
                verificarident = false;
                return new Symbol(SintaxisPythonSym.indent, yyline, yycolumn, value);
            } else {
                verificarident = false;
                return null;
            }
        } else {
            this.yypushback(tam - value.lastIndexOf('\n'));
            verificarident = true;
            return new Symbol(SintaxisPythonSym.newline, yyline, yycolumn, value);
        }
    }

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

    /* Palabras Reservadas */
<YYINITIAL> ("\n"|{espacio}|"\t")*("\n"){tab}* {System.out.print(yytext()); Symbol sim = symbol(yytext(), yytext().length()); if(sim!=null){return sim;}else{/*IGNORAR*/}}
    /*Palabras para procesos*/
<YYINITIAL> ("def") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.deff, yycolumn, yyline, yytext());}
<YYINITIAL> ("return") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.returnn, yycolumn, yyline, yytext());}
    /*Palabras para Condicional*/
<YYINITIAL> ("not") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.nott, yycolumn, yyline, yytext());}
<YYINITIAL> ("and") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.andd, yycolumn, yyline, yytext());}
<YYINITIAL> ("or") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.orr, yycolumn, yyline, yytext());}
    /*Palabras de Funciones*/
<YYINITIAL> ("if") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.iff, yycolumn, yyline, yytext());}
<YYINITIAL> ("elif") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.elseiff, yycolumn, yyline, yytext());}
<YYINITIAL> ("else") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.elsee, yycolumn, yyline, yytext());}
<YYINITIAL> ("for") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.forr, yycolumn, yyline, yytext());}
<YYINITIAL> ("in") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.inn, yycolumn, yyline, yytext());}
<YYINITIAL> ("range") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.range, yycolumn, yyline, yytext());}
<YYINITIAL> ("while") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.whilee, yycolumn, yyline, yytext());}
    /*Palabras de Comparacion*/
<YYINITIAL> ("!=") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.noigual, yycolumn, yyline, yytext());}
<YYINITIAL> ("<") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.menor, yycolumn, yyline, yytext());}
<YYINITIAL> ("<=") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.menorig, yycolumn, yyline, yytext());}
<YYINITIAL> (">") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.mayor, yycolumn, yyline, yytext());}
<YYINITIAL> (">=") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.mayorig, yycolumn, yyline, yytext());}
<YYINITIAL> ("==") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.igig, yycolumn, yyline, yytext());}
    /*Palabras de Operadores*/
<YYINITIAL> ("+") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.mas, yycolumn, yyline, yytext());}
<YYINITIAL> ("-") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.menos, yycolumn, yyline, yytext());}
<YYINITIAL> ("*") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.por, yycolumn, yyline, yytext());}
<YYINITIAL> ("/") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.div, yycolumn, yyline, yytext());}
<YYINITIAL> ("%") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.mod, yycolumn, yyline, yytext());}
<YYINITIAL> ("//") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.floor, yycolumn, yyline, yytext());}
    /*Palabras de agrupacion*/
<YYINITIAL> ("(") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.para, yycolumn, yyline, yytext());}
<YYINITIAL> (")") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.parc, yycolumn, yyline, yytext());}
<YYINITIAL> (",") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.coma, yycolumn, yyline, yytext());}
<YYINITIAL> (":") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.dosp, yycolumn, yyline, yytext());}
<YYINITIAL> (";") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.puntocoma, yycolumn, yyline, yytext());}
    /*palabras para manejar consola*/
<YYINITIAL> ("print") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.print, yycolumn, yyline, yytext());}
<YYINITIAL> ("charinput") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.charinput, yycolumn, yyline, yytext());}
<YYINITIAL> ("intinput") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.intinput, yycolumn, yyline, yytext());}
<YYINITIAL> ("floatinput") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.floatinput, yycolumn, yyline, yytext());}
    /*Operandos de asignacion*/
<YYINITIAL> ("=") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.igual, yycolumn, yyline, yytext());}

/* Expresiones Regulares */
<YYINITIAL> ("/*")(.|{espacio})*("*/") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.com, yycolumn, yyline, yytext());}
<YYINITIAL> ("//")(.)*("\n") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.com, yycolumn, yyline, yytext());}
<YYINITIAL> {letras}({letras}|{onenine}|{cero}|"_")* {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.id, yycolumn, yyline, yytext());}
<YYINITIAL> ({onenine}({onenine}|{cero})*)|{cero} {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.entero, yycolumn, yyline, yytext());}
<YYINITIAL> (({onenine}({onenine}|{cero})*)|{cero})(".")({onenine}|{cero})*{onenine} {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.decimal, yycolumn, yyline, yytext());}
<YYINITIAL> ("'")(.)("'") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.character, yycolumn, yyline, yytext().substring(1, yytext().length() - 1));} // "char"c
<YYINITIAL> ("\"")(.)*("\"") {System.out.print(yytext()); return new Symbol(SintaxisPythonSym.string, yycolumn, yyline, yytext().substring(1, yytext().length() - 1));}

/* Espacios en blanco */
{espacio}+ {System.out.print(yytext()); /*IGNORAR*/}

<YYINITIAL> (.) {System.out.print(yytext()); /*error*/}