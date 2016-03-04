package storage;

public class Result {
	
	private boolean findNode;
	//memory 
	private int maxHoldNodes; 		// the max number of nodes the algorithm holds
	private int HoldNodes; 

	private int generateNodes;
	
	private int graphSize;
	private int graphDepth;
	
	//*************************
	public Result(int graphSize, int graphDepth){
		this.maxHoldNodes = 0;
		this.HoldNodes = 0;
		this.generateNodes = 0;
		
		this.findNode = false;
		
		this.graphSize = graphSize;
		this.graphDepth = graphDepth;
	}
	//*************************
	public void FindNode(){
		this.findNode = true;
	}
	//*************************
	public boolean getFindNode(){
		return findNode;
	}
	public int getMaxHoldNodes(){
		return maxHoldNodes;
	}
	public int getGraphSize() {
		return graphSize;
	}
	public int getGenerateNodesNum() {
		return this.generateNodes;
	}
	//*************************
	public void setMaxNodesNum(int maxHoldNodes){
		this.maxHoldNodes = maxHoldNodes;
	}
	public void setGenerateNodesNum(int generateNodes) {
		this.generateNodes = generateNodes;
	}
	//*************************
	public void generateNode(){
		generateNodes++;
	}
	
	//*************************
	public void addNode(){
		HoldNodes++;
		if(HoldNodes>maxHoldNodes)
			maxHoldNodes = HoldNodes;
	}
	public void removeNode(){
		HoldNodes--;
	}
	//*************************
	public String toString(){
		return 		"findNode=" + findNode 
				+ ", generateNodes=" + generateNodes
				+ ", maxHoldNodes=" + maxHoldNodes
				+ ", graphSize=" + graphSize;
	}


	

	
	
	
}
