package com.matritellabs.webshop.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matritellabs.webshop.entity.Product;
import com.matritellabs.webshop.service.ProductMySQLRepositoryService;
import com.matritellabs.webshop.service.ProductRepository;

/*
 * ------------------------------------
 * Class for managing Product resources
 * ------------------------------------
 */

@RestController
public class ProductResource {

	@Autowired 
	ProductRepository repo;
	
	@Autowired
	ProductMySQLRepositoryService mySqlRepo;
	
	//GET /shop/products <-- lists all products
	@GetMapping("/shop/products")
	public List<Product> retriveAllProducts() {
		//return repo.findAll();
		return mySqlRepo.findAll();
	}
	
    //GET /shop/product/{id} <-- returns an existing product by id
	@GetMapping("shop/product/{id}")
	public Product retriveProduct(@PathVariable Long id) {
		//return repo.findById(id).get();
		
		return mySqlRepo.findById(id);
	}
	//POST /shop/product/create <-- creates a new product
	@PostMapping("shop/product/create")
	public ResponseEntity<Void> createProduct(@RequestBody Product product){
		
		//repo.save(product);
		mySqlRepo.save(product);
	
		URI uri = ServletUriComponentsBuilder
				.fromPath("shop/product")
				.path("/{id}")
				.buildAndExpand(product.getId())
				.toUri();
	
		return ResponseEntity.created(uri).build();
		
	}
	 //PUT /shop/product/{id} <-- updates an existing product by id
	@PutMapping("/shop/product/{id}")
	public ResponseEntity<Product> updateTodo(@PathVariable Long id, @RequestBody Product product){
		
		//repo.save(product);
		mySqlRepo.save(product);
		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	//DELETE /shop/product/{id} <-- deletes an existing product by id
	@DeleteMapping("shop/product/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
		//repo.deleteById(id);
		mySqlRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
