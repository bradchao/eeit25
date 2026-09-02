package tw.brad.tutor;

import java.io.FileOutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Brad53 {

	public static void main(String[] args) {
		try {
			// 1. Client
			HttpClient client = HttpClient.newHttpClient();
			
			// 2. Request
			HttpRequest request = HttpRequest.newBuilder()
									.uri(URI.create("https://s.yimg.com/lo/mysterio/api/a8b64c20f427d63d5096366eebaf36af4f1c73e5a1f83297c96eaf328ebd2b59/lightyear_networkapi/resizefill_w960%3Bquality_80%3Bformat_webp/https%3A%2F%2Fmedia.zenfs.com%2Fzh-tw%2Fftnn_com_tw_939%2F95a26d4263b1464eb1d7637083597b26.jpg"))
									.GET()
									.build();
			
			// 3. send
			HttpResponse<byte[]> response =
					client.send(request, HttpResponse.BodyHandlers.ofByteArray());
		
			System.out.println(response.statusCode());
			
			try(FileOutputStream out = new FileOutputStream("dir1/test.jpg");){
				out.write(response.body());
				out.flush();
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
