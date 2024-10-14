package com.grizer.grizerinventory.service.Impl;

import com.grizer.grizerinventory.dto.InventoryDto;
import com.grizer.grizerinventory.model.Inventory;
import com.grizer.grizerinventory.repository.InventoryRepository;
import com.grizer.grizerinventory.service.InventoryService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private ModelMapper modelMapper;


	@Override
	public List<InventoryDto> getAllInventory() {
		List<Inventory> inventoryList = inventoryRepository.findAll();
		return modelMapper.map(inventoryList,new TypeToken<List<Inventory>>(){}.getType());

	}

	@Override
	public InventoryDto getInventoryById(int id) {
		Inventory inventory = inventoryRepository.getInventoryById(id);
		return modelMapper.map(inventory,InventoryDto.class);
	}

	@Override
	public InventoryDto saveInventory(InventoryDto inventory) {
		inventoryRepository.save(modelMapper.map(inventory,Inventory.class));
		return inventory;
	}

	@Override
	public InventoryDto updateInventory(InventoryDto inventory) {
		inventoryRepository.save(modelMapper.map(inventory,Inventory.class));
		return inventory;
	}

	@Override
	public String deleteInventory(int id) {
		inventoryRepository.deleteById(id);
		return "Successfully deleted";
	}
}
