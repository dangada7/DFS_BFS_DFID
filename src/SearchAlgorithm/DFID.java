package SearchAlgorithm;

import storage.Graph;
import storage.Result;

public class DFID implements SearchAlgorithm{

	@Override
	public Result searchTree(Graph graph3, int value) {
		
		int graphDepth = graph3.getGraphDepth(), i, graphSize=graph3.getGraphSize();
		Result result = new Result(graphSize, graphDepth);
		Result dfsResult = null;
		DFS dfs = new DFS();
		
		//start the algorithm
		for(i=0; i < graphDepth; i++){
			dfsResult = dfs.searchTree(graph3, value);

			if(dfsResult.getFindNode()){
				result.FindNode();
				break;
			}
			
			result.setGenerateNodesNum(result.getGenerateNodesNum() + dfsResult.getGenerateNodesNum());
			
		}
		
		result.setMaxNodesNum(dfsResult.getMaxHoldNodes());

		return result;
	}
	
	
	
	

}
