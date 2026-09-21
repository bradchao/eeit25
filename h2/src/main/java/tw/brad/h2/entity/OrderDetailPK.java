package tw.brad.h2.entity;

import java.util.Objects;

public class OrderDetailPK {
	private int orderId;
	private int productId;
	
	@Override
	public int hashCode() {
		return Objects.hash(orderId, productId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof OrderDetailPK)) return false;
		OrderDetailPK that = (OrderDetailPK)obj;
		
		return this.orderId == that.orderId && this.productId == that.productId;
	}
	
	
	
	
}
