package jscf.treegen;
import java.io.File;
import java.util.Scanner;
 
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import jscf.treegen.antlr.grammar.java.JavaParser;




public class JavaParserTest
{
 
	private static Scanner scanner;

	public static void main(String[] args) throws Exception 
	{
	    scanner = new Scanner(new File("src/jscf/treegen/JavaClassTest.java"));
		String content = scanner.useDelimiter("\\Z").next();
	   // System.out.println( "Java File:\n" + content + "\n\n");
	    
		ANTLRInputStream input = new ANTLRInputStream( content );
		
		JavaLexer lexer = new JavaLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		JavaParser parser = new JavaParser(tokens);
		
		ParseTree tree = parser.compilationUnit();
		
		System.out.println( "ParseTree:\n" + tree.toStringTree( parser ) + "\n"); 
		AST ast = new AST( tree );
		
		System.out.println( "Abstract Syntax Tree:\n" + ast.toString() );
		
	}
	
}

	