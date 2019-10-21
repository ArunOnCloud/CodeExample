import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

// cat cot  con mon man 
// can 
//bool isPresent(String str)
//

public class TechnicalInterview {
	//this method return -1 is Path is not possible
	public int shortestPath(Dictionary d,String source ,String destination) {
		Set<String> words=new TreeSet<>();
		generateWords(source,d,0,words);
		//Map<String ,Boolean> isVisited=new HashMap<>();
		Set<String> isVisited=new HashSet<>();
		Queue<String> queue=new LinkedList<>();
		queue.add(source);
		String cur=source;
		int findFlag=0;
		for(String word:words) {
			
			if(isDistanceOne(cur, word)) {
				if(word.equals(destination)) {
					findFlag=1;
				}
				queue.add(word);
			}
		}
		isVisited.add(cur);
		int ans=0;
		if(findFlag == 1) {
			return 1;
		}
		while(!queue.isEmpty()) {
			ans++;
			Queue<String> queueTwo=new LinkedList<>();
			while(!queue.isEmpty()) {
				cur=queue.peek();
				queue.poll();
				isVisited.add(cur);				
				for(String word:words) {
					if(word.equals(destination)) {
						findFlag=1;
						break;
					}
					
					if(isDistanceOne(cur, word) && !isVisited.contains(word)) {
						queueTwo.add(word);
					}
				}
				
			}

			if(findFlag == 1) {
				break;
			}else {
				queue=queueTwo;
			}
			
		}
		if(findFlag == 1) {
			return ans;
		}else {
			return -1;
		}
		
		
	}
	
	public void generateWords(String str,Dictionary d,int ind,Set<String> words){
		int len=str.length();
		StringBuilder  sb=new StringBuilder(str);
		if(ind <str.length()) {
			for(int i=0;i<26;i++) {
				char c= (char)((int)'a'+i);
				sb.setCharAt(ind, c);
				String res=sb.toString();
				if(d.isPresent(res)) {
					words.add(res);
				}
				generateWords(res,d,ind+1,words);
			}
			
		}
		
		
	}
	boolean isDistanceOne(String a,String b) {
		int d=0;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i) != b.charAt(i)) {
				d++;
			}
			if(d>1) {
				return false;
			}
		}
		if(d==1) {
			return true;
		}else {
			return false;
		}
	}
	
	
		
}


class Dictionary{
 public 	boolean isPresent(String str) {
	 //TO DO
	 return true;
 }
}
