package tw.brad.hibernate.tutor;

import java.util.List;

import tw.brad.hibernate.entity.Order;
import tw.brad.hibernate.entity.OrderItem;
import tw.brad.hibernate.service.OrderService;
import tw.brad.hibernate.service.OrderServiceImpl;

public class Brad20 {

	public static void main(String[] args) {
		OrderService service = new OrderServiceImpl();
		
		Order order = service.getOrderWithItems(5L);
		List<OrderItem> items = order.getItems();
		for (OrderItem item : items) {
			System.out.println(item.getPname() + ":" + item.getPrice() + ":" + item.getQty());
		}
		
	}

}
