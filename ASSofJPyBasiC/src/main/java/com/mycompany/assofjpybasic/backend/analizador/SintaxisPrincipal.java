
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615
//----------------------------------------------------

package com.mycompany.assofjpybasic.backend.analizador;

import java_cup.runtime.*;
import com.mycompany.assofjpybasic.backend.classes.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class SintaxisPrincipal extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return SintaxisPrincipalSym.class;
}

  /** Default constructor. */
  @Deprecated
  public SintaxisPrincipal() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public SintaxisPrincipal(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public SintaxisPrincipal(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\015\000\002\002\004\000\002\010\007\000\002\002" +
    "\004\000\002\003\004\000\002\004\004\000\002\005\004" +
    "\000\002\007\004\000\002\007\004\000\002\007\002\000" +
    "\002\006\004\000\002\006\004\000\002\006\004\000\002" +
    "\006\002" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\025\000\010\004\ufff9\011\ufff9\012\ufff9\001\002\000" +
    "\004\002\027\001\002\000\010\004\007\011\011\012\006" +
    "\001\002\000\010\004\ufffa\011\ufffa\012\ufffa\001\002\000" +
    "\012\005\ufff5\010\ufff5\011\ufff5\012\ufff5\001\002\000\004" +
    "\005\012\001\002\000\010\004\ufffb\011\ufffb\012\ufffb\001" +
    "\002\000\012\006\ufff5\010\ufff5\011\ufff5\012\ufff5\001\002" +
    "\000\004\006\014\001\002\000\012\007\ufff5\010\ufff5\011" +
    "\ufff5\012\ufff5\001\002\000\004\007\017\001\002\000\004" +
    "\002\000\001\002\000\012\002\ufff5\010\ufff5\011\ufff5\012" +
    "\ufff5\001\002\000\012\002\ufffc\010\021\011\023\012\022" +
    "\001\002\000\020\002\ufff8\005\ufff8\006\ufff8\007\ufff8\010" +
    "\ufff8\011\ufff8\012\ufff8\001\002\000\020\002\ufff6\005\ufff6" +
    "\006\ufff6\007\ufff6\010\ufff6\011\ufff6\012\ufff6\001\002\000" +
    "\020\002\ufff7\005\ufff7\006\ufff7\007\ufff7\010\ufff7\011\ufff7" +
    "\012\ufff7\001\002\000\012\007\ufffd\010\021\011\023\012" +
    "\022\001\002\000\012\006\ufffe\010\021\011\023\012\022" +
    "\001\002\000\012\005\uffff\010\021\011\023\012\022\001" +
    "\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\025\000\006\007\004\010\003\001\001\000\002\001" +
    "\001\000\004\002\007\001\001\000\002\001\001\000\004" +
    "\006\025\001\001\000\004\003\012\001\001\000\002\001" +
    "\001\000\004\006\024\001\001\000\004\004\014\001\001" +
    "\000\004\006\023\001\001\000\004\005\015\001\001\000" +
    "\002\001\001\000\004\006\017\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$SintaxisPrincipal$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$SintaxisPrincipal$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$SintaxisPrincipal$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    private Symbol s;
    
    public void syntax_error(Symbol sym){
        System.out.println("Error Sintactico en la letra: " + sym.value + "   <linea>: "  + (sym.right + 1) + "    <columna>: " + (sym.left + 1) + "\n");
    }

    public void unrecovered_syntax_error(Symbol sym) throws java.lang.Exception{
        System.out.println("Error Sintactico en la letra: " + sym.value + "   <linea>: "  + (sym.right + 1) + "    <columna>: " + (sym.left + 1) + "\n");
    }

    public Symbol getS(){
        return this.s;
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$SintaxisPrincipal$actions {
  private final SintaxisPrincipal parser;

  /** Constructor */
  CUP$SintaxisPrincipal$actions(SintaxisPrincipal parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$SintaxisPrincipal$do_action_part00000000(
    int                        CUP$SintaxisPrincipal$act_num,
    java_cup.runtime.lr_parser CUP$SintaxisPrincipal$parser,
    java.util.Stack            CUP$SintaxisPrincipal$stack,
    int                        CUP$SintaxisPrincipal$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$SintaxisPrincipal$result;

      /* select the action based on the action number */
      switch (CUP$SintaxisPrincipal$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= S EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).right;
		ArchivoMLG start_val = (ArchivoMLG)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).value;
		RESULT = start_val;
              CUP$SintaxisPrincipal$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)), ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$SintaxisPrincipal$parser.done_parsing();
          return CUP$SintaxisPrincipal$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // S ::= ESP VB JV PY PROG 
            {
              ArchivoMLG RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-3)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-3)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-3)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-2)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-2)).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-2)).value;
		int e3left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).left;
		int e3right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).right;
		String e3 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).value;
		int e4left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).left;
		int e4right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).right;
		String e4 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.peek()).value;
		RESULT = new ArchivoMLG(e1,e2,e3,e4);
              CUP$SintaxisPrincipal$result = parser.getSymbolFactory().newSymbol("S",6, ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-4)), ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()), RESULT);
            }
          return CUP$SintaxisPrincipal$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // VB ::= vb TEXTO 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.peek()).value;
		RESULT = e1;
              CUP$SintaxisPrincipal$result = parser.getSymbolFactory().newSymbol("VB",0, ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)), ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()), RESULT);
            }
          return CUP$SintaxisPrincipal$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // JV ::= java TEXTO 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.peek()).value;
		RESULT = e1;
              CUP$SintaxisPrincipal$result = parser.getSymbolFactory().newSymbol("JV",1, ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)), ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()), RESULT);
            }
          return CUP$SintaxisPrincipal$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // PY ::= py TEXTO 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.peek()).value;
		RESULT = e1;
              CUP$SintaxisPrincipal$result = parser.getSymbolFactory().newSymbol("PY",2, ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)), ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()), RESULT);
            }
          return CUP$SintaxisPrincipal$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // PROG ::= prog TEXTO 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.peek()).value;
		RESULT = e1;
              CUP$SintaxisPrincipal$result = parser.getSymbolFactory().newSymbol("PROG",3, ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)), ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()), RESULT);
            }
          return CUP$SintaxisPrincipal$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // ESP ::= ESP esp 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.peek()).value;
		RESULT = e1 + e2;
              CUP$SintaxisPrincipal$result = parser.getSymbolFactory().newSymbol("ESP",5, ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)), ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()), RESULT);
            }
          return CUP$SintaxisPrincipal$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // ESP ::= ESP com 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.peek()).value;
		RESULT = e1 + e2;
              CUP$SintaxisPrincipal$result = parser.getSymbolFactory().newSymbol("ESP",5, ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)), ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()), RESULT);
            }
          return CUP$SintaxisPrincipal$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // ESP ::= 
            {
              String RESULT =null;
		RESULT = "";
              CUP$SintaxisPrincipal$result = parser.getSymbolFactory().newSymbol("ESP",5, ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()), RESULT);
            }
          return CUP$SintaxisPrincipal$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // TEXTO ::= TEXTO txt 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.peek()).value;
		RESULT = e1 + e2;
              CUP$SintaxisPrincipal$result = parser.getSymbolFactory().newSymbol("TEXTO",4, ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)), ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()), RESULT);
            }
          return CUP$SintaxisPrincipal$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // TEXTO ::= TEXTO esp 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.peek()).value;
		RESULT = e1 + e2;
              CUP$SintaxisPrincipal$result = parser.getSymbolFactory().newSymbol("TEXTO",4, ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)), ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()), RESULT);
            }
          return CUP$SintaxisPrincipal$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // TEXTO ::= TEXTO com 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$SintaxisPrincipal$stack.peek()).value;
		RESULT = e1 + e2;
              CUP$SintaxisPrincipal$result = parser.getSymbolFactory().newSymbol("TEXTO",4, ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.elementAt(CUP$SintaxisPrincipal$top-1)), ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()), RESULT);
            }
          return CUP$SintaxisPrincipal$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // TEXTO ::= 
            {
              String RESULT =null;
		RESULT = "";
              CUP$SintaxisPrincipal$result = parser.getSymbolFactory().newSymbol("TEXTO",4, ((java_cup.runtime.Symbol)CUP$SintaxisPrincipal$stack.peek()), RESULT);
            }
          return CUP$SintaxisPrincipal$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$SintaxisPrincipal$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$SintaxisPrincipal$do_action(
    int                        CUP$SintaxisPrincipal$act_num,
    java_cup.runtime.lr_parser CUP$SintaxisPrincipal$parser,
    java.util.Stack            CUP$SintaxisPrincipal$stack,
    int                        CUP$SintaxisPrincipal$top)
    throws java.lang.Exception
    {
              return CUP$SintaxisPrincipal$do_action_part00000000(
                               CUP$SintaxisPrincipal$act_num,
                               CUP$SintaxisPrincipal$parser,
                               CUP$SintaxisPrincipal$stack,
                               CUP$SintaxisPrincipal$top);
    }
}

}
