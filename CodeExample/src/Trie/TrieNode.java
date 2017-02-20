package Trie;

public class TrieNode {
	private Character data;
	private Character check;
	private TrieNode[] trieArr;
	TrieNode()
	{
		trieArr=new TrieNode[26];
		check='#';// #shows that word does not end here and & shows word end here
	}
	public Character getData()
	{
		return data;
	}
	public Character getCheck(){
		return check;
	}
	public TrieNode[] getTrieArray()
	{
		return trieArr;
	}
	public void setData(Character c)
	{
		data=c;
	}
	public void setCheck()
	{
		check='@';
	}

}
