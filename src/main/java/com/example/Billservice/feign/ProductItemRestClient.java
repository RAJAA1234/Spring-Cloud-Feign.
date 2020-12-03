package com.example.Billservice.feign;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Billservice.model.Product;

@FeignClient(name="PRODUCT-SERVICE")
public interface ProductItemRestClient {
	@GetMapping(path = "/products")
	PagedModel<Product>pageProducts( @RequestParam(name = "page" )int page, @RequestParam(name = "size" ) int size);
     @GetMapping(path ="/products{id}" )
	  Product getProductById(@PathVariable Long id);
}
