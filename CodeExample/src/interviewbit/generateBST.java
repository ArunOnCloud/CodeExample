package interviewbit;

import java.util.ArrayList;

public class generateBST {
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	ArrayList<TreeNode> constructTrees(int start, int end)
	{
	    ArrayList<TreeNode> list=new ArrayList<TreeNode>();
	 
	    /*  if start > end   then subtree will be empty so returning NULL
	        in the list */
	    if (start > end)
	    {
	        list.add(null);
	        return list;
	    }
	 
	    /*  iterating through all values from start to end  for constructing\
	        left and right subtree recursively  */
	    for (int i = start; i <= end; i++)
	    {
	        /*  constructing left subtree   */
	        ArrayList<TreeNode> leftSubtree  = constructTrees(start, i - 1);
	 
	        /*  constructing right subtree  */
	        ArrayList<TreeNode> rightSubtree = constructTrees(i + 1, end);
	 
	        /*  now looping through all left and right subtrees and connecting
	            them to ith root  below  */
	        for (int j = 0; j < leftSubtree.size(); j++)
	        {
	        	TreeNode left = leftSubtree.get(j);
	            for (int k = 0; k < rightSubtree.size(); k++)
	            {
	            	TreeNode right = rightSubtree.get(k);
	            	TreeNode node = new TreeNode(i);// making value i as root
	                node.left = left;              // connect left subtree
	                node.right = right;            // connect right subtree
	                list.add(node);           // add this tree to list
	            }
	        }
	    }
	    return list;
	}
	
	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	ArrayList<TreeNode> result=new ArrayList<TreeNode>();
	ArrayList<TreeNode> res=new ArrayList<TreeNode>();
	
	public ArrayList<TreeNode> generateTrees(int a) {
		int[] arr=new int[a];
		for(int i=0;i<=a;i++) {
			arr[i]=i+1;
		}
		permutation(arr, 0);
		removeDuplicates();
		
	return res;	
	}
	
	boolean isIdentical(TreeNode one,TreeNode two) {
		if( one !=null && two !=null) {
			if(one.val == two.val) {
				return isIdentical(one.left, two.left) && isIdentical(one.right,two.right );
			}else; {
				return false;
			}
		}else if(one == null && two == null){
			return true;
		}else {
			return false;
		}
	}
	void removeDuplicates() {
		int len=result.size();
		int[] arr=new int[len];
		for(int i=0;i<len;i++) {
		    if(arr[i] == 0){
    			for(int j=i+1;j<len;j++) {
    				if(isIdentical(result.get(i), result.get(j))) {
    					arr[j]=1;
    				}
    			}
		    }
		}
		for(int i=0;i<len;i++) {
			if(arr[i]==0) {
				res.add(result.get(i));
			}
		}
		
	}

	
	public void permutation(int[] arr,int ind) {
		if(arr.length == ind+1)
		{
			TreeNode node=makeBST(arr);
			result.add(node);
			return ;
		}
		for(int i=ind;i<arr.length;i++) {
			swap(arr,i,ind);
			permutation(arr,ind+1);
			swap(arr,i,ind);
			
		}
		
		
	}
	
	void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public ArrayList<Integer>  copyList(ArrayList<Integer> s){
	    ArrayList<Integer> res=new ArrayList<Integer>();
	    for(int i=0;i<s.size();i++){
	        int val=s.get(i);
	        res.add(val);
	        
	     }
	     return res;
	    }
	
	TreeNode makeBST(int[] arr) {
		int len=arr.length;
		if(len >1) {
			TreeNode root=insert(null, arr[0]);
			for(int i=1;i<len;i++) {
				insert(root,arr[i]);
			}
			return root;
		}else
		{
			if(len == 1)
			return insert(null, arr[0]);
			else
				return null;
		}
		
	}
    TreeNode insert(TreeNode node,int d) {
		if(node == null){
			node=new TreeNode(d);
			return node;
		}else
		{
			if(d>node.val && node.right !=null) {
				return insert(node.right, d);
			}else if(d>node.val && node.right ==null) {
				TreeNode temp=new TreeNode(d);
				node.right=temp;
				return temp;
			}else if(d<node.val && node.left !=null) {
				return insert(node.left, d);
			}else if(d<node.val && node.left == null) {
				TreeNode temp=new TreeNode(d);
				node.left=temp;
				return temp;
			}else if(d==node.val && node.left !=null) {
				return insert(node.left, d);
			}else if(d==node.val && node.left == null) {
				TreeNode temp=new TreeNode(d);
				node.left=temp;
				return temp;
			}
			return null;
		}
	}
	

}
