package tw.brad.hibernate.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.hibernate.dao.OrderDao;
import tw.brad.hibernate.dao.OrderDaoImpl;
import tw.brad.hibernate.entity.Order;
import tw.brad.hibernate.entity.OrderItem;
import tw.brad.hibernate.util.HibernateUtil;

public class OrderServiceImpl implements OrderService{
	private OrderDaoImpl dao = new OrderDaoImpl();

	@Override
	public Long createOrder(String customer) {
		Transaction transaction = null;
		Session session = null;
		Long id = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			List<Order> list = dao.findByCustomer(session, customer);
			if (list.size() == 0) {
				transaction = session.beginTransaction();
				Order order = new Order();
				order.setCustomer(customer);
				id = dao.save(session, order);
				transaction.commit();
			}
			
			return id;
		}catch(Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				try {
					transaction.rollback();
					System.out.println("rollback");
				}catch(Exception ee) {
					e.printStackTrace();
				}
			}
		}finally {
			if (session != null) {
				session.close();
			}
		}
		
		return null;
	}

	@Override
	public Long createOrderWithItems(String customer, List<OrderItem> items) {
		Transaction transaction = null;
		Long id = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			
			List<Order> list = dao.findByCustomer(session, customer);
			if (list.size() == 0) {
				transaction = session.beginTransaction();
				Order order = new Order();
				order.setCustomer(customer);
				
				for (OrderItem item: items) {
					order.addItem(item);
				}
				id = dao.save(session, order);
				
				transaction.commit();
			}
			return id;
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
		return null;
	}

	@Override
	public void changeCustomer(Long orderId, String newname) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Order order = dao.findById(session, orderId)
					.orElseThrow(()->new IllegalArgumentException("Order NOT FOUND"));
			
			order.setCustomer(newname);
			
			transaction.commit();
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
	}

	@Override
	public void addItem(Long orderId, String pname, int price, int qty) {
		Transaction transaction = null;
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			Order order = dao.findById(session, orderId)
					.orElseThrow(()->new IllegalArgumentException("Order NOT FOUND"));
			order.addItem(new OrderItem(pname, price, qty));
			
			transaction.commit();
		}catch(Exception e) {
			//e.printStackTrace();
			if (e instanceof IllegalArgumentException) throw new IllegalArgumentException("Order NOT FOUND");
			if (transaction != null) {
				try {
					transaction.rollback();
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		}finally {
			if (session != null) session.close();
		}	
	}

	@Override
	public void updateItemQty(Long orderId, Long itemId, int newqty) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Order order = dao.findById(session, orderId)
					.orElseThrow(()->new IllegalArgumentException("Order NOT FOUND"));
			
			/*
			boolean isFound = false;
			List<OrderItem> items = order.getItems();
			for (OrderItem item: items) {
				if (item.getId().equals(itemId)) {
					isFound = true;
					item.setQty(newqty);
					break;
				}
			}
			if (!isFound) throw new IllegalArgumentException("OrderItem NOT FOUND");
			*/
			
			OrderItem updateItem = order.getItems()
				.stream()
				.filter(item -> item.getId().equals(itemId))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("OrderItem NOT FOUND"));
			/*
			 * .stream() 之後
			 * 期間操作
			 * filter()
			 * map()
			 * sorted()
			 * limit()
			 * 
			 * 收尾操作
			 * findFirst()
			 * toList()
			 * sum()
			 * count()
			 * forEach()
			 * 
			 */
			
			
			updateItem.setQty(newqty);
			
			
			transaction.commit();
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}				
	}

	@Override
	public void removeItem(Long orderId, Long itemId) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Order order = dao.findById(session, orderId)
					.orElseThrow(()->new IllegalArgumentException("Order NOT FOUND"));
			
			OrderItem removeItem = order.getItems()
				.stream()
				.filter(item -> item.getId().equals(itemId))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("OrderItem NOT FOUND"));
			
			order.removeItem(removeItem);
			
			transaction.commit();
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}			
	}

	@Override
	public Order getOrderWithItems(Long orderId) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			return dao.findByIdWithItems(session, orderId)
					.orElseThrow(()->new IllegalArgumentException("Order NOT FOUND"));
		}				
	}

	@Override
	public void delOrder(Long orderId) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Order order = dao.findById(session, orderId)
					.orElseThrow(()->new IllegalArgumentException("Order NOT FOUND"));
			
			dao.delete(session, order);
			
			transaction.commit();
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}			
	}
	

}
