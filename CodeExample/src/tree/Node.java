package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Node{
	int data;
	Node left;
	Node right;
	
	public static void main(String[] args)
	{
		Node  n=new Node();
		n.data=1;
		n.left=new Node();
		n.left.data=2;
		n.left.right=new Node();
		n.left.right.data=3;
		n.right=new Node();
		n.right.data=4;
		n.right.left=new Node();
		n.right.left.data=5;
		levelOrderTraversal(n);
		//printLeftView(n);
		//printrightView(n);
		printTopView(n);
		//System.out.println("finish");
	}
	
	public void diameterOfTree(Node root,Node first,Node second){
		if(root != null)
		{
			
		}
		
	}
	
	public static void levelOrderTraversal(Node node)
	{
		
		Queue<Node> q1=new LinkedList<Node>();
		Queue<Node> q2=new LinkedList<Node>();
		if(node!=null)
		{
			q1.add(node);		
		}
		//System.out.println("adf");
		while(!q1.isEmpty() || !q2.isEmpty())
		{
			//System.out.println("inside");
			while(!q1.isEmpty())
			{
				Node temp=q1.poll();
				if(temp.left!=null)
				{
					q2.add(temp.left);
				}
				if(temp.right!=null)
				{
					q2.add(temp.right);
				}
				System.out.print(temp.data +" ");
			}
			
			Queue<Node> q3=q1;
			q1=q2;
			q2=q3;
			System.out.println();
		}
	}
	public static void printLeftView(Node node)
	{
		if(node!=null)
		{
			Queue<Node> q1=new LinkedList<Node>();
			Queue<Node> q2=new LinkedList<Node>();
			q1.add(node);
			while(!q1.isEmpty() || !q2.isEmpty())
			{
				int i=0;
				while(!q1.isEmpty())
				{
					Node temp=q1.poll();
					if(temp.left!=null)
					{
						q2.add(temp.left);
					}
					if(temp.right!=null)
					{
						q2.add(temp.right);
					}
					if(i==0)
					{
						System.out.println(temp.data);
					}
					i++;
				}
				Queue<Node> q3=q1;
				q1=q2;
				q2=q3;
			}
		}
	}
	public static void printrightView(Node node)
	{
		if(node!=null)
		{
			Queue<Node> q1=new LinkedList<Node>();
			Queue<Node> q2=new LinkedList<Node>();
			q1.add(node);
			while(!q1.isEmpty() || !q2.isEmpty())
			{
				int i=0;
				while(!q1.isEmpty())
				{
					Node temp=q1.poll();
					if(temp.right!=null)
					{
						q2.add(temp.right);
					}
					if(temp.left!=null)
					{
						q2.add(temp.left);
					}
					if(i==0)
					{
						System.out.println(temp.data);
					}
					i++;
				}
				Queue<Node> q3=q1;
				q1=q2;
				q2=q3;
			}
		}
	}
	public static void printTopView(Node node)
	{
		if(node !=null)
		{
			int l=topViewUtil2(node,0);
			int r=topViewUtil1(node,0);
			//System.out.println("l:"+l);
			//System.out.println("r:"+r);
			if(l<0)
				l=(-l);
			Node[] rightArr=new Node[r+1];
			Node[] leftArr=new Node[l];
			int[] rightArrUtil=new int[r+1];
			int[] leftArrUtil=new int[l];
			for(int i=0;i<=r;i++)
			{
				rightArrUtil[i]=Integer.MAX_VALUE;
				//System.out.print(rightArrUtil[i]+ " ");
			}
			for(int i=0;i<l;i++)
			{
				leftArrUtil[i]=Integer.MAX_VALUE;
				//System.out.print(leftArrUtil[i]+ " ");
			}
//			System.out.println(rightArrUtil);
//			System.out.println(leftArrUtil);
			topViewUtil(node,leftArr,rightArr,rightArrUtil,leftArrUtil,0,0);
			for(int i=0;i<leftArrUtil.length;i++)
			{
				System.out.print(leftArr[i].data+ " ");
			}
			for(int i=0;i<rightArrUtil.length;i++)
			{
				System.out.print(rightArr[i].data+ " ");
			}
			System.out.println();
			
		}
	}
	public static void topViewUtil(Node node,Node[] leftArr,Node[] rightArr,int[] rightArrUtil,int[] leftArrUtil,int count,int height)
	{
		
		if(node!=null)
		{
//			System.out.println("count:"+count);
//			System.out.println("data:"+node.data);
		    if(count>=0)
		    {
		       if( rightArrUtil[count] >height)
		       {
		    	   rightArr[count]=node;
		    	   rightArrUtil[count]=height;
		       }
		    }else
		    {
		    	if(leftArrUtil[(-count)-1] > height)
		    	{
		    		 leftArr[-(count+1)]=node;
			    	   leftArrUtil[-(count+1)]=height;
		    	}
		    }
		    topViewUtil(node.left,leftArr,rightArr,rightArrUtil,leftArrUtil,count-1,height+1);
		    topViewUtil(node.right,leftArr,rightArr,rightArrUtil,leftArrUtil,count+1,height+1);
		}else
		{
			
		}
	}
	public static int topViewUtil1(Node node,int count){
		if(node!=null)
		{
			int l=Integer.MIN_VALUE;
			int r=Integer.MIN_VALUE;
			l=topViewUtil1(node.left, count-1);
			r=topViewUtil1(node.right, count+1);
		    return max(max(l,r),count);
		}else
		{
			return Integer.MIN_VALUE;
		}
	}
	public static int topViewUtil2(Node node,int count){
		if(node!=null)
		{
			//System.out.println("count in top:"+count);
			int l=Integer.MAX_VALUE;
			int r=Integer.MAX_VALUE;
			l=topViewUtil2(node.left, count-1);
			r=topViewUtil2(node.right, count+1);
		    return min(min(l,r),count);
		}else
		{
			return Integer.MAX_VALUE;
		}
	}
	
	public static int max(int l,int r)
	{
		if(l>r)
			return l;
		else
			return r;
	}
	public static int min(int l,int r)
	{
		if(l<r)
			return l;
		else
			return r;
	}
	
	
}