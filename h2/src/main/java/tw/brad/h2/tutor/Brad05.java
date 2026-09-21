package tw.brad.h2.tutor;

public class Brad05 {
	private static final String hql = """
			SELECT o.customer.cname, o.employee.lastName, o.orderDate,
				p.productName,
				d.unitPrice,
				d.quantity
			FROM Order o
			JOIN o.orderDetials d
			JOIN d.product p
			WHERE o.orderId = :orderId
			""";
	public static void main(String[] args) {
		
	}
}
