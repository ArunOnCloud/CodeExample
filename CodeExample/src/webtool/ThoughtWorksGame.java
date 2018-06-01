package webtool;

import java.util.HashMap;
import java.util.Map;

public class ThoughtWorksGame {
	public static void main(String[] args) {
		
		Map<String,String> map=new HashMap<>();
		map.put("userId"," SJZGTSxRz");
		map.put("content-type"," application/json");
		map.put("host"," https://http-hunt.thoughtworks-labs.net");
		
		String response=WebService.callService("GET", "https://http-hunt.thoughtworks-labs.net/challenge/input", "", map);
		
		System.out.println(response);

	}
}
