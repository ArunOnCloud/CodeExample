package Hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Contacts {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        
        
        //Scanner sc=new Scanner(System.in);
        
       // int n=sc.nextInt();
        Trie trie=new Trie();
        String l="";
        for(int i=0;i<N;i++)
        {
        	
        	 //l=sc.nextLine();
        	 l=br.readLine();
        	// System.out.println("line:"+l);
        	 String[] arr=l.split(" ");
        	 if(arr[0].equals("add"))
        	 {
        		 trie.add(0,arr[1],null);
        	 }else
        	 {
        		 System.out.println(trie.find(arr[1], 0, null));
        	 }
        	 
        }
       
        
        

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
	Trie()
	{
		cur=new TrieNode[26];
		//System.out.println("length:"+cur.length);
	}
	public int add(int i,String s,TrieNode root)
	{
		int ind=(int)(s.charAt(i)-'a');
		//System.out.println("ind:"+ind);
		if(root==null)
		{
				if(cur[ind]==null)
			
			  {
				TrieNode node=new TrieNode();
				node.c=s.charAt(i);
				node.count=0;
				if(i==s.length()-1)
				{
				  node.isEnd=true;
				}
				cur[ind]=node;
				if(i==s.length()-1)
				{
					node.count=1;
					return node.count;
					
				}else
				{
					return add(i+1,s,node);
				}
			  }else
			  {
				  return add(i+1,s,cur[ind]);
			  }
		}else
		{
			root.count=root.count+1;
			// System.out.println("count:"+root.count);
			if(root.next[ind]==null)
				
			  {
				  
				TrieNode node=new TrieNode();
				node.c=s.charAt(i);
				node.count=0;
				if(i==s.length()-1)
				{
				  node.isEnd=true;
				}
				root.next[ind]=node;
				if(i==s.length()-1)
				{
					node.count=1;
					return node.count;
					
				}else
				{
					return add(i+1,s,node);
				}
			  }else
			  {
				  //root.count=root.count+1;
				 
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
		//return 0;
	}
	public int find(String s,int i,TrieNode node)
	{
		if(i==s.length())
		{
			return node.count;
		}
		int ind=(int)(s.charAt(i)-'a');
		//System.out.println("char "+s.charAt(i)+" ind:"+ind+" i:"+i);
		if(node==null)
		{
			if(cur[ind]==null)
			{
				return 0;
			}else
			{
				return find(s,i+1,cur[ind]);
			}
		}else
		{
		   // if(i == s.length()-1)
		    if(false)
		    {
		    	//System.out.println("c:"+node.c+" count:"+node.count);
		    	if(node.c == s.charAt(i))
		    	{
		    		return node.count;
		    	}else
		    	{
		    		return 0;
		    	}
		    }else
		    {
		    	if(node.next[ind]==null)
				{
					return 0;
				}else
				{
					return find(s,i+1,node.next[ind]);
				}
		    }
		}
		//return 0;
	}
}
