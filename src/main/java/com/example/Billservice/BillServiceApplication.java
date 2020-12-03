package com.example.Billservice;

import java.util.Date;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import com.example.Billservice.entites.Bill;
import com.example.Billservice.entites.ProductItem;
import com.example.Billservice.feign.CustomerRestClient;
import com.example.Billservice.feign.ProductItemRestClient;
import com.example.Billservice.model.Customer;
import com.example.Billservice.model.Product;
import com.example.Billservice.repository.Billrepository;
import com.example.Billservice.repository.ProductItemRepository;
 
@SpringBootApplication
@EnableFeignClients
public class BillServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(Billrepository billrepository,
			ProductItemRepository productItemRepository,CustomerRestClient customerRestClient,
			ProductItemRestClient productItemRestClient) {
		
		
		return args->{
		 Customer customer=customerRestClient.getCustomerById(1L);
		Bill bill= billrepository.save(new Bill(null,new Date(),null,customer.getId(),null));
		PagedModel<Product>productPagedModel=productItemRestClient.pageProducts(1, 2);
		productPagedModel.forEach(p->{
			
			ProductItem productItem=new ProductItem();
			productItem.setPrice(p.getPrice());
			productItem.setQuantity(1+new Random().nextInt(100));
			productItem.setBill(bill);
			productItem.setId(p.getId());
			productItemRepository.save(productItem);
		});
		 System.out.println(customer.getId());
		 System.out.println(customer.getName());
		 System.out.println(customer.getEmail());
	};
	}
	}


