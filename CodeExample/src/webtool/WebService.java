package webtool;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class WebService {

	public static String callService(
			String type, 
			String uri, 
			String request,
			Map<String, String> requestHeaders) {

		URL url;
		HttpURLConnection connection = null;

		try {
			// Create connection
			url = new URL(uri);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(type);

			if (requestHeaders != null) {
				for (Map.Entry<String, String> requestHeader : requestHeaders
						.entrySet()) {
					if (requestHeader.getKey().equals("Content-Length")) {
						connection.setRequestProperty("Content-Length",
								Integer.toString(request.length()));
					} else {
						connection.setRequestProperty(requestHeader.getKey(),
								requestHeader.getValue());
					}
				}

			}
			// log.info(connection.getRequestProperties());

			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setConnectTimeout(60 * 5 * 10000);

			// Send request
			if (request != null) {
				DataOutputStream wr = new DataOutputStream(
						connection.getOutputStream());
				wr.writeBytes(request);
				wr.flush();
				wr.close();
			}
			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();

			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append(' ');
			}

			rd.close();
 			return response.toString().trim();
		} catch (Exception e) {
			System.out.println("Exception in service->" + request);
			e.printStackTrace();
			StringBuffer response = new StringBuffer();
			try {
				InputStream is1 = connection.getErrorStream();
				if (is1 != null) {
					BufferedReader rd1 = new BufferedReader(
							new InputStreamReader(is1));
					String line1;
					while ((line1 = rd1.readLine()) != null) {
						response.append(line1);
						response.append(' ');
					}
				}
				System.out.println("Exception in service->" + response.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return response.toString();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

}
