/************************************************************
 * Morgan Buford
 * COSC 2336
 * Lab III: Create a Node object to implement the
 * reference based stack for characters
 * Due April 2, 2015
 ***********************************************************/
 
 public class Node{
 	
 	private char item;
 	private Node next;
 	
 	public Node(char newItem)
 	{
 		item = newItem;
 		next = null;
 	}
 	
 	public Node(char newItem, Node nextNode)
 	{
 		item = newItem;
 		next = nextNode;
 	}
 	
 	public char getItem()
	{
		return item;
	}
 	
 	public void setNext(Node nextNode)
	{
		next = nextNode;
	}

 	public Node getNext()
	{
		return next;
	}
 }