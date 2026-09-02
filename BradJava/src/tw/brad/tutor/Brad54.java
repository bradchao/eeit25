package tw.brad.tutor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class Brad54 {

	public static void main(String[] args) {
		try {
			// 1. Client
			HttpClient client = HttpClient.newHttpClient();
			
			// 2. Request
			HttpRequest request = HttpRequest.newBuilder()
									.uri(URI.create("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx"))
									.GET()
									.build();
			
			// 3. send
			HttpResponse<String> response =
					client.send(request, HttpResponse.BodyHandlers.ofString());
		
			String body = response.body();
			//System.out.println(body);
			parseJSON(body);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void parseJSON(String json) {
		JSONArray root = new JSONArray(json);
		for (int i = 0; i<root.length(); i++) {
			JSONObject row = root.getJSONObject(i);
			String name = row.getString("Name");
			System.out.println(name);
		}
	}
	

}
