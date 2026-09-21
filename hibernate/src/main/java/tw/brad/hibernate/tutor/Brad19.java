package tw.brad.hibernate.tutor;

import tw.brad.hibernate.service.OrderService;
import tw.brad.hibernate.service.OrderServiceImpl;

public class Brad19 {

	public static void main(String[] args) {
		OrderService service = new OrderServiceImpl();
		
		service.addItem(55L, "Item1", 10, 2);
		//service.addItem(55L, "Item2", 12, 12);
		//service.addItem(55L, "Item3", 15, 7);
		
	}

}
