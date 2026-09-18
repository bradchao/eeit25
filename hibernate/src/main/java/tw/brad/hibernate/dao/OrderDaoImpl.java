package tw.brad.hibernate.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;

import tw.brad.hibernate.entity.Order;

public class OrderDaoImpl implements OrderDao {

	@Override
	public Long save(Session session, Order order) {
		session.persist(order);
		return order.getId();
	}

	@Override
	public Optional<Order> findById(Session session, Long id) {
		Order order = session.find(Order.class, id);
		return Optional.ofNullable(order);
	}

	@Override
	public Optional<Order> findByIdWithItems(Session session, Long id) {
		// Left JOIN
		String hql = """
				SELECT o
				FROM Order o
				LEFT JOIN FETCH o.items
				WHERE o.id = :id
				""";
		Order order = session.createQuery(hql, Order.class)
				.setParameter("id", id)
				.uniqueResult();
		return Optional.of(order);
	}

	@Override
	public void delete(Session session, Order order) {
		session.remove(order);
		
	}

	@Override
	public List<Order> findAll(Session session, int start, int size) {
		String hql = """
				SELECT o
				FROM Order o
				ORDER BY o.id ASC
				""";
		return session.createQuery(hql, Order.class)
				.setFirstResult(start)
				.setMaxResults(size)
				.list();
	}
	
	public List<Order> findByCustomer(Session session, String customer){
		String hql = """
				SELECT o
				FROM Order o
				WHERE o.customer = :cname
				""";
		return session.createQuery(hql, Order.class)
				.setParameter("cname", customer)
				.list();
	}
	
	public List<Order> findByOdate(Session session){
		String hql = """
				SELECT o
				FROM Order o
				ORDER BY o.odate
				""";
		return session.createQuery(hql, Order.class)
				.list();
	}
	
	public List<Order> findByPName(Session session, String pname){
		String hql = """
				SELECT o
				FROM Order o
				JOIN o.items i
				WHERE i.pname = :pname
				ORDER BY o.id
				""";
		return session.createQuery(hql, Order.class)
				.setParameter("pname", pname)
				.list();
	}
	
	

}
