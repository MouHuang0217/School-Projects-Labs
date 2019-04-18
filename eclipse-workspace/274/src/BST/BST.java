package BST;
import java.util.Scanner;
public class BST {
	private Node root;
	static int[] array = new int[100];
	int value = 0;
	public BST() {
		Node root = null;
	}
	public void Sort(Node n, int index, int[] array) {
		array[index] = n.getValue();
		Sort(n.getLeft(),2*index,array);
		Sort(n.getRight(),2*index+1,array);
	}
		
	private void add(int v) {
		if (root == null) {
			root = new Node(v);
		}
		else {
			addToNode(root, v);
		}
	}
	private void addToNode(Node n, int value) {
		if (value <= n.getValue()) {
			if (n.getLeft() == null ) {
				n.setLeft(new Node(value));
			}
			else {
				addToNode(n.getLeft(),value);
			}
		}
		else {
			if(n.getRight() == null)
				n.setRight(new Node(value));
			else 
				addToNode(n.getRight(),value);
		}
	}
	public int height() {
		return height(root);
	}
	private int height(Node n) {
		int max = 0;
		if (n == null) {
			return max;
		}
		else {
			int left = height(n.leftC);
			int right = height(n.rightC);
			max = (left > right) ? left:right;
		}
		return max + 1;
	}
	public int getHeight(Node root, int value) {
		return getHeight(root,value,1);
	}
	private int getHeight(Node root, int value, int level) {
		if (root == null) {
			return 0;
		}
		if (root.getValue() == value) {
			return level;
		}
		int lowerlevel = getHeight(root.leftC,value,level +1);
		if (lowerlevel != 0) {
			return lowerlevel;
		}
		lowerlevel = getHeight(root.rightC,value,level+1);
		return lowerlevel;
	}
	public int root() {
		if (root == null) {
			return 0;
		}
		else {
			return root.getValue();
		}
	}
	private int itemCount() {
		int count = getCount (0, root);
		return count;
	}
	private int getCount(int x, Node n) {
		if (n == null) {
			return 0;
		}
		else {
			return getCount(x,n.getLeft()) + getCount(x,n.getRight()) +1 ;
		}
	}
	public int[] inOrder() {
		array = LNR(root);
		return array;
	}
	private int[] LNR(Node root) {
		if (root != null) {
			LNR(root.getLeft());
			System.out.print(root.getValue() + " " );
			array[value++] = root.getValue();
			LNR(root.getRight());
		}
		return array;
		
	}
	
	public void removeNumber (int v) {
		root = delete(root, v);
	}
	private Node delete (Node root, int value) {
		if (root == null) {
			return root;
		}
		if (value < root.getValue()) {
			root.leftC = delete(root.leftC,value);
		}
		else if (value > root.getValue()) {
			root.rightC = delete(root.rightC,value);
		}
		else {
			if (root.leftC == null)
				return root.rightC;
			else if (root.rightC == null)
				return root.leftC;
			
			root.value = succ(root.rightC);
			root.rightC = delete(root.rightC, root.getValue());
		}
		return root;
	}
	
	public int succ(Node root) {
		int succ = root.getValue();
		while (root.leftC != null)
		{
			succ = root.leftC.getValue();
			root = root.leftC;
		}
		return succ;
	}
	public static void initTree(int[] myArray) {
		System.out.println("                                                         " + myArray[15]);
        System.out.println("                                                         |");
        System.out.println("                              " + myArray[7] + "-------------------------" + "^" + "-------------------------" + myArray[22]);
        System.out.println("                              |" + "                                                     |" );
        System.out.print("                  " + myArray[3] + "-----------" + "^" + "-----------"  + myArray[11]);
        System.out.print("                           " + myArray[18] + "-----------" + "^" + "-----------"  + myArray[27]);
        System.out.println("\n                   |                             |" + "                      |                        |" );
        System.out.print("            " + myArray[2] + " ----^" + "---- " + myArray[5]);
        System.out.print("          " + myArray[9] + " ----^" + "----" + myArray[13]);
        System.out.print("               " + myArray[17] + " ----^" + "---- " + myArray[20]);
        System.out.print("         " + myArray[24] + " ----^" + "---- " + myArray[29]);
        System.out.print("\n         " + myArray[1] + " -^- " + myArray[4]);
        System.out.print("   " + myArray[4] + " -^- " + myArray[6]);
        System.out.print("     " + myArray[8] + " -^- " + myArray[10] + "   ");
        System.out.print(myArray[12] + " -^- " + myArray[14]);
        System.out.print("      " + myArray[16] + " -^- " + myArray[27] + "     ");
        System.out.print(myArray[19] + " -^- " + myArray[21]);
        System.out.print("   " + myArray[23] + " -^- " + myArray[25] + "    ");
        System.out.print(myArray[28] + " -^- " + myArray[30]);

	}
	public void NLR(){
		printPreorder(root);
	}
	void printPreorder(Node node) 
	   { 
		if( node == null)
			return;
	    System.out.print(node.getValue() + " ");
	    printPreorder(node.leftC); 
	    printPreorder(node.rightC); 
	    } 
	public static void main(String[] args) {
		BST tree = new BST() ;		
		int[] array = new int[] {1, 10 ,17, 20, 21, 27, 28, 29, 31, 33, 34, 36, 41, 42, 43, 45, 48, 50, 51, 57, 65, 70, 73, 75, 79, 80, 81, 87, 90, 98, 99 };
		for (int value: array) {
				tree.add(value);
		}
		Scanner userInput = new Scanner(System.in);
		char choice = menu(tree);
		while (choice != 'Q') {
			switch (choice) {
			case 'A':
			case 'a':
				System.out.println("Enter a positive #: ");
				int Anum = userInput.nextInt();
				if(Anum >= 0) {
					tree.add(Anum);
				}
				initTree(array);
				choice = menu(tree);
				break;
			case 'R':
			case 'r':
				System.out.println("What number do you want to Remove? :");
				int Dnum = userInput.nextInt();
				tree.removeNumber(Dnum);
				initTree(array);
				choice = menu(tree);
				break;
			case 'F':
			case 'f':
				System.out.println("What number do you want to find?");
				int Fnum = userInput.nextInt();
				if (tree.getHeight(tree.root, Fnum) != 0) {
					System.out.println("The number was found on level: " + tree.getHeight(tree.root,Fnum));
					
				}
				choice = menu(tree);
				break;
			case 'I':
			case 'i': 
				//tree.Sort(array, 0 , array.length-1);
				System.out.println("");
				initTree(array);
				choice = menu(tree);
				break;
			case 'N':
			case 'n':
				tree = new BST();
				choice = menu(tree);
				break;
			case 'Q':
			case 'q':
				break;
			}
		}
	}
		
	public static char menu(BST tree) {
		//System.out.println("\nNLR:");
		//tree.NLR();
		System.out.println("\n");
		System.out.print("\nINORDER:");
		int[] x = tree.inOrder();
		//BST.initTree(x);
		System.out.printf("\nTree height: 5",tree.height());
		System.out.printf("\nRoot Value: %d", array[15]);
		System.out.printf("\nItem Count: %d", tree.itemCount());
		System.out.println("\n\n(A)dd item \t (R)emove Item \t (F)ind item \t (I)nitialize Tree \t (N)ew Tree \t (Q)uit");
		Scanner userInput = new Scanner(System.in);
		char choice = userInput.next().charAt(0);
		return choice;
	}

}
