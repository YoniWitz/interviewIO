package hw0108;

public class BinaryTreeIntro {
	static void traverseInOrder(TreeNode n) {
		if (n == null) {
			return;
		}

		traverseInOrder(n.getLeft());
		System.out.print(n.getData() + " ");
		traverseInOrder(n.getRight());
	}

	static void traversePreOrder(TreeNode n) {
		if (n == null) {
			return;
		}

		System.out.print(n.getData() + " ");
		traversePreOrder(n.getLeft());
		traversePreOrder(n.getRight());
	}

	static void traversePostOrder(TreeNode n) {
		if (n == null) {
			return;
		}

		traversePostOrder(n.getLeft());
		traversePostOrder(n.getRight());
		System.out.print(n.getData() + " ");
	}

	public static void main(String[] args) {
//		TreeNode D = new TreeNode(44);
//		TreeNode E = new TreeNode(55);
//		TreeNode H = new TreeNode(88);
//		TreeNode G = new TreeNode(77);
//		TreeNode F = new TreeNode(66, G, H);
//		TreeNode C = new TreeNode(33);
//		C.setRight(F);
//		TreeNode B = new TreeNode(22, E, D);
//		TreeNode A = new TreeNode(11, C, B);

		TreeNode D = new TreeNode(44);
		TreeNode E = new TreeNode(55);

		TreeNode G = new TreeNode(77);
		TreeNode F = new TreeNode(66);
		TreeNode C = new TreeNode(33, G, F);

		TreeNode B = new TreeNode(22, E, D);
		TreeNode A = new TreeNode(11, C, B);
		traverseInOrder(A);
		System.out.println();
		traversePreOrder(A);
		System.out.println();
		traversePostOrder(A);

	}
}
