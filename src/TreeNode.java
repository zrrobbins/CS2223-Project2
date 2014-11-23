
public class TreeNode {
	
	private String data;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(String d, TreeNode l, TreeNode r) {
		this.data = d;
		this.left = l;
		this.right = r;
	}
	
	public TreeNode(String d) {
		this.data = d;
		this.left = null;
		this.right = null;
	}

	public String getData() {
		return this.data;
	}
	
	public TreeNode getLeft() {
		return this.left;
	}
	
	public TreeNode getRight() {
		return this.right;
	}

	public void setLeft(TreeNode t) {
		this.left = t;
	}
	
	public void setRight(TreeNode t) {
		this.right = t;
	}
}
