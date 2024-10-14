package com.grizer.grizerinventory.controller;

import com.grizer.grizerinventory.dto.InventoryDto;
import com.grizer.grizerinventory.service.InventoryService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/getAllInventory")
	public List<InventoryDto> getAllInventory(){
		return inventoryService.getAllInventory();
	}

	@GetMapping("/getInventoryById/{id}")
	public InventoryDto getInventoryById(@PathVariable int id){
		System.out.println("id:"+id);
		return inventoryService.getInventoryById(id);
	}

	@PostMapping("/addInventory")
	public InventoryDto saveInventory(@RequestBody InventoryDto inventoryDto){
		return inventoryService.saveInventory(inventoryDto);
	}

	@PutMapping("/updateInventory")
	public InventoryDto updateInventory(@RequestBody InventoryDto inventoryDto){
		return inventoryService.updateInventory(inventoryDto);
	}

	@DeleteMapping("/deleteInventory/{id}")
	public String deleteInventory(@PathVariable int id){
		return inventoryService.deleteInventory(id);
	}
}
