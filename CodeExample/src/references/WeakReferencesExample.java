package references;

//Java Code to illustrate Weak reference 
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List; 
class Gfg 
{ 
  //code 
  public void x() 
  { 
      System.out.println("GeeksforGeeks"); 
  } 
} 

public class WeakReferencesExample 
{ 
  public static void main(String[] args) 
  { 
      // Strong Reference 
      Gfg g = new Gfg();    
      g.x(); 
        
      // Creating Weak Reference to Gfg-type object to which 'g'  
      // is also pointing. 
      WeakReference<Gfg> weakref = new WeakReference<Gfg>(g); 
        
      //Now, Gfg-type object to which 'g' was pointing earlier 
      //is available for garbage collection. 
      //But, it will be garbage collected only when JVM needs memory. 
      g = null; 
      
      long heapSize = Runtime.getRuntime().totalMemory(); 
       System.out.println("heapSize:"+heapSize);
	   // Get maximum size of heap in bytes. The heap cannot grow beyond this size.// Any attempt will result in an OutOfMemoryException.
	   long heapMaxSize = Runtime.getRuntime().maxMemory();
	   System.out.println("heapMaxSize:"+heapMaxSize);
	    // Get amount of free memory within the heap in bytes. This size will increase // after garbage collection and decrease as new objects are created.
	   long heapFreeSize = Runtime.getRuntime().freeMemory(); 
	   System.out.println("heapFreeSize:"+heapFreeSize);
        
	   List<Object[]> set=new LinkedList<>();
	   int prev=0;
	   while (heapFreeSize  > 5L) {
		   Object[] obj=new Object[10000000];
		   set.add(obj);
		   heapFreeSize = Runtime.getRuntime().freeMemory();
		   int cur=set.size();
		   if(cur -prev   >10) {
			   prev=cur;
			   System.out.println("in while heapFreeSize:"+heapFreeSize);
			   System.out.println("in while listSize:"+set.size());
		   }
		   
	   }
	   System.out.println("after while heapFreeSize:"+heapFreeSize);
      // You can retrieve back the object which 
      // has been weakly referenced. 
      // It succesfully calls the method. 
      g = weakref.get();  
        
      g.x(); 
  } 
}