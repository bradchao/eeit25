package tw.brad.h2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customer {
	@Id
	@Column(name = "CustomerID")
	private String id;
	
	@Column(name = "CompanyName")
	private String cname;
}
