package com.grizer.grizerorder.common;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.grizer.grizerorder.dto.OrderDto;
import lombok.Getter;

@Getter
public class SuccessOrderResponse implements OrderResponse{
	@JsonUnwrapped
	private final OrderDto order;

	public SuccessOrderResponse(OrderDto order){
		this.order = order;
	}
}
