package SearchAlgorithm;

import java.util.Stack;

import storage.Graph;
import storage.Node;
import storage.Result;

public class DFS implements SearchAlgorithm{

	@Override
	public Result searchTree(Graph graph, int value) {
		
		int graphSize = graph.getGraphSize(), graphDepth = graph.getGraphDepth();
		Result result = new Result(graphSize, graphDepth);
		Stack<Node> stack = new Stack<Node>();
		Node currentNode;
		
		stack.add(graph.getRoot());
		result.addNode();
		
		while(!stack.empty()){
			result.generateNode();
			
			currentNode = stack.pop();
			result.removeNode();
			
			if(currentNode.getValue() == value){
				result.FindNode();
				break;
			}
			
			//add children to stack
			for(Node childNode: currentNode.getChildren()){
				result.addNode();
				stack.add(childNode);
			}
			
		}
		
		return result;
	}
	

}
