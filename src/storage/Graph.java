package storage;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
	private Node root;
	private int graphDepth;
	
	public Graph(Node root, int graphDepth){
		this.root = root;
		this.graphDepth = graphDepth;
	}
	
	public Node getRoot(){
		return this.root;
	}
	
	public int getGraphSize(){
		Queue<Node> queue = new LinkedList<Node>();
		int numberOfNodes = 0;
		Node currentNode;
		
		//count the tree size (in order like bfs);
		queue.add(this.root);
		while(!queue.isEmpty()){
			currentNode = queue.poll();
			numberOfNodes++;
			
			for(Node child: currentNode.getChildren())
				queue.add(child);
		}//end while
		return numberOfNodes;
	}
	
	public int getGraphDepth(){
		return graphDepth;
	}
	
	//**************************************
	public static Graph create3Graph(int size){
		Graph graph;
		Node currentNode, childNode1, childNode2, childNode3, rootNode;
		Queue<Node> queue = new LinkedList<Node>();
		int i, currentValue, graphDepth, temp;
		
		rootNode = new Node(0);
		
		queue.add(rootNode);
		
		for(i=1; i<=size; i++){
			
			currentNode=queue.poll();
			
			currentValue = currentNode.getValue();
			
			childNode1 = new Node(currentValue*3+1); 
			childNode2 = new Node(currentValue*3+2);
			childNode3 = new Node(currentValue*3+3); 
			
			currentNode.addChild(childNode1);
			currentNode.addChild(childNode2);
			currentNode.addChild(childNode3);
			
			queue.add(childNode1);
			queue.add(childNode2);
			queue.add(childNode3);
		}
		
		//calculate graph depth
		temp = size;
		i=1;
		graphDepth=0;
		while(temp>0){
			graphDepth++;
			temp = temp-i;
			i=i*3;
		}
		
		graph = new Graph(rootNode, graphDepth);
		
		return graph;
	}
	
	
	public static Graph create2Graph(int size){
		Graph graph;
		Node currentNode, childNode1, childNode2, rootNode;
		Queue<Node> queue = new LinkedList<Node>();
		int i, currentValue, graphDepth, temp;
		
		rootNode = new Node(0);
		
		queue.add(rootNode);
		
		for(i=1; i<=size; i++){
			
			currentNode=queue.poll();
			
			currentValue = currentNode.getValue();
			
			childNode1 = new Node(currentValue*2+1); 
			childNode2 = new Node(currentValue*2+2);
			
			currentNode.addChild(childNode1);
			currentNode.addChild(childNode2);
			
			queue.add(childNode1);
			queue.add(childNode2);
		}
		
		//calculate graph depth
		temp = size;
		i=1;
		graphDepth=0;
		while(temp>0){
			graphDepth++;
			temp = temp-i;
			i=i*3;
		}
		
		graph = new Graph(rootNode, graphDepth);
		
		return graph;
	}

}
