package com.grizer.grizerinventory.service.Impl;

import com.grizer.grizerinventory.repository.InventoryRepository;
import com.grizer.grizerinventory.service.InventoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private ModelMapper modelMapper;
}
