
public class TreeNode {
	
	private String data;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(String d, TreeNode l, TreeNode r) {
		this.data = d;
		this.left = l;
		this.right = r;
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

}
