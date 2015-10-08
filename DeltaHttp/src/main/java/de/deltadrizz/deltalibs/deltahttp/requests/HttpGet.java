package de.deltadrizz.deltalibs.deltahttp.requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGet implements HttpRequest {

	private URL url;
	private int responseCode;
	private String response;
	
	public void execute(URL url) throws IOException {
		this.url = url;
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", HttpRequest.USER_AGENT);
		
		this.responseCode = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line;
		StringBuffer response = new StringBuffer();
		
		while((line = in.readLine()) != null)
			response.append(line);
		
		this.response = response.toString();
		
		in.close();
	}

	public int getStatusCode() {
		return this.responseCode;
	}
	
	public String getResponse() {
		return response;
	}

}
