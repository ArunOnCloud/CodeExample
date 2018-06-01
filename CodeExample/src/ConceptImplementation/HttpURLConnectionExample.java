package ConceptImplementation;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;



public class HttpURLConnectionExample {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		HttpURLConnectionExample http = new HttpURLConnectionExample();

		//System.out.println("Testing 1 - Send Http GET request");
		//http.sendGet();

		//System.out.println("\nTesting 2 - Send Http POST request");
		http.sendPost();

	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "http://www.google.com/search?q=mkyong";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

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

	}

	// HTTP POST request
	private void sendPost() throws Exception {

		String url = "https://test.crifhighmark.com/Inquiry/do.getSecureService/encrypt";
		//url="https://cir.crifhighmark.com/Inquiry/do.getSecureService/encrypt;";
		System.setProperty("jsse.enableSNIExtension", "false");
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("accept", "text/plain");
		con.setRequestProperty("Content-Type", "text/plain");
		con.setRequestProperty("key", "65F12317363D6B967DF221E8D7F867B0F3A52D93");				
		con.setRequestProperty("request", "Naresh||Pruthi|Male||45||123456789|||arunram@policybazaar.com||AFUPJ7365N||LHR/1631969||000538/060257|UID900|||PRAKASH|||GANGA ELECTRICALS,  SHOP NO 3 JAIN MANDIR|SAHARANPUR|SAHARANPUR|UP|247001|India|||||||DTC0000013|BBC_CONSUMER_SCORE#85#2.0|Y|");
		con.setRequestProperty("type", "E");
		con.setRequestProperty("userId", "chm_bbc_uat@policybazaar.com");
		con.setRequestProperty("password", "6BC1761476F00983A0EC2EEF980DD0B001B26A33");

		//String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
		String urlParameters = "";

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

	}

	/*private void sendPostAnother throws Exception{
		String output;
		String responseX="";
		HttpClient client = null;
		System.setProperty("jsse.enableSNIExtension", "false");
		String url = "https://test.crifhighmark.com/Inquiry/do.getSecureService/encrypt";
		try {
		HttpPost getRequest = new HttpPost(uri);
		// Add additional header to getRequest which accepts application/xml data
		getRequest.addHeader("accept", "text/plain");
		//set request parameter in header
		getRequest.setHeader("orderId",requestHeaders.get("orderId"));//pass order ID
		getRequest.setHeader("accessCode", requestHeaders.get("accessCode")); // pass accessCode
		getRequest.setHeader("Appid",requestHeaders.get("appID"));//pass Application ID(android or ios)
		getRequest.setHeader("encRequest",requestHeaders.get("encRequest") ); //pass encrypted inquiry request
		getRequest.setHeader("mercchantid",requestHeaders.get("merchantID") ); //pass merchant id
		// Execute your request and catch response 
		
		
		
		
		
		client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(getRequest);
		// Check for HTTP response code: 200 = success
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error"+response.getStatusLine().getStatusCode());
		}
		
		
		// Get-Capture Complete application/xml body response 
		BufferedReader br2 = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		// Simply iterate through XML response and show on console.
		while((output = br2.readLine()) != null) {
			//System.out.println(output);
			responseX+=output;
			
		}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (client != null) {
				client.getConnectionManager().shutdown();
			}
		}
		
			
		
		System.out.println (responseX);
	}
*/
	
}
