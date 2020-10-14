/* The following code was generated by JFlex 1.4.3 on 13/10/20 23:23 */

package com.mycompany.assofjpybasic.backend.analizador.principal;

import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.List;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 13/10/20 23:23 from the specification file
 * <tt>LexicoPrograma.flex</tt>
 */
public class LexicoPrograma implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int STRING = 2;
  public static final int ST = 6;
  public static final int YYINITIAL = 0;
  public static final int JAVA = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3, 3
  };

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  1, 56,  0,  1,  1,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
    13, 28, 14,  5,  0, 44, 26, 58, 45, 46, 42, 40, 51, 41, 18, 43, 
     4,  3,  3,  3,  3,  3,  3,  3,  3,  3, 53, 52, 38, 37, 39,  0, 
     0, 16, 21,  2,  2,  2,  2,  2,  2,  2, 15,  2,  2,  2,  2,  2, 
    19,  2,  2,  2,  2,  2, 17,  2,  2, 20,  2, 49,  0, 50,  0, 57, 
     0, 25, 35,  8, 11, 12, 31, 55, 32,  6,  2, 36,  9, 24,  7, 23, 
    54,  2, 33, 29, 30, 10, 22, 34,  2,  2,  2, 47, 27, 48,  0,  0, 
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
    "\4\0\1\1\1\2\1\3\2\4\1\1\4\3\1\5"+
    "\2\3\1\6\3\3\1\7\1\2\1\10\4\3\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
    "\2\3\1\1\1\32\1\33\1\32\1\34\1\35\1\34"+
    "\2\0\1\3\1\36\10\3\1\37\1\40\2\3\1\41"+
    "\1\42\1\43\6\3\1\44\1\0\1\45\1\46\1\47"+
    "\1\50\2\0\2\3\1\0\1\51\1\52\1\53\1\0"+
    "\1\54\5\3\1\55\7\3\1\56\2\3\2\0\1\57"+
    "\2\3\1\60\1\0\2\3\1\61\1\62\1\3\1\63"+
    "\1\64\1\65\1\66\5\3\1\0\1\57\2\3\1\0"+
    "\1\3\1\67\1\3\1\70\1\3\1\71\1\72\1\73"+
    "\1\74\2\3\1\0\2\3\1\75\1\76\3\0\1\77"+
    "\1\100\1\101\1\102\11\0\1\103\1\104\1\0\1\105";

  private static int [] zzUnpackAction() {
    int [] result = new int[173];
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
    "\0\0\0\73\0\166\0\261\0\354\0\u0127\0\u0162\0\u019d"+
    "\0\u01d8\0\u0213\0\u024e\0\u0289\0\u02c4\0\u02ff\0\354\0\u033a"+
    "\0\u0375\0\354\0\u03b0\0\u03eb\0\u0426\0\u0461\0\u049c\0\u04d7"+
    "\0\u0512\0\u054d\0\u0588\0\u05c3\0\u05fe\0\u0639\0\u0674\0\u06af"+
    "\0\u06ea\0\354\0\u0725\0\354\0\354\0\354\0\354\0\354"+
    "\0\354\0\354\0\354\0\354\0\354\0\u0760\0\u079b\0\u07d6"+
    "\0\354\0\354\0\u0811\0\354\0\354\0\u084c\0\u0887\0\u08c2"+
    "\0\u08fd\0\u0162\0\u0938\0\u0973\0\u09ae\0\u09e9\0\u0a24\0\u0a5f"+
    "\0\u0a9a\0\u0ad5\0\u0162\0\u0162\0\u0b10\0\u0b4b\0\354\0\u0127"+
    "\0\354\0\u0b86\0\u0bc1\0\u0bfc\0\u0c37\0\u0c72\0\u0cad\0\354"+
    "\0\u0ce8\0\354\0\354\0\354\0\354\0\u0d23\0\u0d5e\0\u0d99"+
    "\0\u0dd4\0\u0e0f\0\354\0\354\0\u0887\0\u0e4a\0\u0162\0\u0e85"+
    "\0\u0ec0\0\u0efb\0\u0f36\0\u0f71\0\u0162\0\u0fac\0\u0fe7\0\u1022"+
    "\0\u105d\0\u1098\0\u10d3\0\u110e\0\u0162\0\u1149\0\u1184\0\u11bf"+
    "\0\u11fa\0\354\0\u1235\0\u1270\0\354\0\u12ab\0\u12e6\0\u1321"+
    "\0\u0162\0\u0162\0\u135c\0\u0162\0\u0162\0\u0162\0\u0162\0\u1397"+
    "\0\u13d2\0\u140d\0\u1448\0\u1483\0\u14be\0\u0d23\0\u14f9\0\u1534"+
    "\0\u156f\0\u15aa\0\u0162\0\u15e5\0\u0162\0\u1620\0\u0162\0\u0162"+
    "\0\u0162\0\354\0\u165b\0\u1696\0\u16d1\0\u170c\0\u1747\0\u0162"+
    "\0\u0162\0\u1782\0\u17bd\0\u17f8\0\u0162\0\354\0\u1833\0\354"+
    "\0\u186e\0\u18a9\0\u18e4\0\u191f\0\u195a\0\u1995\0\u19d0\0\u1a0b"+
    "\0\u1a46\0\354\0\354\0\u1a81\0\354";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[173];
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
    "\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\7"+
    "\1\14\2\7\1\15\1\16\1\6\1\17\1\20\1\7"+
    "\1\21\1\22\1\23\2\7\1\24\1\7\1\25\1\7"+
    "\1\26\1\27\1\30\1\31\1\7\1\32\2\7\1\33"+
    "\1\34\1\7\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52"+
    "\1\53\1\54\1\55\1\56\1\57\1\6\1\5\1\60"+
    "\16\61\1\62\35\61\1\63\16\61\2\0\1\7\3\0"+
    "\7\7\1\0\1\62\3\7\1\0\7\7\3\0\10\7"+
    "\5\0\1\42\13\0\2\7\3\0\16\64\1\65\35\64"+
    "\1\66\13\64\1\0\2\64\74\0\1\6\13\0\1\6"+
    "\15\0\1\6\34\0\1\6\4\0\3\7\1\0\7\7"+
    "\2\0\3\7\1\0\7\7\3\0\10\7\21\0\2\7"+
    "\1\0\1\7\4\0\2\10\15\0\1\67\72\0\1\67"+
    "\56\0\1\70\66\0\3\7\1\0\1\7\1\71\5\7"+
    "\2\0\3\7\1\0\7\7\3\0\2\7\1\72\5\7"+
    "\21\0\2\7\1\0\1\7\3\0\3\7\1\0\3\7"+
    "\1\73\3\7\2\0\3\7\1\0\4\7\1\74\1\7"+
    "\1\75\3\0\3\7\1\76\4\7\21\0\2\7\1\0"+
    "\1\7\3\0\3\7\1\0\6\7\1\77\2\0\3\7"+
    "\1\0\4\7\1\100\2\7\3\0\10\7\21\0\2\7"+
    "\1\0\1\7\3\0\3\7\1\0\3\7\1\101\3\7"+
    "\2\0\3\7\1\0\7\7\3\0\10\7\21\0\2\7"+
    "\1\0\1\7\3\0\3\7\1\0\7\7\2\0\1\7"+
    "\1\102\1\7\1\0\7\7\3\0\10\7\21\0\2\7"+
    "\1\0\1\7\3\0\3\7\1\0\7\7\2\0\3\7"+
    "\1\0\2\7\1\103\4\7\3\0\10\7\21\0\2\7"+
    "\1\0\1\7\3\0\3\7\1\0\7\7\2\0\3\7"+
    "\1\0\1\7\1\104\5\7\3\0\10\7\21\0\2\7"+
    "\1\0\1\7\3\0\3\7\1\0\7\7\2\0\3\7"+
    "\1\0\4\7\1\105\2\7\3\0\10\7\21\0\2\7"+
    "\1\0\1\7\3\0\3\7\1\0\7\7\2\0\3\7"+
    "\1\0\6\7\1\106\3\0\10\7\21\0\2\7\1\0"+
    "\1\7\33\0\1\107\41\0\1\6\13\0\1\6\15\0"+
    "\1\110\34\0\1\6\47\0\1\111\27\0\3\7\1\0"+
    "\2\7\1\112\4\7\2\0\3\7\1\0\7\7\3\0"+
    "\5\7\1\113\2\7\21\0\2\7\1\0\1\7\3\0"+
    "\3\7\1\0\3\7\1\114\3\7\2\0\3\7\1\0"+
    "\4\7\1\115\2\7\3\0\10\7\21\0\2\7\1\0"+
    "\1\7\3\0\3\7\1\0\7\7\2\0\3\7\1\0"+
    "\7\7\3\0\3\7\1\116\4\7\21\0\2\7\1\0"+
    "\1\7\3\0\3\7\1\0\7\7\2\0\3\7\1\0"+
    "\7\7\3\0\4\7\1\117\3\7\21\0\2\7\1\0"+
    "\1\7\46\0\1\120\27\0\1\121\3\0\7\121\2\0"+
    "\3\121\1\0\7\121\3\0\10\121\1\122\20\0\2\121"+
    "\50\0\1\123\75\0\1\124\73\0\1\125\73\0\1\126"+
    "\1\127\21\0\3\7\1\0\7\7\2\0\3\7\1\0"+
    "\7\7\3\0\4\7\1\130\3\7\21\0\2\7\1\0"+
    "\1\7\3\0\3\7\1\0\6\7\1\131\2\0\3\7"+
    "\1\0\7\7\3\0\10\7\21\0\2\7\1\0\1\7"+
    "\1\0\70\132\1\0\2\132\10\0\1\133\2\0\1\133"+
    "\23\0\1\133\43\0\1\134\2\0\1\134\23\0\1\134"+
    "\36\0\1\135\1\67\75\0\1\136\65\0\3\7\1\0"+
    "\7\7\2\0\3\7\1\0\7\7\3\0\1\7\1\137"+
    "\6\7\21\0\2\7\1\0\1\7\3\0\3\7\1\0"+
    "\7\7\2\0\3\7\1\0\7\7\3\0\4\7\1\140"+
    "\3\7\21\0\2\7\1\0\1\7\3\0\3\7\1\0"+
    "\1\7\1\141\5\7\2\0\3\7\1\0\7\7\3\0"+
    "\10\7\21\0\2\7\1\0\1\7\3\0\3\7\1\0"+
    "\7\7\2\0\3\7\1\0\7\7\3\0\1\142\7\7"+
    "\21\0\2\7\1\0\1\7\3\0\3\7\1\0\7\7"+
    "\2\0\3\7\1\0\6\7\1\143\3\0\10\7\21\0"+
    "\2\7\1\0\1\7\3\0\3\7\1\0\7\7\2\0"+
    "\3\7\1\0\7\7\3\0\2\7\1\144\5\7\21\0"+
    "\2\7\1\0\1\7\3\0\3\7\1\0\7\7\2\0"+
    "\3\7\1\0\4\7\1\145\2\7\3\0\10\7\21\0"+
    "\2\7\1\0\1\7\3\0\3\7\1\0\7\7\2\0"+
    "\3\7\1\0\7\7\3\0\1\146\7\7\21\0\2\7"+
    "\1\0\1\7\3\0\3\7\1\0\7\7\2\0\2\7"+
    "\1\147\1\0\7\7\3\0\10\7\21\0\2\7\1\0"+
    "\1\7\3\0\3\7\1\0\1\150\6\7\2\0\3\7"+
    "\1\0\7\7\3\0\10\7\21\0\2\7\1\0\1\7"+
    "\3\0\3\7\1\0\1\151\6\7\2\0\3\7\1\0"+
    "\7\7\3\0\10\7\21\0\2\7\1\0\1\7\3\0"+
    "\3\7\1\0\7\7\2\0\3\7\1\0\6\7\1\152"+
    "\3\0\10\7\21\0\2\7\1\0\1\7\3\0\3\7"+
    "\1\0\1\153\6\7\2\0\3\7\1\0\7\7\3\0"+
    "\10\7\21\0\2\7\1\0\1\7\3\0\3\7\1\0"+
    "\7\7\2\0\3\7\1\0\4\7\1\154\2\7\3\0"+
    "\10\7\21\0\2\7\1\0\1\7\3\0\3\7\1\0"+
    "\7\7\2\0\3\7\1\0\7\7\3\0\4\7\1\155"+
    "\3\7\21\0\2\7\1\0\1\7\3\0\3\7\1\0"+
    "\1\156\6\7\2\0\3\7\1\0\7\7\3\0\10\7"+
    "\21\0\2\7\1\0\1\7\3\0\3\7\1\0\6\7"+
    "\1\157\2\0\3\7\1\0\7\7\3\0\10\7\21\0"+
    "\2\7\1\0\1\7\3\0\3\121\1\0\7\121\2\0"+
    "\3\121\1\160\7\121\3\0\10\121\21\0\2\121\1\0"+
    "\1\121\1\0\52\126\1\161\20\126\70\127\1\162\2\127"+
    "\2\0\3\7\1\0\1\163\6\7\2\0\3\7\1\0"+
    "\7\7\3\0\10\7\21\0\2\7\1\0\1\7\3\0"+
    "\3\7\1\0\7\7\2\0\3\7\1\0\7\7\3\0"+
    "\1\7\1\164\6\7\21\0\2\7\1\0\1\7\73\0"+
    "\1\165\10\0\1\166\64\0\3\7\1\0\7\7\2\0"+
    "\3\7\1\0\7\7\3\0\1\167\7\7\21\0\2\7"+
    "\1\0\1\7\3\0\3\7\1\0\7\7\2\0\3\7"+
    "\1\0\7\7\3\0\1\170\7\7\21\0\2\7\1\0"+
    "\1\7\3\0\3\7\1\0\6\7\1\171\2\0\3\7"+
    "\1\0\7\7\3\0\10\7\21\0\2\7\1\0\1\7"+
    "\3\0\3\7\1\0\7\7\2\0\3\7\1\0\7\7"+
    "\3\0\4\7\1\172\3\7\21\0\2\7\1\0\1\7"+
    "\3\0\3\7\1\0\7\7\2\0\3\7\1\0\6\7"+
    "\1\173\3\0\10\7\21\0\2\7\1\0\1\7\3\0"+
    "\3\7\1\0\6\7\1\174\2\0\3\7\1\0\7\7"+
    "\3\0\10\7\21\0\2\7\1\0\1\7\3\0\3\7"+
    "\1\0\7\7\2\0\1\7\1\175\1\7\1\0\7\7"+
    "\3\0\10\7\21\0\2\7\1\0\1\7\3\0\3\7"+
    "\1\0\5\7\1\176\1\7\2\0\3\7\1\0\7\7"+
    "\3\0\10\7\21\0\2\7\1\0\1\7\3\0\3\7"+
    "\1\0\1\7\1\177\5\7\2\0\3\7\1\0\7\7"+
    "\3\0\10\7\21\0\2\7\1\0\1\7\3\0\3\7"+
    "\1\0\1\7\1\200\5\7\2\0\3\7\1\0\7\7"+
    "\3\0\10\7\21\0\2\7\1\0\1\7\3\0\3\7"+
    "\1\0\7\7\2\0\3\7\1\0\7\7\3\0\1\7"+
    "\1\201\6\7\21\0\2\7\1\0\1\7\3\0\3\7"+
    "\1\0\7\7\2\0\3\7\1\0\6\7\1\202\3\0"+
    "\10\7\21\0\2\7\1\0\1\7\3\0\3\7\1\0"+
    "\3\7\1\203\3\7\2\0\3\7\1\0\7\7\3\0"+
    "\10\7\21\0\2\7\1\0\1\7\3\0\3\7\1\0"+
    "\7\7\2\0\3\7\1\0\6\7\1\204\3\0\10\7"+
    "\21\0\2\7\1\0\1\7\41\0\1\205\32\0\52\126"+
    "\1\161\1\206\17\126\2\0\3\7\1\0\1\7\1\207"+
    "\5\7\2\0\3\7\1\0\7\7\3\0\10\7\21\0"+
    "\2\7\1\0\1\7\3\0\3\7\1\0\2\7\1\210"+
    "\4\7\2\0\3\7\1\0\7\7\3\0\10\7\21\0"+
    "\2\7\1\0\1\7\12\0\1\211\63\0\3\7\1\0"+
    "\2\7\1\212\4\7\2\0\3\7\1\0\7\7\3\0"+
    "\10\7\21\0\2\7\1\0\1\7\3\0\3\7\1\0"+
    "\7\7\2\0\3\7\1\0\7\7\3\0\1\7\1\213"+
    "\6\7\21\0\2\7\1\0\1\7\3\0\3\7\1\0"+
    "\4\7\1\214\2\7\2\0\3\7\1\0\7\7\3\0"+
    "\10\7\21\0\2\7\1\0\1\7\3\0\3\7\1\0"+
    "\7\7\2\0\3\7\1\0\7\7\3\0\2\7\1\215"+
    "\5\7\21\0\2\7\1\0\1\7\3\0\3\7\1\0"+
    "\2\7\1\216\4\7\2\0\3\7\1\0\7\7\3\0"+
    "\10\7\21\0\2\7\1\0\1\7\3\0\3\7\1\0"+
    "\7\7\2\0\3\7\1\0\7\7\3\0\1\7\1\217"+
    "\6\7\21\0\2\7\1\0\1\7\3\0\3\7\1\0"+
    "\6\7\1\220\2\0\3\7\1\0\7\7\3\0\10\7"+
    "\21\0\2\7\1\0\1\7\3\0\3\7\1\0\7\7"+
    "\2\0\3\7\1\0\7\7\3\0\7\7\1\221\21\0"+
    "\2\7\1\0\1\7\50\0\1\222\25\0\3\7\1\0"+
    "\7\7\2\0\3\7\1\0\7\7\3\0\1\7\1\223"+
    "\6\7\21\0\2\7\1\0\1\7\3\0\3\7\1\0"+
    "\7\7\2\0\3\7\1\0\7\7\3\0\3\7\1\224"+
    "\4\7\21\0\2\7\1\0\1\7\13\0\1\225\62\0"+
    "\3\7\1\0\7\7\2\0\3\7\1\0\7\7\3\0"+
    "\4\7\1\226\3\7\21\0\2\7\1\0\1\7\3\0"+
    "\3\7\1\0\3\7\1\227\3\7\2\0\3\7\1\0"+
    "\7\7\3\0\10\7\21\0\2\7\1\0\1\7\3\0"+
    "\3\7\1\0\7\7\2\0\3\7\1\0\7\7\3\0"+
    "\3\7\1\230\4\7\21\0\2\7\1\0\1\7\3\0"+
    "\3\7\1\0\7\7\2\0\3\7\1\0\7\7\3\0"+
    "\2\7\1\231\5\7\21\0\2\7\1\0\1\7\3\0"+
    "\3\7\1\0\7\7\2\0\3\7\1\0\7\7\3\0"+
    "\10\7\10\0\1\232\10\0\2\7\1\0\1\7\14\0"+
    "\1\233\61\0\3\7\1\0\7\7\2\0\3\7\1\0"+
    "\7\7\3\0\10\7\10\0\1\234\10\0\2\7\1\0"+
    "\1\7\3\0\3\7\1\0\7\7\2\0\3\7\1\0"+
    "\7\7\3\0\1\7\1\235\6\7\21\0\2\7\1\0"+
    "\1\7\57\0\1\236\30\0\1\237\134\0\1\240\31\0"+
    "\1\241\73\0\1\242\73\0\1\243\1\0\1\244\1\0"+
    "\1\245\67\0\1\246\77\0\1\247\71\0\1\250\67\0"+
    "\1\251\67\0\1\252\72\0\1\253\74\0\1\254\74\0"+
    "\1\255\50\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6844];
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
    "\4\0\1\11\11\1\1\11\2\1\1\11\17\1\1\11"+
    "\1\1\12\11\3\1\2\11\1\1\2\11\1\1\2\0"+
    "\16\1\1\11\1\1\1\11\6\1\1\11\1\0\4\11"+
    "\2\0\2\1\1\0\2\11\1\1\1\0\21\1\2\0"+
    "\1\11\2\1\1\11\1\0\16\1\1\0\3\1\1\0"+
    "\10\1\1\11\2\1\1\0\4\1\3\0\1\1\1\11"+
    "\1\1\1\11\11\0\2\11\1\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[173];
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
  public LexicoPrograma(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public LexicoPrograma(java.io.InputStream in) {
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
        case 42: 
          { yybegin(STRING); String s = string.toString(); string.setLength(0);
                                        this.yypushback(2);
                                        return new Symbol(SintaxisProgramaSym.string, yycolumn, yyline, s);
          }
        case 70: break;
        case 25: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.dosp, yycolumn, yyline, yytext());
          }
        case 71: break;
        case 56: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.scanf, yycolumn, yyline, yytext());
          }
        case 72: break;
        case 5: 
          { yybegin(STRING); return new Symbol(SintaxisProgramaSym.comilla, yycolumn, yyline, yytext());
          }
        case 73: break;
        case 40: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.menosmenos, yycolumn, yyline, yytext());
          }
        case 74: break;
        case 8: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.nott, yycolumn, yyline, yytext());
          }
        case 75: break;
        case 69: 
          { yybegin(JAVA); System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.java, yycolumn, yyline, yytext());
          }
        case 76: break;
        case 1: 
          { System.out.print(yytext());/*error*/
          }
        case 77: break;
        case 46: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.forr, yycolumn, yyline, yytext());
          }
        case 78: break;
        case 44: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.intt, yycolumn, yyline, yytext());
          }
        case 79: break;
        case 12: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.mas, yycolumn, yyline, yytext());
          }
        case 80: break;
        case 17: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.para, yycolumn, yyline, yytext());
          }
        case 81: break;
        case 67: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.vb, yycolumn, yyline, yytext());
          }
        case 82: break;
        case 39: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.masmas, yycolumn, yyline, yytext());
          }
        case 83: break;
        case 2: 
          { System.out.print(yytext()); /*IGNORAR*/
          }
        case 84: break;
        case 19: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.llavea, yycolumn, yyline, yytext());
          }
        case 85: break;
        case 33: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.andd, yycolumn, yyline, yytext());
          }
        case 86: break;
        case 62: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.printf, yycolumn, yyline, yytext());
          }
        case 87: break;
        case 6: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.punto, yycolumn, yyline, yytext());
          }
        case 88: break;
        case 52: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.javaa, yycolumn, yyline, yytext());
          }
        case 89: break;
        case 30: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.iff, yycolumn, yyline, yytext());
          }
        case 90: break;
        case 26: 
          { string.append(yytext()); yybegin(ST);
          }
        case 91: break;
        case 58: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.whilee, yycolumn, yyline, yytext());
          }
        case 92: break;
        case 36: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.igig, yycolumn, yyline, yytext());
          }
        case 93: break;
        case 3: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.id, yycolumn, yyline, yytext());
          }
        case 94: break;
        case 31: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.vbb, yycolumn, yyline, yytext());
          }
        case 95: break;
        case 51: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.elsee, yycolumn, yyline, yytext());
          }
        case 96: break;
        case 18: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.parc, yycolumn, yyline, yytext());
          }
        case 97: break;
        case 66: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.clrs, yycolumn, yyline, yytext());
          }
        case 98: break;
        case 27: 
          { yybegin(YYINITIAL);
                                        return new Symbol(SintaxisProgramaSym.comilla, yycolumn, yyline, yytext());
          }
        case 99: break;
        case 61: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.switchh, yycolumn, yyline, yytext());
          }
        case 100: break;
        case 20: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.llavec, yycolumn, yyline, yytext());
          }
        case 101: break;
        case 21: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.cora, yycolumn, yyline, yytext());
          }
        case 102: break;
        case 59: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.breakk, yycolumn, yyline, yytext());
          }
        case 103: break;
        case 38: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.mayorig, yycolumn, yyline, yytext());
          }
        case 104: break;
        case 14: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.por, yycolumn, yyline, yytext());
          }
        case 105: break;
        case 57: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.floatt, yycolumn, yyline, yytext());
          }
        case 106: break;
        case 53: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.voidd, yycolumn, yyline, yytext());
          }
        case 107: break;
        case 63: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.defaultt, yycolumn, yyline, yytext());
          }
        case 108: break;
        case 35: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.noigual, yycolumn, yyline, yytext());
          }
        case 109: break;
        case 9: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.igual, yycolumn, yyline, yytext());
          }
        case 110: break;
        case 23: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.coma, yycolumn, yyline, yytext());
          }
        case 111: break;
        case 16: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.mod, yycolumn, yyline, yytext());
          }
        case 112: break;
        case 49: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.casee, yycolumn, yyline, yytext());
          }
        case 113: break;
        case 48: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.character, yycolumn, yyline, yytext().substring(1, yytext().length() - 1));
          }
        case 114: break;
        case 22: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.corc, yycolumn, yyline, yytext());
          }
        case 115: break;
        case 68: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.py, yycolumn, yyline, yytext());
          }
        case 116: break;
        case 50: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.charr, yycolumn, yyline, yytext());
          }
        case 117: break;
        case 45: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.doo, yycolumn, yyline, yytext());
          }
        case 118: break;
        case 15: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.div, yycolumn, yyline, yytext());
          }
        case 119: break;
        case 64: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.getch, yycolumn, yyline, yytext());
          }
        case 120: break;
        case 54: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.mainn, yycolumn, yyline, yytext());
          }
        case 121: break;
        case 41: 
          { return new Symbol(SintaxisProgramaSym.string, yycolumn, yyline, yytext());
          }
        case 122: break;
        case 28: 
          { string.append(yytext());
          }
        case 123: break;
        case 55: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.constt, yycolumn, yyline, yytext());
          }
        case 124: break;
        case 43: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.decimal, yycolumn, yyline, yytext());
          }
        case 125: break;
        case 65: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.includee, yycolumn, yyline, yytext());
          }
        case 126: break;
        case 60: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.idlib, yycolumn, yyline, yytext());
          }
        case 127: break;
        case 29: 
          { yybegin(STRING); String s = string.toString(); string.setLength(0);
                                        this.yypushback(1);
                                        return new Symbol(SintaxisProgramaSym.string, yycolumn, yyline, s);
          }
        case 128: break;
        case 24: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.puntocoma, yycolumn, yyline, yytext());
          }
        case 129: break;
        case 37: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.menorig, yycolumn, yyline, yytext());
          }
        case 130: break;
        case 7: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.asig, yycolumn, yyline, yytext());
          }
        case 131: break;
        case 4: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.entero, yycolumn, yyline, yytext());
          }
        case 132: break;
        case 10: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.menor, yycolumn, yyline, yytext());
          }
        case 133: break;
        case 32: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.pyy, yycolumn, yyline, yytext());
          }
        case 134: break;
        case 47: 
          { System.out.print(yytext()); /*return new Symbol(SintaxisProgramaSym.com, yycolumn, yyline, yytext());*/
          }
        case 135: break;
        case 13: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.menos, yycolumn, yyline, yytext());
          }
        case 136: break;
        case 34: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.orr, yycolumn, yyline, yytext());
          }
        case 137: break;
        case 11: 
          { System.out.print(yytext()); return new Symbol(SintaxisProgramaSym.mayor, yycolumn, yyline, yytext());
          }
        case 138: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(SintaxisProgramaSym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
