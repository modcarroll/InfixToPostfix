/************************************************************
 * Morgan Buford
 * COSC 2336
 * Lab III: Operand stack made of integer Nodes
 * Due April 2, 2015
 ***********************************************************/
 
 public class operandStack implements Stack
 	{
 		int integ;
		NodeInt top;
		NodeInt temp;
		
	 	public operandStack() // Default constructor: empty stack
	 	{
	 		top = null;
	 	}
		
	 	public boolean isEmpty() // Returns true if the top of the stack is null
	 	{
	 		return top == null;
	 	}
		
	 	public void push(int integ) // Push an item onto the top of the stack
	 	{
	 		top = new NodeInt(integ, top);
	 	}
	 	
	 	public int pop()
	 	{
	 		NodeInt temp = top;
	 		top = top.getNext();
	 		return temp.getItem();
	 	}
	 	
	 	public void popAll()
	 	{
	 		top = null;
	 	}
	 	
	 	public int peek()
	 	{
	 		return top.getItem();
	 	}	 	
 	}