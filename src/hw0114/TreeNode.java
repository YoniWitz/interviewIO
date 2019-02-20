package hw0114;

public class TreeNode {
	int data;
	TreeNode right;
	TreeNode left;

	public TreeNode(int data) {
		this.data = data;
		this.right = null;
		this.left = null;
	}

	public TreeNode(int data, TreeNode right, TreeNode left) {
		this.data = data;
		this.right = right;
		this.left = left;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}
}
