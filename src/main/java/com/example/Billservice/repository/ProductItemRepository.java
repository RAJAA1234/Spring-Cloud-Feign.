package com.example.Billservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.Billservice.entites.ProductItem;
@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, Long>{
 public Collection<ProductItem>findByBill(Long id); 
}
