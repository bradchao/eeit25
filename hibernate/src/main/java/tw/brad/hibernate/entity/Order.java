package tw.brad.hibernate.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "customer", nullable = false, length = 100)
	private String customer;
	
	@Column(name ="odate", nullable = false)
	private LocalDate odate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public LocalDate getOdate() {
		return odate;
	}
	public void setOdate(LocalDate odate) {
		this.odate = odate;
	}
	//----------------------------
	
	
}
