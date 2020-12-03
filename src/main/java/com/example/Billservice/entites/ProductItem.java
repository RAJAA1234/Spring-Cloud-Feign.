package com.example.Billservice.entites;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.example.Billservice.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class ProductItem {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double quantity;
	private double price;
	private Long productID;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@ManyToOne
	private Bill bill;
	@Transient
	private Product product;
	@Transient
	private String Productname;

}
