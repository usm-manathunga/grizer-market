package com.grizer.grizerinventory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto {
	private int id;
	private int itemId;
	private int productId;
	private int quantity;
}
