package com.grizer.grizerorder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
	private int id;
	private int ItemId;
	private Date OrderDate;
	private String amount;
}
