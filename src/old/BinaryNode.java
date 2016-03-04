package old;

public class BinaryNode {
	
	private int value;
	private BinaryNode leftChild;
	private BinaryNode rightChild;
	
	public BinaryNode(int value){
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}
	public BinaryNode(int value, BinaryNode leftChild, BinaryNode rightChild){
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public int getValue(){
		return value;
	}
	public BinaryNode getLeftChild(){
		return leftChild;
	}
	
	public BinaryNode getRightChild(){
		return rightChild;
	}
	
	public boolean equals(BinaryNode node){
		return this.getValue() == node.getValue();
	}
	
	public boolean hasLeftChild(){
		return this.getLeftChild() != null;
	}
	
	public boolean hasRightChild(){
		return this.getRightChild() != null;
	}
	
	public void addleftChild(int value) {
		this.leftChild = new BinaryNode(value);
	}
	
	public void addRightChild(int value) {
		this.rightChild = new BinaryNode(value);
	}

}
