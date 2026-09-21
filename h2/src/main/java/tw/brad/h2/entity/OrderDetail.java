package tw.brad.h2.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderdetails")
@IdClass(OrderDetailPK.class)
public class OrderDetail {
	@Id
	@Column(name = "OrderID")
	private int orderId;

	@Id
	@Column(name = "ProductID")
	private int productId;
	
	@Column(name = "UnitPrice")
	private BigDecimal unitPrice;
	
	@Column(name = "Quantity")
	private int qty;
	
	@ManyToOne
	@JoinColumn(name = "OrderID")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "ProductID")
	private Product product;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
}
