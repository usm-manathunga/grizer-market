package com.grizer.graizerproduct.service;


import com.grizer.graizerproduct.dto.ProductDto;

import java.util.List;

public interface ProductService {
	public List<ProductDto> getAllProducts();
	public ProductDto getProduct(int productId);
	public ProductDto saveProduct(ProductDto productDto);
	public ProductDto updateProduct(ProductDto productDto);
	public String deleteProduct(int productId);
}
