package ConceptImplementation;

import java.util.Map;
import java.util.TreeMap;


/* 

class Node 
   int data;
   Node left;
   Node right;
*/
class Node
{
	int data;
	Node left;
	Node right;
	Node(int data)
	{
		this.data=data;
	}
}
public class TopViewTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.right=new Node(4);
		root.left.right.right=new Node(5);
		root.left.right.right.right=new Node(6);
		root.left.right.right.left=new Node(7);
		root.left.left=new Node(8);
		root.left.left.right=new Node(9);
		root.left.right.right.right.right=new Node(10);
		TopViewTree topViewTree=new TopViewTree();
        topViewTree.topView(root);
	}
	
	public void util(Node node,Map<Integer,Integer> map,Map<Integer,Node> nodeMap,int count,int height)
	{
		if(node!=null)
		{
			if(map.containsKey(count))
			{
				int h=map.get(count);
				if(height<h)
				{
					map.put(count, height);
					nodeMap.put(count, node);
				}
			}else
			{
				map.put(count, height);
				nodeMap.put(count, node);
			}
			util(node.left,map,nodeMap,count-1,height+1);
			util(node.right,map,nodeMap,count+1,height+1);
		}
	}
	public void topView(Node node)
	{
		Map<Integer,Integer> map=new TreeMap<Integer,Integer>();
		Map<Integer,Node> nodeMap=new TreeMap<Integer,Node>();
		
		util(node,map,nodeMap,0,0);
		for(Map.Entry<Integer, Node> s:nodeMap.entrySet())
		{
			System.out.print(""+s.getValue().data+" ");
		}
		System.out.println();
		for(Map.Entry<Integer, Node> s:nodeMap.entrySet())
		{
			System.out.println(s.getKey());
		}
		
		
		
	}

}
