package com.example.Billservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.Billservice.entites.Bill;
@RepositoryRestResource
public interface Billrepository extends JpaRepository<Bill, Long> {

}
