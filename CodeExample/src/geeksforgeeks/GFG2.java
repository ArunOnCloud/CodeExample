package geeksforgeeks;

import java.util.*;
import java.util.Scanner;
import java.util.HashSet;
import java.lang.Math;
    class Node
    {
        int data;
        Node left,right;
        Node(int d) {data = d; left =right= null; }
    }
		
public class GFG2
{
    public static Node target;
    GFG2(){
        target=null;
    }
	public static void inorder(Node root,int key)
	{
	    if(root==null)
	    return;
	    inorder(root.left,key);
	    if(root.data==key)
	    target=root;
	    inorder(root.right,key);
	}
     /* Drier program to test above functions */
    public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t-->0)
         {
			int n = sc.nextInt();
			GFG2 llist=new GFG2();
			Node root=null,parent=null;
			HashMap<Integer, Node> m = new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                char c=sc.next().charAt(0);
                if(m.containsKey(a)==false)
                {
                    parent=new Node(a);
                    m.put(a,parent);
                    if(root==null)
                    root=parent;
                }
                else
                    parent=m.get(a);
                Node child=new Node(b);
                if(c=='L')
                parent.left=child;
                else
                parent.right=child;
                m.put(b,child);
            }
            int key=sc.nextInt();
            inorder(root,key);
            int k=sc.nextInt();
            GFG obj = new GFG();
            obj.printkdistanceNode(root,target,k);
            System.out.println();
		}
	}
}

class GFG
{
    public static int printkdistanceNode(Node root, Node target , int k)
    {
    //Add your code here.
      List<Node> list=new LinkedList<>();
      findPathToNode(root,target,list);
      Node prev=null;
      for(int i=list.size()-1;i>=0;i--){
         Node node=list.get(i);
         if(prev ==null){
             prev=node;
             print(node,target,k);
         }else{
             int k1=list.size()-1 -i;
             Node next=null;
             if(node.left.data== prev.data){
                 print(node.right,target,k1);
             }else{
                 print(node.left,target,k1);
             }
         }
      }
    }
    
    static boolean findPathToNode(Node node,Node target,List<Node> list){
        if(node != null){
            if(node.data == target.data){
                list.add(target);
                return true;
            }
            
            boolean l=findPathToNode(node.left,target,list);
            boolean r=findPathToNode(node.right,target,list);
            if((l||r)){
                
            }else{
                list.remove(node);
            }
        }
        return false;
        
    }

    static void print(Node root,int c,int k){
        if(root != null){
            if( c== k){
                System.out.print(root.data+" ");
                return;
            }
            print(root.left,c+1,k);
            print(root.right,c+1,k);
        }
    }
}
