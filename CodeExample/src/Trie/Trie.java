package Trie;

public class Trie {
	private TrieNode[] root;
	public void addNode(Character[] arr)
	{
		int ind=((int)(arr[0]))-(int)('a');
		if(root[ind]==null)
		{
			root[ind]=new TrieNode();
			root[ind].setData(arr[0]);
			addNodeUtil(arr,1,root[ind]);
		}else
		{
			addNodeUtil(arr,1,root[ind]);
		}
	}
	public void addNodeUtil(Character[] arr,int i,TrieNode node)
	{
		if(i==arr.length)
		{
			node.setCheck();
		}else
		{
			int ind=((int)(arr[0]))-(int)('a');
			TrieNode[] triearr=node.getTrieArray();
			if(triearr[ind]==null){
			   TrieNode temp=new TrieNode();
			   temp.setData(arr[i]);
			   triearr[ind]=temp;
			   addNodeUtil(arr,i+1,temp);
			}else
			{
				addNodeUtil(arr,i+1,triearr[ind]);
			}
		}
		
	}
	Trie()
	{
		root=new TrieNode[26];
		
	}
	public void print()
	{
	   //StringBuffer str=new StringBuffer();
	   //facebook.com;
		String str="";
		for(int i=0;i<26;i++)
		{
			if(root[i]!=null)
			{
				String newStr=new String(str);
				printUtil( root[i],newStr);
			}
		}
	}
	public void printUtil(TrieNode node,String s)
	{
		
		char[] ch=new char[1];
		ch[0]=node.getData();
		String str=new String(ch);
		s=s+str;
		if(node.getCheck()=='@')
			System.out.println(s);
		
		{
			TrieNode[] trieArr=node.getTrieArray();
			for(int i=0;i<26;i++)
			{
				if(trieArr[i]!=null)
				{
					String newStr=new String(s);
					printUtil(trieArr[i],newStr);
				}
			}
		}
	}

}
