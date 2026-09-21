package tw.brad.h2.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@Column(name ="OrderID")
	private int orderId;
	
	@Column(name = "OrderDate")
	private String orderDate;
	
	@ManyToOne
	@JoinColumn(name = "CustomerID")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "EmployeeID")
	private Employee employee;
	
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	//-----------------------
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetials = new ArrayList<>();

	public List<OrderDetail> getOrderDetials() {
		return orderDetials;
	}

	public void setOrderDetials(List<OrderDetail> orderDetials) {
		this.orderDetials = orderDetials;
	}
	
	
	
	
}
