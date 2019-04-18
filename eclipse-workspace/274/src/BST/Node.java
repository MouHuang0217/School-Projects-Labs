package BST;

public class Node {
	int value;
	Node leftC;
	Node rightC;
	
	public Node (int v) {
		value = v;
		leftC = null;
		rightC = null;
	}
	
	public int getValue() {
		return value;
	}
	public Node getRight() {
		return rightC;
	}
	public Node getLeft() {
		return leftC;
	}
	public void setRight(Node n) {
		rightC = n;
	}
	public void setLeft(Node n) {
		leftC = n;
	}

}

