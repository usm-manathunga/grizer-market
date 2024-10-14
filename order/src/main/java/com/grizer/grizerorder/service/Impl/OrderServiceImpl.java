package com.grizer.grizerorder.service.Impl;

import com.grizer.graizerproduct.dto.ProductDto;
import com.grizer.grizerinventory.dto.InventoryDto;
import com.grizer.grizerorder.common.ErrorOrderResponse;
import com.grizer.grizerorder.common.OrderResponse;
import com.grizer.grizerorder.common.SuccessOrderResponse;
import com.grizer.grizerorder.dto.OrderDto;
import com.grizer.grizerorder.model.Order;
import com.grizer.grizerorder.repository.OrderRepository;
import com.grizer.grizerorder.service.OrderService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	private final WebClient inventoryWebClient;
	private final WebClient productionWebClient;

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ModelMapper modelMapper;

	public OrderServiceImpl(WebClient inventoryWebClient, WebClient productionWebClient) {
		this.inventoryWebClient = inventoryWebClient;
		this.productionWebClient = productionWebClient;
	}


	@Override
	public List<OrderDto> getAllOrderList() {
		List<Order> orderList = orderRepository.findAll();
		return modelMapper.map(orderList, new TypeToken<List<Order>>() {
		}.getType());
	}

	@Override
	public OrderDto getOrderById(int orderId) {

		Order order = orderRepository.getOrderById(orderId);
		return modelMapper.map(order, OrderDto.class);
	}

	@Override
	public OrderResponse saveOrder(OrderDto orderDto) {
		Integer itemId = orderDto.getItemId();
		try {
			InventoryDto inventoryResponse = inventoryWebClient.get()
					.uri(uriBuilder -> uriBuilder.path("/v1/getInventoryById/{itemId}").build(itemId))
					.retrieve()
					.bodyToMono(InventoryDto.class)
					.block();
			assert inventoryResponse != null;

			Integer productId = inventoryResponse.getProductId();

			ProductDto productionResponse = productionWebClient.get()
					.uri(uriBuilder -> uriBuilder.path("/v1/getProduct/{productId}").build(productId))
					.retrieve()
					.bodyToMono(ProductDto.class)
					.block();
			System.out.println("productResponse = " + productId);
			assert productionResponse != null;

			if (inventoryResponse.getQuantity() > 0) {
				if (productionResponse.getForSale() == 1) {
					orderRepository.save(modelMapper.map(orderDto, Order.class));
					return new SuccessOrderResponse(orderDto);
				} else {
					return new ErrorOrderResponse("This item is not sale");
				}

			} else {
				return new ErrorOrderResponse("item is not available");
			}
		} catch (WebClientResponseException e) {
			if(e.getStatusCode().is5xxServerError()){
				return new ErrorOrderResponse("item not found");

			}
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public OrderDto updateOrder(OrderDto orderDto) {
		orderRepository.save(modelMapper.map(orderDto, Order.class));
		return orderDto;
	}

	@Override
	public String deleteOrder(int orderId) {
		orderRepository.deleteById(orderId);
		return "Order deleted successfully";
	}
}
