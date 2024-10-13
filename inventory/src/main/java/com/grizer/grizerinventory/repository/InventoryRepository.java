package com.grizer.grizerinventory.repository;

import com.grizer.grizerinventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
	@Query(value = "select * from inventory where id = ?1", nativeQuery = true)
	Inventory getInventoryById(int id);
}
