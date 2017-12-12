package geeksforgeeks;
/*
Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*  A Binary Search Tree node
 * 
 */
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
} 
public class checkBst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 int prev;
	    int isBST(Node root)  
	    {
	        // Your code here
	        prev=Integer.MIN_VALUE;
	        int val=0;
	        if(util(root))
	        {
	            val=1;
	        }
	       return  val;
	    }
	    
	    boolean util(Node node)
	    {
	        if(node!=null)
	        {
	          boolean left=util(node.left);
	          boolean mid=true;
	          if(node.data < prev)
	          {
	              mid=false;
	          }else
	          {
	              prev=node.data;
	          }
	          boolean right=util(node.right);
	          return left && mid && right;
	          
	        }else
	        {
	            return true;
	        }
	    }

}

