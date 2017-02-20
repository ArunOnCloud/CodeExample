package Trie;
import java.io.*;
public class TrieTest {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Trie trie=new Trie();
		/*Character[] ch1={'f','r','u','n'};
		Character[] ch2={'n','u','n'};
		Character[] ch3={'a','v','i','n','a','s','h'};
		trie.addNode(ch1);
		trie.addNode(ch2);
		trie.addNode(ch3);
		trie.print();*/
		String path="C:\\Users\\arun\\Desktop\\office\\dictionaryWords.txt";
		FileReader fl=new FileReader(path);
		BufferedReader bf=new BufferedReader(fl);
	    String str=bf.readLine();
	    while(str!=null)
	    {
            str=str.trim().toLowerCase();
            
            char[] arr=str.toCharArray();
            Character[] aArr=new Character[arr.length];
            for(int i=0;i<arr.length;i++)
            {
            	aArr[i]=arr[i];
            }
            
            
            //System.out.println("str:"+str);
            trie.addNode(aArr);
	    	str=bf.readLine();
	    }
	    trie.print();

	}

}
