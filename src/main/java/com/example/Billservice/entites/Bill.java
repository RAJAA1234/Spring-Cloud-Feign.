package com.example.Billservice.entites;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.example.Billservice.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString

public class Bill {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private Date billingDate;
 @OneToMany(mappedBy = "bill")
 private Collection<ProductItem>productItems;
	private Long customerID;
	@Transient
	private Customer CUSTOMER;
	
	
	
}
