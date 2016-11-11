/************************************************************
 * Morgan Buford
 * COSC 2336
 * Lab III: Operator stack made of character Nodes
 * Due April 2, 2015
 ***********************************************************/
 
 public class operatorStack implements Stack
 	{
		char charac;
		Node top;
		Node temp;
 		
	 	public operatorStack() // Default constructor: empty stack
	 	{
	 		top = null;
	 	}
	 	
	 	public boolean isEmpty() // Returns true if the top of the stack is null
	 	{
	 		return top == null;
	 	}
	 	
	 	public void push(char charac) // Push an item onto the top of the stack
	 	{
	 		top = new Node(charac, top);
	 	}
	 	
	 	public char pop()
	 	{
	 		Node temp = top;
	 		top = top.getNext();
	 		return temp.getItem();
	 	}
	 	
	 	public void popAll()
	 	{
	 		top = null;
	 	}
	 	
	 	public char peek()
	 	{
	 		return top.getItem();
	 	}	 	
 	}