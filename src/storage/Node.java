package storage;

import java.util.LinkedList;

public class Node {
	
	private int value;
	private LinkedList<Node> children;
	
	public Node(int value){
		this.value = value;
		children = new LinkedList<Node>();
	}
	
	public void addChild(Node child){
		children.add(child);
	}
	
	public LinkedList<Node> getChildren(){
		return this.children;
	}
	
	public int getValue(){
		return this.value;
	}
	
	
}
