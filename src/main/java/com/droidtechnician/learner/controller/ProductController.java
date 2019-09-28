package com.droidtechnician.learner.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.droidtechnician.learner.entities.Product;
import com.droidtechnician.learner.repositories.ProductRepository;

@RestController
@RequestMapping(path="/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
//	@GetMapping
//	public List<Product> getAllProducts() {
//		Iterable<Product> productItr = productRepo.findAll();
//		List<Product> prodList = new ArrayList<Product>();
//		for (Product prod: productItr) {
//			prodList.add(prod);
//		}
//		
//		return prodList;
//	}
	
	@PostMapping
	public ResponseEntity<?> insertProduct(@RequestBody Product product) {
		productRepo.save(product);
		
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(
			path="{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getProductById(@PathVariable("id") Long id ) {
		System.out.println("ID: " + id);
		Optional<Product> productOption = productRepo.findById(id);
		if (productOption.isPresent()) 
			return ResponseEntity.ok().body(productOption.get());
		
		return ResponseEntity.badRequest().build();
		
		
	}
	
	@DeleteMapping(path = "{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
		System.out.println("Count: " + productRepo.count());
		if (productRepo.existsById(id)) {
			productRepo.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> findByDetails(
			@RequestParam(name = "name", required = false) String name) {
		logger.info("Name: " + name);
		if (null != name) {
			logger.info("Here in IF: " + name);
			ArrayList<Product> prodList = productRepo.findByNameIgnoreCase(name);
			prodList.forEach(prod -> logger.info(prod.getName()));
			return prodList;
		}
		
		Iterable<Product> productItr = productRepo.findAll();
		List<Product> prodList = new ArrayList<Product>();
		for (Product prod: productItr) {
			prodList.add(prod);
		}
		
		return prodList;
	}
	

}
