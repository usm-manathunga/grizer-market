package com.grizer.grizerinventory.controller;

import com.grizer.grizerinventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;
}
