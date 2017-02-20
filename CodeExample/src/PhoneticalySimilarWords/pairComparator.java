package PhoneticalySimilarWords;

import java.util.Comparator;

class pairComparator implements Comparator<pair>{
	public int compare(pair obj1,pair obj2)
	{
		
		return Double.compare(obj1.first, obj2.first);
	}
}