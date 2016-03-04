package SearchAlgorithm;

import storage.Graph;
import storage.Result;

public interface SearchAlgorithm {
	
	abstract public Result searchTree(Graph tree, int value);

}
