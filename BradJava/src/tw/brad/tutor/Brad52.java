package tw.brad.tutor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Brad52 {

	public static void main(String[] args) {
		try {
			// 1. Client
			HttpClient client = HttpClient.newHttpClient();
			
			// 2. Request
			HttpRequest request = HttpRequest.newBuilder()
									.uri(URI.create("https://www.ispan.com.tw"))
									.GET()
									.build();
			
			// 3. send
			HttpResponse<String> response =
					client.send(request, HttpResponse.BodyHandlers.ofString());
		
			String body = response.body();
			System.out.println(body);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
