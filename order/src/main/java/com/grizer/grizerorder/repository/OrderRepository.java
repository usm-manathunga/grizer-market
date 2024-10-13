package com.grizer.grizerorder.repository;

import com.grizer.grizerorder.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
	@Query(value = "SELECT * from order where id = ?1", nativeQuery = true)
	Order getOrderById(Integer userId);
}
