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
	
	public static String order2JSON(SortedMap[] rows) {
		JSONObject root = new JSONObject();
		if (rows.length != 0) {
			root.put("employee", rows[0].getOrDefault("LastName", ""));
			root.put("customer", String.format("%s(%s)", 
					rows[0].getOrDefault("CompanyName", ""), 
					rows[0].getOrDefault("ContactName", "")));
			root.put("orderdate", rows[0].getOrDefault("OrderDate", ""));
			
			JSONArray details = new JSONArray();
			for (SortedMap<String,String> row: rows) {
				JSONObject obj = new JSONObject();
				
				obj.put("pname", row.getOrDefault("ProductName", ""));
				obj.put("price", row.getOrDefault("UnitPrice", ""));
				obj.put("qty", row.getOrDefault("Quantity", ""));
				
				
				details.put(obj);
			}
			
			root.put("details", details);
			
		}
		return root.toString();
	}
	
	public static String loadView(String source) throws Exception{
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(source));
		byte[] buf =bin.readAllBytes();
		bin.close();
		
		return new String(buf);
	}
}
