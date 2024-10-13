package com.grizer.grizerorder.controller;

import com.grizer.grizerorder.dto.OrderDto;
import com.grizer.grizerorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/")
@CrossOrigin
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping("/getAllOrders")
	public List<OrderDto> getAllOrders() {
		return orderService.getAllOrderList();
	}

	@GetMapping("/getOrderById/{orderId}")
	public OrderDto getOrderDetailsById(@PathVariable int orderId){
		return orderService.getOrderById(orderId);
	}

	@PostMapping("/saveOrder")
	public OrderDto saveOrder(@RequestBody OrderDto orderDto){
		return orderService.saveOrder(orderDto);
	}

	@DeleteMapping("/deleteOrder/{orderId}")
	public String deleteOrder(@PathVariable int orderId){
		return orderService.deleteOrder(orderId);
	}
}
