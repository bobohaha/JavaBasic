import java.util.LinkedList;
import java.util.Queue;


public class BinaryTest {
	
	private static void preOrder(BinaryTree root){
		if(root!=null){
			System.out.print(root.data+"-");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	private static void inOrder(BinaryTree root){
		if(root!=null){
			inOrder(root.left);
			System.out.print(root.data+"-");
			inOrder(root.right);
		}
	}
	
	private static void postOrder(BinaryTree root){
		if(root!=null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+"-");
		}
	}
	private static void levelOrder(BinaryTree root){
		if(root == null){
			return;
		}
		Queue<BinaryTree> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			BinaryTree node = q.poll();
			System.out.print(node.data+"-");
			if(node.left!=null){
				q.add(node.left);
			}
			if(node.right!=null){
				q.add(node.right);
			}
		}
	}

	public static void main(String[] args) {
		int[] array = {8,6,10,57,9,11};
		BinaryTree tree = new BinaryTree(array[0]);
		for (int i = 1; i < array.length; i++) {
			tree.insert(tree, array[i]);
		}
		preOrder(tree);
		System.out.println("先序遍历");
		inOrder(tree);
		System.out.println("中序遍历");
		postOrder(tree);
		System.out.println("后序遍历");
		levelOrder(tree);
		System.out.println("层级遍历");
	}
}
