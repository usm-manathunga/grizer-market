package com.grizer.grizerorder.service.Impl;

import com.grizer.grizerorder.dto.OrderDto;
import com.grizer.grizerorder.model.Order;
import com.grizer.grizerorder.repository.OrderRepository;
import com.grizer.grizerorder.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<OrderDto> getAllOrderList() {
		List<Order> orderList = orderRepository.findAll();
		return modelMapper.map(orderList, new TypeToken<List<Order>>(){}.getType());
	}

	@Override
	public OrderDto getOrderById(int orderId) {
		Order order = orderRepository.getOrderById(orderId);
		return modelMapper.map(order,OrderDto.class);
	}

	@Override
	public OrderDto saveOrder(OrderDto orderDto) {
		orderRepository.save(modelMapper.map(orderDto,Order.class));
		return orderDto;
	}

	@Override
	public OrderDto updateOrder(OrderDto orderDto) {
		orderRepository.save(modelMapper.map(orderDto,Order.class));
		return orderDto;
	}

	@Override
	public String deleteOrder(int orderId) {
		orderRepository.deleteById(orderId);
		return "Order deleted successfully";
	}
}
