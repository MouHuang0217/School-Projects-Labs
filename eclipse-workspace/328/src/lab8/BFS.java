package lab8;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.*; 
public class BFS{
	
	public static boolean existVertex(ArrayList<Node> graph, Node node) {
		for(Node n :graph) {
			if(n.getName().equals(node.getName()))
			{
				return true;
			}
		}
		return false;
	}
	public static Node randomNode(ArrayList<Node> graph) {
		  Random rand = new Random(); 
		  return graph.get(rand.nextInt(graph.size())); 
	}
	public static ArrayList<Node> createGraph() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("\nHow many vertices? ");
		int size = userInput.nextInt();
		System.out.println("How many edges");
		int edges = userInput.nextInt();
		
		ArrayList<Node> graph = new ArrayList<Node>();
		int i = 0;
		char x = 'a';
		while(i < size) {
			String string = Character.toString(x);
			Node node = new Node(string);
			x += 1;
			if(!existVertex(graph,node)) {
				graph.add(node);
				i++;
			}			
		}
		
		i = 0;
		while(i < edges) {
			Node node = randomNode(graph);
			addEdges(graph,node);
			i++;
		}
		
		printGraph(graph);
		return graph;
	}
	private static void addEdges(ArrayList<Node> graph,Node node) {
		Random r = new Random();
		int size = graph.size();
		
		Node n = graph.get(r.nextInt(size));
		while(n.getName().equals(node.getName()) || n.inAdjList(node) || node.inAdjList(n)){
			r = new Random();
			n = graph.get(r.nextInt(size));
		}
		
		
		//System.out.println(n.getName() +"is added to " + node.getName());
		n.addAdj(node);
	}
	public static void printGraph(ArrayList<Node> graph) {
		System.out.println("printed graph: ");
		for(int i = 0; i < graph.size(); i++) {
			System.out.print("ind " + i + " " + graph.get(i).getName() + " ADJ list: ");
			for(Node j: graph.get(i).getAdjList()) {
				System.out.print(j.getName() + ", ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		ArrayList<Node> graph = createGraph();
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("What index do you want to start in? ");
		int index = userInput.nextInt();
		Node node = graph.get(index);
		
		
		bfs(node);
		for (Node i: graph) {
			System.out.println("\nDistance: " +i.getDistance() + " From " + node.getName() +" to " + i.getName());

			while(i.getParent() != null) {
				if(i.getDistance() != 0) {
					System.out.print(i.getName() + " <- ");
					i = i.getParent();
				}
			}
			System.out.print(node.getName());
		}
	
		
		graph = createGraph();
		System.out.println("What index do you want to start in? ");
		index = userInput.nextInt();
		node = graph.get(index);
		dfs(node,graph);
		
		for(Node i:graph) {
			System.out.println(i.getName() + ": startTime: " + i.getStartTime() + " endTime : " + i.getEndTime());
		}
		
		System.out.println("topological :");
		if(flag == true) {
			topologicalOrder();
		}
		else {
			System.out.println("Cycle is detected Topological sort is impossible");	
		}
		
	}
	public static void bfs(Node v) {
		ArrayList<Node> queue = new ArrayList<Node>();
 		queue.add(v);
		while(!queue.isEmpty()) {
			Node vert = queue.remove(0);
			for(Node i: vert.getAdjList()) {
				if(i.getParent() == null) {
					i.setParent(vert);
					queue.add(i);
					i.setDistance(vert.getDistance() + 1);
				}
			}
		}
	}
	
	
	static Stack<Node> stack = new Stack<Node>();
	static boolean flag = true;
	public static void topologicalOrder() {
		while(!stack.isEmpty()) {
		Node n = stack.pop();
		System.out.println(n.getName() + ": startTime: " + n.getStartTime() + " endTime : " + n.getEndTime());
		}
	}
	public static void dfs(Node v,ArrayList<Node> g) {
		v.setParent(new Node("-1"));
		DFS_visit(v);
		for(Node n: g) {
			if(n.getParent() == null) {
				n.setParent(new Node("-1"));
				DFS_visit(n);		
			}
		}
		
	}
	static int time = 0;
	public static void DFS_visit(Node v) {
		time++;
		//System.out.println("vertex name : " + v.getName());
		v.setStartTime(time);
		
		//System.out.print("start time: ");
		//System.out.println(time);
		//int i = 0;
		for(Node n: v.getAdjList()) {
			if(n.getParent() == null) {
				n.setParent(v); 
				DFS_visit(n);
			}
			else if(n.getEndTime() == 0 && n.getStartTime() !=0) {
				System.out.println(v.getName() + " to " + n.getName() + " is a backedge");
				System.out.println("Cycle is detected Topological sort is impossible");
				flag = false;
			}
		}
		stack.push(v);
		time++;
		System.out.print("end time: ");
		v.setEndTime(time);
		
		System.out.println(time);
	}

}
