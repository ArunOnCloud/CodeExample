package hackerearth;

import java.util.Scanner;

public class PeopleStrongChalengeThree {
	static long mod = 1000000007L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
        {
			int N = s.nextInt();
              int[] arr=new int[N];
	        for (int i = 0; i < N; i++) {
	            int temp=s.nextInt();
	            arr[i]=temp;
	            add(root,temp);
	        }
	        System.out.println(solve(root));
	        t--;
        }

	}
   public static Node root; 
   public static void add(Node cur,long x)
   {
	   if(cur==null)
	   {
		   Node temp=new Node();
		   temp.data=(int)x;
		   root=temp;
	   }else
	   {
		   if(x<cur.data)
		   {
			   if(cur.left!=null)
			   {
				   add(cur.left,x);
			   }else
			   {
				   Node temp=new Node();
				   temp.data=(int)x;
				   cur.left=temp;
			   }
			  
		   }else
		   {
			   if(cur.right !=null)
			   {
				   add(cur.right,x);
			   }else
			   {
				   Node temp=new Node();
				   temp.data=(int)x;
				   cur.right=temp;
			   }
			   return;
		   }
	   }
	   
	   
   }

   
   public static long count(Node root)
   {
	   if(root!=null)
	   {
		   return count(root.left) + count(root.right)+1;
	   }else
	   {
		   return 0;
	   }
   }
   
   public static long solve(Node node)
   {
	   if(node !=null)
	   {
		   long l=count(node.left);
		   long r=count(node.right);
		   long le=solve(node.left);
		   long ri=solve(node.right);
		   
		   
		   return (l+r +le +ri)%mod ;
	   }else
	   {
		   return 0;
	   }
   }
//   public util(Node node)
//   {
//	   
//   }
}
class Node
{
	public long data;
	public Node left;
	public Node right;
	Node()
	{
		left=null;
		right=null;
		data=0;
				
				
	}
}
