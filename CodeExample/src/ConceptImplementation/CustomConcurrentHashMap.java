package ConceptImplementation;

public class CustomConcurrentHashMap {
	
	private int concurrencyLimit=16;
	
	private int tableSize=16;
	
	private Object[] objArr=null;
	
	private class Entry
	{
		String key;
		String value;
		Entry next;
	}
   
	
	private Entry[] table=null;
	
	CustomConcurrentHashMap()
	{
		table=new Entry[tableSize];
		objArr=new Object[concurrencyLimit];
		
	}
	public String get(String str)
	{
		int ind=str.hashCode();
		int tableInd=ind% tableSize;
		int bucketInd= tableInd% concurrencyLimit;
		synchronized(objArr[bucketInd]) {
			Entry entry=table[tableInd];
			if(entry.key.equals(str))
			{
				return entry.value;
			}else
			{
				entry=entry.next;
				while(entry.next!=null)
				{
					if(entry.key.equals(str))
					{
						return entry.value;
					}
					entry=entry.next;
				}
			}
			
		}
		return null;
	}
	
	public void put(String key,String value) {
		int ind=key.hashCode();
		int tableInd=ind% tableSize;
		int bucketInd= tableInd% concurrencyLimit;
		synchronized(objArr[bucketInd]) {
			Entry entry=table[tableInd];
			if(entry!=null)
			{
				Entry prev=entry;
				while(entry!=null && !entry.key.equals(key))
				{
					prev=entry;
					entry=entry.next;
				}
				if(entry==null)
				{
					Entry obj=new Entry();
					obj.key=key;
					obj.value=value;
					obj.next=null;
					prev.next=obj;
					
				}else
				{
					entry.value=value;
				}
			}else
			{
				Entry obj=new Entry();
				obj.key=key;
				obj.value=value;
				obj.next=null;
				table[tableInd]=obj;
				
			}
			
			
		}
		
	}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
