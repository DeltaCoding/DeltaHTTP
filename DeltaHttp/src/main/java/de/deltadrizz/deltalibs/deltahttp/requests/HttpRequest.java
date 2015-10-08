package de.deltadrizz.deltalibs.deltahttp.requests;

import java.io.IOException;
import java.net.URL;

public interface HttpRequest {
	
	public static final String USER_AGENT = "Mozilla/5.0";

	public void execute(URL url) throws IOException;
	
	public int getStatusCode();	
	
}
