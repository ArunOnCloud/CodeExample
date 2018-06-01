package geeksforgeeks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BinaryTreeToBST {
   
	Node binaryTreeToBST(Node root)
    {
	   // Your code here
		preorder(root);
		Collections.sort(list);
		util(root);
		
		
		
		return root;
    }
	int index=0;
	void util(Node node){
		if(node!=null)
		{
			util(node.left);
			int val=node.data;
			node.data=list.get(index);
			index++;
			util(node.right);
			
			
		}
		
	}
    List<Integer> list=new ArrayList<Integer>();
    
    void preorder(Node node){
    	if(node!=null)
    	{
    		list.add(node.data);
    		preorder(node.left);
    		preorder(node.right);
    	}
    }
}
