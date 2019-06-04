package algorithm;

import java.util.LinkedList;

public class BinaryTreeOrderUtils {

	//先根遍历
	public static void preOrder(BinaryTree tree){
		if(tree==null){
			return;
		}
		System.out.print(tree.data+" ");
		preOrder(tree.leftTree);
		preOrder(tree.rightTree);
		
	}
	//中根遍历
	public static void inOrder(BinaryTree tree){
		if(tree==null){
			return;
		}
		inOrder(tree.leftTree);
		System.out.print(tree.data+" ");
		inOrder(tree.rightTree);
	}
	//后根遍历
	public static void afterOrder(BinaryTree tree){
		if(tree==null){
			return;
		}
		afterOrder(tree.leftTree);
		afterOrder(tree.rightTree);
		System.out.print(tree.data+" ");
	}
	
	public static void levelOrder(BinaryTree tree){
		if(tree == null){
			return;
		}
		BinaryTree tempTree;
		LinkedList<BinaryTree> list = new LinkedList<BinaryTree>();
		list.offer(tree);
		while(!list.isEmpty()){
			tempTree = list.pop();
			System.out.println(tempTree.data+"--->");
			if(tempTree.leftTree!=null){
				list.offer(tempTree.leftTree);
			}
			if(tempTree.rightTree!=null){
				list.offer(tempTree.rightTree);
			}
		}
		
	}

}
