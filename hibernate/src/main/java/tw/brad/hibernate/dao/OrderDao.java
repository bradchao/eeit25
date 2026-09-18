package tw.brad.hibernate.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;

import tw.brad.hibernate.entity.Order;

public interface OrderDao {
	Long save(Session session, Order order);
	Optional<Order> findById(Session session, Long id);
	Optional<Order> findByIdWithItems(Session session, Long id);
	void delete(Session session, Order order);
	List<Order> findAll(Session session, int start, int size);
}
