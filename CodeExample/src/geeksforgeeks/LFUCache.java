package geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public LFUCache(int capacity) {
        this.capacity=capacity;
    }
    int capacity=0;
    Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    Map<Integer,Integer> countMap=new HashMap<Integer,Integer>();
    
    public int get(int key) {
        if(map.containsKey(key))
        {
        	Integer val=countMap.get(key);
        	countMap.put(key,val+1);
        	return map.get(key);
        }else
        {
        	return -1;
        }
    }
    
    public void put(int key, int value) {
    	if(map.containsKey(key))
    	{
    		Integer val=countMap.get(key);
        	countMap.put(key,val+1);
        	map.put(key, value);
    	}else
    	{
    		if(map.size() ==capacity)
     	   {
     		   Integer keyObj=remove();
     		   countMap.remove(keyObj);
     		   map.remove(keyObj);
     	   }
    		map.put(key, value);
    		countMap.put(key, 1);
    	   
    	}
        
    }
    private Integer remove(){
    	Integer result=0;
    	Integer key=-1;
    	Integer value=0;
    	for(Map.Entry<Integer, Integer> entry:countMap.entrySet())
    	{
    		if(entry.getValue() <value)
    		{
    			value=entry.getValue();
    			key=entry.getKey();
    		}
    	}
    	return key;
    	
    }

}
