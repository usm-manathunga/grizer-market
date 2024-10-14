package com.grizer.graizerproduct.controller;

import com.grizer.graizerproduct.dto.ProductDto;
import com.grizer.graizerproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping("/getAllProducts")
	public List<ProductDto> getAllProducts(){
		return productService.getAllProducts();
	}

	@GetMapping("/getProduct/{productId}")
	public ProductDto getProduct(@PathVariable int productId){
		return productService.getProduct(productId);
	}

	@PostMapping("/addProduct")
	public ProductDto saveProduct(@RequestBody ProductDto productDto){
		return productService.saveProduct(productDto);
	}

	@PutMapping("/updateProduct")
	public ProductDto updateProduct(@RequestBody ProductDto productDto){
		return productService.updateProduct(productDto);
	}

	@DeleteMapping("/deleteProduct")
	public String deleteProduct(@PathVariable int productId){
		return productService.deleteProduct(productId);
	}

}
