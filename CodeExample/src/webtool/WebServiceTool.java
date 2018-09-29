package webtool;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;


public class WebServiceTool {

	
	
	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		WebServiceTool http = new WebServiceTool();

		System.out.println("Testing 1 - Send Http GET request");
		//http.sendGet();

		System.out.println("\nTesting 2 - Send Http POST request");
		//http.sendPost();
		
		Map<String,String> map=new HashMap<>();
		map.put("userId","SJZGTSxRz");
		map.put("content-type","application/json");
		map.put("host","https://http-hunt.thoughtworks-labs.net");
		
		/*String response=http.sendGet("https://http-hunt.thoughtworks-labs.net/challenge/input", map);
		
		
		JSONArray arr=new JSONArray(response);
		JSONObject object=new JSONObject();
		object.put("count", arr.length());
		String res=http.sendPost("https://http-hunt.thoughtworks-labs.net/challenge/output", map, object.toString());
		
		System.out.println(res);*/
		
        String response=http.sendGet("https://http-hunt.thoughtworks-labs.net/challenge/input", map);
		
		
		JSONArray arr=new JSONArray(response);
		int count=0;
		//Map<String,String> catMap=new HashMap<>();
		JSONObject jsonMap=new JSONObject();
		for(int  i=0;i<arr.length();i++) {
			JSONObject obj=arr.getJSONObject(i);
			//JSONObject o
			System.out.println(obj.get("endDate"));
			String str=obj.getString("startDate");
			Date dd = new SimpleDateFormat("yyyy-MM-dd").parse(str);
			System.out.println("Date : =>    "+dd);
			//return dd;
			Date ed=null;
			str=obj.getString("endDate");
			if(str !=null && !str.equals("null"))
			 ed = new SimpleDateFormat("yyyy-MM-dd").parse(str);
			
			System.out.println("Date : =>    "+ed);
			
		    int flag=0;
			if(obj.get("endDate").toString().equals("null") && dd.getTime() <new Date().getTime()) {
				flag=1;
			}else if(ed !=null && dd.getTime() < ed.getTime() && dd.getTime() <=new Date().getTime() && ed.getTime() >new Date().getTime()){
				flag=1;
			}
			if(flag==1)
		    {
				String cat=obj.getString("category");
				if(jsonMap.has(cat)) {
				  int cou=jsonMap.getInt(cat);
				  jsonMap.put(cat, cou+1);
				}else {
					jsonMap.put(cat, 1);
				}
				int price=obj.getInt("price");
				count+=price;
			}
		}
		JSONObject object=new JSONObject();
		//object.put("count", price);
		object.put("totalValue", count);
		System.out.println(map.toString());
		String res=http.sendPost("https://http-hunt.thoughtworks-labs.net/challenge/output", map, object.toString());
		//String res=http.sendPost("https://http-hunt.thoughtworks-labs.net/challenge/output", map, jsonMap.toString());
		
		System.out.println(res);
		
	}

	// HTTP GET request
	private String sendGet(String url,Map<String,String> requestHeaders) throws Exception {

		//String url = "http://www.google.com/search?q=mkyong";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
		if (requestHeaders != null) {
			for (Map.Entry<String, String> requestHeader : requestHeaders
					.entrySet()) {
				if (requestHeader.getKey().equals("Content-Length")) {
					/*con.setRequestProperty("Content-Length",
							Integer.toString(request.length()));*/
				} else {
					con.setRequestProperty(requestHeader.getKey(),
							requestHeader.getValue());
				}
			}

		}

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		return response.toString();

	}

	// HTTP POST request
	private String sendPost(String url,Map<String,String> requestHeaders,String urlParameters) throws Exception {

		//String url = "https://selfsolve.apple.com/wcResults.do";
		URL obj = new URL(url);
		@SuppressWarnings("deprecation")
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		//con.setRequestProperty("User-Agent", USER_AGENT);
		//con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		//con.setRequestProperty("User-Agent", USER_AGENT);
		if (requestHeaders != null) {
			for (Map.Entry<String, String> requestHeader : requestHeaders
					.entrySet()) {
				if (requestHeader.getKey().equals("Content-Length")) {
					/*con.setRequestProperty("Content-Length",
							Integer.toString(request.length()));*/
				} else {
					con.setRequestProperty(requestHeader.getKey(),
							requestHeader.getValue());
				}
			}

		}

		//String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		return response.toString();

	}

}
