package com.droidtechnician.learner.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.droidtechnician.learner.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	public ArrayList<Product> findByNameIgnoreCase(String name);
}
