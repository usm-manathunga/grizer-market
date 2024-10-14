package com.grizer.base.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEventDto {
	private String status;
	private String message;
}
