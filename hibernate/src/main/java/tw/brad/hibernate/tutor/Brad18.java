package tw.brad.hibernate.tutor;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.hibernate.entity.Order;
import tw.brad.hibernate.entity.OrderItem;
import tw.brad.hibernate.service.OrderService;
import tw.brad.hibernate.service.OrderServiceImpl;
import tw.brad.hibernate.util.HibernateUtil;

public class Brad18 {

	public static void main(String[] args) {
		OrderService service = new OrderServiceImpl();
		
		Long id = service.createOrder("ANDY");
		System.out.println(id);
		
//		Long id = service.createOrderWithItems("III7", List.of(new OrderItem("Mouse", 10, 20),
//				new OrderItem("NB", 20000, 30),
//				new OrderItem("Mac",30000,44)));
//		System.out.println(id);
		
		service.addItem(id, "BTC", 81000, 1);
		service.addItem(id, "ETH", 26000, 2);
		
		
	}

}
