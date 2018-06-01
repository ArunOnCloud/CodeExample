package practice;

public class CustomHashMap {
	int size=15;
	public static void main(String[] args) {
		// TODO Auto-generated method stubm
		CustomHashMap map=new CustomHashMap();
		map.put("arun", "1");
		map.put("sum", "2");
		map.put("val", "3");
		map.put("val", "4");
		System.out.println(map.get("val"));
		System.out.println(map.get("arun"));
		System.out.println(map.get("sum1"));
		
	}
	Node[] table=new Node[size];
	
	void put(String key,String val) {
		int ind=key.hashCode()% size;
		if(table[ind]== null) {
			table[ind]=new Node(key,val);
		}else {
			Node head=table[ind];
			Node temp=head;
			while(temp.next!=null && !temp.key.equals(key)) {
				temp=temp.next;
			}
			if(temp.key.equals(key)) {
				temp.value=val;
			}else {
				temp.next=new Node(key,val);
				
			}
		}
		
		
		
	}
	String get(String key) {
		int ind= key.hashCode()% size;
		Node node=table[ind];
		while(node!=null && !node.key.equals(key)) {
			node=node.next;
		}
		if(node == null) {
			return null;
		}else {
			return node.value;
		}
	}
	
	class Node{
		String key;
		String value;
		Node next;
		
		Node(String key,String val){
			this.key=key;
			this.value=val;
			this.next=null;
		}
	}
	

}
