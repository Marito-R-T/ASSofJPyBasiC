package com.mycompany.assofjpybasic.backend.analizador;
import java_cup.runtime.*;
%%
%class LexicoPrincipal
%type java_cup.runtime.Symbol
%cupsym SintaxisPrincipalSym
%public
%cup
%full
%line
%column
espacio=[\t|\r|\n|\f|" "]+

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

/* Espacios en blanco */
{espacio}+ {return new Symbol(SintaxisPrincipalSym.esp, yycolumn, yyline, yytext());}

/* Palabras Reservadas */
<YYINITIAL> ("VB") {return new Symbol(SintaxisPrincipalSym.vb, yycolumn, yyline, yytext());}
<YYINITIAL> ("JAVA") {return new Symbol(SintaxisPrincipalSym.java, yycolumn, yyline, yytext());}
<YYINITIAL> ("PY") {return new Symbol(SintaxisPrincipalSym.py, yycolumn, yyline, yytext());}
<YYINITIAL> ("PROGRAMA") {return new Symbol(SintaxisPrincipalSym.prog, yycolumn, yyline, yytext());}


<YYINITIAL> ("%%") {return new Symbol(SintaxisPrincipalSym.dospor, yycolumn, yyline, yytext());}


<YYINITIAL> (.)* {return new Symbol(SintaxisPrincipalSym.txt, yycolumn, yyline, yytext());}