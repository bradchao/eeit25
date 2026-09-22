package tw.brad.h2.tutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import tools.jackson.databind.ObjectMapper;
import tw.brad.h2.dto.DetailItem;
import tw.brad.h2.dto.OrderItem;
import tw.brad.h2.util.HibernateUtil;

public class Brad05 {
	private static final String hql = """
			SELECT o.customer.cname, o.employee.lastName, o.orderDate,
				p.productName,
				d.unitPrice,
				d.qty
			FROM Order o
				JOIN o.orderDetials d
				JOIN d.product p
			WHERE o.orderId = :orderId
			""";
	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			List<Object[]> result = session.createQuery(hql, Object[].class)
						.setParameter("orderId", 10248)
						.getResultList();
			//-----------------
			//System.out.println(result.size());
			/*
			for (Object[] row: result) {
				//System.out.println(row.length);
				System.out.print(row[0] + ":");
				System.out.print(row[1] + ":");
				System.out.print(row[2] + ":");
				System.out.print(row[3] + ":");
				System.out.print(row[4] + ":");
				System.out.print(row[5] + "\n");
			}
			*/
			//------------------------
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writerWithDefaultPrettyPrinter()
								.writeValueAsString(result);
			System.out.println("---JSON1--");
			System.out.println(json);
			//-----------------------
			System.out.println("---JSON2--");
			String json2 = toObjectJson(result);
			System.out.println(json2);
			//-----------------------
			System.out.println("---OrderItem--");
			toOrderItem(json2);
			
		}
	}
	
	private static String toObjectJson(List<Object[]> result) {
		Map<String,Object> output = new HashMap<>();
		output.put("customer", result.get(0)[0]);
		output.put("employee", result.get(0)[1]);
		output.put("date", result.get(0)[2]);
		
		List<Map<String,Object>> details = new ArrayList<>();
		for (Object[] row: result) {
			Map<String,Object> detail = new HashMap<>();
			detail.put("pname", row[3]);
			detail.put("price", row[4]);
			detail.put("qty", row[5]);
			details.add(detail);
		}
		output.put("details", details);
		//----------------------
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter()
							.writeValueAsString(output);
		return json;
	}
	
	private static void toOrderItem(String json) {
		ObjectMapper mapper = new ObjectMapper();
		OrderItem order = mapper.readValue(json, OrderItem.class);
		System.out.println(order.customer);
		System.out.println(order.employee);
		System.out.println(order.date);
		
		for (DetailItem detail: order.details) {
			System.out.printf("%s:%f:%d\n", detail.pname, detail.price, detail.qty);
		}
		
		
	}
	
}
