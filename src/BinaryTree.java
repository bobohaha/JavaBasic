
public class BinaryTree {
	
	int data;
	BinaryTree left;
	BinaryTree right;
	
	public BinaryTree(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public void insert(BinaryTree root, int data){
		if(root.data>data){
			if(root.left == null){
				root.left = new BinaryTree(data);
			}else{
				root.left.insert(root.left, data);
			}
		}else{
			if(root.right == null){
				root.right = new BinaryTree(data);
			}else{
				root.right.insert(root.right, data);
			}
		}
	}

}
