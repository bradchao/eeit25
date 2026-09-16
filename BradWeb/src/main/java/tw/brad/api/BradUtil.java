package tw.brad.api;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class BradUtil {
	public static String calc(String x, String y) {
		try {
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			return (intX + intY) + "";
		}catch(Exception e) {
			return "";
		}
	}
	
	public static int createScore() {
		return new Random().nextInt(101);
	}
	
	public static SortedMap[] parseHotels(String json) {
		JSONArray root = new JSONArray(json);
		TreeMap<String, String>[] hotels = new TreeMap[root.length()];
		
		for (int i=0; i<root.length(); i++) {
			JSONObject hotel = root.getJSONObject(i);
			TreeMap<String, String> map = new TreeMap<String, String>();
			map.put("name", hotel.getString("Name"));
			map.put("addr", hotel.getString("Address"));
			map.put("tel", hotel.getString("Tel"));
			hotels[i] = map;
		}
		
		
		return hotels;
	}
	
	public static String loadView(String source) throws Exception{
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(source));
		byte[] buf =bin.readAllBytes();
		bin.close();
		
		return new String(buf);
	}
}
