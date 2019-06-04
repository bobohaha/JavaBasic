package algorithm;

public class BinaryTree {

	public int data;
	public BinaryTree leftTree;
	public BinaryTree rightTree;
	
	public BinaryTree(int data){
		this.data = data;
		leftTree = null;
		rightTree = null;
	}
	
	public void insertTree(BinaryTree tree,int data){
		if(tree.data>data){
			if(tree.leftTree == null){
				tree.leftTree = new BinaryTree(data);
			}else{
				this.insertTree(tree.leftTree, data);
			}
		}else if(tree.data<data){
			if(tree.rightTree == null){
				tree.rightTree = new BinaryTree(data);
			}else{
				this.insertTree(tree.rightTree, data);
			}
		}
	}
	
	
}
