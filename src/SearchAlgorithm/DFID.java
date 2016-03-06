package SearchAlgorithm;

import java.util.Stack;

import storage.Graph;
import storage.Node;
import storage.Result;

public class DFID implements SearchAlgorithm{

	@Override
	public Result searchTree(Graph graph3, int value) {
		
		int graphDepth = graph3.getGraphDepth(), i, graphSize=graph3.getGraphSize();
		Result result = new Result(graphSize, graphDepth);
		Result dfsResult = null;
		
		//start the algorithm
		for(i=0; i <= graphDepth; i++){
			dfsResult = dfsSerachWithDepth(graph3, value, i);

			if(dfsResult.getFindNode()){
				result.FindNode();
				break;
			}
			
			result.setGenerateNodesNum(result.getGenerateNodesNum() + dfsResult.getGenerateNodesNum());
			
		}
		
		result.setMaxNodesNum(dfsResult.getMaxHoldNodes());

		return result;
	}
	
	
	public Result dfsSerachWithDepth(Graph graph, int value, int depth) {
		
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
			
			//add children to stack if we are in the right height
			if(stack.size() <= depth)
				for(Node childNode: currentNode.getChildren()){
					result.addNode();
					stack.add(childNode);
				}
			
		}
		
		return result;
	}
	
	
	

}
