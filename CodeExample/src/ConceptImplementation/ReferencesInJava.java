package ConceptImplementation;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class ReferencesInJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<HeavyList> queue=new LinkedList<>();
		
		HeavyList curr=new HeavyList();
		
		/*Reference<HeavyList> softRef = new SoftReference<>(curr, queue); 
		Reference<HeavyList> weakRef = new WeakReference<>(curr, queue);
		Reference<HeavyList> phantomRef = new PhantomReference<>(curr, queue);*/

	}

}
class HeavyList{
	
}