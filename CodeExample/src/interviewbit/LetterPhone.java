package interviewbit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterPhone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterPhone lp=new LetterPhone();
		List<String> list=lp.letterCombinations("23");
		System.out.println(list);

	}
	 public ArrayList<String> letterCombinations(String A) {
		 Map<Character,String> map=new HashMap<>();
		 map.put('0', "0");
		 map.put('1', "1");
		 map.put('2', "abc");
		 map.put('3', "def");
		 map.put('4', "ghi");
		 map.put('5', "jkl");
		 map.put('6', "mno");
		 
		 map.put('7', "pqrs");
		 map.put('8', "tuv");
		 map.put('9', "wxyz");
		 
		 util(map,A,0,"");
		 result.sort(Comparator.naturalOrder());
		 
		 return result;
	  }
	 ArrayList<String> result=new ArrayList<>();
	 public void util(Map<Character,String> map,String s,int ind,String res) {
		 if(ind== s.length()) {
			 result.add(res);
			 return;
		 }
		 char ch=s.charAt(ind);
		 String str=map.get(s.charAt(ind));
		 for(int i=0;i<str.length();i++) {
			 Character c=str.charAt(i);
			 String val= res+c.toString();
			 util(map,s,ind+1,val);
		 }
		 
	 }

}
