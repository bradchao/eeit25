package tw.brad.h2.tutor;

import java.util.List;
import java.util.Map;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

/*
 * ObjectMapper
 * Object -> JSON : Map + List
 * JSON -> Object
 * write / read
 * 	writeVale -> JSON
 * 	readValue -> Object
 */

public class Brad06 {
	public static void main(String[] args) {
		String json = """
				{
					"date": "1996-07-04 00:00:00",
					"details": [
						{
							"pname": "Queso Cabrales",
							"price": 14.0000,
							"qty": 12
						},
						{
							"pname": "Singaporean Hokkien Fried Mee",
							"price": 9.8000,
							"qty": 10
						},
						{
							"pname": "Mozzarella di Giovanni",
							"price": 34.8000,
							"qty": 5
						}
					],
					"employee": "Buchanan",
					"customer": "Vins et alcools Chevalier"
				}				
				""";
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> result = mapper.readValue(json, 
				new TypeReference<Map<String,Object>>() {});
		System.out.println(result.get("date"));
		System.out.println(result.get("employee"));
		System.out.println(result.get("customer"));
		
		List<Map<String,Object>> details = (List<Map<String,Object>>)result.get("details");
		for (Map<String,Object> detail: details) {
			System.out.println(detail.get("pname"));
		}
	}
}
