package PhoneticalySimilarWords;

import java.util.Comparator;

public class TripleComparator implements Comparator<Triple>{
	public int compare(Triple obj1,Triple obj2)
	{
		
		return Double.compare(obj1.first, obj2.first);
	}

}
