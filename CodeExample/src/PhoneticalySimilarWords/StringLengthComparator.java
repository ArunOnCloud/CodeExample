package PhoneticalySimilarWords;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {
	private String keyword;
	StringLengthComparator(String keyword)
	{
		this.keyword=keyword;
	}
	public int compare(String obj1,String obj2)
	{
		int keylen=keyword.length();
		int abs1=Math.abs(keylen-obj1.length());
		int abs2=Math.abs(keylen-obj2.length());
		//int len=obj1.length()-obj2.length();
				int len=abs1-abs2;
		return len;
	}

}
