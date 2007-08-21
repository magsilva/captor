package captor.projectsystem.build.buildutil.interpreter;



public class Lexer {
    
    private char []input;
    private Symbol token;
    
    private int  tokenPos;
    
    private Eval eval;
    
    public Lexer(char []input, Eval eval) {
        this.eval = eval;
        init(input);
    }
    
    public Lexer(String str, Eval eval) {
        this.eval = eval;
        init(str.toCharArray());
    }
    
    
    //-------------------------------------------------------------------------
    
    private void init(char []input)  {
        String aux = new String(input);
        aux = aux.concat("\0");
        this.input = aux.toCharArray();
        
        tokenPos = 0;
    }
    
    //-------------------------------------------------------------------------
    
    public void nextToken() {
        char ch = input[tokenPos];
        
        while (  ch == ' ' || ch == '\r' || ch == '\t' || ch == '\n' )  {
            tokenPos++;
            ch = input[tokenPos];
        }
        
        if ( ch == '\0' )  { 
            token = new Symbol(Symbol.EOF);
            return;
        }
        
        if ( isIdentChar(input[tokenPos]) ) {
            
            StringBuffer ident = new StringBuffer();
            
            while ( isIdentChar(input[tokenPos]) && input[tokenPos] != '\0' ) {
                ident.append(input[tokenPos]);
                tokenPos++;
            }
            
            token =  new Symbol( Symbol.IDENT, ident);
            return;
        } 
        
        switch ( input[tokenPos] ) {
        case '\'' :
            StringBuffer ident = new StringBuffer();
            tokenPos++;
            
            while ( input[tokenPos] != '\'' && input[tokenPos] != '\0' ) {
                ident.append(input[tokenPos]);
                tokenPos++;
            }
            
            token =  new Symbol( Symbol.IDENT, "'" + ident + "'");
            break;
        case '(' :
            token = new Symbol( Symbol.LEFTPAR );
            break;
        case ')' :
            token = new Symbol( Symbol.RIGHTPAR );
            break;
        case ',' :
            token = new Symbol( Symbol.COMMA );
            break;
        default :
            eval.setRet(false);
        eval.setErrorMsg("Invalid Character: '" + ch + "'");
        return;
        }
        
        tokenPos++;
        return;
    }
    
    //-------------------------------------------------------------------------
    
//    private boolean isLiteralChar(char c)  {
//        if ( c != '(' && c != ')' && c != ',' & c != '\'' ) {
//            return true;
//        }
//        
//        return false;
//    }

    //-------------------------------------------------------------------------

    private boolean isIdentChar(char c)  {
        if ( c != '(' && c != ')' && c != ',' & c != '\'' && c != ' ') {
            return true;
        }
        
        return false;
    }
    
    //-------------------------------------------------------------------------
    
    public int getColumn() {
        return tokenPos;
    }
    
    //-------------------------------------------------------------------------
    
    public Symbol getToken() {
        return token;
    }
    
    //-------------------------------------------------------------------------
    
    public char[] getInput()  {return input;}
    
    //-------------------------------------------------------------------------
    }
