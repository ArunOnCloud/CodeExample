/*Author: arun Kumar Ram
Date:5 july 2015
Remark: without using random fuction
 */
package PhoneticalySimilarWords;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.codec.language.*;

public class GenerateStringSampleFour {
	public Map<Character, Character> charToNumber;// here key is A,B,C..Z
	public Map<Integer, String> integerToString;

	GenerateStringSampleFour() {
		setMap();
	}

	public void setMap() {
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

	public String buildString(String str) {
		String fin = "";
		// for(int i=0;i<)
		return fin;
	}

	public Integer determineSize(String str) {
		int res = 1;
		System.out.println("in det");
		Map<String, Boolean> m = new HashMap<String, Boolean>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			System.out.println("123 in for" + " ch:" + ch);
			char num = charToNumber.get(ch);
			System.out.println("in for");
			int in = (int) (num - '0');

			// System.out.println("in:"+in);
			String tempStr = integerToString.get(in);
			// String tempStr=integerToString.get(ch);

			if (m.containsKey(tempStr) == false) {
				if (tempStr.length() - 1 > 0)
					res *= (tempStr.length() - 1);
				m.put(tempStr, true);
			}

		}
		return res;
	}

	public double compareStrings(String stringA, String stringB) {
		JaroWinkler algorithm = new JaroWinkler();
		return algorithm.similarity(stringA, stringB);
	}

	public String[] genPhoneticalyString(String str, Integer top) {
		str = str.toUpperCase();
		Set<String> set = new HashSet<String>();
		// String word = soundex(str);

		//int size = determineSize(str);// Determinesize determine how many string
										// can be generated by algorithm
		/*System.out.println("size:" + size);
		if (size > 25) {
			size = 25;
		}*/
		int count=0;
		for (int i = 0; i < str.length(); i++) {
			count++;
			String left = str.substring(0, i);
			String right = "";
			if (i + 1 < str.length()) {
				right = str.substring(i + 1);
			}
			char ch = str.charAt(i);

			char num = charToNumber.get(ch);
			int in = (int) (num - '0');

			String tempStr = integerToString.get(in);
			for (int j = 0; j < tempStr.length(); j++) {
				count++;
				String mid = tempStr.substring(j, j + 1);
				String newStr = left + mid + right;// replacing character
				set.add(newStr);
				String ith = str.substring(i, i + 1);
				newStr = left + ith + mid + right;// now adding character
				set.add(newStr);
			}
			// now deleting character
			String delStr = left + right;
			set.add(delStr);

		}
		System.out.println("count:"+count);
        int size=set.size();
        System.out.println("size:"+size);
		Triple[] arr = new Triple[size];
        Metaphone meta=new Metaphone();
		Iterator itr = set.iterator();
		int ind = 0;
		/*
		 * first have double value
		 * second have meta value of string word
		 * third have word
		 */
		String metaStr=meta.metaphone(str);
		while (itr.hasNext()) {
			String temp = (String) itr.next();
			arr[ind] = new Triple();
			arr[ind].third=new String(temp);
			arr[ind].second =meta.metaphone(temp);
			Double dou = compareStrings(metaStr, arr[ind].second);
            
			
			arr[ind].first = new Double(dou);
			
			ind++;
		}
		//Arrays.sort(arr, new TripleComparator());
		TripleComparator tcom=(new TripleComparator());
		Arrays.sort(arr,tcom);
		for (Triple val : arr) {
			System.out.println("first:" + val.first + " second:" + val.second+ " third:"+val.third);
		}

		// int top=5;
		// it ensures that top is not greater than the number fo strings
		if (top >= size) {
			top = size;
		}
		String[] fin = new String[top];
		for (int i = 0; i < top; i++) {
			fin[i] = arr[size - 1 - i].third;
		}

		/*
		 * System.out.println("fin:"); for(int i=0;i<fin.length;i++) {
		 * System.out.println(fin[i]); }
		 */
		return fin;
	}

}
