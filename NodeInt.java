/************************************************************
 * Morgan Buford
 * COSC 2336
 * Lab III: Create a Node object to implement the
 * reference based stack for integers
 * Due April 2, 2015
 ***********************************************************/
 
 public class NodeInt{
 	
 	private int item;
 	private NodeInt next;
 	
 	public NodeInt(int newItem)
 	{
 		item = newItem;
 		next = null;
 	}
 	
 	public NodeInt(int newItem, NodeInt nextNode)
 	{
 		item = newItem;
 		next = nextNode;
 	}
 	
 	public int getItem()
	{
		return item;
	}
 	
 	public void setNext(NodeInt nextNode)
	{
		next = nextNode;
	}

 	public NodeInt getNext()
	{
		return next;
	}
 }