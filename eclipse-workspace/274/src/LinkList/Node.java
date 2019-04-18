package LinkList;

public class Node {
	private int value;
	private Node next;

	public Node (int v) 
	{
		value = v;
		next = null;
	}
	public int getValue ()
	{
		return value;
	}
	public void setNext (Node n)
	{
		next = n;
	}
	public void display()
	{
		System.out.print(value + " ");
	}
	public Node getNext() {
		return next;
	}
	
	
	
	
}
