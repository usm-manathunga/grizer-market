package com.grizer.graizerproduct.service.Impl;

import com.grizer.graizerproduct.dto.ProductDto;
import com.grizer.graizerproduct.model.Product;
import com.grizer.graizerproduct.repository.ProductRepository;
import com.grizer.graizerproduct.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> productList = productRepository.findAll();
		return modelMapper.map(productList, new TypeToken<List<Product>>() {
		}.getType());

	}

	@Override
	public ProductDto getProduct(int productId) {
		Product product = productRepository.getProductById(productId);
		return modelMapper.map(product, ProductDto.class);
	}

	@Override
	public ProductDto saveProduct(ProductDto productDto) {
		productRepository.save(modelMapper.map(productDto, Product.class));
		return productDto;
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto) {
		productRepository.save(modelMapper.map(productDto, Product.class));
		return productDto;
	}

	@Override
	public String deleteProduct(int productId) {
		productRepository.deleteById(productId);
		return "Deleted successfully";
	}
}
