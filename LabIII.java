/**************************************************************
 * Morgan Buford
 * COSC 2336
 * Lab III: Convert infix expressions to postfix and evaluate
 * Due April 2, 2015
 *************************************************************/
 import java.io.*;
 
 public class LabIII
 {
 	public static String line;
 	
 	public static void main(String[] args) throws IOException
 	{ 		
 		try
		{
    		BufferedReader input = new BufferedReader(new FileReader("input.txt")); // Create input reader
			
			char token;
			int tokenI;
			char popOp;
			int popInt1;
			int popInt2;
			int result;
			int index;
			
    		while ((line = input.readLine()) != null) // While the input file still has a line with characters
    		{
    			operatorStack opStack = new operatorStack(); // Initalize the operator stack
				opStack.push(';'); // Push a ';' to the stack
    			operandStack intStack = new operandStack();
    			index = 0;
    			
    			// while the current count has not reached the end of the expression
    			while(index < line.length())
    			{
    				// If the character at [index] is a digit
    				// then print it and push it onto the operand stack
	    			if(Character.isDigit(line.charAt(index)))
	    			{
	    				tokenI = line.charAt(index)-48;
	    				System.out.print(tokenI);
	    				intStack.push(tokenI);
	    				index++;
	    			}
	    			else
	    			{
	    				token = line.charAt(index);
	    				
	    				if(token == ')')
			    		{	
			    			// If there is no '(', evaluate the next result
		    				while(opStack.peek() != '(')
		    				{
		    					popOp = opStack.pop();
		    					System.out.print(popOp);
		    					popInt1 = intStack.pop();
		    					popInt2 = intStack.pop();
		    					result = evaluate(popInt1, popInt2, popOp);
		    					intStack.push(result);    						
		    				}
		    				opStack.pop(); // Pop the "(" and discard it
		    				index++;
			    		}
		    			else
		    			{
		    				// If the input priority is less than or equal to the stack priority
		    				// evaluate the next two operands with the next operator
		    				while(inputPriority(token) <= stackPriority(opStack.peek()))
		    				{
		    					popOp = opStack.pop();
		    					System.out.print(popOp);
		    					popInt1 = intStack.pop();
		    					popInt2 = intStack.pop();
		    					result = evaluate(popInt1, popInt2, popOp);
		    					intStack.push(result);
		    				}
		    				opStack.push(token);
		    				index++;
	    				}
	    			}
    			}
    			
    			// If the top of the operand stack is not ';',
    			// then do the next evaluation with two operands
    			// and an operation
    			while (opStack.peek() != ';')
				{
					popOp = opStack.pop();
					System.out.print(popOp);
					popInt1 = intStack.pop();
					popInt2 = intStack.pop();
					result = evaluate(popInt1, popInt2, popOp);
					intStack.push(result);
				}
	    			
	    		System.out.print(" = " + intStack.pop());
	    		System.out.println();
    		}
		}
		
		catch (IOException ex)
		{
			System.err.println("Exception:" + ex);
		}
 	}
 	
 	// Evaluate the result of two operands and an operator
 	public static int evaluate(int popInt1, int popInt2, char popOp)
 	{
 		int int1 = popInt1;
 		int int2 = popInt2;
 		char op = popOp;
 		int result = 1;
 		
 		if(op == '+')
 		{
 			result = int2 + int1;
 		}
 		else if(op == '-')
 		{
 			result = int2 - int1;
 		}
 		else if(op == '*')
 		{
 			result = int2 * int1;
 		}
 		else if(op == '/')
 		{
 			result = int2 / int1;
 		}
 		
 		return result;
 	}
 	
 	public static int inputPriority(char token) // Determine input priority of operators
 	{
 		switch (token)
 		{
 			case '+':
 				return 2;
 			case '-':
 				return 2;
 			case '*':
 				return 3;
 			case '/':
 				return 3;
 			case '(':
 				return 4;
 			default:
 				return 4;
 		}
 	}
 	
 	public static int stackPriority(char peek) // Determine stack priority of operators
 	{
 		switch (peek)
 		{
 			case ';':
 				return 0;
 			case '+':
 				return 2;
 			case '-':
 				return 2;
 			case '*':
 				return 3;
 			case '/':
 				return 3;
 			case '(':
 				return 1;
 			default: 
 				return 0;
 		}
 	}
 }