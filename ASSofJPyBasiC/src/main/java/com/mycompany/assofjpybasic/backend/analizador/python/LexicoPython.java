/* The following code was generated by JFlex 1.4.3 on 3/11/20 00:58 */

package com.mycompany.assofjpybasic.backend.analizador.python;

import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.List;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 3/11/20 00:58 from the specification file
 * <tt>LexicoPython.flex</tt>
 */
public class LexicoPython implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int STRING = 2;
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  3,  7,  0,  1,  1,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     2, 23, 42,  0,  0, 31,  0, 41, 32, 33, 29, 27, 34, 28, 40, 30, 
     6,  5,  5,  5,  5,  5,  5,  5,  5,  5, 35, 36, 25, 24, 26,  0, 
     0,  4,  4,  4,  4,  4,  4,  4,  4,  4,  4,  4,  4,  4,  4,  4, 
     4,  4,  4,  4,  4,  4,  4,  4,  4,  4,  4,  0,  0,  0,  0, 39, 
     0, 16,  4, 38,  8,  9, 10, 20, 22, 17,  4,  4, 18,  4, 14, 15, 
    37,  4, 11, 19, 12, 13,  4, 21,  4,  4,  4,  0,  1,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\1\1\3\2\4\1\5\11\3"+
    "\1\1\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\2\3\1\1"+
    "\1\23\1\24\1\25\3\0\7\3\1\26\1\3\1\27"+
    "\1\30\1\3\1\31\1\32\1\33\1\34\2\0\2\3"+
    "\1\0\1\35\1\0\1\36\2\3\1\37\3\3\1\40"+
    "\1\41\2\3\1\0\1\42\2\3\1\43\1\0\1\44"+
    "\1\45\5\3\1\42\4\3\1\46\1\3\1\47\1\50"+
    "\2\3\1\51\6\3\1\52\2\3\1\53\1\54";

  private static int [] zzUnpackAction() {
    int [] result = new int[111];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\53\0\126\0\201\0\254\0\327\0\u0102\0\u012d"+
    "\0\u0158\0\u0183\0\u01ae\0\u01d9\0\u0204\0\u022f\0\u025a\0\u0285"+
    "\0\u02b0\0\u02db\0\u0306\0\u0331\0\u035c\0\u0387\0\126\0\126"+
    "\0\126\0\u03b2\0\126\0\126\0\126\0\126\0\126\0\126"+
    "\0\u03dd\0\u0408\0\u0433\0\126\0\126\0\126\0\254\0\u045e"+
    "\0\u0489\0\u04b4\0\u04df\0\u050a\0\u0535\0\u0560\0\u058b\0\u05b6"+
    "\0\327\0\u05e1\0\327\0\u060c\0\u0637\0\126\0\126\0\126"+
    "\0\126\0\u0662\0\u068d\0\u06b8\0\u06e3\0\u070e\0\u045e\0\u0739"+
    "\0\327\0\u0764\0\u078f\0\327\0\u07ba\0\u07e5\0\u0810\0\327"+
    "\0\327\0\u083b\0\u0866\0\u0891\0\126\0\u08bc\0\u08e7\0\126"+
    "\0\u0912\0\327\0\327\0\u093d\0\u0968\0\u0993\0\u09be\0\u09e9"+
    "\0\u0662\0\u0a14\0\u0a3f\0\u0a6a\0\u0a95\0\327\0\u0ac0\0\327"+
    "\0\327\0\u0aeb\0\u0b16\0\327\0\u0b41\0\u0b6c\0\u0b97\0\u0bc2"+
    "\0\u0bed\0\u0c18\0\327\0\u0c43\0\u0c6e\0\327\0\327";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[111];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\2\4\1\5\1\6\1\7\1\10\1\11\1\12"+
    "\1\13\1\14\1\15\2\6\1\16\1\17\1\20\1\21"+
    "\3\6\1\22\1\6\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\1\40\1\41\1\42\2\3\1\43\1\44\52\45\1\46"+
    "\54\0\2\4\1\47\3\0\1\11\44\0\3\47\3\0"+
    "\1\11\47\0\3\6\1\0\17\6\16\0\3\6\10\0"+
    "\2\7\41\0\1\50\52\0\1\50\3\0\1\47\1\51"+
    "\1\11\3\0\1\11\47\0\3\6\1\0\1\6\1\52"+
    "\15\6\16\0\3\6\7\0\3\6\1\0\12\6\1\53"+
    "\4\6\16\0\3\6\7\0\3\6\1\0\7\6\1\54"+
    "\2\6\1\55\4\6\16\0\3\6\7\0\3\6\1\0"+
    "\1\6\1\56\6\6\1\57\6\6\16\0\3\6\7\0"+
    "\3\6\1\0\7\6\1\60\7\6\16\0\3\6\7\0"+
    "\3\6\1\0\3\6\1\61\13\6\16\0\3\6\7\0"+
    "\3\6\1\0\6\6\1\62\10\6\16\0\3\6\7\0"+
    "\3\6\1\0\2\6\1\63\3\6\1\64\10\6\16\0"+
    "\3\6\7\0\3\6\1\0\16\6\1\65\16\0\3\6"+
    "\33\0\1\66\52\0\1\67\52\0\1\70\52\0\1\71"+
    "\57\0\1\72\1\73\20\0\3\6\1\0\3\6\1\74"+
    "\13\6\16\0\3\6\7\0\3\6\1\0\16\6\1\75"+
    "\16\0\3\6\3\0\7\76\1\0\43\76\5\0\1\77"+
    "\1\50\45\0\1\47\1\100\1\47\3\0\1\11\47\0"+
    "\3\6\1\0\2\6\1\101\14\6\16\0\3\6\7\0"+
    "\3\6\1\0\11\6\1\102\1\6\1\103\3\6\16\0"+
    "\3\6\7\0\3\6\1\0\3\6\1\104\13\6\16\0"+
    "\3\6\7\0\3\6\1\0\7\6\1\105\7\6\16\0"+
    "\3\6\7\0\3\6\1\0\4\6\1\106\12\6\16\0"+
    "\3\6\7\0\3\6\1\0\6\6\1\107\10\6\16\0"+
    "\3\6\7\0\3\6\1\0\4\6\1\110\12\6\16\0"+
    "\3\6\7\0\3\6\1\0\1\111\16\6\16\0\3\6"+
    "\7\0\3\6\1\0\4\6\1\112\12\6\16\0\3\6"+
    "\7\0\3\6\1\0\11\6\1\113\5\6\16\0\3\6"+
    "\3\0\7\72\1\0\25\72\1\114\15\72\7\73\1\115"+
    "\43\73\4\0\3\6\1\0\11\6\1\116\5\6\16\0"+
    "\3\6\7\0\3\6\1\0\10\6\1\117\6\6\16\0"+
    "\3\6\54\0\1\120\2\0\1\47\1\121\1\47\3\0"+
    "\1\11\47\0\3\6\1\0\2\6\1\122\14\6\16\0"+
    "\3\6\7\0\3\6\1\0\1\6\1\123\15\6\16\0"+
    "\3\6\7\0\3\6\1\0\10\6\1\124\6\6\16\0"+
    "\3\6\7\0\3\6\1\0\5\6\1\125\11\6\16\0"+
    "\3\6\7\0\3\6\1\0\14\6\1\126\2\6\16\0"+
    "\3\6\7\0\3\6\1\0\11\6\1\127\5\6\16\0"+
    "\3\6\7\0\3\6\1\0\12\6\1\130\4\6\16\0"+
    "\3\6\3\0\7\72\1\0\25\72\1\114\1\131\14\72"+
    "\4\0\3\6\1\0\6\6\1\132\10\6\16\0\3\6"+
    "\7\0\3\6\1\0\3\6\1\133\13\6\16\0\3\6"+
    "\4\0\1\47\1\11\1\47\3\0\1\11\47\0\3\6"+
    "\1\0\4\6\1\134\12\6\16\0\3\6\7\0\3\6"+
    "\1\0\3\6\1\135\13\6\16\0\3\6\7\0\3\6"+
    "\1\0\1\6\1\136\15\6\16\0\3\6\7\0\3\6"+
    "\1\0\6\6\1\137\10\6\16\0\3\6\7\0\3\6"+
    "\1\0\1\6\1\140\15\6\16\0\3\6\7\0\3\6"+
    "\1\0\4\6\1\141\12\6\16\0\3\6\7\0\3\6"+
    "\1\0\11\6\1\142\5\6\16\0\3\6\7\0\3\6"+
    "\1\0\11\6\1\143\5\6\16\0\3\6\7\0\3\6"+
    "\1\0\6\6\1\144\10\6\16\0\3\6\7\0\3\6"+
    "\1\0\17\6\16\0\1\145\2\6\7\0\3\6\1\0"+
    "\6\6\1\146\10\6\16\0\3\6\7\0\3\6\1\0"+
    "\6\6\1\147\10\6\16\0\3\6\7\0\3\6\1\0"+
    "\5\6\1\150\11\6\16\0\3\6\7\0\3\6\1\0"+
    "\17\6\16\0\1\151\2\6\7\0\3\6\1\0\17\6"+
    "\16\0\1\152\2\6\7\0\3\6\1\0\4\6\1\153"+
    "\12\6\16\0\3\6\7\0\3\6\1\0\5\6\1\154"+
    "\11\6\16\0\3\6\7\0\3\6\1\0\5\6\1\155"+
    "\11\6\16\0\3\6\7\0\3\6\1\0\4\6\1\156"+
    "\12\6\16\0\3\6\7\0\3\6\1\0\4\6\1\157"+
    "\12\6\16\0\3\6\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3225];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\23\1\3\11\1\1\6\11\3\1\3\11"+
    "\3\0\14\1\4\11\2\0\2\1\1\0\1\1\1\0"+
    "\13\1\1\0\1\11\2\1\1\11\1\0\36\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[111];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
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


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public LexicoPython(java.io.Reader in) {
      integers.add(0);
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public LexicoPython(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 9: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.mas, yycolumn, yyline, yytext());
          }
        case 45: break;
        case 24: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.inn, yycolumn, yyline, yytext());
          }
        case 46: break;
        case 43: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.charinput, yycolumn, yyline, yytext());
          }
        case 47: break;
        case 31: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.forr, yycolumn, yyline, yytext());
          }
        case 48: break;
        case 18: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.puntocoma, yycolumn, yyline, yytext());
          }
        case 49: break;
        case 39: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.whilee, yycolumn, yyline, yytext());
          }
        case 50: break;
        case 37: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.elsee, yycolumn, yyline, yytext());
          }
        case 51: break;
        case 14: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.para, yycolumn, yyline, yytext());
          }
        case 52: break;
        case 36: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.elseiff, yycolumn, yyline, yytext());
          }
        case 53: break;
        case 30: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.deff, yycolumn, yyline, yytext());
          }
        case 54: break;
        case 23: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.iff, yycolumn, yyline, yytext());
          }
        case 55: break;
        case 33: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.andd, yycolumn, yyline, yytext());
          }
        case 56: break;
        case 35: 
          { System.out.print(yytext()); int s = yytext().charAt(1);
                        return new Symbol(SintaxisPythonSym.character, yycolumn, yyline, s + "");
          }
        case 57: break;
        case 28: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.mayorig, yycolumn, yyline, yytext());
          }
        case 58: break;
        case 25: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.noigual, yycolumn, yyline, yytext());
          }
        case 59: break;
        case 26: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.igig, yycolumn, yyline, yytext());
          }
        case 60: break;
        case 40: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.print, yycolumn, yyline, yytext());
          }
        case 61: break;
        case 2: 
          { System.out.print(yytext()); /*IGNORAR*/
          }
        case 62: break;
        case 15: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.parc, yycolumn, yyline, yytext());
          }
        case 63: break;
        case 6: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.igual, yycolumn, yyline, yytext());
          }
        case 64: break;
        case 34: 
          { System.out.print(yytext()); /*return new Symbol(SintaxisPythonSym.com, yycolumn, yyline, yytext());*/
          }
        case 65: break;
        case 3: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.id, yycolumn, yyline, yytext());
          }
        case 66: break;
        case 11: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.por, yycolumn, yyline, yytext());
          }
        case 67: break;
        case 29: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.decimal, yycolumn, yyline, yytext());
          }
        case 68: break;
        case 44: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.floatinput, yycolumn, yyline, yytext());
          }
        case 69: break;
        case 13: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.mod, yycolumn, yyline, yytext());
          }
        case 70: break;
        case 27: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.menorig, yycolumn, yyline, yytext());
          }
        case 71: break;
        case 12: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.div, yycolumn, yyline, yytext());
          }
        case 72: break;
        case 7: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.menor, yycolumn, yyline, yytext());
          }
        case 73: break;
        case 16: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.coma, yycolumn, yyline, yytext());
          }
        case 74: break;
        case 42: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.intinput, yycolumn, yyline, yytext());
          }
        case 75: break;
        case 4: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.entero, yycolumn, yyline, yytext());
          }
        case 76: break;
        case 10: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.menos, yycolumn, yyline, yytext());
          }
        case 77: break;
        case 21: 
          { yybegin(YYINITIAL); String s = string.toString(); string.setLength(0);
                                        return new Symbol(SintaxisPythonSym.string, yycolumn, yyline, s);
          }
        case 78: break;
        case 19: 
          { yybegin(STRING);
          }
        case 79: break;
        case 8: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.mayor, yycolumn, yyline, yytext());
          }
        case 80: break;
        case 38: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.range, yycolumn, yyline, yytext());
          }
        case 81: break;
        case 1: 
          { System.out.print(yytext()); /*error*/
          }
        case 82: break;
        case 20: 
          { string.append(yytext());
          }
        case 83: break;
        case 22: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.orr, yycolumn, yyline, yytext());
          }
        case 84: break;
        case 5: 
          { System.out.print(yytext()); Symbol sim = symbol(yytext(), yytext().length()); if(sim!=null){return sim;}else{/*IGNORAR*/}
          }
        case 85: break;
        case 17: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.dosp, yycolumn, yyline, yytext());
          }
        case 86: break;
        case 41: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.returnn, yycolumn, yyline, yytext());
          }
        case 87: break;
        case 32: 
          { System.out.print(yytext()); return new Symbol(SintaxisPythonSym.nott, yycolumn, yyline, yytext());
          }
        case 88: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(SintaxisPythonSym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
