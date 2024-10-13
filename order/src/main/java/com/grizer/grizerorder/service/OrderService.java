package com.grizer.grizerorder.service;

import com.grizer.grizerorder.dto.OrderDto;

import java.util.List;

public interface OrderService {
	public List<OrderDto> getAllOrderList();
	public OrderDto getOrderById(int orderId);
	public OrderDto saveOrder(OrderDto orderDto);
	public OrderDto updateOrder(OrderDto orderDto);
	public String deleteOrder(int OrderId);
}
