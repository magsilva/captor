package captor.projectsystem.build.buildutil.interpreter;

public class Symbol {

    public Symbol( int tokenNumber ) {
        tk = tokenNumber;
        value = null;
    }
    public Symbol( int tokenNumber, Object value ) {
        this.tk = tokenNumber;
        this.value = value;
    }
    
    public Object getValue() { return value; }
    
      // don't ever use public variables. Your grade will
      // be decreased by that. 
      // tk is the numeric value of the token such as
      // Symbol.IDENT
    public int tk;
    
      // value of the token. For example, if tk is Symbol.IDENT,
      // value will be a String with the identifier.
      // if tk == Symbol.IDENT, value is an Integer object 
      // with the number value.
    private Object value;
    
    public final static int 
      EOF = 0,
      IDENT = 1,
      NUMBER = 2,
      PLUS = 3,
      MINUS = 4,
      MULT = 5,
      DIV = 6,
      LT = 7,
      LE = 8,
      GT = 9,
      GE = 10,
      NEQ = 11,
      EQ = 12,
      ASSIGN = 13,
      LEFTPAR = 14,
      RIGHTPAR = 15,
      SEMICOLON = 16,
      VAR = 17,
      BEGIN = 18,
      END = 19,
      IF = 20,
      THEN = 21,
      ELSE = 22,
      ENDIF = 23,
      COMMA = 24,
      READ = 25,
      WRITE = 26,
      COLON = 27,
      INTEGER = 28,
      BOOLEAN = 29,
      CHAR = 30,
      CHARACTER = 31,
      TRUE = 32,
      FALSE = 33,
      OR    = 34,
      AND   = 35,
      REMAINDER = 36,
      NOT = 37,
      PROCEDURE = 38,
      FUNCTION = 39,
        // the following symbols are used only at error treatment
      CURLYLEFTBRACE = 40,
      CURLYRIGHTBRACE = 41,
      LEFTSQBRACKET = 42,
      RIGHTSQBRACKET = 43,
        // other symbols
      FOR = 44,
      WHILE = 45,
      TO = 46,
      DO = 47,
      RETURN = 48,
        // new symbols should be added before LastSymbol, which is used as the number
        // of constantes in this class
      LastSymbol = 49,
      
      DOLLAR = 50,
      LITERAL = 52;
}