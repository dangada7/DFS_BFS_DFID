package SearchAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

import storage.Graph;
import storage.Node;
import storage.Result;

public class BFS implements SearchAlgorithm{
	 
	@Override
	public Result searchTree(Graph graph, int value) {
		
		int graphSize = graph.getGraphSize(), graphDepth = graph.getGraphDepth();
		Result result = new Result(graphSize, graphDepth);
		Queue<Node> queue = new LinkedList<Node>();
		Node currentNode;
			
		//insert to root node
		queue.add(graph.getRoot());
		result.addNode();
		
		//loop all the tree in BFS way
		while(!queue.isEmpty()){
			//remove the first node
			currentNode = queue.remove();
			result.generateNode();
			
			//if we find the goal node
			if(currentNode.getValue() == value){
				result.FindNode();
				//break the loop
				break;
			}
			//add children to queue
			for(Node childNode: currentNode.getChildren()){
				result.addNode();
				queue.add(childNode);
			}
				
		}
		return result;
	}
	
	 
}
