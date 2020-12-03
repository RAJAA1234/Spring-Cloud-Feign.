package com.example.Billservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Billservice.entites.Bill;
import com.example.Billservice.feign.CustomerRestClient;
import com.example.Billservice.feign.ProductItemRestClient;
import com.example.Billservice.repository.Billrepository;
import com.example.Billservice.repository.ProductItemRepository;

@RestController
class BillRestController{

@Autowired private Billrepository billRepository;
@Autowired private ProductItemRepository productItemRepository;
@Autowired private CustomerRestClient customerServiceClient;

@GetMapping("/bills/full/{id}")
Bill getBill(@PathVariable(name="id") Long id){
Bill bill=billRepository.findById(id).get();
bill.setCUSTOMER(customerServiceClient.getCustomerById(bill.getCustomerID()));
bill.setProductItems(productItemRepository.findByBill(id));
bill.getProductItems().forEach(pi->{

});
return bill; }

}