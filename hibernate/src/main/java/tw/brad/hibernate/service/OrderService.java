package tw.brad.hibernate.service;

import java.util.List;

import tw.brad.hibernate.entity.Order;
import tw.brad.hibernate.entity.OrderItem;

public interface OrderService {
	Long createOrder(String customer);
	Long createOrderWithItems(String customer, List<OrderItem> items);
	void changeCustomer(Long orderId, String newname);
	void addItem(Long orderId, String pname, int price, int qty);
	void updateItemQty(Long orderId, Long itemId, int newqty);
	void removeItem(Long orderId, Long itemId);
	Order getOrderWithItems(Long orderId);
	void delOrder(Long orderId);
}
