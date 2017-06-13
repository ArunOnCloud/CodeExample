package Hackerrank;

public class Contacts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TrieNode{
	public char c;
	public boolean isEnd;
	public int count;
	TrieNode[] next=new TrieNode[26];
	TrieNode()
	{
		for(int i=0;i<26;i++)
			next[i]=null;
	}
}
class Trie{
	TrieNode[] cur=new TrieNode[26];
	public int add(int i,String s,TrieNode root)
	{
		int ind=(int)('a'-s.charAt(i));
		if(root==null)
		{
				if(cur[ind]==null)
			
			  {
				TrieNode node=new TrieNode();
				node.c=s.charAt(i);
				node.count=1;
				if(i==s.length()-1)
				{
				  node.isEnd=true;
				}
				cur[ind]=node;
				if(i==s.length()-1)
				{
					return node.count;
					
				}else
				{
					return add(i+1,s,node);
				}
			  }
		}else
		{
			if(root.next[ind]==null)
				
			  {
				TrieNode node=new TrieNode();
				node.c=s.charAt(i);
				node.count=1;
				if(i==s.length()-1)
				{
				  node.isEnd=true;
				}
				cur[ind]=node;
				if(i==s.length()-1)
				{
					return node.count;
					
				}else
				{
					return add(i+1,s,node);
				}
			  }else
			  {
				  root.count=root.count+1;
				  if(i==s.length()-1)
					{
					   root.isEnd=true;
					   return root.count;
						
					}else
					{
						return add(i+1,s,root.next[ind]);
					}
				  
				  
			  }
		}
		return 0;
	}
	public int find(String s,int i,TrieNode node)
	{
		int ind=(int)('a'-s.charAt(i));
		if(node==null)
		{
			if(cur[ind]==null)
			{
				return 0;
			}else
			{
				return find(s,i,cur[ind]);
			}
		}else
		{
		    if(ind ==s.length()-1)
		    {
		    	return node.count;
		    }else
		    {
		    	
		    }
		}
		return 0;
	}
}
