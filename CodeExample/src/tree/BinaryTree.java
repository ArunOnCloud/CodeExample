package tree;

public class BinaryTree {
	
	public TreeNode root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree binaryTree=new BinaryTree();
		binaryTree.root=new TreeNode();
		binaryTree.root.data=10;
		binaryTree.root.left=new TreeNode();
		binaryTree.root.left.data=12;
		binaryTree.root.left.left=new TreeNode();
		binaryTree.root.left.left.data=14;
		binaryTree.root.left.right=new TreeNode();
		binaryTree.root.left.right.data=19;
		binaryTree.preorder(binaryTree.root);
		System.out.println("\n");
		binaryTree.inorder(binaryTree.root);

	}
	
	
	public void buildRandomTree()
	{
		
	}
	public void preorder(TreeNode node)
	{
		if(node!=null)
		{
			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}
		
	}
	public void inorder(TreeNode node)
	{
		if(node!=null)
		{
			inorder(node.left);
			System.out.print(node.data + " ");
			
			inorder(node.right);
		}
		
	}
	public void postorder(TreeNode node)
	{
		if(node!=null)
		{
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data + " ");
		}
		
	}

}
