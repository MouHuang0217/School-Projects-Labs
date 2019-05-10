package lab8v2;

import java.util.ArrayList;

public class Node {
	private String name;
	private Node parent;
	private ArrayList<Node> adjList;
	private int distance;
	private int startTime;
	private int endTime;
	public Node(String _name) {
		this.name = _name;
		this.parent = null;
		this.adjList = new ArrayList<Node>();
		this.distance = 0;
		this.setStartTime(0);
		this.setEndTime(0);
	}
	public void printAdjList() {
		for(Node i: adjList) {
			System.out.println(i.getName());
		}
	}
	public void removeItem(int index) {
		this.adjList.remove(index);
	}
	public boolean inAdjList(Node n) {
		for(Node i: adjList) {
			//System.out.println(i.getName());
			if (i.getName().equals(n.getName())) {
				System.out.println("true");
				return true;
			}
		}
		System.out.println("false");
		return false;
	}
	public String toString() {
		return name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node vert) {
		this.parent = vert;
	}

	public ArrayList<Node> getAdjList() {
		return adjList;
	}

	public void setAdjList(ArrayList<Node> adjList) {
		this.adjList = adjList;
	}
	
	public void addAdj(Node node) {
		adjList.add(node);
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
}
