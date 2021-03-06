package PhoneticalySimilarWords;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class GenerateStringSampleTwo {

	public  Map<Character, Character> charToNumber;// here key is A,B,C..Z
	public  Map<Integer, String> integerToString;
	GenerateStringSampleTwo()
	{
		setMap();
	}
	public  void setMap() {
		charToNumber = new HashMap<Character, Character>();
		integerToString = new HashMap<Integer, String>();
		// int temp='A';
		integerToString.put(1, "BFPV");
		integerToString.put(2, "CGJKQSXZ");
		integerToString.put(3, "DT");
		integerToString.put(4, "L");
		integerToString.put(5, "MN");
		integerToString.put(6, "R");
		integerToString.put(0, "AEHIOUWY");

		for (int i = 0; i < 7; i++) {
			String str = integerToString.get(i);
			char ch = (char) (i + (char) '0');
			// System.out.println("ch:"+ch);
			for (int j = 0; j < str.length(); j++) {
				char tempChar = str.charAt(j);
				charToNumber.put(tempChar, ch);
				/*
				 * if(i==5) { System.out.println("tempChar:"+tempChar); }
				 */
			}

		}
	}

	public  String soundex(String s) {
		char[] x = s.toUpperCase().toCharArray();
		char firstLetter = x[0];

		// convert letters to numeric code
		for (int i = 0; i < x.length; i++) {
			switch (x[i]) {
			case 'B':
			case 'F':
			case 'P':
			case 'V': {
				x[i] = '1';
				break;
			}

			case 'C':
			case 'G':
			case 'J':
			case 'K':
			case 'Q':
			case 'S':
			case 'X':
			case 'Z': {
				x[i] = '2';
				break;
			}

			case 'D':
			case 'T': {
				x[i] = '3';
				break;
			}

			case 'L': {
				x[i] = '4';
				break;
			}

			case 'M':
			case 'N': {
				x[i] = '5';
				break;
			}

			case 'R': {
				x[i] = '6';
				break;
			}

			default: {
				x[i] = '0';
				break;
			}
			}
		}

		// remove duplicates
		String output = "" + firstLetter;

		for (int i = 1; i < x.length; i++)
			if (x[i] != x[i - 1] && x[i] != '0')
				output += x[i];

		// pad with 0's or truncate
		// output = output + "0000";
		return output;
	}

	public  String buildString(String str) {
		String fin = "";
		// for(int i=0;i<)
		return fin;
	}
    public  Integer determineSize(String str)
    {
    	int res=1;
    	Map<String,Boolean> m=new HashMap<String,Boolean>();
    	for(int i=1;i<str.length();i++)
    	{
    		char ch=str.charAt(i);
    		char num = charToNumber.get(ch);
			int in = (int) (num - '0');

			 //System.out.println("in:"+in);
			String tempStr = integerToString.get(in);
    		//String tempStr=integerToString.get(ch);
			
			if(m.containsKey(tempStr)==false)
    		{
				if(tempStr.length()-1>0)
					res*=(tempStr.length()-1);
				m.put(tempStr,true);
    		}
    		
    	}
    	return res;
    }
    public  double compareStrings(String stringA, String stringB) {
	    JaroWinkler algorithm = new JaroWinkler();
	    return algorithm.similarity(stringA, stringB);
	}
	public String[] genPhoneticalyString(String str,Integer top) {
		str = str.toUpperCase();
		Set<String> set = new HashSet<String>();
		//String word = soundex(str);
		
		int size =determineSize(str);// Determinesize determine how many string can be generated by algorithm
		//System.out.println("size:"+size);
		if(size>25)
		{
			size=25;
		}
		Random random = new Random();
		while (set.size() < size) {
			int temp = random.nextInt(2);
			// 0 for the replace
			// 1 for the add
			
			int toWhichIndex = random.nextInt(str.length());
			
			if (toWhichIndex == 0) {
				continue;
			}
			char ch = str.charAt(toWhichIndex);
			
			char num = charToNumber.get(ch);
			int in = (int) (num - '0');

			 
			String tempStr = integerToString.get(in);
			int toWhichChar = random.nextInt(tempStr.length());
			char tempChar = tempStr.charAt(toWhichChar);
			
			if (temp == 0) {
				
				StringBuffer bf = new StringBuffer(str);
				bf.setCharAt(toWhichIndex, tempChar);
				tempStr = bf.toString();
				// System.out.println("tempStr:"+tempStr);
				set.add(tempStr);
			} else if (temp == 1)// for adding
			{

				char[] arr = str.toCharArray();
				String fin = "";
				for (int i = 0; i < arr.length; i++) {
					fin += arr[i];
					if (i == toWhichIndex) {
						fin += tempChar;
					}

				}
				set.add(fin);
				
			}
		}
		
		pair[] arr=new pair[size];
		
		Iterator itr=set.iterator();
		int ind=0;
		while(itr.hasNext())
		{
			String temp=(String)itr.next();
			Double dou=compareStrings(str,temp);
			
			arr[ind]=new pair();
			arr[ind].first=new Double(dou);
			arr[ind].second=temp;
			ind++;
		}
		Arrays.sort(arr,new pairComparator() );
		for(pair val:arr){
			System.out.println("first:"+val.first+" second:"+ val.second);
		}
	
		//int top=5;
		//it ensures that top is not greater than the number fo strings
		if(top>=size)
		{
			top=size;
		}
		String[] fin=new String[top];
				for(int i=0;i<top;i++)
				{
					fin[i]=arr[size-1-i].second;
				}
		
		
		
		/*System.out.println("fin:");
		for(int i=0;i<fin.length;i++)
		{
			System.out.println(fin[i]);
		}*/
		return fin;
	}
	public static void main(String[] args)
	{
		GenerateStringSampleTwo test = new GenerateStringSampleTwo();
		Integer top=9;
		String[] result=test.genPhoneticalyString("city",top);
		for(String val:result)
		{
			System.out.println(val);
		}
	}

}
