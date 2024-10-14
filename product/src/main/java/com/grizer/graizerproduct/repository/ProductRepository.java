package com.grizer.graizerproduct.repository;

import com.grizer.graizerproduct.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	@Query(value = "select * from product where product_id = ?1",nativeQuery = true)
	Product getProductById(Integer id);
}
