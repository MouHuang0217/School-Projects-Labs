package lab8v2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import lab8.Node;

public class graph {
	private int V;   
	private static LinkedList<Integer> adj[]; 
  
    // Constructor 
    graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList<Integer>(); 
    } 
	
	public static graph createGraph() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("How many vertices? ");
		int size = userInput.nextInt();
		System.out.println("How many edges");
		int edges = userInput.nextInt();
		
		graph uGraph = new graph(size);
		for(int i = 0; i < size ; i++) {
			Random rand = new Random(); 
			uGraph.addEdge(rand.nextInt(size), rand.nextInt(edges));
		}
		return uGraph;
	}
	
	void addEdge(int v,int w) { 
        adj[v].add(w); 
    } 
	
	static void printGraph(graph graph) {
		int l = 0;
		int k = 0;
		for(LinkedList<Integer> i: adj) {
			System.out.print(l++ + " :");
			System.out.println(i.toString());
			
		}
	}
	
	
public static void main(String[] args) {
		
		graph graph = createGraph();
		printGraph(graph);
		Scanner userInput = new Scanner(System.in);
		System.out.println("What index do you want to start in? ");
		int index = userInput.nextInt();
		bfs(index);
		
		
}
/*
 * public static void bfs(Node v) {
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
 */
public static void bfs(int v) {
	ArrayList<Integer> queue = new ArrayList<Integer>();
		queue.add(v);
	while(!queue.isEmpty()) {
		Integer vert = queue.remove(0);
		Iterator<Integer> i = adj[vert].listIterator(); 
        while (i.hasNext()) 
        { 
             
        } 
	}
}
}
