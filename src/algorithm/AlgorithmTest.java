package algorithm;

public class AlgorithmTest {
	
	
	public static void main(String[] args) {
		int[] datas = new int[]{4,2,1,3,6,5,7,8};
		BinaryTree tree = new BinaryTree(datas[0]);
		for (int i = 1; i < datas.length; i++) {
			tree.insertTree(tree, datas[i]);
		}
		System.out.println("先根遍历");
		BinaryTreeOrderUtils.preOrder(tree);
		
		System.out.println("中根遍历");
		BinaryTreeOrderUtils.inOrder(tree);
		
		System.out.println("后根遍历");
		BinaryTreeOrderUtils.afterOrder(tree);
		
		System.out.println("层级遍历");
		BinaryTreeOrderUtils.levelOrder(tree);
		
	}

}
