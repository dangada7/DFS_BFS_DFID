package old;

import java.util.Stack;

public class BinaryTree {
	
	private BinaryNode root;
	private int size;
	private int depth = 0;
	
	//*************************
	public BinaryTree(){
		this.root = null;
		this.size=0;
		this.depth = 0;
	}

	//*************************
	public BinaryTree(int[] arrTree){
		this.root = null;
		this.size=0;
		
		int i;
		for(i=0; i< arrTree.length; i++)
			addNode(arrTree[i]);
	}
	//*************************
	public BinaryNode getRoot(){
		return root;
	}
	//*************************
	public void addNode(int value){
		size++;
		int currentDepth = 0;
		
		//if the tree is empty
		if (root== null){
			root = new BinaryNode(value);
			return;
		}
		
		//if the tree isnt empty
		BinaryNode currentNode = root;
		
		while(true){
			currentDepth++;
			// (current > value) => search the left branch
			if(currentNode.getValue() > value){
				// have child => search the child 
				if(currentNode.hasLeftChild())
					currentNode = currentNode.getLeftChild();
				// dont have a child => add new nude;
				else{
					currentNode.addleftChild(value);
					break;
				}
			// (Current <= value) => search the left branch
			}else{
				// have child => search the child 
				if(currentNode.hasRightChild())
					currentNode = currentNode.getRightChild();
				// dont have a child => add new nude;
				else{
					currentNode.addRightChild(value);
					break;
				}
			}
		}//end while
		
		if(currentDepth > this.depth)
			this.depth = currentDepth;

	}
	//*************************
	public void printPreOrder(){
		System.out.println("nodesNum=" + size);
		Stack<BinaryNode> stack = new Stack<BinaryNode>();

		if (root==null)
			return;
		stack.add(root);
		
		while (!stack.isEmpty()){
			BinaryNode node = stack.pop();
			System.out.print(node.getValue() + ",");
			
			if(node.hasRightChild())
				stack.push(node.getRightChild());
			
			if(node.hasLeftChild())
				stack.push(node.getLeftChild());
			

		}
		System.out.println("\n---------------------");
		
		
	}

	public boolean isEmprty() {
		return root == null;
	}
	
	public int getSize(){
		return size;
	}
	
	public int getDepth(){
		return this.depth;
	}
	
	
}
