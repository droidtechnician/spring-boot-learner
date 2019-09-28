package com.droidtechnician.learner.repositories;

import org.springframework.data.repository.CrudRepository;

import com.droidtechnician.learner.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
