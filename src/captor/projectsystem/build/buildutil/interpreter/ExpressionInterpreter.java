package captor.projectsystem.build.buildutil.interpreter;

import captor.projectsystem.build.buildutil.interpreter.ast.Function;
import captor.projectsystem.build.buildutil.interpreter.ast.Parameters;
import captor.projectsystem.build.mapper.MapperException;

/**
       This class intepret the language defined below.
       
       FunctionCall ::= Function '(' ParameterList ')'
       
       Function ::= 'equal' | not-equal | exists
       ParameterList ::=  | Parameter { ',' Parameter } 
       
       Parameter ::= StringLiteral | XPathExpr

       StringLiteral ::= '{Literal}'
       XPathExpr ::= {'/'Ident}
       
       Literal :: { Letter | Digit | Symbol }
       Ident ::= Letter { Letter | Digit } 
       
       Digit ::= '0'| '1' | ... | '9'
       Letter ::= 'A' | 'B'| ... | 'Z'| 'a'| 'b' | ... | 'z'
       Symbol ::= {Letter | Digit | '!' | '@' | '#' | '$' | '%' | '&' ... '*' | '(' | ')'}
       
       ------------------------------------------------------------------------

		Examples:
                  
		<!--
		<if test="exist(/pldata/patterns/pattern/pattern)">
		<if test="equal(/pldata/patterns/pattern/pattern, 'value')">
		<if test="not-equal(/pldata/patterns/pattern/pattern, 'value')">
		-->
		<if test="exist(/pldata/patterns/pattern/pattern)">
			<callTask id="second"/>
		</if>
		
		@author Kicho
*/
public class ExpressionInterpreter {

    private Lexer lexer;
    private Eval eval;
    
    public ExpressionInterpreter(String input) {
        eval = new Eval(true, "");
        lexer = new Lexer(input, eval);
    }

    //-------------------------------------------------------------------------

    public Function parseFunction() throws MapperException  {
        lexer.nextToken();
        try {
			return function();
		} catch (MapperException e) {
			throw new MapperException(e, "");
		}
    }

    //-------------------------------------------------------------------------
    
    private Function function() throws MapperException {
        if ( lexer.getToken().tk != Symbol.IDENT )  {
            throw new MapperException(MapperException.FUNCTION_IDENT_NAME_ERROR, "The first letter of this expression must be a valid function name.");
        }
        
        if ( lexer.getToken().getValue().toString().equals("exists") )  {
            lexer.nextToken();
            return exists();
        }
        else if ( lexer.getToken().getValue().toString().equals("equal") )  {
            lexer.nextToken();
            return equal();
        }
        else if ( lexer.getToken().getValue().toString().equals("not-equal") )  {
            lexer.nextToken();
            return notEqual();
        }
         
        throw new MapperException(MapperException.FUNCTION_NAME_ERROR, "The first letter of this expression ('" + lexer.getToken().getValue().toString() + "') must be a valid function name. Examples: exists, equal, not-equals.");
    }
    
    //-------------------------------------------------------------------------

    private Function exists() throws MapperException {
        
        if ( lexer.getToken().tk != Symbol.LEFTPAR )  {
            throw new MapperException(MapperException.LEFT_PAR_EXPECTED_ERROR, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'(' expected.");
        }
        
        String parameter = "";
        lexer.nextToken();
        if ( lexer.getToken().tk != Symbol.IDENT )  {
            throw new MapperException(MapperException.IDENT_EXPECTED_ERROR, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;identifier expected.");
        }
        parameter = lexer.getToken().getValue().toString();
        
        if ( parameter.substring(0,1).equals("'") )  {
        	throw new MapperException(MapperException.IDENT_EXPECTED_ERROR, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;XPath expression expected.");
        }
        
        
        lexer.nextToken();
        if ( lexer.getToken().tk != Symbol.RIGHTPAR )  {
            throw new MapperException(MapperException.RIGHT_PAR_EXPECTED_ERROR, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;')' expected.");
        }
        
        lexer.nextToken();
        if ( lexer.getToken().tk != Symbol.EOF )  {
            throw new MapperException(MapperException.EOF_EXPECTED_ERROR, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'EOF' expected.");
        }
         
        Parameters parameters = new Parameters();
        parameters.add(parameter);
        Function function = new Function("exists", parameters);
        return function;
    }

    //-------------------------------------------------------------------------

    private Function equal()  throws MapperException{
        String parameter1 = "";
        String parameter2 = "";
        if ( lexer.getToken().tk != Symbol.LEFTPAR )  {
            throw new MapperException(MapperException.LEFT_PAR_EXPECTED_ERROR, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'(' expected.");
        }
        
        lexer.nextToken();
        if ( lexer.getToken().tk != Symbol.IDENT )  {
            throw new MapperException(MapperException.IDENT_EXPECTED_ERROR, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Identifier expected.");
        }
        
        parameter1 = lexer.getToken().getValue().toString(); 

        lexer.nextToken();
        if ( lexer.getToken().tk != Symbol.COMMA )  {
            throw new MapperException(MapperException.COMMA_EXPECTED_ERROR, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;comma expected.");
        }

        lexer.nextToken();
        if ( lexer.getToken().tk != Symbol.IDENT )  {
            throw new MapperException(MapperException.IDENT_EXPECTED_ERROR, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;identifier expected.");
        }
        
        parameter2 = lexer.getToken().getValue().toString(); 

        lexer.nextToken();
        if ( lexer.getToken().tk != Symbol.RIGHTPAR )  {
            throw new MapperException(MapperException.RIGHT_PAR_EXPECTED_ERROR, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;')' expected.");
        }
        
        lexer.nextToken();
        if ( lexer.getToken().tk != Symbol.EOF )  {
            throw new MapperException(MapperException.EOF_EXPECTED_ERROR, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'EOF' expected.");
        }
        
        Parameters parameters = new Parameters();
        parameters.add(parameter1);
        parameters.add(parameter2);
        Function function = new Function("equal", parameters);
        return function;
    }

    //-------------------------------------------------------------------------

    private Function notEqual()  throws MapperException {
        String parameter1 = "";
        String parameter2 = "";
        if ( lexer.getToken().tk != Symbol.LEFTPAR )  {
            throw new MapperException(MapperException.LEFT_PAR_EXPECTED_ERROR, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'(' expected.");
        }
        
        lexer.nextToken();
        if ( lexer.getToken().tk != Symbol.IDENT )  {
            throw new MapperException(MapperException.IDENT_EXPECTED_ERROR, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;identifier expected.");
        }
        
        parameter1 = lexer.getToken().getValue().toString(); 

        lexer.nextToken();
        if ( lexer.getToken().tk != Symbol.COMMA )  {
            throw new MapperException(MapperException.COMMA_EXPECTED_ERROR, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;comma expected.");
        }

        lexer.nextToken();
        if ( lexer.getToken().tk != Symbol.IDENT )  {
            throw new MapperException(MapperException.IDENT_EXPECTED_ERROR, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;identifier expected.");
        }
        
        parameter2 = lexer.getToken().getValue().toString(); 

        lexer.nextToken();
        if ( lexer.getToken().tk != Symbol.RIGHTPAR )  {
            throw new MapperException(MapperException.RIGHT_PAR_EXPECTED_ERROR, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;')' expected.");
        }
        
        lexer.nextToken();
        if ( lexer.getToken().tk != Symbol.EOF )  {
            throw new MapperException(MapperException.EOF_EXPECTED_ERROR, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'EOF' expected.");
        }
        
        Parameters parameters = new Parameters();
        parameters.add(parameter1);
        parameters.add(parameter2);
        Function function = new Function("not-equal", parameters);
        return function;
    }
    
    //-------------------------------------------------------------------------
}
