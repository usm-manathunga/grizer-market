package com.grizer.grizerinventory.service;

import com.grizer.grizerinventory.dto.InventoryDto;

import java.util.List;

public interface InventoryService {
	public List<InventoryDto> getAllInventory();
	public InventoryDto getInventoryById(int id);
	public InventoryDto saveInventory(InventoryDto inventory);
	public InventoryDto updateInventory(InventoryDto inventory);
	public String deleteInventory(int id);
}
