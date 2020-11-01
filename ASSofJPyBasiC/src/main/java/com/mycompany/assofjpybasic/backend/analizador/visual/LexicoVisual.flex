package com.mycompany.assofjpybasic.backend.analizador.visual;
import java_cup.runtime.*;
%%
%class LexicoVisual
%type java_cup.runtime.Symbol
%cupsym SintaxisVisualSym
%public
%cup
%full
%line
%column
%ignorecase
letras=[a-zA-Z]
espacio=[\t|\r|\f|" "]+
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

    /* Palabras Reservadas */
<YYINITIAL> ("_\n") {System.out.print(yytext()); /*ignorar*/}
<YYINITIAL> ("\n"|{espacio})*("\n") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.espacio, yycolumn, yyline, yytext());}
    /*Palabras para procesos*/
<YYINITIAL> ("sub") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.subb, yycolumn, yyline, yytext());}
<YYINITIAL> ("function") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.functionn, yycolumn, yyline, yytext());}
<YYINITIAL> ("end") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.endd, yycolumn, yyline, yytext());}
<YYINITIAL> ("public") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.publicc, yycolumn, yyline, yytext());}
<YYINITIAL> ("return") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.returnn, yycolumn, yyline, yytext());}
<YYINITIAL> ("byval") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.byval, yycolumn, yyline, yytext());}
    /*Palabras para declaracion*/
<YYINITIAL> ("dim") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.dimm, yycolumn, yyline, yytext());}
<YYINITIAL> ("as") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.ass, yycolumn, yyline, yytext());}
    /*Palabras para Condicional*/
<YYINITIAL> ("not") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.nott, yycolumn, yyline, yytext());}
<YYINITIAL> ("and") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.andd, yycolumn, yyline, yytext());}
<YYINITIAL> ("or") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.orr, yycolumn, yyline, yytext());}
    /*Palabras tipos*/
<YYINITIAL> ("integer") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.integerr, yycolumn, yyline, yytext());}
<YYINITIAL> ("decimal") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.decimall, yycolumn, yyline, yytext());}
<YYINITIAL> ("char") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.charr, yycolumn, yyline, yytext());}
    /*Palabras de Funciones*/
<YYINITIAL> ("if") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.iff, yycolumn, yyline, yytext());}
<YYINITIAL> ("elseif") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.elseiff, yycolumn, yyline, yytext());}
<YYINITIAL> ("else") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.elsee, yycolumn, yyline, yytext());}
<YYINITIAL> ("then") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.thenn, yycolumn, yyline, yytext());}
<YYINITIAL> ("select") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.selectt, yycolumn, yyline, yytext());}
<YYINITIAL> ("case") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.casee, yycolumn, yyline, yytext());}
<YYINITIAL> ("for") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.forr, yycolumn, yyline, yytext());}
<YYINITIAL> ("to") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.to, yycolumn, yyline, yytext());}
<YYINITIAL> ("step") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.stepp, yycolumn, yyline, yytext());}
<YYINITIAL> ("next") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.nextt, yycolumn, yyline, yytext());}
<YYINITIAL> ("while") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.whilee, yycolumn, yyline, yytext());}
<YYINITIAL> ("do") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.doo, yycolumn, yyline, yytext());}
<YYINITIAL> ("loop") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.loopp, yycolumn, yyline, yytext());}
    /*Palabras de Comparacion*/
<YYINITIAL> ("<>") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.noigual, yycolumn, yyline, yytext());}
<YYINITIAL> ("<") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.menor, yycolumn, yyline, yytext());}
<YYINITIAL> ("<=") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.menorig, yycolumn, yyline, yytext());}
<YYINITIAL> (">") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.mayor, yycolumn, yyline, yytext());}
<YYINITIAL> (">=") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.mayorig, yycolumn, yyline, yytext());}
    /*Palabras de Operadores*/
<YYINITIAL> ("+") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.mas, yycolumn, yyline, yytext());}
<YYINITIAL> ("-") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.menos, yycolumn, yyline, yytext());}
<YYINITIAL> ("*") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.por, yycolumn, yyline, yytext());}
<YYINITIAL> ("/") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.div, yycolumn, yyline, yytext());}
<YYINITIAL> ("mod") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.mod, yycolumn, yyline, yytext());}
    /*Palabras de agrupacion*/
<YYINITIAL> ("(") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.para, yycolumn, yyline, yytext());}
<YYINITIAL> (")") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.parc, yycolumn, yyline, yytext());}
<YYINITIAL> (",") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.coma, yycolumn, yyline, yytext());}
    /*simbolo de concatenacion*/
<YYINITIAL> ("&") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.y, yycolumn, yyline, yytext());}
    /*palabras para manejar consola*/
<YYINITIAL> ("console.writeline") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.writeln, yycolumn, yyline, yytext());}
<YYINITIAL> ("console.write") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.write, yycolumn, yyline, yytext());}
<YYINITIAL> ("charinput") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.charinput, yycolumn, yyline, yytext());}
<YYINITIAL> ("intinput") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.intinput, yycolumn, yyline, yytext());}
<YYINITIAL> ("floatinput") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.floatinput, yycolumn, yyline, yytext());}
    /*Operandos de asignacion*/
<YYINITIAL> ("=") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.igual, yycolumn, yyline, yytext());}

/* Expresiones Regulares */
<YYINITIAL> ("/*")(.|{espacio})*("*/") {System.out.print(yytext()); /*return new Symbol(SintaxisVisualSym.com, yycolumn, yyline, yytext());*/}
<YYINITIAL> ("//")(.)*("\n") {System.out.print(yytext());/* return new Symbol(SintaxisVisualSym.com, yycolumn, yyline, yytext());*/}
<YYINITIAL> {letras}({letras}|{onenine}|{cero}|"_")* {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.id, yycolumn, yyline, yytext());}
<YYINITIAL> ({onenine}({onenine}|{cero})*)|{cero} {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.entero, yycolumn, yyline, yytext());}
<YYINITIAL> (({onenine}({onenine}|{cero})*)|{cero})(".")({onenine}|{cero})*{onenine} {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.decimal, yycolumn, yyline, yytext());}
<YYINITIAL> ("\"")(.)("\"")("c") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.character, yycolumn, yyline, yytext().substring(1, yytext().length() - 2));} // "char"c
<YYINITIAL> ("\"")(.)*("\"") {System.out.print(yytext()); return new Symbol(SintaxisVisualSym.string, yycolumn, yyline, yytext().substring(1, yytext().length() - 1));}

/* Espacios en blanco */
{espacio}+ {System.out.print(yytext()); /*IGNORAR*/}

<YYINITIAL> (.) {System.out.print(yytext()); /*error*/}