package tw.brad.hibernate.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	private LocalDate odate = LocalDate.now();
	
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
	@OneToMany(mappedBy = "order", 
				cascade = CascadeType.ALL,
				orphanRemoval = true)
	private List<OrderItem> items = new ArrayList<>();

	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	public void addItem(OrderItem item) {
		if (item != null) {
			items.add(item);
			item.setOrder(this);
		}
	}
	public void removeItem(OrderItem item) {
		if (item != null && items.contains(item)) {
			items.remove(item);
			item.setOrder(null);
		}
	}
	
	
}
