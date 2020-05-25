package com.matritellabs.webshop.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matritellabs.webshop.entity.Product;


/* 
 * -----------------------------------------------------------------------
 * Service class for managing basic CRUD operations for Product with MySQL
 * -----------------------------------------------------------------------
 */


@Repository
@Transactional
public class ProductMySQLRepositoryService {

	@Autowired 
	EntityManager em;
	
	public List<Product> findAll() {
		Query createQuery = em.createNativeQuery("SELECT * FROM product", Product.class);
		List<Product> resultList = createQuery.getResultList();
		return resultList;	
	}	
	
	public Product findById(Long id) {
		
		Query createQuery = em.createNativeQuery("SELECT * FROM product WHERE id=:id", Product.class).setParameter("id", id);
		List<Product> resultList = createQuery.getResultList();

		return resultList.size() == 0 ? null : resultList.get(0);

	}
	

	public void deleteById(Long id) {
		em.createNativeQuery("DELETE FROM product WHERE id=:id", Product.class).setParameter("id", id).executeUpdate();
		em.flush();
	}
	
	public void save(Product product) {
		
		if(product.getId() == null) 
			//em.createNativeQuery("INSERT INTO product (name, description, price)VALUES(:name,:description,:price);", Product.class)
			//.setParameter("name", product.getName())
			//.setParameter("description", product.getDescription())
			//.setParameter("price", product.getPrice()).executeUpdate();
	
			em.persist(product);
		
		else 

			em.merge(product);
			
		//em.createNativeQuery("UPDATE product SET name=:name, description=:description, price=:price WHERE id=:id", Product.class)
				//.setParameter("name", product.getName())
				//.setParameter("description", product.getDescription())
				//.setParameter("price", product.getPrice())
				//.setParameter("id", product.getId())
				//.executeUpdate();
		
		em.flush();
	}
}
